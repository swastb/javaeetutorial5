package com.baosight.mode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbConsultationOnline entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbConsultationOnline implements java.io.Serializable {

	// Fields

	private String id;
	private String asker;
	private String askerEmail;
	private String askerPhone;
	private String subject;
	private String content;
	private Date askTime;
	private String response;
	private Date responseTime;
	private String responseor;
	private Long status;
	private Set tbPublicAffairTransacts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbConsultationOnline() {
	}

	/** full constructor */
	public TbConsultationOnline(String asker, String askerEmail,
			String askerPhone, String subject, String content, Date askTime,
			String response, Date responseTime, String responseor, Long status,
			Set tbPublicAffairTransacts) {
		this.asker = asker;
		this.askerEmail = askerEmail;
		this.askerPhone = askerPhone;
		this.subject = subject;
		this.content = content;
		this.askTime = askTime;
		this.response = response;
		this.responseTime = responseTime;
		this.responseor = responseor;
		this.status = status;
		this.tbPublicAffairTransacts = tbPublicAffairTransacts;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAsker() {
		return this.asker;
	}

	public void setAsker(String asker) {
		this.asker = asker;
	}

	public String getAskerEmail() {
		return this.askerEmail;
	}

	public void setAskerEmail(String askerEmail) {
		this.askerEmail = askerEmail;
	}

	public String getAskerPhone() {
		return this.askerPhone;
	}

	public void setAskerPhone(String askerPhone) {
		this.askerPhone = askerPhone;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAskTime() {
		return this.askTime;
	}

	public void setAskTime(Date askTime) {
		this.askTime = askTime;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public String getResponseor() {
		return this.responseor;
	}

	public void setResponseor(String responseor) {
		this.responseor = responseor;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Set getTbPublicAffairTransacts() {
		return this.tbPublicAffairTransacts;
	}

	public void setTbPublicAffairTransacts(Set tbPublicAffairTransacts) {
		this.tbPublicAffairTransacts = tbPublicAffairTransacts;
	}

}