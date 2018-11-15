<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>角色添加</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/news.css" />
	</head>
	<body class="childrenBody">
		<div class="layui-form" style="width:40%;">
			<table class="layui-table">
			  <colgroup>
			    <col width="20%">
			    <col width="30%">
			  </colgroup>
			  <tbody>
			    <tr>
			      <td>角色ID<span style="color: #f00;">*</td>
			      <td>
					<input type="tel" id="roleid" class="layui-input roleid" lay-verify="required|id" placeholder="请输入角色ID">
					
			      </td>
			    </tr>
			    <tr>
			      <td>角色名称<span style="color: #f00;">*</span></td>
			      <td>
					<input type="tel" id="rolename" class="layui-input rolename" lay-verify="required" placeholder="请输入角色名称">
			      </td>
			    </tr>
			    <tr>
			      <td>上级角色</td>
			      <td>
				    <select name="parentId" id="parentId" class="parentId">
				         <option value="">无</option>
				    </select>
			      </td>
			    </tr>
			    <tr>
			      <td>备注</td>
			      <td>
					<textarea placeholder="请输入站点描述"  id="memo" class="layui-textarea linksDesc"></textarea>
			      </td>
			    </tr>
			    <tr>
			      <td align="right">
			      </td>
			      <td align="left">
			      <button class="layui-btn" lay-submit="" lay-filter="addroleLinks" lay-verify="errorcodeverify">确认</button>
			      </td>
			 
			    </tr>
			  </tbody>
			</table>
		</div>
		<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/add_role.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/layui-xtree.js"></script>
	</body>
</html>