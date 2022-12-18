package vn.pandora.Model;

import java.sql.Date;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

public class StyleValue {

	public StyleValue() {
		
	}
	public StyleValue(int id , String name,int styleId, boolean isDeleted,Date createdAt,Date updatedAt) {
		this.id=id;
		this.name =name ;
		this.styleId=styleId;
		this.isDeleted=isDeleted;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}
public StyleValue(int id, String name ) {
	this.id= id;
	this.name= name;
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
	public int getStyleId() {
		return styleId;
	}
	public void setStyleId(int styleId) {
		this.styleId = styleId;
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

private int id;
private String name;
private int styleId;
private boolean isDeleted;
private Date createdAt;
private Date updatedAt;
}
