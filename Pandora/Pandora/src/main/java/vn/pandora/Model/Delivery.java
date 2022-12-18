package vn.pandora.Model;

import java.sql.Date;

public class Delivery {

	public Delivery() {

	}

	public Delivery(int id, String name, String description, int price, Boolean isDeleted, Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isDeleted = isDeleted;
		this.createDate = createdAt;
		this.updatedAt = updatedAt;
	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	private int id;
	private String name;
	private String description;
	private int price;
	private boolean isDeleted;
	private Date createDate;
	private Date updatedAt;

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", isDeleted=" + isDeleted + ", createDate=" + createDate + ", updatedAt=" + updatedAt + "]";
	}

}
