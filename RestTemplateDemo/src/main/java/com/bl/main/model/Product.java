package com.bl.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", getProductId()=" + getProductId() + ", getProductName()=" + getProductName()
				+ ", getProductType()=" + getProductType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	@Id
	
	private long productId;
	private String productName;
	private String productType;

	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}