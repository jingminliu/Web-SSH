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
		<span id="systemtishi1">
		   <font color='black' size="3px" style="font-weight:bold;">�û�ע��ҳ��</font>
		</span>			
    <div id="divregister">
     <s:form action="register" method="post">
       <s:textfield name="user.userName" label="�û���" />
       <s:password name="user.userPassword" label="��    ��"></s:password>
       <s:radio name="user.sex" list="#{'��':'��','Ů':'Ů'}" label="��  ��" listKey="key" listValue="value" value="'Ů'"/>
       <sx:datetimepicker name="user.birthday" label="����" type="date"  toggleType="explode"  value="today"></sx:datetimepicker>
       <s:textfield name="user.telephone" label="��  ��"/>
       <s:textfield name="user.email" label="��   ��"/>
       <s:textfield name="user.address" label="��   ַ"/>
       <s:textarea name="user.remark" label="��   ��"/>
       <s:submit value="ע��"/>
     </s:form>
    </div>
  </tr>  
</table>
  </BODY>
</HTML>