package vn.pandora.Model;

import java.sql.Date;

public class Transaction {

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(int id , int userId, int storeId, Boolean isUp, double amount,Date createdAt,Date updatedAt) {
		this.id=id;
		this.userId=userId;
		this.storeId=storeId;
		this.isUp=isUp;
		this.amount=amount;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}
private int id ; 
private int userId;
private int storeId; 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getStoreId() {
	return storeId;
}
public void setStoreId(int storeId) {
	this.storeId = storeId;
}
public Boolean getIsUp() {
	return isUp;
}
public void setIsUp(Boolean isUp) {
	this.isUp = isUp;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public Date getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
private Boolean isUp;
private double amount;
private Date createdAt;
private Date updatedAt;
}
