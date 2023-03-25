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
	width: 90px; border : 1px solid gray;
	height: 22px;
	border: 1px solid gray;
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
					<td class="td_top"><b>当前位置:</b>&nbsp;<a href="list.action">用户管理</a>>>账号信息修改</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<br>
			<s:form action="user!update.action" theme="simple" method="post">
				<fieldset style="width: 98%">
					<legend style="font-size: 16px;">账号信息如下：</legend>
					<input type="hidden" name="user.id" value="${user.id}" />
					<table class="list_dept" border="0" cellpadding="0"
						cellspacing="10">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th>用户名：</th>
							<td><input type="text" name="user.username"
								value="${user.username }" /></td>
							<th>密码：</th>
							<td><input type="text" name="user.password"
								value="${user.password }" /></td>
						</tr>
						<tr>
							<th>权限：</th>
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
							<th>部门所属：</th>
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
									value="保  存" /></td>
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