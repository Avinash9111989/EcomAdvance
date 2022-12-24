package com.mycom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.Exceptions.InvalidProductIdException;
import com.mycom.model.Product;
import com.mycom.repository.ProductRepository;
import com.mycom.service.ProductService;



@RestController
public class ProductController {

	@Autowired
	private ProductService productservice;
	@GetMapping("/products")
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
	
	@GetMapping("/products/{productType}")
	public List<Product> getProductsByType(@PathVariable String productType)
	{
		return productservice.getProductsByType(productType);
	}
	
	@GetMapping("/products/distinctProducts")
	public List<String> getDistinctProduct()
	{
		return productservice.getDistinctProduct();
	}
	
	@GetMapping("/products/productsByType")
	public List<Product> getAllProductsByType()
	{
		return productservice.getAllProductsByType();
	}
	
	@GetMapping("/products/productsByPrice")
	public List<Product> getAllProductsByPrice()
	{
		return productservice.getAllProductsByPrice();
	}
	
	
}

