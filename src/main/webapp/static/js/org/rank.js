layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
    var linksData = '';
    var pageData='';
    var pageCurrent= 1;//当前页数
    var pageSize=10;
    var searchindex = null;
	
	rankListInfo();
	   
	function rankListInfo(pageData){
			
			if(pageData!=null){
				pageCurrent=pageData.curr;
			}
			var userList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
			$.ajax({
				url : "/org/rank/getRanks.do?noId=" + $("#noId").val() + "&agentName=" + $("#agentName").val() + "&lvl=" + $("#lvl").val(),
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
	           rankListInfo() 
	  })
	   
	 //异步刷新
	 function linksList(){
			
			$(".links_content").html(renderDate(linksData.ranks));
			$("#page").html();
			form.render();
			
			function renderDate(currData){
				var dataHtml = '';
				if(currData.length != 0){
					for(var i=0;i<currData.length;i++){
						dataHtml += '<tr>'
				    	+'<td>'+currData[i].branchName+'</td>'
				    	+'<td>'+currData[i].agentName+'</td>'
				    	+'<td>---</td>'
				    	+'<td>'+currData[i].lvl+'</td>'
				    	+'<td>'+currData[i].rankStr+'</td>'
				    	+'</tr>';
					}
				}else{
					dataHtml = '<tr><td colspan="10">暂无数据</td></tr>';
				}
				dataHtml=dataHtml.split('undefined').join('');
			    return dataHtml;
			}
	}
	  
	//刷新
    $(".batchFlash").click(function(){
			
    	 var index = layer.msg('信息刷新中，请稍候',{icon: 16});
			
			$.ajax({
		        url: "/org/rank/refreshRank.do",
		        method: 'POST',
		        success: function (data) {
		        	
		        	layer.close(index);

		            if (data.state == undefined || data.state !== 0) {
		              
		            	layer.msg('刷新失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("刷新成功！", {icon: 0});
		            	  setTimeout(function(){
		            	     window.location.reload();
		            	  },500);
		            }
		        }
		    });
	})
	   
	 //导出
	 $(".batchExport").click(function(){
		
		var url = "/org/rank/exportrank.do?noId=" + $("#noId").val() + "&agentName=" + $("#agentName").val() + "&lvl=" + $("#lvl").val();
	
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
							  rankListInfo(pageData);
	                   }
					}
				});
	       });
     }  
   
})


