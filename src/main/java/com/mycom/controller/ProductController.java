package com.mycom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/product")
	public Product addProducts(@RequestBody Product product)
	{
	
	return productservice.saveProduct(product);
	}
	
	//retrieves a specific user detail
	@GetMapping("/product/{productid}")
	public Product retriveProduct(@PathVariable int productid) throws InvalidProductIdException
	{
		return productservice.findOneProduct(productid);
	}
//
//	@GetMapping("/product1/{productType}")
//	public List<Product>findByproductType(@PathVariable String productType)throws InvalidProductTypeException
//	{
//		return productservice.findByproductType(productType);
//	}
//	@GetMapping("/product2/{productName}")
//	public List<Product>findByproductName(@PathVariable String productName)throws InvalidProductNameException
//	{
//		return productservice.findByproductName(productName);
//	}
//	
//	@GetMapping("/products/distinctProducts")
//	public List<String> getDistinctProduct()
//	{
//		return productservice.getDistinctProduct();
//	}
//	
//	@GetMapping("/products/productsByType")
//	public List<Product> getAllProductsByType()
//	{
//		return productservice.getAllProductsByType();
//	}
//	
//	@GetMapping("/products/productsByPrice")
//	public List<Product> getAllProductsByPrice()
//	{
//		return productservice.getAllProductsByPrice();
//	}
	
	
}

