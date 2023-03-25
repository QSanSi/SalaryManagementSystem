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
<script type="text/javascript" src="js/common.js"></script>

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
						href="salaryStandardList.action">薪资管理</a>>>设置基本工资</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<fieldset style="width: 98%">
				<legend style="font-size: 16px;">设置基本工资：</legend>
				<form action="salaryStandard!update.action" method="post">
					<input type="hidden" name="salaryStandard.id"
						value="${salaryStandard.id}" />
					<table class="list_stand" width="25%" border="0" cellpadding="0"
						cellspacing="10">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th>姓名：</th>
							<td>${ salaryStandard.trueName}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>部门：</th>
							<td>${ salaryStandard.dept}</td>
						</tr>
						<tr>
						<tr>
						<tr>
							<th>工号：</th>
							<td>${ salaryStandard.empId}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>基本工资：</th>
							<td><input type="text" name="salaryStandard.baseSalary"
								value="${ salaryStandard.baseSalary}" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td align="left"><input type="submit" value="修 改"
								class="buttonBack" /> </td>
							<td><input type="button" value="返  回"
								onclick="location='/SalaryManageSys/salary/salaryStandardList.action'"
								class="buttonBack" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>