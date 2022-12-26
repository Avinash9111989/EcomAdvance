package com.mycom.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycom.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value = "select * from product p where p.product_type =?1",nativeQuery=true)
	List<Product> getProductsByType(String productType);

	
	@Query(value = "select distinct p.product_type from product p",nativeQuery = true)
	List<String> getDistinctProducts();
	
	@Query(value = "select * from product p order by p.product_type",nativeQuery = true)
	List<Product> getAllProductsByType();
	
	@Query(value = "select * from product p order by p.product_price",nativeQuery = true)
	List<Product> getAllProductsByPrice();
	public List<Product> findByproductType(String productType);
	public List<Product> findByproductName(String productName);
}
