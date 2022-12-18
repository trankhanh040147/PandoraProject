package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.Model.StyleValue;

public class StyleValueDaoImpl extends ConnectJDBC implements iStyleValueDao {

	@Override
	public StyleValue getOne(int id) {
		String sql="select * from StyleValue where _id=? ";
		try {
			Connection con =super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			StyleValue styleValue = new StyleValue(
					id,
					rs.getString("name")
					);
			return styleValue;
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
			StyleValue styleValue = new StyleValue(
					rs.getInt("_id"),
					rs.getString("name")
					);
			list.add(styleValue);
		}
		return list;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

}
