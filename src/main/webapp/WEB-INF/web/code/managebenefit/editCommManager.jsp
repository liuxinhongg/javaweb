<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>编辑管理津贴标准</title>
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
			<input type="hidden" id="codeId" name="codeId" value="${commManagerPo.codeId}">
			<input type="hidden" id="t_status" name="t_status" value="${commManagerPo.status}">
			<table class="layui-table">
				<colgroup>
					<col width="40%">
					<col width="60%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">总话费数额<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="commMin" name="commMin" value="${commManagerPo.commMin}" class="layui-input Usernum" lay-verify="required" placeholder="" style="display:inline;width:90px;">至
						    <input type="text" id="commMax" name="commMax" value="${commManagerPo.commMax}" class="layui-input Usernum" lay-verify="required" placeholder="" style="display:inline;width:90px;">元
						</td>
					</tr>
                    <tr>
						<td align="right">提成比例<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="commRate" name="commRate" value="${commManagerPo.commRate}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:210px;">%
						</td>
					</tr>
					<tr>
						<td align="right">排序<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="ord" name="ord" value="${commManagerPo.ord}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:220px;">
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
						<td style="text-align: right;">
						    <button class="layui-btn" lay-submit="" lay-filter="addLinks">确认</button>
						</td>
						<td>
							<button type="reset" class="layui-btn layui-btn-primary">取消</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editmanagebenefit.js"></script>
</body>
</html>