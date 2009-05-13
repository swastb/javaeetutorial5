package com.baosight.mode;

import java.util.Date;

/**
 * TbArchivesApply entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbArchivesApply implements java.io.Serializable {

	// Fields

	private String id;
	private String applyor;
	private String archivesId;
	private Date applyTiem;
	private String auditor;
	private Date auditTime;
	private String result;
	private String rem;

	// Constructors

	/** default constructor */
	public TbArchivesApply() {
	}

	/** full constructor */
	public TbArchivesApply(String applyor, String archivesId, Date applyTiem,
			String auditor, Date auditTime, String result, String rem) {
		this.applyor = applyor;
		this.archivesId = archivesId;
		this.applyTiem = applyTiem;
		this.auditor = auditor;
		this.auditTime = auditTime;
		this.result = result;
		this.rem = rem;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplyor() {
		return this.applyor;
	}

	public void setApplyor(String applyor) {
		this.applyor = applyor;
	}

	public String getArchivesId() {
		return this.archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}

	public Date getApplyTiem() {
		return this.applyTiem;
	}

	public void setApplyTiem(Date applyTiem) {
		this.applyTiem = applyTiem;
	}

	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRem() {
		return this.rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

}