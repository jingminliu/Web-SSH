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
			亲，欢迎来耀点100书店！请 <a href="enroll.jsp">注册</a> &nbsp;|&nbsp;<a href="login.jsp">登录</a>
			</s:if>
			<s:else>
					<font style="color:green;font-weight: bold">
						 <s:property value="#session.loginUser.userName"/>
					</font>
					您好！欢迎光临汇智书店
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="firstPage.jsp"><font style="color: #FF6600;font-weight: bold;">首页</font></a>&nbsp;|&nbsp;<a href="personalInformation.jsp">个人信息</a> &nbsp;|&nbsp;<a href="shoppingCart.jsp">我的购物车</a>&nbsp;|&nbsp; <a href="allOrders.jsp">我的订单</a> &nbsp;|&nbsp;<a href="http://school.itzcn.com/help.html" target="_blank">帮助中心</a>
				| <a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.itzcn.com');" href="#">设为首页</a> | <a href="javascript:window.external.AddFavorite('http://www.itzcn.com')">加入收藏</a>&nbsp;|&nbsp;
					<a href="com.huizhi.action/userExitAction.action?userType=ordinaryUser">安全退出</a>
			</s:else>
			</div>
			<div id="logo" style="margin-top: 5px;">
				<a href="http://www.itzcn.com"><img src="image/logo.gif"/></a>
			</div>
			
			<div id="searchBook" style="margin-top: 0px;">
					<br/>
					<input type="radio" name="searchType" value="bookName" checked="checked"/>名称
					<input type="radio" name="searchType" value="bookAuthor"/>作者
					<input type="radio" name="searchType" value="bookPress"/>出版社<br/>
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