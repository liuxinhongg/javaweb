<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>杰出贡献奖标准编辑</title>
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
		    <input type="hidden" id="codeId" name="codeId" value="${commContributionPo.codeId}">
			<input type="hidden" id="t_status" name="t_status" value="${commContributionPo.status}">
			<table class="layui-table">
				<colgroup>
					<col width="40%">
					<col width="60%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">项目名称：</td>
						<td>
							<input type="text" id="codeDesc" name="codeDesc" value="${commContributionPo.codeDesc}" maxlength="50" class="layui-input Usernum" lay-verify="required" style="display:inline;width:220px;">
						</td>
					</tr>
					<tr>
						<td align="right">业绩数量要求：</td>
						<td>
							X≥<input type="text" id="commMin" name="commMin" value="${commContributionPo.commMin}" class="layui-input layui-input-inline" lay-verify="required" style="width:20%">
							<div class="layui-input-inline" style="width: 120px;height: 35px;line-height: 35px;">
								万元、支、笔、个
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">奖励金额：</td>
						<td>
							<input type="text" id="commContribution" name="commContribution" value="${commContributionPo.commContribution}" class="layui-input layui-input-inline" style="width:40%">
							<div class="layui-input-inline" style="width: 60px;height: 35px;line-height: 35px;">
								元/个
							</div>
						</td>
					</tr>
					<tr>
						<td align="right">排序</td>
						<td>
							<input type="text" id="ord" name="ord" value="${commContributionPo.ord}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:220px;">
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
						</td>
						<td>
							<button class="layui-btn" lay-submit="" lay-filter="addLinks">确认</button>&nbsp;&nbsp;&nbsp;
							<button type="reset" class="layui-btn layui-btn-primary">取消</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editCommContribution.js"></script>
	</body>

</html>