<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>佣金结算</title>
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
		<div class="AccountUp">
			<blockquote class="news_search">
				<div class="layui-inline">
					<label class="layui-form-label"> 月导入数据：</label>
					<div class="layui-input-inline" style="width: 150px;">
						<input type="text" name="" autocomplete="off" class="layui-input search_input">
					</div>
				</div>
				<div class="layui-inline">
					<a class="layui-btn search_btn">预览</a>
					<a class="layui-btn" style="border: 1px solid #01AAED;color: #01AAED;background: none;border-radius: 4px;">下载数据模板</a>
				</div>
			</blockquote>
			<div class="layui-form links_list">
				<table class="layui-table">
					<thead>
						<tr>
							<td></td>
							<td>A</td>
							<td>B</td>
							<td>C</td>
							<td>D</td>
							<td>E</td>
							<td>F</td>
							<td>G</td>
							<td>H</td>
							<td>I</td>
							<td>J</td>
							<td>K</td>
						</tr>
						<tr>
						<td>1</td>
						<td>年份</td>
						<td>代理人姓名</td>
						<td>业务代码</td>
						<td>职级</td>
						<td>本月个人业绩总额</td>
						<td>本月小组业绩总额</td>
						<td>发展的有效动力小组数量</td>
						<td>一次性提成业务收益</td>
						<td>2年累计提成话费</td>
						<td>会议开合</td>
						<td>出勤考核</td>
					</tr>
					</thead>
					<tbody class="links_contentup"></tbody>
				</table>
			</div>
			<div id="page"></div>
		</div>
		<div class="AccountDown">
			<div class="recordhead">
				<strong></strong>
				<button onclick="modeladd();">Excel导出</button>
			</div>

			<blockquote class="news_search">

				<div class="layui-inline">
					<div class="layui-form-label">代理人姓名：</div>
					<div class="layui-input-inline" style="width: 150px;">
						<input type="text" value="" placeholder="推荐人" class="layui-input search_input">
					</div>
				</div>

				<div class="layui-inline">
					<div class="layui-form-label">业务代码：</div>
					<div class="layui-input-inline" style="width: 150px;"><input type="text" value="" placeholder="分区名称" class="layui-input search_input"></div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">所属分部：</label>
					<div class="layui-input-inline">
						<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
							<option value="">所有状态</option>
							<option value="1">启用</option>
							<option value="0">未启用</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-form-label">所属分区：</div>
					<div class="layui-input-inline">
						<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
							<option value="">所有方式</option>
							<option value="0">营业厅办理</option>
							<option value="1">业务员推荐</option>
						</select>
					</div>
				</div>
				
				<div class="layui-inline">
					<div class="layui-inline">
						<div class="layui-form-label">开卡时间段：</div>
						<div class="layui-input-inline" style="width: 150px;">
							<input type="text" value="" placeholder="" lay-verify="required|datetime" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						至
						<div class="layui-input-inline" style="width: 150px;">
							<input type="text" value="" placeholder="" lay-verify="required|datetime" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" class="layui-input">
						</div>
						<button class="thismonth">本月</button>
						<button class="thisJD">本季度</button>
						<button class="thisBN">近半年</button>
						<button class="thisYear">今年</button>

					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">职级：</label>
					<div class="layui-input-inline">
						<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
							<option value="">职级一</option>
							<option value="1">职级二</option>
							<option value="0">职级三</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">范围：</label>
					<div class="layui-input-inline">
						<select name="setion" style="width: 150px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
							<option value="">昆明</option>
							<option value="1">地州/市</option>
						</select>
					</div>
				</div>
				&nbsp; &nbsp;
				<a class="layui-btn search_btn">查询</a>
			</blockquote>
            <div class="layui-block backBtn">
				<div class="layui-inline" style="margin-right: 1%;">
					<a class="layui-btn layui-btn-danger">业绩排序</a>
					<select name="setion" style="width: 120px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
						<option value="11">时间</option>
						<option value="20">业绩</option>
					</select>
				</div>
		    </div>
			<div class="layui-form links_list" style="min-width: 2500px;">
				<table class="layui-table">
					<thead>
						<tr>
							<td>序号</td>
							<td>时间</td>
							<td>代理人姓名</td>
							<td>业务代码</td>
							<td>职级</td>
							<td>所属分部</td>
							<td>所属分区</td>
							<td>本月业绩总额(万元)</td>
							<td>一次性提成</td>
							<td>话费提成</td>
							<td>岗位津贴</td>
							<td>代理补助</td>
							<td>管理津贴</td>
							<td>杰出贡献奖</td>
							<td>月度奖励</td>
							<td>税率</td>
							<td>佣金总额(万元)</td>
							<td>不良用户罚款</td>
							<td>代扣</td>
							<td>合计(万元)</td>
							<td>操作人</td>
							<td>部门</td>
							<td>操作时间</td>
						</tr>
					</thead>
					<tbody class="links_contentDown"></tbody>
				</table>
			</div>
			<div id="page"></div>
		</div>
		<script src="${pageContext.request.contextPath}/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/js/comm/account.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>