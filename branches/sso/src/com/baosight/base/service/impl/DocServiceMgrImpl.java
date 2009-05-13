package com.baosight.base.service.impl;

import java.sql.Date;
import java.util.List;

import com.baosight.base.dao.ITbArchivesDAO;
import com.baosight.base.dao.ITbDocArchiveCodeDAO;
import com.baosight.base.dao.ITbDocControlDAO;
import com.baosight.base.dao.ITbDocRecDAO;
import com.baosight.base.dao.ITbDocSendDAO;
import com.baosight.base.dao.ITbDocsendControlDAO;
import com.baosight.base.dao.ITbUserOpeationDAO;
import com.baosight.base.service.IDocSendMgr;
import com.baosight.base.service.IDocServiceMgr;
import com.baosight.base.service.ITbDocRecMgr;
import com.baosight.base.service.ITbUserOpeationMgr;
import com.baosight.infocenter.docsend.dao.ITbDocSendXxzxDAO;
import com.baosight.infocenter.docsend.dao.ITbDocsendControlXxzxDAO;
import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;
import com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx;
import com.baosight.mode.TbArchives;
import com.baosight.mode.TbDocControl;
import com.baosight.mode.TbDocRec;
import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;
import com.baosight.mode.TbUser;

/**
 * <p>Decription:DocServiceMgrImpl</p>
 * @author heaton.cai
 * <p>Create Time:2008-7-31</p>
 */
public class DocServiceMgrImpl implements IDocServiceMgr {
	
	private ITbDocRecDAO tbDocRecDAO;
	private ITbDocSendDAO tbDocSendDAO;
	private ITbDocSendXxzxDAO tbDocSendXxzxDAO;
	private ITbDocControlDAO tbDocControlDAO;
	private ITbDocsendControlDAO tbDocsendControlDAO;
	private ITbDocsendControlXxzxDAO tbDocsendControlXxzxDAO;
	private ITbDocArchiveCodeDAO tbDocArchiveCodeDAO;
	private ITbArchivesDAO tbArchivesDAO;
	private ITbUserOpeationMgr tbUserOpeationMgr;

	private static final String BOOKER_ROLE_ID = "8a9981f11b776225011b777808610003";//登记人角色Id
	private static final String DISPOSER_ROLE_ID = "8a9981f11b776225011b7778f1a80004";//拟办人角色Id
	private static final String DEPT_HEADER_ROLE_ID = "8a9981f11b776225011b777a4e4a0006";//收文部门负责人角色Id

