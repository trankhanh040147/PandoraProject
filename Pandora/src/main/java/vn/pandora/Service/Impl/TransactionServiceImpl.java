package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.Impl.TransactionDaoImpl;
import vn.pandora.Model.Transaction;
import vn.pandora.Service.iTransactionService;

public class TransactionServiceImpl implements iTransactionService {
	private TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();

	@Override
	public List<Transaction> GetAll(int index, int pagesize) {
		return transactionDaoImpl.GetAll(index, pagesize);
	}

	@Override
	public Transaction GetOne(int id) {
		return transactionDaoImpl.GetOne(id);
	}

}
