<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>菜单修改</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Access-Control-Allow-Origin" content="*">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="icon" href="favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/news.css" media="all" />
	    <style type="text/css">
			.layui-disabled{background:#f2f2f2;color: #595963!important;}
		</style>
	</head>

	<body>
		<!--<i class="layui-icon">&#xe60c;</i>-->
		<div class="Modify_add" style="width: 38%;">
			<div class="layui-form Modify_add_Add">
				<table class="layui-table">
					<colgroup>
						<col width="20%">
						<col width="30%">
						<col width="20%">
						<col width="30%">
					</colgroup>
					<tbody>
						<tr>
							<td>模块编号<span style="color: #f00;">*</span>
							</td>
							<td>
								<input type="text" id="moduleId" class="layui-input modeCode layui-disabled" lay-verify="required|id" placeholder="只能输入数字字母下划线"  disabled >
							</td>
							<td>模块类型</td>
							<td>
								<select name="setion modetype" id="moduleType" >
									<option value="01">系统导航菜单</option>
									<option value="02" >TAB页菜单</option>
									<option value="03" >功能点</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>父模块编号<span style="color: #f00;">*</span></td>
							<td>
								<input type="text" id="parentId" class="layui-input parentId layui-disabled" lay-verify="required" disabled/>
							</td>
							<td>模块名称<span style="color: #f00;">*</span></td>
							<td>
								<input type="text" id="moduleName" class="layui-input modename" lay-verify="required" placeholder="请输入模块名称">
							</td>
						</tr>
						<tr>
							<td>排序<span style="color: #f00;">*</span></td>
							<td>
								<input id="ord" type="text" class="layui-input modesort" lay-verify="required|number">
							</td>
							<td>URL</td>
							<td>
								<input id="url" type="text" class="layui-input modeurl">
							</td>
						</tr>
						<tr>
							<td>点击动作</td>
							<td colspan="3">
								<select name="setion" id="toggle">
									<option value="0" selected="selected">保持原样</option>
		                            <option value="1" >自动隐藏菜单</option>
									<option value="2" >弹出窗口</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td style="text-align: center;">
								<button class="layui-btn" lay-submit="" lay-filter="editMenu">确定</button>
							</td>
							<td style="text-align: center;">
							</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/js/system/edit_menu.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>