layui.use(['form', 'treetable', 'layer'], function() {

	var layout = [
	              { name: '菜单名称', treeNodes: true, headerClass: 'value_col', colClass: 'value_col', style: 'width: 30%' },
	              {
	            	  name: '操作',
	            	  headerClass: 'value_col',
	            	  colClass: 'value_col',
	            	  style: 'width: 40%',
	            	  render: function(row) {
	            		  data=$.parseJSON(row);
	            		  return "<a class='layui-btn layui-btn-danger layui-btn-sm links_del' data-id='"+data.id+"' onclick='del(" + row + ")'><i class='layui-icon'>&#xe640;</i> 删除</a><a class='layui-btn layui-btn-normal layui-btn-sm ' href='/manage/menu/showUpdate.do?id="+data.id+"'><i class='layui-icon'>&#xe642;</i>修改</a>"; 
	            	  }
	              },
	              ];
    var layer = layui.layer, form = layui.form, $ = layui.jquery;
	var treeData ='';
	tree();
	function tree(){
		$.ajax({
			url : "/manage/menu/toList.do",
			method: 'POST',
			contentType: "application/json",
		    cache:false, 
		    async:false, 
			success : function(data){
				treeData=data.treeMenu;
			}
		})		
	}
    //加载页面数据

    var tree = layui.treetable({
        elem: '#demo', //传入元素选择器
        spreadable: false, //设置是否全展开，默认不展开
        checkbox : true,
        style:'width:10%',
        nodes:treeData,
        layout: layout
    });
    form.render();
    
	//添加菜单
	$("#addMenu").click(function(){
		var index = layui.layer.open({
			title : "添加菜单",
			type : 2,
			content : "/manage/menu/showAdd.do",
			success : function(layero, index){
				layui.layer.tips('点击此处返回菜单列表', '.layui-layer-setwin .layui-layer-close', {
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
		var $checkbox = $('.layui-row input[type="checkbox"][name="checked"]');
		var $checked = $('.layui-row input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的菜单及子菜单？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	for(var j=0;j<$checked.length;j++){
		        		var menuId=$checked.eq(j).parents("tr").find(".links_del").attr("data-id");
		        		$.ajax({
							url : "/manage/menu/deleteMenu.do",
							method: 'get',
							contentType: "application/json",
							data: {id:menuId}, 
							success : function(data){
								if(data.state==0){
									layer.msg("删除成功");
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
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("成功删除");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的菜单");
		}
	})
	
});

function del(obj){
	layer.confirm('确定删除此菜单及子菜单？',{icon:3, title:'提示信息'},function(index){
		layui.jquery.ajax({
					url : "/manage/menu/deleteMenu.do",
					method: 'get',
					contentType: "application/json",
					data: {id:obj.id},
					success : function(data){
						if(data.state==0){
							layer.msg("删除成功");
							location.reload();
						}else{
							layer.msg("删除失败");
						}
					},
					error:function(){
						layer.msg("网络异常,请稍后重试");
					}
			 })
			 layer.close(index);
	    });
}

function showTips1() {
    layer.tips('展开所有节点', '#expand', {
        tips: [1, '#3595CC'],
        time: 3000
    })
}

function showTips2() {
    layer.tips('收起所有节点', '#collapse', {
        tips: [1, '#3595CC'],
        time: 3000
    })
}


function showTips11() {
    layer.tips('展开指定节点', '#expandNode', {
        tips: [1, '#3595CC'],
        time: 3000
    })
}

function showTips12() {
    layer.tips('折叠指定节点', '#collapseNode', {
        tips: [1, '#3595CC'],
        time: 3000
    })
}

function showTips13() {
    layer.tips('勾选 单个节点。', '#checkNode', {
        tips: [1, '#3595CC'],
        time: 3000
    })
}

function showTips14() {
    layer.tips('取消勾选 单个节点。', '#uncheckNode', {
        tips: [2, '#3595CC'],
        time: 3000
    })
}