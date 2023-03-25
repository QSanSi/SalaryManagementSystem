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
						href="salaryList.action">薪资管理</a>>>显示薪资详细信息</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<fieldset style="width: 98%">
				<legend style="font-size:16px;">薪资详情如下：</legend>
				<form action="" method="post">
					<table class="list" width="28%" border="0" cellpadding="0" cellspacing="10">
						<tr>
							<th>姓名：</th>
							<td>${salary.trueName}</td>						
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>年份：</th>
							<td>${salary.year}</td>
							
						</tr>
						<tr>
							<th>部门：</th>
							<td>${salary.dept }</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>月份：</th>
							<td>${salary.month}</td>
						</tr>
						<tr>
						    <th>工号：</th>
							<td>${salary.empId}</td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<th>基本工资：</th>
							<td>${salary.baseSalary}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>迟到罚金：</th>
							<td>${salary.lateCome}</td>
						</tr>
						<tr>
							<th>早退罚金：</th>
							<td>${salary.earlyLeave}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>请假罚金：</th>
							<td>${salary.leave}</td>
						</tr>
						<tr>
							<th>加班奖金：</th>
							<td>${salary.overtime}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>旷工罚金：</th>
							<td>${salary.negletwork}</td>
						</tr>
						<tr>
							<th>养老保险：</th>
							<td>${salary.old}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>失业保险：</th>
							<td>${salary.unemployment}</td>
						</tr>
						<tr>
							<th>工伤保险：</th>
							<td>${salary.injury}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>生育保险：</th>
							<td>${salary.bear}</td>
						</tr>
						<tr>
							<th>医疗保险：</th>
							<td>${salary.medical}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>公积金：</th>
							<td>${salary.house}</td>
						</tr>
						<tr>
							<th>应纳税额：</th>
							<td>${salary.taxSalary}</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<th>纳税额：</th>
							<td>${salary.tax}</td>
						</tr>
						<tr>
							<th>最终工资：</th>
							<td>${salary.finalSalary}</td>
						</tr>
						<tr>
						</table>
						<table width="20%">
						<tr>
							<td align="right">&nbsp;&nbsp;&nbsp; <input type="button"
								value="返  回"
								onclick="location='/SalaryManageSys/salary/salaryList.action'"
								class="buttonBack" />
							</td>
						</tr>
						<tr><td>&nbsp;</td></tr>
					</table>
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>