package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iCategoryDao;
import vn.pandora.Model.Category;

public class CategoryDaoImpl extends ConnectJDBC implements iCategoryDao{

	@Override
	public Category getOne(int id) {
		String sql="select * from Category where _id =?";
		try {
			Connection con= super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(
						id,
						rs.getString("name")
	);		
				return category;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		
		String sql="select * from Category";
		try {
			Connection con= super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			List<Category> list= new ArrayList<Category>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(
						rs.getInt("_id"),
						rs.getString("name")
	);		
				list.add(category);
				}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
