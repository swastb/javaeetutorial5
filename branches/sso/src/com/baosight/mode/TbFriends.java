package com.baosight.mode;

/**
 * TbFriends generated by MyEclipse Persistence Tools
 */

public class TbFriends implements java.io.Serializable {

	// Fields

	private String id;

	private String friendsId;

	private String frindesName;

	private String groupid;

	private String email;

	private String cellphone;

	// Constructors

	/** default constructor */
	public TbFriends() {
	}

	/** full constructor */
	public TbFriends(String friendsId, String frindesName, String groupid,
			String email, String cellphone) {
		this.friendsId = friendsId;
		this.frindesName = frindesName;
		this.groupid = groupid;
		this.email = email;
		this.cellphone = cellphone;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFriendsId() {
		return this.friendsId;
	}

	public void setFriendsId(String friendsId) {
		this.friendsId = friendsId;
	}

	public String getFrindesName() {
		return this.frindesName;
	}

	public void setFrindesName(String frindesName) {
		this.frindesName = frindesName;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}