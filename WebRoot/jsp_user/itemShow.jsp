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
    <title>热销商品</title>
    
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
  
    <h3>热销商品</h3>
	<hr>
	<table width="95%"  cellpadding="0" cellspacing="0" border="0">
	   <%
	     ArrayList<Item> items=(ArrayList<Item>)session.getAttribute("mostHotItems");
	     //ArrayList<Item> items=(ArrayList<Item>)session.getAttribute("items");
	     if(items!=null){
	     int size=items.size();
	     for(int i=0;i<size;){
		%>
		<tr>
		   <%  
		   for(int j=0;j<4&&i<size;j++,i++){
		   %>
			<td width="20%" valign="top">
             <table>
               <tr>
                 <td ><a href="showDetailItem?itemID=<%=String.valueOf(items.get(i).getItemID())%>&marketID=<%=String.valueOf(items.get(i).getMarketID())%>" target="frame1"><img src="image/item/<%=items.get(i).getItemPicture()%>.jpg" id="itemImage" height="160" width="190"/></a>
                  </td>
               </tr>
               <tr>
                 	<td>名称: <%=items.get(i).getItemName()%></td>
               </tr>
               <tr>
                  	<td><span style="text-decoration: line-through">原价: <%=items.get(i).getOriginalPrice()%>&nbsp;元</span></td>
               </tr>
               <tr>
                	<td>现价： <%=items.get(i).getCurrentPrice()%>&nbsp;元</td>
               </tr>
               <tr>
			     <td>
				   <hr style=" height:2px;border:none;border-top:2px dotted #185598;" />
			    </td>
		       </tr>
            </table>
            </td>
            <%
              }
            %>
		</tr>
		<%
			}
			}
		 %>
		</table>
  </body>
</html>
