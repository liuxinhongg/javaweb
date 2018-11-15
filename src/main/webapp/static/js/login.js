var $,tab,skyconsWeather;
layui.config({
	base : "/static/js/index/"
}).use(['bodyTab','form','element','layer','jquery'],function(){

	    form = layui.form();
        
        //修改密码
        form.on("submit(userlogin)",function(data){
        	
        	var username = $("#username").val();
        	
        	if (username == null || username == "") {
                return "请输入用户名！";
            }
        	
        	var password = $("#password").val();
        	
        	if (password == null || password == "") {
                return "请输入密码";
            }
        	
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
 			
 			$.ajax({
 		        url:"/user/login.do?t="+new Date().getTime(),
 		        data:{"username":$.trim($("#username").val()),"password":$.trim($("#password").val()),"remFlag":$.trim($("#remFlag").val())},
 		        type: "post",
 		        dataType:"json",
 		        success: function (data) {
 		        	layer.close(index);
 		            if (data.state == undefined || data.state !== 0) {
 		            	layer.msg('用户名或密码错误',{icon:5});
 		            } else {
 		            	location.href="/manage/index.do";
 		            }
 		        }
 		    });
 			
 			return false; 
 		})
 		
 		$("input").keydown(function(event){
              if (event.keyCode == 13) {
                    document.getElementById("userlogin").click();
              }
        })
})



$(document).ready(function(){ 
		var str = getCookie("loginInfo"); 
		str = str.substring(0,str.length); 
		
		var username = str.split("#")[0]; 
		var password = str.split("#")[1]; 
		$("#username").val(username);
		$("#password").val(password); 
		
		if(str!=null && str!=""){ 
			$("input[type='checkbox']").attr("checked", true); 
			 $("#remFlag").val(true); 
		} 
	});
	   
	   function remember(){
		  var remFlag = $("input[type='checkbox']").is(':checked');
		   
		  if(remFlag==true){ 
               $("#remFlag").val(true); 
		  }
		  else
		  {  
			  $("#remFlag").val(false); 
	      }
	  }
	   
	   function getCookie(cname){
		   
		   var name = cname + "="; 
	       var ca = document.cookie.split(';');
	       for(var i=0; i<ca.length; i++) { 
		      var c = ca[i]; 
	          while (c.charAt(0)==' ') c = c.substring(1); 
	          if (c.indexOf(name) != -1) 
	          return c.substring(name.length, c.length); 
	       } 
	       return ""; 
	   }
