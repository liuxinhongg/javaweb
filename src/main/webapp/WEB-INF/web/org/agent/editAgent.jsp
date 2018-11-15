<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>业务员添加</title>
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
						<td align="right">推荐人代码<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="pNoId" name="pNoId" value="${agentPo.pNoId}" class="layui-input Usernum" lay-verify="required" placeholder="请输入推荐人代码">
						</td>
						<td align="right">推荐人姓名<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="upAgentName" name="upAgentName" value="${agentPo.upAgentName}" class="layui-input Usernum" lay-verify="required" placeholder="请输入推荐人姓名" maxlength="20">
						</td>
					</tr>
					<tr>
						<td align="right">业务代码<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="noId" name="noId" value="${agentPo.noId}" class="layui-input userpassword" lay-verify="required" placeholder="请输入业务代码">
						</td>
						<td align="right">证件号码<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="idNumber" name="idNumber" value="${agentPo.idNumber}" class="layui-input linksusername" lay-verify="required" placeholder="请输入证件号码" maxlength="18">
						</td>
					</tr>
					<tr>
						<td align="right">用户名称<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="agentName" name="agentName" value="${agentPo.agentName}" class="layui-input masterPart" lay-verify="required" placeholder="请输入用户名称" maxlength="20">
						</td>
						<td align="right">业务电话<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="tel" name="tel" value="${agentPo.tel}" class="layui-input masterPart" lay-verify="required" placeholder="请输入业务电话">
						</td>
					</tr>
					<tr>
						<td align="right">业务代理卡<span style="color: #f00;"></span></td>
						<td colspan="3">
							<input type="text" id="noTel" name="noTel" value="${agentPo.noTel}" class="layui-input masterPart" lay-verify="required" placeholder="请输入业务代理卡" maxlength="20">
						</td>
					</tr>
					<tr>
						<td align="right">部门<span style="color: #f00;"></span></td>
						<td>
						    <input type="hidden" name="branchId" id="branchId" value="${agentPo.branchId}"/>
							<input type="text" id="branchName" name="branchName" readonly="readonly" value="${agentPo.branchName}" class="layui-input mobilePhone" lay-verify="required" style="width:82%;display:inline" placeholder="请选择部门">
							<input type="button" class="layui-btn layui-btn-small" value="选择">
						</td>
						<td align="right">用户性别</td>
						<td>
							<select id="sex" name="sex" class="uersex" lay-verify="required">
								<option value="女">女</option>
								<option value="男">男</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">出生日期<span style="color: #f00;">*</span></td>
						<td>
							<input type="text" id="birthday" value="${agentPo.birthday}" name="birthday" class="layui-input masterPart" placeholder="请输入出生年月" lay-verify="required|date" onclick="layui.laydate({elem: this,max: laydate.now()})">
						</td>
						<td align="right">教育程度<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="education" value="${agentPo.education}" name="education" class="layui-input masterPart" lay-verify="required" placeholder="请输入教育程度">
						</td>
					</tr>
					<tr>
						<td align="right">毕业时间<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="graduateDate" name="graduateDate" value="${agentPo.graduateDate}" class="layui-input masterPart" placeholder="请输入出生年月" lay-verify="required|date" onclick="layui.laydate({elem: this,max: laydate.now()})">
						</td>
						<td align="right">毕业院校<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="graduateSchool" name="graduateSchool" value="${agentPo.graduateSchool}" class="layui-input masterPart" lay-verify="required" placeholder="请输入毕业院校">
						</td>
					</tr>
					<tr>
						<td align="right">籍贯<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="origo" name="origo" value="${agentPo.origo}" class="layui-input masterPart" lay-verify="required" placeholder="请输入籍贯">
						</td>
						<td align="right">民族<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="nation" name="nation" value="${agentPo.nation}" class="layui-input masterPart" lay-verify="required" placeholder="请输入民族">
						</td>
					</tr>
					<tr>
						<td align="right">政治面貌<span style="color: #f00;"></span></td>
						<td>
							<select id="politic" name="politic" class="uersex" lay-verify="required">
								<option value="群众">群众</option>
								<option value="团员">团员</option>
								<option value="党员">党员</option>
								<option value="民主党">民主党</option>
							</select>
						</td>
						<td align="right">健康<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="healthy" name="healthy" value="${agentPo.healthy}" class="layui-input masterPart" lay-verify="required" placeholder="请输入健康情况">
						</td>
					</tr>
					<tr>
						<td align="right">开户行<span style="color: #f00;"></span></td>
						<td>
							<select id="bank" name="bank" class="uersex" lay-verify="required">
								<option value="1">工商银行</option>
								<option value="2">建设银行</option>
								<option value="3">中国银行</option>
								<option value="4">农业银行</option>
								<option value="5">招商银行</option>
								<option value="6">浦发银行</option>
								<option value="7">光大银行</option>
								<option value="8">广发银行</option>
							</select>
						</td>
						<td align="right">账号<span style="color: #f00;"></span></td>
						<td>
							<input type="text" id="bankNo" name="bankNo" value="${agentPo.bankNo}" maxlength="25" onkeyup="loadInputBankNo(this)" onkeydown="loadInputBankNo(this)" class="layui-input masterPart" lay-verify="required" placeholder="请输入账号">
						</td>
					</tr>
					<tr>
						<td align="right">照片<span style="color: #f00;"></span></td>
						<input type="hidden" id="photo" name="photo" value="${agentPo.photo}"/>
						<td>
							<input type="file" class="layui-btn layui-btn-small" value="上传照片">
						</td>
						<td align="right">证件复印件<span style="color: #f00;"></span></td>
						<input type="hidden" id="idPic" name="idPic" value="${agentPo.idPic}"/>
						<td>
							<input type="file" class="layui-btn layui-btn-small" value="上传证件">
						</td>
					</tr>
					<tr>
						<td align="right">户籍地址<span style="color: #f00;"></span></td>
						<td colspan="3">
							<input type="text" id="domicile" name="domicile" value="${agentPo.domicile}" class="layui-input Usernum" lay-verify="required" placeholder="请输入户籍地址">
						</td>
					</tr>
					<tr>
						<td align="right">联系地址<span style="color: #f00;"></span></td>
						<td colspan="3">
							<input type="text" id="address" name="address" value="${agentPo.address}" class="layui-input Usernum" lay-verify="required" placeholder="请输入联系地址">
						</td>
					</tr>
					 <tr>
						<td align="right">家庭情况</td>
						<td colspan="3">
							<textarea id="family" name="family" placeholder="请输入家庭情况" class="layui-textarea linksDesc">${agentPo.family}</textarea>
						</td>
					</tr>
					<tr>
						<td align="right">工作经历</td>
						<td colspan="3">
							<textarea id="experience" name="experience" placeholder="请输入工作经历" class="layui-textarea linksDesc">${agentPo.experience}</textarea>
						</td>
					</tr>
					<tr>
						<td align="right">兴趣爱好</td>
						<td colspan="3">
							<textarea id="hobby" name="hobby" placeholder="请输入兴趣爱好" class="layui-textarea linksDesc">${agentPo.hobby}</textarea>
						</td>
					</tr>
					<tr>
						<td align="right">备注</td>
						<input type="hidden" id="pageType" name="pageType" value="" />
						<td colspan="3">
							<textarea id="remark" name="remark" placeholder="请输入站点描述" class="layui-textarea linksDesc">${agentPo.remark}</textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td style="text-align: center;">
							<button class="layui-btn" lay-submit="" lay-filter="addLinks" onclick="openimg();">确认并生成协议</button>
						</td>
						
						<td style="text-align: center;">
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/org/editAgent.js"></script>
</body>
</html>