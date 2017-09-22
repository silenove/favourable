package com.favourable.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.favourable.service.ShowGoodsService;

public class GoodsDelServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		Integer ID = (Integer) request.getSession().getAttribute("marketID");
		ShowGoodsService us = new ShowGoodsService("market"
				+ Integer.toString(ID));
		boolean f = us.delGoods(itemID);
		Integer s;
		if (f == true)
			s = 10;
		else
			s = 20;
		request.setAttribute("addd", s);
		request.getRequestDispatcher("jsp_manager/delalert.jsp").forward(
				request, response);
		// response.sendRedirect("index.jsp");
	}
}
