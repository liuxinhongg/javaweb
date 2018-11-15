<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>分区经理排行</title>
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
				<strong>分区经理排行</strong>
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
		<div class="layui-block backBtn">
			<div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn layui-btn-danger">业绩排序</a>
				<select name="setion" style="width: 120px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
					<option value="11">时间</option>
					<option value="20">业绩</option>
				</select>
			</div>
		</div>
		<div class="layui-form links_list" >
			<table class="layui-table" style="min-width: 4000px;">
				<thead>
					<tr>
						<th>NO.1</th>
						<th>月份</th>
						<th>所属部门</th>
						<th>分区</th>
						<th>姓名</th>
						<th>业务编码</th>
						<th>总销量</th>
						<th>2G销售</th>
						<th>3G销售</th>
						<th>4G销售</th>
						<th>固网销售</th>
						<th>代理卡</th>
						<th>4G代理卡</th>
						<th>3G存费送机</th>
						<th>4G存费送机</th>
						<th>上网卡销量</th>
						<th>动力值</th>
						<th>新增动力值</th>
						<th>新增编号</th>
						<th>50面值</th>
						<th>100面值</th>
						<th>200面值</th>
						<th>300面值</th>
						<th>400面值</th>
						<th>合计</th>
						<th>是否校园</th>
						<th>面值</th>
						<th>三无面值</th>
						<th>三无总销量</th>
						<th>三无2G销量</th>
						<th>三无3G销量</th>
						<th>三无代理卡</th>
						<th>三无4G销量</th>
						<th>三无存费送机</th>
						<th>三无上网卡</th>
						<th>三无动力卡</th>
						<th>三无新增动力卡</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/stats/branchRank.js"></script>
	</body>
</html>