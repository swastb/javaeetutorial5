package com.baosight.mode;

import java.util.Date;
/**
 * @author shang
 * 此类是 短信平台中查询统计的modle
 */
public class SmsRecordDept implements java.io.Serializable{
	 private String messageContent;
	 private String uname;
	 private String deptname;
	 private Date scheduletime;
	 private String receiveuser;
	 private String destNumber;
		/** default constructor */
	 public SmsRecordDept(){
		 
	 }
	 /** full constructor */
	 public SmsRecordDept(String messageContent,String uname,String deptname,Date scheduletime,String receiveuser,String destNumber){
		 this.messageContent = messageContent;
		 this.uname = uname;
		 this.deptname = deptname;
		 this.scheduletime = scheduletime;
		 this.receiveuser = receiveuser;
		 this.destNumber = destNumber;
	 }
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDestNumber() {
		return destNumber;
	}
	public void setDestNumber(String destNumber) {
		this.destNumber = destNumber;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getScheduletime() {
		return scheduletime;
	}
	public void setScheduletime(Date scheduletime) {
		this.scheduletime = scheduletime;
	}
	public String getReceiveuser() {
		return receiveuser;
	}
	public void setReceiveuser(String receiveuser) {
		this.receiveuser = receiveuser;
	}
}
