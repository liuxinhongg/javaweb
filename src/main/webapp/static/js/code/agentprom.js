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

    agentpromListInfo();

     //加载页面数据
    function agentpromListInfo(pageData){
		
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		$.ajax({
			url : "/code/agentprom/getAgentpromList.do?pageCurrent="+pageCurrent+"&pageSize="+pageSize,
			method: 'POST',
			contentType: "application/json",
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
		var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
        	pageCurrent=1;
        	agentpromListInfo();
            layer.close(index);
        },2000);
})


//异步刷新
function linksList(){
	$(".content1").html(renderDate(linksData.positionRiseConditionPoList));
	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	$("#page").html();
	form.render();
	
	function renderDate(currData){
		var dataHtml = '';
		if(currData.length != 0){
			for(var i=0;i<currData.length;i++){
				dataHtml += '<tr>'
		    	+'<td>'+currData[i].conditionOrd+'</td>'
		    	+'<td>'+currData[i].positionName+'</td>'
				+'<td>'+currData[i].needPositionName+'</td>';
				if(currData[i].standardType == 1){
					dataHtml += '<td>评比合格</td>';
				}
				else if(currData[i].standardType == 2){
					dataHtml += '<td>拥有个人销售小组</td>';
				}
				if(currData[i].highType == 1){
					dataHtml += '<td>拥有高级直接销售小组数</td>';
				}
				else if(currData[i].highType == 2){
					dataHtml += '<td>持续3个月话费总额</td>';
				}
				else if(currData[i].highType == 3){
					dataHtml += '<td>当月产生话费总量</td>';
				}
				dataHtml +='<td>'+currData[i].highValueMin + '-' + currData[i].highValueMax + '</td>'
				+'<td>'+currData[i].operId+'</td>'
				+'<td>'+currData[i].conditionDate.substring(0,10)+'</td>';
				if(currData[i].status==1){
					dataHtml +='<td>有效</td>';
				}
				else{
					dataHtml +='<td>无效</td>';
				}
				dataHtml += '<td>';
		    	if(currData[i].status==1){
		    		dataHtml += '<a class="layui-btn layui-btn-mini links_edit" onclick="javascript:editAgentProm(\''+currData[i].conditionId+'\');"><i class="iconfont icon-edit"></i>编辑</a>'
				             +  '<a class="layui-btn layui-btn-danger layui-btn-mini links_removename" href="javascript:deleteAgentProm(\''+currData[i].conditionId+'\');">删除</a>';
		    	}
				dataHtml +='</td>'
				+'</tr>';
			}
		}else{
			dataHtml = '<tr><td colspan="9">暂无数据</td></tr>';
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
					  agentpromListInfo(pageData);
                }
			}
		});
    });
}
	//添加
	$(".linksAdd_btn").click(function(){
		layer.open({
                    type: 2,
                    title: '新增业务代理人晋升标准',
                    content:['/code/agentprom/toAddPositionRiseCondition.do','no'] ,//不允许出现滚动条
                    area:['720px', '580px']
         });
	})

   window.deleteAgentProm=function(data){
		
        layer.confirm('确定屏蔽此业务代理人晋升标准吗？',{icon:3, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息蔽此中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/code/agentprom/deletePositionRiseConditions.do",
		        data: {conditionIds: data},
		        method: 'POST',
		        success: function (data) {
		        	
		        	layer.close(index);

		            if (data.state == undefined || data.state !== 0) {
		              
		            	layer.msg('蔽此失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("蔽此成功！", {icon: 0});
		            	  setTimeout(function(){
		            	     window.location.reload();
		            	  },500);
		            }
		        }
		    });
			
			return false; 
	   });
   }
   
   window.editAgentProm=function(data){
	   
	   layer.open({
           type: 2,
           title: '编辑业务代理人晋升标准',
           content:['/code/agentprom/toEditPositionRiseCondition.do?conditionId=' + data,'no'] ,//不允许出现滚动条
           area:['720px', '580px']
      });
   }

})