<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>业务员列表</title>
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
		<blockquote class="news_search">
			<div class="recordhead">
				<strong></strong>
				<button>Excel导出</button>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">手机号：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="" autocomplete="off" placeholder="手机号" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">SIM卡号：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="" autocomplete="off" placeholder="姓名" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">代理人姓名：</div>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" value="" placeholder="推荐人" class="layui-input search_input">
				</div>
			</div>

			<div class="layui-inline">
				<div class="layui-form-label">业务代码：</div>
				<div class="layui-input-inline" style="width: 150px;"><input type="text" value="" placeholder="分区名称" class="layui-input search_input"></div>
			</div>
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
				<div class="layui-form-label">套餐：</div>
				<div class="layui-input-inline">
					<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="">所有职级</option>
						<option value="8">分区经理</option>
						<option value="0">资深行销总监</option>
						<option value="1">行销总监</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
			    <label class="layui-form-label">有无终端:</label>
			    <div class="layui-input-block" style="line-height:40px;">
			      <input type="radio" name="terminal" value="有" title="有" checked style="margin-top: 5px;">有
			     &nbsp;&nbsp; <input type="radio" name="terminal" value="无" title="无">无
			  </div>
			   </div>
			  <div class="layui-inline">
				<div class="layui-form-label">号码状态：</div>
				<div class="layui-input-inline">
					<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="11">拉黑</option>
						<option value="22">未使用</option>
						<option value="20">使用中</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
			    <label class="layui-form-label">是否激活:</label>
			    <div class="layui-input-block">
			      <input style="margin-top: 10px;" type="radio" name="code" value="是" checked>是
			     &nbsp;&nbsp; <input type="radio" name="code" value="否">否
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
		  &nbsp; &nbsp;<a class="layui-btn search_btn">查询</a>
		</blockquote>
		<div class="layui-block backBtn">
			<div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn" style="background-color:#5FB878">导出</a>
			</div>
			<div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn layui-btn-danger">业绩排序</a>
				<select name="setion" style="width: 120px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
					<option value="11">时间</option>
					<option value="20">业绩</option>
				</select>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger">开卡登记</a>
			</div>
		</div>
		<div class="layui-form links_list" style="min-width: 2000px;">
			<table class="layui-table">
				<colgroup>
					<col width="4%">
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
				</colgroup>
				<thead>
					<tr>
						<th>NO.1</th>
						<th>业务代码</th>
						<th>姓名</th>
						<th>卡号</th>
						<th>手机号</th>
						<th>销售面值</th>
						<th>活动全额</th>
						<th>对账金额</th>
						<th>折算量</th>
						<th>是否激活</th>
						<th>套餐</th>
						<th>终端</th>
						<th>终端提成</th>
						<th>销售日期</th>
						<th>状态</th>
						<th>操作人</th>
						<th>操作人所属部门</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/oper/listSale.js"></script>
	</body>

</html>