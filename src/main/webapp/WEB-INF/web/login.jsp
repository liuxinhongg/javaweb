<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>云南联通公众互联网营销部佣金系统</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/login.css"/>
	</head>
	<body>
		<div class="login">
			<div class="bg">
				<img src="${pageContext.request.contextPath}/static/images/bj.png" />
			</div>
			<div class="LoginBox">
				<div class="LoginTop">
					<p>公众互联网营销部佣金系统</p>
				</div>
				<div class="LoginContent">
					<div class="ContentLeft">
						<img src="${pageContext.request.contextPath}/static/images/zhongguoliantong.png" />
					</div>
					<div class="JBcolor"></div>
					<div class="ContentRight">
						<form class="">
						    <input type="hidden" id="remFlag" name="remFlag" value="false">
							<div class="userName">
								<img src="${pageContext.request.contextPath}/static/images/icon_yonghu.png" class="IconImg" />
								<input type="text" name="username" id="username" value=""  placeholder="请输入用户名"/>
							</div>
							<div class="userName">
								<img src="${pageContext.request.contextPath}/static/images/icon_mima.png" class="IconImg" />
								<input type="password" name="password" id="password" value="" placeholder="请输入密码"/>
							</div>
							<div class="ReWrite">
								<input type="reset" value="重置" class="CZnew"/>
								<p>
									<input type="checkbox" name="rememberMe" id="rememberMe"  onclick="remember();" />
									<span>记住密码</span>
								</p>
							</div>
							<input type="button" class="DLBtn" id="userlogin" value="登录" lay-submit="" lay-filter="userlogin"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/js/login.js" type="text/javascript" charset="utf-8"></script>
</html>