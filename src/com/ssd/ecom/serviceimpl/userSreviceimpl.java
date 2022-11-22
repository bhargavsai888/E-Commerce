package com.ssd.ecom.serviceimpl;

import com.ssd.ecom.Daoimpl.userDaoImpl;
import com.ssd.ecom.Dto.userDto;
import com.ssd.ecom.dao.userDao;
import com.ssd.ecom.service.userServiceInter;

public class userSreviceimpl implements  userServiceInter {
	private userDao userDaoInterface;
	public userSreviceimpl() {
		userDaoInterface=new userDaoImpl();
	}
	public userDto createUser(userDto dto) {
		return userDaoInterface.createUser(dto);
	}
	
	
	
	public boolean findUserByEmailAndPassword(String email, String password) {
		
		return userDaoInterface.findUserByEmailAndPassword(email, password);
	}
	@Override
	public userDto findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDaoInterface.findUserByEmail(email);
	}
	
	


	
	
}
