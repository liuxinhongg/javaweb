layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','upload'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
			laypage = layui.laypage,
			$ = layui.jquery;
	var linksData = '';
	var pageData='';
	var pageCurrent= 1;//当前页数
	var pageSize=5;
	getDevice();
	
	function getDevice(pageData){
		var deviceName=$("#deviceName").val();
		var state=$("#state option:selected").val();
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		
		deviceList="{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\",\"name\":\"" + deviceName +"\",\"state\":\"" + state +"\"}";
		$.ajax({
			url : "/oper/sale/getDevice.do",
			method: 'POST',
			contentType: "application/json",
			data:deviceList,
			success : function(data){
				linksData=data; 
				paged(data);
				//执行加载数据的方法
				linksList(linksData);
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
            	getDevice();
                layer.close(index);
           },2000);
	})
	
	//异步刷新
	function linksList(){
		$("#device").html(renderDate(linksData.devices));
		$('.links_list thead input[type="checkbox"]').prop("checked",false);
		$("#page").html();
		form.render();
		function renderDate(currData){
			var dataHtml = '';
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
					+'<td><input type="radio" name="choiceBranch" title=" " lay-skin="primary" lay-filter="choose" value="' + currData[i].deviceId + ',' + currData[i].deviceName + '"></td>'
					+'<td>'+currData[i].deviceId+'</td>'
					+'<td>'+currData[i].deviceName+'</td>'
					+'<td>'+currData[i].deduct+'</td>'
					+'<td>'+currData[i].price+'</td>';
					if(currData[i].deviceTypeCode==-1){
					dataHtml +='<td>其他</td></tr>';
					}else if(currData[i].deviceTypeCode==1){
						dataHtml +='<td>手机终端</td></tr>';
					}else if(currData[i].deviceTypeCode==2){
						dataHtml +='<td>上网卡</td></tr>';
					}
				}
			}else{
				dataHtml = '<tr><td colspan="50">暂无数据</td></tr>';
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
						  getDevice(pageData);
                    }
				}
			});
        });
    }
	
	form.on('radio(choose)', function (data) {
        $("#selectDeviceId").val(data.value.split(",")[0]);
		 $("#selectDeviceName").val(data.value.split(",")[1]);
   });

})
