package com.mycom.service;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.model.Orderr;
import com.mycom.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Orderr createOrder(Orderr order) {
		return orderRepository.save(order);
	}
	
}
