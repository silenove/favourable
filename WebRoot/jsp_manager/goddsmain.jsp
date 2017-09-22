<%@ page language="java" import="java.util.*,com.favourable.domain.*" pageEncoding="UTF-8"%>
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
    <title>Bootstrap 实例 - 悬停表格</title>
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery-1.7.2.min.js"></script>
   <script src="js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <center>
  <table class="table table-hover">
   <thead>
      <tr>
         <th>商品ID&nbsp;</th>
         <th>商品名&nbsp;</th>
         <th>原始价格&nbsp;</th>
         <th>现在价格&nbsp;</th>
         <th>折扣&nbsp;</th>
         <th>产地&nbsp;</th>
         <th>商店编号&nbsp;</th>
         <th>种类&nbsp;</th>
      </tr>
   </thead>
   <tbody>
   	<% 
	List<Item> uList = (List<Item>)request.getAttribute("aaa");
	for(int i=0;i<uList.size();i++){
		out.print("<tr>");
		out.print("<td>"+uList.get(i).getItemID()+"</td><td>" +uList.get(i).getItemName()+"</td><td>" +uList.get(i).getOriginalPrice()+"</td><td>"+uList.get(i).getCurrentPrice()+"</td><td>"+uList.get(i).getDiscount()+"</td><td>"+uList.get(i).getProduct()+"</td><td>"+uList.get(i).getMarketID()+"</td><td>"+uList.get(i).getCatagory()+"</td>");
		out.print("</tr>");
	}
	%>
	</tbody> 
	</table>
	                       
	</center>
</body>
  <body><br> </body>
</html>
