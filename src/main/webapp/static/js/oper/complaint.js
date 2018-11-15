layui.config({
	base : "../../js/"
}).use(['upload','laydate','form','layer','jquery','laypage'],function(){
	var form = layui.form(),
	    layer = parent.layer === undefined ? layui.layer : parent.layer,
	    laypage = layui.laypage,
	    $ = layui.jquery;
	
	var linksData = '';
	var pageData='';
	var pageCurrent= 1;//当前页数
	var pageSize=2;
	complaintInfo();

	//加载页面数据
	function complaintInfo(pageData){
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		var saleList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
		$.ajax({
			url : "/oper/complaint/getComplaint.do?"
			+"svcNumber="+$("#svcNumber").val()
			+"&branchManagerName="+$("#branchManagerName").val()
			+"&agentName="+$("#agentName").val()
			+"&operatorName="+$("#operatorName").val()
			+"&operOrgId="+$("#operOrg").val()
			+"&branchId="+$("#branch").val()
			+"&status="+$('#status option:selected') .val()
			+"&endRecord="+$('#endRecord option:selected') .val()
			+"&isOver="+$("input[name='isOver']:checked").val()
			+"&saleDateStart="+$("#saleDateStart").val()
			+"&saleDateEnd="+$("#saleDateEnd").val()
			+"&branchCity="+$("input[name='branchCity']:checked").val(),
			method: 'POST',
			contentType: "application/json",
			data:saleList,
			success : function(data){
				console.log(data);
				linksData=data; 
				paged(data);
				//执行加载数据的方法
				linksList(linksData);
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
            	complaintInfo();
                layer.close(index);
            },2000);
	})

	
	//异步刷新
	function linksList(){
		$(".links_content").html(renderDate(linksData.complaints));
		$('.links_list thead input[type="checkbox"]').prop("checked",false);
		$("#page").html();
		form.render();
		function renderDate(currData){		
			var dataHtml = '';
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					var no=i+1
					dataHtml +='<tr><td>'+no+'</td>'
						+'<td>'+currData[i].saleDate+'</td>'
						+'<td>'+currData[i].svcNumber+'</td>'
						+'<td>'+currData[i].complainName+'</td>'
						+'<td>'+currData[i].saleDate+'</td>'
						+'<td>'+currData[i].productId+'</td>'
						+'<td>'+currData[i].deviceId+'</td>'
						+'<td>'+currData[i].memo+'</td>'
						+'<td>'+currData[i].status+'</td>'
						+'<td>'+currData[i].operatorName+'</td>'
						+'<td>'+currData[i].operatorId+'</td>'
						+'<td>'+currData[i].operatorStatus+'</td>'
						+'<td>'+currData[i].operatorRecord+'</td>'
						+'<td>'+currData[i].agentName+'</td>'
						+'<td>'+currData[i].noId+'</td>'
						+'<td>'+currData[i].branchName+'</td>'
						+'<td>'+currData[i].branchId+'</td>'
						+'<td>'+currData[i].agentStatus+'</td>'
						+'<td>'+currData[i].agentRecord+'</td>'
						+'<td>'+currData[i].agentDate+'</td>'
						+'<td>'+currData[i].branchManagerName+'</td>'
						+'<td>'+currData[i].branchManagerId+'</td>'
						+'<td>'+currData[i].branchStatus+'</td>'
						+'<td>'+currData[i].branchRecord+'</td>'
						+'<td>'+currData[i].branchDate+'</td>'
						+'<td>'+currData[i].operOrgManagerName+'</td>'
						+'<td>'+currData[i].operOrgManagerId+'</td>'
						+'<td>'+currData[i].operOrgStatus+'</td>'
						+'<td>'+currData[i].operOrgRecord+'</td>'
						+'<td>'+currData[i].operOrgDate+'</td>'
						+'<td>'+currData[i].endStatus+'</td>'
						+'<td>'+currData[i].isOver+'</td>'
						+'<td>'+currData[i].overData+'</td>'
						+'<td>'+currData[i].endRecord+'</td>'
						+'<td>'+currData[i].operId+'</td>'
						+'<td>'+currData[i].operData+'</td>'
						+'<td>代理人、分区经理、分部经理、全部</td>'
						+'<td><a class="layui-btn layui-btn-mini links_edit" onclick="javascript:editAgent('+currData[i].complainId+');"><i class="iconfont icon-edit"></i>派单</a><a class="layui-btn layui-btn-danger layui-btn-mini links_del" onclick="javascript:del('+currData[i].complainId+')"><i class="layui-icon"></i>完结</a></td></tr>';	
				}
			}else{
				dataHtml = '<tr><td colspan="50">暂无数据</td></tr>';
			}
			dataHtml=dataHtml.split('undefined').join('');
		    return dataHtml;
		}
	}
	
	 //导出
	 $(".batchExport").click(function(){
		var url = "/oper/complaint/exportrank.do?"
			+"svcNumber="+$("#svcNumber").val()
			+"&branchManagerName="+$("#branchManagerName").val()
			+"&agentName="+$("#agentName").val()
			+"&operatorName="+$("#operatorName").val()
			+"&operOrgId="+$("#operOrg").val()
			+"&branchId="+$("#branch").val()
			+"&status="+$('#status option:selected') .val()
			+"&endRecord="+$('#endRecord option:selected') .val()
			+"&isOver="+$("input[name='isOver']:checked").val()
			+"&saleDateStart="+$("#saleDateStart").val()
			+"&saleDateEnd="+$("#saleDateEnd").val()
			+"&branchCity="+$("input[name='branchCity']:checked").val();
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
							  complaintInfo(pageData);
	                     }
					}
				});
	        });
	    }
	 
	  //从后台获取分部列表
	  $.ajax({
		url : "/org/branch/getAllBrachPoNotRTree.do",
		method: 'POST',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.barches.length != 0){
				dataHtml += '<option value="">-- 请选择 --</option>';
				for(var i=0;i<data.barches.length;i++){
					dataHtml+='<option value="'+data.barches[i].id+'" ">'+data.barches[i].branchName+'</option>';
				}
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#operOrg").html(dataHtml);
			form.render();
		  }
	   })
	   
	     //二级联动出现分区
       form.on('select(myselect)', function(data){
	       console.log("123");
	       if(data.value==""){
	        $("#branch").html('<option value="" >-- 请选择 --</option>');
	        form.render();	
	          }else{	
		     $.ajax({
			 url : "/org/branch/getAllBrachByUpId.do",
			  type :'post',
			   dataType :'json',
			     data :{"upId":data.value,},
			    success: function(data){
				data=$.parseJSON(data);
				var dataHtml = '';
				//执行加载数据的方法
				if(data.barches.length != 0){
					dataHtml+='<option value="" >-- 请选择 --</option>';
					for(var i=0;i<data.barches.length;i++){
						dataHtml+='<option value="'+data.barches[i].id+'" ">'+data.barches[i].branchName+'</option>';
					}
				}else{
					dataHtml+='<option value="" >-- 无 --</option>';
				}
				dataHtml=dataHtml.split('undefined').join('');
				$("#branch").html(dataHtml);
				form.render();
			         }
			    }); 
	         }
     });
	 
		//一个季度
		  $("#getBeforeApril").click(function getBeforeApril(){
			var date =new Date();   
		     var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);  
		     var strYear = date.getFullYear();    
		     var strDay = date.getDate();
		     var strMonth = date.getMonth()+1;  
		     if(strYear%4 == 0 && strYear%100 != 0){  
		        daysInMonth[2] = 29;  
		     } 
		     if(strMonth - 3 <= 0)  
		     {  
		        strYear -= 1;  
		        strMonth = 12+strMonth-3;  
		     }  
		     else  
		     {  
		        strMonth -= 3;  
		     }  
		     strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];  
		     if(strMonth<10)
		     {    
		        strMonth="0"+strMonth;    
		     }  
		     if(strDay<10)    
		     {    
		        strDay="0"+strDay;    
		     }  
		     datastr = strYear+"-"+strMonth+"-"+strDay;  
		   $("#saleDateStart").val(datastr);
		    var getMonth = date.getMonth()+1;  
		   $("#saleDateEnd").val(date.getFullYear()+"-"+getMonth+"-"+date.getDate());
		  } )
		
		//半年
		  $("#getHalfYear").click(function getHalfYear(){  
			var date =new Date();   
		     var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);  
		     var strYear = date.getFullYear();    
		     var strDay = date.getDate();
		     var strMonth = date.getMonth()+1;  
		     if(strYear%4 == 0 && strYear%100 != 0){  
		        daysInMonth[2] = 29;  
		     } 
		     if(strMonth - 6 <= 0)  
		     {  
		        strYear -= 1;  
		        strMonth = 12+strMonth-6;  
		     }  
		     else  
		     {  
		        strMonth -= 6;  
		     }  
		     strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];  
		     if(strMonth<10)
		     {    
		        strMonth="0"+strMonth; 
		     }  
		     if(strDay<10)    
		     {    
		        strDay="0"+strDay;    
		     }  
		     datastr = strYear+"-"+strMonth+"-"+strDay;  
		   $("#saleDateStart").val(datastr);
		    var getMonth = date.getMonth()+1;  
		   $("#saleDateEnd").val(date.getFullYear()+"-"+getMonth+"-"+date.getDate());
		  })
		
		 //一月前
		   $("#getLastMonthYestdy").click(function getLastMonthYestdy(){  
			var date =new Date();   
		     var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);  
		     var strYear = date.getFullYear();    
		     var strDay = date.getDate();
		     var strMonth = date.getMonth()+1;  
		     if(strYear%4 == 0 && strYear%100 != 0){  
		        daysInMonth[2] = 29;  
		     }  
		     if(strMonth - 1 == 0)  
		     {  
		        strYear -= 1;  
		        strMonth = 12;  
		     }  
		     else  
		     {  
		        strMonth -= 1;  
		     }  
		     strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];  
		     if(strMonth<10)    
		     {    
		        strMonth="0"+strMonth;    
		     }  
		     if(strDay<10)    
		     {    
		        strDay="0"+strDay;    
		     }  
		     datastr = strYear+"-"+strMonth+"-"+strDay;  
		   $("#saleDateStart").val(datastr);
		    var getMonth = date.getMonth()+1;  
		   $("#saleDateEnd").val(date.getFullYear()+"-"+getMonth+"-"+date.getDate());
		  })
		    
		  //一年前  
		  $("#getLastYearYestdy").click(function getLastYearYestdy(){  
			var date =new Date();   
		     var strYear = date.getFullYear() - 1;    
		     var strDay = date.getDate();    
		     var strMonth = date.getMonth()+1;  
		     if(strMonth<10)    
		     {    
		        strMonth="0"+strMonth;    
		     }  
		     if(strDay<10)    
		     {    
		        strDay="0"+strDay;    
		     }  
		     datastr = strYear+"-"+strMonth+"-"+strDay;  
		   $("#saleDateStart").val(datastr);
		    var getMonth = date.getMonth()+1;  
		   $("#saleDateEnd").val(date.getFullYear()+"-"+getMonth+"-"+date.getDate());
		  } )
		
})
