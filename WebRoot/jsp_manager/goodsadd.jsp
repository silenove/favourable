<%@ page language="java" import="java.util.*,javax.swing.JOptionPane" pageEncoding="UTF-8"%>
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
    <title>My JSP 'goodsadd.jsp' starting page</title>
    
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
  <body>
    <h5>&nbsp;&nbsp;添加食品</h5>
    <form action="GoodsAdd" method="POST">
    	&nbsp;&nbsp;itemID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="itemID"><br><br>
    	&nbsp;&nbsp;itemName:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="itemName"><br><br>
    	&nbsp;&nbsp;originalPrice:&nbsp;&nbsp;<input type="text" name="originalPrice"><br><br>
    	&nbsp;&nbsp;currentPrice:&nbsp;&nbsp;<input type="text" name="currentPrice"><br><br>
    	&nbsp;&nbsp;discount:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="discount"><br><br>
    	&nbsp;&nbsp;product:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<input type="text" name="product"><br><br>
    	&nbsp;&nbsp;catagory:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="catagory"><br><br>
    	&nbsp;&nbsp;itemPicture:&nbsp;&nbsp;&nbsp;<input type="text" name="itemPicture"><br><br>
    	&nbsp;&nbsp;<input class="btn btn-default" type="submit" value="添加"><br>
    </form>
  </body>
</html>
