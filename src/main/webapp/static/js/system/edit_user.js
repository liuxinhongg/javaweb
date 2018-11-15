layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
	//创建一个编辑器
 	var editIndex = layedit.build('links_content');
 	//获取用户信息
 	var loginId=GetQueryString('loginId');
	//从地址栏获取ID
    function GetQueryString(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)
        return  unescape(r[2]);
        return null;
     }
	var dataHtml = ''; 
	var department='';
	var roles='';
 	$.ajax({
		url : "/manage/user/showUser.do",
        type : 'post',
        dataType : 'json',
        cache:false, 
        async:false, 
		data:{
    		"loginId" : loginId,
    		},
		success : function(data){
			data=$.parseJSON(data);
			$("#loginId").val(data.user.loginId);
			$("#staffId").val(data.user.staffId);
			$("#loginName").val(data.user.loginName);
			if(data.user.gender==1){
				$('#gender').find('option').eq(1).attr("selected","selected");			
			}else if(data.user.gender==2){
				$('#gender').find('option').eq(2).attr("selected","selected");			
			}else{
				$('#gender').find('option').eq(0).attr("selected","selected");		
			}
			if(data.user.isAdmin=="Y"){
				$('#isAdmin').find('input').eq(0).attr("checked","checked");				
			}
			if(data.user.isAdmin=="N"){
				$('#isAdmin').find('input').eq(1).attr("checked","checked");				
			}
			$('#state').find('option').eq(data.user.state).attr("selected","selected");
			$("#mobilePhone").val(data.user.mobilePhone);
			$("#email").val(data.user.email);
			$("#memo").html(data.user.memo);
			department=data.user.department;
			roles=data.roles;
			form.render();
		},
		error:function(){
			alert("网络异常,请稍后重试");
		}	
	})
 	
    //从后台获取部门列表
	$.ajax({
		url : "/manage/department/listAll.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.depars.length != 0){
				for(var i=0;i<data.depars.length;i++){
					dataHtml+='<option value="'+data.depars[i].deptId+'"';
					if(data.depars[i].deptId==department){
						dataHtml+='selected="selected"';
					}
					dataHtml+='>'+data.depars[i].deptName+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#department").html(dataHtml);
			form.render();
		}
	})
 	
  //从后台获取角色列表
	$.ajax({
		url : "/manage/role/listAll.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.roles.length != 0){
				for(var i=0;i<data.roles.length;i++){
					dataHtml+='<input type="checkbox"';
					for(var j=0;j<roles.length;j++){
						if(data.roles[i].roleId==roles[j].roleId){	
							dataHtml+='checked="checked"';
						}
					}
					dataHtml+='data-id="'+data.roles[i].roleId+'" name="roles" lay-skin="primary" title="'+data.roles[i].roleName+'">';
				}
			}else{
				dataHtml = '';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#role").html(dataHtml);
			form.render();
		}
	})
	
	//自定义验证规则
  form.verify({
	    id : [ /^[a-zA-Z0-9_]{3,16}$/, '只能输入3-16位的数字字母下划线'],
		phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！'],
		email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']
  });

 	form.on("submit(updateLinks)",function(data){
 		var roles = '';
 		var getSelectValueMenbers = $("input[name='roles']:checked").each(function(j) {
 		var i=0;
 		    if (j >= 0) {
 		    	roles += $(this).attr('data-id') + ","
 		    }
 		});
 		var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		$.ajax({
		        url: "/manage/user/update.do",
		        type :'post',
		        dataType :'json',
		        data :{
		        	"id":loginId,
		    		"loginId" : $("#loginId").val(),
		    		"staffId" : $("#staffId").val(),
		    		"password" : $("#password").val(),
		    		"loginName" : $("#loginName").val(),
		    		"gender" : $("#gender").val(),
		    		"department" : $("#department").val(),
		    		"state" : $("#state").val(),
		    		"isAdmin" : $('input:radio[name="isAdmin"]:checked').val(),
		    		"roles" : roles,
		    		"email" : $("#email").val(),
		    		"mobilePhone" : $("#mobilePhone").val(),
		    		"memo" : $("#memo").val(),
		    		},
		        success: function (data) {
		        	data=$.parseJSON(data);
		        	if(data.state==0){
		        		layer.msg("修改用户成功！", {icon: 0});
		        		window.parent.location.reload();
		        	}else{
		        		layer.msg(data.msg, {icon: 5});
		        	}
		        },
		    	error:function(){
		    	    	layer.msg("服务异常，请稍后重试", {icon: 5});	
			       	}	
		    });
 		return false;
 	})
})
