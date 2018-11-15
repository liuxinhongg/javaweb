<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>设备信息编辑</title>
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
			<input type="hidden" id="deviceId" name="deviceId" value="${devicePo.deviceId}">
			<input type="hidden" id="t_status" name="t_status" value="${devicePo.status}">
			<input type="hidden" id="deviceTypeCode2" name="deviceTypeCode2" value="${devicePo.deviceTypeCode}">
			<input type="hidden" id="schemeTypeCode2" name="schemeTypeCode2" value="${devicePo.schemeTypeCode}">
			<table class="layui-table">
				<colgroup>
					<col width="18%">
					<col width="32%">
                    <col width="18%">
					<col width="32%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">终端名称<span style="color: #f00;">*</span></td>
						<td colspan="3">
							<input type="text" id="deviceName" name="deviceName" value="${devicePo.deviceName}" required  maxlength="50" class="layui-input Usernum" lay-verify="required" placeholder="请输入终端名称">
						</td>
					</tr>
                    <tr>
						<td align="right">终端类型<span style="color: #f00;">*</span></td>
						<td>
							<select id="deviceTypeCode1" name="deviceTypeCode1" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                               <option value="">全部</option>
                            </select>
						</td>
                        <td align="right">业务类型<span style="color: #f00;">*</span></td>
						<td>
							 <select id="schemeTypeCode1" name="schemeTypeCode1" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                                <option value="">全部</option>
                            </select>
						</td>
					</tr>
                    <tr>
						<td align="right">提成<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="deduct" name="deduct" value="${devicePo.deduct}" class="layui-input Usernum" required lay-verify="required" placeholder="请输入提成">
						</td>
                        <td align="right">单价<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="price" name="price" value="${devicePo.price}" class="layui-input Usernum" required lay-verify="required" placeholder="请输入单价">
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
						<td colspan="3">
							<textarea id="deviceDesc" name="deviceDesc" class="layui-textarea linksDesc">${devicePo.deviceDesc}</textarea>
						</td>
					</tr>
					<tr>	
						<td style="text-align: center;" colspan="4">
						    <button class="layui-btn" lay-submit="" lay-filter="addLinks">确认</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editDevice.js"></script>
</body>
</html>