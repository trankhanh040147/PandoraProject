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
						rs.getDate("createAt"),
						rs.getDate("updatedAt")
						);
				return transaction;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
