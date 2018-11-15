<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>血缘查询</title>
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
		    <div class="layui-inline">
			    <label class="layui-form-label">业务代码：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="noId" name="noId" autocomplete="off" placeholder="请输入业务代码" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label">姓名：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="agentName" name="agentName" autocomplete="off" placeholder="请输入姓名" class="layui-input search_input">
				</div>
		    </div>
			 <div class="layui-inline">
		    	<div class="layui-form-label">层级：</div>
		        <div class="layui-input-inline"><input type="text" id="lvl" name="lvl" autocomplete="off" placeholder="请输入层级" class="layui-input search_input"></div>      
		    </div>
            <div class="layui-inline">
		    	<div class="layui-form-label">职级：</div>
		        <div class="layui-input-inline">
			   <select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">所有职级</option>
						 <option value="8">分区经理</option>
                         <option value="0">资深行销总监</option>
						 <option value="1">行销总监</option>
						 <option value="2">行销总监</option>
						 <option value="3">高级客户经理</option>
						 <option value="4">客户经理</option>
						 <option value="5">客户主任</option>
						 <option value="6">客户指导</option>
						 <option value="7">客户代表</option>
                      </select>
		      </div>
			</div>
			 <a class="layui-btn search_btn">查询</a>
		</blockquote>
		<div class="layui-block backBtn">
            <div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn layui-btn-primary batchFlash">刷新</a>
			</div>
            <div class="layui-inline">
				<a class="layui-btn layui-btn-normal batchExport">excel导出</a>
			</div>
		</div>
	    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>
				<col>
				<col>
				<col>
				<col>
				<col>
		    </colgroup>
		    <thead>
				<tr>
					<th>所在部门</th>
					<th>姓名</th>
					<th>职级</th>
					<th>所在层级</th>
					<th>血缘</th>
				</tr> 
		    </thead>
            <tbody class="links_content"></tbody>
		</table>
	</div>
    <div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/org/rank.js"></script>
</body>
</html>