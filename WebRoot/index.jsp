<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Login.css">
  </head>
  
  <body><!-- 
    你好欢迎来到 东软. <br><hr width="100%" size="2">
    
    
    <form action="login" method="POST">
    	用户名：<input type="text" name="uname"><br>
    	密&nbsp;&nbsp;&nbsp;码：<input type="text" name="upass"><br>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="登录">
        <br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href="reg.jsp">注册</a>
    </form>

    
  -->
  
  <%
  	String username = "";
  	String password = "";
  	Cookie[] cookies = request.getCookies();
  	if(cookies != null){
  		if(cookies.length > 1){
  			for(Cookie c:cookies){
  				if(c.getName().equals("username")){
  					username = URLDecoder.decode(c.getValue(),"utf-8");
  				}
  				if(c.getName().equals("password")){
  					password = URLDecoder.decode(c.getValue(),"utf-8");
  				}
  			}
  		}
  	}
   %>
   
   <div id="Layer1" style="position:absolute; left:0px; top:0px;width:100%; height:100%; z-index:-1">    
	<img src="image/background.jpg" height="100%" width="100%"/>    
	</div>
  
  <section class="login">
	<div class="titulo">登录</div>
	<form action="login" method="post" enctype="application/x-www-form-urlencoded">
    	<input type="text" required title="Username required" placeholder="Username" data-icon="U" name="uname" value="<%=username %>">
        <input type="password" required title="Password required" placeholder="Password" data-icon="x" name="upass" value="<%=password %>">
        <div class="olvido">
        	<div class="col"><a href="jsp_register/reg.jsp" title="Ver Carásteres">注册新用户</a></div>
            <div class="col"><a href="jsp_register/reg_admin.jsp" title="Recuperar Password">注册管理员</a></div>
        </div>
        <input type="submit" value="登录" class="enviar">
        <div class="olvido">
         <div class="col"><a  title="Ver Carásteres">&nbsp;</a></div>
        <div class="col"><a href="jsp_register/findPassword.jsp" title="Ver Carásteres">找回密码</a></div>
   		</div>
    </form>
</section>
  
  
  
  
  </body>
</html>
