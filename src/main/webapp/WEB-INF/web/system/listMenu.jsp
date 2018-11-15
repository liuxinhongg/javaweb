<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>菜单管理</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui2/css/layui.css">
    <style type="text/css">
        p {
            margin-bottom: 20px; 
        }
    </style>
</head>

<body class="layui-row">
    <div class="layui-col-md5" style="padding: 10px 10px;">
            <div class="layui-field-box">
                <p>
                    <button class="layui-btn layui-btn-sm" id="addMenu" >添加菜单</button>
                    <button class="layui-btn layui-btn-danger batchDel" id="removeMenu" >删除菜单</button>
                    
                </p>
        </fieldset>
        <div id="demo"></div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/static/layui2/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/system/menu.js"></script>
</html>