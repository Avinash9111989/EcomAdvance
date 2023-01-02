package com.mycom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.Exceptions.InvalidProductIdException;
import com.mycom.Exceptions.InvalidProductNameException;
import com.mycom.model.Product;
import com.mycom.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository Pr;

	@Override
	public List<Product> getAllProducts() 
	{
		return Pr.findAll();
	}
	public Product saveProduct(Product product) {
		return Pr.save(product);
	}
//
	@Override
	public Product findOneProduct(int productid) throws InvalidProductIdException  
	{
		Product optional = Pr.findById( productid).orElse(null);
		Product product = null;
		if (optional.equals(null)) 
		{
			throw new InvalidProductIdException(" Product not found for id :: " + productid);
			
		}
		else 
		{
			product = optional;
			}
		return product;
	}
//
//	@Override
//	public List<Product> getProductsByType(String productType) 
//	{
//		return Pr.getProductsByType(productType);
//		
//	}
//
//	@Override
//	public List<String> getDistinctProduct() {
//		return Pr.getDistinctProducts();
//	}
//
//	@Override
//	public List<Product> getAllProductsByType() 
//	{
//		return Pr.getAllProductsByType();
//	}
//
//	@Override
//	public List<Product> getAllProductsByPrice() {
//		return Pr.getAllProductsByPrice();
//		
//	}
//	@Override
//	public List<product>findByproductType(String productType)
//	{
//		return productrepo.findByproductType(productType);
//	}
//	@Override
//	public List<product>findByproductName(String productName)
//	{
//		return productrepo.findByproducName(productName);
//	}

}
