package com.mycom.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.model.Customer;
import com.mycom.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService Cs;
	
	@GetMapping("/customers")
	public List<Customer> retriveAllCustomers(){
		return Cs.getAllCustomers();
	}
	
	@PostMapping("/customer")
	public Customer customerRegistration(@RequestBody Customer cust) {
		return Cs.customerRegistration(cust);
	}
	
	@PutMapping("/customerUpdate/{id}")
	public Customer customerUpdate(@PathVariable("id") int id, @RequestBody Customer cust) {
		System.out.println(id);
		System.out.println(cust.getCustomerName());
		return Cs.customerUpdatee(id,cust);
	}
	
}
