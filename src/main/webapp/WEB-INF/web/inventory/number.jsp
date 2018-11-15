<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>号码管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/news.css" media="all" />
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
	        <input type="hidden" id="branchId" name="branchId">
		    <div class="layui-inline">
			    <label class="layui-form-label" style="width: 70px;">精确匹配：</label>
				<div class="layui-input-inline" style="width: 370px;">
					<input id="svcnumber1" type="text" name="serchSvcNumber" autocomplete="off" placeholder="1" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
					<input id="svcnumber2" type="text" name="serchSvcNumber" autocomplete="off" placeholder="2" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
					<input id="svcnumber3" type="text" name="serchSvcNumber" autocomplete="off" placeholder="3" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
					<input id="svcnumber4" type="text" name="serchSvcNumber" autocomplete="off" placeholder="4" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
				    <input id="svcnumber5" type="text" name="serchSvcNumber" autocomplete="off" placeholder="5" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
					<input id="svcnumber6" type="text" name="serchSvcNumber" autocomplete="off" placeholder="6" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
					<input id="svcnumber7" type="text" name="serchSvcNumber" autocomplete="off" placeholder="7" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
					<input id="svcnumber8" type="text" name="serchSvcNumber" autocomplete="off" placeholder="8" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
				    <input id="svcnumber9" type="text" name="serchSvcNumber" autocomplete="off" placeholder="9" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
				    <input id="svcnumber10" type="text" name="serchSvcNumber" autocomplete="off" placeholder="10" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
					<input id="svcnumber11" type="text" name="serchSvcNumber" autocomplete="off" placeholder="11" class="layui-input search_input" style="width:30px;display:inline;" maxlength="1" pattern="^[0-9]{1}">
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label" style="width: 70px;">模糊查询：</label>
				<div class="layui-input-inline" style="width: 130px;">
					<input id="svcnumber2" type="text" name="svcnumber2" autocomplete="off" placeholder="模糊查询" class="layui-input search_input">
				</div>
		    </div>
			 <div class="layui-inline">
		    	<div class="layui-form-label" style="width: 70px;">靓号规则：</div>
		        <div class="layui-input-inline">
			         <select id="lvlType" name="lvlType" style="width: 110px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">所有规则</option>
                      </select>
		        </div>
			</div>
			<div class="layui-inline">
			    <label class="layui-form-label" style="width:30px;"></label>
				<div class="layui-input-inline" style="width: 130px;">
						<input id="opertype" type="radio" name="opertype"  value="1" title="分配"  checked>分配 &nbsp;&nbsp;
						<input id="opertype" type="radio" name="opertype"  value="0" title="回收">回收
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label" style="width: 70px;">起始号码：</label>
				<div class="layui-input-inline" style="width: 130px;">
					<input id="beginSvcNumber" type="text" name="beginSvcNumber" autocomplete="off" placeholder="起始号码" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label" style="width: 70px;">结束号码：</label>
				<div class="layui-input-inline" style="width: 130px;">
					<input id="endSvcNumber" type="text" name="endSvcNumber" autocomplete="off" placeholder="结束号码" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label" style="width: 70px;">批次号：</label>
				<div class="layui-input-inline" style="width: 130px;">
					<input id="snNo" type="text" name="snNo" autocomplete="off" placeholder="批次号" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label" style="width: 70px;">号码状态：</label>
				<div class="layui-input-inline">
			         <select id="status" name="status" style="width: 110px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部状态</option>
						 <option value="1">可用</option>
                         <option value="-1">不可用</option>
                         <option value="0">已售出</option>
                      </select>
		        </div>
		    </div>
			<div class="layui-inline">
			    <label class="layui-form-label" style="width: 70px;">是否共享：</label>
				<div class="layui-input-inline">
				        <select id="isshare" name="isshare" style="width: 110px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
						 <option value="1">是</option>
                         <option value="0">否</option>
                      </select>
				</div>
		    </div>
			 <a class="layui-btn search_btn">查询</a>
		</blockquote>
	    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col>
				<col>
				<col>
				<col>
				<col>
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>手机号码</th>
					<th>当前所在部门</th>
					<th>操作类型</th>
					<th>是否共享</th>
					<th>状态</th>
					<th>批次号</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content"></tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/inventory/number.js"></script>
</body>
</html>