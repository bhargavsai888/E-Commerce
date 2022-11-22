package com.ssd.ecom;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssd.ecom.Dto.userDto;
import com.ssd.ecom.service.*;
import com.ssd.ecom.serviceimpl.userSreviceimpl;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	userServiceInter userServiceInter=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		userServiceInter=new userSreviceimpl();
	}
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		boolean isvalid=false;
		String error="";
		if(email.isBlank() ||email.isEmpty()) {
			isvalid=true;
			error+="email is invalid";
		}
		if(password.isBlank() ||password.isEmpty()) {
			isvalid=true;
			error+="password is invalid";
		}
		
		if(!isvalid) {
			
			boolean validuser=userServiceInter.findUserByEmailAndPassword(email, password);
			if(validuser) {
				
				userDto dto = userServiceInter.findUserByEmail(email);
				HttpSession session = request.getSession();
				session.setAttribute("user", dto);
				System.out.println(dto);
			request.getRequestDispatcher("/ProductServlet").forward(request, response);
		}}
		else {
			request.setAttribute("errormessage", error);
			request.getRequestDispatcher("userlogin.jsp").forward(request, response);
		}
		
	}

}

