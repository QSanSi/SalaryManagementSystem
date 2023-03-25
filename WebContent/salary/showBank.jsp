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
	$(document).ready(function(){		
		//点击链接的时候调用
		$("#go").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
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
			$("#go").attr("href","emppageSelectBank.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d);
	      }); 
		$("#first").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var d = $("#dept").val();
			$("#first").attr("href","emppageSelectBank.action?page=1&empId=" + i + "&trueName=" + n + "&dept=" + d);
	      }); 
		$("#pre").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var d = $("#dept").val();
			var number = "${requestScope.page-1}";
			$("#pre").attr("href","emppageSelectBank.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d);
	      }); 
		$("#next").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var d = $("#dept").val();
			var number = "${requestScope.page+1}";
			$("#next").attr("href","emppageSelectBank.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d);
	      }); 
		$("#last").click(function(){
			var i = $("#empid").val();
			var n = $("#truename").val();
			var d = $("#dept").val();
			var number = "${requestScope.totalPages}";
			$("#last").attr("href","emppageSelectBank.action?page=" + number + "&empId=" + i + "&trueName=" + n + "&dept=" + d);
	      }); 
	});
</script>

</head>
<body>
	<div class="table_top" style="height: 100%">
		<div>
			<table width="100%" class="top" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_top"><b>当前位置:</b>&nbsp;薪资管理>>银行发放表</td>
					<td align="right"></td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<div style="margin-bottom: 10px; float: left;">
				<s:form action="findBank" method="post" theme="simple">
			工号：<s:textfield id="empid" name="empId" cssClass="input" />&nbsp;&nbsp;
			姓名：<s:textfield id="truename" name="trueName" cssClass="input" />&nbsp;&nbsp;
			部门：<select id="dept" name="bank.dept">
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
			<s:submit cssClass="buttonBack" value="查询" />
				</s:form>
			</div>
			<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
				<tr class="table_head">
					<th>序号</th>
					<th>工号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>部门</th>
					<th>持卡人</th>
					<th>开户行</th>
					<th>银行卡号</th>
					<th>联系电话</th>
					<th>基本操作</th>
				</tr>
				<c:forEach items="${banks}" var="bank" varStatus="i">
					<tr class="list" bgcolor="#FFFFFF">
						<td>${idBegin + i.index+1 }</td>
						<td>${bank.empId}</td>
						<td>${bank.trueName}</td>
						<td>${bank.sex}</td>
						<td>${bank.dept }</td>
						<td>${bank.owner}</td>
						<td>${bank.bank}</td>
						<td>${bank.cardId}</td>
						<td>${bank.tel}</td>	
						<td><a href="bank!load.action?bank.id=${bank.id}">
								<img src="../skin/edt.gif" />修改
						</a></td>				
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