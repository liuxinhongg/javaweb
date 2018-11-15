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
	<blockquote class="layui-elem-quote news_search">
		    <div class="layui-inline">
			    <label class="layui-form-label">业务代码：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="noId" name="noId" value="" autocomplete="off" placeholder="业务代码" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
		    	<label class="layui-form-label">姓名：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="agentName" name="agentName" value="" autocomplete="off" placeholder="姓名" class="layui-input search_input">
				</div>
		    </div>
			<div class="layui-inline">
			  <div class="layui-form-label">入职时间：</div>
			  <div class="layui-input-inline" style="width: 150px;">
		    	<input type="text" value="" id="startTime" name="startTime" value="" lay-verify="required|date" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})" class="layui-input">
		      </div>
			</div>
			<div class="layui-inline">
			  至
			  <div class="layui-input-inline" style="width: 150px;">
		    	<input type="text" value="" id="endTime" name="endTime" value="" placeholder="" lay-verify="required|date" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})" class="layui-input">
		      </div>
			</div>
			<div class="layui-inline">
		    	<div class="layui-form-label">推荐人：</div>
			    <div class="layui-input-inline" style="width: 150px;">
		    	     <input type="text" id="upAgentName" name="upAgentName" value="" placeholder="推荐人" class="layui-input search_input">
		        </div>
			</div>
		   
		     <div class="layui-inline">
		           <div class="layui-form-label">分区名称：</div>
			       <div class="layui-input-inline" style="width: 150px;"><input type="text" id="branchName" name="branchName" value="" placeholder="分区名称" class="layui-input search_input"></div>
			 </div>
			<div class="layui-inline">
				<label class="layui-form-label">状态：</label>
				<div class="layui-input-inline">
					<select id="status" name="status" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="-1">所有状态</option>
						<option value="1">正常</option>
						<option value="0">注销</option>
						<option value="2">除名</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
		    	<div class="layui-form-label">入职方式：</div>
		        <div class="layui-input-inline">
			          <select id="joinType" name="joinType" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="-1">所有方式</option>
                         <option value="0">营业厅办理</option>
						 <option value="1">业务员推荐</option>
                      </select>
		         </div>
		    </div>
		   <div class="layui-inline">
		    	<div class="layui-form-label">职级：</div>
		        <div class="layui-input-inline">
			   <select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="-1">所有职级</option>
						 <option value="8">分区经理</option>
                         <option value="0">资深行销总监</option>
						 <option value="1">行销总监</option>
						 <option value="2">行销总监</option>
						 <option value="3">高级客户经理</option>
						 <option value="4">客户经理</option>
						 <option value="5">客户主任</option>
						 <option value="6">客户指导</option>
						 <option value="7">客户代表</option>
                      </select>
		    </div>
			</div>
			<div class="layui-inline">
		    	<div class="layui-form-label">业务电话：</div>
			    <div class="layui-input-inline" style="width: 150px;">
		    	     <input type="text" id="tel" name="tel" value="" placeholder="业务电话" class="layui-input search_input">
		        </div>
			</div>
			<div class="layui-inline">
		    	<div class="layui-form-label">累计业绩：</div>
			    <div class="layui-input-inline" style="width: 150px;">
		    	     <input type="text" value="" class="layui-input search_input">
		        </div>
			</div>
			<div class="layui-inline">
		    	至
			    <div class="layui-input-inline" style="width: 150px;">
		    	     <input type="text" value="" class="layui-input search_input">
		        </div>
			</div>
			 <div class="layui-inline">
		    	<div class="layui-form-label">排序：</div>
		        <div class="layui-input-inline">
			        <select id="orderby" name="orderby" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="0">创建时间由近及远</option>
						 <option value="1">创建时间由远及近</option>
						 <option value="2">业绩由高到低</option>
						 <option value="3">业绩由低到高</option>
                    </select>
		    </div>
           </div>
			 <a class="layui-btn search_btn">查询</a>
		</blockquote>
		<div class="layui-block backBtn">
			<div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn linksAdd_btn" href="javascript:addAgent();" style="background-color:#5FB878">添加</a>
			</div>
            <div class="layui-inline" style="margin-right: 1%;">
				<a class="layui-btn layui-btn-danger batchDel" >批量注销</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn batchDelete" style="background: orange;">批量除名</a>
			</div>
		</div>
	    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>   
				<col width="50">
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
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>业务代码</th>
					<th>姓名</th>
					<th>所属分区</th>
					<th>所属分部</th>
					<th>推荐人</th>
					<th>业务电话</th>
					<th>照片信息</th>
					<th>入职时间</th>
					<th>入职方式</th>  
					<th>状态</th>
					<th>操作人</th>
					<th>变更时间</th>
					<th>职级</th>
					<th>累计业绩(万)</th>
					<th>经手号卡(张)</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content"></tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/org/agent.js"></script>
</body>
</html>