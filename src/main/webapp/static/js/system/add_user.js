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
					dataHtml+='<option value="'+data.depars[i].deptId+'">'+data.depars[i].deptName+'</option>';
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
					dataHtml+='<input type="checkbox" data-id="'+data.roles[i].roleId+'" name="roles" lay-skin="primary" title="'+data.roles[i].roleName+'">';
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

 	form.on("submit(addLinks)",function(data){
 		var roles = '';
 		var getSelectValueMenbers = $("input[name='roles']:checked").each(function(j) {
 		var i=0;
 		    if (j >= 0) {
 		    	roles += $(this).attr('data-id') + ","
 		    }
 		});
 		var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		$.ajax({
		        url: "/manage/user/addUser.do",
		        type : 'post',
		        dataType : 'json',
		        data :{
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
		        		layer.msg("添加用户成功！", {icon: 0});
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