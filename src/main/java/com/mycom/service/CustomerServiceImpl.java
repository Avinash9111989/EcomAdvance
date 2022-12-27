package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.model.Customer;
import com.mycom.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository cr;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Customer customerRegistration(Customer cust) {
		// TODO Auto-generated method stub
		return cr.save(cust);
	}
	
	@Override
	public Customer customerUpdatee(int id, Customer cust) {
		// TODO Auto-generated method stub
		Customer datafromDB=cr.findById(id).get();
		datafromDB.setCustomerName(cust.getCustomerName());
		return cr.save(datafromDB);
	}

}
