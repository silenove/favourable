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
    <title>My JSP 'aboutUS.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.title{
			font-size:70px;
			line-height:150%;
			text-align:left;
			color:#fff;
			font-family:verdana
		}
		
		.stitle{
			font-size:30px;
			line-height:110%;
			text-align:center;
			color:#fff;
			font-family:verdana
		}
		
		.contact{
			font-size:20px;
			line-height:110%;
			text-align:center;
			color:#fff;
			font-family:verdana
		}
		.copyRight{
			font-size:20px;
			line-height:110%;
			text-align:center;
			color:#fff;
			font-family:verdana
		}
	</style>

  </head>
  
  <body >
  
  
	<div id="Layer1" style="position:absolute; left:0px; top:0px;width:100%; height:100%; z-index:-1">    
	<img src="image/background.jpg" height="100%" width="100%"/>    
	</div>   
  
  
  <div class="title">
  	<p>About us</p>
  </div>
  
  <div class="stitle">
  	<p>Team leader:</p>
  	<p>Bi Zhi</p> 
  	<p>Team member:</p>
  	<p>WenTao&nbsp;&nbsp;&nbsp;TianCheng&nbsp;&nbsp;&nbsp;YiMing</p> 
  	
   </div>
   
   <div class="contact">
   <br><br><br><br><br>
   <p>Email: bizhi@163.com</p>
  </div>
  <center>
  <div class="copyRight">
  	<p>Copyright &copy; 2016 - 2016. All Rights Reserved.</p>
  </div>
    </center>
  </body>
</html>
