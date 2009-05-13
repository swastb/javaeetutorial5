package com.baosight.base.service.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.baosight.base.dao.ITbDocControlDAO;
import com.baosight.base.dao.ITbDocInfoLevelSeqDAO;
import com.baosight.base.dao.ITbDocRecDAO;
import com.baosight.base.service.ITbDocRecMgr;
import com.baosight.mode.TbDocControl;
import com.baosight.mode.TbDocInfoLevelSeq;
import com.baosight.mode.TbDocInfoLevelSeqId;
import com.baosight.mode.TbDocRec;

/**
 * <p>Decription: TbDocRecMgrImpl</p>
 * @author Tong.Cai
 * <p>Create Time: 2008-07-31</p>
 */
public class TbDocRecMgrImpl implements ITbDocRecMgr {

	private ITbDocRecDAO tbDocRecDAO;
	private ITbDocControlDAO tbDocControlDAO;
	private ITbDocInfoLevelSeqDAO tbDocInfoLevelSeqDAO;


	public void delete(TbDocRec persistentInstance) {
		this.tbDocRecDAO.delete(persistentInstance);
	}

	public List findAll() {
		return this.tbDocRecDAO.findAll();
	}

	public List findByExample(TbDocRec instance) {
		return this.tbDocRecDAO.findByExample(instance);
	}

	public TbDocRec findById(String id) {
		return this.tbDocRecDAO.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		return this.tbDocRecDAO.findByProperty(propertyName, value);
	}


	public TbDocRec merge(TbDocRec detachedInstance) {
		return this.tbDocRecDAO.merge(detachedInstance);
	}

	public void save(TbDocRec transientInstance) {
		if(transientInstance.getId()!=null && transientInstance.getId().length()>0){
			this.tbDocRecDAO.merge(transientInstance);
		}else{
			this.tbDocRecDAO.save(transientInstance);
		}
	}

	public void saveControl(TbDocControl instance) {
		if(instance.getId()!=null && instance.getId().length()>0){
			this.tbDocControlDAO.merge(instance);
		}else{
			this.tbDocControlDAO.save(instance);
		}
	}

	public TbDocControl findControlById(String controlId) {
		return tbDocControlDAO.findById(controlId);
	}

	public TbDocControl findCuruserControl(String userId,String docId) {
		String hql = "from TbDocControl t where t.userId = '"+userId+"' "
		+"and t.tbDocRec.id = '"+docId+"' and t.state <> '0'";
		List list = tbDocRecDAO.findByHQL(hql,true,-1,-1);
		if (list!=null && !list.isEmpty())
			return (TbDocControl)list.get(0);
		else
			return null;
	}

	public List findAllInfoLevel() {
		return tbDocInfoLevelSeqDAO.findByProperty("id.codeYear", "2008");
	}

	public String getCurInfoLevel(String level) {
		Date now = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(now);
		TbDocInfoLevelSeqId id = new TbDocInfoLevelSeqId(level,year);
		TbDocInfoLevelSeq item = tbDocInfoLevelSeqDAO.findById(id);
		if(item==null){
			item = (TbDocInfoLevelSeq)tbDocInfoLevelSeqDAO.findByProperty("code", level).get(0);
			item.setId(id);
			item.setCurruntNum((long)0);
		}
		item.setCurruntNum(item.getCurruntNum()+1);
		tbDocInfoLevelSeqDAO.save(item);
		NumberFormat numFormat = new DecimalFormat("000");
		return level+"-"+numFormat.format(item.getCurruntNum().doubleValue());
	}

	public void deleteControl(TbDocControl instance) {
		tbDocControlDAO.delete(instance);
	}

	public List findNotClosedControl(String docId) {
		String hql = "from TbDocControl t where "
		+"t.tbDocRec.id = '"+docId+"' and t.state <> '0'";
		return tbDocRecDAO.findByHQL(hql,true,-1,-1);
	}

	public List findNotClosedControl(String docId,String stateType){
		String hql = "from TbDocControl t where "
			+ "t.tbDocRec.id = '"+docId+"' and t.state <> '0' "
			+" and t.stateType = '"+stateType+"'";
		return tbDocRecDAO.findByHQL(hql,true,-1,-1);
	}

	public List findDisposeNext(String docId){
		String hql = "from TbDocControl t where t.createTime>=("
			+"select max(t1.closeTime) from TbDocControl t1 "
			+"where t1.state = '0' and t1.stateType='0' "
			+"and t1.tbDocRec.id= '"+docId+"'"
			+") and t.tbDocRec.id='"+docId+"'";
		return tbDocRecDAO.findByHQL(hql, true,-1, -1); 
	}

	public List findNextControl(String docId) {
		return tbDocControlDAO.findByProperty("tbDocRec.id", docId);
	}

	public List findControl(String docId, String type) {
		String hql = "from TbDocControl t where "
			+"t.tbDocRec.id = '"+docId+"' and t.stateType = '"+type+"'";
		return tbDocRecDAO.findByHQL(hql,true,-1,-1);
	}

	public TbDocControl findBookControl(String docId){
		StringBuffer sb = new StringBuffer("from TbDocControl t ");
		sb.append("where t.tbDocRec.id='").append(docId).append("' ");
		sb.append("and state='0' and state_type='0' order by close_time");
		String hql = sb.toString();
		List list = tbDocRecDAO.findByHQL(hql,true,-1,-1);
		if(list!=null && list.size()>0){
			return (TbDocControl) list.get(0);
		}else{
			return null;
		}
	}

	public void setTbDocRecDAO(ITbDocRecDAO tbDocRecDAO) {
		this.tbDocRecDAO = tbDocRecDAO;
	}

	public void setTbDocControlDAO(ITbDocControlDAO tbDocControlDAO) {
		this.tbDocControlDAO = tbDocControlDAO;
	}

	public void setTbDocInfoLevelSeqDAO(ITbDocInfoLevelSeqDAO tbDocInfoLevelSeqDAO) {
		this.tbDocInfoLevelSeqDAO = tbDocInfoLevelSeqDAO;
	}

}
