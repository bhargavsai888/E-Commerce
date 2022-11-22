package com.ssd.ecom.service;

import java.util.List;

import com.ssd.ecom.Dto.OrderDto;

public interface OrderService {
	public boolean saveOrder(OrderDto dto);
	public List<OrderDto> getOrders(int id);

}
