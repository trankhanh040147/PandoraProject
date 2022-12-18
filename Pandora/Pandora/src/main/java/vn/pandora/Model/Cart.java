package vn.pandora.Model;

import java.sql.Date;

public class Cart {
	
	private int id;
	private int userId;
	private int storeId;
	private Date createdAt;
	private Date updatedAt;

	public Cart() {

	}

	public Cart(int id, int userId, int storeId, Date createdAt, Date updatedAt) {
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

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

	public void setStore(int storeId) {
		this.storeId = storeId;
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

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
}
