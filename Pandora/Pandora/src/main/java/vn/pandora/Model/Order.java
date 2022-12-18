package vn.pandora.Model;

import java.sql.Date;

public class Order {

	public Order(int id, int userId, int storeId, int deliveryId, String adress, String phone, String status,
			boolean isPaidBefore, double amountFromUser, double amountFromStore, double amountToStore,
			double amountToGD, Date createdAt, Date updatedAt) {
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.deliveryId = deliveryId;
		this.address = adress;
		this.phone = phone;
		this.status = status;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGD = amountToGD;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Order() {
	}

	public Order(int id, int userId, Date createdAt, String firstname, String lastname) {
		this.id = id;
		this.userId = userId;
		this.createdAt = createdAt;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	private int id;
	private int userId;
	private int storeId;
	private int deliveryId;
	private String firstname;
	private String lastname;

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

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPaidBefore() {
		return isPaidBefore;
	}

	public void setPaidBefore(boolean isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
	}

	public double getAmountFromUser() {
		return amountFromUser;
	}

	public void setAmountFromUser(double amountFromUser) {
		this.amountFromUser = amountFromUser;
	}

	public double getAmountFromStore() {
		return amountFromStore;
	}

	public void setAmountFromStore(double amountFromStore) {
		this.amountFromStore = amountFromStore;
	}

	public double getAmountToStore() {
		return amountToStore;
	}

	public void setAmountToStore(double amountToStore) {
		this.amountToStore = amountToStore;
	}

	public double getAmountToGD() {
		return amountToGD;
	}

	public void setAmountToGD(double amountToGD) {
		this.amountToGD = amountToGD;
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

	private String address;
	private String phone;
	private String status;
	private boolean isPaidBefore;
	private double amountFromUser;
	private double amountFromStore;
	private double amountToStore;
	private double amountToGD;
	private Date createdAt;
	private Date updatedAt;

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", deliveryId=" + deliveryId
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phone=" + phone
				+ ", status=" + status + ", isPaidBefore=" + isPaidBefore + ", amountFromUser=" + amountFromUser
				+ ", amountFromStore=" + amountFromStore + ", amountToStore=" + amountToStore + ", amountToGD="
				+ amountToGD + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
