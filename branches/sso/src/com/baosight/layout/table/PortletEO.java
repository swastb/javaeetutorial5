package com.baosight.layout.table;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.baosight.layout.*;

public class PortletEO {
	protected int id;//代表数据库中portlet_id列;
	protected String displayName;//代表数据库中display_name列;
	protected String javaClassName;//代表数据库中java_class_name列;
	protected String activeStatus="Y";//代表数据库中active_status列;
	public PortletEO() {//无参的构造方法 
		this.id = -1;
	}
	public PortletEO(int id) {//有参的构造方法，参数为portlet_id
		this.id = id;
		if (!FromDb())//如果有找到该id的porlet
			this.id = -1;
	}
	public static  DbManager dbManager;
//	public static DbManager getInstance(){
//		if(dbManager==null){
//			dbManager=new DbManager();
//		}
//		return dbManager;
//	}
	public boolean FromDb() {//从数据库中读出，并更新bean
		dbManager=new DbManager();
		//System.out.println("PortletEO FromDb() dbManager.DbManager()");
		int row = -1;
		//读记录的sql语句
		String sql = "select * from tb_ajax_portlet where portlet_id=" + this.id
				+ " and active_status='Y'";
		ResultSet rs = dbManager.getResultSet(sql);//执行sql语句并返回ResultSet
		try {
			if (rs.next()) {//如果只查询到一条记录，则代表该记录存在并更新该类的属性
				this.displayName = rs.getString("DISPLAY_NAME");
				this.javaClassName = rs.getString("JAVA_CLASS_NAME");
				this.activeStatus = rs.getString("ACTIVE_STATUS");
				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			//System.out.println("PortletEO FromDb() dbManager.releaseConnection");
			dbManager.releaseConnection();
		}
	}
	public boolean ToDb() {//更新数据库，并重新设置bean
		dbManager=new DbManager();
		//System.out.println("PortletEO ToDb() dbManager.DbManager()");
		if (getId() == -1)//如果此时id为-1
		{
			return false;
		} else {
			//更新该记录的sql语句
			String sql = "update tb_ajax_portlet set display_name=" + getDisplayName()
					+ ",java_class_name='" + getJavaClassName()
				    + "',active_status='"
					+ getActiveStatus() + "' where portlet_id=" + getId();
			dbManager.excute(sql);//执行sql语句
			//System.out.println("PortletEO ToDb() dbManager.releaseConnection");
			dbManager.releaseConnection();
			return FromDb();//重新读出bean的属性
		}
	}
	public String getActiveStatus() {//
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJavaClassName() {
		return javaClassName;
	}
	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}
	
}
