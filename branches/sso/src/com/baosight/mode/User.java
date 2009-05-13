package com.baosight.mode;

public class User {
	/**
	 * 用户标识
	 */
	private String userid;

	/**
	 * 用户真实姓名
	 */
	private String name;

	/**
	 * 用户名
	 */
	private String useracc;

	/**
	 * 密码
	 */
	private String pwd;

	/**
	 * 用户级别
	 */
	private String lvl;

	/**
	 * 用户所属部门
	 */
	private String dept;

	/**
	 * 联系电话
	 */
	private String tel;

	/**
	 * 职务
	 */
	private String pst;

	/**
	 * 备注
	 */
	private String rmk;

	/**
	 * 
	 * 默认构造函数
	 */
	public User() {
	}

	/**
	 * 初使化构造函数
	 * 
	 * @param userid
	 *            用户标识
	 * @param name
	 *            用户真实姓名
	 * @param useracc
	 *            用户名
	 * @param pwd
	 *            密码
	 * @param lvl
	 *            用户级别
	 * @param dept
	 *            用户所属部门
	 * @param tel
	 *            联系电话
	 * @param pst
	 *            职务
	 * @param rmk
	 *            备注
	 */
	public User(String userid, String name, String useracc, String pwd,
			String lvl, String dept, String tel, String pst, String rmk) {
		this.userid = userid;
		this.name = name;
		this.useracc = useracc;
		this.pwd = pwd;
		this.lvl = lvl;
		this.dept = dept;
		this.tel = tel;
		this.pst = pst;
		this.rmk = rmk;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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

	public String getPst() {
		return pst;
	}

	public void setPst(String pst) {
		this.pst = pst;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUseracc() {
		return useracc;
	}

	public void setUseracc(String useracc) {
		this.useracc = useracc;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
