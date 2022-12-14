package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iOrderItemDao;
import vn.pandora.Model.OrderItem;

public class OrderItemDaoImpl extends ConnectJDBC implements iOrderItemDao{

	@Override
	public List<OrderItem> GetOne(int id) {
			String sql="select * from [OrderItem] WHERE orderId=?";
			try {
				Connection con = super.getConnection();
     			PreparedStatement ps= con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				List<OrderItem> list= new ArrayList<OrderItem>();
				while(rs.next()) {
					//function get List<Integer> from String
					List<Integer> listStyleValueIdsIntegers= new ArrayList<Integer>();
					 String[] ss=(rs.getString("styleValueIds")).split(" //,");
					 for(int i=0;i<ss.length;i++)
					 {
						 listStyleValueIdsIntegers.add(Integer.parseInt(ss[i]));
					 }
					OrderItem orderItem = new OrderItem(
							rs.getInt("_id"),
							rs.getInt("OrderId"),
							rs.getInt("productId"),
							listStyleValueIdsIntegers,
							rs.getInt("count"),
							rs.getDate("createdAt"),
							rs.getDate("updatedAt")
							);
					list.add(orderItem);
				}
				return list;
			} catch (Exception e) {
				e.getStackTrace();
			}
			return null;
	}

	

}
