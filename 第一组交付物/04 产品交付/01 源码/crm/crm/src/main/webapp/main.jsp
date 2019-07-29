<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CSI员工 之家</title>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<link rel="stylesheet" type="text/css" href="themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="themes/icon.css" />
<script type="text/javascript">
	$(function() {
		//动态树形菜单数据
		var treeData = [
				{
					text : "用户管理",
					children : [
							{
								text : "用户查询",
								attributes : {
									url : "<iframe src='yhcx.jsp' frameborder='0' width='100%' height='100%' >"
								}
							},
							{
								text : "用户添加",
								attributes : {
									url : "<iframe src='tjyh.jsp' frameborder='0' width='100%' height='100%' >"

								}
							} ]
				},
				{
					text : "部门管理",
					children : [
							{
								text : "部门查询",
								attributes : {
									url : "<iframe src='bmcx.jsp' frameborder='0' width='100%' height='100%' >"
								}
							},
							{
								text : "添加部门",
								attributes : {
									url : "<iframe src='tjbm.jsp' frameborder='0' width='100%' height='100%' >"
								}
							} ]
				},
				{
					text : "职位管理",
					children : [
							{
								text : "职位查询",
								attributes : {
									url : "<iframe src='zwcx.jsp' frameborder='0' width='100%' height='100%' >"
								}
							},
							{
								text : "添加职位",
								attributes : {
									url : "<iframe src='tjzw.jsp' frameborder='0' width='100%' height='100%' >"
								}
							} ]
				},
				{
					text : "员工管理",
					children : [
							{
								text : "员工查询",
								attributes : {
									url : "<iframe src='ygcx1.jsp' frameborder='0' width='100%' height='100%' >"
								}
							},
							{
								text : "添加员工",
								attributes : {
									url : "<iframe src='tjyg.jsp' frameborder='0' width='100%' height='100%' >"
								}
							} ]
				},
				{
					text : "公告管理",
					children : [
							{
								text : "公告查询",
								attributes : {
									url : "<iframe src='ggcx.jsp' frameborder='0' width='100%' height='100%' >"
								}
							},
							{
								text : "添加公告",
								attributes : {
									url : "<iframe src='tjgg.jsp' frameborder='0' width='100%' height='100%' >"
								}
							} ]
				} ];

		//实例化树形菜单
		$("#tree").tree(
				{
					animate : true,
					data : treeData,
					onClick : function(node) {
						if (node.attributes) {
							Open(node.text, node.attributes.url);
						}
						$('#tree')
								.tree(
										node.state === 'closed' ? 'expand'
												: 'collapse', node.target);
					},
					onLoadSuccess : function(node, data) {
						$(".tree-icon,.tree-file").removeClass(
								"tree-icon tree-file");
						$(".tree-icon,.tree-folder").removeClass(
								"tree-icon tree-folder tree-folder-open");
						$('#tree').tree('collapseAll')
					}

				});
		//在右边center区域打开菜单，新增tab
		function Open(text, url) {
			if ($("#tabs").tabs('exists', text)) {
				$('#tabs').tabs('select', text);
			} else {
				$('#tabs').tabs('add', {
					title : text,
					closable : true,
					content : url
				});
			}
		}

		//绑定tabs的右键菜单
		$("#tabs").tabs({
			onContextMenu : function(e, title) {
				e.preventDefault();
				$('#tabsMenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data("tabTitle", title);
			}
		});

		//实例化menu的onClick事件
		$("#tabsMenu").menu({
			onClick : function(item) {
				CloseTab(this, item.name);
			}
		});

		//几个关闭事件的实现
		function CloseTab(menu, type) {
			var curTabTitle = $(menu).data("tabTitle");
			var tabs = $("#tabs");

			if (type === "close") {
				tabs.tabs("close", curTabTitle);
				return;
			}

			var allTabs = tabs.tabs("tabs");
			var closeTabsTitle = [];

			$.each(allTabs, function() {
				var opt = $(this).panel("options");
				if (opt.closable && opt.title != curTabTitle
						&& type === "Other") {
					closeTabsTitle.push(opt.title);
				} else if (opt.closable && type === "All") {
					closeTabsTitle.push(opt.title);
				}
			});

			for (var i = 0; i < closeTabsTitle.length; i++) {
				tabs.tabs("close", closeTabsTitle[i]);
			}
		}
	});
</script>
<!-- 显示时间 -->
<script>
	//页面加载调用
	window.onload = function() {
		//每1秒刷新时间
		setInterval("NowTime()", 1000);
		
		//权限
		if(sessionStorage.getItem('admin') != 'admin'){
			_easyui_tree_3.style.display = 'none';
			_easyui_tree_6.style.display = 'none';
			_easyui_tree_9.style.display = 'none';
			_easyui_tree_12.style.display = 'none';
			_easyui_tree_15.style.display = 'none';
		}
		exit.onclick = function(){
			sessionStorage.setItem('admin','');
		}

	}
	function NowTime() {
		//获取年月日
		var time = new Date();
		var year = time.getFullYear();
		var month = time.getMonth() + 1;
		var day = time.getDate();
		//获取时分秒
		var h = time.getHours();
		var m = time.getMinutes();
		var s = time.getSeconds();
		// var day = time.getDay();
		//检查是否小于10
		h = check(h);
		m = check(m);
		s = check(s);
		document.getElementById("nowtime").innerHTML = "" + year + "年" + month
				+ "月" + day + "日  " + h + ":" + m + ":" + s;
	}
	//时间数字小于10，则在之前加个“0”补位。
	function check(i) {
		//方法一，用三元运算符
		var num;
		i < 10 ? num = "0" + i : num = i;
		return num;
	}
</script>
<style type="text/css">
#CSI {
	font-size: 20px;
	color: #3BC5BB;
	font-family: "楷体";
	position: absolute;
	bottom: 18px;
	font-weight: 700;
}

