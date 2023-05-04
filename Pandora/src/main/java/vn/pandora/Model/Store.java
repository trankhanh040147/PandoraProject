package vn.pandora.Model;

import java.sql.Date;

public class Store {
	public Store() {
	}

	public Store(int id, String name, String bio, int ownerId, boolean isActive, boolean isOpen, String avatar,
			String cover, String featured_image, int rating, double e_wallet, Date createAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.bio = bio;
		this.ownerId = ownerId;
		this.isActive = isActive;
		this.isOpen = isOpen;
		this.avatar = avatar;
		this.cover = cover;
		this.featured_image = featured_image;
		this.rating = rating;
		this.e_wallet = e_wallet;
		this.createdAt = createAt;
		this.updatedAt = updatedAt;

	}

	public Store(String name, String bio, int ownerId, String avatar, String cover, String featured_image) {

		this.name = name;
		this.bio = bio;
		this.ownerId = ownerId;
		this.avatar = avatar;
		this.cover = cover;
		this.featured_image = featured_image;

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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getFeatured_image() {
		return featured_image;
	}

	public void setFeatured_image(String featured_image) {
		this.featured_image = featured_image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getE_wallet() {
		return e_wallet;
	}

	public void setE_wallet(double e_wallet) {
		this.e_wallet = e_wallet;
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
	private String name;
	private String bio;
	private int ownerId;
	private boolean isActive;
	private boolean isOpen;
	private String avatar;
	private String cover;
	private String featured_image;
	private int rating;
	private double e_wallet;
	private Date createdAt;
	private Date updatedAt;

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", bio=" + bio + ", ownerId=" + ownerId + ", isActive=" + isActive
				+ ", isOpen=" + isOpen + ", avatar=" + avatar + ", cover=" + cover + ", featured_image="
				+ featured_image + ", rating=" + rating + ", e_wallet=" + e_wallet + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}