<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.favourable.servlet.SearchServelet"
		import="com.favourable.domain.Item"
%>
<%@page import="com.favourable.domain.Market"%>
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
    <title>找到符合条件的超市</title>
    
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
    <h3>为你找到符合条件的超市</h3>
	<hr>
	<table width="95%"  cellpadding="0" cellspacing="0" border="0">
	   <%
	     ArrayList<Market> markets=(ArrayList<Market>)request.getAttribute("markets");
	     //ArrayList<Item> items=(ArrayList<Item>)session.getAttribute("items");
	     if(markets!=null){
	     int size=markets.size();
	     for(int i=0;i<size;){
		%>
		<tr>
		   <%  
		   for(int j=0;j<3&&i<size;j++,i++){
		   %>
			<td width="20%" valign="top">
             <table>
               <tr>
                 <td><a href="ShowItemOfMarket?id=<%=Integer.toString(markets.get(i).getMarketID())%>"  target="frame1"><img src=<%="image/market/"+markets.get(i).getMarketPicture()+".jpg"%> id="marketImage" height="160" width="250"/></a>
                  </td>
               </tr>
               <tr>
                 <td>名称: <%=markets.get(i).getMarketName()%></td>
               </tr>
               <tr>
               	<td>地址: <%=markets.get(i).getMarketCity()%>,<%=markets.get(i).getMarketArea()%>
               	</td>
               </tr>
               <tr>
               	<td>&nbsp;&nbsp;&nbsp;<%=markets.get(i).getMarketBlock()%>
               	</td>
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
