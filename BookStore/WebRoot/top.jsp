<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<style type="text/css">
		a{
			font-size: 12px;
			text-decoration: none;
			color: black;
		}
		a:HOVER {
			color: red;
			text-decoration: none;
		}
		.serach{
			width:131px;
			height:35px;
			background-image: url("image/serach.jpg");
			background-color: Transparent;
			border: 0;
			list-style: none;
			border-style: none;
			margin-left: -9px;
			margin-top: 0px;
		}
		.input{
			width: 300px;
			height: 35px;
			border-color: #FF6600;
			border-style: solid;
			border-width: 1px;
			list-style: none;
		}
	</style>
  </head>

<body>
	<center>
		<div id="top">
			<div width="900px" height="30px" style="margin-left: 0px;margin-top:10px;" align="left">
			<s:if test="%{#session.loginUser == null}">
			�ף���ӭ��ҫ��100��꣡�� <a href="enroll.jsp">ע��</a> &nbsp;|&nbsp;<a href="login.jsp">��¼</a>
			</s:if>
			<s:else>
					<font style="color:green;font-weight: bold">
						 <s:property value="#session.loginUser.userName"/>
					</font>
					���ã���ӭ���ٻ������
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="firstPage.jsp"><font style="color: #FF6600;font-weight: bold;">��ҳ</font></a>&nbsp;|&nbsp;<a href="personalInformation.jsp">������Ϣ</a> &nbsp;|&nbsp;<a href="shoppingCart.jsp">�ҵĹ��ﳵ</a>&nbsp;|&nbsp; <a href="allOrders.jsp">�ҵĶ���</a> &nbsp;|&nbsp;<a href="http://school.itzcn.com/help.html" target="_blank">��������</a>
				| <a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.itzcn.com');" href="#">��Ϊ��ҳ</a> | <a href="javascript:window.external.AddFavorite('http://www.itzcn.com')">�����ղ�</a>&nbsp;|&nbsp;
					<a href="com.huizhi.action/userExitAction.action?userType=ordinaryUser">��ȫ�˳�</a>
			</s:else>
			</div>
			<div id="logo" style="margin-top: 5px;">
				<a href="http://www.itzcn.com"><img src="image/logo.gif"/></a>
			</div>
			
			<div id="searchBook" style="margin-top: 0px;">
					<br/>
					<input type="radio" name="searchType" value="bookName" checked="checked"/>����
					<input type="radio" name="searchType" value="bookAuthor"/>����
					<input type="radio" name="searchType" value="bookPress"/>������<br/>
					<input type="text" name="searchDescribe" id="searchDescribeID" class="input" />
					<input type="button" value="" onclick="searchBook()" class="serach"/>
			</div>
			<hr/>
		</div>
	</center>
</body>
<SCRIPT type="text/javascript">
<!--
	function searchBook(){
		var searchType = "";
		for (i=0;i<document.all.searchType.length;i++){
		    if (document.all.searchType[i].checked){
		    	searchType = document.all.searchType[i].value;
		    }
	    }
		var searchDescribe = document.getElementById("searchDescribeID").value;
		location.href="oneType.jsp?searchType="+searchType+"&searchDescribe="+searchDescribe;
	}
//-->
</SCRIPT>
</html>