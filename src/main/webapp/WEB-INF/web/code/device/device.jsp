<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>终端</title>
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
	<blockquote class="layui-elem-quote news_search" >
			<div class="layui-inline">
		    	<label class="layui-form-label">终端名称：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="deviceName" name="deviceName" autocomplete="off" placeholder="请输入终端名称" class="layui-input search_input">
				</div>
		    </div>
			 <div class="layui-inline">
		    	<div class="layui-form-label">终端描述：</div>
		        <div class="layui-input-inline"><input type="text" id="deviceDesc" name="deviceDesc" autocomplete="off" placeholder="请输入终端描述" class="layui-input search_input"></div>      
		    </div>
			<div class="layui-inline">
		    	<div class="layui-form-label">终端类型：</div>
		        <div class="layui-input-inline">
			     <select id="deviceTypeCode" name="deviceTypeCode" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
                 </select>
		      </div>
			 </div>
			  <div class="layui-inline">
		    	<div class="layui-form-label">业务类型：</div>
		        <div class="layui-input-inline">
			          <select id="schemeTypeCode" name="schemeTypeCode" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
                      </select>
		      </div>
			 </div>
			 <div class="layui-inline">
		    	<div class="layui-form-label">终端状态：</div>
		        <div class="layui-input-inline">
			          <select id="status" name="status" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
						 <option value="1">有效</option>
                         <option value="0">无效</option>
                      </select>
		      </div>
			 </div>
			 <a class="layui-btn search_btn">查询</a>
		</blockquote>
		<div class="layui-block backBtn">
            <div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn linksAdd_btn" style="background-color:#5FB878">添加</a>
				<a class="layui-btn layui-btn-danger batchDel">删除</a>
				
			</div>
		</div>
	    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>
			    <col width="50">
				<col>
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
				    <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>终端名称</th>
					<th>终端描述</th>
					<th>终端类型</th>
					<th>业务类型</th>
					<th>提成</th>
					<th>单价</th>
                    <th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		     <tbody class="links_content"></tbody>
		</table>
	</div>
	
    <div id="page"></div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/code/device.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>