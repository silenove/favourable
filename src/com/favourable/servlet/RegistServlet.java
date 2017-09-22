package com.favourable.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.favourable.domain.User;
import com.favourable.service.AreaService;
import com.favourable.service.UserService;

public class RegistServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5840236404186965423L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1, get request
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String passwd = request.getParameter("password");
		String confirPasswdString = request.getParameter("confirpassword");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String usercity = request.getParameter("usercity");
		String userblock = request.getParameter("userblock");
		String userStreet = request.getParameter("userstreet");

		if (passwd.equals(confirPasswdString) == false) {
			// ´íÎóÅÐ¶Ï -- ±ÚÖ½
			response.sendRedirect("jsp_register/difference.jsp");
		}
		// 3, æŸ¥æ‰¾areaID
		else {

			AreaService areaService = new AreaService();
			String areaIDString = areaService.getAreaID(userblock);
			// System.out.print("areaId: "+areaIDString+"\n");
			if (areaIDString.length() == 0) {
				// System.out.print("buchunzai");
				response.sendRedirect("jsp_register/notarea.jsp");
			} else {

				// 2, pack
				User user = new User(-1, name, passwd, usercity, Integer
						.parseInt(areaIDString), userStreet, telephone, email);

				// 3, get service
				UserService userService = new UserService();
				boolean canAdd = userService.addUser(user);

				if (canAdd) {
					System.out.println("GG");
					response.sendRedirect("index.jsp");
				} else {
					response.sendRedirect("jsp_register/nameexist.jsp");
				}
			}
		}
	}
}
