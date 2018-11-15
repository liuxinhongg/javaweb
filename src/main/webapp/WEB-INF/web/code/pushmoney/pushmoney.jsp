<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>业务提成</title>
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

	<body>
		<div class="layui-tab" style="width: 95%;margin: 30px auto;">
			<ul class="layui-tab-title">
				<li class="layui-this" style="width: 15%;color: #999;font-size: 16px;font-weight: bold;">一次性提成标准</li>
				<li style="width: 15%;color: #999;font-size: 16px;font-weight: bold;"><a href="javascript:open();">话费提成标准</a></li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<div class="recordhead">
						<strong></strong>
						<button class="linksAdd_btn">新增</button>
					</div>
					<div class="layui-form links_list">
						<table class="layui-table">
							<thead>
								<tr>
									<th>序号</th>
									<th>业务名称</th>
									<th>一次性提成比例(%)</th>
									<th>设置人ID</th>
									<th>设置时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody class="links_content content1"></tbody>
						</table>
					</div>
					<div id="page"></div>
					<div class="recordhead" style="margin-top: 50px;">
						<strong>一次性提成说明</strong>
						<a class="layui-btn linksAdd_btn1" style="background-color:#5FB878">添加</a>
					</div>
					<div class="layui-form links_list">
						<table class="layui-table">
							<thead>
								<tr>
								   <th>序号</th>
					               <th>项目</th>
					               <th>数量</th>
					               <th>业务数量（笔）</th>
					               <th>说明</th>
                                   <th>设置ID</th>
                                   <th>设置时间</th>
                                   <th>状态</th>
					               <th>操作</th>
								</tr>
							</thead>
							<tbody class="links_content content2"></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/code/pushmoney.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>