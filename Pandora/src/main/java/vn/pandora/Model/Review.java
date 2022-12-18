package vn.pandora.Model;

import java.sql.Date;

public class Review {

	public Review(int id , int userId, int productId,int storeId,int orderId,String content,int stars ,Date createdAt,Date updatedAt ) {
		this.id=id;
		this.userId=userId;
		this.productId=productId;
		this.storeId=storeId;
		this.orderId=orderId;
		this.content=content;
		this.stars=stars;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}
	public Review() {}
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
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
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
private int productId;
private int storeId;
private int orderId;
private String content;
private int stars;
private Date createdAt;
private Date updatedAt;
}
