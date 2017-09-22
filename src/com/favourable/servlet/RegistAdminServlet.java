package com.favourable.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.favourable.domain.Manager;
import com.favourable.domain.Market;
import com.favourable.service.AreaService;
import com.favourable.service.ManagerService;
import com.favourable.service.MarketService;

public class RegistAdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -515700271514128919L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1, get request
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name_admin");
		String passwd = request.getParameter("password_admin");
		String confirPasswdString = request
				.getParameter("confirpassword_admin");
		String email = request.getParameter("email_admin");
		String telephone = request.getParameter("telephone_admin");
		String marketname = request.getParameter("marketname");
		String marketnum = request.getParameter("marketnum");
		String marketcity = request.getParameter("marketcity");
		String marketarea = request.getParameter("marketarea");
		String marketblock = request.getParameter("marketblock");
		if (passwd.equals(confirPasswdString) == false) {
			// ´íÎóÅÐ¶Ï -- ±ÚÖ½
			response.sendRedirect("jsp_register/differenceadmin.jsp");
		} else {
			if (name.charAt(0) != '#') {
				response.sendRedirect("jsp_register/notjing.jsp");
			} else {
				AreaService areaService = new AreaService();
				String areaIDString = areaService.getAreaID(marketarea);
				if (areaIDString.length() != 0) {
					Market market = new Market(-1, marketname, marketnum,
							marketcity, Integer.parseInt(areaIDString),
							marketblock, telephone);

					MarketService marketService = new MarketService();
					boolean canAdd = marketService.addMarket(market);

					String marketIDString = marketService.getMarketID(market);

					marketService.createMarketTable(Integer
							.parseInt(marketIDString));

					// 2, pack
					Manager admin = new Manager(-1, name, passwd, telephone,
							email, Integer.parseInt(marketIDString));

					// 3, get service
					ManagerService managerService = new ManagerService();
					boolean canAdd2 = managerService.addAdmin(admin);
					if (canAdd && canAdd2) {
						response.sendRedirect("index.jsp");
					} else {
						response.sendRedirect("jsp_register/nameexist.jsp");
					}
				} else {
					response.sendRedirect("jsp_register/notareaadmin.jsp");
				}
			}
		}
	}
}
