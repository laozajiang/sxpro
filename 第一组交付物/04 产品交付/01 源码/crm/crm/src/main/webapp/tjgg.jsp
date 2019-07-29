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



<body>
	<form id="iform" action="gg_add" method="post">
	 
	    <div style="display:none;">
	     <span>状态</span>
		<input type="text" id="t" name="t" />
	    <span>编号</span>
		<input type="text" id="id" name="id" />
		</div>
		<span>公告名称</span>
		<input type="text" id=gg_name name="gg_name" />
		<span>公告内容</span>
		<input type="text" id="gg_content" name="gg_content"/>
	<span>公告时间</span>
		<input type="text" id="gg_time" name="gg_time"/>
		<span>公告人</span>
		<input type="text" id="gg_person" name=""gg_person""/>
		
		<button type="submit" >提交</button>
	</form>

</body>


<script type="text/javascript">
//获取id
function GetRequest() {
          var url = location.search; //获取url中"?"符后的字串
          var theRequest = new Object();
          if (url.indexOf("?") != -1) {
              var str = url.substr(1);
              strs = str.split("&");
              for ( var i = 0; i < strs.length; i++) {
                  theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
              }
          }
          return theRequest;
      }
var Request=undefined;
Request=GetRequest();
var id=Request["id"];
var gg_name=Request["gg_name"];
var gg_content=Request["gg_content"];
var gg_time=Request["gg_time"];
var gg_person=Request["gg_person"];
var t=Request["t"];

if(id!=null)
	{
	$("#id").val(id);
	$("#gg_name").val(gg_name);
	$("#gg_content").val(gg_content);
	$("#gg_time").val(gg_time);
	$("#gg_person").val(gg_person);
	
	
	
	  
	
	 $("#iform").attr('action',"gg_update");
	
	
	
	
	
	}
else if(t!=null){
	
	$("#t").val(t);
}
else{
	//console.log("zz");
}







</script>
</html>