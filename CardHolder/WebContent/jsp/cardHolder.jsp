<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>持卡人账单</title>
<%String context = request.getContextPath();%>
<link href="<%=context%>/resources/css/style.css" rel="stylesheet" type="text/css" />
<link type='text/css' href='<%=context%>/resources/css/popup.css' rel='stylesheet'
	media='screen' />
<script type="text/javascript" src="<%=context%>/js/esl.js"></script>

<script type="text/javascript">
	var year;
	var cardNum;
	
	function setYear(y){
		year = y;
	}
	
	function getYear() {
		return year;
	}
	
	function setCardNum(c) {
		cardNum = c;
	}
	
	function getCardNum() {
		return cardNum;
	}
	
	function cssTo(where, cardNum, year) {
		var ifr = document.getElementById("right");
		var billTab = document.getElementById("ckr");
		var travelTab = document.getElementById("sl");
		if (where == 1) {
			billTab.src = "<%=context%>/resources/img/btn/ckr_hover_bg.png";
			travelTab.src = "<%=context%>/resources/img/btn/sl_link_bg.png";
			ifr.src = '/CardHolder/jsp/bill.jsp';
		} else if(where ==2){
			billTab.src = "<%=context%>/resources/img/btn/ckr_link_bg.png";
			travelTab.src = "<%=context%>/resources/img/btn/sl_hover_bg.png";
			ifr.src = '/CardHolder/jsp/travel.jsp';
		}else if(where ==3){
			billTab.src = "<%=context%>/resources/img/btn/ckr_link_bg.png";
			travelTab.src = "<%=context%>/resources/img/btn/sl_hover_bg.png";
			ifr.src = '/CardHolder/TravelServlet?cardNum=' + cardNum + "&yearSelect=" + year;
		}
	}	
