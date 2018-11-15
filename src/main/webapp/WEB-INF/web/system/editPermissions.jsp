<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>角色授权</title>
		<meta name="description" content="">
		<meta name="keywords" content="">
		<link href="" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/layui2/css/layui.css" />
		<style type="text/css">
			.layui-disabled{background:#f2f2f2;color: #595963!important;}
		</style>
	</head>

	<body class="layui-row">
		<blockquote class="layui-elem-quote news_search">
			<div class="layui-inline">
				<label class="layui-form-label">角色ID：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="roleId" name="roleId" autocomplete="off" class="layui-input search_input layui-disabled" value="角色id" disabled >
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">角色姓名：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text"  id="roleName" name="roleName" autocomplete="off" class="layui-input search_name layui-disabled" value="角色姓名" disabled>
				</div>
			</div>

			<div class="layui-inline" style="float: right;margin-right: 10%;">
			<button class="layui-btn" lay-submit="" lay-filter="updatePermissions">提交</button>
			</div>
		</blockquote>
		<div id="demo"></div>
	</body>
	<script src="${pageContext.request.contextPath}/static/layui2/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/js/system/edit_permissions.js" type="text/javascript" charset="utf-8"></script>

</html>