<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>注册用户</title>

<link rel="stylesheet" href="css/UserReg.css" type="text/css">

</head>

<body>

	<div id="Layer1" style="position:absolute; left:0px; top:0px;width:100%; height:100%; z-index:-1">    
	<img src="image/background.jpg" height="100%" width="100%"/>    
	</div>

<div id="mycontainer">

<br><br><br>

<div class="label">注册</div>

<br><br>

<div id="tw-outer">

<div id="tw">

					<form action="regist" method="post">

						<div id='name' class='outerDiv'>

							<label for="name">
								用户名:
							</label>

							<input type="text" name="name" required />

							<div class='message' id='nameDiv'>
								普通用户输入用户名
							</div>

						</div>


						<div class='clearfix'></div>

						<div id='password' class='outerDiv'>

							<label for="password">
								密码:
							</label>

							<input type="password" name="password" required />

							<div class='message' id='websiteDiv'>
								请输入至少6位的密码
							</div>

						</div>

						<div class='clearfix'></div>

						<div id='confirpassword' class='outerDiv'>

							<label for="number">
								确认密码:
							</label>

							<input type="password" name="confirpassword" required />

							<div class='message' id='usernameDiv'>
								请确保您的密码输入无误
							</div>

						</div>

						<div class='clearfix'></div>

						<div id='email' class='outerDiv'>

							<label for="email">
								Email:
							</label>

							<input type="email" name="email" required />

							<div class='message' id='emailDiv'>
								我们会给您发送最新的折扣商品信息.
							</div>

						</div>
						<div class='clearfix'></div>

						<div id='telephone' class='outerDiv'>

							<label for="telephone">
								手机：
							</label>

							<input type="text" name="telephone" required />

							<div class='message' id='websiteDiv'>
								输入手机号，方便我们给您推荐最划算的产品
							</div>

						</div>
						
						<div class='clearfix'></div>

						<div id='usercity' class='outerDiv'>

							<label for="usercity">
								所在城市：
							</label>

							<input type="text" name="usercity" value="北京市" required />

							<div class='message' id='websiteDiv'>
								当前只支持北京市
							</div>

						</div>
						
						
						<div class='clearfix'></div>

						<div id='userblock' class='outerDiv'>

							<label for="userblock">
								所在区域：
							</label>

							<input type="text" name="userblock" required />

							<div class='message' id='websiteDiv'>
								精确到区即可，比如：海淀区
							</div>

						</div>
						
						
						<div class='clearfix'></div>

						<div id='userstreet' class='outerDiv'>

							<label for="userstreet">
								具体地址：
							</label>

							<input type="text" name="userstreet" required />

							<div class='message' id='websiteDiv'>
								请输入具体地址，精确到小区即可
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
