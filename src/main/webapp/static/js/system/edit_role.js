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
	var roleId=GetQueryString('roleId');
	    function GetQueryString(name){
	        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	        var r = window.location.search.substr(1).match(reg);
	        if(r!=null)
	        return  unescape(r[2]);
	        return null;
	     }
	var parentId='';
    //查询角色信息
    $.ajax({
		url : "/manage/role/showRole.do",
        type : 'post',
        dataType : 'json',
        cache:false, 
        async:false, 
		data:{
    		"roleId" : roleId,
    		},
		success : function(data){
			data=$.parseJSON(data);
			parentId=data.role.parentId;
			$("#roleId").val(data.role.roleId);
			$("#roleName").val(data.role.roleName);
			$("#memo").html(data.role.memo);
			form.render();
		},
		error:function(){
			alert("网络异常,请稍后重试");
		}	
	})
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
					if(data.roles[i].roleId==parentId){
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
	         id : [ /^[a-zA-Z0-9_]{3,16}$/, '只能输入3-16位的数字字母下划线'],
          })
	    
        form.on("submit(updateRoleLinks)",function(data){
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
		    	$.ajax({
					url : "/manage/role/update.do",
			        type :'post',
			        dataType :'json',
			        data :{
			        	"id":roleId,
			        	"roleId" : $("#roleId").val(),
			    		"roleName" : $("#roleName").val(),
			    		"memo" : $("#memo").val()
			    		},
					success : function(data){
					 	data=$.parseJSON(data);
					if(data.state==0){
						  layer.msg("修改成功！", {icon: 0});
						  window.parent.location.reload();
						}else{
						  layer.msg(data.msg,{icon: 5});			
						}
					},
		    	    error:function(){
		    	    	layer.msg("服务异常，请稍后重试", {icon: 5});	
			       	}	
		 		})
 			
 			return false; 
        })
  });