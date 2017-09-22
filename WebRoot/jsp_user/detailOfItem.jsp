<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.favourable.servlet.SearchServelet"
		import="com.favourable.domain.Item"
%>
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
    <title>商品展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascipt" >
		function itemImageSrc(){
              String src="image/item/"+items.get(i).getItemPicture()+".jpg";
              itemImage.Src=src;
		}
	</script>

  </head>
  
  <body>
    <h3>商品详情</h3>
	<hr>
	   <%
	     Item item=(Item)request.getAttribute("item");
		%>
             <table>
             	<tr>
                 <td><img src=<%="image/item/"+item.getItemPicture()+".jpg"%> id="itemImage"
                    width="300"/>
                 </td>
                 <td width="50">
                 </td>
               	 <td>
               	 	<table>
                 		<tr>
                 			<td>名称: <%=item.getItemName()%></td>
                 		</tr>
                 		<tr>
                 			<td>原价: <%=item.getOriginalPrice()%>&nbsp;元</td>
                 		</tr>
                 		<tr>
                 			<td>现价: <%=item.getCurrentPrice()%>&nbsp;元</td>
                 		</tr>
                 		<tr>
                 			<td>超市: <%=item.getMarketName()%></td>
                 		</tr>
                 		<tr>
                 			<td>产地: <%=item.getProduct()%></td>
                 		</tr>
                 		<tr>
                 			<td>地址: <%=item.getMarketAddress()%></td>
                 		</tr>
               		</table>
               	 </td>
               	 </tr>
           </table>
  </body>
</html>
