
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
    <title>My JSP 'marketIner.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<%
  		Market market = (Market)request.getAttribute("marketinfo");
  		String s1 = new String(market.getMarketName().getBytes("UTF-8"),"ISO8859-1");
  		System.out.print("select market is:"+market.getMarketName());
   %>

  </head>
  
  
   
	
  

    <frameset rows="18%,82%" border="1">
    	<frame name="frame4" src="showCatagoryFrame?marketID=<%=String.valueOf(market.getMarketID())%> "  noresize="noresize">
    	<frame name="frame5" src="showMarketWelcomeFrame?marketID=<%=String.valueOf(market.getMarketID())%>" noresize="noresize">
    </frameset>

</html>
