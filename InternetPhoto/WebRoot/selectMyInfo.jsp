<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<sx:head parseContent="true"/>
 <meta http-equiv="Content-Style-Type" content="text/css">
<LINK HREF="style/style.css" TYPE="text/css" REL="stylesheet"> 
</head>
<BODY BGCOLOR=#2E740A LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 background="images/back-body.jpg" style="background-repeat:repeat-x;background-position:top">
<table width="799" height="660"  border="0" cellspacing="0" cellpadding="0" background="images/index.jpg" style="background-repeat:no-repeat;background-position:top left">
<tr>
    <td style="padding-top:84px;padding-left:34px">
				<TABLE WIDTH=615 BORDER=0 CELLPADDING=0 CELLSPACING=0>
			<TR>
			  <TD><img src="images/spacer.gif" WIDTH=195 HEIGHT=82></TD>
				<TD WIDTH=420 HEIGHT=82>
				   <TABLE WIDTH=420 BORDER=0 CELLPADDING=0 CELLSPACING=0>
					  <TR>
						<TD WIDTH=87 HEIGHT=82 background="images/menu_01.jpg">
						   <span id="menu1"><a href="findAllUser?id=${user.id}"><font color='black' style="font-weight:bold;" size="2">添加好友</font></a></span></TD>
							 <TD WIDTH=103 HEIGHT=82 background="images/menu_02.jpg">
							   <span id="menu2"><a href="findMyFriends?id=${user.id}"><font color='black' style="font-weight:bold;" size="2">查询好友</font></a></span>	</TD>
							    <TD WIDTH=105 HEIGHT=82 background="images/menu_03.jpg">
							   <span id="menu3"><a href="selectMyInfo?id=${user.id}"><font color='black' style="font-weight:bold;" size="2">我的信息</font></a></span>
							 </TD>
							<TD WIDTH=125 HEIGHT=82 background="images/menu_04.jpg">
							<span id="menu4"><a href="index.jsp"><font color='black' style="font-weight:bold;" size="2">我的相册</font></a></span>
							</TD>
						</TR>						
					</TABLE>					
				</TD>				
			</TR>			
		</TABLE>
		<span id="systemtishi1">
		   <a href="index.jsp"><font color='black' size="4" style="font-weight:bold;">首页</font></a><br/><br/>
		   <a href="newcomment"><font color='black' size="4" style="font-weight:bold;">我的动态</font></a>
		</span>	
    <div id="divlogin">
    个人信息:
       <s:form action="modifyuser" method="post">
				<s:textfield name="userinfo.userName" label="用户名" />
				<s:textfield name="userinfo.userPassword" label="登录密码" />
				<s:radio list="#{'男':'男','女':'女'}" name="userinfo.sex" value="userinfo.sex" label="性别" />
				<sx:datetimepicker name="userinfo.birthday" label="生日" type="date" toggleType="explode" value="userinfo.birthday"></sx:datetimepicker>
				<s:textfield name="userinfo.telephone" label="联系电话" />
				<s:textfield name="userinfo.email" label="邮箱地址" />
				<s:textfield name="userinfo.address" label="住址"/>
				<s:textfield name="userinfo.remark" label="个人说明" />
				<s:submit value="修改" />

			</s:form>
    </div>
  </tr>
  
</table>
  </BODY>
</HTML>