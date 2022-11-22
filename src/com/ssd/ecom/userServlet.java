package com.ssd.ecom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.ecom.Dto.userDto;
import com.ssd.ecom.service.userServiceInter;
import com.ssd.ecom.serviceimpl.userSreviceimpl;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/user")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	userServiceInter userServiceI = null;

	/**
	 * Default constructor.
	 */
	public userServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		userServiceI = new userSreviceimpl();

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean isValid = false;
		String errorMag = "";

		if (fname.isEmpty() || fname.isBlank() || fname.length() >= 20) {
			errorMag = errorMag + "please enter valid first name";
			isValid = true;
		}
		if (lname.isEmpty() || lname.isBlank() || lname.length() >= 20) {
			errorMag = errorMag + "please enter valid last name";
			isValid = true;
		}
		if (email.isEmpty() || email.isBlank() || email.length() >= 30) {

			errorMag = errorMag + "please enter valid email";
			isValid = true;
		}
		if (password.isEmpty() || password.isBlank() || password.length() >= 15) {

			errorMag = errorMag + "please enter valid password";
			isValid = true;
		}
		if (!isValid) {
         System.out.println("good");
			userDto ecomDto = new userDto(fname, lname, email, password);
          System.out.println(ecomDto);
			userDto dto= userServiceI.createUser(ecomDto);
			
//			request.setAttribute("id",ecomDto.getId() );
//			request.setAttribute("email",ecomDto.getEmail() );

			request.getRequestDispatcher("userlogin.jsp").forward(request, response);

		} else {
			System.out.println("bad");
			request.setAttribute("validation", errorMag);
			request.getRequestDispatcher("userRegister.jsp").forward(request, response);
		}
	}
}
