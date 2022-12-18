package vn.pandora.Service;

import java.util.List;
import vn.pandora.Model.Delivery;

public interface iDeliveryService {
	
	List<Delivery> getAll(int index, int pagesize);
	
	Delivery getOne(int id);
	
	void insert(Delivery delivery);
	
	void update(Delivery delivery);
	
	void delete(int id);

}
