<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <html>
	<head>
		<meta charset="utf-8">
		<title>角色列表</title>
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
				<label class="layui-form-label"> 角色ID：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="roleId" type="text" name="" autocomplete="off" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label"> 角色姓名：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="roleName" type="text" name="" autocomplete="off" class="layui-input search_name">
				</div>
			</div>
			<div class="layui-inline">
				<a class="layui-btn search_btn">查询</a>
			</div>
		</blockquote>
		<div class="layui-block backBtn" align="right">
			<div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn linksAdd_btn" style="background-color:#5FB878">添加用户</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
			</div>
		</div>
		<div class="layui-form links_list">
			<table class="layui-table">
				<colgroup>
					<col width="50">
					<col width="20%">
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
						<th style="text-align:left;">角色ID</th>
						<th>角色名称</th>
						<th>上级角色ID</th>
						<th>备注</th>
						<th>修改人</th>
						<th>修改时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
	 <div id="page"></div>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/role.js"></script>
  </body>
</html>