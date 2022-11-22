package com.ssd.ecom.Daoimpl;

import com.ssd.ecom.Dto.OrderDto;
import com.ssd.ecom.dao.OrderDaoInterface;
import com.ssd.ecom.util.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class OrderDaoImpl implements OrderDaoInterface {
	

	
		private Connection conn;
		private PreparedStatement ps;
		private Statement stmt;
		private ResultSet rs;
		
		// orderId, uId, pId, quantity, date
		private String ORDER_INSERT = "insert into orders(uId,pId,quantity,date)"
				+ " values(?,?,?,?)";
		 //orderId, uId, pId, quantity, date
		private String GET_ALL_ORDERS = "select date,name,catagorey,quantity,price from orders o inner join product p on o.pId = p.id where uId=";

		public OrderDaoImpl() {
			conn =dbConnection.getConnection();
			
		}
		
		@Override
		public boolean saveOrder(OrderDto dto) {
			boolean isUpdated = false;
			try {
				ps=conn.prepareStatement(ORDER_INSERT);
				ps.setInt(1, dto.getuId());
				ps.setInt(2, dto.getId());
				ps.setInt(3, dto.getQuantity());
				ps.setString(4, dto.getDate());
				int noOfRecords=ps.executeUpdate();
				if(noOfRecords>0) {
					isUpdated=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isUpdated;
		}

		@Override
		public List<OrderDto> getOrders(int id) {
			List<OrderDto> orderList = new ArrayList<>();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(GET_ALL_ORDERS + id);
				while(rs.next()) {
					OrderDto dto = new OrderDto();
					
					dto.setDate(rs.getString("date"));
					dto.setQuantity(rs.getInt("quantity"));
					dto.setName(rs.getString("name"));
					dto.setCategory(rs.getString("category"));
					double price = rs.getInt("price") * rs.getInt("quantity");
					dto.setPrice(price);
					
					orderList.add(dto);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return orderList;
		}

	}


