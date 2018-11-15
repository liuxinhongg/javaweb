<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>用户明细查询列表</title>
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
			<strong>用户明细查询</strong>
			<button>Excel导出</button>
		</div>
		<blockquote class="news_search">
			<div class="layui-inline">
				<label class="layui-form-label">关键字：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="" autocomplete="off" placeholder="关键字" class="layui-input search_input">
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
			<div class="layui-form-item">
				<label class="layui-form-label">复选框：</label>
				<div class="layui-input-block" style="margin-left: 0px;">
					<label><input type="checkbox" style="margin-top: 14px;">2G语音卡</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">3G语音卡</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">3G上网</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">4G语音卡</label>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">查询区域：</label>
				<div class="layui-input-block" style="margin-left: 0px;">
					<label><input type="checkbox" style="margin-top: 14px;">用户号码</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">SIM卡</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">套餐</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">终端</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">号码状态</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">分部</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">分区</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">分区编号</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">分区经理编号</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">分区经理姓名</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">业务代码</label>
					<label><input type="checkbox" style="margin-top: 14px;margin-left: 20px;">代理人姓名</label>
				</div>
			</div>
			<div class="layui-block" align="right">
				<div class="layui-input-inline">
					<select name="setion" class="message" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="01">短信提醒</option>
						<!--<option value="">所有需提醒的用户</option>
						<option value="1">套餐到期用户</option>
						<option value="0">已欠费用户</option>-->
					</select>
				</div>
			<a class="layui-btn search_btn">查询</a>
			</div>
		</blockquote>

		<div class="layui-form links_list">
			<table class="layui-table" style="min-width: 3000px;">
				<thead>
					<tr>
						<th>NO.1</th>
						<th>月份</th>
						<th>用户手机号码</th>
						<th>SIM卡</th>
						<th>销售时间</th>
						<th>所属分部</th>
						<th>所属分区</th>
						<th>分区编号</th>
						<th>分区经理名称</th>
						<th>代理人业务编号</th>
						<th>业务类型</th>
						<th>套餐名称</th>
						<th>是否三无用户</th>
						<th>面值</th>
						<th>折算量</th>
						<th>活动金额</th>
						<th>对账金额</th>
						<th>套餐剩余时间</th>
						<th>套餐续费提醒</th>
						<th>套餐短信提醒</th>
						<th>已欠费</th>
						<th>续费提醒</th>
						<th>续费短信提醒</th>
						<th>号码状态</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/stats/userDetails.js"></script>
	</body>

</html>