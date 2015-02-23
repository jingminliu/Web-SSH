<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%String context = request.getContextPath();%>
<link href="<%=context%>/resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=context%>/js/esl.js"></script>
<script type="text/javascript">
	var servletFlag = "0";
	var loginFlag = "0";
	servletFlag = <%=request.getAttribute("servletFlag")%>;
	loginFlag = <%=request.getAttribute("loginFlag")%>;
		
	function load() {		
		if (servletFlag=="1") {
			servletflag = "0";
			if(loginFlag=="1") {
				loginFlag = "0";
				window.location.href='<%=context%>/jsp/cardHolder.jsp';
			} else {
				show();
			} 
		}
	}
	
	function show() {
		/* document.getElementById("login_box").style.display = "block";
		document.getElementById("login_title").style.display = "block";
		document.getElementById("sj_line").style.display = "block";
		document.getElementById("login_main").style.display = "block"; */
		document.getElementById("login_err").style.display = "block";
	}
</script>
</head>
<body onload="load()">
<form action="/CardHolder/LoginServlet" method="post">
<div id="login_box" class="login_box">
	<div id="login_title" class="login_title"></div>
	<div id="sj_line" class="sj_line"></div>
	<div id="login_main" class="login_main">
 		<div id="login_err" class="login_err">您输入的帐号或密码有误！</div>
		<span><label>用户名：</label> <input id="usrNm" name="usrNm" type="text" class="textbox"></span>
		<span><label>密   &nbsp;码：</label> <input id="pwd" name="pwd" type="password" class="textbox"></span>
		<!-- <span><label>机    &nbsp;构：</label> <input id="ins" name="ins" type="text" class="textbox"></span> -->
		<span><input type="submit" value="登 录"></span>
	</div>
	<div class="sj_line"></div>
 	<div class="sj_footer">中国银联股份有限公司版权所有 © 2002-2013 沪ICP备07032180号</div>
</div>
</form>
</body>
</html>