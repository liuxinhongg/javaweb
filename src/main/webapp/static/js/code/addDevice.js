layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	 //设备类型
	$.ajax({
		url : "/code/device/getAllDeviceType.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.deviceTypeList.length != 0){ 
				for(var i=0;i<data.deviceTypeList.length;i++){
					dataHtml +='<option value="'+data.deviceTypeList[i].codeId+'">'+data.deviceTypeList[i].codeDesc+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#deviceTypeCode1").html(dataHtml);
			form.render();
		}	
	})
	
	 //业务类型
	$.ajax({
		url : "/code/device/getAllSchemeType.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.schemeTypeList.length != 0){ 
				for(var i=0;i<data.schemeTypeList.length;i++){
					dataHtml +='<option value="'+data.schemeTypeList[i].codeId+'">'+data.schemeTypeList[i].codeDesc+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#schemeTypeCode1").html(dataHtml);
			form.render();
		}	
	 })
	  
      form.on("submit(addLinks)",function(data){
      	
      	var index = layer.msg('提交中，请稍候',{icon: 16});
      	
      	var status = $("input[name='status']:checked").val();
			
			$.ajax({
		        url: "/code/device/addDevice.do",
		        data: {status:status
		        	,deviceName: $.trim($("#deviceName").val())
		        	,deviceDesc: $.trim($("#deviceDesc").val())
		        	,deviceTypeCode: $.trim($("#deviceTypeCode1").val())
		        	,schemeTypeCode: $.trim($("#schemeTypeCode1").val())
		        	,deduct: $.trim($("#deduct").val())
		        	,price: $.trim($("#price").val())},
		        method: 'POST',
		        success: function (data) {
		        	
		        	layer.close(index);

		            if (data.state == undefined || data.state !== 0) {
		              
		            	layer.msg('添加失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("添加成功！", {icon: 0});
		            	  setTimeout(function(){
		            	     window.parent.location.reload();
			                 var index1 = parent.layer.getFrameIndex(window.name);
			                 parent.layer.close(index1);
		            	  },1000);
		            }
		        }
		    });
			
			return false; 
		})
})
