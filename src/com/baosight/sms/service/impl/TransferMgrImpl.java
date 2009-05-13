package com.baosight.sms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baosight.sms.bean.AddressBook;
import com.baosight.sms.bean.BookPerson;
import com.baosight.sms.dao.SmsTransferInfoDAO;
import com.baosight.sms.dao.SmsTransferListDAO;
import com.baosight.sms.mode.SmsTransferInfo;
import com.baosight.sms.mode.SmsTransferList;
import com.baosight.sms.service.TransferMgr;

/**
 * <p>Decription:¶ÌÐÅ×ª·¢</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-8</p>
 */
public class TransferMgrImpl implements TransferMgr {

	private SmsTransferInfoDAO infoDAO;
	private SmsTransferListDAO listDAO;

	public void saveInfo(SmsTransferInfo instance) {
		if(instance.getId()!=null && !"".equals(instance.getId())){
			infoDAO.merge(instance);
		}else{
			infoDAO.save(instance);
		}
	}

	public void deleteInfo(SmsTransferInfo persistentInstance) {
		infoDAO.delete(persistentInstance);
	}

	public SmsTransferInfo findInfoById(String id) {
		return infoDAO.findById(id);
	}

	public List findByExample(SmsTransferInfo instance){
		return infoDAO.findByExample(instance);
	}

	public List findInfoAll(){
		return infoDAO.findAll();
	}
	public List findListByExample(SmsTransferList instance){
		return listDAO.findByExample(instance);
	}

	public void saveList(SmsTransferList instance) {
		if(instance.getId()!=null && !"".equals(instance.getId())){
			listDAO.merge(instance);
		}else{
			listDAO.save(instance);
		}
	}

	public void deleteList(SmsTransferList persistentInstance) {
		listDAO.delete(persistentInstance);
	}

	public SmsTransferList findListById(String id) {
		return listDAO.findById(id);
	}

	public List findListByInfo(String infoId){
		return listDAO.findByProperty("smsTransferInfo.id", infoId);
	}

	public void deleteListByInfo(String infoId){
		String sql="delete from sms_transfer_list where transferid='"+infoId+"'";
		infoDAO.exeSql(sql);
	}

	public List findListByQuery(SmsTransferList instance){
		String hql = "from SmsTransferList where 1=1 ";
		String ct = "";
		if(instance.getSenderName()!=null
				&& !"".equals(instance.getSenderName())){
			ct+="and senderName='"+instance.getSenderName()+"' ";
		}
		if(instance.getSenderMobile()!=null
				&& !"".equals(instance.getSenderMobile())){
			ct+="and senderMobile='"+instance.getSenderMobile()+"' ";
		}
		if(instance.getSmsTransferInfo()!=null
				&& instance.getSmsTransferInfo().getId()!=null
				&& !"".equals(instance.getSmsTransferInfo().getId())){
			ct+="and transferid='"+instance.getSmsTransferInfo().getId()+"' ";
		}
		return infoDAO.findByHQL(hql+ct, true, -1, -1);
	}

	public List findAddBookList(){
		String sql = "select tt.id,tt.parentId,tt.name from " +
				"(select t.id,nvl(t.parent_id,'0A') parentId,t.name from tb_commonality_comm t) tt " +
				"start with parentId='0A' " +
				"connect by prior tt.id=tt.parentId " +
				"order by level";
		List list = infoDAO.findBySQL(sql);
		List bookList = new ArrayList();
		for(Object o:list){
			Object[] oo = (Object[]) o;
			AddressBook ab = new AddressBook();
			ab.setId((String)oo[0]);
			ab.setParentId((String)oo[1]);
			ab.setName((String)oo[2]);
			bookList.add(ab);
		}
		return bookList;
	}

	public List findBookPersonList(String type){
		String sql = "select id,nvl(com_parent_id,commonality_id) commId,name," +
				type +
				" from tb_commonality";
		List list = infoDAO.findBySQL(sql);
		List personList = new ArrayList();
		for(Object o:list){
			Object[] oo = (Object[]) o;
			BookPerson person = new BookPerson();
			person.setId((String)oo[0]);
			person.setGroupId((String)oo[1]);
			person.setName((String)oo[2]);
			person.setMobile((String)oo[3]);
			personList.add(person);
		}
		return personList;
	}

	public void setInfoDAO(SmsTransferInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}

	public void setListDAO(SmsTransferListDAO listDAO) {
		this.listDAO = listDAO;
	}

}
