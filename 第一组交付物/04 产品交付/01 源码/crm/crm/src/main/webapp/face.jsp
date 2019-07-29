<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>刷脸登录</title>
<link rel="stylesheet" type="text/css" href="themes/facestyle.css" />
<script type="text/javascript"
	src="js/jquery-1.4.4.min.js"></script>
<style>
body {
	height: 100%;
	background-color:#98FB98;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>


<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js"></script>
<script src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //测试提交，对接程序删除即可
  //$(".submit_btn").click(function(){
	 // localhost.href="index.jsp";
	  //});
});
</script>


<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	height: 100vh;
	background-position: center;
	overflow: hidden;
}

h1 {
	color: #fff;
	text-align: center;
	font-weight: 100;
	margin-top: 40px;
}

#media {
	width: 100%;
	height: 250px;
	margin: 10px auto 0;
	border-radius: 30px;
	overflow: hidden;
	opacity: 0.7px;
}

#video {
	
}

#canvas {
	display: none;
}

#btn {
	width: 160px;
	height: 50px;
	background: #03a9f4;
	margin: 70px auto 0;
	text-align: center;
	line-height: 50px;
	color: #fff;
	border-radius: 40px;
}
</style>
</head>

<body>


	<dl class="admin_login">
		<dt>
			<strong>CSI员工之家</strong><em></em> <strong>请把你的脸放摄像头面前</strong>
		</dt>
		<div id="media">
			<video id="video" width="100%" height="300" autoplay></video>
			<canvas id="canvas" width="530" height="300"></canvas>
		</div>
		<dd>
			<form id="ff" method="post" action="login">
				<input type="submit" onclick="query()" value="立即登录"
					class="submit_btn" />
			</form>
		</dd>

	</dl>
	<script type="text/javascript" src="../js/alert.js"></script>
	<script type="text/javascript">
  		//var 是定义变量
  		var video = document.getElementById("video"); //获取video标签
  		var context = canvas.getContext("2d");
  		var con  ={
  			audio:false,
  			video:true,
  			video:{
  			width:1980,
  			height:1024,
  			
  			}
  		};	
  		
  		//导航 获取用户媒体对象
  			navigator.mediaDevices.getUserMedia(con)
  			.then(function(stream){
  				try{
  					video.src = window.URL.createObjectURL(stream);
  				}catch(e){
  					video.srcObject=stream;
  				}
  				
  				video.onloadmetadate = function(e){
  					video.play();
  				
  				}
  			});
  	
  			
  			
  	
  			function query(){
  				
  				//把流媒体数据画到convas画布上去
  				context.drawImage(video,0,0,530,300);
  				var base = getBase64();
  
  				/*
  				$.ajax({
  					type:"post",
  					url:"/hrm/user/faceLogin",
  					data:{"base":base},
  					dataType: "json",
  					success:function(json){
  						if(json.message==""){
  							$.MsgBox.Alert("消息","登录失败");
  						}else{
  							window.parent.location.replace("main");
  						}
  						

					}
				});
				*/
				
				window.parent.location.replace("../main.html");
			}
			function getBase64() {
				var imgSrc = document.getElementById("canvas").toDataURL(
						"image/png");
				
				return imgSrc.split("base64,")[1];

			};
		</script>


</body>
</html>