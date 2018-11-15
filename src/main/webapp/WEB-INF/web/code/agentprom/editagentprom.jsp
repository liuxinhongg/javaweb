<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>新增业务代理人晋升标准</title>
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
			<input type="hidden" id="conditionId" name="conditionId" value="${positionRiseConditionPo.conditionId}">
			<input type="hidden" id="t_positionId" name="t_positionId" value="${positionRiseConditionPo.positionId}">
			<input type="hidden" id="t_needPositionId" name="t_needPositionId" value="${positionRiseConditionPo.needPositionId}">
			<input type="hidden" id="t_status" name="t_status" value="${positionRiseConditionPo.status}">
			<input type="hidden" id="t_standardType" name="t_standardType" value="${positionRiseConditionPo.standardType}">
			<input type="hidden" id="t_highType" name="t_highType" value="${positionRiseConditionPo.highType}">
			<table class="layui-table">
				<colgroup>
					<col width="20%">
					<col width="20%">
					<col width="60%">
					
				</colgroup>
				<tbody>
					<tr>
						<td align="right">晋升职级：<span style="color: #f00;">*</span></td>
						<td colspan="2">
							<select id="positionId" name="positionId" class="masterPart" lay-verify="required">
								<option value="">职位</option>
							</select>
						</td>
					</tr>
					 <tr>
						<td align="right">基础条件<span style="color: #f00;">*</span></td>
						<td></td>
						<td></td>
					</tr>
					 <tr>
						<td></td>
						<td align="right">原职级：</td>
						<td>
						    <select id="needPositionId" name="needPositionId" class="masterPart" lay-verify="required">
								<option value="">职位</option>
							</select>
					   </td>
					</tr>
					 <tr>
						<td></td>
						<td align="right">标准</td>
						<td>
						    <select id="standardType" name="standardType" class="masterPart" lay-verify="required">
								<option value="1">评比合格</option>
								<option value="2">拥有个人销售小组</option>
							</select>
						</td>
					</tr>
					 <tr>
						<td align="right">条件二：<span style="color: #f00;">*</span></td>
						<td></td>
						<td></td>
					</tr>
					 <tr>
						<td></td>
						<td align="right">项目</td>
						<td>
						    <select id="highType" name="highType" class="masterPart" lay-verify="required">
								<option value="1">拥有高级直接销售小组数</option>
								<option value="2">持续3个月话费总额</option>
								<option value="3">当月产生话费总量</option>
							</select>
						</td>
					</tr>
					 <tr>
						<td></td>
						<td align="right">数量</td>
						<td>
							<input type="text" id="highValueMin" name="highValueMin" value="${positionRiseConditionPo.highValueMin}" style="width: 10%;"/>
							≤X<
							<input type="text" id="highValueMax" name="highValueMax" value="${positionRiseConditionPo.highValueMax}" style="width: 10%;"/>
							<div class="layui-input-inline" style="width: 120px;height: 35px;line-height: 35px;">
					                                  万元、支、笔、个
				            </div>
						</td>
					</tr>
                    <tr>
						<td align="right">排序：<span style="color: #f00;">*</span></td>
						<td colspan="2">
							<input type="text" id="conditionOrd" name="conditionOrd" value="${positionRiseConditionPo.conditionOrd}" class="layui-input Usernum" lay-verify="required" style="display:inline;width:40%">
						</td>
					</tr>
					<tr>
						<td align="right">状态<span style="color: #f00;"></span></td>
						<td colspan="2">
							<input type="radio" name="status"  value="1" title="有效" checked>
						    <input type="radio" name="status"  value="0" title="无效">
						</td>
					</tr>
					<tr>	
						<td></td>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/code/editagentprom.js"></script>
</body>
</html>