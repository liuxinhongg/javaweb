layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
    var linksData = '';
    var pageData='';
    var pageCurrent= 1;//当前页数
    var pageSize=10;
    var searchindex = null;

	//从后台获取分部列表
	$.ajax({
		url : "/org/branch/getOrgs.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml ='<option value="-1">全部分部</option>';
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
	
	 agentListInfo();
	   
	 function agentListInfo(pageData){
			
			if(pageData!=null){
				pageCurrent=pageData.curr;
			}
			var userList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
			$.ajax({
				url : "/org/agent/getAlertAgents.do?upId=" + $("#upId").val()
				+ "&branchName=" + $("#branchName").val() + "&upAgentName=" + $("#upAgentName").val() + "&branchCity=" + $("#branchCity").val(),
				method: 'POST',
				contentType: "application/json",
				data:userList,
				success : function(data){
					
					linksData=data;
					paged(data);
					//执行加载数据的方法
					linksList(linksData);
					
					if(null != searchindex){
						layer.close(searchindex);
					}
				},
				error:function(){
					alert("网络异常,请稍后重试");
				}	
			})
	   }
	   
	   //查询
	   $(".search_btn").click(function(){
		   var newArray = [];
			   searchindex = layer.msg('查询中，请稍候',{icon: 16});
	           pageCurrent=1;
	           agentListInfo() 
	   })
	   
	 //异步刷新
	 function linksList(){
			
			$(".links_content").html(renderDate(linksData.agents));
			$("#page").html();
			form.render();
			
			function renderDate(currData){
				var dataHtml = '';
				if(currData.length != 0){
					for(var i=0;i<currData.length;i++){
						dataHtml += '<tr>'
						+'<td><input type="checkbox" value="' + currData[i].noId + '" name="querybox" lay-skin="primary" lay-filter="choose"></td>'
				    	+'<td>'+currData[i].noId+'</td>'
				    	+'<td>'+currData[i].agentName+'</td>'
				    	+'<td>'+currData[i].tel+'</td>'
				    	+'<td>'+currData[i].branchName+'</td>'
				    	+'<td>'+currData[i].upBranchName+'</td>'
				    	+'<td>'+currData[i].createDate.substring(0,10)+'</td>'
				    	+'<td>4月</td>'
				    	+'<td>'+currData[i].upAgentName+'</td>'
				    	+'<td>'+currData[i].pNoId+'</td>'
				    	+'</tr>';
					}
				}else{
					dataHtml = '<tr><td colspan="10">暂无数据</td></tr>';
				}
				dataHtml=dataHtml.split('undefined').join('');
			    return dataHtml;
			}
	}
	   
	 //导出
	 $(".batchExport").click(function(){
		
		var url = "/org/agent/exportalert.do?upId=" + $("#upId").val() + "&branchName=" + $("#branchName").val() + "&upAgentName=" + $("#upAgentName").val() + "&branchCity=" + $("#branchCity").val();
	
		window.location.href = url;
	 })
	   
	//页码
	function paged(obj){
			layui.use('laypage', function(){
		        var laypage = layui.laypage;
		       	laypage({
					cont : "page",
					pages :obj.pageCount,
					curr:obj.pageCurrent,
					jump : function(data,first){
						  pageData=data;
						  if (!first) {
							  branchListInfo(pageData);
	                   }
					}
				});
	       });
   }  
   
   $('.batchSendSms').click(function () {
       var noList = null;  
       $("input:checkbox[name='querybox']:checked").each(function () {
       	
       	if(noList == null){
       		noList = $(this).val();
       	}
       	else{
       		noList += "," + $(this).val();
       	}
       });

       if (noList == null) {
           layer.open({
               title: '提示',
               content: '请选择业务员'
           });
           return false;
       }
       layer.confirm('确定要给所选业务员发送短信吗？',{icon:3, title:'提示信息'},function(index){
    	   
    	    var sendMyself = $('#myself').attr('checked') == true ? "1" : "0"; 
    	    var sendUpAgent = $('#upAgent').attr('checked') == true ? "1" : "0"; 
    	    var sendBranchManager = $('#branchManager').attr('checked') == true ? "1" : "0"; 
    	    
    	    alert(sendMyself);
    	    alert(sendUpAgent);
    	    alert(sendBranchManager);
    	   
           	var index = layer.msg('短信法宗中，请稍候',{icon: 16,time:false,shade:0.8});

               $.ajax({
                   type: 'POST',
                   url: '/org/agent/sendSMS.do',
                   data: {'noId': noList,'sendMyself':sendMyself,'sendUpAgent':sendUpAgent,'sendBranchManager':sendBranchManager},
                   success: function (data) {
                   	
                   	layer.close(index);

			            if (data.state == undefined || data.state !== 0) {
			              
			            	layer.msg('发送失败', {icon: 5});

			            } else {
			            	
			            	  layer.msg("发送成功！", {icon: 0});
			            	  setTimeout(function(){
			            	     window.location.reload();
			            	  },500);
			            }
                   }
               });
               
               return false; 
       });
});
})


