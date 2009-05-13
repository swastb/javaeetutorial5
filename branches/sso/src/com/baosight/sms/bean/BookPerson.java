package com.baosight.sms.bean;

/**
 * <p>Decription:公共通讯录人员</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-13</p>
 */
public class BookPerson {

	private String id;
	private String groupId;
	private String name;
	private String mobile;

	public BookPerson(){
	}

	public BookPerson(String id, String groupId, String name, String mobile) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.name = name;
		this.mobile = mobile;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
