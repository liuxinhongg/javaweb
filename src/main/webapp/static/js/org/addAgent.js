layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

	//创建一个编辑器
 	var editIndex = layedit.build('links_content');
 	var addLinksArray = [],addLinks;
 	form.on("submit(addLinks)",function(data){
 		//是否添加过信息
	 	if(window.sessionStorage.getItem("addLinks")){
	 		addLinksArray = JSON.parse(window.sessionStorage.getItem("addLinks"));
	 	}
	 	//显示、审核状态
 		var homePage = data.field.homePage=="on" ? "首页" : "",
 			subPage = data.field.subPage=="on" ? "子页" : "";
 			showAddress = '';
 		if(subPage == '' && homePage == ''){
 			showAddress = "暂不展示";
 		}else if(homePage == ''){
 			showAddress = subPage;
 		}else if(subPage == ''){
 			showAddress = homePage;
 		}else{
 			showAddress = homePage + '，' + subPage;
 		}

 		addLinks = '{"linksName":"'+ $(".linksName").val() +'",';  //用户工号
 		addLinks += '"linksusername":"'+ $(".linksusername").val() +'",';	 //用户姓名
 		addLinks += '"Oselect":"'+ $(".Oselect option:checked").text() +'",'; //站点描述
 		addLinks += '"masterPart":"'+ $(".masterPart").val() +'",'; //所在部门
 		addLinks += '"masterTime":"'+ $(".masterTime").val() +'",'; //时间
 		addLinks += '"showAddress":"'+ showAddress +'"}';  //展示位置
 		addLinksArray.unshift(JSON.parse(addLinks));
 		window.sessionStorage.setItem("addLinks",JSON.stringify(addLinksArray));
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.5});
        setTimeout(function(){
            top.layer.close(index);
			top.layer.msg("文章添加成功！");
 			layer.closeAll("iframe");
	 		//刷新父页面
	 		parent.location.reload();
        },2000);
 		return false;
		

 	})
})

function openimg(){
	
	location.href="wordpic.html";
}

