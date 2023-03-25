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
			var u = $("#username").val();
			var number = document.myf.num.value;
			var maxnum = "${requestScope.totalPages}";
			if (number.length == 0) {
				alert("请先输入要查找的页数!");
				return;
			} else if(number <= 0 || number > maxnum){
				alert("页面不存在！");
				return;
			}
			$("#go").attr("href","emppageSelectUser.action?page=" + number + "&userName=" + u);
	      }); 
		$("#first").click(function(){
			var u = $("#username").val();
			$("#first").attr("href","emppageSelectUser.action?page=1&userName=" + u);
	      }); 
		$("#pre").click(function(){
			var u = $("#username").val();
			var number = "${requestScope.page-1}";
			$("#pre").attr("href","emppageSelectUser.action?page=" + number + "&userName=" + u);
	      }); 
		$("#next").click(function(){
			var u = $("#username").val();
			var number = "${requestScope.page+1}";
			$("#next").attr("href","emppageSelectUser.action?page=" + number + "&userName=" + u);
	      }); 
		$("#last").click(function(){
			var u = $("#username").val();
			var number = "${requestScope.totalPages}";
			$("#last").attr("href","emppageSelectUser.action?page=" + number + "&userName=" + u);
	      }); 
	});
</script>
</head>
<body>
	<div class="table_top" style="height: 100%">
		<div>
			<table width="100%" class="top" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_top"><b>当前位置:</b>&nbsp;用户管理>>查询所有账号信息</td>
					<td align="right"></td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top: 10px;">
			<div style="margin-bottom: 10px; float: left;">
				<s:form action="findUser" method="post" theme="simple">
			用戶名：<s:textfield id="username" name="userName" cssClass="input" />&nbsp;&nbsp;
			<s:submit cssClass="buttonBack" value="查询" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="addUser.action"> <img src="../skin/22.gif" />&nbsp;&nbsp;添加
					</a>&nbsp;&nbsp;
				</s:form>
			</div>
			<table border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
				<tr class="table_head">
					<th>序号</th>
					<th>用戶名</th>
					<th>密码</th>
					<th>权限</th>
					<th>所属部门</th>
					<th>基本操作</th>
				</tr>
				<c:forEach items="${users}" var="user" varStatus="i">
					<tr class="list" bgcolor="#FFFFFF">
						<td>${idBegin + i.index+1}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.rights}</td>
						<td>${user.dept}</td>
						<td><a href="user!load.action?user.username=${user.username}">
								<img src="../skin/edt.gif" />修改
						</a><a href="user!delete.action?user.username=${user.username}"> <img
								src="../skin/del.gif" />删除
						</a></td>
					</tr>
				</c:forEach>
			</table>
			<div style="margin-left: 200px; margin-top: 50px;">
				<form action="" method="post" name="myf">
					共<font color="red" id="tp">${requestScope.totalPages }</font>页&nbsp;&nbsp;
					当前第<font color="red">${requestScope.page }</font>页 <a href=""
						id="first">首页&gt</a>&nbsp;&nbsp; <a href="" id="pre">上一页</a>
					&nbsp;&nbsp; <a href="" id="next">下一页</a> &nbsp;&nbsp; 第&nbsp;<input
						type="text" size="1" name="num" />&nbsp;页 <a href="" id="go">&nbsp;GO&nbsp;
					</a>&nbsp;&nbsp; <a href="" id="last">&lt尾页</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>