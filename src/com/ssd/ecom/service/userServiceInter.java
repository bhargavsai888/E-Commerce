package com.ssd.ecom.service;

import java.util.List;

import com.ssd.ecom.Dto.userDto;

public interface userServiceInter {

	public userDto createUser(userDto dto);
	//public userDto findUserByEmail(String email);
	public boolean findUserByEmailAndPassword(String email,String password);
	public userDto findUserByEmail(String email);
	
}
