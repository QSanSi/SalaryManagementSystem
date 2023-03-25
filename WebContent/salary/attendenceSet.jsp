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
    width: 50px;
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
					<td class="td_top"><b>当前位置:</b>&nbsp;<a
						href="attendenceList.action">考勤管理</a>>>考勤奖惩设置</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<br>
			<fieldset style="width: 98%">
				<legend style="font-size: 16px;">考勤奖惩设置：</legend>
				<s:form action="attendenceSet!find.action" theme="simple"
					method="post">
					<table width="15%" class="list" border="0" cellpadding="0" cellspacing="10">
						<tr>
							<th>部门：</th>
							<td><select name="attendenceSet.dept">
									<c:forEach items="${deptList}" var="dp">
										<c:choose>
											<c:when test="${dp.name==attendenceSet.dept}">
												<option value="${dp.name}" selected>${dp.name }</option>
											</c:when>
											<c:otherwise>
												<option value="${dp.name}">${dp.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select></td>
							<td><s:submit cssClass="buttonBack" value="查询" /></td>
						</tr>
					</table>
				</s:form>
				<s:form action="attendenceSet!updateSet.action" theme="simple"
					method="post">
					<table class="list" border="0" cellpadding="0" cellspacing="10">
						<tr>
							<th>迟到罚款：<input type="text" size="1"
								value="${attendenceSet.dept }" name="attendenceSet.dept"
								style="display: none" /></th>
							<td><input type="text" size="1"
								value="${attendenceSet.lateCome }" name="attendenceSet.lateCome" />元/次</td>
						</tr>
						<tr>
							<th>早退罚款：</th>
							<td><input type="text" size="1"
								value="${attendenceSet.earlyLeave }"
								name="attendenceSet.earlyLeave" />元/次</td>
						</tr>
						<tr>
							<th>请假罚款：</th>
							<td><input type="text" size="1"
								value="${attendenceSet.leave }" name="attendenceSet.leave" />元/天</td>
						</tr>
						<tr>
							<th>旷工罚款：</th>
							<td><input type="text" size="1"
								value="${attendenceSet.negletwork }"
								name="attendenceSet.negletwork" />元/时</td>

						</tr>
						<tr>
							<th>加班奖金：</th>
							<td><input type="text" size="1"
								value="${attendenceSet.overtime }" name="attendenceSet.overtime" />元/时</td>
						</tr>
						<tr>
					</table>
					<table width="12%">
						<tr>
							<td colspan="4" align="right"><s:submit
									cssClass="buttonBack" value="修改" />
						</tr>
						<tr>
							<td align="right"><span id="msg" style="color: red">${message}</span>&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table>
				</s:form>
			</fieldset>
		</div>
	</div>
</body>
</html>