package com.mycom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycom.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{
	public Customer findBycustUserName(String custUserName);
}
