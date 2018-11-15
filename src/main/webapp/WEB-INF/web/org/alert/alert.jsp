<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>离职预警</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/news.css" media="all" />
	
	<style type="text/css">
        form {
            height: 700px
        }

        h1, h2, h3 {
            padding: 10px 0;
        } 

        a {
            text-align: right;
            font-size: 18px;
            color: #1C86EE;
        }

        .xtree_contianer {
            height: 700px;
            /*border: 1px solid #9C9C9C;*/
            overflow: auto;
            margin-bottom: 30px;
            background-color: #fff;
        }

        .div-btns {
            margin: 20px 0;
        }
		
    </style>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search" >
		   <div class="layui-inline">
		    	<div class="layui-form-label">分部名称：</div>
		        <div class="layui-input-inline">
			     <select name="upId" id="upId" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">所有分部</option>
                      </select>
		      </div>
			</div>
			<div class="layui-inline">
		    	<label class="layui-form-label">分区名称：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="branchName" id="branchName" autocomplete="off" placeholder="请输入分区名称" class="layui-input search_input">
				</div>
		    </div>
            <div class="layui-inline">
		    	<div class="layui-form-label">推荐人：</div>
		        <div class="layui-input-inline"><input type="text" id="upAgentName" name="upAgentName" autocomplete="off" placeholder="请输入推荐人" class="layui-input search_input"></div>      
		     </div>
		     <div class="layui-inline">
		    	<div class="layui-form-label">范围：</div>
		        <div class="layui-input-inline">
			     <select id="branchCity" name="branchCity" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="-1">全部</option>
						 <option value="0">昆明</option>
                         <option value="1">地州/市</option>
                      </select>
		      </div>
			 </div>
			 <div class="layui-inline">
		    	<div class="layui-form-label">入职时长：</div>
		        <div class="layui-input-inline">
			     <select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
						 <option value="1">0~6个月</option>
                         <option value="2">6个月~12个月</option>
						 <option value="3">1年~3年</option>
						 <option value="4">3年以上</option>
                      </select>
		      </div>
			 </div>
			  <div class="layui-inline">
		    	<div class="layui-form-label">0业绩时长：</div>
		        <div class="layui-input-inline">
			          <select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
                         <option value="">全部</option>
						 <option value="1">4个月</option>
                         <option value="2">5个月</option>
                      </select>
		      </div>
			 </div>
			 <a class="layui-btn search_btn">查询</a>
			 <a class="layui-btn layui-btn-normal batchExport" style="float:right;margin-right:10px;">excel导出</a>
		</blockquote>
		<div class="layui-block backBtn">
            <div class="layui-inline">
				
			</div>
			<div class="layui-inline">
				<input type="checkbox" lay-skin="primary" id="myself" name="myself">本人 <input type="checkbox" id="upAgent" lay-skin="primary" name="upAgent">推荐人 <input type="checkbox" lay-skin="primary" id="branchManager" name="branchManager">分区经理 
				<a class="layui-btn layui-btn-small batchSendSms">发送短信</a>
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
		    </colgroup>
		    <thead>
				<tr>
				    <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>业务代码</th>
					<th>姓名</th>
					<th>业务电话</th>
					<th>所属分区</th>
					<th>所属分部</th>
					<th>入职时间</th>
					<th>累计0业绩时长</th>
					<th>推荐人姓名</th>
					<th>推荐人业务代码</th>
				</tr> 
		  </thead>
          <tbody class="links_content" id="links_content"></tbody>
		</table>
	</div>
	
    <div id="page"></div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/org/alert.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>