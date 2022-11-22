package com.ssd.ecom.dao;

import com.ssd.ecom.Dto.userDto;

public interface userDao {
	public  userDto createUser(userDto dto);
	//public userDto findUserByEmail(String email);
	public boolean findUserByEmailAndPassword(String email,String password);
	
	public userDto findUserByEmail(String email);
	
	
}
