package com.baosight.base.service;

import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;

public interface IDocSendBookMgr {

	public void saveDocSend(TbDocSend instance);

	public void updateDocSend(TbDocSend instance);

	public TbDocSend findDocSendById(String id);

	public void saveDocSendControl(TbDocsendControl instance);

	public void updateDocSendControl(TbDocsendControl instance);
	
	public TbDocsendControl findDocSendControlById(String id);
	
	
}
