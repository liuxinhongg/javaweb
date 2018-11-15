<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>号码导入</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui2/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
</head>
<body class="childrenBody">
 <blockquote class="layui-elem-quote news_search">手机号码导入（<span style="color:red">数据格式：所有数据列都是字符类型，一次只能使用其中一套模板，不能讲两套模板混合使用</span>）</blockquote>
	<input type="hidden" id="branchId" name="branchId">
	<div style="padding-bottom:40px;">
       <form class="layui-form" style="width:80%;margin:auto;" method="post" enctype="multipart/form-data">
			<table class="layui-table">
				<colgroup>
					<col width="50%">
                    <col width="50%">
				</colgroup>
               <thead>
                <tr>
					<th>死卡和固网模板</th>
					<th>准活卡模板</th>
				</tr> 
		    </thead>
				<tbody>
					<tr>
						<td align="center">
							<img src="${pageContext.request.contextPath}/static/images/ex01.jpg" alt="" />
						</td>
						<td align="center"> 
							<img src="${pageContext.request.contextPath}/static/images/ex02.jpg" alt="" />
						</td>
					</tr>
                    <tr>
						<td align="left" colspan="2">
                                                        选择文件<span style="color: #f00;"></span>
                            <input type="file" id="uploadExcel" name="uploadExcel" class="layui-btn-small" value="浏览">
						</td>
					</tr>
                    <tr>
						<td align="left" colspan="2">
                                                         选择部门<span style="color: #f00;"></span>
                            <input type="text" class="layui-input mobilePhone" lay-verify="required" id="branchName" name="branchName" readonly="readonly" style="width:220px;display:inline" placeholder="请选择部门">
							<input id="bumen" type="button" class="layui-btn layui-btn-small" value="选择" onclick="openBranch();">
                            <button class="layui-btn layui-btn-small" id="upload" lay-submit="" lay-filter="addLinks">保存</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
     </div>
    <blockquote class="layui-elem-quote news_search">强制导入（<span style="color:red">数据格式：所有数据列都是字符类型，一次只能使用其中一套模板，不能讲两套模板混合使用</span>）</blockquote>
 <div>     
<form class="layui-form" style="width:80%;margin:auto;">
			<table class="layui-table">
				<colgroup>
					<col width="50%">
                    <col width="50%">
				</colgroup>
               <thead>
                <tr>
					<th>死卡和固网模板</th>
					<th>准活卡模板</th>
				</tr> 
		    </thead>
				<tbody>
					<tr>
						<td align="center">
							<img src="${pageContext.request.contextPath}/static/images/ex01.jpg" alt="" />
						</td>
						<td align="center"> 
							<img src="${pageContext.request.contextPath}/static/images/ex02.jpg" alt="" />
						</td>
					</tr>
                    <tr>
						<td align="left" colspan="2">
                                                                 手机号码<span style="color: #f00;"></span>
                            <input name="svcnumber" type="text" class="layui-input mobilePhone" lay-verify="required" style="width:220px;display:inline" placeholder="请输入手机号">
						</td>
					</tr>
                    <tr>
						<td align="left" colspan="2">
                            SIM卡<span style="color: #f00;"></span>
                            <input name="simnumber" type="text" class="layui-input mobilePhone" lay-verify="required" style="width:220px;display:inline" placeholder="请输入SIM卡号">
							<!--<input type="button" class="layui-btn layui-btn-small" value="选择" onclick="openBranch();">-->
                            <button class="layui-btn layui-btn-small" lay-submit="" lay-filter="addLinks" id="mandatory">强制导入</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form> 
     </div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui2/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/inventory/numberIn.js"></script>
</body>
</html>