#jia {
	font-size: 20px;
	color: #FF9A4C;
	font-family: "楷体";
	position: absolute;
	bottom: 18px;
	left: 165px;
	font-weight: 700;
}

#welcome {
	color: #F1F1F1;
	position: absolute;
	bottom: 14px;
	left: 400px;
}

#exit {
	position: absolute;
	bottom: 14px;
	right: 100px;
}

a.white {
	color: black;
	text-decoration: none
}

a.white:hover {
	color: #ff0;
	text-decoration: none;
}

#nowtime {
	position: absolute;
	left: 0;
	top: 0;
	bottom: 0;
	right: 0;
	margin: auto;
	width: 300px;
	height: 26px
}

.tabs-wrap {
	position: relative;
	left: 0;
	overflow: hidden;
	width: 100%;
	margin: 0;
	padding: 0;
	background: #D1EEEE;
}

.tabs-header, .tabs-tool {
	background-color: #E0ECFF;
	padding: 0;
}

.tree-title {
	font-size: 14px;
	display: inline-block;
	text-decoration: none;
	vertical-align: middle;
	white-space: nowrap;
	padding: 0 2px;
	margin: 4px 0;
	height: 18px;
	line-height: 18px;
	/* margin-left:10px; */
}

#center {
	height: 200px;
	width: 500px;
	position: absolute;
	left: 0;
	top: 0;
	bottom: 0;
	right: 0;
	margin: auto;
	text-align: center;
}

li {
	margin-top: 15px;
}

.tree-title {
	font-size: 18px;
}
</style>
</head>
<body class="easyui-layout">
	<!--  页面上方区域     -->
	<div region="north" split="false"
		style="height: 60px; font-size: 20px; padding: 8px; background-color: #D1EEEE;"
		border="false">
		<img alt="" src="img/LOGO.jpg"> <span id="CSI">CSI员工</span> <span
			id="jia">之家</span> <a href="login.jsp" class="white"><span
			id="exit">退出登录</span></a>
		<div id="nowtime"></div>
	</div>

	<!--  页面左边区域    -->
	<div region="west" style="width: 180px; background: #BEEAEA"
		split="false" border="false">
		<!-- 树形结构的功能列表 -->
		<ul id="tree"></ul>
	</div>

	<!--  页面中间内容（主面板）区域     -->
	<div region="center" border="true">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" style="">
				<div id="center">
					<span style="font-size: 60px; color: #3BC5BB">Wel</span> <span
						style="font-size: 60px; color: #FFA570">come</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>