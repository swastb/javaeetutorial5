package com.baosight.layout;

import java.sql.*;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class DbManager {
	//类成员Connection
	public Connection conn=null;
    //mysql的驱动类，定义为常量
	public static final String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
    //数据库的连接地址，定义为常量
	//public static final String CONNET_STR = "jdbc:oracle:thin:@127.0.0.1:1521:ODB";
	public static final String CONNET_STR = "jdbc:oracle:thin:@31.16.1.134:1521:GGXXPT";
	//public static final String CONNET_STR = "jdbc:oracle:oci:@GGXXPT_31.16.1.134";
    //获得Connetion
	public  Connection getConnection() {
		/*Connection con=null;
		DataSource ds=null;	*/	

		try {
			
			
//			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			/*Properties  pro=new  Properties();  
			pro.put(Context.INITIAL_CONTEXT_FACTORY  ,"weblogic.jndi.WLInitialContextFactory");    
		    pro.put(Context.PROVIDER_URL,"t3://31.16.3.161:7001");  */
			/*Context ctx=new InitialContext();
			
			javax.sql.DataSource ds=(javax.sql.DataSource)ctx.lookup("ORADBSOURCE");
			conn=ds.getConnection();*/
			//System.out.println("bbb"+conn.toString());
	        /*Context initCtx=new InitialContext();
	        ds=(DataSource)initCtx.lookup("jdbc/oracle");*/
			//Class.forName(CLASS_NAME);//使用类反射加载该驱动类
			//获得一个Connection
			conn = DriverManager.getConnection(CONNET_STR, "ssoadmin", "ssoadmin");
			System.out.println("bbb"+conn.toString());
			return conn;//返回该Connection
			 
	        /*conn = ds.getConnection();
	        return conn;*/
	    } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//传入查询数据库的sql语句，返回ResultSet
	public  ResultSet getResultSet(String sql) {
		boolean bSuccess = true;
		Statement stmt = null;//声明Statement stmt
		ResultSet rs = null;//声明ResultSet rs
		if(conn==null){
			conn=getConnection();
		}
		//Connection con= getConnection();//调用getConnetion()方法获得一个Connetion
		if (conn == null)//如果Connection 为null则返回假
			bSuccess = false;
		if (bSuccess) {
			try {		
				stmt = conn.createStatement();//通过Connection创建一个Statemet
				rs = stmt.executeQuery(sql);//执行查询语句，
			} catch (SQLException e) {
				e.printStackTrace();
				bSuccess = false;
			}
		}
		if (bSuccess)//如果执行成功，则返回rs
			return rs;
		else
			return null;
		
		
	}
   //传入执行数据更新的语句，返回更新结果，真为成功执行
	public  boolean excute(String sql) {
		boolean bSuccess = true;
		Statement stmt = null;//声明Statement stmt
		if(conn==null){
			conn=getConnection();
		}
		//Connection con = getConnection();//调用getConnetion()方法获得一个Connetion
		if (conn == null)//如果Connection 为null则返回假
			bSuccess = false;
		if (bSuccess) {
			try {
				stmt = conn.createStatement();//通过Connection创建一个Statemet
				bSuccess = stmt.execute(sql);//执行更新数据操作
			} catch (SQLException e) {
				e.printStackTrace();
				bSuccess = false;
			}
		}
		return bSuccess;
	}
    //释放Connection
	public  void releaseConnection() {
		try {
			if(this.conn!=null){
				if (!this.conn.isClosed()){//  如果Connetion 不为null则关闭Connection
					System.out.println("aaa"+conn.toString());
					this.conn.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
