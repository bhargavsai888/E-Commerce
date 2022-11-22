package com.ssd.ecom.dao;

import java.util.List;

import com.ssd.ecom.Dto.CartDto;

public interface CartDaoInterface {
	public List<CartDto> getAllProducts(List<CartDto> cartList);
}
