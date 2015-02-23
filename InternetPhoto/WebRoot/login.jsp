<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'login.jsp' starting page</title>
  <meta http-equiv="Content-Style-Type" content="text/css">
<LINK HREF="style/style.css" TYPE="text/css" REL="stylesheet"> 
</HEAD>
<BODY BGCOLOR=#2E740A LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 background="images/back-body.jpg" style="background-repeat:repeat-x;background-position:top">
<table width="799" height="660"  border="0" cellspacing="0" cellpadding="0" background="images/index.jpg" style="background-repeat:no-repeat;background-position:top left">
<tr>
    <td style="padding-top:84px;padding-left:34px">
		<TABLE WIDTH=615 BORDER=0 CELLPADDING=0 CELLSPACING=0>
			<TR>
				<TD><img src="images/spacer.gif" WIDTH=195 HEIGHT=82 ALT=""></TD>
				<TD WIDTH=420 HEIGHT=82 ALT="">
					<TABLE WIDTH=420 BORDER=0 CELLPADDING=0 CELLSPACING=0>
						<TR>
							<TD WIDTH=87 HEIGHT=82 background="images/menu_01.jpg"></TD>
							<TD WIDTH=103 HEIGHT=82 background="images/menu_02.jpg"></TD>
							<TD WIDTH=105 HEIGHT=82 background="images/menu_03.jpg"></TD>
							<TD WIDTH=125 HEIGHT=82 background="images/menu_04.jpg"></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
			<TR>
				<TD WIDTH=195 HEIGHT=127 background="images/per.jpg">
				<span id="systemtishi"><font color='black' size="5px" style="font-weight:bold;">欢迎用户登录</font></span></TD>
				<TD ROWSPAN=2 WIDTH=420 HEIGHT=360>
					<table width="420"  height="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="184" style="padding-left:23px;padding-top:29px ">
							<img src="images/3-txt-1.jpg"><br>
							<form style="margin:0;margin-left:24px;margin-top:10px" action="login" method="post">
								<table width="321"  border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="73">
										<strong class="style1">
											用户名:
											<div style="padding-top:18px;padding-bottom:18px">密      码：</div>
										</strong>
									</td>
									<td width="248">
																  
										<input type="text" name="user.userName" style="width:248px;height:15px;font-size:11px;border-color:#764320;border-style:solid;border-width:1px"><br>
										<input type="password" name="user.userPassword" style="width:248px;height:15px;font-size:11px;border-color:#764320;border-style:solid;border-width:1px;margin-top:12px;margin-bottom:13px"><br>
										<br>
										<input type="reset" value="取消"/><input type="submit" value="登录" style="margin-left:33px;margin-right:82px">							
								</tr>
								</table>
							</form>
						</td>						
					</tr>				
					</table>
				</TD>
			</TR>
			<TR>
				<TD><img src="images/spacer.gif" WIDTH=195 HEIGHT=233 ALT=""></TD>
			</TR>
		</TABLE>
	</td>    
</tr>
</table>
</BODY>
</HTML>