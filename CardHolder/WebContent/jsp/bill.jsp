<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>持卡人账单</title>
<%String context = request.getContextPath();%>
<%@page import="com.cup.cardholder.service.CardNum"%>
<%@page import="com.get.card.num.GetBankCardNum"%>
<link href="<%=context%>/resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=context%>/js/esl.js"></script>
<script type="text/javascript" src="<%=context%>/js/jquery.js"></script>
<script type="text/javascript">
var sum = <%=request.getAttribute("sum")%>;
var times = <%=request.getAttribute("times")%>;
var indLegendData = <%=request.getAttribute("indLegendData")%>;
var indSeriesData = <%=request.getAttribute("indSeriesData")%>;
var chnlData = <%=request.getAttribute("chnlData")%>; 
var overAreaRank = <%=request.getAttribute("overAreaRank")%>; 
var fstMcc = <%=request.getAttribute("fstMcc")%>;
var scdMcc = <%=request.getAttribute("scdMcc")%>;
var thrdMcc = <%=request.getAttribute("thrdMcc")%>;
var maxTimes = <%=request.getAttribute("maxTimes")%>;
var maxIndex = <%=request.getAttribute("maxIndex")%>;
var cardLvl = <%=request.getAttribute("cardLvl")%>;
var cardNum = <%=request.getAttribute("cardNum")%>;
var year = <%=request.getAttribute("year")%>;
var num;

function config() {
	require.config({
		paths : {
			echarts: '<%=context%>/js/echarts',    
			'echarts/chart/line' : '<%=context%>/js/echarts',
			'echarts/chart/bar': '<%=context%>/js/echarts',
			'echarts/chart/pie': '<%=context%>/js/echarts'
			}
		});
}

function drawTrans(sum, times) {
	require([ 'echarts', 'echarts/chart/line', 'echarts/chart/bar' ], function(ec) {
		var transChart = ec.init(document.getElementById('trans'));
		transOption = {
			    tooltip : {
			        trigger: 'axis'
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : true,
			            dataView : {readOnly: false},
			            magicType:['line', 'bar'],
			            restore : true,
			            saveAsImage : true
			        }
			    },
			    calculable : true,
			    legend: {
			        data:['交易金额','交易次数']
			    },
			    xAxis : [
			        {
			            type : 'category',
			            axisLabel : {
			                formatter: '{value} 月'
			            },
			            data : ['1','2','3','4','5','6','7','8','9','10','11','12']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            name : '金额',
			            axisLabel : {
			                formatter: '{value} 元'
			            },
			            splitArea : {show : true}
			        },
			        {
			            type : 'value',
			            name : '次数',
			            axisLabel : {
			                formatter: '{value}'
			            },
			            splitLine : {show : false}
			        }
			    ],
			    series : [
			        {
			            name:'交易金额',
			            type:'bar',
			            data:sum
			        },
			        {
			            name:'交易次数',
			            type:'line',
			            yAxisIndex: 1,
			            data:times
			        }
			    ]
			};
		transChart.setOption(transOption);
	});
}

