package com.ssd.ecom;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecom.Dto.CartDto;
import com.ssd.ecom.Dto.OrderDto;
import com.ssd.ecom.Dto.userDto;
import com.ssd.ecom.service.OrderService;
import com.ssd.ecom.serviceimpl.OrderServiceImpl;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private OrderService service;
	public void init() throws ServletException {
		service =new OrderServiceImpl();
	}
	 
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CartDto> oldCartList= (List<CartDto>) request.getSession().getAttribute("cart_list");
		if(oldCartList!=null) {
		int index=0;
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		
		Date date=new Date();
		String strDate=formatter.format(date);
		System.out.println(request.getParameter("id")+" "+"orderservelet");
		//int productId=Integer.parseInt(request.getParameter("id"));
		int productId=Integer.parseInt(request.getParameter("id"));
		System.out.println(productId+" "+"productid");
		
		userDto ecomDto =(userDto) request.getSession().getAttribute("user");
		int id=ecomDto.getId();
		System.out.println(id+"id");
		int quantity=0;
		
				for(CartDto dto:oldCartList) {
			if(dto.getId()==productId) {
				quantity=dto.getQuantity();
			    index=oldCartList.indexOf(dto);
			
				break;
			}
		}
		OrderDto odto=new OrderDto();
		odto.setDate(strDate);
		odto.setQuantity(quantity);
		odto.setuId(id);
		odto.setId(productId);
		System.out.println(odto+"data");
		boolean isOrderCreate = service.saveOrder(odto);
		
		if(isOrderCreate) {
		System.out.println("successfully saved");
			oldCartList.remove(index);
					response.sendRedirect("./OrdersDisplayServlet");
		}else {
			System.out.println("successfully not saved");
			response.sendRedirect("./CartDisplayServlet");
		}}
		else {
			response.sendRedirect("./CartDisplayServlet");
		}
	}

}
