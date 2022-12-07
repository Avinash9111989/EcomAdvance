package com.mycom.service;

import java.util.List;

import com.mycom.Exceptions.InvalidProductIdException;
import com.mycom.model.Product;



public interface ProductService {

	public List<Product> getAllProducts();

	public Product findOneProduct(int productid) throws InvalidProductIdException;

}
