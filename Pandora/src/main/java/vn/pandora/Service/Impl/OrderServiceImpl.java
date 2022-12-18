package vn.pandora.Service.Impl;

import java.sql.Date;
import java.util.List;

import vn.pandora.DAO.Impl.OrderDaoImpl;
import vn.pandora.Model.Order;
import vn.pandora.Service.iOrderService;

public class OrderServiceImpl implements iOrderService {
	private OrderDaoImpl orderDao = new OrderDaoImpl();

	@Override
	public Order GetOne(int id) {
		return orderDao.GetOne(id);
	}

	@Override
	public List<Order> GetAllByOwnerId(int i) {
		return orderDao.GetAllByOwnerId(i);
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

	@Override
	public Order GetOneJoinUser(int id) {

		return orderDao.GetOneJoinUser(id);
	}

	@Override
	public List<Order> GetByStatus(String status) {

		return orderDao.GetByStatus(status);
	}

	@Override
	public List<Order> GetAll(int index, int pagesize) {
		return orderDao.GetAll(index, pagesize);
	}

	@Override
	public List<Order> GetNotProcessed(int index, int pagesize) {

		return orderDao.GetNotProcessed(index, pagesize);
	}

	@Override
	public List<Order> GetProcessing(int index, int pagesize) {

		return orderDao.GetProcessing(index, pagesize);
	}

	@Override
	public List<Order> GetShipped(int index, int pagesize) {

		return orderDao.GetShipped(index, pagesize);
	}

	@Override
	public List<Order> GetDelivered(int index, int pagesize) {

		return orderDao.GetDelivered(index, pagesize);
	}

	@Override
	public List<Order> GetCancelled(int index, int pagesize) {

		return orderDao.GetCancelled(index, pagesize);
	}

}
