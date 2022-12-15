package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.Impl.OrderItemDaoImpl;
import vn.pandora.Model.OrderItem;
import vn.pandora.Service.iOrderItemService;

public class OrderItemServiceImpl implements iOrderItemService {
      private OrderItemDaoImpl orderItemDaoImpl= new OrderItemDaoImpl();
	@Override
	public List<OrderItem> GetOne(int id) {
		return orderItemDaoImpl.GetOne(id);
	}

}
