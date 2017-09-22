package com.favourable.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.favourable.domain.Area;
import com.favourable.domain.Market;
import com.favourable.service.AreaService;
import com.favourable.service.ShowMarketService;

public class ShowAreaMarketsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowAreaMarketsServlet() {
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

		request.setCharacterEncoding("utf-8");
		String areaID = (String) request.getParameter("areaID");
		String areaName = (String) request.getParameter("areaName");
		System.out.println(areaID);

		ShowMarketService sMarketService = new ShowMarketService();

		AreaService aService = new AreaService();

		Area area = aService.getAreaByAreaID(Integer.parseInt(areaID));

		List<Market> lists = sMarketService.showAreaMarketByAreaID(Integer
				.parseInt(areaID));

		if (lists.size() != 0) {
			for (Market market : lists) {
				market.setMarketArea(area.getAreaName());
			}
			request.setAttribute("markets", lists);
			request.getRequestDispatcher("jsp_user/marketShow.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("jsp_user/searchNoMarket.jsp")
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

		this.doGet(request, response);
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
