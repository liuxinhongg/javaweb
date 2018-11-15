<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE>
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
	<blockquote class="layui-elem-quote news_search">
	        <input type="hidden" id="selectAgentName" name="selectAgentName">
	        <input type="hidden" id="selectAgentNoId" name="selectAgentNoId">
			<div class="layui-inline">
		    	<label class="layui-form-label">姓名：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="agentName" name="agentName" autocomplete="off" placeholder="姓名" class="layui-input search_input">
				</div>
		    </div>
		    <div class="layui-inline">
			    <label class="layui-form-label">业务代码：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="noId" name="noId" autocomplete="off" placeholder="业务代码" class="layui-input search_input">
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
					<th>业务代码</th>
					<th>员工姓名</th>
					<th>所属分部</th>
					<th>所属分区</th>
					<th>员工等级</th>
				</tr> 
		    </thead>
		    <tbody class="links_content"></tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/org/branch_agent.js"></script>
</body>
</html>