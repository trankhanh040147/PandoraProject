package vn.pandora.Service.Impl;

import java.sql.Date;
import java.util.List;

import vn.pandora.DAO.Impl.OrderDaoImpl;
import vn.pandora.Model.Order;
import vn.pandora.Service.iOrderService;

public class OrderServiceImpl implements iOrderService {
      private OrderDaoImpl orderDao= new OrderDaoImpl();
	@Override
	public Order GetOne(int id) {
		return orderDao.GetOne(id);
	}

	@Override
	public List<Order> GetAll() {
		return orderDao.GetAll();
	}

	@Override
	public void UpdateStatus(int id, String status) {
		orderDao.UpdateStatus(id, status);
		
	}

	@Override
	public List<Order> GetByStoreId(int storeId) {
		return orderDao.GetByStoreId(storeId);
	}

	@Override
	public List<Order> GetByDate(Date date) {
		return orderDao.GetByDate(date);
	}

}
