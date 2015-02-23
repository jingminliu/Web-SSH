package com.cup.cardholder.model;

import java.util.Comparator;

import com.cup.cardholder.service.StringUtil;

@SuppressWarnings("rawtypes")
public class SortByPct implements Comparator{

	@Override
	public int compare(Object arg1, Object arg2) {
		Industry ind1 = (Industry) arg1;
		Industry ind2 = (Industry) arg2;
		
		if(StringUtil.string2Double(ind1.getPct()) < StringUtil.string2Double(ind2.getPct()))
			return 1;

		return 0;
	}

}
