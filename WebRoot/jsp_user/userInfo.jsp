<%@ page language="java" import="java.util.*,com.favourable.domain.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
   <title>Bootstrap 实例 - 响应式表格</title>
   <base href="<%=basePath%>">
   <% String name=(String)session.getAttribute("userName");
  		if(name==null){
  			response.sendRedirect("../index.jsp");
  		}
  		System.out.print("user_info: name is "+name+"\n");
  	%>
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery-1.7.2.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <style type="text/css">
   		.button1{border:none;color:#1E90FF;background-color:#FFFFFF;font-size:15px;}
   </style>
</head>
<body>
<center>
<table>
	<% User userInfo=(User)request.getAttribute("uiinfo"); %>
	<tr>
		<td valign="bottom" style="font-size:35px;">
			个人信息
		</td>
		<td width="20%">
		</td>
		</tr>
</table>
<br>
<br>
</center>
<table>
<tr>
	<td width="35%">
	</td>
	<td><img src="image/displayPhoto/001.jpg" height="210">
	</td>
	<td width="10%">
	</td>
	<td>
		<table class="table table-hover">
      <tr>
         <td>用户名:</td>
         <td><%=userInfo.getUserName()%></td>
      </tr>
      <tr>
         <td>区域:</td>
         <td><%=userInfo.getAreaNameById(userInfo.getUserAreaID())%></td>
      </tr>
      <tr>
         <td>街道:</td>
         <td><%=userInfo.getUserBlock()%></td>
      </tr>
      <tr>
         <td>邮箱:</td>
         <td><%=userInfo.getUserEmail()%></td>
      </tr>
      <tr>
         <td>电话:</td>
         <td><%=userInfo.getUserPhone()%></td>
      </tr>
</table>
		
	</td>
</tr>
</table>
</body>
</html>

