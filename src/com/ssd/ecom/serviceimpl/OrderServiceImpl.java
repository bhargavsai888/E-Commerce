package com.ssd.ecom.serviceimpl;

import java.util.List;

import com.ssd.ecom.Daoimpl.OrderDaoImpl;
import com.ssd.ecom.Dto.OrderDto;
import com.ssd.ecom.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDaoImpl orderDaoI;
	public OrderServiceImpl() {
		orderDaoI= new OrderDaoImpl();
	}
	
	@Override
	public boolean saveOrder(OrderDto dto) {
		
		return orderDaoI.saveOrder(dto);
	}

	@Override
	public List<OrderDto> getOrders(int id) {
		// TODO Auto-generated method stub
		return orderDaoI.getOrders(id);
	}

}
