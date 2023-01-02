package com.mycom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity

public class Orderr 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name = "customer")
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "product")
	Product product;
	
	public Orderr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orderr(int orderId, Customer customer, Product product, double totalA) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.totalA = totalA;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getTotalA() {
		return totalA;
	}
	public void setTotalA(double totalA) {
		this.totalA = totalA;
	}
	double totalA;
	
	
}
