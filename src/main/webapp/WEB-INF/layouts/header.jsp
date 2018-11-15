<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/web/common/taglibs.jspf"%>

<div class="header navbar navbar-inverse navbar-fixed-top">
  <div class="header-inner"> <a class="navbar-brand" href="${ctx}/dashboard"> <img src="${ctx}/static/lirenkj/images/logo-smartedu.png"  width="225" height="42" alt="logo"  class="img-responsive" id="headImg"/> </a>
    <div class="hor-menu hidden-sm hidden-xs">
      <lx:navigation></lx:navigation>
    </div>
    <div class="pull-right">
      <div class="userloggedinfo"> <a data-target="#changeprofile" id="profile-btn"  style="cursor:pointer;" data-toggle="modal"  title="个人中心"><img src="${domain}${user.avatar}" alt="头像" onerror="this.src='${ctx }/static/lirenkj/images/userImage.jpg';" class="img-avatar" id="userAvatar"/></a>
        <c:if test="${empty fuyao}">    
	        <div class="userinfo">
	          <h5><span class="username">
	            <shiro:user>${user.nickname}</shiro:user>
	            </span></h5>
	          <ul>
	            <shiro:authenticated>     
	              <li> <a  id="changepwd"  style="cursor:pointer;">修改密码</a> </li>
	              <li>
	                <button id="logoutBtn" style="display:none;" onclick="javascript:document.location='${ctx}/logout'"></button>
	                <a href="javascript:logout();">退出系统</a> </li>
	            </shiro:authenticated>
	          </ul>
	        </div>
        </c:if>
      </div>
    </div>
  </div>
</div>
<script>
$(function() {
   $("#changepwd").on("click",function () {
   	$('#changepassword').modal().on('hide.bs.modal', function () {
   		$("input[type=reset]").trigger("click");
   		$("span.help-block").hide();
   		console.log($("div.has-error"));
   		$("div.has-error").removeClass("has-error");
   		$("div.has-success").removeClass("has-success");
   		
   	})
   });
});
</script>
