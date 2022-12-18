package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iCategoryDao;
import vn.pandora.Model.Category;

public class CategoryDaoImpl extends ConnectJDBC implements iCategoryDao {

	@Override
	public Category findById(int id) {
		String sql = "select * from Category where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				cate.setId(id);
				cate.setName(rs.getString("name"));
				cate.setCategoryId(rs.getInt("categoryId"));
				cate.setImage(rs.getString("image"));
				cate.setDeleted(rs.getBoolean("isDeleted"));
				cate.setCreatedAt(rs.getDate("createdAt"));
				cate.setUpdatedAt(rs.getDate("updatedAt"));
				return cate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category getOne(int id) {
		String sql = "select * from Category where _id =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category(id, rs.getString("name"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() {

		String sql = "select * from Category";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			List<Category> list = new ArrayList<Category>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category(rs.getInt("_id"), rs.getString("name"));
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Hàm xem danh sách tất cả các Category trong hệ thống có phân trang
	@Override
	public List<Category> getAll(int index, int pagesize) {
		List<Category> categories = new ArrayList<Category>();
		String sql = "Select * From Category ORDER BY name asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("_id"));
				category.setName(rs.getString("name"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setImage(rs.getString("image"));
				category.setDeleted(rs.getBoolean("isDeleted"));
				category.setCreatedAt(rs.getDate("createdAt"));
				category.setUpdatedAt(rs.getDate("updatedAt"));

				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public void insert(Category category) {
		String sql = "Insert into Category(name, categoryId, image, isDeleted) Values (?,?,?,0)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setInt(2, category.getCategoryId());
			ps.setString(3, category.getImage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category category) {
		String sql = "Update Category set name = ?, categoryId = ?, image = ?, isDeleted = ? where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setInt(2, category.getCategoryId());
			ps.setString(3, category.getImage());
			ps.setBoolean(4, category.isDeleted());
			ps.setInt(5, category.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Xóa mềm cho loại sản phẩm
	@Override
	public void delete(int id) {
		String sql = "Update Category set isDeleted = 1 where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
