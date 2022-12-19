package com.mycom.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.model.Customer;
import com.mycom.model.Orderr;
import com.mycom.repository.CustomerRepo;
import com.mycom.repository.OrderRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo Cr;
	OrderRepo Or;

	@Override
	public Customer regsiterCustomer(Customer cust) 
	{
		
//		Customer custt = Cr.save(cust);
//		System.out.println(custt.getCustId());
//		Orderr ordObj = new Orderr();
//		ordObj.setCustomer(custt);
//		Or.save(ordObj);
//		return custt;
		return  Cr.save(cust);		 
	}

	@Override
	public boolean loginCustomer(Customer cust) 
	{
		Customer databaseObject = Cr.findBycustUserName(cust.getCustUserName());
		if(databaseObject == null)
		{
			return false;
		}
		if(databaseObject.getCustUserName().equals(cust.getCustUserName()) && databaseObject.getCustPassword().equals(cust.getCustPassword()))
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Customer> getCustomers() 
	{
		return Cr.findAll();
		
	}

	@Override
	public Customer updateCustomerByUserName(String userName, @Valid Customer cust) 
	{
		Customer ans = null;
		try
		{
			Customer dataFromDb = Cr.findBycustUserName(userName);
			dataFromDb.setCustUserName(cust.getCustUserName());
			Cr.save(dataFromDb);
			System.out.println("updated the user name"); 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
		return null;
	}
 
	@Override
	public Customer getCustomerById(int id) 
	{
		return Cr.findById(id).get();
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		return Cr.findBycustUserName(userName);
	}
}
