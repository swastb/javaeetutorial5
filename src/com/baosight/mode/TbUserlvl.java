package com.baosight.mode;

/**
 * TbUserlvl generated by MyEclipse Persistence Tools
 */

public class TbUserlvl implements java.io.Serializable {

	// Fields

	private String id;

	private String name;

	private String ename;

	private String code;

	private String rm;

	// Constructors

	/** default constructor */
	public TbUserlvl() {
	}

	/** full constructor */
	public TbUserlvl(String name, String ename, String code, String rm) {
		this.name = name;
		this.ename = ename;
		this.code = code;
		this.rm = rm;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRm() {
		return this.rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

}