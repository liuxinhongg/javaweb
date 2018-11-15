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
	var pageSize=15;
	userListInfo();
	//加载页面数据
	function userListInfo(pageData){
		var staffId=$("#staffId").val();
		var loginName=$("#loginName").val();
		var state=$("#state option:selected").val();
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		var userList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\",\"id\":\"" + staffId +"\",\"name\":\"" + loginName +"\",\"state\":\"" + state +"\"}";
		$.ajax({
			url : "/manage/user/toList.do",
			method: 'POST',
			contentType: "application/json",
			data:userList,
			success : function(data){
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
            	userListInfo();
                layer.close(index);
            },2000);
	})

	//添加用户
	$(".linksAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加用户",
			type : 2,
			content : "/manage/user/showAdd.do",
			success : function(layero, index){
				layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})
		
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})

	//批量注销
	$(".batchDel").click(function(){
		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定注销选中的用户？',{icon:3, title:'提示信息'},function(index){
 
				var index = layer.msg('注销中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	    
	            	//注销数据
	            	for(var j=0;j<$checked.length;j++){
	            		for(var i=0;i<linksData.users.length;i++){
							if(linksData.users[i].loginId  == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								$.ajax({
									url : "/manage/user/deleteUser.do",
									method: 'get',
									contentType: "application/json",
									data: {loginId: linksData.users[i].loginId}, 
									success : function(data){
									}
								})
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("成功注销");
					userListInfo();
	            },2000);
	        })
		}else{
			layer.msg("请选择需要注销的用户");
		}
	})

   //注销单个
	$("body").on("click",".links_del",function(){
		var _this = $(this);
		layer.confirm('确定注销此用户？',{icon:3, title:'提示信息'},function(index){
			for(var i=0;i<linksData.users.length;i++){
				if(linksData.users[i].loginId == _this.attr("data-id")){
					$.ajax({
						url : "/manage/user/deleteUser.do",
						method: 'get',
						contentType: "application/json",
						data: {loginId: _this.attr("data-id")}, 
						success : function(data){
							if(data.state==0){
								layer.msg("注销成功");
								userListInfo();
							}else{
								layer.msg("注销失败");
							}
						}
					})
				}
			}
			layer.close(index);
		});
	})
	
	//异步刷新
	function linksList(){
		$(".links_content").html(renderDate(linksData.users));
		$('.links_list thead input[type="checkbox"]').prop("checked",false);
		$("#page").html();
		form.render();
		
		function renderDate(currData){
			var dataHtml = '';
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
			    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+'<td align="left">'+currData[i].staffId+'</td>'
			    	+'<td>'+currData[i].loginName+'</td>'
			    	+'<td>'+currData[i].deptName+'</td>';
					if(currData[i].state==1){
					dataHtml +='<td>启用</td>';
					}else{
					dataHtml +='<td>未启用</td>';
					}
					dataHtml +='<td>'+currData[i].regDate+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini links_edit" data-id="'+currData[i].loginId+'" href="/manage/user/showUpdate.do?loginId='+currData[i].loginId+'"><i class="iconfont icon-edit"></i>编辑</a>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+currData[i].loginId+'"><i class="layui-icon">&#xe640;</i> 注销</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="7">暂无数据</td></tr>';
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
                          userListInfo(pageData);
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
 
})