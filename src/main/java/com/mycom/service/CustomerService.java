package com.mycom.service;

import java.util.List;

import com.mycom.model.Customer;

public interface CustomerService {
		public Customer customerRegistration(Customer cust);
		public List<Customer> getAllCustomers();
		public Customer customerUpdatee(int id, Customer cust);
}
