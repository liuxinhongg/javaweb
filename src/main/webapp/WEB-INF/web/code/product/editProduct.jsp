<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>套餐编辑</title>
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
			<form class="layui-form" style="width:98%;margin:auto">
			<input type="hidden" id="productId" name="productId" value="${productPo.productId}">
			<input type="hidden" id="productType2" name="productType2" value="${productPo.productType}">
			<input type="hidden" id="t_view" name="t_view" value="${productPo.isView}">
			<input type="hidden" id="t_Kh" name="t_Kh" value="${productPo.isKh}">
			<input type="hidden" id="t_Ih" name="t_Ih" value="${productPo.isIh}">
			
			<table class="layui-table">
				<colgroup>
					<col width="16%">
					<col width="30%">
                    <col width="22%">
					<col width="32%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">套餐名称<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="productName" name="productName" value="${productPo.productName}" required maxlength="500" class="layui-input Usernum" lay-verify="required" placeholder="请输入套餐名称">
						</td>
                         <td align="right">状态<span style="color: #f00;">*</span></td>
						<td>
							<input type="radio" name="isView"  value="1" title="显示"  checked>
						    <input type="radio" name="isView"  value="0" title="屏蔽">
						</td>
					</tr>
                    <tr>
						<td align="right">套餐类型<span style="color: #f00;">*</span></td>
						<td>
							<select id="productType1" name="productType1" class="uersex" lay-verify="required">
								<option value=" ">选择套餐类型</option>
							</select>
						</td>
                        <td align="right" width="140px;">非现场激活折扣量<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="action" name="action" value="${productPo.action}" class="layui-input Usernum" lay-verify="required" placeholder="请输入非现场激活折扣量">
						</td>
					</tr>
                    <tr>
						<td align="right">带四折算量<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="four" name="four" value="${productPo.four}" class="layui-input Usernum" lay-verify="required" placeholder="请输入带四折算量">
						</td>
                        <td align="right">不带四折算量<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="noneFour" name="noneFour" value="${productPo.noneFour}" class="layui-input Usernum" lay-verify="required" placeholder="请输入不带四折算量">
						</td>
					</tr>
                    <tr>
						<td align="right">考核<span style="color: #f00;"></span></td>
						<td>
							<input type="radio" name="isKh"  value="1" title="是" checked>
						    <input type="radio" name="isKh"  value="0" title="否">
						</td>
                         <td align="right">中高端<span style="color: #f00;"></span></td>
						<td>
							<input type="radio" name="isIh"  value="1" title="是" checked>
						    <input type="radio" name="isIh"  value="0" title="否">
						</td>
					</tr>
                    <tr>
						<td align="right">描述</td>
						<td colspan="3">
							<textarea id="productDesc" name="productDesc" class="layui-textarea linksDesc">${productPo.productDesc}</textarea>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editProduct.js"></script>
</body>
</html>