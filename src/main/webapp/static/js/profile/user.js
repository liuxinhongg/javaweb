var $form;
var form;
var $;
layui.config({
	base : "/static/js/index/"
}).use(['form','layer','upload','laydate'],function(){
	form = layui.form();
	var layer = parent.layer === undefined ? layui.layer : parent.layer;
		$ = layui.jquery;
		$form = $('form');
		laydate = layui.laydate;
        layui.upload({
        	elem: '#userhead',
        	url : "/attachment/img/upload.do",
        	multi: false,
        	fileSizeLimit: "10MB",
        	success: function(res){
        		alert(res.urls[0].url);
        		userFace.src = res.urls[0].url;
		    	window.sessionStorage.setItem('userFace',res.urls[0].url);
		    }
        });

        //添加验证规则
        form.verify({
        	
            newPwd : function(value, item){
                if(value.length < 6){
                    return "密码长度不能小于6位";
                }
            },
            confirmPwd : function(value, item){
                if(!new RegExp($("#newPwd").val()).test(value)){
                    return "两次输入密码不一致，请重新输入！";
                }
            }
        })

        //判断是否修改过头像，如果修改过则显示修改后的头像，否则显示默认头像
        if(window.sessionStorage.getItem('userFace')){
        	$("#userFace").attr("src",window.sessionStorage.getItem('userFace'));
        }else{
        	$("#userFace").attr("src","../../images/face.jpg");
        }
        
        //修改密码
        form.on("submit(changePwd)",function(data){
        	
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
 			
 			$.ajax({
 		        url: "/manage/updatePwd.do",
 		        data: { newPwd: $.trim($("#newPwd").val()), oldPwd: $.trim($("#oldPwd").val())},
 		        type: "post",
 		        //dataType: "application/json",//请不要写这个
 		        success: function (data) {
 		        	
 		        	layer.close(index);

 		            if (data.state == undefined || data.state !== 0) {
 		              
 		            	layer.msg('密码修改失败', {icon: 5});

 		            } else {
 		            	
 		            	  layer.msg("密码修改成功！", {icon: 0});
		                  $(".pwd").val('');
 		            }
 		        }
 		    });
 			
 			return false; 
 		})
})

