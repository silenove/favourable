<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.favourable.domain.Area"%>
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
    <title>My JSP 'areaMarket.jsp' starting page</title>
    
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
  <% 
  		List<Area> lists = (ArrayList)session.getAttribute("areaList");
  %>
  <body>
   <nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" >超市</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="showAreaMarkets?areaID=<%=String.valueOf(session.getAttribute("userAreaID")) %>" target="frame1">附近的超市</a></li>
         <li class="dropdown">
            <a  href="#" class="dropdown-toggle" data-toggle="dropdown">
            	   地区
               <b class="caret"></b>
            </a>
            <ul class="dropdown-menu" role="menu">
               <%
               		for(int i = 0;i < lists.size();i++){
                %>
                
                <li><a href="showAreaMarkets?areaID=<%=String.valueOf(lists.get(i).getAreaID()) %>" target="frame1"><%=lists.get(i).getAreaName() %></li>
                
                <%} %>
            </ul>
         </li>
      </ul>
   </div>
</nav>

   </body>
</html>
