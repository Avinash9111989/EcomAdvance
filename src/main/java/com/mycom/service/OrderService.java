package com.mycom.service;



import org.springframework.stereotype.Service;

import com.mycom.model.Orderr;

@Service
public interface OrderService 
{
	
	public Orderr createOrder(Orderr order);
		
	
}
