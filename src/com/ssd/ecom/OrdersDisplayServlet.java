package com.ssd.ecom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecom.Dto.OrderDto;
import com.ssd.ecom.Dto.userDto;
import com.ssd.ecom.service.OrderService;
import com.ssd.ecom.serviceimpl.OrderServiceImpl;

/**
 * Servlet implementation class OrdersDisplayServlet
 */
@WebServlet("/OrdersDisplayServlet")
public class OrdersDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderService orderService ;
	
	public void init() throws ServletException{
		orderService = new OrderServiceImpl();
		
	}
   
  

	
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 userDto edto = (userDto) request.getSession().getAttribute("user");
		
		
		List<OrderDto> orderList = orderService.getOrders(edto.getId());
		System.out.println(orderList);
		request.setAttribute("orderList", orderList);
		
		request.getRequestDispatcher("Order.jsp").forward(request, response);
		
	}

}
