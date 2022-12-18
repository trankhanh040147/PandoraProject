package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iCartDao;
import vn.pandora.Model.Cart;
import vn.pandora.Model.CartItem;
import vn.pandora.Util.UtilClass;

public class CartDaoImpl extends ConnectJDBC implements iCartDao {

	@Override
	public void insert(Cart cart) {
		String sql = "insert into Cart(userId, storeId) values(?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getStoreId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

	@Override
	public Cart findLast() {
		String sql = "SELECT TOP 1 * FROM Cart ORDER BY _id DESC ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("_id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStore(rs.getInt("storeId"));
				cart.setCreatedAt(rs.getDate("createdAt"));
				cart.setUpdatedAt(rs.getDate("updatedAt"));
				return cart;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cart findLastByUserId(int id) {
		String sql = "SELECT TOP 1 * FROM Cart Where userId=? ORDER BY _id DESC ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("_id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStore(rs.getInt("storeId"));
				cart.setCreatedAt(rs.getDate("createdAt"));
				cart.setUpdatedAt(rs.getDate("updatedAt"));
				return cart;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
