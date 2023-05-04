package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iTransactionDao;
import vn.pandora.Model.Transaction;

public class TransactionDaoImpl extends ConnectJDBC implements iTransactionDao{

	@Override
	public List<Transaction> GetAll() {
		String sql="SELECT * FROM Transaction";
		
		try {
			List<Transaction> list= new ArrayList<Transaction>();
			Connection con= super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Transaction transaction= new Transaction(
						rs.getInt("_id"),
						rs.getInt("userId"),
						rs.getInt("storeId"),
						rs.getBoolean("isUp"),
						rs.getDouble("amount"),
						rs.getDate("createAt"),
						rs.getDate("updatedAt")
						);
				list.add(transaction);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Transaction GetOne(int id) {
		String sql="SELECT * FROM Transaction WHERE _id=?";
		
		try {
			Connection con= super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Transaction transaction= new Transaction(
						rs.getInt("_id"),
						rs.getInt("userId"),
						rs.getInt("storeId"),
						rs.getBoolean("isUp"),
						rs.getDouble("amount"),
						rs.getDate("createdAt"),
						rs.getDate("updatedAt")
						);
				return transaction;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Transaction> GetAllByIdOwner(int index, int pagesize, int id) {
    String sql="SELECT * FROM [Transaction] WHERE userId=? ORDER BY [Transaction]._id asc  OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
		
		try {
			List<Transaction> list= new ArrayList<Transaction>();
			Connection con= super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, index);
			ps.setInt(3, pagesize);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Transaction transaction= new Transaction(
						rs.getInt("_id"),
						rs.getInt("userId"),
						rs.getInt("storeId"),
						rs.getBoolean("isUp"),
						rs.getDouble("amount"),
						rs.getDate("createdAt"),
						rs.getDate("updatedAt")
						);
				list.add(transaction);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public void Add(Transaction transaction) {
		String sqlString="INSERT INTO [Transaction](userId, storeId, amount,isUp) VALUES (?,?,?,?)";    // true là rút tiền 
		try {
			Connection con= super.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlString);
			ps.setInt(1,transaction.getUserId());
			ps.setInt(2,transaction.getStoreId());
			ps.setDouble(3,transaction.getAmount());
			ps.setBoolean(4, true);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
