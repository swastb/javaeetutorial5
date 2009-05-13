package com.baosight.layout;

import java.util.StringTokenizer;
import java.util.Vector;


public class Util {
		public static final String GOOGLE_RSS = "http://news.google.com/news?hl=zh-CN&ned=cn&q=google&ie=UTF-8&output=rss";
	    public static final String SINA_RSS = "http://rss.sina.com.cn/news/marquee/ddt.xml";
	    public static final String YAHOO_RSS = "http://rss.news.yahoo.com/rss/us" ;
	    public static final String XINHUA_RSS = "http://rss.xinhuanet.com/rss/it.xml" ;
	    public static final int NUMBER = 5;
	    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	   
	    public static Vector parseCSV(String s)
	    {
	    	Vector v = new Vector();
	    	  StringTokenizer st = new StringTokenizer(s,",");
	    	     while (st.hasMoreTokens()) {
	    	         v.add(st.nextToken());
	    	     }
	    	return v;
	    }
	    public static String delAInB(String a, String b)
	    {
	    	String s= b;
	    	
	    	return s;
	    }
	    public static String replaceAWithB(String str, String A, String B)
	    {
	   /* String re [] = str.split(",");
	    String result="";
	    boolean isE = false;
	    for(int i=0;i<re.length;i++){
	    	if(re[i].equals(A)){
	    		isE = true;
	    		break;
	    	}else{
	    		result = result + re[i]+",";
	    	}
	    }
	    if(isE){
	    	return result;
	    }else{
	    	return str;
	    }*/
	     // if ( isStringNull(str) ) return "";

	      StringBuffer res = new StringBuffer();
	      int p = 0;
	      int q = 0;
	      while ((q = str.indexOf(A, p)) > -1) {
	        res.append(str.substring(p, q));
	        if ( B!= null )
	          res.append(B);
	        p = q + A.length();
	      }
	      res.append(str.substring(p));
	      return res.toString();
	    }
}
