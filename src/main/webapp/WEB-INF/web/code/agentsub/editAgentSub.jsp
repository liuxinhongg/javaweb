<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>话费补贴标准添加</title>
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
			<form class="layui-form" >
			<input type="hidden" id="codeId" name="codeId" value="${commNewAgentPo.codeId}">
			<input type="hidden" id="t_status" name="t_status" value="${commNewAgentPo.status}">
			<table class="layui-table">
				<!--<colgroup>
					<col width="20%">
					<col width="10%">
					<col width="20%">
					<col width="30%">
				</colgroup>-->
				<tbody>
					<tr>
						<td align="right">补贴批次<span style="color: #f00;">*</span></td>
				     	<td><input type="text" id="codeDesc" name="codeDesc" value="${commNewAgentPo.codeDesc}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:220px;"></td>
					</tr>
                    <tr>
						<td align="right">发放补贴金额<span style="color: #f00;">*</span></td>
						<td ><input type="text" id="totalMoney" name="totalMoney" value="${commNewAgentPo.totalMoney}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:200px;">元</td>
						
					</tr>
					<tr>
						<td align="right">首月发放金额：</td>
                    	<td><input type="text" id="firstMMoney" name="firstMMoney" class="layui-input" value="${commNewAgentPo.firstMMoney}" style="display:inline;width:220px;"/>元</td>
					</tr>
					<tr>
						<td align="right">次月发放金额：</td>
                    	<td><input type="text" id="secondMMoney" name="secondMMoney" class="layui-input" value="${commNewAgentPo.secondMMoney}" style="display:inline;width:220px;"/>元</td>
					</tr>
					<tr>
						<td align="right">最后一月发放金额：</td>
                    	<td><input type="text" id="lastMMoney" name="lastMMoney" class="layui-input" value="${commNewAgentPo.lastMMoney}" style="display:inline;width:220px;"/>元</td>
					</tr>
					<tr>
						<td align="right">状态<span style="color: #f00;"></span></td>
						<td >
							<input type="radio" name="status"  value="1" title="有效" checked>
						    <input type="radio" name="status"  value="0" title="无效">
						</td>
					</tr>
					<tr>	
						<td style="text-align: right;">
						   
						</td>
						<td>
						     <button class="layui-btn" lay-submit="" lay-filter="addLinks">确定</button>&nbsp;&nbsp;&nbsp;
							<button type="reset" class="layui-btn layui-btn-primary">取消</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editagentsub.js"></script>
</body>
</html>