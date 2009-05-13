package com.baosight.infocenter.docsend.service.impl;

import java.util.List;

import com.baosight.infocenter.docsend.dao.ITbDocSendXxzxDAO;
import com.baosight.infocenter.docsend.dao.ITbDocsendControlXxzxDAO;
import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;
import com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx;
import com.baosight.infocenter.docsend.service.IDocSendDealMgr;
import com.baosight.infocenter.docsend.service.IDocSendMgr;
import com.baosight.mode.TbUser;

/**
 * <p>Decription:DocSendMgrImpl</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-13</p>
 */
public class DocSendMgrImpl implements IDocSendMgr {
	private ITbDocSendXxzxDAO tbDocSendDAO;
	private ITbDocsendControlXxzxDAO tbDocsendControlDAO;

	public void delete(TbDocSendXxzx instance) {
		tbDocSendDAO.delete(instance);
	}

	public TbDocSendXxzx findById(String id) {
		return tbDocSendDAO.findById(id);
	}

	public void save(TbDocSendXxzx instance) {
		if(instance.getId()==null || instance.getId().length()<1){
			tbDocSendDAO.save(instance);
		}else{
			tbDocSendDAO.merge(instance);
		}
	}

	public void deleteControl(TbDocsendControlXxzx instance) {
		tbDocsendControlDAO.delete(instance);
		
	}

	public TbDocsendControlXxzx findControlById(String controlId) {
		return tbDocsendControlDAO.findById(controlId);
	}

	public void saveControl(TbDocsendControlXxzx instance) {
		if(instance.getId()==null || instance.getId().length()<1){
			tbDocsendControlDAO.save(instance);
		}else{
			tbDocsendControlDAO.merge(instance);
		}

	}

	public List findActiveControl(String docId, String stateType) {
		String hsql = "from TbDocsendControlXxzx t where t.tbDocSendXxzx.id='"+docId+"' ";
		hsql += "and t.state in ('1','2') ";
		if(stateType!=null && stateType.length()>0){
			hsql += "and t.stateType='"+stateType+"'";
		}
		return tbDocSendDAO.findByHQL(hsql, true, -1, -1);
	}

	public List findClosedControl(String docId) {
		String hsql = "from TbDocsendControlXxzx t where t.tbDocSendXxzx.id='"+docId+"' ";
		hsql += "and t.state='0' order by t.closeTime";
		return tbDocSendDAO.findByHQL(hsql, true, -1, -1);
//		return tbDocsendControlDAO.findByProperty("tbDocSend.id", docId);
	}

	public TbUser getPrinter() {
		DocSendDealMgrImpl mgr = new DocSendDealMgrImpl();
		mgr.settbDocSendDAO(tbDocSendDAO);
		List ocrList = mgr.findUserByRoleList(IDocSendDealMgr.PRINTROOM, null);
		if(ocrList!=null && ocrList.size()>0){
			Object[] objs = (Object[]) ocrList.get(0);
			TbUser user = new TbUser();
			user.setId(String.valueOf(objs[0]));
			user.setName(String.valueOf(objs[1]));
			return user;
		}else{
			return null;
		}
	}

	public void setTbDocsendControlDAO(ITbDocsendControlXxzxDAO tbDocsendControlDAO) {
		this.tbDocsendControlDAO = tbDocsendControlDAO;
	}

	public void setTbDocSendDAO(ITbDocSendXxzxDAO tbDocSendDAO) {
		this.tbDocSendDAO = tbDocSendDAO;
	}

}
