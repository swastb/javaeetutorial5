package com.baosight.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;

import com.baosight.SequenceFind;
import com.baosight.SequenceFindImpl;
import com.baosight.SequenceFinderFactory;

/**
 * 基础POJO，用意是通过SequenceFind接口提供灵活的id生成方案
 * @author ytr
 *
 */
public class BasePOJO {
	
	private SequenceFind sequenceFind;
	
	protected String id;
	
	public BasePOJO() {
		init();
		this.id = sequenceFind.getId();
	}
	
	protected void init() {
		this.sequenceFind = SequenceFinderFactory.getSequenceFinder();
	}
}
