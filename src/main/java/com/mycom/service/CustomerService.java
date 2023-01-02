package com.mycom.service;

import java.util.List;

import javax.validation.Valid;
import com.mycom.model.Customer;

public interface CustomerService {

  Customer regsiterCustomer(Customer cust);

  boolean loginCustomer(Customer cust);
//
  List<Customer> getCustomers();
//
  Customer updateCustomerByUserName(String userName, @Valid Customer cust) throws Exception;
//
  Customer getCustomerById(int id);
//
  Customer getCustomerByUserName(String userName);

}
