<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <% String name=(String)session.getAttribute("managerName");
  		if(name==null){
  			//request.getRequestDispatcher("../index.jsp").forward(request,response);
  			response.sendRedirect("../index.jsp");
  		}
  	 %>
    <title>My JSP 'welcome.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/bootstrap.min.css">
   <script src="js/jquery-1.7.2.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  
  <body bgcolor="#AEEEEE">
    <h1>欢迎来到管理员界面</h1>
    <a href="ShowGoods" target="mainpage"><button type="button" class="btn btn-primary">商品查看</button></a> 
    <a href="jsp_manager/goodsadd.jsp" target="mainpage"><button type="button" class="btn btn-primary">添加商品</button></a> 
    <a href="jsp_manager/goodsdel.jsp" target="mainpage"><button type="button" class="btn btn-primary">删除商品</button></a>
    <a href="index.jsp" target="_top"><button type="button" class="btn btn-primary">注销</button></a>        
  </body>
</html>
