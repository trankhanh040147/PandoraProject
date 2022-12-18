package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Transaction;

public interface iTransactionDao {
	List<Transaction> GetAll(int index, int pagesize);

	// Lấy danh sách giao dịch 1 cửa hàng
	Transaction GetOne(int id);
}
