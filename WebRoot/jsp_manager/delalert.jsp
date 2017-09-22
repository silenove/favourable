<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'delalert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
    <%
    Integer f = (Integer)request.getAttribute("addd");
    int a=0;  
	if(f==10){
	//System.out.println("是123");
		 out.print("<script>alert('删除成功');</script>");
	}else if (f==20){
		out.print("<script>alert('商品不存在');</script>");
	}
	else {
		;
	}
	//request.getRequestDispatcher("goodsadd.jsp").forward(request, response);
%>
<a href="jsp_manager/goodsdel.jsp" target="mainpage">点击继续</a>
  </body>
</html>
