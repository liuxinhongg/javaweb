<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Sim卡导入</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
</head>
<body class="childrenBody">
 <blockquote class="layui-elem-quote news_search">SIM卡导入（<span style="color:red">数据格式：所有数据列都是字符类型</span>）</blockquote>
	<div style="padding-bottom:40px;">
       <form class="layui-form" style="width:80%;margin:auto;">
			<table class="layui-table">
				<colgroup>
					<col>
				</colgroup>
               <thead>
                <tr>
					<th>数据模板</th>
				</tr> 
		    </thead>
				<tbody>
					<tr>
						<td align="center">
							<img src="${pageContext.request.contextPath}/static/images/ex02.jpg" alt="" />
						</td>
					</tr>
                    <tr>
						<td align="left" colspan="2">
                            选择文件<span style="color: #f00;"></span>
                            <input type="text" class="layui-input mobilePhone" lay-verify="required" style="width:220px;display:inline" placeholder="请选择文件">
							<input type="file" class="layui-btn-small" value="浏览">
						</td>
					</tr>
                    <tr>
						<td align="left" colspan="2">
                            选择部门<span style="color: #f00;"></span>
                            <input type="text" class="layui-input mobilePhone" lay-verify="required" style="width:220px;display:inline" placeholder="请选择部门">
							<input type="button" class="layui-btn layui-btn-small" value="选择" onclick="openBranch();">
                            <button class="layui-btn layui-btn-small" lay-submit="" lay-filter="addLinks">保存</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
     </div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/cardIn.js"></script>
</body>
</html>