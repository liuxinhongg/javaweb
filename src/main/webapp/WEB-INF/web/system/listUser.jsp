<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户列表</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/news.css" media="all" />
	</head>

	<body class="childrenBody">
		<blockquote class="layui-elem-quote news_search">

			<div class="layui-inline">
				<label class="layui-form-label"> 用户工号：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="staffId" type="text" name="" autocomplete="off" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label"> 用户姓名：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="loginName" type="text" name="" autocomplete="off" class="layui-input search_name">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">状态：</label>
				<div id="state" class="layui-input-inline">
					<select id="state" name="setion" style="width: 150px;height: 
					38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="1" selected>启用</option>
						<option value="0">未启用</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<a class="layui-btn search_btn" >查询</a>
			</div>
		</blockquote>
		<div class="layui-block backBtn" align="right">
			<div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn linksAdd_btn" style="background-color:#5FB878">添加用户</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger batchDel">批量注销</a>
			</div>
			</div>
		<div class="layui-form links_list">
			<table class="layui-table">
				<colgroup>
					<col width="50">
					<col width="30%">
					<col>
					<col>
					<col>
					<col>
					<col>
					<col width="13%">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
						<th style="text-align:left;">用户工号</th>
						<th>用户姓名</th>
						<th>所在部门</th>
						<th>状态</th>
						<th>注册时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="links_content" id="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/user.js"></script>
	</body>
</html>