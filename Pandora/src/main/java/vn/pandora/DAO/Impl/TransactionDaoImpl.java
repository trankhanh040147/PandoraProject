package vn.pandora.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.pandora.Connection.ConnectJDBC;
import vn.pandora.DAO.iTransactionDao;
import vn.pandora.Model.Transaction;

public class TransactionDaoImpl extends ConnectJDBC implements iTransactionDao {

	// Hàm xem danh sách tất cả các giao dịch trong hệ thống có phân trang
	@Override
	public List<Transaction> GetAll(int index, int pagesize) {
		List<Transaction> list = new ArrayList<Transaction>();
		String sql = "SELECT * FROM dbo.[Transaction] ORDER BY _id asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getBoolean("isUp"), rs.getDouble("amount"), rs.getDate("createAt"), rs.getDate("updatedAt"));
				list.add(transaction);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Transaction GetOne(int id) {
		String sql = "SELECT * FROM dbo.[Transaction] WHERE _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("_id"), rs.getInt("userId"), rs.getInt("storeId"),
						rs.getBoolean("isUp"), rs.getDouble("amount"), rs.getDate("createAt"), rs.getDate("updatedAt"));
				return transaction;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
