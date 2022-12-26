package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iStyleDao;
import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.Model.Product;
import vn.pandora.Model.Style;
import vn.pandora.Model.StyleValue;
import vn.pandora.Util.UtilClass;

public class StyleValueDaoImpl extends ConnectJDBC implements iStyleValueDao {

	iStyleDao styleDao = new StyleDaoImpl();
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
				sv.setStyle(styleDao.getOne(sv.getStyleId()));

				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StyleValue> getAllById(int id) {
		String sql = "select * from StyleValue  where styleId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			List<StyleValue> list = new ArrayList<StyleValue>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StyleValue sv = new StyleValue();
				sv.setId(rs.getInt("_id"));
				sv.setName(rs.getString("name"));
				sv.setStyleId(rs.getInt("styleId"));
				sv.setDeleted(rs.getBoolean("isDeleted"));
				sv.setCreatedAt(rs.getDate("createdAt"));
				sv.setUpdatedAt(rs.getDate("updatedAt"));
				sv.setStyle(styleDao.getOne(sv.getStyleId()));

				list.add(sv);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StyleValue> getAll(int index, int pagesize) {
		List<StyleValue> styleValues = new ArrayList<StyleValue>();
		String sql = "Select * From StyleValue ORDER BY name asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StyleValue sv = new StyleValue();
				sv.setId(rs.getInt("_id"));
				sv.setName(rs.getString("name"));
				sv.setStyleId(rs.getInt("styleId"));
				sv.setDeleted(rs.getBoolean("isDeleted"));
				sv.setCreatedAt(rs.getDate("createdAt"));
				sv.setUpdatedAt(rs.getDate("updatedAt"));
				sv.setStyle(styleDao.getOne(sv.getStyleId()));

				styleValues.add(sv);
			}
			return styleValues;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(StyleValue styleValue) {
		String sql = "Insert into StyleValue(name, styleId, isDeleted) Values (?,?,0)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, styleValue.getName());
			ps.setInt(2, styleValue.getStyleId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(StyleValue styleValue) {
		String sql = "Update StyleValue set name = ?, styleId = ?, isDeleted = ? where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, styleValue.getName());
			ps.setInt(2, styleValue.getStyleId());
			ps.setBoolean(3, styleValue.isDeleted());
			ps.setInt(4, styleValue.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "Update StyleValue set isDeleted = 1 where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
