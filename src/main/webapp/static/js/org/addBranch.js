layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
	
	  //从后台获取分部列表
	  $.ajax({
		url : "/org/branch/getOrgs.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.length != 0){
				
				for(var i=0;i<data.length;i++){
					dataHtml+='<option value="'+data[i].id+'">'+data[i].branchName+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#upId").html(dataHtml);
			form.render();
		  }
	   })
	
	   window.selectAgent=function(data){
		   
		    layer.open({
	                    type: 2,
	                    title: '选择分区经理 ',
	                    content:['/org/branch/agents.do','no'] ,//不允许出现滚动条
	                    area:['800px', '500px'],
	                    btn: ['确定','关闭'],
	                    yes: function(index, layero){  
	                    	
	                    	$("#agentName").val($(layero).find('iframe')[0].contentWindow.selectAgentName.value);
	                    	$("#noId").val($(layero).find('iframe')[0].contentWindow.selectAgentNoId.value);
	                    	
	                    	layer.close(index);
	                    }  
	         });
	   }
	  
      form.on("submit(addLinks)",function(data){
      	
      	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/org/branch/addBatch.do",
		        data: {branchName: $.trim($("#branchName").val()),upId: $.trim($("#upId").val()),noId: $.trim($("#noId").val()),status: $.trim($("#status").val()),effectMonth: $.trim($("#effectMonth").val())},
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
