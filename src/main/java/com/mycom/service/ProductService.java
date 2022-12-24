package com.mycom.service;

import java.util.List;

import com.mycom.Exceptions.InvalidProductIdException;
import com.mycom.model.Product;
import com.mycom.repository.ProductRepository;



public interface ProductService {

	public List<Product> getAllProducts();

	public Product findOneProduct(int productid) throws InvalidProductIdException;

	public List<Product> getProductsByType(String productType);

	public List<String> getDistinctProduct();

	public List<Product> getAllProductsByType();

	public List<Product> getAllProductsByPrice();

}
