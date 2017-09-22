<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.favourable.domain.Market"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <% String name=(String)session.getAttribute("userName");
  		if(name==null){
  			//request.getRequestDispatcher("../index.jsp").forward(request,response);
  			response.sendRedirect("../index.jsp");
  		}
  	 %>
    <title>My JSP 'marketCatagory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.0.0.min.js"></script>
   <script src="js/bootstrap.min.js"></script>

  </head>
  
  <body>
  
   <h3>&nbsp;&nbsp;<%=request.getAttribute("marketName")%></h3>
  <ul class="nav nav-tabs">
   <li><a href="showCatagoryItem?marketID=<%=request.getAttribute("marketID")%>&catagoryID=0" target="frame5">所有商品</a></li>
   <li><a href="showCatagoryItem?marketID=<%=request.getAttribute("marketID")%>&catagoryID=1" target="frame5">饮品</a></li>
   <li><a href="showCatagoryItem?marketID=<%=request.getAttribute("marketID")%>&catagoryID=2" target="frame5">生活</a></li>
   <li><a href="showCatagoryItem?marketID=<%=request.getAttribute("marketID")%>&catagoryID=3" target="frame5">水果</a></li>
   <li><a href="showCatagoryItem?marketID=<%=request.getAttribute("marketID")%>&catagoryID=4" target="frame5">电子</a></li>
   <li><a href="showCatagoryItem?marketID=<%=request.getAttribute("marketID")%>&catagoryID=5" target="frame5">服饰</a></li>
   <li><a href="showCatagoryItem?marketID=<%=request.getAttribute("marketID")%>&catagoryID=6" target="frame5">运动</a></li>
</ul>

  </body>
</html>
