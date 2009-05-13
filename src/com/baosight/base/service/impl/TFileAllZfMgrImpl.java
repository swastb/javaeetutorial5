package com.baosight.base.service.impl;

import java.util.Iterator;
import java.util.List;

import com.baosight.base.dao.ITFileAllZfDAO;
import com.baosight.base.service.TFileAllZfMgr;
import com.baosight.mode.TFileAllZf;

public class TFileAllZfMgrImpl implements TFileAllZfMgr {
	private ITFileAllZfDAO tbileAllZfDAO;

	public ITFileAllZfDAO getTbileAllZfDAO() {
		return tbileAllZfDAO;
	}

	public void setTbileAllZfDAO(ITFileAllZfDAO tbileAllZfDAO) {
		this.tbileAllZfDAO = tbileAllZfDAO;
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return tbileAllZfDAO.findAll();
	}

	public List findById(Long id) {
		//String hql = "from t_file_all_zf t order by t.createtime desc";
		List list = tbileAllZfDAO.findByHQL("select  substr(model.title,1,16),TO_CHAR(model.createtime,'mm-dd')  from TFileAllZf model  order by model.createtime desc", true, 1, 6);
		/*for(Iterator it = list.iterator();it.hasNext();){
			Object[] obj=(Object[])it.next();
			System.out.println(obj[0]+"-----------"+obj[1]);
		}*/

		System.out.println(list.size());
		return list;
/*		String hql = "from t_file_all_zf t order by t.createtime desc";
		tbileAllZfDAO.findByHQL(hql, true, -1, -1);
		return tbileAllZfDAO.findById(id);*/
	}
	
	public List findByIdList(Long id) {
		
		List list = tbileAllZfDAO.findByHQL("select  substr(model.title,1,16),TO_CHAR(model.createtime,'mm-dd')  from TFileAllZf model  order by model.createtime desc", true, 1, 30);
		

		System.out.println(list.size());
		return list;
		
	}
	
}
