<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="../css/main.css" type="text/css"></link>



<style type="text/css">
	body{
		text-align:center;
	}
	.buttonBack{
		background: url(../skin/83.gif);
		width:67px;
		height:22px;
		border:0px;
		cursor: pointer;
	}
	input{
		border:1px solid gray;
		height:22px;
	}
	a:hover{
		text-decoration: underline;
	}
</style>
</head>
<body style="overflow-y:scroll">
	
   
<div class="table_top" style="height:100%" >
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="list.action">用户管理</a>>>修改密码</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<br><s:form action="updatePassword" theme="simple" method="post">
		<fieldset style="width:98%">
			<legend style="font-size:16px;">修改密码：</legend>
			<table class="list_user" border="0" cellpadding="0" cellspacing="15">
            <tr>
                <td>旧密码：</td>
                <td ><input type="password" name="oldPassword"/> 
                <span id="passwordMsg" style="color:red">${password_error}</span><br/></td>
                  
            </tr>
            <tr>
                <td>新密码：</td>
                <td ><input type="password" name="newPassword1"/></td>
                  
            </tr>
            <tr>
                <td>再次输入新密码：</td>
                 <td ><input type="password" name="newPassword2"/>
                  <span id="newPasswordMsg" style="color:red">${newPassword_error}</span><br/></td>
                   
            </tr>
            
            <tr>
                <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="1">&nbsp;</td>
                <td align="right">
                 	<s:submit cssClass="buttonBack" value="修改"/>
                 	&nbsp;&nbsp;&nbsp;            
                </td>
            </tr>
        </table>
     </fieldset>
     </s:form>
    </div>
  </div>
</body>
</html>