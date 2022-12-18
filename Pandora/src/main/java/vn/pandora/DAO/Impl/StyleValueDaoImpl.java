package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.Model.Product;
import vn.pandora.Model.StyleValue;
import vn.pandora.Util.UtilClass;

public class StyleValueDaoImpl extends ConnectJDBC implements iStyleValueDao{

	@Override
	public StyleValue getOne(int id) {
		String sql = "select * from StyleValue where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StyleValue sv = new StyleValue();
				sv.setId(rs.getInt("_id"));
				sv.setName(rs.getString("name"));
				sv.setStyleId(rs.getInt("styleId"));
				sv.setDeleted(rs.getBoolean("isDeleted"));
				sv.setCreatedAt(rs.getDate("createdAt"));
				sv.setUpdatedAt(rs.getDate("updatedAt"));
				
				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StyleValue> getAllById(int id) {
		String sql="select * from StyleValue  where styleId=?";
		try {
			Connection con =super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			List<StyleValue>list= new ArrayList<StyleValue>();
			ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			StyleValue sv = new StyleValue();
			sv.setId(rs.getInt("_id"));
			sv.setName(rs.getString("name"));
			sv.setStyleId(rs.getInt("styleId"));
			sv.setDeleted(rs.getBoolean("isDeleted"));
			sv.setCreatedAt(rs.getDate("createdAt"));
			sv.setUpdatedAt(rs.getDate("updatedAt"));
			
			list.add(sv);
		}
		return list;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
}
