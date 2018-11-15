layui.config({
	base: "/static/js/index/"
}).use(['form', 'treetable', 'layer', 'jquery', 'layedit', 'laydate','tree'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

	var layout = [{
			name: '菜单名称',
			treeNodes: true,
			headerClass: 'value_col',
			colClass: 'value_col',
			style: 'width: 10%'
		},
		{
			name: '查阅权限',
			headerClass: 'value_col',
			colClass: 'value_col',
			style: 'width: 10%',
			render: function(row) {
				var str=JSON.parse(row);
				return "<input class='authRead "+str.id+"' type='checkbox' name='checked' lay-skin='primary' lay-filter='choose2'>";
			}
		},
		{
			name: '创建权限',
			headerClass: 'value_col',
			colClass: 'value_col',
			style: 'width: 10%',
			render: function(row) {
				return "<input class='authCreate' type='checkbox' name='checked' lay-skin='primary' lay-filter='choose2'>";
			}
		}, {
			name: '修改权限',
			headerClass: 'value_col',
			colClass: 'value_col',
			style: 'width: 10%',
			render: function(row) {
				return "<input class='authUpdate' type='checkbox' name='checked' lay-skin='primary' lay-filter='choose2'>";
			}
		}, {
			name: '删除权限',
			headerClass: 'value_col',
			colClass: 'value_col',
			style: 'width: 10%',
			render: function(row) {
				return "<input class='authDelete' type='checkbox' name='checked' lay-skin='primary' lay-filter='choose2'>";
			}
		},
		{
			name: '模块ID',
			headerClass: 'value_col',
			colClass: 'value_col',
			style: 'width: 10%',
			render: function(row) {
				var str=JSON.parse(row);
				return str.id;
			}
		},
		{
			name: '模块类型',
			headerClass: 'value_col',
			colClass: 'neirong',
			style: 'width: 10%',
			render: function(row) {
				var str=JSON.parse(row);
			  return "系统导航模块";
			}
		},

	];
	//查询菜单表列
	var treeData ='';
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
//查询菜单表列非树状
	var rootMenu ='';
		$.ajax({
			url : "/manage/menu/rootMenu.do",
			method: 'POST',
			contentType: "application/json",
		    cache:false, 
		    async:false, 
			success : function(data){
				rootMenu=data.rootMenu;
			}
		})
		
    //加载页面数据
	var tree = layui.treetable({
		elem: '#demo', //传入元素选择器
		spreadable: false, //设置是否全展开，默认不展开
		nodes:treeData,
		layout: layout
	});
		//加载角色信息
		var roleId=GetQueryString('roleId');
 	    function GetQueryString(name){
 	        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
 	        var r = window.location.search.substr(1).match(reg);
 	        if(r!=null)
 	        return  unescape(r[2]);
 	        return null;
 	     }
		var parentId='';
		
	    //查询角色信息
	    $.ajax({
			url : "/manage/permissions/showPermissions.do",
	        type : 'post',
	        dataType : 'json',
	        cache:false, 
	        async:false, 
			data:{
	    		"roleId" : roleId,
	    		},
			success : function(data){
				data=$.parseJSON(data);
				$("#roleId").val(data.role.roleId);
				$("#roleName").val(data.role.roleName);
				 console.log(data);
				 console.log(data.rpses.length);
				for(var i=0;i<data.rpses.length;i++){
					if(data.rpses[i].authRead==1){
						$("."+data.rpses[i].moduleId).parents("tr").find(".authRead").attr("checked","checked" );
					}
					if(data.rpses[i].authCreate==1){
						$("."+data.rpses[i].moduleId).parents("tr").find(".authCreate").attr("checked","checked" );
					}
					if(data.rpses[i].authUpdate==1){
						$("."+data.rpses[i].moduleId).parents("tr").find(".authUpdate").attr("checked","checked" );
					}
					if(data.rpses[i].authDelete==1){
						$("."+data.rpses[i].moduleId).parents("tr").find(".authDelete").attr("checked","checked" );
					}
				}
				form.render();
			},
			error:function(){
				layer.msg("网络异常,请稍后重试");
			}	
		})
    form.on("submit(updatePermissions)",function(row){
    	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
    	 setTimeout(function(){
		var authRead='';
		var authCreate='';
		var authUpdate='';
		var authDelete='';
		var moduleId='';
    	for(var i=0;i<rootMenu.length;i++){
    	moduleId=rootMenu[i].moduleId;
    	if($("."+rootMenu[i].moduleId).parents("tr").find(".authRead").is(':checked')==true){
    		authRead=1;}else{authRead=0;}
    	if($("."+rootMenu[i].moduleId).parents("tr").find(".authCreate").is(':checked')==true){
    		authCreate=1;}else{authCreate=0;}
    	if($("."+rootMenu[i].moduleId).parents("tr").find(".authUpdate").is(':checked')==true){
    		authUpdate=1;}else{authUpdate=0;}
    	if($("."+rootMenu[i].moduleId).parents("tr").find(".authDelete").is(':checked')==true){
    		authDelete=1;
    	}else{authDelete=0;}
    	var updatePermissions = "{\"roleId\":\"" + roleId + "\",\"moduleId\":\"" + moduleId + "\",\"authRead\":\"" + authRead +"\",\"authCreate\":\"" + authCreate +"\",\"authUpdate\":\"" + authUpdate +"\",\"authDelete\":\"" + authDelete +"\"}";  
    	 $.ajax({
 			url : "/manage/permissions/update.do",
 	        type : 'post',
 	        dataType : 'json',
 	       method: 'POST',
			contentType: "application/json",
			data:updatePermissions,
	  	})
    	form.render();
         layer.close(index);
			layer.msg("更改成功");
			window.parent.location.reload();
    	}},2000);
			return false; 
		})

});
