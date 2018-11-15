<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>已欠费用户查询</title>
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
		<div class="recordhead">
			<strong>套餐到期用户</strong>
			<button>Excel导出</button>
		</div>
		<blockquote class="news_search">
			<div class="layui-inline">
				<div class="layui-inline">
					<div class="layui-form-label">开卡时间段：</div>
					<div class="layui-input-inline" style="width: 150px;">
						<input type="text" value="" placeholder="" lay-verify="required|datetime" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" class="layui-input starttime">
					</div>
				</div>
				<div class="layui-inline">
					至
					<div class="layui-input-inline" style="width: 150px;">
						<input type="text" value="" placeholder="" lay-verify="required|datetime" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" class="layui-input endtime">
					</div>
					<button class="thismonth">本月</button>
					<button class="thisJD">本季度</button>
					<button class="thisBN">近半年</button>
					<button class="thisYear">今年</button>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">复选框：</label>
				<div class="layui-input-block" style="margin-left: 0px;">
					<label><input type="checkbox" style="margin-top: 14px;">2G语音卡</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">3G语音卡</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">3G上网</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">4G语音卡</label>
				</div>
			</div>
			<div class="layui-block" align="right">
			    <a class="layui-btn layui-btn-primary tccx">已欠费用户查询</a>
				<a class="layui-btn search_btn" >查询</a>
			</div>
		</blockquote>
		<form class="layui-form links_list">
			<div class="layui-block" align="right">
				<div class="layui-input-inline" style="margin-left: 0px;">
					<input type="checkbox" name="" title="用户" lay-skin="primary">
                    <input type="checkbox" name="" title="代理人" lay-skin="primary"> 
                    <input type="checkbox" name="" title="区域经理" lay-skin="primary">
                    <input type="checkbox" name="" class="allBtn" title="全部" lay-skin="primary"> 
				</div>
				<a class="layui-btn layui-btn-primary tccx">发送</a>
			</div>
			<table class="layui-table">
				<thead>
					<tr>
						<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
						<th>月份</th>
						<th>用户手机号码</th>
						<th>销售时间</th>
						<th>业务类型</th>
						<th>套餐名称</th>
						<th>套餐剩余时间</th>
						<th>套餐续费提醒</th>
						<th>套餐短信提醒</th>
						<th>号码状态</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</form>
		<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/stats/userArrearage.js"></script>
	</body>

</html>