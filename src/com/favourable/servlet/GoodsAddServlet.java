package com.favourable.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.favourable.domain.Item;
import com.favourable.service.ShowGoodsService;

public class GoodsAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("itemID") == null
				|| request.getParameter("itemID").equals("")
				|| request.getParameter("itemName") == null
				|| request.getParameter("itemName").equals("")
				|| request.getParameter("originalPrice") == null
				|| request.getParameter("originalPrice").equals("")
				|| request.getParameter("currentPrice") == null
				|| request.getParameter("currentPrice").equals("")
				|| request.getParameter("discount") == null
				|| request.getParameter("discount").equals("")
				|| request.getParameter("product") == null
				|| request.getParameter("product").equals("")
				|| request.getParameter("catagory") == null
				|| request.getParameter("catagory").equals("")) {
			request.getRequestDispatcher("jsp_manager/empty.jsp").forward(
					request, response);
		} else {
			Integer ID = (Integer) request.getSession()
					.getAttribute("marketID");
			int itemID = Integer.parseInt(request.getParameter("itemID"));
			String itemName = request.getParameter("itemName");
			String originalPrice = request.getParameter("originalPrice");
			String currentPrice = request.getParameter("currentPrice");
			float discount = Float.parseFloat(request.getParameter("discount"));
			String product = request.getParameter("product");
			// int marketID =
			// Integer.parseInt(request.getParameter("marketID"));
			int marketID = ID;
			String catagory = request.getParameter("catagory");
			String itemPicture = request.getParameter("itemPicture");
			Item ub = new Item(itemID, itemName, originalPrice, currentPrice,
					discount, product, marketID, catagory, itemPicture);
			ShowGoodsService us = new ShowGoodsService("market"
					+ Integer.toString(ID));
			boolean f = us.addGoods(ub);
			Integer s;
			if (f == true)
				s = 10;
			else
				s = 20;
			request.setAttribute("addf", s);
			request.getRequestDispatcher("jsp_manager/addalert.jsp").forward(
					request, response);
		}
	}
}

// }
