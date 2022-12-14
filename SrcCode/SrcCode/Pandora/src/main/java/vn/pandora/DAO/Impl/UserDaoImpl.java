package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iUserDao;
import vn.pandora.Model.User;

public class UserDaoImpl extends ConnectJDBC implements iUserDao {

	@Override
	public List<User> getAll(int index, int pagesize) {
		List<User> users = new ArrayList<User>();
		String sql = "Select * from dbo.[User] ORDER BY firstname asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmailActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setaddresses(rs.getString("addresses"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setE_wallet(rs.getDouble("e_wallet"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void insert(String firstname, String lastname, String id_card, String email, String phone, String password,
			String addresses, String avatar, String cover) {
		String sql = "Insert Into dbo.[User](firstname, lastname, id_card, email, phone, password, addresses, avatar, cover) values "
				+ "(?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, id_card);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.setString(6, password);
			ps.setString(7, addresses);
			ps.setString(8, avatar);
			ps.setString(9, cover);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findUser(String infoUser, int index, int pagesize) {
		List<User> users = new ArrayList<User>();
		String sql = "Select * from dbo.[User] where (role = 'customer' or role = 'vendor') and \n"
				+ "				 (firstname like (?) or lastname like (?) or id_card like (?) \n"
				+ "				 email like (?) or  phone like (?) or addresses like (?))\n"
				+ "				 ORDER BY firstname asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + infoUser + "%");
			ps.setString(2, "%" + infoUser + "%");
			ps.setString(3, "%" + infoUser + "%");
			ps.setString(4, "%" + infoUser + "%");
			ps.setString(5, "%" + infoUser + "%");
			ps.setString(6, "%" + infoUser + "%");
			ps.setInt(7, index);
			ps.setInt(8, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmailActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setaddresses(rs.getString("addresses"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setE_wallet(rs.getDouble("e_wallet"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User get(int id) {
		String sql = "Select * from dbo.[User] Where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmailActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setaddresses(rs.getString("addresses"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setE_wallet(rs.getDouble("e_wallet"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
