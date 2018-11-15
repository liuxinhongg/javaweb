<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户修改</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
		<style type="text/css">
			.descText {
				width: 100px;
			}
			
			.OinputK {
				margin-left: 140px;
			}
			
			.opselect {
				width: 180px;
				margin-left: 10px;
			}
			.layui-disabled{background:#f2f2f2;color: #595963!important;}
		</style>
	</head>

	<body class="childrenBody">
		<form class="layui-form" style="width:80%;">
			<table class="layui-table">
				<colgroup>
					<col width="20%">
					<col width="30%">
					<col width="20%">
					<col width="30%">
				</colgroup>
				<tbody>
					<tr>
						<td align="right">用户ID<span style="color: #f00;">*</span></td>
						<td colspan="3">
						 <input class="layui-input Usernum layui-disabled" type="text" name="loginId" type="roleId" id="loginId" value="" size="52" disabled />
						</td>
					</tr>
					<tr>
						<td align="right">用户工号<span style="color: #f00;">*</span></td>
						<td>
							<input id="staffId" type="text" class="layui-input Usernum" lay-verify="required|id" placeholder="请输入用户工号">
						</td>
						<td align="right">用户密码</td>
						<td>
							<input type="password" id="password" class="layui-input userpassword" placeholder="请输入用户密码">
						</td>
					</tr>
					<tr>
						<td align="right"> 用户姓名<span style="color: #f00;">*</span></td>
						<td>
							<input type="tel" id="loginName" class="layui-input linksusername" lay-verify="required" placeholder="请输入用户姓名">
						</td>
						<td align="right">用户性别</td>
						<td>
							<select name="" id="gender" class="uersex" lay-verify="required">
								<option value="0" >--请选择--</option>
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">用户部门<span style="color: #f00;">*</span></td>
						<td>
							<select id="department" name="" class="masterPart" lay-verify="required">
								<option value="1">部门</option>
							</select>
						</td>
						<td align="right">状态</td>
						<td>
							<select name="" id="state" class="Oselect" lay-verify="required">
								<option value="0">未启用</option>
								<option value="1">启用</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">是否管理员<span style="color: #f00;">*</span></td>
						<td colspan="3" id="isAdmin">
							<input type="radio" value="Y" name="isAdmin" class="homePage" title="是" >
							<input type="radio" value="N" name="isAdmin" class="subPage" title="否">
						</td>
					</tr>
					<tr>
						<td align="right">移动电话<span style="color: #f00;">*</span></td>
						<td>
							<input type="tel" id="mobilePhone" class="layui-input mobilePhone" lay-verify="required|phone" placeholder="请输入移动电话">
						</td>
						<td align="right">Email</td>
						<td>
							<input type="email" id="email" class="layui-input userEmail"  placeholder="请输入用户Email">
						</td>
					</tr>
					<tr>
						<td align="right">所属角色</td>
						<td colspan="3" id="role">
						</td>
					</tr>
					<tr>
						<td align="right">备注</td>
						<td colspan="3">
							<textarea id="memo" placeholder="请输入备注" class="layui-textarea linksDesc"></textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td style="text-align: center;">
							<button class="layui-btn" lay-submit="" lay-filter="updateLinks">提交</button>
						</td>
						
						<td style="text-align: center;">
						</td>
						<td>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/edit_user.js"></script>
	</body>

</html>