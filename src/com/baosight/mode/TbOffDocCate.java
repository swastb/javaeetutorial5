package com.baosight.mode;

/**
 * TbOffDocCate entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbOffDocCate implements java.io.Serializable {

	// Fields

	private String cateId;
	private String cateName;
	private String rem;

	// Constructors

	/** default constructor */
	public TbOffDocCate() {
	}

	/** full constructor */
	public TbOffDocCate(String cateName, String rem) {
		this.cateName = cateName;
		this.rem = rem;
	}

	// Property accessors

	public String getCateId() {
		return this.cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return this.cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getRem() {
		return this.rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

}