layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	//加载上级部门
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
			laypage = layui.laypage,
			layedit = layui.layedit,
			laydate = layui.laydate,
			$ = layui.jquery;
    var resCode=false;
    
    //从后台获取上级列表
	$.ajax({
		url : "/manage/role/selectRoleAll.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.roles.length != 0){ 
				for(var i=0;i<data.roles.length;i++){
					dataHtml +='<option value="'+data.roles[i].roleId+'"';
					if(data.roles[i].roleId=='defualt_oper'){
					dataHtml+='selected="selected"';
					}
					dataHtml +='>'+data.roles[i].roleName+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#parentId").html(dataHtml);
			form.render();
		}	
	})

	    form.verify({
	         id : [ /^[a-zA-Z0-9_]{3,16}$/, '只能输入数字字母下划线'],
          })
	    
        form.on("submit(addroleLinks)",function(data){
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
            var roleId=$("#roleid").val();
   			var roleName=$("#rolename").val();
   			var memo=$("#memo").val();
   			var parentId=$("#parentId").val();
   			var addRole = "{\"roleId\":\"" + roleId + "\",\"roleName\":\"" + roleName + "\",\"memo\":\"" + memo +"\",\"parentId\":\"" + parentId +"\"}";
		    	$.ajax({
					url : "/manage/role/addRole.do",
					method: 'POST',
					contentType: "application/json",
					data: addRole, 
					success : function(data){
					if(data.state==0){
						  layer.msg("添加成功！", {icon: 0});
						  window.parent.location.reload();
						  location.reload();
						}else{
						  layer.msg(data.msg, {icon: 5});							
						}
					},
		    	    error:function(){
		    	    	layer.msg("服务异常，请稍后重试", {icon: 5});	
			       	}	
		 		})
 			
 			return false; 
      })
  });
