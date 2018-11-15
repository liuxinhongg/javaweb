layui.config({
	base : "/static/js/index/"
}).use(['form','layer','jquery','layedit','laydate','tree'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	  //产品类型
	  $.ajax({
		url : "/code/product/getProductType.do",
		method: 'GET',
		contentType: "application/json",
		success : function(data){
			var dataHtml = '';
			//执行加载数据的方法
			if(data.productTypeList.length != 0){ 
				for(var i=0;i<data.productTypeList.length;i++){
					dataHtml +='<option value="'+data.productTypeList[i].codeId+'">'+data.productTypeList[i].codeDesc+'</option>';
				}
			}else{
				dataHtml = '<option value="">无</option>';
			}
			dataHtml=dataHtml.split('undefined').join('');
			$("#productType1").html(dataHtml);
			form.render();
		 }	
	  })
	  
      form.on("submit(addLinks)",function(data){
      	
      	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
      	
      	var isView = $("input[name='isView']:checked").val();
      	var isKh = $("input[name='isKh']:checked").val();
      	var isIh = $("input[name='isIh']:checked").val();
			
			$.ajax({
		        url: "/code/product/addProduct.do",
		        data: {isView:isView
		        	,productName: $.trim($("#productName").val())
		        	,productType: $.trim($("#productType1").val())
		        	,action: $.trim($("#action").val())
		        	,four: $.trim($("#four").val())
		        	,noneFour: $.trim($("#noneFour").val())
		        	,isKh: isKh
		        	,isIh: isIh
		        	,productDesc: $.trim($("#productDesc").val())},
		        method: 'POST',
		        success: function (data) {
		        	
		        	layer.close(index);

		            if (data.state == undefined || data.state !== 0) {
		              
		            	layer.msg('添加失败', {icon: 5});

		            } else {
		            	
		            	  layer.msg("添加成功！", {icon: 0});
		            	  setTimeout(function(){
		            	     window.parent.location.reload();
			                 var index1 = parent.layer.getFrameIndex(window.name);
			                 parent.layer.close(index1);
		            	  },1000);
		            }
		        }
		    });
			
			return false; 
		})
})
