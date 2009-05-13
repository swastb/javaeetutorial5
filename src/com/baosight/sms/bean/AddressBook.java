package com.baosight.sms.bean;

/**
 * <p>Decription:公共通讯录分组</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-13</p>
 */
public class AddressBook {

	private String id;
	private String parentId;
	private String name;

	public AddressBook(){
	}

	public AddressBook(String id, String parentId, String name) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
