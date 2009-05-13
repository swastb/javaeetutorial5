package com.baosight.mode;

/**
 * TbType entity.
 * 
 * @author MyEclipse Persistence Tools
 */


public class TbType implements java.io.Serializable {

	// Fields

	private String typeId;
	private String typeName;
	private String rem;

	// Constructors

	/** default constructor */
	public TbType() {
	}

	/** full constructor */
	public TbType(String typeName, String rem) {
		this.typeName = typeName;
		this.rem = rem;
	}

	// Property accessors

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRem() {
		return this.rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

}