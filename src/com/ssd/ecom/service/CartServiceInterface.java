package com.ssd.ecom.service;

import java.util.List;

import com.ssd.ecom.Dto.CartDto;

public interface CartServiceInterface {
	public List<CartDto> getAllProducts(List<CartDto> cartList);
}
