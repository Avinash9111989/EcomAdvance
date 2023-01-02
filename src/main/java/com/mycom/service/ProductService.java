package com.mycom.service;

import java.util.List;

import com.mycom.Exceptions.InvalidProductIdException;
import com.mycom.model.Product;
import com.mycom.repository.ProductRepository;

import com.mycom.Exceptions.InvalidProductNameException;
import com.mycom.Exceptions.InvalidProductTypeException;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
//
	public Product findOneProduct(int productid) throws InvalidProductIdException;

	public List<Product> getProductsByType(String productType);

	public List<String> getDistinctProduct();

	public List<Product> getAllProductsByType();

	public List<Product> getAllProductsByPrice();
	public List<Product>findByproductType(String productType) throws InvalidProductTypeException;
	
	public List<Product>findByproductName(String productName) throws InvalidProductNameException;
}
