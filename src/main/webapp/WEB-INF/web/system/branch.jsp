<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>部门分区</title>
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
   <div>
    <!--别忘记form 以及form的class-->
    <form class="layui-form">
        <div id="xtree1"></div>
    </form>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/js/layui-xtree.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/js/system/branch.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>