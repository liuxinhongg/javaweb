<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>选择终端</title>
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
		<blockquote class="news_search">
			<div class="layui-inline">
				<label class="layui-form-label"> 终端名称：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="" autocomplete="off" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">终端类型：</label>
				<div class="layui-input-inline">
					<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="1">启用</option>
						<option value="0">未启用</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<a class="layui-btn search_btn">查询</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-normal">选择</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn  layui-btn-danger">关闭</a>
			</div>
			<div class="recordhead" style="margin-bottom: 0px;"></div>
		</blockquote>
		<div class="layui-form links_list" style="width: 80%;margin: auto;">
			<table class="layui-table">
				<colgroup>
					<col width="10%">
					<col width="15%">
					<col width="40%">
					<col width="10%">
					<col width="15%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<td></td>
						<th>终端编号</th>
						<th>终端名称</th>
						<th>提成</th>
						<th>单价</th>
						<th>终端类型</th>
					</tr>
				</thead>
				<tbody class="links_content">
					<tr>
						<td><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></td>
						<td>2345</td>
						<td>至尊宝太快80七彩39.89元套餐</td>
						<td>30.0</td>
						<td>299.0</td>
						<td>手机终端</td>
					</tr>
				</tbody>
			</table>
			<div id="demo7"></div>
		</div>
		<script src="${pageContext.request.contextPath}/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		 <script src="${pageContext.request.contextPath}/static/js/system/branch.js" type="text/javascript" charset="utf-8"></script> 
		<style type="text/css">
			layui.use(['laypage', 'layer'], function() {
				var laypage=layui.laypage, layer=layui.layer;
				laypage.render( {
					elem: 'demo7', count: 100, layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'], jump: function(obj) {
						console.log(obj)
					}
				});
			})
		</style>
	</body>

</html>