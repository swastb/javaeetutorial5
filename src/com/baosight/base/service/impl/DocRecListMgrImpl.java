package com.baosight.base.service.impl;

import java.util.List;
import java.util.Set;

import com.baosight.base.dao.ITbDocControlDAO;
import com.baosight.base.dao.ITbDocRecDAO;
import com.baosight.base.dao.ITbDocUrgentDAO;
import com.baosight.base.service.IDocRecListMgr;
import com.baosight.mode.TbDocControl;
import com.baosight.mode.TbDocRec;
import com.baosight.mode.TbDocUrgent;
import com.baosight.mode.TbUser;


public class DocRecListMgrImpl implements IDocRecListMgr {

	private ITbDocRecDAO tbDocRecDAO;
	private ITbDocControlDAO tbDocControlDAO;
	private ITbDocUrgentDAO tbDocUrgentDAO;
	
	/* 新收到的收文 */
	public List findNewReceiveList(TbUser user) {
		String NEWRECEIVE_SQL = "select t.doc_name,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss'),to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t.doc_state,t1.doc_rec_id,t1.id,t1.state_type " +
				"from tb_doc_rec t,tb_doc_control t1 " +
				"where t.id=t1.doc_rec_id and t1.state='1' and t1.user_id='"+user.getId()+"' " +
				"order by t1.create_time desc,t1.input_time desc";
		
		return tbDocRecDAO.findBySql(NEWRECEIVE_SQL);
	}
	/*正在办理的收文*/
	public List findDisposingList(TbUser user) {
		String DISPOSING_SQL = "select t.doc_name,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss'),to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t.doc_state,t1.doc_rec_id,t1.id,t1.state_type " +
				"from tb_doc_rec t,tb_doc_control t1 " +
				"where t.id=t1.doc_rec_id and t1.state='2' and t1.user_id='"+user.getId()+"' " +
				"order by t1.create_time desc,t1.input_time desc";
		
		return tbDocRecDAO.findBySql(DISPOSING_SQL);
	}
	/*可监控的收文*/
	public List findCanMonitorList(TbUser user) {
		String CANMONITOR_SQL = "select t.doc_name,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss'),to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t.doc_state,t.id " +
				"from tb_doc_rec t,tb_doc_control t1 " +
				"where t.id=t1.doc_rec_id and t1.state='4' and t1.user_id='"+user.getId()+"' " +
				"order by t1.create_time desc,t1.input_time desc";
		
		return tbDocRecDAO.findBySql(CANMONITOR_SQL);
	}
	/*已办理的收文*/
	public List findDisposedList(TbUser user) {
		String DISPOSED_SQL = "select t.doc_name,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss'),to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t.doc_state,t.id " +
				"from tb_doc_rec t,tb_doc_control t1 " +
				"where t.id=t1.doc_rec_id and t1.state='0' and t1.user_id='"+user.getId()+"' " +
				"order by t1.create_time desc,t1.input_time desc";
		
		return tbDocRecDAO.findBySql(DISPOSED_SQL);
	}
	/*新起草的收文*/
	public List findBookingList(TbUser user) {
		String BOOKING_SQL = "select t.id,t.doc_name,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss'),to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t.doc_state " +
				"from tb_doc_rec t,tb_doc_control t1 " +
				"where t.id=t1.doc_rec_id and t1.state='3' and t1.user_id='"+user.getId()+"' " +
				"order by t1.create_time desc,t1.input_time desc";
		
		return tbDocRecDAO.findBySql(BOOKING_SQL);
	}

	/*新起草的收文删除*/
	public void deleteRecDoc(String docId) {
		
		TbDocRec docRec = (TbDocRec)tbDocRecDAO.findById(docId);
		Set docControls = docRec.getTbDocControls();
		tbDocRecDAO.delete(docRec);
		for (int i=0;!docControls.isEmpty()&&i<docControls.toArray().length;i++)
		tbDocControlDAO.delete((TbDocControl)docControls.toArray()[i]);
		
	}
	
	/*上海市水务信息中心公文处理单（查看）*/
	public TbDocRec findReceiveDocById(String docId) {
		return tbDocRecDAO.findById(docId);
	}
	/* 审查流转单 */
	public List findSCLZDById(String docId) {
		String sql = "select t.doc_name,t1.state_name,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss'),to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t1.close_time,t1.user_name,t1.id " +
				"from tb_doc_rec t,tb_doc_control t1 " +
				"where t.id=t1.doc_rec_id and t.id='"+docId+"' and t1.state='0' order by t1.close_time";
		return tbDocRecDAO.findBySql(sql);
		
	}
	/* 催办通知 --找被催办的相关人 */
	public List findPersonByDocId(String docId) {
		String sql = "select t.user_id from tb_doc_control t where t.doc_rec_id='"+docId+"' and t.state='1'";
		List docConList = tbDocRecDAO.findBySql(sql);
		StringBuffer userIdStrBuf = new StringBuffer("");
		
		if (docConList!=null) {
			int size = docConList.size();
			for (int i=0;size>0&&i<size;i++) {
				String item = (String)docConList.get(i);
				userIdStrBuf.append("'");
				userIdStrBuf.append(item);
				userIdStrBuf.append("',");
			}
		}
		String userIdStr = userIdStrBuf.append("'00'").toString();
			
		String hql = "from TbUser u where u.id in " +
				"("+userIdStr+")";
		List list = tbDocRecDAO.findByHQL(hql, true, -1, -1);
		return list==null||list.isEmpty()?null:list;
	}
	/* 催办通知 --保存 */
	public void saveDocUrgentObj(TbDocUrgent docUrgent) {
		tbDocUrgentDAO.save(docUrgent);
	}

	public ITbDocControlDAO getTbDocControlDAO() {
		return tbDocControlDAO;
	}

	public void setTbDocControlDAO(ITbDocControlDAO tbDocControlDAO) {
		this.tbDocControlDAO = tbDocControlDAO;
	}

	public ITbDocRecDAO getTbDocRecDAO() {
		return tbDocRecDAO;
	}

	public void setTbDocRecDAO(ITbDocRecDAO tbDocRecDAO) {
		this.tbDocRecDAO = tbDocRecDAO;
	}
	public ITbDocUrgentDAO getTbDocUrgentDAO() {
		return tbDocUrgentDAO;
	}
	public void setTbDocUrgentDAO(ITbDocUrgentDAO tbDocUrgentDAO) {
		this.tbDocUrgentDAO = tbDocUrgentDAO;
	}

}
