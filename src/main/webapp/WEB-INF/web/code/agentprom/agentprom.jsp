<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>代理人晋升</title>
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

	<body>
		<div class="layui-tab" style="width: 95%;margin: 30px auto;">
			<div class="recordhead">
				<strong>业务代理人晋升标准：</strong>
				<a class="layui-btn linksAdd_btn" style="background-color:#5FB878">新增</a>
			</div>
			<div style="color: #999;text-indent: 2em;">
				<p >1、年满18岁以上，具有完全民事行为能力和完全民事权利能力。</p> 
                <p>2、经过岗前培训并由本人向州市公众互联网营销部提出申请。</p> 
			</div>
			<div class="layui-tab-content">
					<div class="layui-form links_list" style="min-width: 1000px;">
						<table class="layui-table">
							<thead>
								<tr>
									<th rowspan="2">序号</th>
									<th rowspan="2">晋升职级</th>
									<th colspan="2">基础条件</th>
									<th colspan="2">条件二</th>
									<th rowspan="2">设置人</th>
									<th rowspan="2">设置时间</th>
									<th rowspan="2">状态</th>
									<th rowspan="2">操作</th>
								</tr>
								<tr>
									<th>原职级</th>
									<th>标准</th>
									<th>项目</th>
									<th>数量</th>
								</tr>
							</thead>
							<tbody class="links_content content1">
								
							</tbody>
						</table>
						<p style="color: #999;">
							* 客户经理及其以下职级的代理人，若当月生产话费总额X≥10万元，职级标记为“准高级客户经理”；若次月话费总额仍然保持在X≥10万元，
							继续标记职级为“准高级客户经理”；第三个月若继续保持话费X≥10万，则该代理人直接晋升为“高级客户经理”，本月享受高级客户经理级别的岗位津贴。
						</p>
					</div>
					<div id="page"></div>
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/code/agentprom.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>