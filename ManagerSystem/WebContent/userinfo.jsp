<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="css/admin.css" type="text/css" rel="stylesheet">
<base href="<%=basePath%>">
<style type="text/css">
.table {
	font-size: 13px;
}
</style>
<script src="js/clock.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background=images/title_bg1.jpg>��ǰλ��:</TD>
		</TR>
		<TR>
			<TD bgColor=#b1ceef height=1></TD>
		</TR>
		<TR height=20>
			<TD background=images/shadow_bg.jpg></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
		<TR height=100>
			<TD align=middle width=100><IMG height=100
				src="images/admin_p.gif" width=90></TD>
			<TD width=60>&nbsp;</TD>
			<TD>
				<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>

					<TR>
						<TD>��ǰʱ�䣺<span id="myclock"></span></TD>
					</TR>
					<TR>
						<TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">${user.nic}</TD>
					</TR>
					<TR>
						<TD>��ӭ�����û��������ģ�</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD colSpan=3 height=10></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
		<TR height=20>
			<TD></TD>
		</TR>
		<TR height=22>
			<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
				align=middle background=images/title_bg2.jpg>${userinfo.nic}�����Ϣ</TD>
		</TR>
		<TR bgColor=#ecf4fc height=12>
			<TD></TD>
		</TR>
		<TR height=20>
			<TD></TD>
		</TR>
	</TABLE>
	<center>
		<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0
			class="table">
			<TR>
				<TD align=right width=100>��¼�ʺţ�</TD>
				<TD style="COLOR: #880000">${userinfo.username }</TD>
			</TR>
			<TR>
				<TD align=right>��ʵ������</TD>
				<TD style="COLOR: #880000">${userinfo.name}</TD>
			</TR>
			<TR>
				<TD align=right>�ǳƣ�</TD>
				<TD style="COLOR: #880000">${userinfo.nic}</TD>
			</TR>

			<TR>
				<TD align=right>�Ա�:</TD>
				<TD style="COLOR: #880000"><s:if test="userinfo.sex==0">Ů</s:if>
					<s:else>��</s:else></TD>
			</TR>
			<TD align=right>���䣺</TD>
			<TD style="COLOR: #880000">${userinfo.age}</TD>
			</TR>
			<TR>
			<TR>
				<TD align=right>Email��</TD>
				<TD style="COLOR: #880000">${userinfo.email}</TD>
			</TR>
			<TR>
				<TD align=right>��ϵ�绰��</TD>
				<TD style="COLOR: #880000">${userinfo.phone}</TD>
			</TR>
			<TR>
				<TD align=right>����˵����</TD>
				<TD style="COLOR: #880000">${userinfo.selfshow}</TD>
			</TR>
			<TR>
				<TD align=right>�û�Ȩ�ޣ�</TD>
				<TD style="COLOR: #880000"><s:if test="userinfo.roleId==0">��ͨ�û� </s:if>
					<s:elseif test="userinfo.roleId==1">����Ա</s:elseif> <s:else>��������Ա</s:else>

				</TD>
			</TR>
		</TABLE>
	</center>
</body>
</html>