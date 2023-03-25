<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="../css/main.css" type="text/css"></link>



<style type="text/css">
body {
	text-align: center;
}

.buttonBack {
	background: url(../skin/83.gif);
	width: 67px;
	height: 22px;
	border: 0px;
	cursor: pointer;
}

input {
	border: 1px solid gray;
	height: 22px;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="table_top" style="height: 100%">
		<div>
			<table width="100%" class="top" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_top"><b>当前位置:</b>&nbsp;<a href="list.action">用户管理</a>>>修改密码</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<fieldset style="width: 98%">
				<legend style="font-size: 16px;">修改密码：</legend>
				<table class="list_user" border="0" cellpadding="0" cellspacing="15">
					<tr>
						<td style="font-size:30px;font-style:italic;">密码修改成功！</td>
						<td>		
						<a href="http://localhost:8080/SalaryManageSys/login.jsp" target="_top">
						<img src="../skin/33.gif" />重新登录
						</a></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</body>
</html>