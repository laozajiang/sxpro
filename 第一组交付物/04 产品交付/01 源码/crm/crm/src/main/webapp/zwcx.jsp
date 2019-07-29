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
	    url:'job_select',
	    columns:[[
			{field:'ck',checkbox:true,width:100},      
			{field:'id',title:'编号',width:100},
			{field:'job_name',title:'职位名称',width:100},
			{field:'job_info',title:'职位描述',width:100},
			{field:'operate',title:'操作',align:'center',width:$(this).width()*0.1,
				formatter:function(value, row, index){
					var str = '<a href="tjzw.jsp?id='+row.id+'&job_name='+row.job_name+'&job_info='+row.job_info+'  " name="opera" class="easyui-linkbutton" ></a>';
				//	console.log(str);
				//	console.log(row);
				
					return str;
					
			}},
			

			

			
	    ]],
	    
	    onLoadSuccess:function(data){  
	        $("a[name='opera']").linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});  
	},
	    
	 
	    
	    data: [
			{id:"value10",job_name:"value11", job_info:"value12"}
			
		
		],
	    pagination:true,
	    toolbar: [
	    	  	{
			iconCls: 'icon-add',
			text:'增加职位',
			handler: function(){
				window.location.href="tjzw.jsp?t=5";
				
			}
		},'-', 
		{
			iconCls: 'icon-cancel',
			text:'删除职位',
			handler: function(){
				var  datas = $('#dg').datagrid('getSelections');
				//console.log(datas[0].id)
				//console.log(datas[1].id)
			//	console.log(datas.length);
				 
				 
				<!--用ajax传递数据 -->
				for(var a=0;a<datas.length;a++ ){
					var c=datas[a].id;
					console.log("id");
					 console.log(c);
				  $.ajax({
					
					 url:'job_delect',
					 type:"post",
					 data:{"id":c},
					 dataType:"text",
					 success:function(res){
					    //获取通过resp回写的数据
						 console.log(res)
						//现在要将数据写在本页面  利用js或者jquey操作页面对应的元素
					//	$("#uname").val(res)
						
					 }
					 
				 }) 
			}
				
				$('#dg').datagrid('reload');
				
			}
		}]
	});	
});

//查询部分代码
function doSearch(){
	$('#dg').datagrid('load',{
		id:$('#id').val(),
		job_name: $('#job_name').val(),
		job_info: $('#job_info').val(),
	});
}
</script>
<body>
<div id="tb" style="padding:3px">
	<span>职位名</span>
	<input id="job_name" style="line-height:26px;border:1px solid #ccc">
	<span>内容:</span>
	<input id="job_info" style="line-height:26px;border:1px solid #ccc">
	<a href="#" class="easyui-linkbutton"  plain="true" onclick="doSearch()">查询</a>
</div>

<table id="dg"></table>
</body>
</html>