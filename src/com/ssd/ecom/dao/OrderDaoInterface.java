package com.ssd.ecom.dao;

import java.util.List;

import com.ssd.ecom.Dto.OrderDto;

public interface OrderDaoInterface {
	public boolean saveOrder(OrderDto dto);
	public List<OrderDto> getOrders(int id);

}
