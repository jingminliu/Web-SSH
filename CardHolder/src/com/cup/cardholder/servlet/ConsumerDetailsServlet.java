package com.cup.cardholder.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cup.bigtable.scan.api.CardholderTransScan;
import com.cup.bigtable.scan.bean.ReturnField;
import com.cup.cardholder.model.HashMaps;
import com.cup.cardholder.model.TransModel;
import com.cup.cardholder.service.DateUtil;
import com.cup.cardholder.service.DoubleUtil;
import com.cup.cardholder.service.StringUtil;

/**
 * Servlet implementation class ConsumerDetailsServlet
 */
public class ConsumerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsumerDetailsServlet() {
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
		System.out.println("ConsumerDetailsServlet: cardNum:" + cardNum);

		if (cardNum == null) {
			System.out.println("CardNum is null!");
			return;
		}

		String lenCardNum = cardNum.length() + cardNum;
		System.out.println("ConsumerDetailsServlet: lenCardNum:" + lenCardNum);

		String year = request.getParameter("year");
		System.out.println("ConsumerDetailsServlet: year: " + year);

		String month = request.getParameter("monthSelect");
		System.out.println("ConsumerDetailsServlet: month: " + month);

		if (month == null || month == "") {
			System.out.println("Month is null!");
			return;
		}

		String startDate = DateUtil.getStartDate(year, month);
		System.out.println("ConsumerDetailsServlet: startDate: " + startDate);

		String nowDate = DateUtil.getDate();
		System.out.println("ConsumerDetailsServlet: nowDate: " + nowDate);

		if (StringUtil.string2Int(startDate) > StringUtil.string2Int(nowDate)) {
			System.out.println("StartDate is over current date!");
			return;
		}

		String endDate = DateUtil.getEndDate(year, month);
		System.out.println("ConsumerDetailsServlet: endDate: " + endDate);

		List<ReturnField> top10List = new ArrayList<ReturnField>();

		List<String> transNmList = new ArrayList<String>();
		List<String> mchntNmList = new ArrayList<String>();
		List<String> sumList = new ArrayList<String>();
		List<String> timeList = new ArrayList<String>();
		List<String> mchntTpList = new ArrayList<String>();
		List<String> transChnnlList = new ArrayList<String>();

		HashMaps map = new HashMaps();
		Map<String, String> transHashMap = map.getTransHashMap();
		Map<String, String> mccHashMap = map.getMccHashMap();
		Map<String, String> indHashMap = map.getIndHashMap();

		@SuppressWarnings("unchecked")
		List<ReturnField> retList = CardholderTransScan.scanIndexData(
				lenCardNum, startDate, endDate, null, null);

		int length = retList.size();
		if (length > 10) {
			length = 10;
		}

		for (int i = 0; i < length; i++) {
			top10List.add(retList.get(i));
		}

		for (ReturnField ret : top10List) {
			if (ret.getStiTakeoutIn().equals("1")
					&& ret.getCuTransSt().equals("10000")
					&& !ret.getTransId().equalsIgnoreCase("S00")) {
				transNmList.add(transHashMap.get(ret.getTransId()));
				mchntNmList.add(ret.getCardAccptrNmAddr());
				sumList.add(DoubleUtil.div(
						StringUtil.string2Double(ret.getTransAt()), 100)
						+ "");
				timeList.add(StringUtil.getTime(
						ret.getSettleDt().substring(0, 4), ret.getLocTransDt()
								.substring(0, 2), ret.getLocTransDt()
								.substring(2),
						ret.getLocTransTm().substring(0, 2), ret
								.getLocTransTm().substring(2, 4), ret
								.getLocTransTm().substring(4)));
				mchntTpList
						.add(indHashMap.get(mccHashMap.get(ret.getMchntTp())));
				transChnnlList.add(StringUtil.getTransChnnl(StringUtil
						.string2Int(ret.getTransChnl())));
			}
		}

		String transNm = StringUtil.getConsStr(transNmList);
		String mchntNm = StringUtil.getConsStr(mchntNmList);
		String sum = StringUtil.getConsStr(sumList);
		String time = StringUtil.getConsStr(timeList);
		String mchntTp = StringUtil.getConsStr(mchntTpList);
		String transChnnl = StringUtil.getConsStr(transChnnlList);

		System.out.println("ConsumerDetailsServlet: transNm:" + transNm);
		System.out.println("ConsumerDetailsServlet: mchntNm:" + mchntNm);
		System.out.println("ConsumerDetailsServlet: sum:" + sum);
		System.out.println("ConsumerDetailsServlet: time:" + time);
		System.out.println("ConsumerDetailsServlet: mchntTp:" + mchntTp);
		System.out.println("ConsumerDetailsServlet: transChnnl:" + transChnnl);

		request.setAttribute("transNm", transNm);
		request.setAttribute("mchntNm", mchntNm);
		request.setAttribute("sum", sum);
		request.setAttribute("time", time);
		request.setAttribute("mchntTp", mchntTp);
		request.setAttribute("transChnnl", transChnnl);
		request.setAttribute("cardNum", cardNum);
		request.setAttribute("year", year);

		request.getRequestDispatcher("/jsp/consumerDetails.jsp").forward(
				request, response);

	}
}
