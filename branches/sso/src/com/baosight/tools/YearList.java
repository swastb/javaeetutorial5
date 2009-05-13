package com.baosight.tools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class YearList {
	
	
	public static List getYearList(int offset, int count) {
		List list = new ArrayList();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + offset);
		for (int i = 0; i < count; i++) {
			YearListForm date = new YearListForm();
			date.setYear(calendar.get(Calendar.YEAR) + i);
			list.add(date);
		}
		return list;
	}
	
	
	
	public static List getMonthList(int count) {
		List list = new ArrayList();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 01);
		for (int i = 0; i < count; i++) {
			YearListForm date = new YearListForm();
			date.setMonth(calendar.get(Calendar.MONTH) + i);
			list.add(date);
		}
		return list;
	}


}
