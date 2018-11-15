layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	var deviceTypeCode2 = $("#deviceTypeCode2").val();
	var schemeTypeCode2 = $("#schemeTypeCode2").val();
	
	var t_status = $("#t_status").val();
	if(t_status == 1){
		  $("input[name='status'][value=1]").attr("checked",true); 
	}
	else{
		  $("input[name='status'][value=0]").attr("checked",true);  
	}
	
	 form.render();
	
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
					
					if(data.deviceTypeList[i].codeId == deviceTypeCode2){
						dataHtml +='<option value="'+data.deviceTypeList[i].codeId+'" selected>'+data.deviceTypeList[i].codeDesc+'</option>';
					}
					else{
						dataHtml +='<option value="'+data.deviceTypeList[i].codeId+'">'+data.deviceTypeList[i].codeDesc+'</option>';
					}
					
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
					
					if(data.schemeTypeList[i].codeId == schemeTypeCode2){
						dataHtml +='<option value="'+data.schemeTypeList[i].codeId+'" selected>'+data.schemeTypeList[i].codeDesc+'</option>';
					}
					else{
						dataHtml +='<option value="'+data.schemeTypeList[i].codeId+'">'+data.schemeTypeList[i].codeDesc+'</option>';
					}
					
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
		        url: "/code/device/editDevice.do",
		        data: {deviceId:$.trim($("#deviceId").val())
		        	,status:status
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
		              
		            	layer.msg('编辑失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("编辑成功！", {icon: 0});
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
