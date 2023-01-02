package com.mycom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.model.Customer;
import com.mycom.model.Orderr;
import com.mycom.model.Product;
import com.mycom.repository.CustomerRepository;
import com.mycom.repository.OrderRepository;
import com.mycom.repository.ProductRepository;
import com.mycom.service.CustomerService;
import com.mycom.service.OrderService;

@RestController
public class OrderController 
{
	@Autowired
	OrderService orderService;
	@PostMapping("/createOrder/{custid}/{prodid}")
	public Orderr createOrder(@PathVariable int custid,@PathVariable int prodid ,@RequestBody Orderr orderJson)
	{
		return orderService.createOrder(orderJson, custid, prodid);
		}
	@GetMapping("/Order/{id}")
	public List<Orderr> showOrder(@PathVariable int id){
		
		return orderService.showOrdersList(id);
		
	}
	
}
