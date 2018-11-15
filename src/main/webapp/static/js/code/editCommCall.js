layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	var t_status = $("#t_status").val();
	if(t_status == 1){
		  $("input[name='status'][value=1]").attr("checked",true); 
	}
	else{
		  $("input[name='status'][value=0]").attr("checked",true);  
	}
	
	form.render();
	  
    form.on("submit(addLinks)",function(data){
      	
      	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
      	
      	var status = $("input[name='status']:checked").val();
			
			$.ajax({
		        url: "/code/pushmoney/editCommCall.do",
		        data: {status:status
		        	,codeId: $.trim($("#codeId").val())
		        	,firstYRate: $.trim($("#firstYRate").val())
		        	,secondYRate: $.trim($("#secondYRate").val())
		        	,commMin: $.trim($("#commMin").val())
		        	,commMax: $.trim($("#commMax").val())
		        	,codeDesc: $.trim($("#codeDesc").val())
		        	,ord: $.trim($("#ord").val())},
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
