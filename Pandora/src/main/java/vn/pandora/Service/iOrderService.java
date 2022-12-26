package vn.pandora.Service;

import java.sql.Date;
import java.util.List;

import vn.pandora.Model.Order;

public interface iOrderService {
	Order GetOne(int id);

	List<Order> GetAllByOwnerId(int i , int index, int pagesize);

	void UpdateStatus(int id, String status);

	List<Order> GetByStoreId(int storeId);

	List<Order> GetByDate(Date date);

	Order GetOneJoinUser(int id);

	List<Order> GetByStatus(String status, int id);
	List<Order> GetAllByStatus(String status );
	
	List<Order> GetAll(int index, int pagesize);

	List<Order> GetNotProcessed(int index, int pagesize);

	List<Order> GetProcessing(int index, int pagesize);

	List<Order> GetShipped(int index, int pagesize);

	List<Order> GetDelivered(int index, int pagesize);

	List<Order> GetCancelled(int index, int pagesize);
}