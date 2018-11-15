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
	
	cardsListInfo();
	
	//加载页面数据
	function cardsListInfo(pageData){
		
			var simnumber=$("#simnumber").val();  //号码精准查询
			var beginSimNumber=$("#beginSimNumber").val();  //起始号码
			var endSimNumber=$("#endSimNumber").val();  //结束号码
			var snNo=$("#snNo").val();  //批次号
			var status=$("#status").val();  //号码状态
			
			if(pageData!=null){
				pageCurrent=pageData.curr;
			}
			$.ajax({
				url : "/inventory/card/getCardList.do?simnumber="+simnumber+"&beginSimNumber="+beginSimNumber+"&endSimNumber="
				+endSimNumber+"&snNo="+snNo+"&status="+status+"&pageCurrent="+pageCurrent+"&pageSize="+pageSize,
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
            	cardsListInfo();
                layer.close(index);
            },2000);
	})

	//分配全部
	$(".layui-btn-mini").click(function(){
		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定分配选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('分配中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("分配成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要分配的号码");
		}
	})
	
	//异步刷新
	function linksList(){
		$(".links_content").html(renderDate(linksData.cardPoList));
		$('.links_list thead input[type="checkbox"]').prop("checked",false);
		$("#page").html();
		form.render();
		
		function renderDate(currData){
			var dataHtml = '';
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
			    	+'<td><input type="checkbox" value="' + currData[i].id + '" name="querybox"  lay-skin="primary" lay-filter="choose"></td>'
			    	+'<td align="left">'+currData[i].simNumber+'</td>'
			    	+'<td>'+currData[i].branchName+'</td>';
					if(currData[i].operType==0){
					    dataHtml +='<td>导入</td>';		
					}else if(currData[i].operType==1){
					    dataHtml +='<td>分配</td>';		
					}else if(currData[i].operType==2){
					    dataHtml +='<td>出售</td>';		
					}else if(currData[i].operType==3){
					    dataHtml +='<td>回收再分配</td>';		
					}else if(currData[i].operType==4){
					    dataHtml +='<td>回收</td>';		
					}else{
					    dataHtml +='<td>销毁</td>';
					}
					if(currData[i].status==0){
						dataHtml +='<td>不可用</td>';
					}else{
						dataHtml +='<td>可用</td>';
					}
					dataHtml += '<td>'+currData[i].snNo+'</td>';
					if(i == 0){
						dataHtml +='<td rowspan=10>'
	                    +'<span style="display:block;color:green">请先选择要分配的Sim卡，然后选择要移动至的部门，点击《分配》按钮</span>' 
	                    +'选择部门'
                        +'<input type="text" name="" autocomplete="off"  id="branchName" name="branchName" readonly="readonly"  class="layui-input search_input" style="display:inline;width:180px;">'
                        +'&nbsp;&nbsp;<a class="layui-btn search_btn" href="javascript:openBranch();">选择</a><br/><br/>'
                        +'<span id="labelName">单卡押金</span><input type="text" id="deposit" name="deposit" autocomplete="off" placeholder="0"  class="layui-input search_input"  style="display:inline;width:180px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>'
	                    +'<a class="layui-btn search_btn " href="javascript:selectBranch(3);" id="sendall" style="float:right;margin-right:5px;">分配全部</a>'
	                    +'<a class="layui-btn search_btn " href="javascript:selectBranch(1);" id="sendselect" style="float:right;margin-right:15px;">分配选中</a>'
	                    +'<a class="layui-btn search_btn " href="javascript:selectBranch(2);" id="backall" style="float:right;margin-right:5px;display:none;">回收全部</a>'
	                    +'<a class="layui-btn search_btn " href="javascript:selectBranch(0);" id="backselect" style="float:right;margin-right:15px;display:none;">回收选中</a>'
	                    +'</td>';
					}
					dataHtml += '</tr>';
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
						  cardsListInfo(pageData);
                    }
				}
			});
        });
    }
	//全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});
	
	$("#isSend").click(function(){
		
		$("#backall").css('display','none'); 
		$("#backselect").css('display','none');
		
		$("#sendall").css('display',''); 
		$("#sendselect").css('display','');
		$("#deposit").css('display','inline');
		$("#labelName").css('display','');
		
		
	});
	
	$("#isback").click(function(){
		
		$("#sendall").css('display','none'); 
		$("#sendselect").css('display','none');
		$("#deposit").css('display','none');
		$("#labelName").css('display','none');
		
		$("#backall").css('display',''); 
		$("#backselect").css('display','');
	});
	
   //部门选择
   window.openBranch=function(){
		   layer.open({
	                    type: 2,
	                    title: '选择部门',
	                    content:['/org/branch/openBranch.do'] ,//不允许出现滚动条
	                    area:['600px', '480px'] ,
	                    btn: ['确定','关闭'],
	                    yes: function(index, layero){  
	                    	
	                    	$("#branchName").val($(layero).find('iframe')[0].contentWindow.selectBranchName.value);
	                    	$("#branchId").val($(layero).find('iframe')[0].contentWindow.selectBranchId.value);
	                    	
	                    	layer.close(index);
	                    }  
	      });
	}
	
	window.selectBranch=function(saveType){
		
		 if($("#branchId").val() == null || $("#branchId").val() == ''){
			
			layer.msg('请选择部门！', {icon: 5});
			return;
		 }
		 
		 var deposit = $("#deposit").val();  //号码状态
		 
		 if(saveType == 1 || saveType == 3){
				
			 if(deposit == null || deposit == ''){
				 
				layer.msg('请输入单卡押金！', {icon: 5});
				return;
			 }	
	     }
		
		 var optype = "分配选中";
		 if(saveType == 2){	 
			 optype = "分配全部";
		 }
		 else if(saveType == 3){
			 optype = "回收选中";
		 }
		 else if(saveType == 4){
			 optype = "回收全部";
		 }
		 
		 var noList = null;  
         $("input:checkbox[name='querybox']:checked").each(function () {
         	
         	if(noList == null){
         		noList = $(this).val();
         	}
         	else{
         		noList += "," + $(this).val();
         	}
         });

         if (noList == null && (saveType == 1 || saveType == 3)) {
        	 layer.msg('请选择号码！', {icon: 5});
             return;
         }
         
		 
         
         layer.confirm('确定 ' + optype + '的号码吗？',{icon:3, title:'提示信息'},function(index){
             	var index = layer.msg('信息操作中，请稍候',{icon: 16});

                 $.ajax({
                     type: 'POST',
                     url: '/inventory/card/saveCard.do',
                     data: {'cardId': noList,'deposit':deposit,'saveType':saveType,'branchId':$("#branchId").val(),'simnumber':$("#simnumber").val(),'beginSimNumber':$("#beginSimNumber").val(),'endSimNumber':$("#endSimNumber").val(),'snNo':$("#snNo").val(),'status':$("#status").val()},
                     success: function (data) {
                     	
                     	layer.close(index);

 			            if (data.state == undefined || data.state !== 0) {
 			              
 			            	layer.msg('操作失败', {icon: 5});

 			            } else {
 			            	
 			            	  layer.msg("操作成功！", {icon: 0});
 			            	  setTimeout(function(){
 			            	     window.location.reload();
 			            	  },500);
 			            }
                     }
                 });
                 
                 return false; 
         });
    }
	
})
