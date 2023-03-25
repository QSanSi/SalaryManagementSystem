<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
<body style="overflow-y: scroll">
	<div class="table_top" style="height: 100%">
		<div>
			<table width="100%" class="top" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_top"><b>当前位置:</b>&nbsp;<a
						href="salaryList.action">薪资管理</a>>>五险一金设置</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<br>
			<s:form action="insurance!update.action" theme="simple" method="post">
				<fieldset style="width: 98%">
					<legend style="font-size: 16px;">五险一金设置：</legend>
					<table class="list_insur" border="0" cellpadding="0"
						cellspacing="10">
						<tr>
							<th>养老保险：<input type="text" size="1"
								value="${insurance.id }" name="insurance.id"
								style="display: none" /></th>
							<td>工资<input type="text" size="1" value="${insurance.old }"
								name="insurance.old" />%
							</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<th>失业保险：</th>
							<td>工资<input type="text" size="1"
								value="${insurance.unemployment }" name="insurance.unemployment" />%
							</td>
						</tr>
						<tr>
							<th>工伤保险：</th>
							<td>工资<input type="text" size="1"
								value="${insurance.injury }" name="insurance.injury" />%
							</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<th>生育保险：</th>
							<td>工资<input type="text" size="1" value="${insurance.bear }"
								name="insurance.bear" />%
							</td>
						</tr>
						<tr>
							<th>医疗保险：</th>
							<td>工资<input type="text" size="1"
								value="${insurance.medical }" name="insurance.medical" />%
							</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<th>公积金：</th>
							<td>工资<input type="text" size="1"
								value="${insurance.house }" name="insurance.house" />%
							</td>
						</tr>
						<tr>
					</table>
					<table width="25%">
						<tr>
							<td align="right"><s:submit cssClass="buttonBack" value="修改" /></td>
						</tr>
						<tr>
							<td align="right"><span id="msg" style="color: red">${message}</span>&nbsp;&nbsp;</td>
						</tr>
					</table>
				</fieldset>
			</s:form>
		</div>
	</div>
</body>
</html>