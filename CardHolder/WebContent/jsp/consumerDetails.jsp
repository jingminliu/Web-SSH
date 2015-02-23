<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
<%
	String context = request.getContextPath();
%>
<link href="<%=context%>/resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=context%>/js/esl.js"></script>
<script type="text/javascript">
	var transNm = <%=request.getAttribute("transNm")%>;
	var mchntNm = <%=request.getAttribute("mchntNm")%>;
	var sum = <%=request.getAttribute("sum")%>;
	var time = <%=request.getAttribute("time")%>;
	var mchntTp = <%=request.getAttribute("mchntTp")%>;
	var transChnnl = <%=request.getAttribute("transChnnl")%>;
	var cardNum = <%=request.getAttribute("cardNum")%>;
	var year = <%=request.getAttribute("year")%>;
	
	var transNmArr = transNm.split(",");
	var mchntNmArr = mchntNm.split(",");
	var sumArr = sum.split(",");
	var timeArr = time.split(",");
	var mchntTpArr = mchntTp.split(",");
	var transChnnlArr = transChnnl.split(",");

	function load() {
		init();
	}
	
	function toOpen(id){
		parent.parent.initConsDetl(transNmArr[id], mchntNmArr[id],
				mchntTpArr[id], transChnnlArr[id], timeArr[id], sumArr[id]);
		parent.parent.showDetailsModal();
	}
	
	function reBack(){
		//window.history.go(-2);
		//return false; 
		var ifr = parent.parent.document.getElementById("right");
		ifr.src='/CardHolder/BillServlet?cardNum=' + cardNum + "&yearSelect=" + year;
	}
	
	function init() {
		if(cardNum == null || cardNum == "null") {
			document.getElementById("consDetl").style.display = "none";
			document.getElementById("returnBtn").style.display = "none";
			document.getElementById("cardNum").value = parent.parent.getCardNum();
			document.getElementById("year").value = parent.parent.getYear();
		} else if(transNm =="") {
			document.getElementById("consDetl").style.display = "none";
			//document.getElementById("returnBtn").style.display = "none";
			document.getElementById("cardNum").value = cardNum;
			document.getElementById("year").value = year;
		} else {
			document.getElementById("cardNum").value = cardNum;
			document.getElementById("year").value = year;
			for(var i=0;i<transNmArr.length;i++) {
				document.getElementById("transNm"+i).innerHTML = transNmArr[i];
				document.getElementById("mchntNm"+i).innerHTML = mchntNmArr[i];
				document.getElementById("sum"+i).innerHTML = sumArr[i];
				document.getElementById("time"+i).innerHTML = timeArr[i];
				document.getElementById("detl"+i).innerHTML = "详情";
			}		
			if(transNmArr.length<10) {
				for(var i=transNmArr.length;i<10;i++) {
					document.getElementById("cons"+i).style.display = "none"; 
				}
			}
		}
	}
	
</script>
</head>

<body onload="load()" style="background: none">
	<div class="qj_box">
		<!---->		
		<div class="xf_box">
			<div class="zhangdan_title">
				<strong>消费明细</strong>
			</div>
			<form name="myform" method="post" action="/CardHolder/ConsumerDetailsServlet">
			<div class="xz_box">
				<select name="monthSelect" class="sl">
					<option value="01" selected>请选择月份</option>
					<option value="01">一月</option>
					<option value="02">二月</option>
					<option value="03">三月</option>
					<option value="04">四月</option>
					<option value="05">五月</option>
					<option value="06">六月</option>
					<option value="07">七月</option>
					<option value="08">八月</option>
					<option value="09">九月</option>
					<option value="10">十月</option>
					<option value="11">十一月</option>
					<option value="12">十二月</option>
				</select> 
				<input name="cardNum" id="cardNum" value="" type="text" style="display:none"/>
				<input name="year" id="year" value="" type="text" style="display:none"/>
				<input type="submit" value="查询" />
			</div>
			</form>	
			<table id="consDetl" width="100%" border="0" cellspacing="0" cellpadding="0"
				class="biaoge_box">
				<tr id="consTitl">
					<th scope="col">交易名称</th>
					<th scope="col">商户名称</th>
					<th scope="col">交易金额</th>
					<th scope="col">交易时间</th>
					<th scope="col">操作</th>
				</tr>
				<tr id="cons0">
					<td id="transNm0"></td>
					<td id="mchntNm0"></td>
					<td id="sum0"></td>
					<td id="time0"></td>
					<td><div>
							<a id="detl0" href="javascript:void(0)" class='basic' onclick="toOpen(0)"></a>
						</div></td>
				</tr>
				<tr id="cons1">
					<td id="transNm1"></td>
					<td id="mchntNm1"></td>
					<td id="sum1"></td>
					<td id="time1"></td>
					<td><div>
							<a id="detl1" href="javascript:void(0)" class='basic' onclick="toOpen(1)"></a>
						</div></td>
				</tr>
				<tr id="cons2">
					<td id="transNm2"></td>
					<td id="mchntNm2"></td>
					<td id="sum2"></td>
					<td id="time2"></td>
					<td><div>
							<a id="detl2" href="javascript:void(0)" class='basic' onclick="toOpen(2)"></a>
						</div></td>
				</tr>
				<tr id="cons3">
					<td id="transNm3"></td>
					<td id="mchntNm3"></td>
					<td id="sum3"></td>
					<td id="time3"></td>
					<td><div>
							<a id="detl3" href="javascript:void(0)" class='basic' onclick="toOpen(3)"></a>
						</div></td>
				</tr>
				<tr id="cons4">
					<td id="transNm4"></td>
					<td id="mchntNm4"></td>
					<td id="sum4"></td>
					<td id="time4"></td>
					<td><div>
							<a id="detl4" href="javascript:void(0)" class='basic' onclick="toOpen(4)"></a>
						</div></td>
				</tr>
				<tr id="cons5">
					<td id="transNm5"></td>
					<td id="mchntNm5"></td>
					<td id="sum5"></td>
					<td id="time5"></td>
					<td><div>
							<a id="detl5" href="javascript:void(0)" class='basic' onclick="toOpen(5)"></a>
						</div></td>
				</tr>
				<tr id="cons6">
					<td id="transNm6"></td>
					<td id="mchntNm6"></td>
					<td id="sum6"></td>
					<td id="time6"></td>
					<td><div>
							<a id="detl6" href="javascript:void(0)" class='basic' onclick="toOpen(6)"></a>
						</div></td>
				</tr>
				<tr id="cons7">
					<td id="transNm7"></td>
					<td id="mchntNm7"></td>
					<td id="sum7"></td>
					<td id="time7"></td>
					<td><div>
							<a id="detl7" href="javascript:void(0)" class='basic' onclick="toOpen(7)"></a>
						</div></td>
				</tr>
				<tr id="cons8">
					<td id="transNm8"></td>
					<td id="mchntNm8"></td>
					<td id="sum8"></td>
					<td id="time8"></td>
					<td><div>
							<a id="detl8" href="javascript:void(0)" class='basic' onclick="toOpen(8)"></a>
						</div></td>
				</tr>
				<tr id="cons9">
					<td id="transNm9"></td>
					<td id="mchntNm9"></td>
					<td id="sum9"></td>
					<td id="time9"></td>
					<td><div>
							<a id="detl9" href="javascript:void(0)" class='basic' onclick="toOpen(9)"></a>
						</div></td>
				</tr> 
			</table>
			<div id="returnBtn" class="fh_btn">
				<input type="submit" onclick="reBack()" value="返 回" />
			</div>
		</div>
	</div>
	<!---->	
</body>
</html>