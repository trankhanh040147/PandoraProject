package vn.pandora.Model;

import java.sql.Date;

public class UserFollowProduct {

	public UserFollowProduct(int id , int userId , int productId,Date createdAt,Date updatedAt) {
		this.id= id;
		this.userId=userId;
		this.productId=productId;
		this.createdAt=createdAt;
		this.updateAt=updatedAt;
	}
	public UserFollowProduct() {}
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
private int id ;
private int userId;
private int productId;
private Date createdAt;
private Date updateAt;
}
