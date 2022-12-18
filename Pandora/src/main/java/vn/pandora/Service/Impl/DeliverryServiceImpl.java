package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iDeliveryDao;
import vn.pandora.DAO.Impl.DeliveryDaoImpl;
import vn.pandora.Model.Delivery;
import vn.pandora.Service.iDeliveryService;

public class DeliverryServiceImpl implements iDeliveryService {

	iDeliveryDao deliveryDao = new DeliveryDaoImpl();
	@Override
	public List<Delivery> getAll(int index, int pagesize) {
		
		return deliveryDao.getAll(index, pagesize);
	}

	@Override
	public Delivery getOne(int id) {
		
		return deliveryDao.getOne(id);
	}

	@Override
	public void insert(Delivery delivery) {
		
		deliveryDao.insert(delivery);
	}

	@Override
	public void update(Delivery delivery) {
		
		deliveryDao.update(delivery);
	}

	@Override
	public void delete(int id) {
		
		deliveryDao.delete(id);
	}

}
