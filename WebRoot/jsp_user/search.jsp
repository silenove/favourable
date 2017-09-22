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
  		//System.out.print("search: name is "+name+"\n");
  	 %>
    <title>My JSP 'search.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script type="text/javascript" language="javasript">
   	   function onFocus(){
   	   		if(document.getElementById("input1").value=='输入超市/商品'){
   	   		   document.getElementById("input1").value='';
   	   		   document.getElementById("input1").className="input1_style";
			}
   	   }
   	   function onBlur(){
   	   		if(document.getElementById("input1").value==''){
   	   			document.getElementById("input1").value='输入超市/商品';
   	   			document.getElementById("input1").className="input0_style";
   	   		}
   	   }
   </script>
   
   <style type="text/css">
		.input1_style{color:black}
		.input0_style{color:#e5e1e1}
	</style>
  </head>
  
  <body >
     <div id="Layer1" style="position:absolute; left:0px; top:0px;width:100%; height:100%; z-index:-1">    
	<img src="image/search_background.jpg" height="100%" width="100%"/>    
	</div>
 
    <center>
    <form  action="search"  method="get" target="frame1" >
 
    	<table width="20%" height="80%" border="0" >
    		<tr>
    			 <td width="0%">
    			      <select name="category">
    			      	  <option >商品</option>
    			      	  <option >超市</option>
    			      </select>
    			 </td>
    			 <td width=80%>
    			 	<input class="input0_style "id="input1" name="name" type="text" width="100%" value="输入超市/商品" onfocus="javascript:onFocus()"
    			 	 onblur="javascript:onBlur()"/>
    			 </td>
    			 <td width="10%">
    			 	<button type="submit" width="100%" class="btn btn-default" >
                     <span class="glyphicon glyphicon-search" aria-hidden="true"></span>	 	
    			 </td>
    		</tr>
    	</table>
    </form>
    </center>
  </body>
</html>
