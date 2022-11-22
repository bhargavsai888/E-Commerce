package com.ssd.ecom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecom.Dto.CartDto;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int productId = Integer.parseInt(request.getParameter("id"));

		List<CartDto> oldcartList = (List<CartDto>) request.getSession().getAttribute("cart_list");

		List<CartDto> newCartList = new ArrayList<>();

		boolean isProductExist = false;

		CartDto newCartDto = new CartDto();

		newCartDto.setId(productId);
		newCartDto.setQuantity(1);

		if (oldcartList == null) {

			newCartList.add(newCartDto);
			request.getSession().setAttribute("cart_list", newCartList);
			response.sendRedirect("./ProductServlet");
		} else {
			newCartList = oldcartList;

			for (CartDto dto : newCartList) {

				if (dto.getId() == productId) {
					isProductExist = true;

				}

			}
			if (isProductExist) {

				response.sendRedirect("index.jsp");

			} else {
				newCartList.add(newCartDto);
				request.getSession().setAttribute("cart_list", newCartList);
				response.sendRedirect("./ProductServlet");
			}
		}
		
		
	}

}
