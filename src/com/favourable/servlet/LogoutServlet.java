package com.favourable.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LogoutServlet() {
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

		// Cookie usernameCookie = new Cookie("username", "");
		// Cookie passwordCookie = new Cookie("password", "");
		// usernameCookie.setMaxAge(86400);
		// passwordCookie.setMaxAge(86400);
		// response.addCookie(usernameCookie);
		// response.addCookie(passwordCookie);

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			if (cookies.length > 1) {
				for (Cookie c : cookies) {
					if (c.getName().equals("username")) {
						c.setMaxAge(0);
						response.addCookie(c);
					}
					if (c.getName().equals("password")) {
						c.setMaxAge(0);
						response.addCookie(c);
					}
				}
			}
		}

		// String username = "";
		// String password = "";
		// Cookie[] cookies1 = request.getCookies();
		// if(cookies != null){
		// if(cookies.length > 1){
		// for(Cookie c:cookies1){
		// if(c.getName().equals("username")){
		// username = URLDecoder.decode(c.getValue(),"utf-8");
		// }
		// if(c.getName().equals("password")){
		// password = URLDecoder.decode(c.getValue(),"utf-8");
		// }
		// }
		// }
		// }
		//	  	
		// System.out.println(username);
		// System.out.println(password);

		response.sendRedirect("index.jsp");
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
