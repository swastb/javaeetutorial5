package com.baosight.fax.bean;

/**
 * <p>Decription:查询条件使用参数</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-16</p>
 */
public class ListSearchBean {
	private String startTime;
	private String endTime;
	private String faxNum;
	private String state;
	private String sendDeptId;
	private String sender;

	public ListSearchBean(){
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFaxNum() {
		return faxNum;
	}

	public void setFaxNum(String faxNum) {
		this.faxNum = faxNum;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSendDeptId() {
		return sendDeptId;
	}

	public void setSendDeptId(String sendDeptId) {
		this.sendDeptId = sendDeptId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
