package vn.pandora.Model;

import java.sql.Date;

public class UserFollowStore {
     public UserFollowStore() {} 
	public UserFollowStore(int id ,int useId,int storeId,Date createdAt,Date updatedAt) {
		this.id=id;
		this.userId=useId;
		this.storeId=storeId;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
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
	public void setStoreId(int storeId) {
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
private int id ;
private int userId;
private int storeId;
private Date createdAt;
private Date updatedAt;

}
