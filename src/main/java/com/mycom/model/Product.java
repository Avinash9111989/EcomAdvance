package com.mycom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int productId;
	 @Pattern(regexp="^[a-zA-Z]{3}",message="length must be 3")  
private String productName;
private float productPrice;
private String productType;
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public float getProductPrice() {
	return productPrice;
}
public void setProductPrice(float productPrice) {
	this.productPrice = productPrice;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public Product(int productId, @Pattern(regexp = "^[a-zA-Z]{3}", message = "length must be 3") String productName,
		float productPrice, String productType) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
	this.productType = productType;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}


}

