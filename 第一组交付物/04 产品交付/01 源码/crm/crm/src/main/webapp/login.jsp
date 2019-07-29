<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="themes/Login.css">

</head>

<body>
	<div class="a">
		<div class="navbar-header">
			<div>
				<span
					style="font-family: 'Britannic Bold', 'Britannic'; color: #3BC5BB;">CSI员工</span>
				<span
					style="font-family: 'Segoe UI Emoji Bold', 'Segoe UI Emoji Normal', 'Segoe UI Emoji'; color: #1D4474;"></span>
				<span
					style="font-family: 'Segoe UI Emoji Bold', 'Segoe UI Emoji Normal', 'Segoe UI Emoji'; color: #FF9A4C;">之家</span>
			</div>
		</div>
		<div class="login-box">
			<div class="c">
				<form id="ff" method="post" action="login">
					<table cellpadding="5">
						<tr>

							<td><div class="username">
									<input id="shuru" class="easyui-textbox" type="text"
										name="username"
										style="width: 280px; height: 38px; padding: 10px">
								</div></td>
						</tr>
						<tr>

							<td><div class="password">
									<input id="mi" class="easyui-passwordbox" prompt="请输入密码"
										name="password"
										style="width: 280px; height: 38px; padding: 10px"> <span
										id="tishi2" class="b"></span>
								</div></td>
					</table>
					<div class="box">
						<input type="checkbox" />
					</div>
					<div class="rememberPwd">
						<span>记住密码</span>
					</div>
					<div class="buttonLayout">
						<input type="button" class="button button1" value='登录' id="tj"
							name="tj"> 
						<a href="face.jsp" style="text-decoration: none; color: white">
							<div class="button button2">刷脸</div>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/dynamic.effect.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#mi').passwordbox({

			showEye : false,
			iconCls : 'icon-lock',
			iconAlign : 'left',

		});
		$('#shuru').textbox({
			iconAlign : 'left',
			prompt : "请输入用户名",
			iconCls : 'icon-man',
		})

	});
</script>
<script type="text/javascript">
	tj.onclick = function(){
		if(shuru.value == 'admin'){
			sessionStorage.setItem('admin','admin');
		}
		if(shuru.value=='' || mi==''){
			alert("用户或密码不能为空");			
		}else{
			ff.submit();
		}
	}
</script>
</html>