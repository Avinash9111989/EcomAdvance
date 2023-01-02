package com.mycom.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.model.Orderr;

@Service
public interface OrderService 
{
	
	public Orderr createOrder(Orderr order,int cid,int pid);
	public List<Orderr> showOrdersList(int id);	
	
}
