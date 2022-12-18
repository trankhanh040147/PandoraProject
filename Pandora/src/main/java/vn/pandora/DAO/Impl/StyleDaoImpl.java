package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iStyleDao;
import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.Model.Style;
import vn.pandora.Model.StyleValue;
import vn.pandora.Service.iStyleValueService;
import vn.pandora.Service.Impl.StyleValueServiceImpl;
import vn.pandora.Util.UtilClass;

public class StyleDaoImpl extends ConnectJDBC implements iStyleDao{

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
	
	
	
	public static void main(String[] args) {
		System.out.println((new StyleDaoImpl()).getOne(2).toString());
	}
	
}
