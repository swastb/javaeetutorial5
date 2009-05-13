package com.baosight.tools;

/**
 *  日期转换
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateFormat {
	// 定义一个私有的 数据库访问类
	public static DbManager1 db = DbManager1.getInstance();

	// 结果集
	public static ResultSet rs = null;

	/**
	 * 日期格式化
	 * 
	 * @return 返回yyyy-MM-dd样式的日期字符串
	 */
	static public String dateFormat(java.util.Date date) {
		if (date.getTime() <= 0)
			return "";
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		return formatter.format(date);
	}

	/**
	 * 根据字符串获取日期，返回格式为yyyyy-mm-dd
	 */
	public static Date getDate(String dateStr) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取指定日期的毫秒
	 * 
	 * @param date
	 *            util.Date日期
	 * @return long 毫秒
	 */
	public static long getMillisTime(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 获取 某天后的具体日期（节假日除外）
	 * 
	 * @param1 stringDate(String 基准日期)
	 * @param2 days(int 天数（-前+后）)
	 * 
	 */
	@SuppressWarnings( { "static-access", "unchecked" })
	static public Date spanDate(String stringDate, int days) {
		Date paramDate = null;
		if (days == 0) {
			paramDate = getDate(stringDate);
			return paramDate;

		} else {
			boolean eq = true;
			// 记录天数，用于判断 days = day
			int day = 0;

			String addDate = "";

			Date sdate = getDate(stringDate);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(sdate);
			calendar.add(Calendar.DATE, (days * 2));
			String endDate = dateFormat(calendar.getTime());

			// 取出大于 stringDate 日期的 ‘节假日日期’ 和 ‘放假天数’ 的数据
			String sql = "select holiday as holiday,day as day from ssoadmin.tb_oa_holiday where holiday between to_date('"
					+ stringDate
					+ "','yyyy-mm-dd') and to_date('"
					+ endDate
					+ "','yyyy-mm-dd') order by holiday";
			try {
				rs = db.getResultSet(sql);
				List list = new ArrayList();
				while (rs.next()) {
					list.add(rs.getDate("holiday"));
				}
				// 参数列表中传入的日期（stringDate）
				Date date = getDate(stringDate);
				// 日历对象
				GregorianCalendar cal = (GregorianCalendar) GregorianCalendar
						.getInstance();
				// 把 stringDate 设置为日历对象，以便操作
				cal.setTime(date);
				if (list.size() == 0) {
					cal.add(Calendar.DATE, days);
					addDate = dateFormat(cal.getTime());
					paramDate = getDate(addDate);
				} else {

					for (int i = 0; i < 100; i++) {
						// 天数 +1
						cal.add(Calendar.DATE, 1);
						addDate = dateFormat(cal.getTime());
						paramDate = getDate(addDate);
						for (int y = 0; y < list.size(); y++) {
							Date holiday = (Date) list.get(y);
							// 如果相等，paramDate 为节假日，不予计算
							if (holiday.compareTo(paramDate) == 0) {
								eq = true;
								break;
							}
							// 否则，paramDate 不是节假日，天数加一天
							else {
								eq = false;
							}

						}
						if (eq == false) {
							day++;
						}
						if (day == days) {
							break;
						}
					}
				}
				// System.out.println("最后的日期：" + addDate);
				return paramDate;

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	/**
	 * 获取日期相差天数（节假日除外）
	 * 
	 * @param1 stringDateBegin(String 开始日期)
	 * @param2 stringDateEnd(String 结束日期)
	 * 
	 */
	@SuppressWarnings("static-access")
	static public int spanDateGap(String stringDateBegin, String stringDateEnd) {
		// 相差天数中的节假日天数
		int totalCount = 0;
		// 用于返回
		int returnDay = 0;
		// 开始日期
		Date dateBegin = getDate(stringDateBegin);
		// String beginTime = dateFormat(dateBegin);
		// 日历对象
		GregorianCalendar cal2 = (GregorianCalendar) GregorianCalendar
				.getInstance();
		// 把 stringDate 设置为日历对象，以便操作
		cal2.setTime(dateBegin);
		// 天数 +1
		cal2.add(Calendar.DATE, 1);
		String begin = dateFormat(cal2.getTime());

		// 结束日期
		Date dateEnd = getDate(stringDateEnd);
		String endTime = dateFormat(dateEnd);

		// long dateBeginLong = getMillisTime( dateBegin );
		// long dateEndLong = getMillisTime( dateEnd );
		// 相差的天数（没有除去节假日）
		// int gapDays = (int)( ( dateEndLong - dateBeginLong ) / ( 1000 * 60 *
		// 60 * 24 ) );

		long time = Math.abs(dateBegin.getTime() - dateEnd.getTime());
		int gapDays = (int) (time / (24 * 3600 * 1000));

		// System.out.println("相差的天数（没有除去节假日）：" + gapDays);

		// 取出数据库中开始日期和结束日期之间的节假日天数
		String sql = "select count(*) as totalcount from ssoadmin.tb_oa_holiday where holiday between to_date('"
				+ begin
				+ "','yyyy-mm-dd') and to_date('"
				+ endTime
				+ "','yyyy-mm-dd')";
		try {
			rs = db.getResultSet(sql);
			while (rs.next()) {
				totalCount = rs.getInt("totalcount");
				System.out.println("相差天数中的节假日天数：" + totalCount);
			}
			returnDay = gapDays - totalCount;
			System.out.println("最后，实际的相差天数：" + returnDay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnDay;

	}

	// 程序入口
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// System.out.println(spanDateGap("2008-8-28","2008-9-4 20:14:50"));
		// System.out.println(spanDate("2010-04-11",5));
		DateFormat obj = new DateFormat();
		// 获取某天后的日期（节假日除外）
		System.out.println("============= 获取某天后的日期（节假日除外） ==============");
		@SuppressWarnings("unused")
		Date someDay = obj.spanDate("2008-11-3", 2);

		System.out.println(someDay.toString());

		// 获取相差天数（节假日除外）
		// System.out.println("============= 获取相差天数（节假日除外） ==============");
		// @SuppressWarnings("unused")
		// int day = obj.spanDateGap("2008-08-31", "2008-09-04");
	}
}
