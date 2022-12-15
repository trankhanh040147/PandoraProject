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
	public List<Order> GetAll() {
		String sql = "SELECT * from [Order]  ";

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

}