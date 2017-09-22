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

<title>注册</title>

<link rel="stylesheet" href="css/UserReg.css" type="text/css">

</head><body>

	<div id="Layer1" style="position:absolute; left:0px; top:0px;width:100%; height:120%; z-index:-1">    
	<img src="image/background.jpg" height="100%" width="100%"/>    
	</div>

<div id="mycontainer">

<br><br><br>

<div class="label">注册管理员</div>

<br><br>

<div id="tw-outer">

<div id="tw">

					<form action="registadmin" method="post">

						<div id='name_admin' class='outerDiv'>

							<label for="name_admin">
								用户名:
							</label>

							<input type="text" name="name_admin" value="#" required />

							<div class='message' id='nameDiv'>
								请以#开头
							</div>

						</div>


						<div class='clearfix'></div>

						<div id='password_admin' class='outerDiv'>

							<label for="password_admin">
								密码:
							</label>

							<input type="password" name="password_admin" required />

							<div class='message' id='websiteDiv'>
								请输入至少6位的密码
							</div>

						</div>

						<div class='clearfix'></div>

						<div id='confirpassword_admin' class='outerDiv'>

							<label for="number">
								确认密码:
							</label>

							<input type="password" name="confirpassword_admin" required />

							<div class='message' id='usernameDiv'>
								请确保您的密码输入无误
							</div>

						</div>

						<div class='clearfix'></div>

						<div id='email_admin' class='outerDiv'>

							<label for="email_admin">
								Email:
							</label>

							<input type="email" name="email_admin" required />

							<div class='message' id='emailDiv'>
								我们会给您发送最新的折扣商品信息.
							</div>

						</div>
						<div class='clearfix'></div>

						<div id='telephone_admin' class='outerDiv'>

							<label for="telephone">
								手机：
							</label>

							<input type="text" name="telephone_admin" required />

							<div class='message' id='websiteDiv'>
								输入手机号，方便我们给您推荐最划算的产品
							</div>

						</div>
						
						<div class='clearfix'></div>

						<div id='marketname' class='outerDiv'>

							<label for="marketname">
								超市名：
							</label>

							<input type="text" name="marketname" required />

							<div class='message' id='websiteDiv'>
								请输入你所属的超市名称
							</div>

						</div>
						
						
						<div class='clearfix'></div>

						<div id='marketnum' class='outerDiv'>

							<label for="marketnum">
								序列号：
							</label>

							<input type="text" name="marketnum" required />

							<div class='message' id='websiteDiv'>
								请输入您超市的营业序列号
							</div>

						</div>
						
						<div class='clearfix'></div>

						<div id='marketcity' class='outerDiv'>

							<label for="marketcity">
								城市：
							</label>

							<input type="text" name="marketcity" value="北京市" required />

							<div class='message' id='websiteDiv'>
								当前只支持北京市
							</div>

						</div>
						
						<div class='clearfix'></div>

						<div id='marketarea' class='outerDiv'>

							<label for="marketarea">
								所在区名：
							</label>

							<input type="text" name="marketarea" required />

							<div class='message' id='websiteDiv'>
								请输入您超市所在的区，比如：海淀区
							</div>

						</div>
						<div class='clearfix'></div>
						
						<div id='marketblock' class='outerDiv'>

							<label for="marketblock">
								具体位置：
							</label>

							<input type="text" name="marketblock" required />

							<div class='message' id='websiteDiv'>
								请输入您超市的具体位置
							</div>

						</div>
						
						
						
						<div class='clearfix'></div>

						<div id='submit' class='outerDiv'>

							<input type="submit" value="注册帐号" />

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
