package vn.pandora.Model;


import java.sql.Date;
import java.util.List;

public class CartItem {

	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem( int id , int cartId, int productId, List<Integer> styleValueIds,int count, Date createdAt,Date updatedAt) {
		this.id=id ;
		this.cartId=cartId;
		this.productid=productId;
		this.styleValueIds=styleValueIds;
		this.count=count;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	public List<Integer> getStyleValueIds() {
		return styleValueIds;
	}
	public void setStyleValueIds(List<Integer> styleValueIds) {
		this.styleValueIds = styleValueIds;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
private int id;
private int cartId;
private int productid;
private List<Integer> styleValueIds;
private int count;
private Date createdAt;
private Date updatedAt;
}
