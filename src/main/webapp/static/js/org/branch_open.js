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
	var pageSize=5;
	var searchindex = null;
	
	branchListInfo();
	   
	   function branchListInfo(pageData){
		   
			var branchName=$("#branchName").val();
			
			if(pageData!=null){
				pageCurrent=pageData.curr;
			}
			var userList = "{\"pageCurrent\":\"" + pageCurrent + "\",\"pageSize\":\"" + pageSize + "\"}";
			$.ajax({
				url : "/org/branch/getSampleBranchs.do?branchName=" + branchName,
				method: 'POST',
				contentType: "application/json",
				data:userList,
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
			   searchindex = layer.msg('查询中，请稍候',{icon: 16});
	           pageCurrent=1;
	           branchListInfo() 
	 })

	form.on('radio(choose)', function (data) {
         
         $("#selectBranchId").val(data.value.split(",")[0]);
		 $("#selectBranchName").val(data.value.split(",")[1]);
    });

	//异步刷新
	function linksList(){
		
		$(".links_content").html(renderDate(linksData.branchs));
		$("#page").html();
		form.render();
		
		function renderDate(currData){
			var dataHtml = '';
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
					+'<td><input type="radio" name="choiceBranch" title=" " lay-skin="primary" lay-filter="choose" value="' + currData[i].id + ',' + currData[i].branchName + '"></td>'
			    	+'<td>'+currData[i].branchName+'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="5">暂无数据</td></tr>';
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
						  branchListInfo(pageData);
                    }
				}
			});
        });
    }
 
})