package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iProductDao;
import vn.pandora.Model.Product;
import vn.pandora.Util.UtilClass;

public class ProductDaoImpl extends ConnectJDBC implements iProductDao {

	@Override
	public void Add(Product product) {
		String sql = "INSERT INTO [Product](name,description,price, promotionalPrice,quantity,listImages,categoryId,styleValueIds,storeId) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getPromotionalPrice());
			ps.setInt(5, product.getQuantity());
			ps.setString(6, UtilClass.toStr_StrList(product.getListImages()));
			ps.setInt(7, product.getCategoryId());
			ps.setString(8, UtilClass.toStr_IntList(product.getStyleValueIds()));
			ps.setInt(9, product.getStoreId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(Product product) {
		String sql = "UPDATE Product set name=? , description=? , price=?, promotionalPrice=? , quantity=? , sold =? , isActive=? , isSelling=?  , listImages=? , categoryId=? , styleValueIds=?,storeId=?, rating=? where id=? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getPromotionalPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getSold());
			ps.setBoolean(7, product.isActive());
			ps.setBoolean(8, product.isSelling());
			ps.setString(9, UtilClass.toStr_StrList(product.getListImages()));
			ps.setInt(10, product.getCategoryId());
			ps.setString(11, UtilClass.toStr_IntList(product.getStyleValueIds()));
			ps.setInt(12, product.getStoreId());
			ps.setInt(13, product.getRating());
			ps.setInt(14, product.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void UpdateSelling(int id, Boolean isSellinString) {
		String sql = "UPDATE Product SET isSelling=? WHERE _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, isSellinString);
			ps.setInt(2, id);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Product GetOne(int id) {
		String sql = "select * from Product where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(id, rs.getString("name"), rs.getString("description"), rs.getInt("price"),
						rs.getInt("promotionalPrice"), rs.getInt("quantity"), rs.getInt("sold"),
						rs.getBoolean("isActive"), rs.getBoolean("isSelling"),
						UtilClass.toList_Str(rs.getString("listImages")), rs.getInt("categoryId"),
						UtilClass.toList_Int(rs.getString("styleValueIds")), rs.getInt("storeId"), rs.getInt("rating"),
						rs.getDate("createdAt"), rs.getDate("updatedAt"));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> GetAll(int index, int pagesize) {
		String sql = "select * from Product ORDER BY _id asc  OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			List<Product> list = new ArrayList<Product>();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("_id"), rs.getString("name"), rs.getString("description"),
						rs.getInt("price"), rs.getInt("promotionalPrice"), rs.getInt("quantity"), rs.getInt("sold"),
						rs.getBoolean("isActive"), rs.getBoolean("isSelling"),
						UtilClass.toList_Str(rs.getString("listImages")), rs.getInt("categoryId"),
						UtilClass.toList_Int(rs.getString("styleValueIds")), rs.getInt("storeId"), rs.getInt("rating"),
						rs.getDate("createdAt"), rs.getDate("updatedAt"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findTop_Promo(int index, int pagesize) {
		String sql = "select * from Product ORDER BY (price-promotionalPrice) desc  OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			List<Product> list = new ArrayList<Product>();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("_id"), rs.getString("name"), rs.getString("description"),
						rs.getInt("price"), rs.getInt("promotionalPrice"), rs.getInt("quantity"), rs.getInt("sold"),
						rs.getBoolean("isActive"), rs.getBoolean("isSelling"),
						UtilClass.toList_Str(rs.getString("listImages")), rs.getInt("categoryId"),
						UtilClass.toList_Int(rs.getString("styleValueIds")), rs.getInt("storeId"), rs.getInt("rating"),
						rs.getDate("createdAt"), rs.getDate("updatedAt"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findTop_Created(int index, int pagesize) {
		String sql = "select * from Product ORDER BY createdAt desc  OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			List<Product> list = new ArrayList<Product>();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("_id"), rs.getString("name"), rs.getString("description"),
						rs.getInt("price"), rs.getInt("promotionalPrice"), rs.getInt("quantity"), rs.getInt("sold"),
						rs.getBoolean("isActive"), rs.getBoolean("isSelling"),
						UtilClass.toList_Str(rs.getString("listImages")), rs.getInt("categoryId"),
						UtilClass.toList_Int(rs.getString("styleValueIds")), rs.getInt("storeId"), rs.getInt("rating"),
						rs.getDate("createdAt"), rs.getDate("updatedAt"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Hàm cấp phép cho sản phẩm trong hệ thống
	// Note: Nếu sản phẩm đang được cấp phép rồi thì không cấp phép nữa
	@Override
	public void permit(Product product) {
		String sql = "Update Product set [isActive] = 1 where _id = ? and [isActive] = 0";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Hàm cấm sản phẩm trong hệ thống
	// Note: Nếu sản phẩm đang bị cấm thì không cấm nữa
	@Override
	public void revoke(Product product) {
		String sql = "Update Product set [isActive] = 0 where _id = ? and [isActive] = 1";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
