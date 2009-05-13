package com.baosight.mode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbDocRec generated by MyEclipse Persistence Tools
 */

public class TbDocRec implements java.io.Serializable {

	// Fields

	private String id;

	private String infoLevel;

	private Date writeTime;

	private String docDept;

	private String docCode;

	private Long docNum;

	private String docType;

	private String docName;

	private String draftOpinion;

	private String bookUser;

	private String auditUser;

	private Date overDate;

	private String leaderAudit;

	private String assUserRemark;

	private String mainDeptOpinion;

	private String dealState;

	private String docState;

	private Long archiveFlag=0l;

	private Long urgentFlag=0l;

	private Long docPage;

	private String draftRadio;

	private Set tbDocControls = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbDocRec() {
	}

	/** minimal constructor */
	public TbDocRec(String docName) {
		this.docName = docName;
	}

	/** full constructor */
	public TbDocRec(String infoLevel, Date writeTime, String docDept,
			String docCode, Long docNum, String docType, String docName,
			String draftOpinion, String bookUser, String auditUser,
			Date overDate, String leaderAudit, String assUserRemark,
			String mainDeptOpinion, String dealState, String docState,
			Long archiveFlag, Long urgentFlag, Long docPage, String draftRadio,
			Set tbDocControls) {
		this.infoLevel = infoLevel;
		this.writeTime = writeTime;
		this.docDept = docDept;
		this.docCode = docCode;
		this.docNum = docNum;
		this.docType = docType;
		this.docName = docName;
		this.draftOpinion = draftOpinion;
		this.bookUser = bookUser;
		this.auditUser = auditUser;
		this.overDate = overDate;
		this.leaderAudit = leaderAudit;
		this.assUserRemark = assUserRemark;
		this.mainDeptOpinion = mainDeptOpinion;
		this.dealState = dealState;
		this.docState = docState;
		this.archiveFlag = archiveFlag;
		this.urgentFlag = urgentFlag;
		this.docPage = docPage;
		this.draftRadio = draftRadio;
		this.tbDocControls = tbDocControls;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInfoLevel() {
		return this.infoLevel;
	}

	public void setInfoLevel(String infoLevel) {
		this.infoLevel = infoLevel;
	}

	public Date getWriteTime() {
		return this.writeTime;
	}

	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}

	public String getDocDept() {
		return this.docDept;
	}

	public void setDocDept(String docDept) {
		this.docDept = docDept;
	}

	public String getDocCode() {
		return this.docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public Long getDocNum() {
		return this.docNum;
	}

	public void setDocNum(Long docNum) {
		this.docNum = docNum;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDraftOpinion() {
		return this.draftOpinion;
	}

	public void setDraftOpinion(String draftOpinion) {
		this.draftOpinion = draftOpinion;
	}

	public String getBookUser() {
		return this.bookUser;
	}

	public void setBookUser(String bookUser) {
		this.bookUser = bookUser;
	}

	public String getAuditUser() {
		return this.auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Date getOverDate() {
		return this.overDate;
	}

	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}

	public String getLeaderAudit() {
		return this.leaderAudit;
	}

	public void setLeaderAudit(String leaderAudit) {
		this.leaderAudit = leaderAudit;
	}

	public String getAssUserRemark() {
		return this.assUserRemark;
	}

	public void setAssUserRemark(String assUserRemark) {
		this.assUserRemark = assUserRemark;
	}

	public String getMainDeptOpinion() {
		return this.mainDeptOpinion;
	}

	public void setMainDeptOpinion(String mainDeptOpinion) {
		this.mainDeptOpinion = mainDeptOpinion;
	}

	public String getDealState() {
		return this.dealState;
	}

	public void setDealState(String dealState) {
		this.dealState = dealState;
	}

	public String getDocState() {
		return this.docState;
	}

	public void setDocState(String docState) {
		this.docState = docState;
	}

	public Long getArchiveFlag() {
		return this.archiveFlag;
	}

	public void setArchiveFlag(Long archiveFlag) {
		this.archiveFlag = archiveFlag;
	}

	public Long getUrgentFlag() {
		return this.urgentFlag;
	}

	public void setUrgentFlag(Long urgentFlag) {
		this.urgentFlag = urgentFlag;
	}

	public Long getDocPage() {
		return this.docPage;
	}

	public void setDocPage(Long docPage) {
		this.docPage = docPage;
	}

	public String getDraftRadio() {
		return this.draftRadio;
	}

	public void setDraftRadio(String draftRadio) {
		this.draftRadio = draftRadio;
	}

	public Set getTbDocControls() {
		return this.tbDocControls;
	}

	public void setTbDocControls(Set tbDocControls) {
		this.tbDocControls = tbDocControls;
	}

}