package vn.pandora.DAO.Impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iUserDao;
import vn.pandora.Model.User;

public class UserDaoImpl extends ConnectJDBC implements iUserDao {

	//Hàm tìm bằng id user
	@Override
	public User getOne(int id) {
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
				user.setAddress(rs.getString("addresses"));
				user.setRole(rs.getString("role"));
				user.setAddress(sql);
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
	
	//Tìm người dùng theo thông tin bất kỳ
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
					user.setAddress(rs.getString("addresses"));
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
		
		
	//Hàm tìm tất cả User có phân trang
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
				user.setAddress(rs.getString("addresses"));
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
	
	//Hàm đăng nhập
	@Override
	public User login(String email, String passwd) {
		String sql = "Select * From dbo.[User] where email=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setId_card(rs.getString("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmailActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("addresses"));
				user.setRole(rs.getString("role"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setE_wallet(rs.getDouble("e_wallet"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));

				if (passwd.equals(user.getPassword())) {
					return user;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//Hàm tìm thông tin user theo email
	@Override
	public User findByEmail(String email) {
		String sql = "Select * From dbo.[User] where email=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setId_card(rs.getString("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmailActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setAddress(rs.getString("addresses"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
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
	
	@Override
	public User findById(int id) {
		String sql = "Select * From dbo.[User] where _id=?";
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
				user.setEmail(rs.getString("email"));
				user.setId_card(rs.getString("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmailActive"));
				user.setAddress(rs.getString("addresses"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
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

	//Hàm đăng ký tài khoản Customer
	@Override
	public void registerCustomer(User user) {
		String sql = "Insert Into dbo.[USER] (lastname, firstname, email, phone, password, role) \n"
				+ "VALUES (?,?,?,?,?,'customer')";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getLastname());
			ps.setString(2, user.getFirstname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getPassword());
		
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Hàm đăng ký tài khoản Vendor
	@Override
	public void registerVendor(User user) {
		String sql = "Insert Into dbo.[USER] (lastname, firstname, email, phone, password, id_card, addresses, role) \n"
				+ "VALUES (?,?,?,?,?,?,?,'vendor')";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getLastname());
			ps.setString(2, user.getFirstname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getId_card());
			ps.setString(7, user.getAddress());
			
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Chức năng thay đổi thông tin tài khoản của người mua
	@Override
	public void editCustomer(User user) {
		String sql = "Update dbo.[User] Set firstname=?, lastname=?, id_card=?,email=?, "
				+ "phone=?,addresses=?, avatar=?, password=?, e_wallet=?, isEmailActive=?, isPhoneActive=? WHERE _id=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			System.out.println(user);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getId_card());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getAvatar());
			ps.setString(8, user.getPassword());
			ps.setDouble(9, user.getE_wallet());
			ps.setBoolean(10, user.isEmailActive());
			ps.setBoolean(11, user.isPhoneActive());
			ps.setInt(12, user.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		iUserDao userDao= new UserDaoImpl();
	}

	
	
}
