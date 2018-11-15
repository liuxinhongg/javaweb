var $form;
var form;
var $;
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
    var pageSize=10;
    var searchindex = null;
	
	
	 agentListInfo();
	   
	 function agentListInfo(pageData){
			
			if(pageData!=null){
				pageCurrent=pageData.curr;
			}
			var userList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
			$.ajax({
				url : "/org/agent/getAgents.do?noId=" + $("#noId").val()
				+ "&branchName=" + $("#branchName").val() + "&agentName=" + $("#agentName").val() + "&startTime=" + $("#startTime").val()
				+ "&endTime=" + $("#endTime").val() + "&upAgentName=" + $("#upAgentName").val() 
                + "&joinType=" + $("#joinType").val() + "&tel=" + $("#tel").val(),
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
				    	+'<td>'+currData[i].branchName+'</td>'
				    	+'<td>'+currData[i].upBranchName+'</td>'
				    	+'<td>'+currData[i].upAgentName+'</td>'
				    	+'<td>'+currData[i].tel+'</td>'
				    	+'<td>'+currData[i].photo+'</td>'
				    	+'<td>'+currData[i].createDate.substring(0,10)+'</td>';
						if(currData[i].joinType==1){
							dataHtml +='<td>业务员推荐</td>';
						}
						else{
							dataHtml +='<td>营业厅办理</td>';
						}
				    	if(currData[i].status==1){
							dataHtml +='<td>正常</td>';
						}else if(currData[i].status==0){
							dataHtml +='<td>注销</td>';
						}
						else{
							dataHtml +='<td>除名</td>';
						}
				    	dataHtml +='<td>'+currData[i].modifyMan+'</td>'
				    	+'<td>'+currData[i].modifyTime+'</td>'
				    	+'<td>--</td>'
				    	+'<td>--</td>'
				    	+'<td>--</td>'
				    	+'<td>';
				    	if(currData[i].status==1){
				    		dataHtml += '<a class="layui-btn layui-btn-mini links_edit" onclick="javascript:editAgent(\''+currData[i].noId+'\');"><i class="iconfont icon-edit"></i>修改</a>'
						             +  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" onclick="javascript:del(\''+currData[i].noId+'\')"><i class="layui-icon">&#xe640;</i>注销</a>'
						             +  '<a class="layui-btn layui-btn-danger layui-btn-mini links_removename" href="javascript:delete1(\''+currData[i].noId+'\');">除名</a>';
				    	}else if(currData[i].status==0){
							dataHtml +='<a class="layui-btn layui-btn-danger layui-btn-mini links_removename" href="javascript:delete1(\''+currData[i].noId+'\');">除名</a>';
						}
						dataHtml +='</td>'
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
							  branchListInfo(pageData);
	                   }
					}
				});
	       });
	   }
		
		$('.batchDel').click(function () {
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
                        content: '请选择需要注销的业务员信息'
                    });
                    return false;
                }
                layer.confirm('确定注销全部选中业务员吗？',{icon:3, title:'提示信息'},function(index){
                    	var index = layer.msg('信息注销中，请稍候',{icon: 16,time:false,shade:0.8});
 
                        $.ajax({
                            type: 'POST',
                            url: '/org/agent/delAgent.do',
                            data: {'noId': noList},
                            success: function (data) {
                            	
                            	layer.close(index);

        			            if (data.state == undefined || data.state !== 0) {
        			              
        			            	layer.msg('注销失败', {icon: 5});

        			            } else {
        			            	
        			            	  layer.msg("注销成功！", {icon: 0});
        			            	  setTimeout(function(){
        			            	     window.location.reload();
        			            	  },500);
        			            }
                            }
                        });
                        
                        return false; 
                });
       });
		
	   window.del=function(data){
		   layer.confirm('确定注销此业务员吗？',{icon:3, title:'提示信息'},function(index){
				
			    var index = layer.msg('信息注销中，请稍候',{icon: 16,time:false,shade:0.8});
				
				$.ajax({
			        url: "/org/agent/delAgent.do",
			        data: {noId: $.trim(data)},
			        method: 'POST',
			        success: function (data) {
			        	
			        	layer.close(index);

			            if (data.state == undefined || data.state !== 0) {
			              
			            	layer.msg('注销失败', {icon: 5});

			            } else {
			            	
			            	  layer.msg("注销成功！", {icon: 0});
			            	  setTimeout(function(){
			            	     window.location.reload();
			            	  },500);
			            }
			        }
			    });
				
				return false; 
		   });
	   }
	   
		$('.batchDelete').click(function () {
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
                    content: '请选择需要除名的业务员信息'
                });
                return false;
            }
            layer.confirm('确定除名全部选中业务员吗？',{icon:3, title:'提示信息'},function(index){
                	var index = layer.msg('信息除名中，请稍候',{icon: 16,time:false,shade:0.8});

                    $.ajax({
                        type: 'POST',
                        url: '/org/agent/deleteAgent.do',
                        data: {'noId': noList},
                        success: function (data) {
                        	
                        	layer.close(index);

    			            if (data.state == undefined || data.state !== 0) {
    			              
    			            	layer.msg('除名失败', {icon: 5});

    			            } else {
    			            	
    			            	  layer.msg("除名成功！", {icon: 0});
    			            	  setTimeout(function(){
    			            	     window.location.reload();
    			            	  },500);
    			            }
                        }
                    });
                    
                    return false; 
            });
   });
	   
	   //删除
	   window.delete1=function(data){
			
	       layer.confirm('确定将此业务员除名吗？',{icon:3, title:'提示信息'},function(index){
				
			    var index = layer.msg('信息除名中，请稍候',{icon: 16,time:false,shade:0.8});
				
				$.ajax({
			        url: "/org/agent/deleteAgent.do",
			        data: {noId: $.trim(data)},
			        method: 'POST',
			        success: function (data) {
			        	
			        	layer.close(index);

			            if (data.state == undefined || data.state !== 0) {
			              
			            	layer.msg('除名失败', {icon: 5});

			            } else {
			            	
			            	  layer.msg("除名成功！", {icon: 0});
			            	  setTimeout(function(){
			            	     window.location.reload();
			            	  },500);
			            }
			        }
			    });
				
				return false; 
		   });
	   }
	   
	  window.addAgent=function(){
		   
		   var index = layui.layer.open({
				title : "添加业务员",
				type : 2,
				content : "/org/agent/toAddAgent.do",
				success : function(layero, index){
					layui.layer.tips('点击此处返回业务员列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				}
			})
			$(window).resize(function(){
				layui.layer.full(index);
			})
			layui.layer.full(index);
	   }
	  
	   window.editAgent=function(data){
		   
		   var index = layui.layer.open({
				title : "编辑业务员",
				type : 2,
				content : "/org/agent/toEditAgent.do?noId=" + $.trim(data),
				success : function(layero, index){
					layui.layer.tips('点击此处返回业务员列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				}
			})
			$(window).resize(function(){
				layui.layer.full(index);
			})
			layui.layer.full(index);
	   }
	   
})
