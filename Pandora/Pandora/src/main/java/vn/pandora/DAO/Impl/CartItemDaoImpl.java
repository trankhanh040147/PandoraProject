package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iCartDao;
import vn.pandora.DAO.iCartItemDao;
import vn.pandora.DAO.iProductDao;
import vn.pandora.Model.Cart;
import vn.pandora.Model.CartItem;
import vn.pandora.Model.Store;
import vn.pandora.Model.StyleValue;
import vn.pandora.Util.UtilClass;

public class CartItemDaoImpl extends ConnectJDBC implements iCartItemDao {

	iProductDao productDao = new ProductDaoImpl();
	
	@Override
	public void insert(CartItem cartItem) {
		String sql = "insert into CartItem(cartId,productId,styleValueIds,count) values(?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setString(3, UtilClass.toStr_IntList(cartItem.getStyleValueIds()));
			ps.setInt(4, cartItem.getCount());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tìm tất cả các CartItem thuộc một Cart
	@Override
	public List<CartItem> findByCartId(int id) {
		String sql = "select * from CartItem where cartId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			List<CartItem> list = new ArrayList<CartItem>();
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("_id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setStyleValueIds(UtilClass.toList_Int(rs.getString("styleValueIds")));
				cartItem.setCount(rs.getInt("count"));
				cartItem.setCreatedAt(rs.getDate("createdAt"));
				cartItem.setUpdatedAt(rs.getDate("updatedAt"));
				cartItem.setProduct(productDao.GetOne(cartItem.getProductId()));
				list.add(cartItem);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Cho phép khách update cartItem của mình (thay đổi số lượng)
	@Override
	public void update(CartItem cartItem) {
		String sql = "Update CartItem set count=? where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getCount());
			ps.setInt(2, cartItem.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		iCartItemDao dao = new CartItemDaoImpl();
		CartItem cartItem = new CartItem();

		cartItem.setId(5);
		cartItem.setCartId(8);
		cartItem.setCount(100);
		cartItem.setProductId(3);
		cartItem.setStyleValueIds(new ArrayList<Integer>(0));

		dao.update(cartItem);
		
		List<CartItem> list = dao.findByCartId(8);
		
		for (CartItem cartItem2 : list) {
			System.out.println(cartItem2.getProduct().toString());
		}
	}

	@Override
	public CartItem findOne(int id) {
		String sql = "select * from CartItem where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("_id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setStyleValueIds(UtilClass.toList_Int(rs.getString("styleValueIds")));
				cartItem.setCount(rs.getInt("count"));
				cartItem.setCreatedAt(rs.getDate("createdAt"));
				cartItem.setUpdatedAt(rs.getDate("updatedAt"));
				cartItem.setProduct(productDao.GetOne(cartItem.getProductId()));
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM CartItem WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
