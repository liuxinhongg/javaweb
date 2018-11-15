layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	  //岗位
	  $.ajax({
		url : "/code/position/getPositions.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.positionPoList.length != 0){ 
				for(var i=0;i<data.positionPoList.length;i++){
					dataHtml +='<option value="'+data.positionPoList[i].id+'">'+data.positionPoList[i].positionName+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#positionId").html(dataHtml);
			$("#needPositionId").html(dataHtml);
			form.render();
		 }	
	  })
	  
      form.on("submit(addLinks)",function(data){
      	
      	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
      	
      	var status = $("input[name='status']:checked").val();
			
			$.ajax({
		        url: "/code/agentprom/addPositionRiseCondition.do",
		        data: {status:status
		        	,positionId: $.trim($("#positionId").val())
		        	,needPositionId: $.trim($("#needPositionId").val())
		        	,standardType: $.trim($("#standardType").val())
		        	,highType: $.trim($("#highType").val())
		        	,highValueMin: $.trim($("#highValueMin").val())
		        	,highValueMax: $.trim($("#highValueMax").val())
		        	,conditionOrd: $.trim($("#conditionOrd").val())},
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
