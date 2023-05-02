package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iDeliveryDao;
import vn.pandora.Model.Delivery;

public class DeliveryDaoImpl extends ConnectJDBC implements iDeliveryDao {

	// Hàm xem danh sách tất cả các Delivery trong hệ thống có phân trang
	@Override
	public List<Delivery> getAll(int index, int pagesize) {
		List<Delivery> deliveries = new ArrayList<Delivery>();
		String sql = "Select * From Delivery ORDER BY name asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Delivery delivery = new Delivery();

				delivery.setId(rs.getInt("_id"));
				delivery.setName(rs.getString("name"));
				delivery.setDescription(rs.getString("description"));
				delivery.setPrice(rs.getInt("price"));
				delivery.setDeleted(rs.getBoolean("isDeleted"));
				delivery.setCreateDate(rs.getDate("createdAt"));
				delivery.setUpdatedAt(rs.getDate("updatedAt"));

				deliveries.add(delivery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deliveries;
	}

	// Hàm lấy ra chi tiết thông tin của 1 Delivery trong hệ thống
	@Override
	public Delivery getOne(int id) {
		String sql = "Select * From Delivery Where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Delivery delivery = new Delivery();

				delivery.setId(rs.getInt("_id"));
				delivery.setName(rs.getString("name"));
				delivery.setDescription(rs.getString("description"));
				delivery.setPrice(rs.getInt("price"));
				delivery.setDeleted(rs.getBoolean("isDeleted"));
				delivery.setCreateDate(rs.getDate("createdAt"));
				delivery.setUpdatedAt(rs.getDate("updatedAt"));

				return delivery;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Delivery delivery) {
		String sql = "Insert into Delivery(name, description, price, isDeleted) values (?,?,?,0)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, delivery.getName());
			ps.setString(2, delivery.getDescription());
			ps.setInt(3, delivery.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Delivery delivery) {
		String sql = "Update Delivery set name = ? , description = ?, price = ?, isDeleted = ? where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, delivery.getName());
			ps.setString(2, delivery.getDescription());
			ps.setInt(3, delivery.getPrice());
			ps.setBoolean(4, delivery.isDeleted());
			ps.setInt(5, delivery.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Xóa mềm cho đơn vị vận chuyển
	@Override
	public void delete(int id) {
		String sql = "Update Delivery isDeleted = 1 where _id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
