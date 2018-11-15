<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>业务员列表</title>
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
		<blockquote class="news_search layui-form">
			<div class="recordhead">
				<strong></strong>
				<a class="layui-btn layui-btn-normal batchExport" style="background-color:#5FB878">excel导出</a>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">投诉人手机号：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="svcNumber" type="text" name="" autocomplete="off" placeholder="手机号" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">分区经理姓名/代码：</label>
				<div class="layui-input-inline" style="width: 130px;">
					<input id="branchManagerName" type="text" name="" autocomplete="off" placeholder="区域经理姓名" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">代理人姓名/代码：</div>
				<div class="layui-input-inline" style="width: 130px;">
					<input id="agentName" type="text" value="" placeholder="代理人" class="layui-input search_input">
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">接线客服姓名/代码：</div>
				<div id="operatorName" class="layui-input-inline" style="width: 150px;"><input type="text" value="" placeholder="接线人代码" class="layui-input search_input"></div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">所属分部：</label>
				<div class="layui-input-inline">
					<select name="operOrg" id="operOrg"  lay-filter="myselect" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="" selected = "selected">-- 请选择 --</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">所属分区：</div>
				<div class="layui-input-inline">
					<select name="branch" id="branch" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="" selected = "selected">-- 请选择 --</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-form-label">紧急状态：</div>
				<div class="layui-input-inline">
					<select id="status" name="setion" style="width: 130px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
					    <option value="" selected = "selected">全部</option>
						<option value="0">一般</option>
						<option value="1">较紧急</option>
						<option value="2">紧急</option>
					</select>
				</div>
			</div>
			  <div class="layui-inline">
				<div class="layui-form-label">处理状态：</div>
				<div class="layui-input-inline">
					<select name="setion" id="endRecord" style="width: 130px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="" selected = "selected">全部</option>
						<option value="0">待处理</option>
						<option value="1">处理中,需要跟进</option>
						<option value="2">处理完毕</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
			    <label class="layui-form-label">完结:</label>
			     <input type="radio" name="isOver" value="" title="全部" checked>
			      &nbsp;&nbsp;  <input id="isOver" style="margin-top: 12px;" type="radio" name="isOver" title="是" value="1">
			     &nbsp;&nbsp; <input type="radio" name="isOver" value="0" title="否" >
			  </div>
			<div class="layui-inline">
				<div class="layui-inline">
					<div class="layui-form-label">投诉时间段：</div>
					<div class="layui-form-label" style="width: 150px;">
						<input id="saleDateStart" type="text" lay-verify="title" value="" placeholder="" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					至
					<div class="layui-form-label" style="width: 150px;">
						<input id="saleDateEnd" type="text" value="" placeholder="" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})" class="layui-input">
					</div>
					<button class="thismonth" id="getLastMonthYestdy">本月</button>
					<button class="thisJD" id="getBeforeApril">本季度</button>
					<button class="thisBN" id="getHalfYear">近半年</button>
					<button class="thisYear" id="getLastYearYestdy">今年</button>
				</div>
			</div>
			<div class="layui-inline">
			    <label class="layui-form-label">范围:</label>
			     <input style="margin-top: 12px;" type="radio" name="branchCity" title="全部" value="" checked />
			      <input style="margin-top: 12px;" type="radio" name="branchCity" title="昆明" value="0"/>
			     &nbsp;&nbsp; <input type="radio" name="branchCity" value="地州/市" value="1" title="地州/市"/>
			  </div>
		   <a class="layui-btn search_btn">查询</a>
			<a class="layui-btn" style="background-color:#5FB878" onclick="location.reload();">刷新</a>
		</blockquote>
		<div class="layui-block backBtn">
			<div class="layui-inline" style="margin-right: 1%;">
			<label><input type="checkbox" name="" id="" value="" />代理人</label>	
			<label><input type="checkbox" name="" id="" value="" />分区经理</label>	
			<label><input type="checkbox" name="" id="" value="" />分部经理</label>	
			<label><input type="checkbox" name="" id="" value="" />全部</label>	
				<a class="layui-btn layui-btn-normal">派单</a>
				<a class="layui-btn layui-btn-warm">完结</a>
			</div>
		</div>
		<div class="layui-form links_list" style="min-width: 4000px;">
			<table class="layui-table">
				<colgroup>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
					<col>
				</colgroup>
				<thead>
					<tr>
						<th>序号</th>
						<th>投诉时间</th>
						<th>手机号</th>
						<th>用户姓名</th>
						<th>办卡时间</th>
						<th>套餐</th>
						<th>终端</th>
						<th>投诉内容描述</th>
						<th>投诉紧迫性</th>
						<th>接线客服姓名</th>
						<th>接线客服ID</th>
						<th>接线客服处理状态</th>
						<th>接线客服处理记录</th>
						<th>代理人姓名</th>
						<th>代理人编码</th>
						<th>代理人所属分区</th>
						<th>分区编码</th>
						<th>代理人处理状态</th>
						<th>代理人处理记录</th>
						<th>代理人处理时间</th>
						<th>分区经理姓名</th>
						<th>分区经理编码</th>
						<th>分区经理所属分部</th>
						<th>分区经理处理状态</th>
						<th>分区经理处理时间</th>
						<th>分部经理姓名</th>
						<th>分部经理编码</th>
						<th>分部经理所属分部</th>
						<th>分部经理处理状态</th>
						<th>分部经理处理时间</th>
						<th>最终处理结果记录</th>
						<th>是否处理完结</th>
						<th>完结时间</th>
						<th>处理登记</th>
						<th>登记人</th>
						<th>登记时间</th>
						<th>派单对象</th>
						<th>派单操作</th>
					</tr>
				</thead>
				<tbody class="links_content"></tbody>
			</table>
		</div>
		<div id="page"></div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/oper/complaint.js"></script>
	</body>

</html>