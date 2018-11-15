<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<title>分部列表</title>
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
	        <input type="hidden" id="selectBranchName" name="selectBranchName">
	        <input type="hidden" id="selectBranchId" name="selectBranchId">
			<div class="layui-inline">
		    	<label class="layui-form-label">部门名称：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="branchName" name="branchName" autocomplete="off" placeholder="请输入名称" class="layui-input search_input">
				</div>
		    </div>
			 <a class="layui-btn search_btn">查询</a>
		</blockquote>
	    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup> 
		        <col width="50"> 
				<col>
				<col>
				<col>
				<col>
				<col>
		    </colgroup>
		    <thead>
				<tr>
				    <th></th>
				    <th>部门/分部/分区名称</th>
				</tr> 
		    </thead>
		    <tbody class="links_content"></tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/org/branch_open.js"></script>
</body>
</html>