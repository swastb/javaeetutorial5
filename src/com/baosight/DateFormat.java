package com.baosight;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormat {
	
	/**日期格式化
	 * @return	返回yyyy-MM-dd样式的日期字符串
		*/
	static public String dateFormat(java.util.Date date)
	{
		if (date.getTime() <= 0)
			return "";
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	/*
	 * 根据字符串获取日期，返回格式为yyyyy-mm-dd
	 * */
	public static Date getDate(String dateStr) 
	{
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateStr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}		
	/**   
	* 获取指定日期的毫秒     
	* @param date util.Date日期   
	* @return long   毫秒       
	*/  
	public static long getMillisTime( java.util.Date date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( date );   
	   return c.getTimeInMillis();   
	} 
	/**获取日期
	 @param stringDate:String 基准日期
	 @param days :int 天数（-前+后）
	 */
	static public String spanDate(String stringDate, int days)
	{
		Date date = getDate(stringDate);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return dateFormat(cal.getTime());
	}
	/**获取日期相差天数
	 @param stringDateBegin :String 开始日期
	 @param stringDateEnd :String 结束日期
	 */
	static public int spanDateGap(String stringDateBegin, String stringDateEnd)
	{
		Date dateBegin = getDate(stringDateBegin);
		Date dateEnd = getDate(stringDateEnd);
		long dateBeginLong = getMillisTime( dateBegin );   
		long dateEndLong = getMillisTime( dateEnd );   
		int gapDays =  (int)( ( dateEndLong - dateBeginLong ) / ( 1000 * 60 * 60 * 24 ) );   
		return gapDays;
	}
	public static void main(String [] args){
		System.out.println(spanDateGap("2008-08-08","2009-08-09"));
		System.out.println(spanDate("2008-04-08",366));
	}
}
