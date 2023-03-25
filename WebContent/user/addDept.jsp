<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<td class="td_top"><b>当前位置:</b>&nbsp;
					<a href="deptList.action">部门管理</a>>>添加部门详细信息</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<fieldset style="width: 98%">
				<legend style="font-size:16px;">填写部门详情如下：</legend>

				<form action="dept!add.action" method="post">

					<table class="list_dept" border="0" cellpadding="0" cellspacing="10">
						<tr><td>&nbsp;</td></tr>
						<tr>
							<th>部门名称：</th>
							<td><input type="text" name="dept.name" /></td>
							<th>部门编号：</th>
							<td><input type="text" name="dept.number" /></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<th>部门电话：</th>
							<td><input type="text" name="dept.tel" /></td>
							<th>部门负责人：</th>
							<td><input type="text" name="dept.manager" /></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<th>部门简介：</th>
							<td colspan="3" style="height: 42px"><textarea
									name="dept.remark" rows="5" cols="54"
									style="border: 1px solid gray; overflow: hidden;"></textarea></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td align="right">&nbsp;</td>
							<td align="left"><input type="submit" value="添加"
								class="buttonBack" /> &nbsp;&nbsp;&nbsp;<input type="button"
								value="返  回"
								onclick="location='/SalaryManageSys/user/deptList.action'"
								class="buttonBack" /></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
					</table>
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>