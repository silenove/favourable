<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     </head>
     
     <!--
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	


  
  <body>
     <h5>注册</h5>
    <form action="regist" method="POST">
    	用户：<input type="text" name="uname"><br>
    	密码：<input type="text" name="upass"><br>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="submit" value="注册"><br>
    </form>
  -->
  
  <head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>错误</title>

<link rel="stylesheet" href="css/UserReg.css" type="text/css">

</head><body>

<div id="container">

<br><br><br>

<div class="label">管理员用户名请以#键开始</div>

<br><br>

<div id="tw-outer">

<div id="tw">

					<form action="registadmin" method="post">
						请您确认您的用户名以#键开始！
						<div class='clearfix'></div>

						<div id='submit' class='outerDiv'>

							<a href="jsp_register/reg_admin.jsp">点击返回注册界面</a>

						</div>

						<div class='clearfix'></div>

					</form>

					<div class="clearfix"></div>

</div>

</div>

<br>

<div id="warning" style="margin-top: 20px; color: rgb(85, 85, 85); text-align: center; font-size: 14px;"></div>

</div>
  
  </body>
</html>
