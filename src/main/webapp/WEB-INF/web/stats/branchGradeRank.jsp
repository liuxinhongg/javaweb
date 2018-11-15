<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>分区业绩排行</title>
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
				<strong>分区业绩排行：</strong>
				<button>Excel导出</button>
			</div>
		<blockquote class="news_search">
			<div class="layui-inline">
				<label class="layui-form-label">所属分部：</label>
				<div class="layui-input-inline">
					<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="">所有状态</option>
						<option value="1">启用</option>
						<option value="0">未启用</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">所属分区：</div>
				<div class="layui-input-inline">
					<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="">所有方式</option>
						<option value="0">营业厅办理</option>
						<option value="1">业务员推荐</option>
					</select>
				</div>
			</div>
			

			<div class="layui-inline">
				<div class="layui-inline">
					<div class="layui-form-label">开卡时间段：</div>
					<div class="layui-input-inline" style="width: 150px;">
						<input type="text" value="" placeholder="" lay-verify="required|datetime" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					至
					<div class="layui-input-inline" style="width: 150px;">
						<input type="text" value="" placeholder="" lay-verify="required|datetime" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" class="layui-input">
					</div>
					<button class="thismonth">本月</button>
					<button class="thisJD">本季度</button>
					<button class="thisBN">近半年</button>
					<button class="thisYear">今年</button>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">范围：</div>
				<div class="layui-input-inline">
					<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="">昆明</option>
						<option value="0">地州/市</option>
					</select>
				</div>
			</div>
			<a class="layui-btn search_btn">查询</a>
		</blockquote>
		
		<div class="layui-form links_list" >
			<table class="layui-table" style="min-width: 2000px;">
				<thead>
					<tr>
						<th>NO.1</th>
						<th>月份</th>
						<th>分区</th>
						<th>是否校园</th>
						<th>所属分部</th>
						<th>所属分区</th>
						<th>销售量</th>
						<th>业务代理卡数量</th>
						<th>4G代理卡销量</th>
						<th>2G销售量</th>
						<th>3G销售量(含上网卡)</th>
						<th>3G存费送机销量</th>
						<th>4G存费送机销量</th>
						<th>折算量</th>
						<th>销售额</th>
						<th>面值</th>
						<th>对账金额</th>
						<th>活动金额</th>
						<th>三无4G代理卡销量</th>
						
						
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/stats/branchGradeRank.js"></script>
	</body>
</html>