function drawConsType(indLegendData, indSeriesData) {
	require([ 'echarts', 'echarts/chart/pie'], function(ec) {
		var consTypeChart = ec.init(document.getElementById('consType'));
		var consTypeOption = {
			    title : {
			        //text: '各消费类别占比分析'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {d}%"
			    },
			    legend: {
			        orient : 'vertical',
			        x : 'left',
			        y :'center',
			        data:indLegendData
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
			    calculable : true,
			    series : [
			        	{
				            name:'消费类别',
				            type:'pie',
				            radius : '40%',
				            center: ['62%', 185],
				            data:indSeriesData
			        	}
			    	]
				};
		        consTypeChart.setOption(consTypeOption);
	});
}


function drawConsChnl(chnlData) {
	require([ 'echarts', 'echarts/chart/pie'], function(ec) {
	var consChnlChart = ec.init(document.getElementById('consChannel'));
	var consChnlOption = {
		    title : {
		        //text: '各消费渠道占比分析'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {d}%"
		    },
		    legend: {
		        orient : 'vertical',
		        x : 'left',
		        y :'center',
		        data:['POS','ATM','在线','柜台','手机','其他']
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
		    calculable : false,
		    series : [
		        {
		            name:'消费渠道',
		            type:'pie',
			        center: ['55%', 175],
		            radius : [33, 66],
		            data:chnlData
		        }
		    ]
			};
	        consChnlChart.setOption(consChnlOption);
	    });
}

function draw() {
	config();
	drawTrans(sum, times);
	drawConsType(indLegendData, indSeriesData);
	drawConsChnl(chnlData);
}

function init() {
	document.getElementById("yearSpan").innerHTML = <%=request.getAttribute("yearSpan")%>;
	document.getElementById("bankNm").innerHTML = <%=request.getAttribute("bankNm")%>;	
	document.getElementById("cardNm").innerHTML = <%=request.getAttribute("cardNm")%>;	
	document.getElementById("consSum").innerHTML = <%=request.getAttribute("consSum")%>; 
	document.getElementById("consTimes").innerHTML = <%=request.getAttribute("consTimes")%>;  
	document.getElementById("areaRankCity").innerHTML = <%=request.getAttribute("areaRankCity")%>; 
	document.getElementById("areaRankPct").innerHTML = <%=request.getAttribute("areaRankPct")%>; 
	
	if(<%=request.getAttribute("fstMchntNm")%> != "-2") {
		document.getElementById("fstMchntNm").innerHTML = <%=request.getAttribute("fstMchntNm")%>;
		document.getElementById("fstSum").innerHTML = <%=request.getAttribute("fstSum")%>;
	}
	
	if(<%=request.getAttribute("scdMchntNm")%> != "-2") {
		document.getElementById("scdMchntNm").innerHTML = <%=request.getAttribute("scdMchntNm")%>;
		document.getElementById("scdSum").innerHTML = <%=request.getAttribute("scdSum")%>;
	}
	
	if(<%=request.getAttribute("thrdMchntNm")%> != "-2") {
		document.getElementById("thrdMchntNm").innerHTML = <%=request.getAttribute("thrdMchntNm")%>;
		document.getElementById("thrdSum").innerHTML = <%=request.getAttribute("thrdSum")%>;
	}
	
	setCardImg();
	setMchntImg("fstMchntImg", fstMcc);
	setMchntImg("scdMchntImg", scdMcc);
	setMchntImg("thrdMchntImg", thrdMcc);
	setRankImg();
	for(var i=0; i<5; i++) {
		setConsTimes(i);
	}
}

function load() {
		servletFlag = "0";
		
		if(cardLvl=="null" || cardLvl==null) {
			hidden();
		} else {
			init();
 			show();
			draw(); 
		}
}

function hidden() {
	document.getElementById("zhangdan_box").style.display = "none";   
}

function show() {
	document.getElementById("zhangdan_box").style.display = "block"; 
	
	if(<%=request.getAttribute("cardAttr")%> == "02") {
		document.getElementById("consTag").style.display = "block"; 
	}
	
	if(<%=request.getAttribute("fstMchntNm")%> == "-2") {
		document.getElementById("fstCons").style.display = "none"; 
	}
	if(<%=request.getAttribute("scdMchntNm")%> == "-2") {
		document.getElementById("scdCons").style.display = "none"; 
	}
	if(<%=request.getAttribute("thrdMchntNm")%> == "-2") {
		document.getElementById("thrdCons").style.display = "none"; 
	}
}

function setCardImg() {
	switch (cardLvl) {
	case 0:
	case 1:
	case 2:
		document.images.cardImg.src = "<%=context%>/resources/img/card/pk_bill.png";
		break;
	case 3:
		document.images.cardImg.src = "<%=context%>/resources/img/card/jk_bill.png";
		break;
	case 4:
		document.images.cardImg.src = "<%=context%>/resources/img/card/bj_bill.png";
		break;
	case 5:		
	case 6:
		document.images.cardImg.src = "<%=context%>/resources/img/card/zs_bill.png";
		break;
	}
}

function setMchntImg(id, mcc) {
	if(mcc == "SC") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/sc_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/sc_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/sc_img.png";
		}
	} else if (mcc == "ZS") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/zs_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/zs_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/zs_img.png";
		}
	} else if (mcc == "CY") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/cy_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/cy_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/cy_img.png";
		}
	} else if (mcc == "YJ") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/yj_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/yj_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/yj_img.png";
		}
	} else if (mcc == "SDM") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/sdm_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/sdm_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/sdm_img.png";
		}
	} else if (mcc == "RB") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/rb_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/rb_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/rb_img.png";
		}
	} else if (mcc == "RFB") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/rfb_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/rfb_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/rfb_img.png";
		}
	} else if (mcc == "LSC") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/lsc_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/lsc_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/lsc_img.png";
		}
	} else if (mcc == "FC") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/fc_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/fc_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/fc_img.png";
		}
	} else if (mcc == "QC") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/qc_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/qc_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/qc_img.png";
		}
	} else if (mcc == "FZ") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/fz_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/fz_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/fz_img.png";
		}
	} else if (mcc == "YL") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/yl_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/yl_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/yl_img.png";
		}
	} else if (mcc == "BYL") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/byl_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/byl_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/byl_img.png";
		}
	} else if (mcc == "XQ") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/xq_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/xq_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/xq_img.png";
		}
	} else if (mcc == "ZXX") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/zxx_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/zxx_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/zxx_img.png";
		}
	} else if (mcc == "DX") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/dx_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/dx_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/dx_img.png";
		}
	} else if (mcc == "NX") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/nx_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/nx_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/nx_img.png";
		}
	} else if (mcc == "MR") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/mr_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/mr_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/mr_img.png";
		}
	} else if (mcc == "GYD") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/gyd_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/gyd_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/gyd_img.png";
		}
	} else if (mcc == "DYD") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/dyd_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/dyd_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/dyd_img.png";
		}
	} else if (mcc == "WH") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/wh_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/wh_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/wh_img.png";
		}
	} else if (mcc == "XY") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/xy_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/xy_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/xy_img.png";
		}
	} else if (mcc == "LY") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/ly_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/ly_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/ly_img.png";
		}
	} else if (mcc == "JT") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/jt_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/jt_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/jt_img.png";
		}
	} else if (mcc == "MSD") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/msd_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/msd_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/msd_img.png";
		}
	} else if (mcc == "CG") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/cg_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/cg_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/cg_img.png";
		}
	} else if (mcc == "XJ") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/xj_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/xj_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/xj_img.png";
		}
	} else if (mcc == "JR") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/jr_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/jr_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/jr_img.png";
		}
	} else if (mcc == "XX") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/xx_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/xx_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/xx_img.png";
		}
	} else if (mcc == "SY") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/sy_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/sy_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/sy_img.png";
		}
	} else if (mcc == "ZF") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/zf_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/zf_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/zf_img.png";
		}
	} else if (mcc == "PF") {
		if(id == "fstMchntImg") {
			document.images.fstMchntImg.src = "<%=context%>/resources/img/xf_img/pf_img.png";
		} else if(id == "scdMchntImg") {
			document.images.scdMchntImg.src = "<%=context%>/resources/img/xf_img/pf_img.png";
		} else if(id == "thrdMchntImg") {
			document.images.thrdMchntImg.src = "<%=context%>/resources/img/xf_img/pf_img.png";
		}
	} 
}

