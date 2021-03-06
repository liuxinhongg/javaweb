var $form;
var form;
var $;
layui.config({
	base : "../../js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	//加载页面数据
	var linksData = '';
	$.ajax({
		url : "../../../json/agentList.json",
		type : "get",
		dataType : "json",
		success : function(data){
			linksData = data;
			if(window.sessionStorage.getItem("addAgents")){
				var addAgents = window.sessionStorage.getItem("addAgents");
				linksData = JSON.parse(addLinks).concat(linksData);
			}
			//执行加载数据的方法
			linksList();
		}
	})
	//批量删除
	$(".batchDel").click(function(){
		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	for(var j=0;j<$checked.length;j++){
	            		for(var i=0;i<linksData.length;i++){
							if(linksData[i].linksId == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								linksData.splice(i,1);
								linksList(linksData);
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("删除成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的文章");
		}
	})

	//全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		data.elem.checked;
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})
 
	//编辑
//	$("body").on("click",".links_edit",function(){  //编辑
//          var index = layui.layer.open({
//			title : "编辑业务员",
//			type : 2,
//			content : "editAgent.html",
//			success : function(layero, index){
//				layui.layer.tips('点击此处返回业务员列表', '.layui-layer-setwin .layui-layer-close', {
//					tips: 3
//				});
//			}
//		})
//		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
//		$(window).resize(function(){
//			layui.layer.full(index);
//		})
//		layui.layer.full(index);
//	})

	$("body").on("click",".links_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<linksData.length;i++){
				if(linksData[i].linksId == _this.attr("data-id")){
					linksData.splice(i,1);
					linksList(linksData);
				}
			}
			layer.close(index);
		});
	})
	
	$("body").on("click",".links_saleAmount",function(){  //删除
		var _this = $(this);
		//_this.parents("tr").remove();
		for(var i=0;i<linksData.length;i++){
				if(linksData[i].linksId == _this.attr("data-id")){
					
			       var index = layui.layer.open({
			          title : "业务员销售业绩",
			          type : 2,
			          content : "saleAmount.html",
			          success : function(layero, index){
				            layui.layer.tips('点击此处返回业务员列表', '.layui-layer-setwin .layui-layer-close', {
					        tips: 3
				         });
                       }
                    });
					//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		            $(window).resize(function(){
			            layui.layer.full(index);
		            })
		            layui.layer.full(index);
				}
		   }
		});
	
//	$("body").on("click",".links_saleCards",function(){  
//		var _this = $(this);
//		//_this.parents("tr").remove();
//		for(var i=0;i<linksData.length;i++){
//				if(linksData[i].linksId == _this.attr("data-id")){
//					
//			       var index = layui.layer.open({
//			          title : "业务员经手号卡详情",
//			          type : 2,
//			          content : "saleCards.html",
//			          success : function(layero, index){
//				         layui.layer.tips('点击此处返回业务员列表', '.layui-layer-setwin .layui-layer-close', {
//					     tips: 3
//				      });
//                     }
//                  });
//					//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
//		            $(window).resize(function(){
//			            layui.layer.full(index);
//		            })
//		            layui.layer.full(index);
//				}
//		     }
//	});
	function linksList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = linksData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
			    	+'<td>'+currData[i].totalSaleAmount+'</td>'
			    	+'<td>'+currData[i].serviceCode+'</td>'
			    	+'<td>'+currData[i].userName+'</td>'
			    	+'<td>'+currData[i].area+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].commandName+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
					+'<td>'+currData[i].pic+'</td>'
					+'<td>'+currData[i].joinDate+'</td>'
					+'<td>'+currData[i].joinWay+'</td>'
					+'<td>'+currData[i].optName+'</td>'
					+'<td>'+currData[i].updateDate+'</td>'
					+'<td>'+currData[i].postionName+'</td>'
					+'<td>'+currData[i].updateDate+'</td>'
					+'<td>'+currData[i].totalSaleAmount+'</td>'
					+'<td>'+currData[i].userName+'</td>'
					+'<td>'+currData[i].totalSaleCards+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+data[i].linksId+'"><i class="layui-icon"></i>注销</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="7">暂无数据</td></tr>';
			}
		    return dataHtml;
		}
		//分页
		var nums = 20; //每页出现的数据量
		if(that){
			linksData = that;
		}
		laypage({
			cont : "page",
			pages : Math.ceil(linksData.length/nums),
			jump : function(obj){
				$(".links_content").html(renderDate(linksData,obj.curr));
				$('.links_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})
