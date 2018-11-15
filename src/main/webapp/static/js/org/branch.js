layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','tree'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	var linksData = '';
	var pageData='';
	var pageCurrent= 1;//当前页数
	var pageSize=10;
	var searchindex = null;
	gettree();
	function gettree(){
		$.ajax({
			url : "/org/branch/gettree.do",
			method: 'POST',
			contentType: "application/json",
			success : function(data){	
				data = JSON.parse(data);
				layui.tree({
					   elem: '#xtree1' //传入元素选择器
					  ,nodes: data
					     
					});
			},
			error:function(){
				alert("网络异常,请稍后重试");
			}	
	  })
	}
	
   branchListInfo();
   
   function branchListInfo(pageData){
	    var upId=$("#upId").val();
	    
		var branchName=$("#branchName").val();
		var agentName=$("#agentName").val();
		var noId=$("#noId").val();
		
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		var userList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
		$.ajax({
			url : "/org/branch/getBranchs.do?upId=" + upId + "&branchName=" + branchName + "&agentName=" + agentName + "&noId=" + noId,
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
           branchListInfo() 
   })
   
  //异步刷新
  function linksList(){
		$(".links_content").html(renderDate(linksData.branchs));
		$("#page").html();
		form.render();
		
		function renderDate(currData){
			var dataHtml = '';
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
			    	+'<td>'+currData[i].upName+'</td>'
			    	+'<td>'+currData[i].branchName+'</td>'
			    	+'<td>'+currData[i].agentName+'</td>'
			    	+'<td>'+currData[i].noId+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini links_edit" onclick="javascript:edit('+currData[i].id+');"><i class="iconfont icon-edit"></i>修改</a>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" onclick="javascript:del('+currData[i].id+')"><i class="layui-icon">&#xe640;</i> 删除</a>'
					+  '<a class="layui-btn search_btn layui-btn-mini " href="javascript:record('+currData[i].id+');">任命记录</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="5">暂无数据</td></tr>';
			}
			dataHtml=dataHtml.split('undefined').join('');
		    return dataHtml;
		}
	}
   
    //编辑
	$("body").on("click",".links_setion",function(){
		var id = $("#upId").val(); 
		layer.open({
            type: 2,
            title: '编辑分部',
            content:['/org/branch/toEditOrg.do?id=' + id,'no'] ,//不允许出现滚动条
            area:['600px', '450px']
       });
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
	
   window.searchbranchList=function (data){
		
	   $("#upId").val(data);
	   var newArray = [];
	   searchindex = layer.msg('查询中，请稍候',{icon: 16});
       pageCurrent=1;
       branchListInfo();   
   }
   
   window.linksList=function (data){
      layer.msg(data);      
   }
   
   window.del=function(data){
	   layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息删除中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/org/branch/delBatch.do",
		        data: {id: data},
		        method: 'POST',
		        success: function (data) {
		        	
		        	layer.close(index);

		            if (data.state == undefined || data.state !== 0) {
		              
		            	layer.msg('删除失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("删除成功！", {icon: 0});
		            	  setTimeout(function(){
		            	     window.location.reload();
		            	  },1000);
		            }
		        }
		    });
			
			return false; 
	   });
   }
   
   //删除
   window.delorg=function(){
		
		var id = $("#upId").val(); 
		
       layer.confirm('确定删除此分部？',{icon:3, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息删除中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/org/branch/delOrg.do",
		        data: {id: id},
		        method: 'POST',
		        success: function (data) {
		        	
		        	layer.close(index);

		            if (data.state == undefined || data.state !== 0) {
		              
		            	layer.msg('删除失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("删除成功！", {icon: 0});
		            	  setTimeout(function(){
		            	     window.location.reload();
		            	  },500);
		            }
		        }
		    });
			
			return false; 
	   });
   }
   
   window.addorg=function(){
	   
	   layer.open({
                    type: 2,
                    title: '新增分部',
                    content:['/org/branch/toAddOrg.do','no'] ,//不允许出现滚动条
                    area:['600px', '450px']
         });
   }
   
   window.addbatch=function(){
	   
	   layer.open({
                    type: 2,
                    title: '新增分区',
                    content:['/org/branch/toAddBatch.do','no'] ,//不允许出现滚动条
                    area:['600px', '460px'] 
      });
   }
   
   window.edit=function(data){
	   
	   layer.open({
                    type: 2,
                    title: '编辑分部/分区',
                    content:['/org/branch/toEditBatch.do?id=' + data,'no'] ,//不允许出现滚动条
                    area:['600px', '460px']
         });
   }
   
   window.record=function(data){
	   
	    layer.open({
                    type: 2,
                    title: '分区经理任命记录',
                    content:['page/org/branch/record.html','no'] ,//不允许出现滚动条
                    area:['800px', '450px']
         });
   }
})


