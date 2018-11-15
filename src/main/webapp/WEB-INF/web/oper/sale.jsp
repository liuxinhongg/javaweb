<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>业务管理-开发登记</title>
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

	<body style="min-width: 1200px;">
		<blockquote class="news_search" style="width: 80%;margin: auto;min-width: 1200px;">
			<div class="recordhead">
				<strong>开卡登记</strong>
				<button>开卡记录</button>
			</div>
			<div class="layui-block twoInline">
				<div class="layui-inline">
					<label class="layui-form-label">开卡日期<span class="twotable">*</span> </label>
					<div class="layui-input-inline">
						<input type="date" name="" autocomplete="off" placeholder="开卡日期" class="layui-input search_input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: auto;">代理人姓名</label>
					<div class="layui-input-inline">
						<input type="text" name="" autocomplete="off" placeholder="姓名" class="layui-input search_input">
					</div>
				</div>
			</div>
			<div class="layui-block twoInline">
				<div class="layui-inline">
					<label class="layui-form-label">业务编码<span class="twotable">*</span></label>
					<div class="layui-input-inline">
						<input type="text" name="" autocomplete="off" placeholder="业务编码" class="layui-input search_input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: auto;">小卡卡号<span class="twotable">*</span></label>
					<div class="layui-input-inline">
						<input type="text" name="" autocomplete="off" placeholder="姓名" class="layui-input search_input">
					</div>
				</div>
			</div>
			<div class="layui-block twoInline">
				<div class="layui-inline">
					<label class="layui-form-label">手机号码<span class="twotable">*</span></label>
					<div class="layui-input-inline">
						<input type="tel" name="" autocomplete="off" placeholder="手机号码" class="layui-input search_input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: auto;">对账金额<span class="twotable">*</span></label>
					<div class="layui-input-inline">
						<input type="text" name="" autocomplete="off" placeholder="对账金额" class="layui-input search_input">
					</div>
				</div>
			</div>
			<div class="layui-block twoInline" style="width: 70%;">
				<div class="layui-inline">
					<label class="layui-form-label">面值<span class="twotable">*</span></label>
					<div class="layui-input-inline">
						<input type="tel" name="" autocomplete="off" class="layui-input search_input">
					</div>
					<div class="layui-input-inline">
						<label><input type="radio" name="switch" checked>正常开关</label>
						<label>   <input type="radio" name="switch" >零元开关</label>
					</div>
				</div>
				<div class="layui-inline addBtn">
					<label class="layui-form-label" style="width: auto;">配置设备<span class="twotable">*</span></label>
					<div class="layui-input-inline">
						<input type="text" name="" autocomplete="off" class="layui-input search_input">
					</div>
					<button onclick="choose();">选择</button><button>清除</button>
				</div>
			</div>

			<div class="layui-block twoInline">
				<div class="layui-inline">
					<label class="layui-form-label">套餐<span class="twotable">*</span></label>
					<div class="layui-input-inline">
						<select name="setion" style="width: 180px;height: 38px;line-height: 38px;border-radius: 4px;border: 1px solid #E2E2E2;">
							<option value="">所有状态</option>
							<option value="1">启用</option>
							<option value="0">未启用</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: auto;">串号</label>
					<div class="layui-input-inline">
						<input type="text" name="" autocomplete="off" class="layui-input search_input">
					</div>
				</div>
			</div>
            <div class="layui-block">
				<div class="layui-inline">
					<label class="layui-form-label" style="width: auto;">开户方式</label>
				</div>
				<div class="layui-inline">
					<label> <input type="checkbox"/>沃云霄 </label>
					<label> <input type="checkbox"/>mini厅 </label>
					<label> <input type="checkbox"/>激活卡 </label>
					<label> <input type="checkbox"/>新装开户 </label>
					<label> <input type="checkbox"/>马上购 </label>
				</div>
			</div>
			<div class="layui-block resukBtn">
				<div class="layui-inline">
					<a class="layui-btn layui-btn-normal">激活开关</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-danger">不激活开关</a>
				</div>
			</div>
			
			<div class="recordhead">
				<strong>批量登记</strong>
				<button>下载模板</button>
			</div>
		</blockquote>
		<div class="layui-form links_list" style="width: 80%;margin: auto;min-width: 1200px;">
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
				</colgroup>
				<thead>
					<tr>
						<th colspan="12">批量登记模板</th>
					</tr>
					<tr>
						<td><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></td>
						<td>A</td>
						<td>B</td>
						<td>C</td>
						<td>D</td>
						<td>E</td>
						<td>F</td>
						<td>开户方式</td>
						<td>G</td>
						<td>H</td>
						<td>I</td>
						<td>J</td>
					</tr>

					<tr>
						<td>1</td>
						<th>开卡日期</th>
						<th>业务代码</th>
						<th>代理人姓名</th>
						<th>手机号码</th>
						<th>小卡卡号</th>
						<th>面值</th>
						<th>沃云霄</th>
						<th>对账金额</th>
						<th>套餐编号</th>
						<th>配置设备编号</th>
						<th>串号</th>
					</tr>
				</thead>
				<tbody class="links_content">
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>正常开卡</td>
						<td>mini厅</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>零元开卡开卡</td>
						<td>新装开户</td>
						<td>对账金额</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<div class="layui-inline">
					<label class="layui-form-label">选择文件：</label>
					<div class="layui-input-inline">
						<input type="tel" name="" autocomplete="off" class="layui-input search_input">
					</div>
					<div class="layui-input-inline">
						<button>预览...</button>
					</div>
					<div class="layui-input-inline">
						<button class="activate">激活确认</button>
					</div>
				</div>
		</div>
		<div id="page"></div>
		<script src="${pageContext.request.contextPath}/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/js/oper/sale.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>