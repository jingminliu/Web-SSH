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
       ��Ƭ�б�       <a href="prepareupload?id=<s:property value='id'/>" id="uploadphoto"><font size="3px">�ϴ���Ƭ</font></a>
      <s:if test="#session.photoList==null">
        <br/><br/><font color='red'>������Ƭ�б�</font></s:if>
      <s:else>
       <br/><br/><br/><br/>
        <table>
            <tr>
        <s:iterator value="#session.photoList">       
           <td style="padding:10px;">
           <table>
             <tr>
              <td colspan="2"><img height="150px" width="150px" src="upload/<s:property value="photoPath"/>"/>
              </td>
             </tr>
             <tr>
              <td align="center"><a href="scanPhoto?pid=${id}&type=0&id=${folderid}&pageIndex=<s:property value="pageIndex"/>">�鿴��ͼ</a></td>
              <td align="center"><a href="delphoto?pid=${id}&id=${folderid}&pageIndex=<s:property value="pageIndex"/>">ɾ����Ƭ</a></td>
             </tr>
           </table>
           </td>             
         </s:iterator>
           </tr>
       </table>
       <br/>
      <a href="scanFolder?id=<s:property value='id'/>&pageIndex=1">��ҳ</a>
      <a href="scanFolder?id=<s:property value='id'/>&pageIndex=<s:property value="pageIndex-1"/>">��һҳ</a>
      <a href="scanFolder?id=<s:property value='id'/>&pageIndex=<s:property value="pageIndex+1"/>">��һҳ</a>
      <a href="scanFolder?id=<s:property value='id'/>&pageIndex=<s:property value="totalPage"/>">ĩҳ</a> 
      </s:else>
    </div>
  </tr>
  
</table>
  </BODY>
</HTML>