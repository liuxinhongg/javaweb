layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate','upload'],function(){
   var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	 window.choose=function(data){
	    layer.open({
                    type: 2,
                    title: '选择终端',
                    content:['page/businessmanage/opencard/addopencard.html','no'] ,//不允许出现滚动条
                    area:['800px', '450px']
         });
  }
	$(".activate").click(function(){
		var index = layui.layer.open({
			title : "激活确认",
			type : 2,
			content : "activateCard.html",
			success : function(layero, index){
				layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
})
})