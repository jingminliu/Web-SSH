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
    <div id="divcontent">
     我的好友      <a href="findAllUser?id=${user.id}" id="addFolder"><font size="3px">添加好友</font></a>
       <s:if test="#session.myFriendsList==null">
       <br/><font color='red'>暂无好友列表</font></s:if>
       <s:else>
      <TABLE cellSpacing=0 cellPadding=2 border="1px">
       <TR>
         <TD align=center width=80>好友名称</TD>
         <TD align=center width=80>查看详细信息</TD> 
         <TD align=center width=80>删除好友</TD> 
         <TD align=center width=80>浏览相册</TD> 
      </TR>
      <s:iterator value="#session.myFriendsList">
      <tr>
         <td  align=center width=80><s:property value="userName"/></td>
         <td  align=center width=80><a href="scanUser?id=${id}">查看详细信息</a></td> 
         <td  align=center width=80><a href="delFriend?id=${id}">删除好友</a></td>
         <td  align=center width=80><a href="scanFriendFolder?friendid=${id}">浏览相册</a></td>
      </tr>
       </s:iterator>
      </TABLE> 
      </s:else> 
    </div>
  </tr>
  
</table>
  </BODY>
</HTML>