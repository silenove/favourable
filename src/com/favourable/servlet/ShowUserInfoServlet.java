package com.favourable.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.favourable.domain.User;
import com.favourable.service.ShowUserInof;

public class ShowUserInfoServlet extends HttpServlet {

	// private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------");
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------");
		String ua = (String) request.getSession().getAttribute("userName");
		System.out.println(ua);
		ShowUserInof us = new ShowUserInof(ua);
		User ui = us.getuserinfo();
		// 作用域 page request（请求） session（会话） application
		request.setAttribute("uiinfo", ui);
		request.getRequestDispatcher("jsp_user/userInfo.jsp").forward(request,
				response);
	}
}
