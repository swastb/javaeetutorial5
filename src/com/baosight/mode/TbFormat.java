package com.baosight.mode;

/**
 * TbFormat entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbFormat implements java.io.Serializable {

	// Fields

	private String formatId;
	private String formatName;
	private String rem;

	// Constructors

	/** default constructor */
	public TbFormat() {
	}

	/** full constructor */
	public TbFormat(String formatName, String rem) {
		this.formatName = formatName;
		this.rem = rem;
	}

	// Property accessors

	public String getFormatId() {
		return this.formatId;
	}

	public void setFormatId(String formatId) {
		this.formatId = formatId;
	}

	public String getFormatName() {
		return this.formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public String getRem() {
		return this.rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

}