function setRankImg() {
	if(overAreaRank >= 14/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_15.png";
	}else if(overAreaRank >= 13/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_14.png";
	}else if(overAreaRank >= 12/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_13.png";
	}else if(overAreaRank >= 11/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_12.png";
	}else if(overAreaRank >= 10/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_11.png";
	}else if(overAreaRank >= 9/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_10.png";
	}else if(overAreaRank >= 8/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_09.png";
	}else if(overAreaRank >= 7/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_08.png";
	}else if(overAreaRank >= 6/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_07.png";
	}else if(overAreaRank >= 5/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_06.png";
	}else if(overAreaRank >= 4/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_05.png";
	}else if(overAreaRank >= 3/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_04.png";
	}else if(overAreaRank >= 2/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_03.png";
	}else if(overAreaRank >= 1/15) {
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_02.png";
	}else{
		document.images.rankImg.src = "<%=context%>/resources/img/rank_img/img_01.png";
	}
}

function setConsTimes(id) {
	switch (id) {
	case 0:
	{
		if(maxIndex == 0) {
			document.images.consTimesImg0.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_hover_0.png"; 
			document.getElementById("consTimes0").innerHTML = maxTimes;
		} else {
			document.images.consTimesImg0.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_0.png"; 
			document.getElementById("consTimes0").innerHTML = <%=request.getAttribute("workDayWorkHrsTimes")%>; 
		}
		break;
	}
	case 1: 
	{
		if(maxIndex == 1) {
			document.images.consTimesImg1.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_hover_1.png"; 
			document.getElementById("consTimes1").innerHTML = maxTimes;
		} else {
			document.images.consTimesImg1.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_1.png"; 
			document.getElementById("consTimes1").innerHTML = <%=request.getAttribute("workDayNonWorkHrsTimes")%>;
		}
		break;
	}
	case 2: 
	{
		if(maxIndex == 2) {
			document.images.consTimesImg2.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_hover_2.png"; 
			document.getElementById("consTimes2").innerHTML = maxTimes;
		} else {
			document.images.consTimesImg2.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_2.png"; 
			document.getElementById("consTimes2").innerHTML = <%=request.getAttribute("workDayMidnightTimes")%>;
		}
		break;
	}
	case 3:
	{
		if(maxIndex == 3) {
			document.images.consTimesImg3.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_hover_3.png"; 
			document.getElementById("consTimes3").innerHTML = maxTimes; 
		} else {
			document.images.consTimesImg3.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_3.png"; 
			document.getElementById("consTimes3").innerHTML = <%=request.getAttribute("nonWorkDayNormHrsTimes")%>;
		}
		break;
	}
	case 4:
	{
		if(maxIndex == 4) {
			document.images.consTimesImg4.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_hover_4.png"; 
			document.getElementById("consTimes4").innerHTML = maxTimes;
		} else {
			document.images.consTimesImg4.src = "<%=context%>/resources/img/xf_sj_img/xf_sd_img_4.png"; 
			document.getElementById("consTimes4").innerHTML = <%=request.getAttribute("nonWorkDayMidnightTimes")%>;
		}
		break;
	}
	}
}

