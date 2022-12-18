package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iOrderItemDao;
import vn.pandora.Model.OrderItem;

public class OrderItemDaoImpl extends ConnectJDBC implements iOrderItemDao{

	@Override
	public List<OrderItem> GetOne(int id) {
			String sql="select OrderItem._id, OrderItem.count,Product.categoryId,Product.styleValueIds, OrderItem.orderId ,OrderItem.productId,OrderItem.createdAt,OrderItem.updatedAt,Product.name, Product.promotionalPrice from OrderItem join Product on OrderItem.productId=Product._id  WHERE orderId=?";
			try {
				Connection con = super.getConnection();
     			PreparedStatement ps= con.prepareStatement(sql);
     			
				ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				
				List<OrderItem> list= new ArrayList<OrderItem>();
				while(rs.next()) {
					//function get List<Integer> from String
					
					 
					
					 String string1=rs.getString("styleValueIds");
					
					    List<Integer> list1 = Arrays.asList(string1.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
			System.out.println(list);
					 
					try {
						OrderItem orderItem = new OrderItem();

								orderItem.setId(rs.getInt("_id"));
								orderItem.setOrderId(rs.getInt("orderId"));
								orderItem.setNameProduct(rs.getString("name"));
								orderItem.setProductId(rs.getInt("productId"));
								orderItem.setStyleValueIds(list1);
								orderItem.setCount(rs.getInt("count"));
								orderItem.setCreatedAt(rs.getDate("createdAt"));
								orderItem.setUpdatedAt(rs.getDate("updatedAt"));
								orderItem.setPriceProduct(rs.getDouble("promotionalPrice"));
								
						list.add(orderItem);
					} catch (SQLException e) {
						e.printStackTrace();
					}		 
					
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	

}
