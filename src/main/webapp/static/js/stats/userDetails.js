var $form;
var form;
var $;
layui.config({
	base : "../js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	//加载页面数据
	var linksData = '';
	$.ajax({
		url : "../../../json/agentList.json",
		type : "get",
		dataType : "json",
		success : function(data){
			linksData = data;
			if(window.sessionStorage.getItem("addAgents")){
				var addAgents = window.sessionStorage.getItem("addAgents");
				linksData = JSON.parse(addLinks).concat(linksData);
			}
			//执行加载数据的方法
			linksList();
		}
	})
	//短息页面的添加
	$(".message").click(function(){
		var index=layui.layer.open({
			title:"短信提示",
			type:2,
			content:"usermessage.html",
			success : function(layero, index){
				layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		});
		$(window).resize(function(){
			layui.layer.full(index)
		})
		layui.layer.full(index);
	})
	//查询
	$(".search_btn").click(function(){
		var newArray = [];
		if($(".ssfb option:checked").text() != ''||$(".ssfq option:checked").text() != ''|| $(".starttime").val()!=''||$(".endtime").val()){
			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
            	$.ajax({
					url : "../../../json/agentList.json",
					type : "get",
					dataType : "json",
					success : function(data){
						if(window.sessionStorage.getItem("addLinks")){
							var addLinks = window.sessionStorage.getItem("addLinks");
							linksData = JSON.parse(addLinks).concat(data);
						}else{
							linksData = data;
						}
						for(var i=0;i<linksData.length;i++){
							var linksStr = linksData[i];
							var selectStr = $(".ssfb option:checked").text();
		            		function changeStr(data){
		            			var dataStr = '';
		            			var showNum = data.split(eval("/"+selectStr+"/ig")).length - 1;
		            			if(showNum > 1){
									for (var j=0;j<showNum;j++) {
		            					dataStr += data.split(eval("/"+selectStr+"/ig"))[j] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>";
		            				}
		            				dataStr += data.split(eval("/"+selectStr+"/ig"))[showNum];
		            				return dataStr;
		            			}else{
		            				dataStr = data.split(eval("/"+selectStr+"/ig"))[0] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>" + data.split(eval("/"+selectStr+"/ig"))[1];
		            				return dataStr;
		            			}
		            		}
		            		//网站名称
		            		if(linksStr.linksName.indexOf(selectStr) > -1){
			            		linksStr["linksName"] = changeStr(linksStr.linksName);
		            		}
		            		//网站地址
		            		if(linksStr.linksUrl.indexOf(selectStr) > -1){
			            		linksStr["linksUrl"] = changeStr(linksStr.linksUrl);
		            		}
		            		//
		            		if(linksStr.showAddress.indexOf(selectStr) > -1){
			            		linksStr["showAddress"] = changeStr(linksStr.showAddress);
		            		}
		            		if(linksStr.linksName.indexOf(selectStr)>-1 || linksStr.linksUrl.indexOf(selectStr)>-1 || linksStr.showAddress.indexOf(selectStr)>-1){
		            			newArray.push(linksStr);
		            		}
		            	}
		            	linksData = newArray;
		            	linksList(linksData);
					}
				})
            	
                layer.close(index);
            },2000);
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})

	function linksList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = linksData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
					+'<td>'+currData[i].totalSaleAmount+'</td>'
			    	+'<td>'+currData[i].serviceCode+'</td>'
			    	+'<td>'+currData[i].totalSaleAmount+'</td>'
			    	+'<td>'+currData[i].serviceCode+'</td>'
			    	+'<td>'+currData[i].userName+'</td>'
			    	+'<td>'+currData[i].area+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].commandName+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
				    +'<td>'+currData[i].totalSaleAmount+'</td>'
			    	+'<td>'+currData[i].serviceCode+'</td>'
			    	+'<td>'+currData[i].userName+'</td>'
			    	+'<td>'+currData[i].area+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].commandName+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].totalSaleAmount+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
			    	+'<td>'+currData[i].mobile+'</td>'
					+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="7">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 20; //每页出现的数据量
		if(that){
			linksData = that;
		}
		laypage({
			cont : "page",
			pages : Math.ceil(linksData.length/nums),
			jump : function(obj){
				$(".links_content").html(renderDate(linksData,obj.curr));
				$('.links_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})
