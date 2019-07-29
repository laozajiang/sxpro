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
	<form id="iform" action="job_insert" method="post">
	 
	    <div style="display:none;">
	     <span>状态</span>
		<input type="text" id="t" name="t" />
	    <span>编号</span>
		<input type="text" id="id" name="id" />
		</div>
		<span>职业名称</span>
		<input type="text" id=job_name name="job_name" />
		<span>职业描述</span>
		<input type="text" id="job_info" name="job_info"/>
	
		
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
var job_name=Request["job_name"];
var job_info=Request["job_info"];
var t=Request["t"];

if(id!=null)
	{
	$("#id").val(id);
	$("#job_name").val(job_name);
	$("#job_info").val(job_info);
	
	
	
	  
	
	 $("#iform").attr('action',"job_update");
	
	
	
	
	
	}
else if(t!=null){
	
	$("#t").val(t);
}
else{
	//console.log("zz");
}







</script>
</html>