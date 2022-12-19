package com.mycom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Singular;

@Data
@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="custid")
	private int custId;
	
	//@OneToMany(mappedBy = "customer")
	//private List<Orderr> ordersList = new ArrayList<Orderr>();
	//Ignore these lines
	
	
	@NotBlank
	@Size(min=3,max=20)
	private String custName;
	private Long custPhoneNumber;
	
	@NotNull
	private Date custRegisterDate;
	
	@Size(min=3)
	@Column(name = "custUName",unique = true)
	private String custUserName;
	
	@Size(min=6 , max =10)
	private String custPassword;
}
