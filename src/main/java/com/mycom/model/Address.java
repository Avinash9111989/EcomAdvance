package com.mycom.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AddrID")
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL},mappedBy = "address")
	private Customer cust;
	
	private @Getter @Setter String streetName;
	private @Getter @Setter String cityName;
	private @Getter @Setter int pinCode;

}
