package com.mycom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.model.Product;
import com.mycom.service.InvalidProductIdException;
import com.mycom.service.ProductService;



@RestController
public class ProductController {

	@Autowired
	private ProductService productservice;
	@GetMapping("/product")
	public List<Product> retriveAllProducts()
	{
	return productservice.getAllProducts();
	}
	//retrieves a specific user detail
	@GetMapping("/product/{productid}")
	public Product retriveProduct(@PathVariable int productid) throws InvalidProductIdException 
	{
	return productservice.findOneProduct(productid);
	}
	
	}

