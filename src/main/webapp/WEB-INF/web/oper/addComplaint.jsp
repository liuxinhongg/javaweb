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
			<form class="layui-form" style="width:95%;margin:auto">
			<table class="layui-table">
				<colgroup>
					<col width="40%">
					<col width="60%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">项目紧迫性</td>
						<td>
							<span style="color: #f00;">紧急</span>
						</td>
					</tr>
                    <tr>
						<td align="right">处理建议<span style="color: #f00;">*</span></td>
						<td>
							<textarea placeholder="请输入站点描述" class="layui-textarea"></textarea>
						</td>
					</tr>
					<tr>
						<td align="right">处理状态</td>
						<td>
							<select name="" class="uersex" lay-verify="required" >
								<option value="1">处理完毕</option>
								<option value="0">待处理</option>
								<option value="0">处理中，需跟进</option>
								
							</select>
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
	<script src="${pageContext.request.contextPath}/static/js/oper/add_complaint.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>