package com.ssd.ecom.Daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ssd.ecom.Dto.CartDto;
import com.ssd.ecom.dao.CartDaoInterface;
import com.ssd.ecom.util.dbConnection;

public class CartDaoImpl implements CartDaoInterface{

	
	
		public Connection conn;

		private String FIND_PRODUCT_BY_ID = "select * from products where id=";

		public CartDaoImpl() {
			conn = dbConnection.getConnection();
		}

		private Statement stmt;
		private ResultSet rs;

		@Override
		public List<CartDto> getAllProducts(List<CartDto> cartList) {

			List<CartDto> newCartList = new ArrayList<>();

			for (CartDto dto : cartList) {
				
				try {
					stmt=conn.createStatement();
					rs = stmt.executeQuery(FIND_PRODUCT_BY_ID + dto.getId());
					while(rs.next()) {
						//id, name, category, price, image
					dto.setName(rs.getString("name"));
					dto.setCategory(rs.getString("category"));
					dto.setPrice(rs.getDouble("price"));
					dto.setImage(rs.getString("image"));
					newCartList.add(dto);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			return newCartList;
	}

}