	//private static final String ;//归档权限的Id
	/**
	 * <p>Decription:该用户是否有归档权限</p>
	 * @param userid 用户Id
	 * @return 有返回true，否则false
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public boolean canArchive(String userid) {
		// TODO Auto-generated method stub
		
		return false;
	}
	/**
	 * <p>Decription:获取某部门的负责人</p>
	 * @param deptId TODO
	 * @return TbUser 部门的负责人，找不到返回nulll
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public TbUser getDeptDisposer(String deptId) {
		// TODO Auto-generated method stub
		String hql = "from TbUser u where exists (select u.id from TbUserRole userrole " +
				"where u.id=userrole.userid and userrole.roleid='"+DEPT_HEADER_ROLE_ID+"') and u.deptCode='"+deptId+"'";
		List list = tbDocRecDAO.findByHQL(hql,true,-1,-1);
		if (!list.isEmpty() && list!=null)
			return (TbUser)list.get(0);
		else
			return null;
	}
	/**
	 * <p>Decription:获取拟办人列表</p>
	 * @return List-TbUser 拟办人
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public List getDisposerList() {
		// TODO Auto-generated method stub
		String hql = "from TbUser u where exists (select u.id from TbUserRole userrole " +
				"where u.id=userrole.userid and userrole.roleid='"+DISPOSER_ROLE_ID+"')";
		return tbDocRecDAO.findByHQL(hql,true,-1,-1);
	}
	/**
	 * <p>Decription:判断该用户是否是拟办人或者登记人</p>
	 * @param userId 用户Id
	 * @return 是返回true，否则返回false
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public boolean isDisposerOrBooker(String userId) {
		return isDisposerOrBooker(userId,3);
	}
	
	public boolean isDisposerOrBooker(String userId,int type) {
		String sub_sql = "";
		if (type==1)
			sub_sql = "(userrole.roleid='"+BOOKER_ROLE_ID+"')";
		else if (type==2)
			sub_sql = "(userrole.roleid='"+DISPOSER_ROLE_ID+"')";
		else
			sub_sql = "(userrole.roleid='"+DISPOSER_ROLE_ID+"' or userrole.roleid='"+BOOKER_ROLE_ID+"')";
		String hql = "from TbUserRole userrole where userrole.userid='"+userId+"' and " +sub_sql;
		
		List list = tbDocRecDAO.findByHQL(hql,true,-1,-1);
		if (!list.isEmpty() && list!=null)
			return true;
		else
			return false;
	}

	public List findUserByRoleList(String roleId,TbUser user) {
		String sql = "select t.userId,t.username,t.userlvl,t1.name,t.deptname from " +
				"(select u.id userId,d.id deptId,u.pst upst,u.name username,u.lvl userlvl,d.name deptname " +
				"from tb_user u,tb_dept d where u.dept_code=d.id "+getDeptSelect(user)+" and u.id in " +
				"(select ur.userid from tb_user_role ur where ur.roleid='"+roleId+"')) t,tb_pst t1 " +
				"where t.upst=t1.id(+)";
		return tbDocRecDAO.findBySql(sql);
	}

	private String getDeptSelect(TbUser user){
		if(user!=null){
//			String str = "select t5.id from (select id,lvl from tb_dept " +
//			"start with id='"+user.getDeptCode()+"' " +
//			"connect by prior par_code=id and lvl='9f9083fe194fbea901194fc18da80006') t5 " +
//			"where t5.lvl='9f9083fe194fbea901194fc18da80006'";
//			return " and d.id in ("+str+") ";
			return " and u.userdept = '"+user.getUserdept()+"' ";
		}else{
			return "";
		}
	}

	public String copyRec2Send(String recId,TbUser user){
		TbDocRec rec = tbDocRecDAO.findById(recId);
		if(rec==null){
			return null;
		}
		if(DEPT_TYPE_JUOA.equals(user.getUserdept())){
			TbDocSend send = new TbDocSend();
			send.setFileTitle(rec.getDocName());
			send.setMainDraftUser(user.getName());
			send.setFileNo(rec.getDocCode());
			send.setFileNum(rec.getDocNum());
			send.setFilePages(rec.getDocPage());
			send.setFileType(rec.getDocType());
			send.setFileDate(rec.getWriteTime());
			send.setDocState(IDocSendMgr.STATE_NAME_NEWBOOK);
			tbDocSendDAO.save(send);
			Date nowTime = new Date(System.currentTimeMillis());
			TbDocsendControl sendControl = new TbDocsendControl();
			sendControl.setCreateTime(nowTime);
			sendControl.setInputTime(nowTime);
			sendControl.setState(IDocSendMgr.STATE_BOOKING);
			sendControl.setStateName(IDocSendMgr.STATE_NAME_NEWBOOK);
			sendControl.setStateType(IDocSendMgr.STATE_TYPE_DRAFTER);
			sendControl.setTbDocSend(send);
			sendControl.setUserId(user.getId());
			sendControl.setUserName(user.getName());
			tbDocsendControlDAO.save(sendControl);
			tbUserOpeationMgr.SaveOrUpdate(sendControl.getUserId(),"302","add");
			return sendControl.getId();
		}else{
			TbDocSendXxzx send = new TbDocSendXxzx();
			send.setFileTitle(rec.getDocName());
			send.setDraftUser(user.getName());
			send.setFileNo(rec.getDocCode());
			send.setFileNum(rec.getDocNum());
			send.setFilePages(rec.getDocPage());
			send.setFileType(rec.getDocType());
			send.setFileDate(rec.getWriteTime());
			send.setDocState(com.baosight.infocenter.docsend.service.IDocSendMgr.STATE_NAME_NEWBOOK);
			tbDocSendXxzxDAO.save(send);
			Date nowTime = new Date(System.currentTimeMillis());
			TbDocsendControlXxzx sendControl = new TbDocsendControlXxzx();
			sendControl.setCreateTime(nowTime);
			sendControl.setInputTime(nowTime);
			sendControl.setState(com.baosight.infocenter.docsend.service.IDocSendMgr.STATE_BOOKING);
			sendControl.setStateName(com.baosight.infocenter.docsend.service.IDocSendMgr.STATE_NAME_NEWBOOK);
			sendControl.setStateType(com.baosight.infocenter.docsend.service.IDocSendMgr.STATE_TYPE_DRAFTER);
			sendControl.setTbDocSendXxzx(send);
			sendControl.setUserId(user.getId());
			sendControl.setUserName(user.getName());
			tbDocsendControlXxzxDAO.save(sendControl);
			tbUserOpeationMgr.SaveOrUpdate(sendControl.getUserId(),"302","add");
			return sendControl.getId();
		}
	}

	public List findAllArchiveType() {
		return tbDocArchiveCodeDAO.findByStatus("OPEN");
	}

	public void save2Archives(TbDocRec item,TbUser user){
		if(item.getArchiveFlag()==1l){
			//已归档
			return;
		}
		TbArchives archive = new TbArchives();
		archive.setFileId(item.getDocCode());
		archive.setTitle(item.getDocName());
		//archive.setCreateDept(item.getDocDept());
		archive.setCreateDept(user.getDeptCode());
		archive.setCreateTime(new Date(System.currentTimeMillis()));
		archive.setStatus("0");
		tbArchivesDAO.save(archive);
		String sql = "update tb_doc_rec set archive_flag=1 where id='"+item.getId()+"'";
		tbDocRecDAO.exeSql(sql);
	}

	public void sendToInfoRec(TbDocSend send){
		TbUser recUser = new TbUser();
		recUser.setUserdept(DEPT_TYPE_INFO);
		List userList = findUserByRoleList(BOOKER_ROLE_ID, recUser);
		if(userList!=null && !userList.isEmpty()){
			Object[] u = (Object[]) userList.get(0);
			recUser.setId((String) u[0]);
			recUser.setName((String) u[1]);
		}
		TbDocRec rec = new TbDocRec();
		rec.setBookUser(recUser.getName());
		rec.setDocCode(send.getFileNo());
		rec.setDocDept(send.getFileDept());
		rec.setDocName(send.getFileTitle());
		rec.setDocState(ITbDocRecMgr.STATE_NAME_NEW);
		rec.setWriteTime(send.getFileDate());
		tbDocRecDAO.save(rec);
		TbDocControl control = new TbDocControl();
		control.setCreateTime(new Date(System.currentTimeMillis()));
		control.setState(ITbDocRecMgr.STATE_NEW);
		control.setStateName(ITbDocRecMgr.STATE_NAME_NEW);
		control.setStateType(ITbDocRecMgr.STATE_TYPE_NEW);
		control.setTbDocRec(rec);
		control.setUserId(recUser.getId());
		control.setUserName(recUser.getName());
		tbDocControlDAO.save(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"300","add");
	}

	public ITbDocRecDAO getTbDocRecDAO() {
		return tbDocRecDAO;
	}
	public void setTbDocRecDAO(ITbDocRecDAO tbDocRecDAO) {
		this.tbDocRecDAO = tbDocRecDAO;
	}
	public void setTbDocSendDAO(ITbDocSendDAO tbDocSendDAO) {
		this.tbDocSendDAO = tbDocSendDAO;
	}
	public void setTbDocArchiveCodeDAO(ITbDocArchiveCodeDAO tbDocArchiveCodeDAO) {
		this.tbDocArchiveCodeDAO = tbDocArchiveCodeDAO;
	}
	public void setTbDocsendControlDAO(ITbDocsendControlDAO tbDocsendControlDAO) {
		this.tbDocsendControlDAO = tbDocsendControlDAO;
	}
	public void setTbDocsendControlXxzxDAO(
			ITbDocsendControlXxzxDAO tbDocsendControlXxzxDAO) {
		this.tbDocsendControlXxzxDAO = tbDocsendControlXxzxDAO;
	}
	public void setTbDocSendXxzxDAO(ITbDocSendXxzxDAO tbDocSendXxzxDAO) {
		this.tbDocSendXxzxDAO = tbDocSendXxzxDAO;
	}
	public void setTbArchivesDAO(ITbArchivesDAO tbArchivesDAO) {
		this.tbArchivesDAO = tbArchivesDAO;
	}
	public void setTbDocControlDAO(ITbDocControlDAO tbDocControlDAO) {
		this.tbDocControlDAO = tbDocControlDAO;
	}
	public ITbUserOpeationMgr getTbUserOpeationMgr() {
		if(tbUserOpeationMgr==null){
			tbUserOpeationMgr = new TbUserOpeationMgrImpl();
		}
		return tbUserOpeationMgr;
	}
	public void setTbUserOpeationMgr(ITbUserOpeationMgr tbUserOpeationMgr) {
		this.tbUserOpeationMgr = tbUserOpeationMgr;
	}
	public void setTbUserOpeationDAO(ITbUserOpeationDAO tbUserOpeationDAO) {
		((TbUserOpeationMgrImpl)getTbUserOpeationMgr()).setTbUserOpeationDAO(tbUserOpeationDAO);
	}

}
