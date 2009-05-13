package com.baosight.layout.table;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.baosight.layout.*;

public class UserEO {
	protected String id;//代表数据库中id列
	protected String name;//代表数据库中name列
	protected String password;//代表数据库中pwd列
	protected String userAcc;//代表数据库中user_acc列
	public UserEO() {//无参的构造方法 
		this.id = "";
	}
	public UserEO(String id) {//有参的构造方法，参数为user_id
		this.id = id;
		if (!FromDb())//如果没有找到该id的user
			this.id = "";
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
		//System.out.println("UserEO FromDb() dbManager.DbManager()");
        //读记录的sql语句
		String sql = "select * from tb_user where id='" +this.id+ "'";
		ResultSet rs = dbManager.getResultSet(sql);//执行sql语句并返回ResultSet
		try {
			if (rs.next()) {//如果只查询到一条记录，则代表该记录存在并更新该类的属性
				this.name = rs.getString("NAME");
				this.password = rs.getString("PWD");
				this.userAcc = rs.getString("USER_ACC");
				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			//System.out.println("UserEO FromDb() dbManager.releaseConnection");
			dbManager.releaseConnection();
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(String userAcc) {
		this.userAcc = userAcc;
	}


}
