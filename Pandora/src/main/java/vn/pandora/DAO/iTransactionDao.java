package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Transaction;

public interface iTransactionDao {
	List<Transaction> GetAll();
	List<Transaction> GetAllByIdOwner( int index , int pagesize , int id);
	Transaction GetOne(int id);// Lấy danh sách giao dịch 1 cửa hàng
	void Add(Transaction transaction);
}
