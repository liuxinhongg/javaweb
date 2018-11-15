<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>SIM卡管理</title>
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
		    	<label class="layui-form-label">卡号查询：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="simnumber" type="text" name="simnumber" autocomplete="off" placeholder="卡号查询" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
			    <label class="layui-form-label"></label>
				<div class="layui-input-inline" style="width: 150px;">
						<input id="opertype" type="radio" name="opertype"  value="1" title="分配" checked="true">分配 &nbsp;&nbsp;
						<input id="opertype" type="radio" name="opertype"  value="0" title="回收">回收
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label">起始号码：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="ksvcnumber" type="text" name="ksvcnumber" autocomplete="off" placeholder="起始号码" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label">结束号码：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input  id="jsvcnumber" type="text" name="jsvcnumber" autocomplete="off" placeholder="结束号码" class="layui-input search_input">
				</div>
		    </div>
            <div class="layui-inline">
		    	<label class="layui-form-label">号码状态：</label>
				<div class="layui-input-inline">
			         <select id="status" name="status" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部状态</option>
						 <option value="1">可用</option>
                         <option value="0">不可用</option>
                      </select>
		        </div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label">批次号：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="snno" type="text" name="snno" autocomplete="off" placeholder="批次号" class="layui-input search_input">
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
				<col width="250">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>Sim卡号码</th>
					<th>当前所在部门</th>
					<th>操作类型</th>
					<th>状态</th>
                    <th>批次</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">
               
           </tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/js/system/carmanage.js"></script>
</body>
</html>