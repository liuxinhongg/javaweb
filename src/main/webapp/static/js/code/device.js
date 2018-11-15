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
    
    //设备类型
	$.ajax({
		url : "/code/device/getAllDeviceType.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '<option value="">全部</option>';
			//执行加载数据的方法
			if(data.deviceTypeList.length != 0){ 
				for(var i=0;i<data.deviceTypeList.length;i++){
					dataHtml +='<option value="'+data.deviceTypeList[i].codeId+'">'+data.deviceTypeList[i].codeDesc+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#deviceTypeCode").html(dataHtml);
			form.render();
		}	
	})
	
	 //业务类型
	$.ajax({
		url : "/code/device/getAllSchemeType.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '<option value="">全部</option>';
			//执行加载数据的方法
			if(data.schemeTypeList.length != 0){ 
				for(var i=0;i<data.schemeTypeList.length;i++){
					dataHtml +='<option value="'+data.schemeTypeList[i].codeId+'">'+data.schemeTypeList[i].codeDesc+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#schemeTypeCode").html(dataHtml);
			form.render();
		}	
	})

    deviceListInfo();

     //加载页面数据
    function deviceListInfo(pageData){
	
		var deviceName=$("#deviceName").val();  
		var deviceDesc=$("#deviceDesc").val();  
		var deviceTypeCode=$("#deviceTypeCode").val();  
		var schemeTypeCode=$("#schemeTypeCode").val();  
		var status=$("#status").val();  
		
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		$.ajax({
			url : "/code/device/getDeviceList.do?deviceName="+deviceName+"&deviceDesc="+deviceDesc+"&deviceTypeCode="
			+deviceTypeCode+"&schemeTypeCode="+schemeTypeCode+"&status="+status+"&pageCurrent="+pageCurrent+"&pageSize="+pageSize,
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
        	idDelete=0;
        	pageCurrent=1;
        	deviceListInfo();
            layer.close(index);
        },2000);
})


//异步刷新
function linksList(){
	$(".links_content").html(renderDate(linksData.devicePoList));
	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	$("#page").html();
	form.render();
	
	function renderDate(currData){
		var dataHtml = '';
		if(currData.length != 0){
			for(var i=0;i<currData.length;i++){
				dataHtml += '<tr>'
		    	+'<td><input type="checkbox" value="' + currData[i].deviceId + '" name="querybox"  lay-skin="primary" lay-filter="choose"></td>'
		    	+'<td align="left">'+currData[i].deviceName+'</td>'
		    	+'<td>'+currData[i].deviceDesc+'</td>'
				+'<td>'+currData[i].deviceTypeDesc+'</td>'
				+'<td>'+currData[i].schemeTypeDesc+'</td>'
				+'<td>'+currData[i].deduct+'</td>'
				+'<td>'+currData[i].price+'</td>';
				if(currData[i].status==1){
					dataHtml +='<td>有效</td>';
				}
				else{
					dataHtml +='<td>无效</td>';
				}
				dataHtml += '<td>';
		    	if(currData[i].status==1){
		    		dataHtml += '<a class="layui-btn layui-btn-mini links_edit" onclick="javascript:editDevice(\''+currData[i].deviceId+'\');"><i class="iconfont icon-edit"></i>编辑</a>'
				             +  '<a class="layui-btn layui-btn-danger layui-btn-mini links_removename" href="javascript:delDevice(\''+currData[i].deviceId+'\');">删除</a>';
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
					  deviceListInfo(pageData);
                }
			}
		});
    });
}
	//添加
	$(".linksAdd_btn").click(function(){
		layer.open({
                    type: 2,
                    title: '新增设备',
                    content:['/code/device/toAddDevice.do','no'] ,//不允许出现滚动条
                    area:['720px', '480px']
         });
	})

   window.delDevice=function(data){
		
        layer.confirm('确定删除此设备信息吗？',{icon:3, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息删除中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/code/device/deleteDevices.do",
		        data: {deviceIds: data},
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
                content: '请选择需要删除的设备信息'
            });
            return false;
        }
        layer.confirm('确定删除全部选中的设备信息吗？',{icon:3, title:'提示信息'},function(index){
            	var index = layer.msg('信息删除中，请稍候',{icon: 16});

                $.ajax({
                    type: 'POST',
                    url: '/code/device/deleteDevices.do',
                    data: {'deviceIds': noList},
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
   });
   
   window.editDevice=function(data){
	   
	   layer.open({
           type: 2,
           title: '编辑套餐',
           content:['/code/device/toEditDevice.do?deviceId=' + data,'no'] ,//不允许出现滚动条
           area:['720px', '480px']
      });
   }
})