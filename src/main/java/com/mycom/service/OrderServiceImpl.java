package com.mycom.service;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.model.Customer;
import com.mycom.model.Orderr;
import com.mycom.model.Product;
import com.mycom.repository.CustomerRepository;
import com.mycom.repository.OrderRepository;
import com.mycom.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{


	@Autowired
	CustomerService Cs;
	
	@Autowired
	OrderService Os;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Orderr createOrder(Orderr order,int cid,int pid) {
		Customer customer=customerRepository.findById(cid).orElse(null);	
		order.setCustomer(customer);
		System.out.println("fgh   "+pid);
		Product product= productRepository.findById(pid).orElse(null);
		order.setProduct(product);
		return orderRepository.save(order);
	}
	public List<Orderr> showOrdersList(int id){
		Customer customer=customerRepository.findById(id).orElse(null);
		return orderRepository.getOrdList(customer);
	}

	
}
