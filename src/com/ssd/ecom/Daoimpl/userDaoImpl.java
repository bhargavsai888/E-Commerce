package com.ssd.ecom.Daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.ssd.ecom.Dto.userDto;
import com.ssd.ecom.dao.userDao;
import com.ssd.ecom.util.dbConnection;

public  class userDaoImpl implements userDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String insert_user="insert into user (fname, lname, email, password) values (?,?,?,?)";
	private String get_User_By_Id = "select * from user where email = ? " ;
	private String get_user_Details="select * from user where email=? and password=?";
	public userDaoImpl() {
		conn=dbConnection.getConnection();
	}
	
	public userDto createUser(userDto dto) {
	
		userDto usrDtob = new userDto();
		
		try {
			              ps=conn.prepareStatement(insert_user);
							ps.setString(1, dto.getFname());
							ps.setString(2, dto.getLname());
							ps.setString(3, dto.getEmail());
							ps.setString(4, dto.getPassword());
						int isCreated=	ps.executeUpdate();
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return usrDtob;
	}

	@Override
	public boolean findUserByEmailAndPassword(String email,String password) {
		
		userDto usrDtob = new userDto();
		boolean isValidUser=false;
		try {
			ps=conn.prepareStatement(get_user_Details);
			ps.setString(1, email);
			ps.setString(2, password);
		rs=	ps.executeQuery();
		while(rs.next()) {
			isValidUser=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return  isValidUser;
	}

	@Override
	public userDto findUserByEmail(String email) {
		
			userDto dto = null;
			try {
				ps = conn.prepareStatement(get_User_By_Id);
				ps.setString(1, email);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					//user_id, fname, lname, email, password
					dto = new userDto(rs.getInt("id"),
							rs.getString("fname"),
							rs.getString("lname"),
							rs.getString("email"),
							"*****");
							
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return dto;
			
	}

	
	
	//public userDto get



	
	
}
