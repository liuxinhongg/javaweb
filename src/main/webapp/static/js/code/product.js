layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
    var linksData = '';
    var pageData='';
    var pageCurrent= 1;//当前页数
    var pageSize=10;
    var searchindex = null;
    
    //产品类型
	$.ajax({
		url : "/code/product/getProductType.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '<option value="">所有规则</option>';
			//执行加载数据的方法
			if(data.productTypeList.length != 0){ 
				for(var i=0;i<data.productTypeList.length;i++){
					dataHtml +='<option value="'+data.productTypeList[i].codeId+'">'+data.productTypeList[i].codeDesc+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#productType").html(dataHtml);
			form.render();
		}	
	})

    productListInfo();

     //加载页面数据
    function productListInfo(pageData){
	
		var productName=$("#productName").val();  //号码精准查询
		var productType=$("#productType").val();  //起始号码
		var isView=$("#isView").val();  //结束号码
		var isIh=$("#isIh").val();  //批次号
		var isKh=$("#isKh").val();  //号码状态
		
		if(pageData!=null){
			pageCurrent=pageData.curr;
		}
		$.ajax({
			url : "/code/product/getProductList.do?productName="+productName+"&productType="+productType+"&isView="
			+isView+"&isIh="+isIh+"&isKh="+isKh+"&pageCurrent="+pageCurrent+"&pageSize="+pageSize,
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
        	productListInfo();
            layer.close(index);
        },2000);
})


//异步刷新
function linksList(){
	$(".links_content").html(renderDate(linksData.proudctPoList));
	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	$("#page").html();
	form.render();
	
	function renderDate(currData){
		var dataHtml = '';
		if(currData.length != 0){
			for(var i=0;i<currData.length;i++){
				dataHtml += '<tr>'
		    	+'<td><input type="checkbox" value="' + currData[i].productId + '" name="querybox"  lay-skin="primary" lay-filter="choose"></td>'
		    	+'<td align="left">'+currData[i].productName+'</td>'
		    	+'<td>'+currData[i].productTypeDesc+'</td>'
				+'<td>'+currData[i].four+'</td>'
				+'<td>'+currData[i].noneFour+'</td>'
				+'<td>'+currData[i].action+'</td>';
				if(currData[i].isView==1){
					dataHtml +='<td>显示</td>';
				}
				else{
					dataHtml +='<td>屏蔽</td>';
				}
				dataHtml += '<td>';
		    	if(currData[i].isView==1){
		    		dataHtml += '<a class="layui-btn layui-btn-mini links_edit" onclick="javascript:editProduct(\''+currData[i].productId+'\');"><i class="iconfont icon-edit"></i>编辑</a>'
				             +  '<a class="layui-btn layui-btn-danger layui-btn-mini links_removename" href="javascript:delProduct(\''+currData[i].productId+'\');">屏蔽</a>';
		    	}
				dataHtml +='</td>'
				+'</tr>';
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
					  productListInfo(pageData);
                }
			}
		});
    });
}
	//添加
	$(".linksAdd_btn").click(function(){
		layer.open({
                    type: 2,
                    title: '新增套餐',
                    content:['/code/product/toAddProduct.do','no'] ,//不允许出现滚动条
                    area:['720px', '480px']
         });
	})

   window.delProduct=function(data){
		
        layer.confirm('确定屏蔽此套餐？',{icon:3, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息蔽此中，请稍候',{icon: 16,time:false,shade:0.8});
			
			$.ajax({
		        url: "/code/product/delProducts.do",
		        data: {productIds: data},
		        method: 'POST',
		        success: function (data) {
		        	
		        	layer.close(index);

		            if (data.state == undefined || data.state !== 0) {
		              
		            	layer.msg('蔽此失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("蔽此成功！", {icon: 0});
		            	  setTimeout(function(){
		            	     window.location.reload();
		            	  },500);
		            }
		        }
		    });
			
			return false; 
	   });
   }
   
   window.editProduct=function(data){
	   
	   layer.open({
           type: 2,
           title: '编辑套餐',
           content:['/code/product/toEditProduct.do?productId=' + data,'no'] ,//不允许出现滚动条
           area:['720px', '480px']
      });
   }
})


