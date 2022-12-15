package vn.pandora.Service;

import java.sql.Date;
import java.util.List;

import vn.pandora.Model.Order;

public interface iOrderService {
	Order GetOne(int id);
	List<Order> GetAll();
	void UpdateStatus(int id, String status);
	List<Order> GetByStoreId(int storeId);
	List<Order> GetByDate(Date date);
}
