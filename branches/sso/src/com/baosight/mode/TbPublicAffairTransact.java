package com.baosight.mode;

import java.util.Date;

/**
 * TbPublicAffairTransact entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbPublicAffairTransact implements java.io.Serializable {

	// Fields

	private String id;
	private String affairId;
	private String transactor;
	private Date receiveTime;
	private Date finisheTime;
	private Long status;
	private String commenta;
	private Long type;
	private Long affairType;
	private String beforeTransactor;

	// Constructors

	/** default constructor */
	public TbPublicAffairTransact() {
	}

	/** full constructor */
	public TbPublicAffairTransact(String affairId,
			String transactor, Date receiveTime, Date finisheTime, Long status,
			String commenta, Long type, Long affairType,String beforeTransactor) {
		this.affairId= affairId;
		this.transactor = transactor;
		this.receiveTime = receiveTime;
		this.finisheTime = finisheTime;
		this.status = status;
		this.commenta = commenta;
		this.type = type;
		this.affairType = affairType;
		this.beforeTransactor = beforeTransactor;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getTransactor() {
		return this.transactor;
	}

	public void setTransactor(String transactor) {
		this.transactor = transactor;
	}

	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Date getFinisheTime() {
		return this.finisheTime;
	}

	public void setFinisheTime(Date finisheTime) {
		this.finisheTime = finisheTime;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getCommenta() {
		return this.commenta;
	}

	public void setCommenta(String commenta) {
		this.commenta = commenta;
	}

	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getAffairType() {
		return this.affairType;
	}

	public void setAffairType(Long affairType) {
		this.affairType = affairType;
	}

	public String getAffairId() {
		return affairId;
	}

	public void setAffairId(String affairId) {
		this.affairId = affairId;
	}

	public String getBeforeTransactor() {
		return beforeTransactor;
	}

	public void setBeforeTransactor(String beforeTransactor) {
		this.beforeTransactor = beforeTransactor;
	}


}