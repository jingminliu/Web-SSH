<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html> 
	<head>
		<title>用户登录</title>
	<style type="text/css">
		.tdLabel{
			width:100px;
			font-size: 14px;
			font-weight: bold;
		}
		.login_input{
			width: 200px;
			height: 25px;
			border-color: #FF6600;
			border-style: solid;
			border-width: 1px;
			list-style: none;
		}
		.login{
			background-image: url(image/login_button.jpg);
			width:86px;
			height: 27px;
			background-color: Transparent;
			border-style: none;
		}
		.wwFormTable{
			line-height: 30px;
		}
	</style>
	</head>
	<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div style="margin-top: 0px;width: 900px;height: 30px;background-color: #FF6600;" align="left"><div style="font-size: 14px;font-weight: bold;color:white;position: relative;margin-top:5px;margin-left:10px;">用户登录</div></div>
		<div id="login" style="border: 1 #FF6600;border-style: solid;">
			<s:form action="loginAction">
				<s:textfield label="用户" name="userName" cssClass="login_input"></s:textfield>
				<s:password label="密码" name="userPassword" cssClass="login_input"></s:password>
				<s:submit type="submit" value="" cssClass="login" align="center"></s:submit>
			</s:form>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
	</body>
</html>

