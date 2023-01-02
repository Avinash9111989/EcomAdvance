package com.mycom.controller;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mycom.Exceptions.InvalidPhoneNumberException;
import com.mycom.Exceptions.InvalidUserNameException;
import com.mycom.model.Customer;
import com.mycom.service.CustomerService;

@RestController
public class CustomerController {

  @Autowired
  CustomerService Cs;

  @PostMapping("/registerCustomer")
  public Customer regsiterCustomer(@Valid @RequestBody Customer cust) throws InvalidPhoneNumberException, InvalidUserNameException {
    if (cust.getCustPhoneNumber().toString().length() != 10)
    {
      throw new InvalidPhoneNumberException("Phone number length should be 10!");
    }
 
    
    //checking for special characters in customer's username
    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
    Matcher matcher = pattern.matcher(cust.getCustUserName());
    if(matcher.find())
    {
    	throw new InvalidUserNameException("User name cant have special characters");
    }
    
    
    return Cs.regsiterCustomer(cust);
  }


  @GetMapping("/loginCustomer")
  public String loginCustomer(@RequestBody Customer cust) {
    if (Cs.loginCustomer(cust)){ return "Logged in successfully"; 
    }
    return "Cant login! Invalid credentials";
  }

  @GetMapping("/getCustomers")
  public List<Customer> getCustomer() {
    return Cs.getCustomers();
  }

  @PutMapping("/updateCustomerByUserName/{userName}")
  public Customer updateCustomerByUserName(@PathVariable("userName") String userName, @RequestBody Customer cust)
    throws Exception {
    return Cs.updateCustomerByUserName(userName, cust);
  }

  @GetMapping("/getCustomerById/{id}")
  public Customer getCustomerById(@PathVariable("id") int id) {
    return Cs.getCustomerById(id);
  }

  @GetMapping("/getCustomerByUserName/{userName}")
  public Customer getCustomerByUserName(@PathVariable("userName") String userName) {
    return Cs.getCustomerByUserName(userName);
  }

  @GetMapping("/")
  public String home() {
    return "welcome home customer!";
  }
}
