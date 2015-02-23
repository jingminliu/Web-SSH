<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
							
							</TD>
							<TD WIDTH=103 HEIGHT=82 background="images/menu_02.jpg">
							
							</TD>
							<TD WIDTH=105 HEIGHT=82 background="images/menu_03.jpg">
							
							</TD>
							<TD WIDTH=125 HEIGHT=82 background="images/menu_04.jpg">
							
							</TD>
						</TR>								
					</TABLE>					
				</TD>				
			</TR>			
		</TABLE>		
    <div id="divregsuc">
     <font color='red'>恭喜您,网络相册系统注册完成 </font><a href="login.jsp">是否登录</a>
    </div>
  </tr>  
</table>
  </BODY>
</HTML>