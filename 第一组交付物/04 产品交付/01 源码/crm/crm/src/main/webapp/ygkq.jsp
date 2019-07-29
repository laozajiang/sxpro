<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css"
	href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$('#dg').datagrid({
	    url:'notice_select',
	    columns:[[
			{field:'ck',checkbox:true,width:100},      
			{field:'uid',title:'编号',hidden:true,width:100},
			{field:'name',title:'标题',width:100},
			{field:'info',title:'详情',width:100},
			{field:'user',title:'操作人',width:100,align:'right'}
	    ]],
	    
	    data: [
			{name:'value11', info:'value12',user:'value13'}
		
		],
	    pagination:true,
		toolbar: [{
			iconCls: 'icon-add',
			text:'人员增加',
			handler: function(){
				alert('edit')
				
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'人员变更',
			handler: function(){
				var  datas = $('#dg').datagrid('getSelections');
				console.log(datas[0].uid)
			//	<!--用ajax传递数据 -->
				$('#dg').datagrid('reload');
				
			}
		}]
	});	
})
</script>
<body>
<table id="dg"></table>
</body>
</html>