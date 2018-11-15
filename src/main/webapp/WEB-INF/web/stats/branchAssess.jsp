<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>分部考核</title>
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
	<div class="layui-tab" lay-filter="demo" style="width: 95%;margin: 30px auto;">
			<ul class="layui-tab-title">
				<li class="layui-this" style="width: 15%;color: #999;font-size: 16px;font-weight: bold;">周报</li>
				<li style="width: 15%;color: #999;font-size: 16px;font-weight: bold;">日报</li>
			</ul>
		<div class="layui-tab-content">	
		<div class="layui-tab-item layui-show">
		<div class="recordhead">
				<strong>查询：</strong>
				<button>Excel导出</button>
			</div>
		<blockquote class="news_search">
			<div class="layui-inline">
				<label class="layui-form-label">所属分部：</label>
				<div class="layui-input-inline">
					<select name="setion" class="ssfb" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="">所有状态</option>
						<option value="1">启用</option>
						<option value="0">未启用</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">所属分区：</div>
				<div class="layui-input-inline">
					<select name="setion" class="ssfq" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
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
			<table class="layui-table" style="min-width: 2500px;">
				<thead>
					<tr>
						<th rowspan="2">NO.1</th>
						<th rowspan="2">日期</th>
						<th rowspan="2">分部</th>
						<th colspan="7">新增用户</th>
						<th colspan="7">出账收入</th>
						<th colspan="7">离网用户人数</th>
						
					</tr>
					<tr>
						<th>2G</th>
						<th>3G</th>
						<th>存费送机</th>
						<th>购机赠费</th>
						<th>自备机</th>
						<th>上网卡</th>
						<th>合计</th>
						<th>2G</th>
						<th>3G</th>
						<th>存费送机</th>
						<th>购机赠费</th>
						<th>自备机</th>
						<th>上网卡</th>
						<th>合计</th>
						<th>2G</th>
						<th>3G</th>
						<th>存费送机</th>
						<th>购机赠费</th>
						<th>自备机</th>
						<th>上网卡</th>
						<th>合计</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
	</div>
	<div class="layui-tab-item">
	<div class="recordhead">
				<strong>查询：</strong>
				<button>Excel导出</button>
			</div>
		<blockquote class="news_search">
			<div class="layui-inline">
				<label class="layui-form-label">所属分部：</label>
				<div class="layui-input-inline">
					<select name="setion" class="ssfb" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="">所有状态</option>
						<option value="1">启用</option>
						<option value="0">未启用</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">所属分区：</div>
				<div class="layui-input-inline">
					<select name="setion" class="ssfq" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
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
			<table class="layui-table" style="min-width: 2500px;">
				<thead>
					<tr>
						<th rowspan="2">NO.1</th>
						<th rowspan="2">日期</th>
						<th rowspan="2">分部</th>
						<th colspan="7">新增用户</th>
						<th colspan="7">出账收入</th>
						<th colspan="7">离网用户人数</th>
						
					</tr>
					<tr>
						<th>2G</th>
						<th>3G</th>
						<th>存费送机</th>
						<th>购机赠费</th>
						<th>自备机</th>
						<th>上网卡</th>
						<th>合计</th>
						<th>2G</th>
						<th>3G</th>
						<th>存费送机</th>
						<th>购机赠费</th>
						<th>自备机</th>
						<th>上网卡</th>
						<th>合计</th>
						<th>2G</th>
						<th>3G</th>
						<th>存费送机</th>
						<th>购机赠费</th>
						<th>自备机</th>
						<th>上网卡</th>
						<th>合计</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
	</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/stats/branchAssess.js"></script>
	</body>
</html>