<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>话费提成标准编辑</title>
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
			<input type="hidden" id="codeId" name="codeId" value="${commCallPo.codeId}">
			<input type="hidden" id="t_status" name="t_status" value="${commCallPo.status}">
			<table class="layui-table">
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">销售业绩<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="commMin" name="commMin" value="${commCallPo.commMin}" class="layui-input Usernum" lay-verify="required" placeholder="" style="display:inline;width:90px;">至
						    <input type="text" id="commMax" name="commMax" value="${commCallPo.commMax}"  class="layui-input Usernum" lay-verify="required" placeholder="" style="display:inline;width:90px;">元
						</td>
					</tr>
                   <tr>
						<td align="right">首年提成比例(%)<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="firstYRate" name="firstYRate" value="${commCallPo.firstYRate}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:220px;">%
						</td>
					</tr>
					<tr>
						<td align="right">次年提成比例(%)<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="secondYRate" name="secondYRate" value="${commCallPo.secondYRate}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:220px;">%
						</td>
					</tr>
                    <tr>
						<td align="right">排序<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="ord" name="ord"  value="${commCallPo.ord}" class="layui-input Usernum" lay-verify="required" placeholder="请输入排序">
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
						<td style="text-align: center;" colspan="2">
						    <button class="layui-btn" lay-submit="" lay-filter="addLinks">确认</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editCommCall.js"></script>
</body>
</html>