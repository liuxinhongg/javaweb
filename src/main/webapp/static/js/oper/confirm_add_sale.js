var $;
layui.config({
	base:'/static/js/index/'
}).use(['form','layer','jquery','laypage'],function(){
	var form=layui.form(),
	layui=parent.layui==undefined?layui.layer:parent.layui,
	laypage=layui.laypage,
	$=layui.jquery;
//	加载页面的数据
   var linksData='';
   $.ajax({
   	type:"get",
   	url:"../../../json/usersList.json",
   	dataType:"json",
   	success:function(data){
   		linksData=data;
   	}
   });
})
