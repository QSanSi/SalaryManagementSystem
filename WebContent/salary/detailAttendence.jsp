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
<script type="text/javascript" src="../js/common.js"></script>

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
<body>
	<div class="table_top" style="height: 100%">
		<div>
			<table width="100%" class="top" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_top"><b>当前位置:</b>&nbsp;<a
						href="attendenceList.action">考勤管理</a>>>显示考勤详细信息</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<fieldset style="width: 98%">
				<legend style="font-size: 16px;">考勤详情如下：</legend>
				<form action="attendence!update.action" method="post">
					<input type="hidden" name="attendence.id" value="${attendence.id}" />
					<table class="list_stand" width="25%" border="0" cellpadding="0" cellspacing="10">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th>姓名：</th>
							<td>${attendence.trueName}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>工号：</th>
							<td>${attendence.empId}</td>
						</tr>
						<tr>
							<th>年份：</th>
							<td>${attendence.year}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>部门：</th>
							<td>${attendence.dept}</td>					
						</tr>
						<tr>
						    <th>月份：</th>
							<td>${attendence.month}</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th>早退次数：</th>
							<td><input type="text" name="attendence.earlyLeave"
								value="${attendence.earlyLeave}" /></td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>迟到次数：</th>
							<td><input type="text" name="attendence.lateCome"
								value="${attendence.lateCome}" /></td>
						</tr>
						<tr>
							<th>加班时数：</th>
							<td><input type="text" name="attendence.overtime"
								value="${attendence.overtime}" /></td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>旷工时数：</th>
							<td><input type="text" name="attendence.negletwork"
								value="${attendence.negletwork}" /></td>
						</tr>
						<tr>
							<th>请假天数：</th>
							<td><input type="text" name="attendence.leave"
								value="${attendence.leave}" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td align="right">&nbsp;</td>
							<td align="left"><input type="submit" value="修改"
								class="buttonBack" /> </td>
							<td><input type="button" value="返  回"
								onclick="location='/SalaryManageSys/salary/attendenceList.action'"
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