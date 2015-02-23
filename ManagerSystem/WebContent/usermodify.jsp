<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="css/admin.css" type="text/css" rel="stylesheet">
<base href="<%=basePath%>"%>
<style type="text/css">
	.label{
		font-size:14px;
	}
	.tdLabel{
		width=:150px;
	}
</style>
<script src="js/clock.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<table cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<tr heigh=28>
			<td background=images/title_bg1.jpg>
				当前位置:
			</td>
		</tr>
		<tr>
			<td bgColor=#b1ceef height=1></td>
		</tr>
		<tr height=20>
			<td background=images/shadow_bg.jgp></td>
		</tr>
	</table>
	<table cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
		<tr height=100>
			<td align=middle width=100>
				<img height=100 src="images/admin_p.gif" width=90>
			</td>
			<td width=60>
			 	&nbsp;
			</td>
			<td>
				<table height=100 cellSpacing=0 celPadding=0 width="100%" border=0>
				<tr>
					<td>
						当前时间:<span id="myclock"></span>
					</td>
				</tr>
				<tr>
					<td style="FONT-WEIGHT:bold;FONT-SIZE:16px">
						${user.nic}
					</td>
				</tr>
				<tr>
					<td>
						欢迎进入用户管理中心！
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colSpan=3 height=10></td>
	</tr>
	</table>
	<table cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
		<tr height=20>
			<td></td>
		</tr>
		<tr height=22>
			<td style="PADDING-LEFT:20px;FONT-WEIGHT:bold;COLOR:#ffffff" align=middle background=images/title_bg2.jpg>
			${userinfo.nic}--相关信息
			</td>
		</tr>
		<tr bgColor=#ecf4fc height=12>
			<td></td>
		</tr>
		<tr height=20>
			<td></td>
		</tr>
	</table>
	<center>
		<s:form action="common/modifyuser" method="post">
			<s:textfield name="userinfo.username" label="登陆账号"/>
			<s:textfield name="userinfo.password" label="登陆密码"/>
			<s:textfield name="userinfo.name" label="真实姓名"/>
			<s:textfield name="userinfo.nic"/>
			<s:radio list="#{1:'男',0:'女'} " name="userinfo.sex" value="userinfo.sex" label="性别"/>
			<s:textfield name="userinfo.age" label="年龄"/>
			<s:textfield name="userinfo.email" label="邮箱地址"/>
			<s:textfield name="userinfo.phone" label="联系电话"/>
			<s:textfield name="userinfo.selfshow" label="个人说明"/>
			<s:submit value="修改"/>
		</s:form>
	</center>
</body>
</html>