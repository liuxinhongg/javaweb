layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	var t_positionId = $("#t_positionId").val();
	var t_needPositionId = $("#t_needPositionId").val();
	
	 //岗位
	  $.ajax({
		url : "/code/position/getPositions.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			var dataHtml1 = '';
			//执行加载数据的方法
			if(data.positionPoList.length != 0){ 
				for(var i=0;i<data.positionPoList.length;i++){
					
					if(t_positionId == data.positionPoList[i].id){
						dataHtml +='<option value="'+data.positionPoList[i].id+'" selected >'+data.positionPoList[i].positionName+'</option>';
					}
					else{
						dataHtml +='<option value="'+data.positionPoList[i].id+'">'+data.positionPoList[i].positionName+'</option>';
					}
					
					if(t_needPositionId == data.positionPoList[i].id){
						dataHtml1 +='<option value="'+data.positionPoList[i].id+'" selected >'+data.positionPoList[i].positionName+'</option>';
					}
					else{
						dataHtml1 +='<option value="'+data.positionPoList[i].id+'">'+data.positionPoList[i].positionName+'</option>';
					}
				}
			}else{
				dataHtml = '<option value="">无</option>';
				dataHtml1 = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#positionId").html(dataHtml);
			$("#needPositionId").html(dataHtml1);
			form.render();
		 }	
	  })
	
	var t_status = $("#t_status").val();
	if(t_status == 1){
		  $("input[name='status'][value=1]").attr("checked",true); 
	}
	else{
		  $("input[name='status'][value=0]").attr("checked",true);  
	}	
	
	var t_standardType = $("#t_standardType").val();
	
	if(t_standardType == 1){
		$("#standardType").html('<option value="1" selected >评比合格</option><option value="2">拥有个人销售小组</option>');
	}
	else{
		$("#standardType").html('<option value="1">评比合格</option><option value="2" selected>拥有个人销售小组</option>');
	}
	
    var t_highType = $("#t_highType").val();
	
	if(highType == 1){
		$("#highType").html('<option value="1" selected >拥有高级直接销售小组数</option><option value="2">持续3个月话费总额</option><option value="3">当月产生话费总量</option>');
	}
	else if(highType == 2){
		$("#highType").html('<option value="1" >拥有高级直接销售小组数</option><option value="2" selected>持续3个月话费总额</option><option value="3">当月产生话费总量</option>');
	}
	else{
		$("#highType").html('<option value="1"  >拥有高级直接销售小组数</option><option value="2">持续3个月话费总额</option><option value="3" selected>当月产生话费总量</option>');
	} 
	
	form.render();
	  
    form.on("submit(addLinks)",function(data){
      	
      	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
      	
      	var status = $("input[name='status']:checked").val();
			
			$.ajax({
		        url: "/code/agentprom/editPositionRiseCondition.do",
		        data: {status:status
		        	,positionId: $.trim($("#positionId").val())
		        	,needPositionId: $.trim($("#needPositionId").val())
		        	,standardType: $.trim($("#standardType").val())
		        	,highType: $.trim($("#highType").val())
		        	,highValueMin: $.trim($("#highValueMin").val())
		        	,highValueMax: $.trim($("#highValueMax").val())
		        	,conditionId: $.trim($("#conditionId").val())
		        	,conditionOrd: $.trim($("#conditionOrd").val())},
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
