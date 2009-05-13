package com.baosight.tools;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WeekManager {

	public static String getSeqWeek(String date) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		// System.out.println(c.get(Calendar.WEEK_OF_YEAR));
		c.setTime(strToDate(date));
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	// 产生周序列 x年x周
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		// System.out.println(c.get(Calendar.WEEK_OF_YEAR));
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	// 获得周一的日期
	public static String getMonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	// 获得周二的日期
	public static String getTuesday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	// 获得周三的日期
	public static String getWednesday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	// 获得周四的日期
	public static String getThursday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	// 获得周五的日期
	public static String getFriday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

	}

	// 获得周六的日期
	public static String getSaturday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

	}

	// 获得周日的日期
	public static String getSunday(Date date) {
		// System.out.println(date.toString());
		//date.setDate(date.getDate()+7);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String str = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return str;
	}

	public static String dateToStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String datetostr;
		try {
			datetostr = formatter.format(date);
			return datetostr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date strtodate;
		try {
			strtodate = formatter.parse(strDate);
			return strtodate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数

	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24
					* 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	public static Date getNextDate(Date nowdate, String delay) {
		long myTime = (nowdate.getTime() / 1000) + Integer.parseInt(delay) * 24
				* 60 * 60;
		nowdate.setTime(myTime * 1000);
		return nowdate;
	}

	public static String getDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// System.out.println(c.get(Calendar.WEEK_OF_MONTH));
		int num = c.get(Calendar.DAY_OF_WEEK);
		String result = "";
		switch (num) {
		case 1:
			result = "星期日";
			break;
		case 2:
			result = "星期一";
			break;
		case 3:
			result = "星期二";
			break;
		case 4:
			result = "星期三";
			break;
		case 5:
			result = "星期四";
			break;
		case 6:
			result = "星期五";
			break;
		case 7:
			result = "星期六";
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		// String str = WeekManager.getSeqWeek();
		// System.out.println(str);
		// Date now = new Date();
		// String strs = WeekManager.getSaturday(now);
		// System.out.println(strs);
		// String result = WeekManager.getDayOfWeek(new Date());
		// String s = "2008-05-01";
		// Date date = null;
		// try {
		// date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(s);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// String str = WeekManager.getNextDay(s, "-7");
		// System.out.println(str);

		Date date = new Date();
		date = WeekManager.getNextDate(date, "7");
		System.out.println(date.toString());
	}
}
