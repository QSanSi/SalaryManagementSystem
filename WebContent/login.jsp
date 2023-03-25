<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>绵师教工工资管理系统</title>
<link href="css/login.css" type=text/css rel=stylesheet>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/img_ver.js"></script>
<style>
.bxs-row {
	margin-bottom: 12px;
}

.logo-box {
	width: 404px;
	margin: 120px auto;
	border: 1px solid #e5e5e5;
	border-radius: 4px;
	box-shadow: 0 4px 18px rgba(0, 0, 0, 0.2);
	position: relative;
	overflow: hidden;
	height: 360px;
}

.login {
	position: absolute;
	width: 320px;
	left: 0;
	top: 0;
	padding: 42px 42px 36px;
	transition: all 0.8s;
}

.username, .password, .btn {
	height: 44px;
	width: 100%;
	padding: 0 10px;
	border: 1px solid #9da3a6;
	background: #fff;
	text-overflow: ellipsis;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	-khtml-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	color: #000;
	font-size: 1em;
	font-family: Helvetica, Arial, sans-serif;
	font-weight: 400;
	direction: ltr;
	font-size: 13px;
}

.submit {
	background-color: #0070ba;
	color: #fff;
	border: 1px solid #0070ba;
}

.submit:hover {
	background-color: #005ea6;
}

.verBox {
	position: absolute;
	width: 100%;
	text-align: center;
	left: 404px;
	top: 0;
	opacity: 0;
	transition: all 0.8s;
	padding-top: 55px;
}

.err {
	margin: 12px 0 0;
	line-height: 12px;
	height: 12px;
	font-size: 12px;
	color: red;
}
</style>
</head>
<body>

	<div class="logo-box">

		<div class="login" style="">
			<div class="bxs-row" style="text-align: center;">
				<img id="logo" src="images/login/logo.jpg" style="width: 72px;">
				<span class="tips" style="color: red;">忍住不哭来段口技</span>
			</div>
			<form name="login" method="POST" action="login.action"
				id="login_form">
				<div class="bxs-row">
					<input type="text" class="username" name="username"
						placeholder="用户名" value="admin">
					<span class=" err err-username" style="color:red">${username_error}</span>
				</div>
				<div class="bxs-row">
					<input type="password" class="password" name="password"
						placeholder="密码">
					<span class="err err-password" style="color:red">${password_error}</span>
				</div>
				<div class="bxs-row">
					<input type="submit" class="submit btn" value="登录">
				</div>
			</form>
		</div>
		<div class="verBox">
			<div id="imgVer" style="display: inline-block;"></div>
		</div>

	</div>
	<script>
		var username_flag = false;
		var password_flag = false;
		var imgVer_flag = false;
		imgVer({
			el : '$("#imgVer")',
			width : '260',
			height : '116',
			img : [ 'images/login/ver.png', 'images/login/ver-1.png',
					'images/login/ver-2.png', 'images/login/ver-3.png' ],
			success : function() {
				//alert('执行登录函数');
				$(".login").css({
					"left" : "0",
					"opacity" : "1"
				});
				$(".verBox").css({
					"left" : "404px",
					"opacity" : "0"
				});
				imgVer_flag = true;
				//$(".tips").html('你是不是不知道账号密码！？？？');
				//$("#logo").attr("src", 'images/login/login-err.png')
			},
			error : function() {
				//alert('错误什么都不执行')
			}
		});
		$(".submit").on('click', function() {
			if ($(".username").val() == '') {
				$(".tips").html('老兄！！你用户名呢！？？？');
				$("#logo").attr("src", 'images/login/null-password.jpg')
			} else if ($(".password").val() == '') {
				$(".tips").html('老兄！！你密码呢！？？？');
				$("#logo").attr("src", 'images/login/null-password.jpg')
			} else {
				username_flag = true;
				password_flag = true;
				$(".login").css({
					"left" : "-404px",
					"opacity" : "0"
				});
				$(".verBox").css({
					"left" : "0",
					"opacity" : "1"
				})
			}
		})
		$(function() {
			$("#login_form").submit(function() {
				if (!username_flag) {
					//alert("用户名不能为空...");
					return false;
				}
				if (!password_flag) {
					//alert("密码不能为空...");
					return false;
				}
				if (!imgVer_flag) {
					//alert("验证信息有错");
					return false;
				}
				return true;
			});
		});
	</script>
</body>
</html>