package vn.pandora.Model;

import java.sql.Date;
import java.util.List;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private double promotionalPrice;
	private int quantity;
	private int sold;
	private boolean isActive;
	private boolean isSelling;
	private List<String> listImages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPromotionalPrice() {
		return promotionalPrice;
	}

	public void setPromotionalPrice(double promotionalPrice) {
		this.promotionalPrice = promotionalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isSelling() {
		return isSelling;
	}

	public void setSelling(boolean isSelling) {
		this.isSelling = isSelling;
	}

	public List<String> getListImages() {
		return listImages;
	}

	public void setListImages(List<String> listImages) {
		this.listImages = listImages;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<Integer> getStyleValueIds() {
		return styleValueIds;
	}

	public void setStyleValueIds(List<Integer> styleValueIds) {
		this.styleValueIds = styleValueIds;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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

	private int categoryId;
	private List<Integer> styleValueIds;
	private int storeId;
	private int rating;
	private Date createdAt;
	private Date updatedAt;

	public Product() {

	}

	public Product(int id, String name, String description, double price, double promotionalPrice, int quantity,
			int sold, boolean isActive, boolean isSelling, List<String> listImages, int categoryId,
			List<Integer> styleValueIds, int storeId, int rating, Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.isSelling = isSelling;
		this.listImages = listImages;
		this.categoryId = categoryId;
		this.styleValueIds = styleValueIds;
		this.storeId = storeId;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Product(String name, String description, double price, double promotionalPrice, int quantity,
			List<String> listImages, int categoryId, List<Integer> styleValueIds, int storeId) {

		this.name = name;
		this.description = description;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
		this.listImages = listImages;
		this.categoryId = categoryId;
		this.styleValueIds = styleValueIds;
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", promotionalPrice=" + promotionalPrice + ", quantity=" + quantity + ", sold=" + sold + ", isActive="
				+ isActive + ", isSelling=" + isSelling + ", listImages=" + listImages + ", categoryId=" + categoryId
				+ ", styleValueIds=" + styleValueIds + ", storeId=" + storeId + ", rating=" + rating + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
