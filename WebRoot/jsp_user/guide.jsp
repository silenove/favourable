<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<% String name=(String)session.getAttribute("userName");
  		if(name==null){
  			//request.getRequestDispatcher("../index.jsp").forward(request,response);
  			response.sendRedirect("../index.jsp");
  		}
  	 %>
   <title>Bootstrap面包屑导航</title>
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery-1.7.2.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <style>
   		a{color:#000000 !important;}
   		a:hover{color:#84c1ff !important;}
   		.div_guide{text-align:right;background-color:#84c1ff !important;}
   </style>
</head>
<body>
<div class="div_guide">
	<ol class="breadcrumb" >
  		<li><a href="UserInfo" target="frame1">个人中心</a></li>
  		<li><a href="logout" target="_top">注销</a></li>
  		<li><a href="jsp_user/aboutUS.jsp" target="_top">关于我们</a></li>
	</ol>
</div>

</body>
</html>