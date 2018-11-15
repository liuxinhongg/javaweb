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

    commTelBillListInfo();

     //加载页面数据
    function commTelBillListInfo(pageData){
		
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		$.ajax({
			url : "/code/tellBill/getTellBillList.do?pageCurrent="+pageCurrent+"&pageSize="+pageSize,
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
        	commTelBillListInfo();
            layer.close(index);
        },2000);
})


//异步刷新
function linksList(){
	$(".content1").html(renderDate(linksData.commTelBillPoList));
	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	$("#page").html();
	form.render();
	
	function renderDate(currData){
		var dataHtml = '';
		if(currData.length != 0){
			for(var i=0;i<currData.length;i++){
				dataHtml += '<tr>'
		    	+'<td>'+currData[i].ord+'</td>'
		    	+'<td>'+currData[i].commMin + '-' + currData[i].commMax + '</td>'
				+'<td>'+currData[i].allowance+'</td>'
				+'<td>'+currData[i].operId+'</td>'
				+'<td>'+currData[i].createDate.substring(0,10)+'</td>';
				if(currData[i].status==1){
					dataHtml +='<td>有效</td>';
				}
				else{
					dataHtml +='<td>无效</td>';
				}
				dataHtml += '<td>';
		    	if(currData[i].status==1){
		    		dataHtml += '<a class="layui-btn layui-btn-mini links_edit" onclick="javascript:editCommTelBill(\''+currData[i].telBillId+'\');"><i class="iconfont icon-edit"></i>编辑</a>'
				             +  '<a class="layui-btn layui-btn-danger layui-btn-mini links_removename" href="javascript:delCommTelBill(\''+currData[i].telBillId+'\');">删除</a>';
		    	}
				dataHtml +='</td>'
				+'</tr>';
			}
		}else{
			dataHtml = '<tr><td colspan="8">暂无数据</td></tr>';
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
					  commTelBillListInfo(pageData);
                }
			}
		});
    });
}
	//添加
	$(".linksAdd_btn").click(function(){
		layer.open({
                    type: 2,
                    title: '新增话费补助',
                    content:['/code/tellBill/toAddTellBill.do','no'] ,//不允许出现滚动条
                    area:['720px', '400px']
         });
	})

   window.delCommTelBill=function(data){
		
        layer.confirm('确定屏蔽此话费补助吗？',{icon:3, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息蔽此中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/code/tellBill/deleteCommTelBills.do",
		        data: {positionIds: data},
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
   
   window.editCommTelBill=function(data){
	   
	   layer.open({
           type: 2,
           title: '编辑岗位津贴',
           content:['/code/tellBill/toEditTellBill.do?telBillId=' + data,'no'] ,//不允许出现滚动条
           area:['720px', '400px']
      });
   }
   
   
   
//<!-----------------------------------------------------------分割线------------------------------------------------------------------>

   positionConditionListInfo();

    //加载页面数
   function positionConditionListInfo(){
		
		$.ajax({
			url : "/code/position/getPositionConditionList.do?pageCurrent=1&pageSize=20&conditionType=2",
			method: 'POST',
			contentType: "application/json",
			success : function(data){

				//执行加载数据的方法
				linksList1(data);
				
			},
			error:function(){
				alert("网络异常,请稍后重试");
			}	
		})
	
  }


//异步刷新
function linksList1(linksData1){
	$(".content2").html(renderDate1(linksData1.positionConditionPoList));
	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	form.render();
	
	function renderDate1(currData){
		var dataHtml = '';
		if(currData.length != 0){
			for(var i=0;i<currData.length;i++){
				dataHtml += '<tr>'
		    	+'<td>'+currData[i].conditionOrd+'</td>'
		    	+'<td>'+currData[i].conditionName+'</td>'
				+'<td>X>='+currData[i].conditionX+'</td>'
				+'<td>N>='+currData[i].conditionY+'</td>'
				+'<td>'+currData[i].conditionDesc+'</td>'
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
		    		dataHtml += '<a class="layui-btn layui-btn-mini links_edit" onclick="javascript:editPositionCondition(\''+currData[i].conditionId+'\');"><i class="iconfont icon-edit"></i>编辑</a>'
				             +  '<a class="layui-btn layui-btn-danger layui-btn-mini links_removename" href="javascript:delPositionCondition(\''+currData[i].conditionId+'\');">删除</a>';
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

	//添加
	$(".linksAdd_btn1").click(function(){
		layer.open({
                   type: 2,
                   title: '新增岗位津贴条件',
                   content:['/code/position/toAddPositionCondition.do?conditionType=2','no'] ,//不允许出现滚动条
                   area:['720px', '520px']
        });
	})

  window.delPositionCondition=function(data){
		
       layer.confirm('确定屏蔽此岗位津贴条件信息吗？',{icon:3, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息蔽此中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/code/position/deletePositionConditions.do",
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
  
  window.editPositionCondition=function(data){
	   
	   layer.open({
          type: 2,
          title: '编辑岗位津贴条件',
          content:['/code/position/toEditPositionCondition.do?conditionId=' + data,'no'] ,//不允许出现滚动条
          area:['720px', '520px']
     });
  }

})


