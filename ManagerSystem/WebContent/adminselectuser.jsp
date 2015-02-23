<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="css/admin.css" type="text/css" rel="stylesheet">
<base href="<%=basePath%>">
<style type="text/css">
	A:link{
		COLOR:#036;TEXT-DECORATION:none
	}
	A:visited{
		COLOR:#36;TEXT-DECORATION:none
	}
	A:hover{
		COLOR:#f60;TEXT_DECORATION:none
	}
	td{
		font-size:15px;
	}
</style>
<script src="js/clock.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>

<table cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
	<tr height=28>
		<td background=images/title_bg1.jpg>当前位置: </td></tr>
	<tr>
		<td bgColor=#b1ceef height=1></td></tr>
	<tr height=20>
		<td background=images/shadow_bg.jpg></td></tr></table>
<table cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
	<tr height=100>
		<td align=middle width=100><img heght=100 src="images/admin_p.gif" width=90></td>
		<td width=60>&nbsp;</td>
		<td>
			<table height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>
				<tr>
					<td>当前时间：<span id="myclock"></span></td></tr>
				<tr>
					<td style="FONT-WEIGHT:bold; FONT-SIZE:16px">${user.nic}</td></tr>
				<tr>
					<td>欢迎进入用户管理中心！</td></tr></table></td></tr>
	<tr>
		<td colSpan=3 height=10></td></tr></table>
<table cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
	<tr height=20>
		<td></td></tr>
	<tr height=22>
		<td style="PADDING-LEF:20px;FONT-WEIGHT:bold;COLOR:#ffffff" align=middle background=images/title_bg2.jpg>所有用户信息列表如下</td></tr>
	<tr bgColor=#ecf4fc height=12>
		<td></td></tr>
	<tr height=20>
		<td></td></tr></table>		
<center>
<table cellSpacing=0 cellPadding=2 width="95%" align=center class="table" border="1px">
	<tr>
		<TD align=center width=80>登录帐号</TD>
    	<TD align=center width=50>昵称</TD>
   		<TD align=center width=80>真实姓名</TD>
    	<td align="center" width=80>查看详情</td>
    	<td align="center" width=80>删除用户</td>
    	<td align="center" width=80>修改用户</td>  
    </tr>
    <s:iterator value="#session.alluserList">
    	<tr>
    		<td align=center width=80><s:property value="username"/></td>
    		<td align=center width=100><s:property value="nic"/></td>
    		<td align=center width=100><s:property value="name"/></td>
    		<td align=center width=80><a href="common/scan?id=${id}" target="main">查看详情</a></td>
    		<td align=center width=80><a href="admin/deleteuser?id=${id}" target="main">删除用户</a></td>
    		<td align=center width=80><a href="common/modifydispatch?id=${id}" target="main">修改用户</a></td>
   		</tr>
    </s:iterator> 
</table>
</center>
</body>
</html>