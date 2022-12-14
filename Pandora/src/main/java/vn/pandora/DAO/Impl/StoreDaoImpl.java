package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vn.pandora.DAO.iStoreDao;
import vn.pandora.Model.Store;
import vn.pandora.Connection.*;
public class StoreDaoImpl extends ConnectJDBC implements iStoreDao {

	@Override
	public void Add(Store store) {
		String sql= "insert into Store(name,bio,ownerId, avatar,cover,featured_image ) values(?,?,?,?,?,?)";
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
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
}

	@Override
	public void Update(Store store) {
		String sql="Update Store set name=? ,bio=?,ownerId=?,[isActive ]=? ,[isOpen ]=?, avatar=?,cover=?,featured_image=?,rating=?,e_wallet=? where _id=?;";
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
			ps.setInt(11,store.getId());
			ps.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Store GetOne(int id) {
		String sql = "select * from Store where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store(
						id,
						rs.getString("name"),
						rs.getString("bio"),
						rs.getInt("ownerId"),
						rs.getBoolean("isActive"),
						rs.getBoolean("isOpen"),
						rs.getString("avatar"),
						rs.getString("cover"),
						rs.getString("featured_image"),
						rs.getInt("rating"),
						rs.getDouble("e_wallet"),
						rs.getDate("createdAt"),
						rs.getDate("updatedAt")
				);
				return store;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
}

	@Override
	public void UpdateWallet(int id, double mount) {
		String sql="UPDATE Store SET e_wallet =? WHERE  _id=?";
		
		try {
			Connection con= super.getConnection();
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setDouble(1, mount);
			ps.setInt(2, id);
			ps.execute();
		} catch (Exception e) {
		e.getStackTrace();
		}
		
		
	}


}
