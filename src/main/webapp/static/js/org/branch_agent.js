layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	var linksData = '';
	var pageData='';
	var pageCurrent= 1;//当前页数
	var pageSize=5;
	var searchindex = null;
	
	agentListInfo();
	//加载页面数据
	function agentListInfo(pageData){
		var agentName=$("#agentName").val();
		var noId=$("#noId").val();
		
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		var userList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
		$.ajax({
			url : "/org/branch/getAgents.do?agentName=" + agentName + "&noId=" + noId,
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
			searchindex = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
            pageCurrent=1;
            agentListInfo() 
	})
	
	form.on('radio(choose)', function (data) {
         
         $("#selectAgentNoId").val(data.value.split(",")[0]);
		 $("#selectAgentName").val(data.value.split(",")[1]);
    });

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
					+'<td><input type="radio" name="choiceBranch" title=" " lay-skin="primary" lay-filter="choose" value="' + currData[i].noId + ',' + currData[i].agentName + '"></td>'
			    	+'<td align="left">'+currData[i].noId+'</td>'
			    	+'<td>'+currData[i].agentName+'</td>'
			    	+'<td>'+currData[i].upBranchName+'</td>'
			    	+'<td>'+currData[i].branchName+'</td>'
			    	+'<td>'+currData[i].lvl+'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="5">暂无数据</td></tr>';
			}
			dataHtml=dataHtml.split('undefined').join('');
		    return dataHtml;
		}
	}
	
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
						  agentListInfo(pageData);
                    }
				}
			});
        });
    }
 
})