$(document).ready(function(){
	  $("#cardNum").click(function(){
		  getCardNum();
	  });
	});
	
function getCardNum(){
	$.ajax({
		type: "post",
		url : "/CardHolder/CardNum",
		//method:"getCardNum",
		success: function(json){
			//alert(json);
			if(json==00) {
				$('#cardNum').val(""); 
				alert("没有检测到IC银行卡，请插卡或输入银行卡号！");
			} else if(json==01) {
				alert("此IC银行卡为非标准IC银行卡!");
			} else {
				$('#cardNum').val(json); 
			}
			
		},
		error: function (msg) {
			$('#cardNum').val(""); 
            alert("请插卡或输入银行卡号");
        }
	})
}; 
	
<%-- function readCardNum(){
	//window.location.reload();
	alert(111);
	num = "<%=CardNum.getCardNum()%>"; 
	alert("num: " + num);
	if(!(num == "00" || num == "01")) {
		document.getElementById("cardNum").value = num;
		num="";
		alert(2);
	} else {
		document.getElementById("cardNum").value = "";
		num="";
		alert(3);
	}
}

function resetText() {
	document.getElementById("cardNum").value = "请插卡或输入银行卡号";
} --%>

function jumpToTrvl() {
	parent.parent.cssTo(3,cardNum,year);
}

function jumpToCons(){
	parent.parent.setYear(year);
	parent.parent.setCardNum(cardNum);
	parent.parent.document.getElementById("right").src='<%=context%>/jsp/consumerDetails.jsp';
}

function check() {
	var inNum = new Array();
	var outNum = new Array();
	var checkNum;
	var sum = 0;
	var result;
	var str = document.getElementsByName("cardNum")[0].value;
	//alert("str = " + str);

	for ( var i = 0; i < str.length; i++) {
		inNum[i] = parseInt(str.charAt(i));
	}
	//alert("inNum before reverse: " + inNum);
	inNum.reverse();
	//alert("inNum after reverse: " + inNum);
	checkNum = inNum[0];
	//alert("checkNum: " + checkNum);

	// 除校验位外，从第一位开始，每隔一位乘以2
	for ( var i = 1; i < str.length; i++) {
		if (i % 2 == 1) {
			outNum[i] = inNum[i] * 2;
			if (outNum[i] > 9) {
				// 个位与十位相加
				outNum[i] = outNum[i] - 9;
			}
		} else {
			outNum[i] = inNum[i];
		}

		sum = sum + outNum[i];
	}

	result = Math.ceil(sum / 10) * 10 - sum;
	//alert("result: " + result);

	if (result == checkNum) {
		return true;
	} else {
		alert("请输入正确的银行卡号！");
		window.location.reload();
		return false;
	}
}
</script>

</head>

