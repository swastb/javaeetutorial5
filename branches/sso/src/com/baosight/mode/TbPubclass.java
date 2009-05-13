package com.baosight.mode;

/**
 * TbPubclass entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbPubclass implements java.io.Serializable {

	// Fields

	private String pubId;
	private String pubName;
	private String rem;

	// Constructors

	/** default constructor */
	public TbPubclass() {
	}

	/** full constructor */
	public TbPubclass(String pubName, String rem) {
		this.pubName = pubName;
		this.rem = rem;
	}

	// Property accessors

	public String getPubId() {
		return this.pubId;
	}

	public void setPubId(String pubId) {
		this.pubId = pubId;
	}

	public String getPubName() {
		return this.pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public String getRem() {
		return this.rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

}