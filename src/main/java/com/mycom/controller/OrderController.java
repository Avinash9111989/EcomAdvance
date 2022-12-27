package com.mycom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.model.Orderr;
import com.mycom.service.CustomerService;
import com.mycom.service.OrderService;

@RestController
public class OrderController 
{
	@Autowired
	CustomerService Cs;
	
	@Autowired
	OrderService Os;
	
	
	@PostMapping("/createOrder/{userName}")
	public String createOrder(@PathVariable("userName") String custName ,@RequestBody Orderr orderJson)
	{
		return "";
	}
}
