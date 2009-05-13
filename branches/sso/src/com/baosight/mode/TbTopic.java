package com.baosight.mode;

/**
 * TbTopic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TbTopic implements java.io.Serializable {

	// Fields

	private String topicId;
	private String topicName;
	private String rem;

	// Constructors

	/** default constructor */
	public TbTopic() {
	}

	/** full constructor */
	public TbTopic(String topicName, String rem) {
		this.topicName = topicName;
		this.rem = rem;
	}

	// Property accessors

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getRem() {
		return this.rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

}