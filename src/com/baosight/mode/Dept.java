package com.baosight.mode;

public class Dept {
	/**
	 * 部门编号
	 */
	private String code;

	/**
	 * 部门名称
	 */
	private String name;

	/**
	 * 部门类型
	 */
	private String type;

	/**
	 * 部门级别
	 */
	private String lvl;

	/**
	 * 上级部门
	 */
	private String superior;

	/**
	 * 联系电话
	 */
	private String tel;

	/**
	 * 联系人
	 */
	private String ctc;

	/**
	 * 备注字段
	 */
	private String rmk;

	/**
	 * 
	 * 默认构造函数
	 */
	public Dept() {
	}

	/**
	 * 初使化构造函数
	 * 
	 * @param code
	 *            部门编号
	 * @param name
	 *            部门名称
	 * @param type
	 *            部门级别
	 * @param lvl
	 *            部门级别
	 * @param superior
	 *            上级部门
	 * @param tel
	 *            联系电话
	 * @param ctc
	 *            联系人
	 * @param rmk
	 *            备注字段
	 */
	public Dept(String code, String name, String type, String lvl,
			String superior, String tel, String ctc, String rmk) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.lvl = lvl;
		this.superior = superior;
		this.tel = tel;
		this.ctc = ctc;
		this.rmk = rmk;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
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

	public String getSuperior() {
		return superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
