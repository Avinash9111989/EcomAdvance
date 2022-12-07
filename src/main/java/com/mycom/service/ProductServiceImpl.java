package com.mycom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.model.Product;
import com.mycom.repository.ProductRepository;




@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productrepo;

	@Override
	public List<Product> getAllProducts() {
		return productrepo.findAll();
	}

	@Override
	public Product findOneProduct(int productid) throws InvalidProductIdException  {
		Optional<Product> optional = productrepo.findById( productid);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new InvalidProductIdException(" Product not found for id :: " + productid);
		}
		return product;
	}

}
