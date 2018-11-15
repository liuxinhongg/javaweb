<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/web/common/taglibs.jspf"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title><sitemesh:title />云南联通公众互联网营销部佣金系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<meta name="MobileOptimized" content="320">
<%@include file="/WEB-INF/web/common/import-assets-css-js.jspf" %>
<%@include file="/WEB-INF/web/common/import-css-js.jspf" %>
<sitemesh:head />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-full-width page-footer-fixed">
<!-- BEGIN HEADER -->
<%@include file="/WEB-INF/layouts/header.jsp" %>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
	<sitemesh:body />
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<%@include file="/WEB-INF/layouts/footer.jsp" %>
<!-- END FOOTER -->
<%@include file="/WEB-INF/web/common/import-footer-js.jspf" %>
<!-- END JAVASCRIPTS -->
<script>
jQuery(document).ready(function() {
   App.init(); // initlayout and core plugins
});
</script>
<sitemesh:getProperty property="page.cs" />
</body>
<!-- END BODY -->
</html>