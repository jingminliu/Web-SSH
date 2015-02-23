package com.cup.cardholder.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getStartDate(String year, String month) {
		StringBuffer sb = new StringBuffer();
		sb.append(year).append(month).append("01");

		return sb.toString();
	}

	public static String getEndDate(String year, String month) {
		StringBuffer sb = new StringBuffer();
		sb.append(year).append(month);
		int m = StringUtil.string2Int(month);
		int y = StringUtil.string2Int(year);

		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			sb.append("31");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			sb.append("30");
			break;
		case 2:
			if ((y % 4 == 0 && y % 1 != 0) || (y % 400 == 0)) {
				sb.append("29");
			} else {
				sb.append("28");
			}
		}

		return sb.toString();
	}

	public static String getYearSpan(String year) {
		StringBuffer sb = new StringBuffer();
		sb.append(year);
		if (year.equals("2012")) {
			sb.append("/06/01-").append(year).append("/12/31");
		} else if (year.equals("2013")) {
			sb.append("/01/01-").append(year).append("/12/31");
		} else if (year.equals("2014")) {
			sb.append("/01/01-").append(year).append("/04/30");
		}

		return sb.toString();
	}

	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		return formatter.format(new Date());
	}

}
