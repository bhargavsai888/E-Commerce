package com.ssd.ecom.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;
import com.ssd.ecom.Dto.ProductDto;
import com.ssd.ecom.dao.ProductDaoInter;

import com.ssd.ecom.util.dbConnection;

public class ProductDaoimpl implements ProductDaoInter {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private java.sql.Statement st;
	private String get_all_products="select * from products ";
	@Override
	public List<ProductDto> GetAllProducts() {
		
		
		List<ProductDto>Productlist=new ArrayList<>();
		try {
		
		
			conn = dbConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(get_all_products);
		while(rs.next()) {
			Productlist.add(new ProductDto(rs.getInt("id"),rs.getString("name"),
					rs.getString("category"),
					rs.getDouble("price"),
					rs.getString("image")));
		}
		
		
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return Productlist;
	}

}
