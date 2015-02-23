package com.cup.cardholder.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.hbase.client.Result;

import com.cup.cardholder.model.BillModel;
import com.cup.cardholder.model.Constant;
import com.cup.cardholder.model.Industry;
import com.cup.cardholder.model.SortByPct;
import com.cup.cardholder.service.DateUtil;
import com.cup.cardholder.service.DoubleUtil;
import com.cup.cardholder.service.HBaseService;
import com.cup.cardholder.service.MD5;
import com.cup.cardholder.service.StringUtil;

/**
 * Servlet implementation class BillServlet
 */
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cardNum = request.getParameter("cardNum");
		String md5CardNum;
		String year = request.getParameter("yearSelect");
		String yearSpan = StringUtil.getString("'", DateUtil.getYearSpan(year),
				"'");
		String key;
		String bankNm = null;
		String cardNm;
		String cardLvl;
		String cardAttr;
		String consSum;
		String consTimes;
		String sum;
		String times;
		String indLegendData;
		String indSeriesData;
		String chnlData;
		String areaNm;
		String areaRank;
		String areaRankCity;
		String areaRankPct;
		double overAreaRank;
		String fstMchntNm;
		String fstMcc;
		String fstSum;
		String scdMchntNm;
		String scdMcc;
		String scdSum;
		String thrdMchntNm;
		String thrdMcc;
		String thrdSum;
		String workDayWorkHrsTimes;
		String workDayNonWorkHrsTimes;
		String workDayMidnightTimes;
		String nonWorkDayNormHrsTimes;
		String nonWorkDayMidnightTimes;

		String maxTimes;
		int maxIndex;

		List<String> sumList = new ArrayList<String>();
		List<String> timesList = new ArrayList<String>();
		List<Industry> indList = new ArrayList<Industry>();
		List<Industry> top10Ind = new ArrayList<Industry>();
		List<Industry> chnlList = new ArrayList<Industry>();

		HBaseService hbs = new HBaseService();
		BillModel model = new BillModel();
		System.out.println("BillServlet: cardNum:" + cardNum);
		//md5CardNum = cardNum;
	    md5CardNum = MD5.GetMD5Code(cardNum);
		System.out.println("BillServlet: after md5 cardNum:" + md5CardNum);
		key = md5CardNum + "," + year;
		System.out.println("BillServlet: key:" + key);
		Result res = hbs.get(Constant.TBL_CARDHOLDER, key,
				Constant.COLUMNFAMILY);
		model = hbs.setBillModel(res);

		if (model == null) {
			return;
		}

		cardLvl = model.getCardLvl();
		cardAttr = model.getCardAttr();
		if (model.getBankNm() != null) {
			bankNm = StringUtil.getString(
					"'",
					model.getBankNm().substring(0,
							model.getBankNm().length() - 2), "'");
		}
		cardNm = StringUtil.getString("'", StringUtil.getCardLvlNm(StringUtil
				.string2Int(model.getCardLvl())), "'");
		consSum = DoubleUtil.div(StringUtil.string2Double(model.getSum()), 100)
				+ "";
		consTimes = model.getTimes();
		sumList = model.getSumList();
		timesList = model.getTimesList();
		sum = StringUtil.getData(sumList);
		times = StringUtil.getData(timesList);
		indList = model.getIndList();
		Collections.sort(indList, new SortByPct());
		for (Industry ind : indList) {
			System.out.println("BillServlet: indList: " + ind.getName() + " : "
					+ ind.getPct());
		}
		top10Ind = model.getTop10Ind(indList);
		for (Industry ind : top10Ind) {
			System.out.println("BillServlet: top10Ind: " + ind.getName()
					+ " : " + ind.getPct());
		}
		indLegendData = StringUtil.getLegendData(top10Ind);
		indSeriesData = StringUtil.getSeriesData(top10Ind);
		chnlList = model.getChnlList();
		chnlData = StringUtil.getSeriesData(chnlList);
		areaNm = model.getRsdntAreaNm();
		areaRank = model.getAreaRank();
		overAreaRank = DoubleUtil.sub(1, StringUtil.string2Double(areaRank));
		areaRankCity = StringUtil.getString("'", areaNm, "'");
		areaRankPct = StringUtil.getString("'",
				DoubleUtil.mul(100, overAreaRank) + "%", "'");
		fstMchntNm = StringUtil.getString("'", model.getFstMchntNm(), "'");
		fstMcc = StringUtil.getString("'", model.getFstMcc(), "'");
		fstSum = StringUtil
				.getString(
						"'",
						DoubleUtil.div(
								StringUtil.string2Double(model.getFstSum()),
								100) + "", "'");
		scdMchntNm = StringUtil.getString("'", model.getScdMchntNm(), "'");
		scdMcc = StringUtil.getString("'", model.getScdMcc(), "'");
		scdSum = StringUtil
				.getString(
						"'",
						DoubleUtil.div(
								StringUtil.string2Double(model.getScdSum()),
								100) + "", "'");
		thrdMchntNm = StringUtil.getString("'", model.getThrdMchntNm(), "'");
		thrdMcc = StringUtil.getString("'", model.getThrdMcc(), "'");
		thrdSum = StringUtil.getString(
				"'",
				DoubleUtil.div(StringUtil.string2Double(model.getThrdSum()),
						100) + "", "'");
		workDayWorkHrsTimes = StringUtil.getString("'消费",
				model.getWorkDayWorkHrsTimes(), "笔'");
		workDayNonWorkHrsTimes = StringUtil.getString("'消费",
				model.getWorkDayNonWorkHrsTimes(), "笔'");
		workDayMidnightTimes = StringUtil.getString("'消费",
				model.getWorkDayMidnightTimes(), "笔'");
		nonWorkDayNormHrsTimes = StringUtil.getString("'消费",
				model.getNonWorkDayNormHrsTimes(), "笔'");
		nonWorkDayMidnightTimes = StringUtil.getString("'消费",
				model.getNonWorkDayMidnightTimes(), "笔'");
		maxTimes = StringUtil.getString("'消费最多:", model.getMaxTimes() + "",
				"笔'");
		maxIndex = model.getMaxIndex();

		System.out.println("BillServlet: cardLvl: " + cardLvl);
		System.out.println("BillServlet: cardAttr: " + cardAttr);
		System.out.println("BillServlet: year: " + year);
		System.out.println("BillServlet: yearSpan: " + yearSpan);
		System.out.println("BillServlet: bankNm: " + bankNm);
		System.out.println("BillServlet: cardNm: " + cardNm);
		System.out.println("BillServlet: consSum: " + consSum);
		System.out.println("BillServlet: consTimes: " + consTimes);
		System.out.println("BillServlet: sum: " + sum);
		System.out.println("BillServlet: times: " + times);
		System.out.println("BillServlet: indLegendData: " + indLegendData);
		System.out.println("BillServlet: indSeriesData: " + indSeriesData);
		System.out.println("BillServlet: chnlData: " + chnlData);
		System.out.println("BillServlet: overAreaRank: " + overAreaRank);
		System.out.println("BillServlet: areaRankCity: " + areaRankCity);
		System.out.println("BillServlet: areaRankPct: " + areaRankPct);
		System.out.println("BillServlet: fstMchntNm: " + fstMchntNm);
		System.out.println("BillServlet: fstMcc: " + fstMcc);
		System.out.println("BillServlet: fstSum: " + fstSum);
		System.out.println("BillServlet: scdMchntNm: " + scdMchntNm);
		System.out.println("BillServlet: scdMcc: " + scdMcc);
		System.out.println("BillServlet: scdSum: " + scdSum);
		System.out.println("BillServlet: thrdMchntNm: " + thrdMchntNm);
		System.out.println("BillServlet: thrdMcc: " + thrdMcc);
		System.out.println("BillServlet: thrdSum: " + thrdSum);
		System.out.println("BillServlet: workDayWorkHrsTimes: "
				+ workDayWorkHrsTimes);
		System.out.println("BillServlet: workDayNonWorkHrsTimes: "
				+ workDayNonWorkHrsTimes);
		System.out.println("BillServlet: workDayMidnightTimes: "
				+ workDayMidnightTimes);
		System.out.println("BillServlet: nonWorkDayNormHrsTimes: "
				+ nonWorkDayNormHrsTimes);
		System.out.println("BillServlet: nonWorkDayMidnightTimes: "
				+ nonWorkDayMidnightTimes);
		System.out.println("BillServlet: maxTimes: " + maxTimes);
		System.out.println("BillServlet: maxIndex: " + maxIndex);

		request.setAttribute("cardLvl", cardLvl);
		request.setAttribute("cardAttr", cardAttr);
		request.setAttribute("yearSpan", yearSpan);
		request.setAttribute("bankNm", bankNm);
		request.setAttribute("cardNm", cardNm);
		request.setAttribute("consSum", consSum);
		request.setAttribute("consTimes", consTimes);
		request.setAttribute("sum", sum);
		request.setAttribute("times", times);
		request.setAttribute("indLegendData", indLegendData);
		request.setAttribute("indSeriesData", indSeriesData);
		request.setAttribute("chnlData", chnlData);
		request.setAttribute("overAreaRank", overAreaRank);
		request.setAttribute("areaRankCity", areaRankCity);
		request.setAttribute("areaRankPct", areaRankPct);
		request.setAttribute("fstMchntNm", fstMchntNm);
		request.setAttribute("fstMcc", fstMcc);
		request.setAttribute("fstSum", fstSum);
		request.setAttribute("scdMchntNm", scdMchntNm);
		request.setAttribute("scdMcc", scdMcc);
		request.setAttribute("scdSum", scdSum);
		request.setAttribute("thrdMchntNm", thrdMchntNm);
		request.setAttribute("thrdMcc", thrdMcc);
		request.setAttribute("thrdSum", thrdSum);
		request.setAttribute("workDayWorkHrsTimes", workDayWorkHrsTimes);
		request.setAttribute("workDayNonWorkHrsTimes", workDayNonWorkHrsTimes);
		request.setAttribute("workDayMidnightTimes", workDayMidnightTimes);
		request.setAttribute("nonWorkDayNormHrsTimes", nonWorkDayNormHrsTimes);
		request.setAttribute("nonWorkDayMidnightTimes", nonWorkDayMidnightTimes);
		request.setAttribute("maxTimes", maxTimes);
		request.setAttribute("maxIndex", maxIndex);
		request.setAttribute("cardNum", cardNum);
		request.setAttribute("year", year);

		request.getRequestDispatcher("/jsp/bill.jsp")
				.forward(request, response);
	}
}
