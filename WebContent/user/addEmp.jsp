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
					<td class="td_top"><b>当前位置:</b>&nbsp;<a href="empList.action"
						target="main">员工管理</a>>>添加员工</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<br>
			<s:form action="emp!add.action" theme="simple" method="post">
				<fieldset style="width: 98%">
					<legend style="font-size: 16px;">填写员工信息如下：</legend>
					<table class="list_emp" border="0" cellpadding="0" cellspacing="10">
						<tr>
							<th>员工工号：</th>
							<td><input type="text" name="emp.empId" /></td>
							<th>员工姓名：</th>
							<td><input type="text" name="emp.trueName" /></td>
						</tr>
						<tr>
							<th>员工性别：</th>
							<td><input name="emp.sex" type="radio" value="男"
								checked="checked" />男 <input name="emp.sex" type="radio"
								value="女" />女</td>
							<th>出生年月：</th>
							<td><input class="Wdate" type="text" name="emp.birthday"
								id="time" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>
						</tr>
						<tr>
							<th>年龄：</th>
							<td><input type="text" name="emp.age" /></td>
							<th>身份证号：</th>
							<td><input type="text" name="emp.idNum" /></td>

						</tr>
						<tr>
							<th>婚姻情况：</th>
							<td><input type="text" name="emp.marry" /></td>
							<th>政治面貌：</th>
							<td><input type="text" name="emp.polity" /></td>
						</tr>
						<tr>
							<th>籍贯：</th>
							<td><input type="text" name="emp.city" /></td>
							<th>手机号：</th>
							<td><input type="text" name="emp.telNum" /></td>
						</tr>
						<tr>
							<th>毕业院校：</th>
							<td><input type="text" name="emp.school" /></td>
							<th>学历：</th>
							<td><input type="text" name="emp.degree" /></td>
						</tr>
						<tr>
							<th>入职时间：</th>
							<td><input class="Wdate" type="text" name="emp.startDate"
								id="time" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
							</td>
							<th>所属部门：</th>
							<td><select name="emp.deptName">
									<c:forEach items="${depts}" var="dp">
										<option value="${dp.name}">${dp.name }</option> 
                       ${pd.name}            
                     </c:forEach>
							</select></td>

						</tr>
						<tr>
							<th>住址：</th>
							<td><input type="text" name="emp.address" /></td>
							<th>基本工资：</th>
							<td><input type="text" name="emp.basesalary" /></td>
						</tr>

						<tr>
							<th>备注信息：</th>
							<td colspan="3" style="height: 42px"><br> <textarea
									rows="5" cols="53" name="emp.remark"></textarea> <br></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
							<td align="left"><s:submit cssClass="buttonBack"
									value="保  存" /> &nbsp;&nbsp;&nbsp; <input type="button"
								value="返  回"
								onclick="location='/SalaryManageSys/user/empList.action'"
								class="buttonBack" /></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
					</table>
				</fieldset>
			</s:form>
		</div>
	</div>
</body>
</html>