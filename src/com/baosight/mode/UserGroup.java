package com.baosight.mode;

public class UserGroup {
	/**
	 * 用户组编号
	 */
	private String code;

	/**
	 * 用户组名称
	 */
	private String name;

	/**
	 * 用户组级别
	 */
	private String lvl;

	/**
	 * 备注
	 */
	private String rmk;

	/**
	 * 
	 * 默认构造函数
	 */
	public UserGroup() {
	}

	/**
	 * 初使化构造函数
	 * 
	 * @param code
	 *            用户组编号
	 * @param name
	 *            用户组名称
	 * @param lvl
	 *            用户组级别
	 * @param rmk
	 *            备注
	 */
	public UserGroup(String code, String name, String lvl, String rmk) {
		this.code = code;
		this.name = name;
		this.lvl = lvl;
		this.rmk = rmk;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

}
