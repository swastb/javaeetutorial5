package com.baosight.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  数据库操作类
 * @author xiongfeng
 *
 */

public class DbManager1
{
	//饿汉式的单例模式
	private static DbManager1 instance = new DbManager1();
	private DbManager1()
	{
	}
	public static DbManager1 getInstance()
	{
		return instance;
	}
	
	//类成员Connection
	protected static Connection conn;
	//Oracle驱动
	public static final String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
	//数据库连接地址
	public static final String CONNET_STR = "jdbc:oracle:thin:@31.16.1.134:1521:GGXXPT";
	
	
	//获得连接
	public static Connection getConnection()
	{
		try
		{
			//使用类反射加载驱动
			Class.forName(CLASS_NAME);
			conn = DriverManager.getConnection(CONNET_STR, "ssoadmin", "ssoadmin");
			return conn;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 *  根据Sql语句得到结果集
	 *  @params:Sql语句
	 *  @return:ResultSet
	 */
	public static ResultSet getResultSet(String sql)
	{
		boolean bSuccess = true;
		//语句集
		Statement stmt = null;
		//结果集
		ResultSet rs = null;
		//获得一个连接
		Connection con = getConnection();
		if(con == null)
		{
			bSuccess = false;
		}
		if(bSuccess)
		{
			try
			{
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				bSuccess = false;
				System.out.println("---------数据库连接失败---------");
			}
		}
		if(bSuccess)
		{
			return rs;
		}
		else
		{
			return null;
		}
	}
	
	
	/**
	 *  根据Sql语句，更新数据
	 *  @params:sql语句
	 *  @return:boolean
	 */
	public static boolean execute(String sql)
	{
		boolean bSuccess = true;
		Statement stmt = null;
		Connection con = getConnection();
		if(con == null)
		{
			bSuccess = false;
		}
		if(bSuccess)
		{
			try 
			{
				stmt = con.createStatement();
				bSuccess = stmt.execute(sql);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return false;
			}
		}
		return bSuccess;
	}
	
	//关闭连接
	public static void releaseConnection()
	{
		try 
		{
			if(conn != null)
			{
				conn.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
