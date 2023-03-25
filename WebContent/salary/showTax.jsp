<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
<link rel="stylesheet" href="../css/main.css" type="text/css"></link>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>

<style type="text/css">
a:hover {
	text-decoration: underline;
	color: #075B92;
}

.body {
	text-align: center;
}

.buttonBack {
	background: url(../skin/83.gif);
	width: 67px;
	height: 22px;
	border: 0px;
	cursor: pointer;
}

.input {
	border: 1px solid gray;
	height: 22px;
}
</style>

<script type="text/javascript">
	$(document).ready(
			function() {
				//获取年度下拉框值
				var date = new Date();
				var year = date.getFullYear() - 2;
				for (var i = 0; i < 5; i++) {
					if (year + i == "${requestScope.year}") {
						var option = $("<option></option>").val(year + i).text(
								year + i).attr("selected", true).appendTo(
								$("#year"));
					} else {
						$("<option></option>").val(year + i).text(year + i)
								.appendTo($("#year"));
					}
				}
			});
	function getDate() {
		var dept = document.getElementById("dept").value;
		var dept2 = document.getElementById("dept2");
		dept2.value = dept;
		var year = document.getElementById("year").value;
		var year2 = document.getElementById("year2");
		year2.value = year;
		var month = document.getElementById("month").value;
		var month2 = document.getElementById("month2");
		month2.value = month;
	}
	
	$(document).ready(function(){		
		//点击链接的时候调用
		$("#go").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var y = $("#year").val();
			var m = $("#month").val();
			var d = $("#dept").val();
			var number = document.myf.num.value;
			var maxnum = "${requestScope.totalPages}";
			if (number.length == 0) {
				alert("请先输入要查找的页数!");
				return;
			} else if(number <= 0 || number > maxnum){
				alert("页面不存在！");
				return;
			}
			$("#go").attr("href","emppageSelectTax.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d + "&syear=" + y + "&smonth=" + m);
	      }); 
		$("#first").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var y = $("#year").val();
			var m = $("#month").val();
			var d = $("#dept").val();
			$("#first").attr("href","emppageSelectTax.action?page=1&empId=" + i + "&trueName=" + n + "&dept=" + d + "&syear=" + y + "&smonth=" + m);
	      }); 
		$("#pre").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var y = $("#year").val();
			var m = $("#month").val();
			var d = $("#dept").val();
			var number = "${requestScope.page-1}";
			$("#pre").attr("href","emppageSelectTax.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d + "&syear=" + y + "&smonth=" + m);
	      }); 
		$("#next").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var y = $("#year").val();
			var m = $("#month").val();
			var d = $("#dept").val();
			var number = "${requestScope.page+1}";
			$("#next").attr("href","emppageSelectTax.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d + "&syear=" + y + "&smonth=" + m);
	      }); 
		$("#last").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var y = $("#year").val();
			var m = $("#month").val();
			var d = $("#dept").val();
			var number = "${requestScope.totalPages}";
			$("#last").attr("href","emppageSelectTax.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d + "&syear=" + y + "&smonth=" + m);
	      }); 
	});
</script>

</head>
<body>
	<div class="table_top" style="height: 100%">
		<div>
			<table width="100%" class="top" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_top"><b>当前位置:</b>&nbsp;薪资管理>>查询个人纳税表</td>
					<td align="right"></td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<div style="margin-bottom: 10px; float: left;">
				<s:form action="findTax" method="post" theme="simple">
			工号：<s:textfield id="empid" name="empId" cssClass="input" />&nbsp;&nbsp;
			姓名：<s:textfield id="truename" name="trueName" cssClass="input" />&nbsp;&nbsp;
			部门：<select id="dept" name="tax.dept">
						<c:forEach var="everyDept" items="${deptList}">
							<c:choose>
								<c:when test="${everyDept==dept}">
									<option value="${everyDept}" selected>${everyDept}</option>
								</c:when>
								<c:otherwise>
									<option value="${everyDept}">${everyDept}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>&nbsp;&nbsp;
			年份：<select id="year" name="tax.year" cssClass="input"></select>&nbsp;&nbsp;
			月份：<select id="month" name="tax.month">
						<c:forEach var="everyMonth" items="${monthList}">
							<c:choose>
								<c:when test="${everyMonth==month}">
									<option value="${everyMonth}" selected>${everyMonth}</option>
								</c:when>
								<c:otherwise>
									<option value="${everyMonth}">${everyMonth}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>&nbsp;&nbsp;
			<s:submit cssClass="buttonBack" value="查询" />
				</s:form>
			</div>
			<div style="float: left;">
				<s:form action="addTax" method="post" theme="simple">
					<input id="dept2" name="tax.dept" style="display: none">
					<input id="year2" name="tax.year" style="display: none">&nbsp;&nbsp;
			        <input id="month2" name="tax.month" style="display: none" />
					<s:submit cssClass="buttonBack" value="生成" onclick="getDate();" />
				</s:form>
			</div>
			<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
				<tr class="table_head">
					<th>序号</th>
					<th>工号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>身份证号</th>
					<th>部门</th>
					<th>年份</th>
					<th>月份</th>
					<th>纳税人收入额</th>
					<th>应纳税所得额</th>
					<th>纳税额</th>
				</tr>
				<c:forEach items="${taxs}" var="tax" varStatus="i">
					<tr class="list" bgcolor="#FFFFFF">
						<td>${idBegin + i.index+1 }</td>
						<td>${tax.empId}</td>
						<td>${tax.trueName}</td>
						<td>${tax.sex}</td>
						<td>${tax.idnum}</td>
						<td>${tax.dept }</td>
						<td>${tax.year}</td>
						<td>${tax.month}</td>
						<td>${tax.finalSalary}</td>
						<td>${tax.taxSalary}</td>
						<td>${tax.tax}</td>						
					</tr>
				</c:forEach>
			</table>
			<div style="margin-left: 200px; margin-top: 50px;">
				<form action="" method="post" name="myf">
					共<font color="red" id="tp">${requestScope.totalPages }</font>页&nbsp;&nbsp;
					当前第<font color="red">${requestScope.page }</font>页
					 <a href="" id="first">首页&gt</a>&nbsp;&nbsp; 
					 <a href="" id="pre">上一页</a> &nbsp;&nbsp; 
					 <a href="" id="next">下一页</a> &nbsp;&nbsp; 
					 第&nbsp;<input type="text" size="1" name="num" />&nbsp;页
					 <a href="" id="go">&nbsp;GO&nbsp; </a>&nbsp;&nbsp; 
					 <a href="" id="last">&lt尾页</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>