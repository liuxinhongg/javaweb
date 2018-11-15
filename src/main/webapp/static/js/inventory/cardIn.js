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
		var svcnumber=$("#svcnumber").val();
		var roleName=$("#roleName").val();
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		var roleList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
		$.ajax({
			url : "/manage/role/toList.do?svcnumber"+svcnumber+"&roleName"+roleName,
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
				    	+'<td>'+currData[i].memo+'</td>'
				    	+'<td>'+currData[i].updateUser+'</td>'
				    	+'<td>'+currData[i].updateDate+'</td>'
				    	+'<td>'
						+'<a class="layui-btn layui-btn-mini links_edit data-id="'+currData[i].roleId+' href="/manage/permissions/showUpdate.do?roleId='+currData[i].roleId+'"><i class="iconfont icon-edit"></i>授权</a>'
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

 })