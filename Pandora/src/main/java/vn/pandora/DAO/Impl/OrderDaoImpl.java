package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iOrderDao;
import vn.pandora.Model.Order;

public class OrderDaoImpl extends ConnectJDBC implements iOrderDao {

	@Override
	public Order GetOne(int id) {
		String sql = "SELECT * from [Order] WHERE _id=?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(id, rs.getInt("userId"), rs.getInt("storeId"), rs.getInt("deliveryId"),
						rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> GetAllByOwnerId(int i) {
		String sql = "select * from [Order] join Store on [Order].storeId=store._id where Store.ownerId=24  ";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void UpdateStatus(int id, String status) {
		String sql = "UPDATE [Order] SET status=? where _id=?";
		Connection con;
		try {
			con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Order> GetByStoreId(int storeId) {
		String sql = "SELECT * FROM [Order] WHERE storeId=?";
		try {
			List<Order> list = new ArrayList<Order>();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> GetByDate(Date date) {
		String sql = " SELECT * FROM [Order] WHERE createdAt=?";
		try {
			List<Order> list = new ArrayList<Order>();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order GetOneJoinUser(int id) {
		String sql = " select [Order]._id,[User].lastname,[User].firstname,[Order].userId,[Order].createdAt   from [Order] join [User] on [Order].userId= [User]._id where [Order]._id=?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(id, rs.getInt("userId"), rs.getDate("createdAt"), rs.getString("firstname"),
						rs.getString("lastname"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> GetByStatus(String status) {
		String sql = "SELECT * from [Order] where status=? ";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Hàm xem danh sách tất cả đơn hàng trong hệ thống có phân trang
	@Override
	public List<Order> GetAll(int index, int pagesize) {
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * from [Order] ORDER BY _id asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Hàm xem danh sách tất cả các đơn hàng chưa được xử lý trong hệ thống có phân
	// trang
	@Override
	public List<Order> GetNotProcessed(int index, int pagesize) {
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * from [Order] Where status = 'not precessed' ORDER BY _id asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Hàm xem danh sách tất cả đơn hàng đang được xử lý trong hệ thống có phân
	// trang
	@Override
	public List<Order> GetProcessing(int index, int pagesize) {
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * from [Order] Where status = 'processing' ORDER BY _id asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Hàm xem danh sách tất cả các đơn hàng đã được ship đi trong hệ thống có phân
	// trang
	@Override
	public List<Order> GetShipped(int index, int pagesize) {
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * from [Order] Where status = 'shipped' ORDER BY _id asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Hàm xem danh sách tất cả các đơn hàng đã giao hàng trong hệ thống có phân
	// trang
	@Override
	public List<Order> GetDelivered(int index, int pagesize) {
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * from [Order] Where status = 'delivered' ORDER BY _id asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Hàm xem danh sách tất cả các đơn hàng đã bị hủy trong hệ thống có phân trang
	@Override
	public List<Order> GetCancelled(int index, int pagesize) {
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * from [Order] Where status = 'cancelled' ORDER BY _id asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getInt("deliveryId"), rs.getString("address"), rs.getString("phone"), rs.getString("status"),
						rs.getBoolean("isPaidBefore"), rs.getDouble("amountFromUser"), rs.getDouble("amountFromStore"),
						rs.getDouble("amountToStore"), rs.getDouble("amountToGD"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}