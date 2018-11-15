layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	  
      form.on("submit(addLinks)",function(data){
      	
      	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
      	
      	var status = $("input[name='status']:checked").val();
			
			$.ajax({
		        url: "/code/agentsub/addAgentSub.do",
		        data: {status:status
		        	,totalMoney: $.trim($("#totalMoney").val())
		        	,firstMMoney: $.trim($("#firstMMoney").val())
		        	,secondMMoney: $.trim($("#secondMMoney").val())
		        	,lastMMoney: $.trim($("#lastMMoney").val())
		        	,codeDesc: $.trim($("#codeDesc").val())},
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
