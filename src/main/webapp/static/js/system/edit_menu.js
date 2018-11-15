 layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
	//从url获取id
	var id=GetQueryString('id');
	    function GetQueryString(name){
	        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	        var r = window.location.search.substr(1).match(reg);
	        if(r!=null)
	        return  unescape(r[2]);
	        return null;
	     }
		   $.ajax({
			   url : "/manage/menu/showMenu.do",
			   type : 'post',
			   dataType : 'json',
			   cache:false, 
			   async:false, 
			   data:{
				   "id" : id,
			   },
			   success : function(data){
				   data=$.parseJSON(data);
				   $("#parentId").val(data.menu.parentId);
				   $("#moduleId").val(data.menu.moduleId);
				   $("#moduleName").val(data.menu.moduleName);
				   $("#url").val(data.menu.url);
				   $("#ord").val(data.menu.ord);
				   if(data.menu.moduleType==01){
					   $('#moduleType').find('option').eq(0).attr("selected","selected");			
				   }else if(data.menu.moduleType==02){
					   $('#moduleType').find('option').eq(1).attr("selected","selected");			
				   }else{
					   $('#moduleType').find('option').eq(2).attr("selected","selected");		
				   }
				   if(data.menu.toggle==0){
					   $('#toggle').find('option').eq(0).attr("selected","selected");			
				   }else if(data.menu.toggle==1){
					   $('#toggle').find('option').eq(1).attr("selected","selected");			
				   }else{
					   $('#toggle').find('option').eq(2).attr("selected","selected");		
				   }
				   form.render();
			   },
			   error:function(){
				   alert("网络异常,请稍后重试");
			   }	
		   })
		
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
					dataHtml +='>'+data.rootMenu[i].moduleName+'</option>';
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
          
	     form.on("submit(editMenu)",function(data){
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
            var moduleId=$("#moduleId").val();
   			var moduleName=$("#moduleName").val();
   			var moduleType=$("#moduleType").val();
   			var parentId=$("#parentId").val();
   			var url=$("#url").val();
   			var ord=$("#ord").val();
   			var toggle=$("#toggle").val();
   			var editMenu = "{\"moduleId\":\"" + moduleId + "\",\"moduleName\":\"" + moduleName + "\",\"moduleType\":\"" + moduleType +"\",\"parentId\":\"" + parentId +"\",\"ord\":\"" + ord +"\",\"url\":\"" + url +"\",\"toggle\":\"" + toggle +"\"}";
		    	$.ajax({
					url : "/manage/menu/updateMenu.do",
					method: 'POST',
					contentType: "application/json",
					data: editMenu, 
					success : function(data){
					if(data.state==0){
						  layer.msg("修改成功！", {icon: 0});
						  window.parent.location.reload();
						  parent.location.reload(); // 父页面刷新
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
