package com.baosight.mode;

/**
 * TbNopubdesc entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbNopubdesc implements java.io.Serializable {

	// Fields

	private String nopubdescId;
	private String nopubdescName;
	private String rem;

	// Constructors

	/** default constructor */
	public TbNopubdesc() {
	}

	/** full constructor */
	public TbNopubdesc(String nopubdescName, String rem) {
		this.nopubdescName = nopubdescName;
		this.rem = rem;
	}

	// Property accessors

	public String getNopubdescId() {
		return this.nopubdescId;
	}

	public void setNopubdescId(String nopubdescId) {
		this.nopubdescId = nopubdescId;
	}

	public String getNopubdescName() {
		return this.nopubdescName;
	}

	public void setNopubdescName(String nopubdescName) {
		this.nopubdescName = nopubdescName;
	}

	public String getRem() {
		return this.rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

}