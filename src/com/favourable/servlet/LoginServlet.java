package com.favourable.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.favourable.domain.Area;
import com.favourable.domain.Item;
import com.favourable.domain.User;
import com.favourable.domain.UserBean;
import com.favourable.service.ManagerService;
import com.favourable.service.RecommandService;
import com.favourable.service.ShowAreaService;
import com.favourable.service.UserService;

public class LoginServlet extends HttpServlet {

	private static int maxNum = 30;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1, Get request
		String na = request.getParameter("uname");
		String pa = request.getParameter("upass");

		// 2, Pack
		UserBean ub = new UserBean(na, pa);

		// 3, Get service
		UserService us = new UserService();

		// 4, Use service
		boolean isUser = us.isUser(ub);
		boolean isAdmin = us.isAdmin(ub);

		// 5, Get user
		User user = us.getUserByUserName(na);

		if (isUser || isAdmin) {

			Cookie usernameCookie = new Cookie("username", na);
			Cookie passwordCookie = new Cookie("password", pa);
			usernameCookie.setMaxAge(86400);
			passwordCookie.setMaxAge(86400);
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
			if (na.contains("#")) {
				request.getSession().setAttribute("managerName", na);
				ManagerService ms = new ManagerService();
				Integer a = ms.ismanger(na);
				if (a != -1) {
					request.getSession().setAttribute("marketID", a);
				}
				request.getRequestDispatcher("jsp_manager/index.jsp").forward(
						request, response);
			} else {
				List<Area> list = null;
				ShowAreaService sAreaService = new ShowAreaService();
				list = sAreaService.showAllAreas();
				request.getSession().setAttribute("areaList", list);
				request.getSession().setAttribute("userName", na);
				if (user != null)
					request.getSession().setAttribute("userAreaID",
							user.getUserAreaID());

				HttpSession session = request.getSession();
				if (request == null) {
					System.out.print("searchServelet:request is null");
				}
				RecommandService recommandservice = new RecommandService(
						request, response);
				ArrayList<Item> recommandItems = null;
				ArrayList<Item> mostHotItems = null;
				try {
					recommandItems = recommandservice.getRecommandItem();
					mostHotItems = recommandservice.getMostHotItem(maxNum);
					// System.out.print("the size of cookies is "+recommandItems.size()+"\n");
					// for(Item item:recommandItems){
					// System.out.print("cookies:"+item.getItemName()+"\n");
					// }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("recommandItems", recommandItems);
				session.setAttribute("mostHotItems", mostHotItems);
				request.getRequestDispatcher("jsp_user/main.jsp").forward(
						request, response);
			}

		} else {
			System.out.print("buchenggong");
			response.sendRedirect("nook.jsp");

		}
	}
}
