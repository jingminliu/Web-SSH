package com.cup.cardholder.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.hbase.client.Result;

import com.cup.cardholder.model.Constant;
import com.cup.cardholder.model.HashMaps;
import com.cup.cardholder.model.TravelModel;
import com.cup.cardholder.service.DateUtil;
import com.cup.cardholder.service.DoubleUtil;
import com.cup.cardholder.service.HBaseService;
import com.cup.cardholder.service.MD5;
import com.cup.cardholder.service.StringUtil;

/**
 * Servlet implementation class TravelServlet
 */
public class TravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TravelServlet() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cardNum = request.getParameter("cardNum");
		String year = request.getParameter("yearSelect");
		String yearSpan = StringUtil.getString("'", DateUtil.getYearSpan(year),
				"'");
		String key;
		String trvlVal;
		String trvlRank;
		String trvlBtNum;
		String trvlTransTimes;
		String trvlTransSum;
		String crossTrvlTimes;
		String htlLvl;
		String htlTimes;
		String htlSum;
		String htlLoyalty;
		String cityNum;
		String provinceNum;
		String crossTimes;
		String crossSum;
		String crossAreaNm;
		String trvlLvlNm;
		String cardLvl;
		String transTimes;
		String areaNm;
		String areaLegend;
		String areaRank;
		String bankNm;
		String bankLegend;
		String bankRank;
		String legendNm;
		int maxTimes;
		String seriesNm;
		String markLineData;
		String markPointData;

		HBaseService hbs = new HBaseService();
		TravelModel model = new TravelModel();
		System.out.println("TravelerServlet: cardNum: " + cardNum);
		cardNum = MD5.GetMD5Code(cardNum);
		System.out.println("TravelerServlet: md5 cardNum: " + cardNum);
		key = cardNum + "," + year;
		System.out.println("TravelerServlet: key: " + key);
		Result res = hbs.get(Constant.TBL_TRAVELER, key, Constant.COLUMNFAMILY);
		model = hbs.getTravelModel(res);
		if (model == null) {
			return;
		}

		cardLvl = model.getCardLvl();
		trvlVal = StringUtil.getString(
				"'",
				DoubleUtil.div(
						StringUtil.string2Double(model.getTrvlScoreVal()), 100)
						+ "", "'");
		trvlRank = StringUtil
				.getString(
						"'",
						DoubleUtil.mul(StringUtil.string2Double(model
								.getTrvlScoreRank()), 100)
								+ "", "%'");
		trvlBtNum = StringUtil.getString("'", model.getTrvlScoreBtNum(), "人'");
		trvlTransTimes = StringUtil.getString("'", model.getTrvlTransTimes(),
				"次'");
		trvlTransSum = StringUtil.getString(
				"'",
				DoubleUtil.div(
						StringUtil.string2Double(model.getTrvlTransSum()), 100)
						+ "", "元'");
		crossTrvlTimes = StringUtil.getString("'",
				model.getCrossTrvlTransTimes(), "次'");
		htlLvl = StringUtil.getString("'", model.getHtlLvlNm(), "'");
		htlTimes = StringUtil.getString("'", model.getHtlTransTimes(), "次'");
		htlSum = StringUtil.getString(
				"'",
				DoubleUtil.div(
						StringUtil.string2Double(model.getHtlTransSum()), 100)
						+ "", "元'");
		htlLoyalty = StringUtil.getString(
				"'",
				DoubleUtil.mul(100,
						StringUtil.string2Double(model.getHtlConcentration()))
						+ "%", "'");
		cityNum = StringUtil.getString("'", model.getTransCityNum(), "个'");
		provinceNum = StringUtil.getString("'", model.getTransProvinceNum(),
				"个'");
		crossTimes = StringUtil
				.getString("'", model.getCrossTransTimes(), "次'");
		crossSum = StringUtil
				.getString(
						"'",
						DoubleUtil.div(StringUtil.string2Double(model
								.getCrossTransSum()), 100)
								+ "", "元'");
		crossAreaNm = StringUtil.getString("'", model.getCrossAreaNm(), "'");
		trvlLvlNm = StringUtil.getString("'", model.getTrvlLvlNm(), "'");
		transTimes = StringUtil.getData(model.getTimesList());
		areaNm = StringUtil.getString("'", model.getResidentAreaNm(), "'");
		areaLegend = StringUtil.getRankLegend(model.getAreaRank());
		areaRank = StringUtil.getRankData(model.getAreaRank());
		bankNm = StringUtil.getString("'", model.getIssBankNm(), "'");
		bankLegend = StringUtil.getRankLegend(model.getBankRank());
		bankRank = StringUtil.getRankData(model.getBankRank());
		legendNm = StringUtil.getString("['", model.getMigrateAreaNmStart(),
				"商旅']");
		seriesNm = StringUtil.getString("'", model.getMigrateAreaNmStart(),
				"商旅'");
		HashMaps map = new HashMaps();
		map.setMigrateHashMap(model.getMigrateRoute());
		maxTimes = map.getMaxTimes(map.getMigrateHashMap());
		System.out.println("TravelServlet: model.getMigrateRoute(): "
				+ model.getMigrateRoute());
		markLineData = StringUtil.getMarkLineData(
				model.getMigrateAreaNmStart(), map.getMigrateHashMap());
		markPointData = StringUtil.getMarkPointData(
				model.getMigrateAreaNmStart(), map.getMigrateHashMap());

		System.out.println("TravelServlet: cardLvl: " + cardLvl);
		System.out.println("TravelServlet: year: " + year);
		System.out.println("TravelServlet: yearSpan: " + yearSpan);
		System.out.println("TravelServlet: trvlVal: " + trvlVal);
		System.out.println("TravelServlet: trvlRank: " + trvlRank);
		System.out.println("TravelServlet: trvlBtNum: " + trvlBtNum);
		System.out.println("TravelServlet: trvlTransTimes: " + trvlTransTimes);
		System.out.println("TravelServlet: trvlTransSum: " + trvlTransSum);
		System.out.println("TravelServlet: crossTrvlTimes: " + crossTrvlTimes);
		System.out.println("TravelServlet: htlLvl: " + htlLvl);
		System.out.println("TravelServlet: htlTimes: " + htlTimes);
		System.out.println("TravelServlet: htlSum: " + htlSum);
		System.out.println("TravelServlet: htlLoyalty: " + htlLoyalty);
		System.out.println("TravelServlet: cityNum: " + cityNum);
		System.out.println("TravelServlet: provinceNum: " + provinceNum);
		System.out.println("TravelServlet: crossTimes: " + crossTimes);
		System.out.println("TravelServlet: crossSum: " + crossSum);
		System.out.println("TravelServlet: crossAreaNm: " + crossAreaNm);
		System.out.println("TravelServlet: trvlLvlNm: " + trvlLvlNm);
		System.out.println("TravelServlet: transTimes: " + transTimes);
		System.out.println("TravelServlet: areaNm: " + areaNm);
		System.out.println("TravelServlet: areaLegend: " + areaLegend);
		System.out.println("TravelServlet: areaRank: " + areaRank);
		System.out.println("TravelServlet: bankNm: " + bankNm);
		System.out.println("TravelServlet: bankLegend: " + bankLegend);
		System.out.println("TravelServlet: bankRank: " + bankRank);
		System.out.println("TravelServlet: legendNm: " + legendNm);
		System.out.println("TravelServlet: maxTimes: " + maxTimes);
		System.out.println("TravelServlet: seriesNm: " + seriesNm);
		System.out.println("TravelServlet: markLineData: " + markLineData);
		System.out.println("TravelServlet: markPointData: " + markPointData);

		request.setAttribute("cardLvl", cardLvl);
		request.setAttribute("yearSpan", yearSpan);
		request.setAttribute("trvlVal", trvlVal);
		request.setAttribute("trvlRank", trvlRank);
		request.setAttribute("trvlBtNum", trvlBtNum);
		request.setAttribute("trvlTransTimes", trvlTransTimes);
		request.setAttribute("trvlTransSum", trvlTransSum);
		request.setAttribute("crossTrvlTimes", crossTrvlTimes);
		request.setAttribute("htlLvl", htlLvl);
		request.setAttribute("htlTimes", htlTimes);
		request.setAttribute("htlSum", htlSum);
		request.setAttribute("htlLoyalty", htlLoyalty);
		request.setAttribute("cityNum", cityNum);
		request.setAttribute("provinceNum", provinceNum);
		request.setAttribute("crossTimes", crossTimes);
		request.setAttribute("crossSum", crossSum);
		request.setAttribute("crossAreaNm", crossAreaNm);
		request.setAttribute("trvlLvlNm", trvlLvlNm);
		request.setAttribute("transTimes", transTimes);
		request.setAttribute("areaNm", areaNm);
		request.setAttribute("areaLegend", areaLegend);
		request.setAttribute("areaRank", areaRank);
		request.setAttribute("bankNm", bankNm);
		request.setAttribute("bankLegend", bankLegend);
		request.setAttribute("bankRank", bankRank);
		request.setAttribute("legendNm", legendNm);
		request.setAttribute("maxTimes", maxTimes);
		request.setAttribute("seriesNm", seriesNm);
		request.setAttribute("markLineData", markLineData);
		request.setAttribute("markPointData", markPointData);

		request.getRequestDispatcher("/jsp/travel.jsp").forward(request,
				response);
	}

}
