package com.favourable.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.favourable.domain.Item;
import com.favourable.service.ShowGoodsService;

public class ShowGoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ID = (Integer) request.getSession().getAttribute("marketID");
		ShowGoodsService us = new ShowGoodsService("market"
				+ Integer.toString(ID));
		List<Item> uList = us.showgoods();
		// 作用域 page request（请求） session（会话） application
		request.setAttribute("aaa", uList);
		request.getRequestDispatcher("jsp_manager/goddsmain.jsp").forward(
				request, response);
	}
}
