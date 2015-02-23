package com.cup.cardholder.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cup.cardholder.model.Industry;
import com.cup.cardholder.model.TransModel;

public class StringUtil {
	public static String getBankCard(String bankNm, int cardLvl) {
		StringBuffer sb = new StringBuffer();
		String cardLvlNm = getCardLvlNm(cardLvl);
		sb.append("'").append(bankNm).append(cardLvlNm).append("'");

		return sb.toString();
	}

	/*public static String getConsInfo(String sum, String times) {
		StringBuffer sb = new StringBuffer();
		sb.append("'年度消费支出").append(sum).append("元，共消费").append(times)
				.append("笔'");

		return sb.toString();
	}*/

	public static String getCardLvlNm(int cardLvl) {
		String cardLvlNm = null;
		switch (cardLvl) {
		case 0:
			cardLvlNm = "";
			break;
		case 1:
			cardLvlNm = "普卡";
			break;
		case 2:
			cardLvlNm = "银卡";
			break;
		case 3:
			cardLvlNm = "金卡";
			break;
		case 4:
			cardLvlNm = "白金卡";
			break;
		case 5:
			cardLvlNm = "钻石卡";
			break;
		case 6:
			cardLvlNm = "无限卡";
			break;
		default:
			cardLvlNm = "";
		}

		return cardLvlNm;
	}

	public static String getTransChnnl(int transChnnl) {
		String transChnnlNm = null;
		switch (transChnnl) {
		case 1:
			transChnnlNm = "ATM";
			break;
		case 3:
		case 11:
			transChnnlNm = "POS";
			break;
		case 6:
			transChnnlNm = "柜台";
			break;
		case 7:
			transChnnlNm = "在线";
			break;
		case 8:
			transChnnlNm = "手机";
			break;
		default:
			transChnnlNm = "其他";
		}

		return transChnnlNm;
	}

	public static int string2Int(String str) {
		int out = 0;
		if (str != null && !str.equals("") && !str.contains(".")) {
			out = Integer.parseInt(str);
		}
		return out;
	}

	public static double string2Double(String str) {
		double out = 0;
		if (str != null && !str.equals("")) {
			out = Double.parseDouble(str);
		}
		return out;
	}

	public static String getLegendData(List<Industry> indList) {
		StringBuffer sb = new StringBuffer();
		int length = indList.size();
		sb.append("['");
		for (int i = 0; i < length; i++) {
			sb.append(indList.get(i).getName()).append("','");
		}
		sb.append("非前10名行业").append("']");

		return sb.toString();
	}

	public static String getSeriesData(List<Industry> indList) {
		StringBuffer sb = new StringBuffer();
		int length = indList.size();
		sb.append("[{value:");
		for (int i = 0; i < length; i++) {
			sb.append(indList.get(i).getPct()).append(", name:'")
					.append(indList.get(i).getName()).append("'},{value:");
		}
		sb.append(DoubleUtil.sub(1, getPctSum(indList))).append(
				", name:'非前10名行业'}]");

		return sb.toString();
	}

	public static String getData(List<String> list) {
		StringBuffer sb = new StringBuffer();
		int length = list.size();
		sb.append("[");
		int i = 0;
		for (; i < length - 1; i++) {
			sb.append(list.get(i)).append(",");
		}
		sb.append(list.get(length - 1)).append("]");

		return sb.toString();
	}

	public static String getAreaRankInfo(String areaNm, String areaRank) {
		String oAreaRank = DoubleUtil.mul(100,
				DoubleUtil.sub(1, StringUtil.string2Double(areaRank)))
				+ "%";
		StringBuffer sb = new StringBuffer();
		sb.append("'在").append(areaNm).append("的排名超过").append(oAreaRank)
				.append("的人'");

		return sb.toString();
	}

	public static String getString(String arg0, String arg1, String arg2) {
		StringBuffer sb = new StringBuffer();
		sb.append(arg0).append(arg1).append(arg2);

		return sb.toString();
	}

	public static String getRankLegend(String rank) {

		StringBuffer sb = new StringBuffer();
		sb.append("['超越")
				.append(DoubleUtil.mul(100,
						DoubleUtil.sub(1, string2Double(rank)))
						+ "%").append("','未超越")
				.append(DoubleUtil.mul(100, string2Double(rank)) + "%")
				.append("']");

		return sb.toString();
	}

	public static String getRankData(String rank) {

		StringBuffer sb = new StringBuffer();
		/*
		 * sb.append("[{value:") .append(DoubleUtil.mul(100, DoubleUtil.sub(1,
		 * string2Double(rank)))) .append(", name:'超越")
		 * .append(DoubleUtil.mul(100, DoubleUtil.sub(1, string2Double(rank))) +
		 * "%").append("'},, {value:") .append(DoubleUtil.mul(100,
		 * string2Double(rank))) .append(", name:'未超越")
		 * .append(DoubleUtil.mul(100, string2Double(rank)) + "%")
		 * .append("'}]");
		 */
		sb.append("[")
				.append(DoubleUtil.mul(100,
						DoubleUtil.sub(1, string2Double(rank)))).append(",")
				.append(DoubleUtil.mul(100, string2Double(rank))).append("]");

		return sb.toString();
	}

	public static String getMarkLineData(String startAreaNm,
			Map<String, String> map) {
		if (startAreaNm == null || startAreaNm == "") {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		Set set = map.entrySet();
		Iterator iter = set.iterator();
		sb.append("[");
		while (iter.hasNext()) {
			Map.Entry me = (Map.Entry) iter.next();
			sb.append("[{name:'").append(startAreaNm).append("'},{name:'")
					.append(me.getKey()).append("',value:")
					.append(me.getValue()).append("}],");
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");

		return sb.toString();
	}

	public static String getMarkPointData(String startAreaNm,
			Map<String, String> map) {
		if (startAreaNm == null || startAreaNm == "") {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		Set set = map.entrySet();
		Iterator iter = set.iterator();
		sb.append("[");
		while (iter.hasNext()) {
			Map.Entry me = (Map.Entry) iter.next();
			sb.append("{name:'").append(me.getKey()).append("',value:")
					.append(me.getValue()).append("},");
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");

		return sb.toString();
	}

	public static String getTime(String year, String month, String date,
			String hour, String minute, String second) {
		StringBuffer sb = new StringBuffer();
		sb.append(year).append("年").append(month).append("月").append(date)
				.append("日 ").append(hour).append(":").append(minute)
				.append(":").append(second);

		return sb.toString();
	}

	public static String getConsStr(List<String> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(",");
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("\"");

		return sb.toString();
	}
	
	private static double getPctSum(List<Industry> indList) {
		double pctSum = 0.0;
		for (Industry ind : indList) {
			pctSum = DoubleUtil.add(pctSum, string2Double(ind.getPct()));
		}

		if (pctSum >= 1) {
			pctSum = 1;
		}

		return pctSum;
	}

}
