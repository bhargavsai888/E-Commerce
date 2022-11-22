package com.ssd.ecom.serviceimpl;

import java.util.List;

import com.ssd.ecom.Daoimpl.CartDaoImpl;
import com.ssd.ecom.Dto.CartDto;
import com.ssd.ecom.dao.CartDaoInterface;
import com.ssd.ecom.service.CartServiceInterface;

public class CartServiceImpl implements CartServiceInterface {
public CartDaoInterface CartDaoInterface;
	public CartServiceImpl() {
		CartDaoInterface	=new CartDaoImpl();
	}
	@Override
	public List<CartDto> getAllProducts(List<CartDto> cartList) {
		// TODO Auto-generated method stub
		return CartDaoInterface.getAllProducts(cartList);
	}

}
