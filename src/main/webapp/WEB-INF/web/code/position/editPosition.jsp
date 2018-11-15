<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>岗位津贴标准编辑</title>
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
			<form class="layui-form" style="width:95%;margin:auto">
			<input type="hidden" id="id" name="id" value="${positionPo.id}">
			<input type="hidden" id="t_status" name="t_status" value="${positionPo.status}">
			<table class="layui-table">
				<colgroup>
					<col width="35%">
					<col width="65%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">职级<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="positionName"  name="positionName" value="${positionPo.positionName}" class="layui-input Usernum" required maxlength="20"  lay-verify="required" placeholder="请输入职级">
						</td>
					</tr>
                    <tr>
						<td align="right">岗位津贴<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="positionComm" name="positionComm" value="${positionPo.positionComm}" class="layui-input Usernum" required lay-verify="required" placeholder="请输入岗位津贴" style="display:inline;width:220px;">元/月
						</td>
					</tr>
                    <tr>
						<td align="right">排序<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="ord" name="ord" value="${positionPo.ord}" class="layui-input Usernum" required lay-verify="required" placeholder="请输入排序">
						</td>
					</tr>
					 <tr>
						<td align="right">状态<span style="color: #f00;"></span></td>
						<td colspan="3">
							<input type="radio" name="status"  value="1" title="有效" checked>
						    <input type="radio" name="status"  value="0" title="无效">
						</td>
					</tr>
                    <tr>
						<td align="right">描述</td>
						<td>
							<textarea id="positionDesc" name="positionDesc" class="layui-textarea linksDesc">${positionPo.positionDesc}</textarea>
						</td>
					</tr>
					<tr>	
						<td style="text-align: center;" colspan="2">
						    <button class="layui-btn" lay-submit="" lay-filter="addLinks">确认</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editPosition.js"></script>
</body>
</html>