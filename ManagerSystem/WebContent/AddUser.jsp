<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<base href="<%=basePath%>">
<script src="js/clock.js" type="text/javascript"></script>
</head>
<style type="text/css">
.errorMessage{
	font-size:12px;
	color:red;
}
.label{
	font-size:12px;
}
.errorLabel{
	font-size:14px;
	color:red;
}
</style>
<body>
<table cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
	<tr height=28>
		<td background=images/title_bg1.jpg>当前位置:${tip} </td></tr>
	<tr>
		<td bgColor=#b1ceef height=1></td></tr>
	<tr height=20>
		<td background=images/shadow_bg.jpg></td></tr></table>
<table cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
	<tr height=100>
		<td align=middle width=100><img height=100 src="images/admin_p.gif" width=90></td>
		<td width=60>&nbsp;</td>
		<td>
			<table height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>
				<tr>	
					<td>当前时间：<span id="myclock"></span></td></tr>
				<tr>
					<td style="FONT-WEIGHT:bold;FONT-SIZE:16px">${user.nic}</td></tr>
				<tr>
					<td>欢迎进入用户管理中心！</td></tr></table></td></tr>
	<tr>
		<td colSpan=3 height=10></td></tr></table>
<table cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
	<tr height=20>
		<td></td></tr>
	<tr height=22>
		<td style="PADDING-LEFT:20px; FONT-WEIGHT:bold; COLOR:#ffffff" align=middle background=images/title_bg2.jpg>添加普通用户</td></tr>
	<tr bgColor=#ecf4fc height=12>
		<td></td></tr>
	<tr height=20>
		<td></td></tr></table>
<center>
<font color='red'><s:property value="errors.addusererr[0]"/></font>
<table cellSpacing=0 cellPadding=2 width="95%" align=center border=0 class="table">
	<s:form action="admin/adduser" method="post">
		<s:textfield name="user.username" label="用户名"/>
		<s:textfield name="user.password" label="密码"/>
		<s:textfield name="user.name" label="真实姓名"/>
		<s:textfield name="user.nic" label="用户昵称"/>
		<s:radio list="#{1:'男',0:'女'}" label="性别" name="user.sex" value="1"/>
		<s:textfield name="user.age" label="年龄"/>
		<s:textfield name="user.email" label="电子邮箱"/>
		<s:textfield name="user.phone" label="联系电话"/>
		<s:textarea name="user.selfshow" label="个人说明"/>
		<s:submit value="添加"></s:submit>
		</s:form>
		</table>
</center>
</body>
</html>