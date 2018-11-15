<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>套餐</title>
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
		    	<label class="layui-form-label">套餐名称：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="productName" name="productName" autocomplete="off" placeholder="请输入套餐名称" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
		    	<div class="layui-form-label">套餐类型：</div>
		        <div class="layui-input-inline">
			     <select id="productType" name="productType" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
                      </select>
		      </div>
			 </div>
			  <div class="layui-inline">
		    	<div class="layui-form-label">套餐状态：</div>
		        <div class="layui-input-inline">
			          <select id="isView" name="isView" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
						 <option value="1">显示</option>
                         <option value="2">屏蔽</option>
                      </select>
		      </div>
			 </div>
			 <div class="layui-inline">
		    	<div class="layui-form-label">中高端：</div>
		        <div class="layui-input-inline">
			          <select id="isIh" name="isIh" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
						 <option value="1">是</option>
                         <option value="0">否</option>
                      </select>
		      </div>
			 </div>
             <div class="layui-inline">
		    	<div class="layui-form-label">考核：</div>
		        <div class="layui-input-inline">
			          <select id="isKh" name="isKh" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
						 <option value="1">是</option>
                         <option value="0">否</option>
                      </select>
		      </div>
			 </div>
			 <a class="layui-btn search_btn">查询</a>
		</blockquote>
		<div class="layui-block backBtn">
            <div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn linksAdd_btn" style="background-color:#5FB878">添加</a>
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
		    </colgroup>
		    <thead>
				<tr>
				    <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>套餐名称</th>
					<th>套餐类型</th>
					<th>带四折算量</th>
					<th>不带四折算量</th>
					<th>现场激活折算量</th>
					<th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		   <tbody class="links_content"></tbody>
		</table>
	</div>
	
    <div id="page"></div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/code/product.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>