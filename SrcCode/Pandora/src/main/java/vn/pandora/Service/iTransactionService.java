package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.Transaction;

public interface iTransactionService {
	List<Transaction> GetAll();
	Transaction GetOne(int id);
}
