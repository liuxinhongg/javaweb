<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>话费补贴</title>
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
				<strong>岗位津贴标准：（凡持有“本地联通手机号码（统称为“业务代理卡”）”的业务代理人员）</strong>
				<a class="layui-btn linksAdd_btn" style="background-color:#5FB878">新增</a>
			</div>
	    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>
		    <thead>
				<tr>
				    <th>序号</th>
					<th>销售业绩（个）</th>
					<th>送费额度（元）</th>
					<th>设置人ID</th>
					<th>设置时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		     <tbody class="links_content content1"></tbody>
		</table>
	</div>
	<div id="page"></div>
	<div class="recordhead">
			<strong>话费补助领取说明：</strong>
			<a class="layui-btn linksAdd_btn1" style="background-color:#5FB878" >添加</a>
	</div>
    <div class="layui-block backBtn">
            <div class="layui-inline" style="margin-right: 1%;">
				
			</div>
    </div>
    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <thead>
				<tr>
				    <th>序号</th>
					<th>项目</th>
					<th>数量</th>
					<th>业务数量（笔）</th>
					<th>说明</th>
                    <th>设置ID</th>
                    <th>设置时间</th>
                    <th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		     <tbody class="links_content content2"></tbody>
		</table>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/code/tellBill.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>