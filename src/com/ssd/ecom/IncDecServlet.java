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
 * Servlet implementation class IncDecServlet
 */
@WebServlet("/IncDecServlet")
public class IncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncDecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CartDto> oldCartList = (List<CartDto>) request.getSession().getAttribute("cart_list");
		List<CartDto> newCartList = new ArrayList<>();

		int productId = Integer.parseInt(request.getParameter("id"));
		String incOrDec = request.getParameter("action");
		int pos = 0;
		CartDto newCartDto = new CartDto();
        
		if (incOrDec.equals("inc")) {
			for (CartDto dto : oldCartList) {

				if (dto.getId() == productId) {

					pos = oldCartList.indexOf(dto);

					newCartDto.setId(dto.getId());
					newCartDto.setName(dto.getName());
	
					newCartDto.setCategory(dto.getCategory());

					int qt = dto.getQuantity();

					qt = qt + 1;
					newCartDto.setQuantity(qt);
					break;

				}
			}
			
		} else if (incOrDec.equals("dec")) {

			for (CartDto dto : oldCartList) {

				if (dto.getId() == productId && dto.getQuantity() > 1) {

					pos = oldCartList.indexOf(dto);

					newCartDto.setId(dto.getId());
					newCartDto.setName(dto.getName());
					newCartDto.setCategory(dto.getCategory());
					int qt = dto.getQuantity();
					qt = qt - 1;
					dto.setQuantity(qt);
					break;
				}
			}
			response.sendRedirect("./CartDisplayServlet");
		}

		if (incOrDec.equals("rmv")) {
			for (CartDto dto : oldCartList) {
				if (dto.getId() == productId) {
					if (oldCartList.remove(oldCartList.indexOf(dto)) != null) {

						break;
					}
				}
			}

			response.sendRedirect("./CartDisplayServlet");
}
		oldCartList.remove(pos);
		oldCartList.add(pos, newCartDto);
		request.getSession().setAttribute("cart_list", oldCartList);
		response.sendRedirect("./CartDisplayServlet");

	}

}



