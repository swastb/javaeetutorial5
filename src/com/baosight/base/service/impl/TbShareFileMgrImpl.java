package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbShareFileDAO;
import com.baosight.base.service.ITbShareFileMgr;
import com.baosight.mode.TbShareFile;



public class TbShareFileMgrImpl  implements ITbShareFileMgr{

	private ITbShareFileDAO tbShareFileDAO;

	public void save(TbShareFile transientInstance) {
		tbShareFileDAO.save(transientInstance);
	}

	public void update(TbShareFile transientInstance) {
		tbShareFileDAO.update(transientInstance);
	}
	public void delete(TbShareFile persistentInstance) {
		tbShareFileDAO.delete(persistentInstance);
	}

	public TbShareFile findById(java.lang.String id) {
		return tbShareFileDAO.findById(id);
	}
	
	public List findByProperty(String propertyName, Object value) {
		return tbShareFileDAO.findByProperty(propertyName, value);
	}
	public List findAll() {
		return tbShareFileDAO.findAll();
	}
	public List findShareFileList(String type,String userId) {
		String sql = "";
		if(type.equals("0")){
			sql = "select t.id, (select u.name from TB_USER u where u.id = t.userid) as upuser,"
				+ " t.explanation,t.originally_name,t.userid from tb_share_file t where (t.is_share = 0"
			       + " or t.userid='"+userId +"') and t.type in ('1','2','3','4','5')";	
		}else{
		sql = "select t.id, (select u.name from TB_USER u where u.id = t.userid) as upuser,"
			+ " t.explanation,t.originally_name,t.userid from tb_share_file t where (t.is_share = 0"
       + " or t.userid='"+userId +"') and t.type='"+type+"'";		
		}
     return tbShareFileDAO.findByNativeSql(sql);
	}
	public void setTbShareFileDAO(ITbShareFileDAO tbShareFileDAO) {
		this.tbShareFileDAO = tbShareFileDAO;
	}

}