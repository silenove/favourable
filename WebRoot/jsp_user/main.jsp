<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
     <frameset rows="5%,12%,83%" border="2">
     	<frame src="jsp_user/guide.jsp" noresize="noresize">
     	<frame src="jsp_user/search.jsp" noresize="noresize">
     	<frameset cols="20%,60%,20%",border="2">
     		<frame name="frame2" src="jsp_user/areaMarket.jsp" noresize="noresize">
     		<frame name="frame1"  src="jsp_user/itemShow.jsp" noresize="noresize">
     		<frame name="frame3" src="jsp_user/recommand.jsp" noresize="noresize">
     	</frameset>
     </frameset>
</html>
