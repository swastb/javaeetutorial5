package com.baosight.mode;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

/**
 * TbWrit7 generated by MyEclipse Persistence Tools
 */

public class TbWrit7 extends ActionForm implements java.io.Serializable {

	// Fields

	private String id;

	private String busId;

	private Date applydate;

	private String checkbox;

	private String text1;

	private String text2;

	private Date createdate;

	// Constructors

	/** default constructor */
	public TbWrit7() {
	}

	/** full constructor */
	public TbWrit7(String busId, Date applydate, String checkbox, String text1,
			String text2, Date createdate) {
		this.busId = busId;
		this.applydate = applydate;
		this.checkbox = checkbox;
		this.text1 = text1;
		this.text2 = text2;
		this.createdate = createdate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusId() {
		return this.busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public Date getApplydate() {
		return this.applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getCheckbox() {
		return this.checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getText1() {
		return this.text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return this.text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}