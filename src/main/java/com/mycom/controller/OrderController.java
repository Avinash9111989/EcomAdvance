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
	CustomerService Cs;
	
	@Autowired
	OrderService Os;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;
	@PostMapping("/createOrder/{custid}/{prodid}")
	public Orderr createOrder(@PathVariable int custid,@PathVariable int prodid ,@RequestBody Orderr orderJson)
	{
		Customer customer=customerRepository.findById(custid).orElse(null);	
		orderJson.setCustomer(customer);
		System.out.println("fgh   "+prodid);
		Product product= productRepository.findById(prodid).orElse(null);
		orderJson.setProduct(product);
		return Os.createOrder(orderJson);
		}
	@GetMapping("/Order/{id}")
	public List<Orderr> showOrder(@PathVariable int id){
		Customer customer=customerRepository.findById(id).orElse(null);	
		return orderRepository.getOrdList(customer);
		
	}
	
}
