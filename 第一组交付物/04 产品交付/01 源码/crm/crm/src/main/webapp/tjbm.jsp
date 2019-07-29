<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>



</head>

<body>
	<form id="iform" action="depart_Insert" method="post">
	    <div style="display:none;">
	    <span>状态</span>
		<input type="text" id="t" name="t" />
		</div>
	    <div style="display:none;">
	    <span>编号</span>
		<input type="text" id="id" name="id" />
		</div>
		<span>部门名</span>
		<input type="text" id="dname" name="dname" />
		<span>部门信息</span>
		<input type="text" id="dinfo" name="dinfo"/>
		
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
var dname=Request["dname"];

var dinfo=Request["dinfo"];

var t=Request["t"];

if(id!=null)
	{
	$("#dname").val(dname);
	$("#dinfo").val(dinfo);
	
	$("#id").val(id);
	
	
	  
	
	 $("#iform").attr('action',"depart_update");
	
	
	
	
	
	}
else if(t!=null){
	
	$("#t").val(t);
}
else{
	//console.log("zz");
}







</script>

</html>

