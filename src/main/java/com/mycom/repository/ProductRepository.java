package com.mycom.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{

}