</script>
</head>
<body>
	<div class="zd_box">
		<div class="zd_title">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="dl_box">
				<tr>
					<td align="left"><a href="/CardHolder/jsp/login.jsp"><img
							src="../resources/img/zy_icon.png" align="absmiddle" />返回首页</a></td>
					<td width="30" align="center"><img
						src="<%=context%>/resources/img/line_bg02.png" /></td>
					<td><a href="/CardHolder/jsp/login.jsp"><img
							src="<%=context%>/resources/img/tc_icon.png" align="absmiddle" />退出</a></td>
				</tr>
			</table>
		</div>
		<div class="zd_main">
			<div class="left_nav">
				<div class="hy_box">
					<strong>欢迎您！</strong>
				</div>
				<ul>
					<li id="billTab" class="hover_bg"><a href="javascript:void(0)"
						target="right" onclick="cssTo(1, 0, 0)"> <img id="ckr"
							src="../resources/img/btn/ckr_hover_bg.png" /></a></li>
					<li id="travelTab"><a href="javascript:void(0)" target="right"
						onclick="cssTo(2, 0, 0)"> <img id="sl"
							src="../resources/img/btn/sl_link_bg.png" /></a></li>
				</ul>
			</div>
			<div class="right_nr">
				<iframe id="right" width="100%" height="100%" src="../jsp/bill.jsp"
					scrolling="no" frameborder="0" name="right"></iframe>
			</div>
		</div>
		<div class="sj_line"></div>
		<div class="sj_footer">中国银联股份有限公司版权所有 © 2002-2013 沪ICP备07032180号</div>
	</div>

	<!--持卡人消费账单弹框-->
	<div id="basic-modal-content" class="tankuang_box01">
		<div class="tc_biaoti" style="width: 525px;">
			<span><a href="javascript:void(0)" onclick="closeModal()"><img
					src="../resources/img/close_btn.gif" /></a></span>消费详情
		</div>
		<div class="tankuang_nr">
			<ul>
				<li>交易名称：<strong id="transNm"></strong></li>
				<li>商户名称：<strong id="mchntNm"></strong></li>
				<li>商户类型：<strong id="mchntTp"></strong></li>
				<li>交易渠道：<strong id="transChnnl"></strong></li>
				<li>交易时间：<strong id="time"></strong></li>
				<li>交易金额：<strong id="sum"></strong></li>
			</ul>
		</div>
		<div class="gb_btn">
			<input type="submit" onclick="closeModal()" value="关闭" />
		</div>
	</div>
	<!--持卡人消费账单弹框-->
	<!--商旅排名弹框01-->
	<div id="tradeType" class="tankuang_box02">
		<div class="tc_biaoti" style="width: 700px;">
			<span><a href="javascript:void(0)" onclick="closeModal()"><img
					src="../resources/img/close_btn.gif" /></a></span>商旅交易分布
		</div>
		<div id="trans" class="fenbutu"></div>
		<div class="gb_btn">
			<input type="submit" onclick="closeModal()" value="关闭" />
		</div>
	</div>
	<!--商旅排名弹框01-->
	<!--商旅交易类型弹框02-->
	<div id="rank" class="tankuang_box03">
		<div class="tc_biaoti" style="width: 700px;">
			<span><a href="javascript:void(0)" onclick="closeModal()"><img
					src="<%=context%>/resources/img/close_btn.gif" /></a></span>排名分布
		</div>
		<div class="pm_box">
			<div class="yh">
				<div class="yh_title">
					<img src="<%=context%>/resources/img/yh_icon.png" align="absbottom" /> 银行排名
				</div>
				<div id="bankRank" class="pie"></div>
			</div>
			<div class="dq">
				<div class="yh_title">
					<img src="<%=context%>/resources/img/dq_icon.png" align="absbottom" /> 地区排名
				</div>
				<div id="areaRank" class="pie"></div>
			</div>
		</div>
		<div class="gb_btn">
			<input type="submit" onclick="closeModal()" value="关闭" />
		</div>
	</div>
	<!--商旅交易类型弹框02-->

	<script type='text/javascript' src='<%=context%>/js/jquery.js'></script>
	<script type='text/javascript' src='<%=context%>/js/jquery.simplemodal.js'></script>
	<script type="text/javascript">

		var transTimes;
		var areaNm ;
		var areaLegend;
		var areaRank;
		var bankNm;
		var bankLegend;
		var bankRank; 
		
		function setTransTimes(times) {
			transTimes = times.split(",");
		}
		
		function setAreaBank(aName, aLegend, aRank, bName, bLegend, bRank) {
			areaNm = aName;
			areaLegend = aLegend.split(",");
			areaRank = setRank(aRank.split(","), areaLegend);
			
			bankNm = bName;
			bankLegend = bLegend.split(",");
			bankRank = setRank(bRank.split(","), bankLegend);
		}
		
		function setRank(value, name) {
			var rank = new Array();
			var obj0 = new Object();
			var obj1 = new Object();
			obj0.value = value[0];
			obj0.name = name[0];
			obj1.value = value[1];
			obj1.name = name[1];
			rank[0] = obj0;
			rank[1] = obj1;
			
			return rank;
		}

		function showDetailsModal() {
			$('#basic-modal-content').modal();
		}
		
		function initConsDetl(transNm, mchntNm, mchntTp, transChnnl, time, sum) {
			document.getElementById("transNm").innerHTML = transNm;
			document.getElementById("mchntNm").innerHTML = mchntNm;
			document.getElementById("mchntTp").innerHTML = mchntTp;
			document.getElementById("transChnnl").innerHTML = transChnnl;
			document.getElementById("time").innerHTML = time;
			document.getElementById("sum").innerHTML = sum;
		}
		
		function showRankModal() {
			config();
			drawAreaRank(areaNm, areaLegend, areaRank);	
			drawBankRank(bankNm, bankLegend, bankRank);
			$('#rank').modal();
		}
		function showTradeModal() {
			config();
			drawTrans(transTimes);
			$('#tradeType').modal();
		}
		function closeModal() {
			$.modal.close();
		}

		function config() {
			require.config({
				paths : {
					echarts : '<%=context%>/js/echarts',    
					'echarts/chart/line' : '<%=context%>/js/echarts',
					'echarts/chart/bar': '<%=context%>/js/echarts',
					'echarts/chart/pie': '<%=context%>/js/echarts'
					}
				});
		}
		
		function drawTrans(transTimes) {
			require([ 'echarts', 'echarts/chart/line', 'echarts/chart/bar' ],
					function(ec) {
						var transChart = ec.init(document.getElementById('trans'));
						var transOption = {
							tooltip : {
								trigger : 'axis'
							},
							toolbox : {
								show : true,
								feature : {
									mark : true,
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : true,
										type : [ 'line', 'bar' ]
									},
									restore : true,
									saveAsImage : true
								}
							},
							calculable : true,
							legend : {
								data : [ '交易次数' ]
							},
							xAxis : [ {
								type : 'category',
								axisLabel : {
									formatter : '{value} 月'
								},
								data : [ '1', '2', '3', '4', '5', '6', '7', '8',
										'9', '10', '11', '12' ]
							} ],
							yAxis : [ {
								type : 'value',
								name : '次数',
								axisLabel : {
									formatter : '{value}'
								},
								splitArea : {
									show : true
								}
							} ],
							series : [ {
								name : '交易次数',
								type : 'bar',
								data : transTimes
							} ]
						};
						transChart.setOption(transOption);
					});
		}

		function drawBankRank(bankNm, bankLegend, bankRank) {
			require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
				var bankRankChart = ec.init(document.getElementById('bankRank'));
				var bankRankOption = {
					title : {
						text : bankNm,
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {d}%"
					},
					toolbox: {
				        show : false,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
					legend : {
						orient : 'horizontal',
						x : 'center',
						y : 'bottom',
						data : bankLegend
					},					
					calculable : true,
					series : [ {
						name : '银行排名',
						type : 'pie',
						radius : '40%',
						center : [ '50%', 140 ],
						data : bankRank
					} ]
				};
				bankRankChart.setOption(bankRankOption);
			});
		}

		function drawAreaRank(areaNm, areaLegend, areaRank) {
			require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
				var areaRankChart = ec.init(document.getElementById('areaRank'));
				var areaRankOption = {
					title : {
						text : areaNm,
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {d}%"
					},
					toolbox: {
				        show : false,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
					legend : {
						orient : 'horizontal',
						x : 'center',
						y : 'bottom',
						data : areaLegend
					},					
					calculable : true,
					series : [ {
						name : '地区排名',
						type : 'pie',
						radius : '40%',
						center : [ '50%', 140 ],
						data : areaRank
					} ]
				};

				areaRankChart.setOption(areaRankOption);
			});
		}
	</script>
</body>
</html>
