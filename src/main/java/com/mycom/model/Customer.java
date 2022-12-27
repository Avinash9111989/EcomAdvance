package com.mycom.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int CustomerID;
	private String CustomerName;
	private String CustomerPhoneNumber;
	private String CustomerUserName;
	private String CustomerPassword;
	@Embedded
	private Address address;
	
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerPhoneNumber() {
		return CustomerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		CustomerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerUserName() {
		return CustomerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		CustomerUserName = customerUserName;
	}
	public String getCustomerPassword() {
		return CustomerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
