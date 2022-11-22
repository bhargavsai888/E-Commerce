package com.ssd.ecom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecom.Dto.ProductDto;
import com.ssd.ecom.service.ProductServiceInter;
import com.ssd.ecom.serviceimpl.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	  private ProductServiceInter productService;
		@Override
		public void init() throws ServletException {
			productService=new ProductServiceImpl();
		}
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<ProductDto>productsList=productService.getAllProducts();
		
		System.out.println(productsList);
		request.setAttribute("productsList", productsList);
		request.getRequestDispatcher("Products.jsp").forward(request, response);
		
	}

}
