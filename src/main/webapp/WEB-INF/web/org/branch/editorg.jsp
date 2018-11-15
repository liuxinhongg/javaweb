<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>分部编辑</title>
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
			<input type="hidden" id="id" name="id" value="${branchPo.id}">
			<input type="hidden" id="upId" name="upId" value="10000000">
			<input type="hidden" id="city" name="city" value="${branchPo.branchCity}">
			<table class="layui-table">
				<colgroup>
					<col width="35%">
					<col width="65%">
				</colgroup>
				<tbody>
				    <tr>
						<td align="right">部门类目<span style="color: #f00;">*</span></td>
						<td>
							<input type="radio" name="branchCity" title="昆明" value="0" class="layui-input Usernum"  lay-verify="required">
							<input type="radio" name="branchCity" title="地州/市" value="1" class="layui-input Usernum" lay-verify="required">
						</td>
					</tr>
					<tr>
						<td align="right">分部名称<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" name="branchName" id="branchName" value="${branchPo.branchName}" class="layui-input Usernum" lay-verify="required" placeholder="某某分部" maxlength="20">
						</td>
					</tr>
					<tr style="display:none;">
						<td align="right">分部经理<span style="color: #f00;">*</span></td>
						<td>
						    <input type="hidden" id="noId" name="noId" value="${branchPo.noId}">
						    <input type="text" id="agentName" name="agentName" value="${branchPo.agentName}" class="layui-input mobilePhone" lay-verify="required" style="width:82%;display:inline" placeholder="请选择">
							<input type="button" class="layui-btn layui-btn-small" onclick="selectAgent();" value="选择">
						</td> 
					</tr>
					<tr>
						<td align="right">任命时间<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="effectMonth" name="effectMonth" value="${branchPo.effectMonthView}" class="layui-input masterPart" placeholder="请输入任命时间" lay-verify="required|date" onclick="layui.laydate({elem: this,min: laydate.now(),format: 'YYYY-MM'})">
						</td>
					</tr>
					<tr>
						<td align="right">分部状态<span style="color: #f00;">*</span></td>
						<td>
							<select id="status" name="status" class="status" lay-verify="required">
								<option value="1" <c:if test="${branchPo.status == '1'} ">selected</c:if>>有效</option>
								<option value="0" <c:if test="${branchPo.status == '0'} ">selected</c:if>>无效</option>
							</select>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/org/editorg.js"></script>
</body>
</html>