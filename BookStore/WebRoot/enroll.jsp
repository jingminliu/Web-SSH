<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
 
<html> 
	<head>
		<title>用户注册</title>
	<style type="text/css">
	.reg_input{
			width: 200px;
			height: 25px;
			border-color: #FF6600;
			border-style: solid;
			border-width: 1px;
			list-style: none;
		}
	.but{
		width: 100px;
		height: 30px;
		background-color: #FF6600;
		font-size: 14px;
		font-weight: bold;
		border-style: none;
		color: white;
	}
	.errorMessage{
		color: red;
		position:absolute;
		margin-left: 155px;
		margin-top: 10px;
	}
	</style>
	</head>
	<body>
		<center>
			<jsp:include page="top.jsp"></jsp:include>
			<div style="margin-top: 0px;width: 900px;height: 30px;background-color: #FF6600;" align="left"><div style="font-size: 14px;font-weight: bold;color:white;position: relative;margin-top:5px;margin-left:10px;">用户注册</div></div>
		<div id="enroll" style="border: 1 #FF6600;border-style: solid;">
			
			
				<s:form action="enrollAction">
					<s:textfield label="用户名" name="userName" cssClass="reg_input"></s:textfield>
					<s:password label="密码" name="userPassword" cssClass="reg_input"></s:password>
					<s:password label="重复密码" name="userRePassword" cssClass="reg_input"></s:password>
					<s:textfield label="邮箱" name="userEmail" cssClass="reg_input"></s:textfield>
					<s:submit value="注册" align="center" cssClass="but"></s:submit>					
				</s:form>
			</div>
			<jsp:include page="bottom.html"></jsp:include>
		</center>
	</body>
</html>

