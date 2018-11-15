layui.config({
	base : "/static/js/index/"
}).use(['layer','jquery','laypage','element','upload'],function(){
	
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		upload = layui.upload;
	    
		upload.render({ 
		    elem: '#uploadExcel',
			url:'/inventory/numberIn/uploadExcel.do',
			auto: false,
			accept:"file",
			multiple: true,
			bindAction: '#upload',
			before: function(obj){
				 
			     this.data={'branchId':$('#branchId').val()};//关键代码
		    },
		    done: function(data){ 
		    	
		    	if (data.state == undefined || data.state !== 0) {
		              
	            	layer.msg('导入失败', {icon: 5});

	            } else {
	            	
	            	  layer.msg("导入成功！", {icon: 0});
	            	  setTimeout(function(){
	            	     window.location.reload();
	            	  },500);
	           }
		    },error: function(){
		      
		    }
	});
	
	//强制导入
	$("#mandatory").click(function(){
		var simnumber=$("#simnumber").val();
		var svcnumber=$("#svcnumber").val();
           
		    layer.confirm('确定导入？',{icon:5, title:'提示信息'},function(index){
			
		    var index = layer.msg('信息导入中，请稍候',{icon: 16});
			
		    $.ajax({
				url : "/inventory/numberIn/excelMandatory.do",
				data: {simnumber: $.trim($("#simnumber").val()),svcnumber: $.trim($("#svcnumber").val())},
				method: 'POST',
				success : function(data){
		        	
		        	layer.close(index);

		            if (data == undefined || data <= 0) {
		              
		            	layer.msg('导入失败', {icon: 2});

		            } else {
		        
		            	  layer.msg("导入成功！", {icon: 2});
		            	  setTimeout(function(){
		            	     window.location.reload();
		            	  },500);
		            }
		        }
		    
		    });
			
			return false; 
	   });
		
	})
	
	
	
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
	
	
	

 })