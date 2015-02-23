<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  
  <body>
    <center>
    	<jsp:include page="top.jsp"></jsp:include>
		<div id="singleBook">
			<div id="left">
				<jsp:include page="left.jsp"></jsp:include>
			</div>
			<div id="bookInfor">
			<s:action name="singleBookAction" executeResult="false"></s:action>
				<ul class="singleBookUl">
					<li class="singleBookName">
						<s:property value="#request.singleBook.bookName"/>
					</li>
					<li class="singleBookPicture">
						<img src='upload/<s:property value="#request.singleBook.bookPicture"/>' />
					</li>
					<li class="singleBookInfor">
						���ߣ�<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="#request.singleBook.bookAuthor"/>"><s:property value="#request.singleBook.bookAuthor"/></a><br/><br/>
						�����磺<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="#request.singleBook.bookPress"/>"><s:property value="#request.singleBook.bookPress"/></a><br/><br/>
						���<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="#request.singleBook.type.typeId"/>"><s:property value="#request.singleBook.type.typeName"/></a><br/><br/>
						�ϼ�ʱ�䣺<s:date name="#request.singleBook.bookShelveTime" format="yyyy-MM-dd HH:mm:ss"/><br/><br/>
						ͼ���飺<s:property value="#request.singleBook.bookRemark"/><br/><br/>
						ԭ�ۣ�<font style="text-decoration: line-through;color:red;"><s:property value="#request.singleBook.bookPrice"/></font> Ԫ&nbsp;&nbsp;&nbsp;&nbsp;�ּۣ�<s:property value="#request.singleBook.bookNewPrice"/> Ԫ<br/><br/><br/><br/>
						<a href='com.huizhi.action/shoppingCartAction.action?bookId=<s:property value="#request.singleBook.bookId"/>' style="text-decoration: none;">
						<img alt="���빺�ﳵ" src="image/button.jpg">
						</a>
					</li>
				</ul>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
    </center>
  </body>
