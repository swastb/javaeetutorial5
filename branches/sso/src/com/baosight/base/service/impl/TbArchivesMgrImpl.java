package com.baosight.base.service.impl;

import java.io.Serializable;
import java.util.List;

import com.baosight.base.dao.ITbArchivesDAO;
import com.baosight.base.service.ITbArchivesMgr;
import com.baosight.mode.TbArchives;
import com.baosight.mode.TbUser;



public class TbArchivesMgrImpl  implements  ITbArchivesMgr{

	private ITbArchivesDAO tbArchivesDAO;

	public void save(TbArchives transientInstance) {
		tbArchivesDAO.save(transientInstance);
	}
	public void update(TbArchives transientInstance) {
		tbArchivesDAO.update(transientInstance);
	}
	public void delete(TbArchives persistentInstance) {
		tbArchivesDAO.delete(persistentInstance);
	}

	public TbArchives findById(java.lang.String id) {
		return tbArchivesDAO.findById(id);
	}

	public List findByExample(TbArchives instance) {
		return tbArchivesDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbArchivesDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbArchivesDAO.findAll();
	}

	public ITbArchivesDAO getTbArchivesDAO() {
		return tbArchivesDAO;
	}

	public void setTbArchivesDAO(ITbArchivesDAO tbArchivesDAO) {
		this.tbArchivesDAO = tbArchivesDAO;
	}
	public List findOrderByCreateTime() {
		String hql="from TbArchives t where t.status='0' order by t.createTime desc";
		return this.tbArchivesDAO.findByHQL(hql, true, -1, -1);
	}
	public List findPigeonholedArchives(String userId) {
		 String	hql = "select t.id as archiveId, t.title,t.file_id,to_char(t.create_time,'yyyy-mm-dd hh:mm:ss') as createTime,a.applyor,a.result,a.id as applyId from tb_archives t"+
		  " left join tb_archives_apply a on t.id=a.archives_id where t.status='1' and "+
	      "  (a.applyor is null or a.applyor='" +userId+
	       "') union select t.id  as archiveId, t.title,t.file_id,to_char(t.create_time,'yyyy-mm-dd hh:mm:ss') as createTime,null,null,null from "+
	       " tb_archives t where not exists (select 1 from tb_archives b"+
				  " left join tb_archives_apply c on b.id=c.archives_id where b.id=t.id and b.status='1' and "+
	       " (c.applyor is null or c.applyor='"+userId+"')) and t.status='1' order by createTime desc";

		List objList = this.tbArchivesDAO.findByNativeSql(hql);
		return objList;
	}
	public List findAuditList() {
		 String	hql = "select (select u.name from tb_user u where u.id=t.applyor) as applyorName, to_char(t.apply_tiem,'yyyy-mm-dd hh:mm:ss') as applyTime, s.title,t.id,t.result,t.archives_id from tb_archives_apply"+ 
		 				" t left join tb_archives s on t.archives_id=s.id order by applyTime desc";

		List objList = this.tbArchivesDAO.findByNativeSql(hql);
		return objList;
	}
	public List findShenHeRole(String userId) {
		 String	hql = "select * from Tb_Role role"
		 	+" where role.id in("
		 	+" select userrole.roleid from Tb_User_Role userrole where userrole.userid='"+userId+"'"
		 	+") and role.code='DANGANSHENHE'";

		List objList = this.tbArchivesDAO.findByNativeSql(hql);
		return objList;
	}
	public List findByObjects(Object entity) {
		// TODO Auto-generated method stub
		List objList = this.tbArchivesDAO.findByObjects(entity);
		return objList;
	}
	public Object findById(Class entity, Serializable primaryKey) {
		// TODO Auto-generated method stub
		Object instance=this.tbArchivesDAO.findById(entity, primaryKey);
		return instance;
	}	
}