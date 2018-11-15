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
	roleListInfo();
	
	//加载页面数据
	function roleListInfo(pageData){
		var roleId=$("#roleId").val();
		var roleName=$("#roleName").val();
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		var roleList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\",\"id\":\"" + roleId +"\",\"name\":\"" + roleName +"\"}";
		$.ajax({
			url : "/manage/role/toList.do",
			method: 'POST',
			contentType: "application/json",
			data:roleList,
			success : function(data){
				linksData=data;
				paged(data);
				//执行加载数据的方法
				linksList(linksData);
			},
			error:function(){
				layer.msg("网络异常,请稍后重试");
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
            	roleListInfo();
                layer.close(index);
            },2000);
	})

	//添加角色
	$(".linksAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加角色",
			type : 2,
			content : "/manage/role/showAdd.do",
			success : function(layero, index){
				layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
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
	            		for(var i=0;i<linksData.roles.length;i++){
							if(linksData.roles[i].roleId  == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								$.ajax({
									url : "/manage/role/deleteRole.do",
									method: 'get',
									contentType: "application/json",
									data: {roleId: linksData.roles[i].roleId}, 
								})
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("成功删除");
					location.reload();
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的用户");
		}
	})


   //删除单个
	$("body").on("click",".links_del",function(){
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			for(var i=0;i<linksData.roles.length;i++){
				if(linksData.roles[i].roleId == _this.attr("data-id")){
					$.ajax({
						url : "/manage/role/deleteRole.do",
						method: 'get',
						contentType: "application/json",
						data: {roleId: _this.attr("data-id")}, 
						success : function(data){
							if(data.state==0){
								layer.msg("删除成功");
								roleListInfo();
								location.reload();
							}else{
								layer.msg("删除失败");
							}
						},
						error:function(){
							layer.msg("网络异常,请稍后重试");
						}
					 })
				 }
			}
			layer.close(index);
		});
	})
	
	//异步刷新
	function linksList(){
		$(".links_content").html(renderDate(linksData.roles));
		$('.links_list thead input[type="checkbox"]').prop("checked",false);
		$("#page").html();
		form.render();
		
		function renderDate(currData){
			var dataHtml = '';
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
				    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
				    	+'<td align="left">'+currData[i].roleId+'</td>'
				    	+'<td>'+currData[i].roleName+'</td>'
				    	+'<td>'+currData[i].parentId+'</td>'
				    	+'<td>'+currData[i].memo+'</td>'
				    	+'<td>'+currData[i].updateUser+'</td>'
				    	+'<td>'+currData[i].updateDate+'</td>'
				    	+'<td>'
						+  '<a class="layui-btn layui-btn-mini links_edit" data-id="'+currData[i].roleId+'" href="/manage/role/showUpdate.do?roleId='+currData[i].roleId+'"><i class="iconfont icon-edit"></i>编辑</a>'
						+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+currData[i].roleId+'"><i class="layui-icon">&#xe640;</i> 删除</a>'
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
                          roleListInfo(pageData);
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