package com.favourable.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.favourable.domain.Item;
import com.favourable.domain.Market;
import com.favourable.service.ShowItemOfMarketService;
import com.favourable.service.ShowMarketService;

public class ShowCatagoryItemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowCatagoryItemServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		String idString = request.getParameter("catagoryID");

		int marketTable = Integer.parseInt(request.getParameter("marketID"));
		ShowMarketService sMarketService = new ShowMarketService();
		Market market = sMarketService.showMarketByMarketID(marketTable);
		ShowItemOfMarketService showItemOfMarketService = new ShowItemOfMarketService(
				marketTable);

		ArrayList<Item> lists = null;

		// System.out.println(idString);

		try {
			if (idString.equals("0")) {
				lists = showItemOfMarketService.showItemOfMarket();
			} else if (idString.equals("1")) {
				lists = showItemOfMarketService.showItemofCatagory("饮品");
			} else if (idString.equals("2")) {
				lists = showItemOfMarketService.showItemofCatagory("生活");
			} else if (idString.equals("3")) {
				lists = showItemOfMarketService.showItemofCatagory("水果");
			} else if (idString.equals("4")) {
				lists = showItemOfMarketService.showItemofCatagory("电子");
			} else if (idString.equals("5")) {
				lists = showItemOfMarketService.showItemofCatagory("服饰");
			} else if (idString.equals("6")) {
				lists = showItemOfMarketService.showItemofCatagory("运动");
			} else {
				lists = new ArrayList<Item>();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("items", lists);
		if (lists == null || lists.size() == 0) {
			request.getRequestDispatcher("jsp_user/searchNoitem.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("jsp_user/marketItemShow.jsp")
					.forward(request, response);
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
