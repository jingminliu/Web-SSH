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
						   <span id="menu1"><a href="findAllUser?id=${user.id}"><font color='black' style="font-weight:bold;" size="2">��Ӻ���</font></a></span></TD>
							 <TD WIDTH=103 HEIGHT=82 background="images/menu_02.jpg">
							   <span id="menu2"><a href="findMyFriends?id=${user.id}"><font color='black' style="font-weight:bold;" size="2">��ѯ����</font></a></span>	</TD>
							    <TD WIDTH=105 HEIGHT=82 background="images/menu_03.jpg">
							   <span id="menu3"><a href="selectMyInfo?id=${user.id}"><font color='black' style="font-weight:bold;" size="2">�ҵ���Ϣ</font></a></span>
							 </TD>
							<TD WIDTH=125 HEIGHT=82 background="images/menu_04.jpg">
							<span id="menu4"><a href="index.jsp"><font color='black' style="font-weight:bold;" size="2">�ҵ����</font></a></span>
							</TD>
						</TR>						
					</TABLE>					
				</TD>				
			</TR>			
		</TABLE>
		<span id="systemtishi1">
		   <a href="index.jsp"><font color='black' size="4" style="font-weight:bold;">��ҳ</font></a><br/><br/>
		   <a href="newcomment"><font color='black' size="4" style="font-weight:bold;">�ҵĶ�̬</font></a>
		</span>	
    <div id="divcontent">
    ������Ϣ:
     <table style="font-size: 15px;">
       <tr><td style="color:CF7C3A;font-size:12px;" width="100px" height="17px" align="right">�û��ǳ�:</td><td style="color:276F01;font-size:14px;" align="left"><s:property value="userinfo.userName"/></td></tr>
       <tr><td style="color:CF7C3A;font-size:12px;" width="100px" height="17px" align="right">�û��Ա�:</td><td style="color:276F01;font-size:15px;" align="left"><s:property value="userinfo.sex"/></td></tr>
       <tr><td style="color:CF7C3A;font-size:12px;" width="100px" height="17px" align="right">�û�����:</td><td style="color:276F01;font-size:15px;" align="left"><s:property value="userinfo.birthday"/></td></tr>
       <tr><td style="color:CF7C3A;font-size:12px;" width="100px" height="17px" align="right">��ϵ�绰:</td><td style="color:276F01;font-size:15px;" align="left"><s:property value="userinfo.telephone"/></td></tr>
       <tr><td style="color:CF7C3A;font-size:12px;" width="100px" height="17px" align="right">  Email:</td><td style="color:276F01;font-size:15px;" align="left"><s:property value="userinfo.email"/></td></tr>
       <tr><td style="color:CF7C3A;font-size:12px;" width="100px" height="17px" align="right">��ͥסַ:</td><td style="color:276F01;font-size:15px;" align="left"><s:property value="userinfo.address"/></td></tr>
       <tr><td style="color:CF7C3A;font-size:12px;" width="100px" height="17px" align="right">����˵��:</td><td style="color:276F01;font-size:15px;" align="left"><s:property value="userinfo.remark"/></td></tr>
       
     </table>
    </div>
  </tr>
  
</table>
  </BODY>
</HTML>