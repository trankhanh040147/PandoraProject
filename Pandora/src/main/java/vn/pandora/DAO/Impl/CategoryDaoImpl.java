package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
}
