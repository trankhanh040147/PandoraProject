package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.OrderItem;

public interface iOrderItemService {
	List<OrderItem> GetOne(int id);//Hiển thị chi tiết 1 đơn hàng 
}
