package vn.pandora.DAO;

import java.sql.Date;
import java.util.List;

import vn.pandora.Model.Order;



public interface iOrderDao {
Order GetOne(int id);
List<Order> GetAll();
void UpdateStatus(int id, String status);
List<Order> GetByStoreId(int storeId);
List<Order> GetByDate(Date date);
}
