package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iStyleDao;
import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.Model.Style;
import vn.pandora.Model.StyleValue;
import vn.pandora.Service.iStyleValueService;
import vn.pandora.Service.Impl.StyleValueServiceImpl;
import vn.pandora.Util.UtilClass;

public class StyleDaoImpl extends ConnectJDBC implements iStyleDao {

	@Override
	public Style getOne(int id) {
		String sql = "select * from Style where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Style style = new Style();

				style.setId(id);
				style.setName(rs.getString("name"));
				style.setCategoryIds(UtilClass.toList_Int(rs.getString("categoryIds")));
				style.setDeleted(rs.getBoolean("isDeleted"));
				style.setCreatedAt(rs.getDate("createdAt"));
				style.setUpdatedAt(rs.getDate("updatedAt"));

				return style;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Hàm lấy ra tất cả các Style trong hệ thống có phân trang
	@Override
	public List<Style> getAll(int index, int pagesize) {
		List<Style> styles = new ArrayList<Style>();
		String sql = "Select * From Style ORDER BY name asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Style style = new Style();

				style.setId(rs.getInt("_id"));
				style.setName(rs.getString("name"));
				style.setCategoryIds(UtilClass.toList_Int((rs.getString("categoryIds"))));
				style.setDeleted(rs.getBoolean("isDeleted"));
				style.setCreatedAt(rs.getDate("createdAt"));
				style.setUpdatedAt(rs.getDate("updatedAt"));

				styles.add(style);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styles;
	}

	@Override
	public void insert(Style style) {
		String sql = "Insert into Style(name, categoryIds, isDeleted) Values (?,?,0)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, style.getName());
			ps.setString(2, UtilClass.toStr_IntList((style.getCategoryIds())));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Style style) {
		String sql = "Update Style set name = ?, categoryIds = ?, isDeleted = ? where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, style.getName());
			ps.setString(2, UtilClass.toStr_IntList(style.getCategoryIds()));
			ps.setBoolean(3, style.isDeleted());
			ps.setInt(4, style.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Xóa mềm cho style
	@Override
	public void delete(int id) {
		String sql = "Update Style set isDeleted = 1 where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println((new StyleDaoImpl()).getOne(2).toString());
	}

}
