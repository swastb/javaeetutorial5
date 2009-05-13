package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baosight.base.dao.ITbCommonalityDAO;
import com.baosight.base.service.ICommonalityMgr;
import com.baosight.mode.TbCommonality;

public class CommonalityMgrImpl implements ICommonalityMgr {

	private ITbCommonalityDAO tbCommonalityDAO;
	
	public ITbCommonalityDAO getTbCommonalityDAO() {
		return tbCommonalityDAO;
	}

	public void setTbCommonalityDAO(ITbCommonalityDAO tbCommonalityDAO) {
		this.tbCommonalityDAO = tbCommonalityDAO;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbCommonalityDAO.delete(this.findById(id));
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbCommonalityDAO.findAll();
	}

	public TbCommonality findById(String id) {
		// TODO Auto-generated method stub
		return this.tbCommonalityDAO.findById(id);
	}

	public void save(TbCommonality model) {
		// TODO Auto-generated method stub
		 this.tbCommonalityDAO.save(model);
	}

	public void updte(TbCommonality model) {
		// TODO Auto-generated method stub
		this.tbCommonalityDAO.update(model);
	}

	public List findByName(String parentid,String name,String phone,String duty,String remark) {
		
		StringBuilder hql = new StringBuilder()
		.append("select * from Tb_Commonality model where 1=1 ");
		if(name!=null && !"".equals(name)){
			hql.append(" and model.name like '%"+name+"%'");
		}
		if(phone!=null && !"".equals(phone)){  
			hql.append(" and model.move_Phone like '%"+phone+"%'");		
		}
		if(duty!=null && !"".equals(duty)){
			hql.append(" and model.duty like '%"+duty+"%'");
		}
		if(remark!=null && !"".equals(remark)){
			hql.append(" and model.remark like '%"+remark+"%'");
		}
//		String hql="from TbCommonality model where 1=1  model.name like '%"+name+"%' and model.movePhone like '%"+phone+"%' " +
//				"and model.duty like '%"+duty+"%' and model.remark like '%"+remark+"%'";
		return this.tbCommonalityDAO.findBySql(hql.toString());
	}
//	查询二级组下的所有通讯录
	public List findByNameAndPhone(String comParentId){
		return this.tbCommonalityDAO.findByNameAndPhone(comParentId);
	}
	
	public List findByCommId(String id){
		List list = new ArrayList();
		String sql = "select * from Tb_Commonality t1 where t1.commonality_Id in " +
				"(select t.id from tb_commonality_comm t start with t.id='"+id+"'" +
				"connect by prior t.id=t.parent_id)";
		return tbCommonalityDAO.findBySql(sql);
	}

	public List findByCommonalityId(String id){
		String hql = "from TbCommonality model where model.commonalityId='"+id+"' order by name";
		return tbCommonalityDAO.findByHQL(hql, true, -1, -1);
	}
	/**
	 * 保存对象并返回id
	 * @param model
	 */
	public String saveObjRetrunId(TbCommonality model) {
		return this.tbCommonalityDAO.saveObjRetrunId(model);
	}
	/**
	 * 根据一个组成员id删除所有组中的该成员
	 * @param userIdForZu
	 */
	public void deleteFromAllZu(String userIdForZu) {
		String hql = "from TbCommonality t where t.comParentId='"+userIdForZu+"'";
		List list = tbCommonalityDAO.findByHQL(hql, true, -1, -1);
		if (list!=null&&list.size()>0) {
			int size = list.size();
			for (int i=0;i<size;i++) {
				this.tbCommonalityDAO.delete((TbCommonality)list.get(i));
			}
		}
	}
	/**
	 * 根据一个组成员id找该成员所在的所有组
	 * @param userIdForZu
	 * @return
	 */
	public List findSelectedZuList(String userIdForZu) {
		String hql = "from TbCommonalityComm t1 where t1.id in " +
				"(select t.commonalityId from TbCommonality t where t.comParentId='"+userIdForZu+"')";
		return tbCommonalityDAO.findByHQL(hql, true, -1, -1);
	}
	
	public List findByIdReturnName(String id){
		return tbCommonalityDAO.findByIdReturnName(id);
	}

	public String checkMphone(String name, String fax) {
		if(name!=null && !"".equals(name)){
			String hql="from TbCommonality t where t.name="+name;
			TbCommonality tb=(TbCommonality) tbCommonalityDAO.findByHQL(hql, true, -1, -1);
			return tb.getMovePhone();
		}
		if(fax!=null && !"".equals(fax)){
			String hql="from TbCommonality t where t.fax='"+fax+"'";
			List tb=tbCommonalityDAO.findByHQL(hql, true, -1, -1);
			if(tb!=null && !tb.isEmpty()){
				TbCommonality  tb1=	(TbCommonality) tb.get(0);
				return tb1.getFax();
			}
		}
		return null;
	}
}
