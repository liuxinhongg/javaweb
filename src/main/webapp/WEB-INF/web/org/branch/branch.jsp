<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>部门管理</title>
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
   <div style="float:left;width:18%">
    <form class="layui-form">
        <div id="xtree1"></div>
    </form>
	</div>
	<div style="float:right;width:82%">
	<blockquote class="layui-elem-quote news_search" >
	        <input type="hidden" id="upId" name="upId" value="11000000">
			<div class="layui-inline">
		    	<label class="layui-form-label">分区名称：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" id="branchName" name="branchName" autocomplete="off" placeholder="请输入分区名称" class="layui-input search_input">
				</div>
		    </div>
            <div class="layui-inline">
		    	<div class="layui-form-label" style="width: 160px;">分区经理姓名：</div>
		        <div class="layui-input-inline"><input type="text" id="agentName" name="agentName" autocomplete="off" placeholder="请输入姓名或编码" class="layui-input search_input"></div>      
		     </div>
		     <div class="layui-inline">
		    	<div class="layui-form-label" style="width: 170px;">分区经理业务编码：</div>
		        <div class="layui-input-inline"><input type="text" id="noId" name="noId" autocomplete="off" placeholder="请输入姓名或编码" class="layui-input search_input"></div>      
		     </div>
			 <a class="layui-btn search_btn">查询</a>
		</blockquote>
		<div class="layui-block">
		    <div class="layui-inline" >
				<a class="layui-btn links_setion" style="background-color:orange;margin:0 10px 0 0 ;">修改分部</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger" onclick="javascript:delorg();" style="margin:0 10px 0 0 ;">删除分部</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn linksAdd_btn" onclick="javascript:addorg();" style="background-color:#5FB878">添加分部</a>
			</div>
			<div class="layui-inline" style="float: right;">
				<a class="layui-btn linksAdd_btn" onclick="javascript:addbatch();" style="background-color:#5FB878">添加分区</a>
			</div>
		</div>
	    <div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>
				<col>
				<col>
				<col>
				<col>
				<col>
		    </colgroup>
		    <thead>
				<tr>
					<th>分部名称</th>
					<th>分区名称</th>
					<th>分区经理姓名</th>
					<th>分区经理业务编码</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content" id="links_content"></tbody>
		</table>
	  </div>
	
      <div id="page"></div>
    </div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/layui-xtree.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/js/org/branch.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>