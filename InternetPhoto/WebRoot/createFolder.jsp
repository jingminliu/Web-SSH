<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <meta http-equiv="Content-Style-Type" content="text/css">
<LINK HREF="style/style.css" TYPE="text/css" REL="stylesheet"> 
</HEAD>
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
       �ҵ����<br/><br/>
        <form action="createFolder" method="post">
         <table border=0 class="wwFormTable">
          <tr height="20"><td>�������:</td><td><input type="text" name="folder.folderName"/></td></tr>
          <tr><td>���˵��:</td><td><input type="text" name="folder.folderInfo"/></td></tr>
          <tr><td>����Ȩ��:</td>
           <td><select name="folder.limit">
           <option value="0">���������˷���</option>
           <option value="1" selected="selected">ֻ������ѷ���</option>
           <option value="2">�������κ��˷���</option></select></td>
          </tr>
          <tr><td width="60px"><td rowspan="2"><input type="submit" value="���"/></td></tr>
       </table>
        </form>
    </div>
  </tr>
  
</table>
  </BODY>
</HTML>