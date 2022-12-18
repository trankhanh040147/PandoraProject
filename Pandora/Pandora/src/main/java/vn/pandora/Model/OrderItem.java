package vn.pandora.Model;

import java.sql.Date;
import java.util.List;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

public class OrderItem {

	public OrderItem() {

	}

	public OrderItem(int id, int orderId, int productId, List<Integer> styleValueIds, int count, Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.styleValueIds = styleValueIds;
		this.count = count;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public OrderItem(int id, int orderId, String nameProduct, int productId, int count, Date createdAt, Date updatedAt,
			Double priceProduct) {
		this.id = id;
		this.orderId = orderId;
		this.nameProduct = nameProduct;
		this.productId = productId;

		this.count = count;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.priceProduct = priceProduct;
	}

	public double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}

	private double priceProduct;
	private String nameProduct;

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	private int id;
	private int orderId;
	private int productId;
	private List<Integer> styleValueIds;

	public List<Integer> getStyleValueIds() {
		return styleValueIds;
	}

	public void setStyleValueIds(List<Integer> styleValueIds) {
		this.styleValueIds = styleValueIds;
	}

	private int count;
	private Date createdAt;
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "OrderItem [priceProduct=" + priceProduct + ", nameProduct=" + nameProduct + ", id=" + id + ", orderId="
				+ orderId + ", productId=" + productId + ", styleValueIds=" + styleValueIds + ", count=" + count
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
