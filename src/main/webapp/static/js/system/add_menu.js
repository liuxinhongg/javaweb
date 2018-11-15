layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
	
    //从后台获取上级列表
	$.ajax({
		url : "/manage/menu/selectMenuAll.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.rootMenu.length != 0){ 
				for(var i=0;i<data.rootMenu.length;i++){
					dataHtml +='<option value="'+data.rootMenu[i].moduleId+'"';
					if(data.rootMenu[i].moduleId=='kb_menu_root'){
					dataHtml+='selected="selected"';
					}
					dataHtml +='>'+data.rootMenu[i].moduleId+'</option>';
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
	         id : [ /^[a-zA-Z0-9_]{0,16}$/, '只能输入数字字母下划线'],
          })
          
	     form.on("submit(addMenu)",function(data){
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
            var moduleId=$("#moduleId").val();
   			var moduleName=$("#moduleName").val();
   			var moduleType=$("#moduleType").val();
   			var parentId=$("#parentId").val();
   			var url=$("#url").val();
   			var ord=$("#ord").val();
   			var toggle=$("#toggle").val();
   			var addMenu = "{\"moduleId\":\"" + moduleId + "\",\"moduleName\":\"" + moduleName + "\",\"moduleType\":\"" + moduleType +"\",\"parentId\":\"" + parentId +"\",\"ord\":\"" + ord +"\",\"url\":\"" + url +"\",\"toggle\":\"" + toggle +"\"}";
		    	$.ajax({
					url : "/manage/menu/addMenu.do",
					method: 'POST',
					contentType: "application/json",
					data: addMenu, 
					success : function(data){
					if(data.state==0){
						  layer.msg("添加成功！", {icon: 0});
						  window.parent.location.reload();
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
})

