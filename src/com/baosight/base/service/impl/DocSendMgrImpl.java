package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbDocSendDAO;
import com.baosight.base.dao.ITbDocsendControlDAO;
import com.baosight.base.service.IDocSendDealMgr;
import com.baosight.base.service.IDocSendMgr;
import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;
import com.baosight.mode.TbUser;

/**
 * <p>Decription:DocSendMgrImpl</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-13</p>
 */
public class DocSendMgrImpl implements IDocSendMgr {
	private ITbDocSendDAO tbDocSendDAO;
	private ITbDocsendControlDAO tbDocsendControlDAO;

	public void delete(TbDocSend instance) {
		tbDocSendDAO.delete(instance);
	}

	public TbDocSend findById(String id) {
		return tbDocSendDAO.findById(id);
	}

	public void save(TbDocSend instance) {
		if(instance.getId()==null || instance.getId().length()<1){
			tbDocSendDAO.save(instance);
		}else{
			tbDocSendDAO.merge(instance);
		}
	}

	public void deleteControl(TbDocsendControl instance) {
		tbDocsendControlDAO.delete(instance);
		
	}

	public TbDocsendControl findControlById(String controlId) {
		return tbDocsendControlDAO.findById(controlId);
	}

	public void saveControl(TbDocsendControl instance) {
		if(instance.getId()==null || instance.getId().length()<1){
			tbDocsendControlDAO.save(instance);
		}else{
			tbDocsendControlDAO.merge(instance);
		}

	}

	public List findActiveControl(String docId, String stateType) {
		String hsql = "from TbDocsendControl t where t.tbDocSend.id='"+docId+"' ";
		hsql += "and t.state in ('1','2') ";
		if(stateType!=null && stateType.length()>0){
			hsql += "and t.stateType='"+stateType+"'";
		}
		return tbDocSendDAO.findByHQL(hsql, true, -1, -1);
	}

	public TbUser getOfficeCharger() {
		DocSendDealMgrImpl mgr = new DocSendDealMgrImpl();
		mgr.settbDocSendDAO(tbDocSendDAO);
		List ocrList = mgr.findUserByRoleList(IDocSendDealMgr.LEADER, null);
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

	public TbUser getDrafter() {
		DocSendDealMgrImpl mgr = new DocSendDealMgrImpl();
		mgr.settbDocSendDAO(tbDocSendDAO);
		List ocrList = mgr.findUserByRoleList(IDocSendDealMgr.DRAFT, null);
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

	public TbUser getSignsender() {
		DocSendDealMgrImpl mgr = new DocSendDealMgrImpl();
		mgr.settbDocSendDAO(tbDocSendDAO);
		List ocrList = mgr.findUserByRoleList(IDocSendDealMgr.SIGNSEND, null);
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

	public List findClosedControl(String docId) {
		String hsql = "from TbDocsendControl t where t.tbDocSend.id='"+docId+"' ";
		hsql += "and t.state='0' order by t.closeTime";
		return tbDocSendDAO.findByHQL(hsql, true, -1, -1);
//		return tbDocsendControlDAO.findByProperty("tbDocSend.id", docId);
	}

	public void setTbDocsendControlDAO(ITbDocsendControlDAO tbDocsendControlDAO) {
		this.tbDocsendControlDAO = tbDocsendControlDAO;
	}

	public void setTbDocSendDAO(ITbDocSendDAO tbDocSendDAO) {
		this.tbDocSendDAO = tbDocSendDAO;
	}

}
