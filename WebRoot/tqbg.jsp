<%@ page language="java" session="true" contentType="text/html;charset=gb2312"  import="java.sql.*,java.util.*,java.net.URL,java.lang.*"%>
<%@ page import="java.sql.*,java.util.*,java.lang.*"%>


<%@ page import="java.sql.*"%> 
<%
	//String opinion7=com.db.get2Table.getCateIDex("危化品申报及登记指南","");
	String strDate;
	java.text.SimpleDateFormat simpleDateFormat=new java.text.SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date=new java.util.Date();
    String currentDate	= simpleDateFormat.format(date);
%>

<%//取天气预报
        String nr="";
		String high="";
		String low="";
		Connection conn1 = null;
		//Connect dbc=new Connect();
		conn1 = DriverManager.getConnection("jdbc:oracle:thin:@31.16.1.123:1521:swater", "newwater", "2ws3ed4rf");
	    //conn1=dbc.getDbConn("newwater","2ws3ed4rf","jdbc:oracle:thin:@31.16.1.123:1521:swater");
		
		Statement stmt1 = conn1.createStatement();
        
		//String sql="select * from qxyb where currdate>=to_date('" + currentDate + " 00:00:00','YYYY-MM-DD HH24:MI:SS') and currdate<=to_date('" + currentDate + " 23:59:59','YYYY-MM-DD HH24:MI:SS') ";
		String sql1="select substr(nr,instr(nr,'：')+6,instr(nr,'。',(instr(nr,'：')+6))-(instr(nr,'：')+6)) as nr,	substr(nr,instr(nr,'最高温度')+4,instr(nr,'度',instr(nr,'最高温度')+4)-(instr(nr,'最高温度')+4)) as high, substr(nr,instr(nr,'最低温度')+4,instr(nr,'度',instr(nr,'最低温度')+4)-(instr(nr,'最低温度')+4)) as low from qxyb where nr is not null order by currdate desc ";

	    ResultSet rs_xq = stmt1.executeQuery(sql1);
	    boolean  more_all  = rs_xq.next();        
        
        while(more_all){

        	nr=rs_xq.getString("nr");
			high=rs_xq.getString("high");
			low=rs_xq.getString("low");
        	more_all=false;
			//more_all  = rs_xq.next();
        }
        rs_xq.close();
		nr=nr.replace('\n',' ');
		nr=nr.replace('。',' ');
        nr=nr + "&nbsp;&nbsp;&nbsp;&nbsp;最高温度：" + high + "度，" + "最低温度" + low + "度";
		
%>
<%=nr%>
<%conn1.close();%>
