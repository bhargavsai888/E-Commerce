package com.ssd.ecom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecom.Dto.CartDto;
import com.ssd.ecom.service.CartServiceInterface;
import com.ssd.ecom.serviceimpl.CartServiceImpl;

/**
 * Servlet implementation class CartDisplayServlet
 */
@WebServlet("/CartDisplayServlet")
public class CartDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CartServiceInterface cartService;

	@Override
	public void init() throws ServletException {
		cartService = new CartServiceImpl();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CartDto> listOfProducts = (List<CartDto>) request.getSession().getAttribute("cart_list");

		if (listOfProducts == null) {
			response.sendRedirect("./ProductServlet");
		} else {

		List<CartDto> newCartList = cartService.getAllProducts(listOfProducts);
		//System.out.println(newCartList+" good");
		double totalPrice=getTotalPrice(newCartList);
		
		request.getSession().setAttribute("cart_list",newCartList);
		request.getSession().setAttribute("totalPrice",totalPrice);
		
		response.sendRedirect("Cart.jsp");
		}
	}
	public double getTotalPrice(List<CartDto> newCartList ) {
		double totalPrice=0;
		for(CartDto dto:newCartList) {
			totalPrice=totalPrice+(dto.getPrice()*dto.getQuantity());
		}
		
		
		
		
		return totalPrice;
		
	}

}
