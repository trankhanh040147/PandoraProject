package vn.pandora.Model;

import java.sql.Date;
import java.util.List;

public class Style {

	private int id;
	private String name;
	private List<Integer> categoryIds;
	private boolean isDeleted;
	private Date createdAt;
	private Date updatedAt;

	public Style() {
		super();
	}

	public Style(int id, String name, List<Integer> categoryIds, boolean isDeleted, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.categoryIds = categoryIds;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
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

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

}
