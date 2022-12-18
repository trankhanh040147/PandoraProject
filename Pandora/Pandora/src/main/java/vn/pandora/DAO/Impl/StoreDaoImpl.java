package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.DAO.iStoreDao;
import vn.pandora.Model.Store;
import vn.pandora.Connection.*;

public class StoreDaoImpl extends ConnectJDBC implements iStoreDao {

	@Override
	public void Add(Store store) {
		String sql = "insert into Store(name,bio,ownerId, avatar,cover,featured_image ) values(?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, store.getName());
			ps.setString(2, store.getBio());
			ps.setInt(3, store.getOwnerId());
			ps.setString(4, store.getAvatar());
			ps.setString(5, store.getCover());
			ps.setString(6, store.getFeatured_image());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(String name, String bio, boolean isOpen, String avatar, String cover, String featured_image,
			int id) {
		String sql = "Update Store set name=? ,bio=? ,[isOpen ]=?, avatar=?,cover=?,featured_image=? where _id=?;";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, bio);
			ps.setBoolean(3, isOpen);
			ps.setString(4, avatar);
			ps.setString(5, cover);
			ps.setString(6, featured_image);
			ps.setInt(7, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void Update(Store store) {
		String sql = "Update Store set name=? ,bio=?,ownerId=?,[isActive]=? ,[isOpen]=?, avatar=?,cover=?,featured_image=?,rating=?,e_wallet=? where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, store.getName());
			ps.setString(2, store.getBio());
			ps.setInt(3, store.getOwnerId());
			ps.setBoolean(4, store.isActive());
			ps.setBoolean(5, store.isOpen());
			ps.setString(6, store.getAvatar());
			ps.setString(7, store.getCover());
			ps.setString(8, store.getFeatured_image());
			ps.setInt(9, store.getRating());
			ps.setDouble(10, store.getE_wallet());
			ps.setInt(11, store.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Store GetOne(int id) {
		String sql = "select * from Store where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store(id, rs.getString("name"), rs.getString("bio"), rs.getInt("ownerId"),
						rs.getBoolean("isActive"), rs.getBoolean("isOpen"), rs.getString("avatar"),
						rs.getString("cover"), rs.getString("featured_image"), rs.getInt("rating"),
						rs.getDouble("e_wallet"), rs.getDate("createdAt"), rs.getDate("updatedAt"));
				return store;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void UpdateWallet(int id, double mount) {
		String sql = "UPDATE Store SET e_wallet =? WHERE  _id=?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, mount);
			ps.setInt(2, id);
			ps.execute();
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Override
	public List<Integer> GetIdSrore(int id) {
		String sql = "select _id from Store where ownerId=?";
		try {
			List<Integer> list = new ArrayList<Integer>();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("_id"));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Store> GetStoreByownerId(int id) {
		String sql = "select * from Store where ownerID=? and isActive='true'";
		try {
			List<Store> list = new ArrayList<Store>();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store(rs.getInt("_id"), rs.getString("name"), rs.getString("bio"),
						rs.getInt("ownerId"), rs.getBoolean("isActive"), rs.getBoolean("isOpen"),
						rs.getString("avatar"), rs.getString("cover"), rs.getString("featured_image"),
						rs.getInt("rating"), rs.getDouble("e_wallet"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(store);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Hàm xem danh sách tất cả Store trong hệ thống có phân trang
	@Override
	public List<Store> getAll(int index, int pagesize) {
		List<Store> stores = new ArrayList<Store>();
		String sql = "Select * from Store ORDER BY name asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();

				store.setId(rs.getInt("_id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setCover(rs.getString("cover"));
				store.setFeatured_image(rs.getString("featured_image"));
				store.setRating(rs.getInt("rating"));
				store.setE_wallet(rs.getDouble("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));

				stores.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stores;
	}

	// Hàm cấp phép hoạt động cho cửa hàng trong hệ thống
	// Note: Nếu cửa hàng đang được cấp phép rồi thì không cấp phép nữa
	@Override
	public void permit(Store store) {
		String sql = "Update Store set [isActive] = 1 where _id = ? and [isActive] = 0";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, store.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Hàm cấm hoạt động cho cửa hàng trong hệ thống
	// Note: Nếu cửa hàng đang bị cấm thì không cấm nữa
	@Override
	public void revoke(Store store) {
		String sql = "Update Store set [isActive] = 0 where _id = ? and [isActive] = 1";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, store.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}