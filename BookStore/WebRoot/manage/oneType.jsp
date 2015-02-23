<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  
  <body>
    <center>
    	<jsp:include page="top.jsp"></jsp:include>
		<div id="managePage">
			<div id="left">
				<jsp:include page="manageLeft.jsp"></jsp:include>
			</div>
			<div id="oneType" style="width: 100%;background-color: white;margin-top: -200px;margin-left: 180px;">
			<s:action name="oneTypeAction" executeResult="false"></s:action>
	    		<ul class="allBookUl" style="width: 700px;float: left;">
	    			<li class="allBookHead" style="width: 100%;background-color: yellow;color: black;">
	    				<s:property value="#request.typeDescribe"/>
	    			</li>
					<s:iterator value="#request.bookList" status="st">
						<li class="allBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookId" />"><img src='<%=basePath%>upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="allBookInfor" style="width: 200px;">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName" /></a><br/><br/>
							���ߣ�<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
							�����磺<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
							���<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="type.typeId"/>"><s:property value="type.typeName"/></a><br/><br/>
						</li>
					</s:iterator>
	    		</ul>
	    	</div>	
		</div>
		<jsp:include page="bottom.html"></jsp:include>
    </center>
  </body>