<body onload="load()" style="background: none">
	<form name="myform" method="post" action="/CardHolder/BillServlet" onsubmit="return check()">
		<div class="qj_box">
			<div class="search_box">
				<!--搜索开始-->
				<select id="yearSelect" name="yearSelect" class="sl">
					<option value="2012">2012</option>
					<option value="2013" selected>2013</option>
					<option value="2014">2014</option>
				</select> 
				<input name="cardNum" id="cardNum" type="text" value="请插卡或输入银行卡号" />
				<input name="submit" type="submit" value="查询" />
			</div>
			<!--搜索结束-->
			<div id="zhangdan_box" class="zhangdan_box" style="display:none">
				<div class="zhangdan_title">
					<strong>电子对账单</strong><span id="yearSpan"></span>
				</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="zhangdan_nr01">
					<tr>
						<td width="24%" rowspan="3" class="toux_img"><img
							src="<%=context%>/resources/img/tx_img.png" width="148" height="98" /></td>
						<td colspan="2" class="font_01">您持有的银行卡为 >> <strong id="bankNm"></strong><span>银行</span><strong id="cardNm"></strong></td>
					</tr>
					<tr>
						<td width="17%" rowspan="2"><img id="cardImg" src="" width="113" height="73" /></td>
						<td class="font_02">年度消费支出<strong id="consSum"></strong>元，共消费<strong id="consTimes"></strong>笔</td>
					</tr>
					<tr>
						<td><input type="button" value="消费明细查询"
							onclick="jumpToCons()" /></td>
					</tr>
				</table>
				<div class="zhangdan_zs">
					<div class="zhangdan_title02"></div>
					<h1>最近一年我的消费走势</h1>
					<div id="trans" style="height: 300px; width: 830px; padding: 0px;"></div>
				</div>
				<div class="zhangdan_nr02">
					<div class="zhangdan_title02"></div>
					<div class="nr02_left01">
						<!--各消费类别占比分析开始-->
						<h1>各消费类别占比分析</h1>
						<div id="consType"
							style="height: 300px; width: 400px; padding: 0px; float: left;"></div>
					</div>
					<div class="line_bg02"></div>
					<div class="nr02_right01">
						<!--各消费渠道占比分析开始-->
						<h1>各消费渠道占比分析</h1>
						<div id="consChannel"
							style="height: 300px; width: 400px; padding: 10px; float: right;"></div>
					</div>
					<!--各消费渠道占比分析结束-->
					<div class="line_bg01"></div>
					<div class="nr02_left01">
						<!--我在这里消费最多开始-->
						<h1>我在这里消费最多</h1>
						<div class="tubiao_01">
							<div class="xiaofei">
								<div class="xiaofei_nr">
									<div id="scdCons" class="xiaofei_nr_left">
										<p id="scdMchntNm"></p>
										<p id="scdSum" class="jine_font"></p>
										<img id="scdMchntImg" src="" />
									</div>
									<div id="fstCons" class="xiaofei_nr_center">									
										<p id="fstMchntNm"></p>
										<p id="fstSum" class="jine_font"></p>
										<img id="fstMchntImg" src="" />
									</div>
									<div id="thrdCons" class="xiaofei_nr_right">
										<p id="thrdMchntNm"></p>
										<p id="thrdSum" class="jine_font"></p>
										<img id="thrdMchntImg" src="" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--我在这里消费最多结束-->
					<div class="line_bg02"></div>
					<div class="nr02_right01">
						<!--我的排名信息开始-->
						<h1>我的排名信息</h1>
						<div class="tubiao_02">
							<p class="pm_font">在<strong id="areaRankCity"></strong>的排名超过<b id="areaRankPct"></b>的人</p>
							<div class="img_rx">
								<img id="rankImg" src="" />
							</div>
						</div>
					</div>
					<!--我的排名信息结束-->
					<div class="line_bg01"></div>
				</div>
				<div class="shijian_fx">
					<!--我的消费时间分析开始-->
					<div class="zhangdan_title02"></div>
					<h1>我的消费时间分析</h1>
					<div class="yh">
						<ul>
							<li><img id="consTimesImg0" src="" />
								<p id="consTimes0"></p></li>
							<li><img id="consTimesImg1" src="" />
								<p id="consTimes1"></p></li>
							<li><img id="consTimesImg2" src="" />
								<p id="consTimes2"></p></li>
							<li><img id="consTimesImg3" src="" />
								<p id="consTimes3"></p></li>
							<li><img id="consTimesImg4" src="" />
								<p id="consTimes4"></p></li>
						</ul>
					</div>
				</div>
				<!--我的消费时间分析结束-->
				<div id="consTag" class="shijian_fx" style="display:none">
					<!--我的消费标签开始-->
					<div class="zhangdan_title02"></div>
					<h1>我的消费标签</h1>
					<dl>
						<dt>
							<a href="#"><img src="<%=context%>/resources/img/sl_img.png" onclick="jumpToTrvl()"/></a>
						</dt>
						<dd>
							<a href="#">商旅</a>
						</dd>
					</dl>
				</div>
				<!--我的消费标签结束-->
				<div class="shijian_fx">
					<div class="zhangdan_title02"></div>
					<h1>银联推荐</h1>
					<p style="font-size:10px">&nbsp;&nbsp;&nbsp;&nbsp;敬请期待...</p>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
