package com.baosight.base.service.impl;

import java.util.List;
import java.util.Set;

import com.baosight.base.dao.ITbDocSendDAO;
import com.baosight.base.dao.ITbDocUrgentDAO;
import com.baosight.base.dao.ITbDocsendControlDAO;
import com.baosight.base.dao.ITbDocsendListitemsDAO;
import com.baosight.base.dao.ITbDocsendSubjectDAO;
import com.baosight.base.service.IDocSendDealMgr;
import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;
import com.baosight.mode.TbUser;


public class DocSendDealMgrImpl implements IDocSendDealMgr {

	private ITbDocSendDAO tbDocSendDAO;
	private ITbDocsendControlDAO tbDocsendControlDAO;
	private ITbDocUrgentDAO tbDocUrgentDAO;
	private ITbDocsendListitemsDAO tbDocsendListitemsDAO;
	private ITbDocsendSubjectDAO tbDocsendSubjectDAO;
	
	/* 发文列表 */
	public List findDocSendList(TbUser user,String type) {
		
		String SQL = "select t1.doc_send_id,t1.id,t.file_title,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss')," +
				"to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t.doc_state,t1.state_type,to_char(t1.close_time,'yyyy-MM-dd hh24:mi:ss') " +
				"from tb_doc_send t,tb_docsend_control t1 " +
				"where t.id=t1.doc_send_id and t1.state='"+type+"' and t1.user_id='"+user.getId()+"' " +
				"order by t1.create_time desc,t1.input_time desc";
			
		return tbDocSendDAO.findBySql(SQL);
	}
	/*新起草的收文删除*/
	public void deleteSendDoc(String docId) {
		
		TbDocSend docSend = (TbDocSend)tbDocSendDAO.findById(docId);
		Set docControls = docSend.getTbDocsendControls();
		tbDocSendDAO.delete(docSend);
		for (int i=0;!docControls.isEmpty()&&i<docControls.toArray().length;i++)
		tbDocsendControlDAO.delete((TbDocsendControl)docControls.toArray()[i]);
		
	}
	
	/*上海市水务信息中心公文处理单（查看）*/
	public TbDocSend findSendDocById(String docId) {
		return tbDocSendDAO.findById(docId);
	}
	/* 审查流转单 */
	public List findSCLZDById(String docId) {
		String sql = "select t.file_title,t1.state_name,to_char(t1.create_time,'yyyy-MM-dd hh24:mi:ss'),to_char(t1.input_time,'yyyy-MM-dd hh24:mi:ss'),t1.close_time,t1.user_name,t1.id " +
				"from tb_doc_send t,TB_DOCSEND_CONTROL t1 " +
				"where t.id=t1.doc_send_id and t.id='"+docId+"' and t1.state='0' order by t1.close_time";
		return tbDocSendDAO.findBySql(sql);
		
	}
	/* 催办通知 --找被催办的相关人 */
	public List findPersonByDocId(String docId) {
		String sql = "select t.user_id from TB_DOCSEND_CONTROL t where t.doc_send_id='"+docId+"' and t.state='1'";
		List docConList = tbDocSendDAO.findBySql(sql);
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
		List list = tbDocSendDAO.findByHQL(hql, true, -1, -1);
		return list==null||list.isEmpty()?null:list;
	}
	
	/*判断该发文是否可以取回*/
	public boolean isCanRollBack(String docId,String closetime) {
		String sql = "select * from TB_DOCSEND_CONTROL model where model.DOC_SEND_ID='"+docId+"' " +
				"and model.state_type in ('2','3') and model.state in ('0','2') and model.close_time> to_date('"+closetime+"','yyyy-MM-dd hh24:mi:ss')";
		List docConList = tbDocSendDAO.findBySql(sql);
		if (docConList==null || docConList.isEmpty())
			return true;
		return false;
	}
	/*取回该发文*/
	public void docSendRollBack(String docId,TbUser user) {
		//从TB_DOCSEND_CONTROL先删除负责人报领导所选择的人的流程
		String hql = "from TbDocsendControl model where model.tbDocSend.id='"+docId+"' " +
				"and model.stateType in ('2','3') and model.state='1'";
		List docConList = tbDocSendDAO.findByHQL(hql,true,-1,-1);
		for (int i=0;!docConList.isEmpty()&&i<docConList.size();i++)
			tbDocsendControlDAO.delete((TbDocsendControl)docConList.get(i));
		//修改该负责人所处的流程状态
		String sql2 = "from TbDocsendControl model where model.tbDocSend.id='"+docId+"' " +
				"and model.userId='"+user.getId()+"'";
		List docSendControlList = tbDocSendDAO.findByHQL(sql2,true,-1,-1);
		TbDocsendControl docSendControl = (TbDocsendControl)docSendControlList.get(0);
		docSendControl.setState("2");
		tbDocsendControlDAO.attachDirty(docSendControl);
	}

	public List findUserByRoleList(String roleId,TbUser user) {
		String sql = "select t.userId,t.username,t.userlvl,t1.name,t.deptname from " +
				"(select u.id userId,d.id deptId,u.pst upst,u.name username,u.lvl userlvl,d.name deptname " +
				"from tb_user u,tb_dept d where u.dept_code=d.id "+getDeptSelect(user)+" and u.id in " +
				"(select ur.userid from tb_user_role ur where ur.roleid='"+roleId+"')) t,tb_pst t1 " +
				"where t.upst=t1.id(+)";
		return tbDocSendDAO.findBySql(sql);
	}

	private String getDeptSelect(TbUser user){
		if(user!=null){
			return " and d.id = '"+user.getDeptCode()+"' ";
		}else{
			return "";
		}
	}

	/*成文机关、主送、抄送*/
	public List findDeptList(String type) {
		return tbDocsendListitemsDAO.findByStyle(type);
	}
	
	/*主题词*/
	public List findTypeList(long style) {
		return tbDocsendSubjectDAO.findByStyle(new Long(style));
	}
	public List findGongWenTypeList(long style) {
		return tbDocsendListitemsDAO.findByStyle(new Long(style));
	}
	
	public ITbDocsendControlDAO gettbDocsendControlDAO() {
		return tbDocsendControlDAO;
	}

	public void settbDocsendControlDAO(ITbDocsendControlDAO tbDocsendControlDAO) {
		this.tbDocsendControlDAO = tbDocsendControlDAO;
	}

	public ITbDocSendDAO gettbDocSendDAO() {
		return tbDocSendDAO;
	}

	public void settbDocSendDAO(ITbDocSendDAO tbDocSendDAO) {
		this.tbDocSendDAO = tbDocSendDAO;
	}
	public ITbDocUrgentDAO getTbDocUrgentDAO() {
		return tbDocUrgentDAO;
	}
	public void setTbDocUrgentDAO(ITbDocUrgentDAO tbDocUrgentDAO) {
		this.tbDocUrgentDAO = tbDocUrgentDAO;
	}
	public ITbDocsendListitemsDAO getTbDocsendListitemsDAO() {
		return tbDocsendListitemsDAO;
	}
	public void setTbDocsendListitemsDAO(
			ITbDocsendListitemsDAO tbDocsendListitemsDAO) {
		this.tbDocsendListitemsDAO = tbDocsendListitemsDAO;
	}
	public ITbDocsendSubjectDAO getTbDocsendSubjectDAO() {
		return tbDocsendSubjectDAO;
	}
	public void setTbDocsendSubjectDAO(ITbDocsendSubjectDAO tbDocsendSubjectDAO) {
		this.tbDocsendSubjectDAO = tbDocsendSubjectDAO;
	}

}
