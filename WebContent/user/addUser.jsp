<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css" type="text/css"></link>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
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
    width: 90px;
	border: 1px solid gray;
	height: 22px;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body style="overflow-y: scroll">
	<div class="table_top" style="height: 100%">
		<div>
			<table width="100%" class="top" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_top"><b>当前位置:</b>&nbsp;<a href="list.action">用户管理</a>>>添加账号</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<br>
			<s:form action="user!add.action" theme="simple" method="post">
				<fieldset style="width: 98%">
					<legend style="font-size: 16px;">填写账号信息如下：</legend>
					<table class="list_user" border="0" cellpadding="0" cellspacing="10">
						<tr><td>&nbsp;</td></tr>
						<tr>
							<th>输入用户名：</th>
							<td><input type="text" name="user.username" /></td>
							<th>输入密码：</th>
							<td><input type="text" name="user.password" /></td>
						</tr>
						<tr>
						<tr>
							<td colspan="1">&nbsp;</td>
							<td><span id="passwordMsg" style="color:red">${username_error}</span>
							<th>再次输入密码：</th>
							<td><input type="text" name="password2" /></td>
						</tr>
						<tr>
						    <td colspan="3">&nbsp;</td>
						    <td><span id="passwordMsg" style="color:red">${password_error}</span></td>
						<tr>
							<th>设置权限：</th>
							<td><select name="user.rights">
							       <c:forEach var="rt" items="${rightList}">
										<c:choose>
											<c:when test="${rt==user.rights}">
												<option value="${rt}" selected>${rt}</option>
											</c:when>
											<c:otherwise>
												<option value="${rt}">${rt}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select></td>
							<th>设置部门所属：</th>
							<td><select name="user.dept">
									<c:forEach var="everyDept" items="${deptList}">
										<c:choose>
											<c:when test="${everyDept==user.dept}">
												<option value="${everyDept}" selected>${everyDept}</option>
											</c:when>
											<c:otherwise>
												<option value="${everyDept}">${everyDept}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select></td>
						</tr>						
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
							<td align="left"><s:submit cssClass="buttonBack"
									value="添 加" /> </td>
							<td><input type="button" value="返  回"
								onclick="location='/SalaryManageSys/user/list.action'"
								class="buttonBack" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
				</fieldset>
			</s:form>
		</div>
	</div>
</body>
</html>