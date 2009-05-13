package com.baosight.fax.service.impl;

import java.util.List;

import com.baosight.fax.bean.ListSearchBean;
import com.baosight.fax.dao.TbFaxQueryScheduleDAO;
import com.baosight.fax.mode.TbFaxSchedule;
import com.baosight.fax.service.QueryScheduleMgr;

public class QueryScheduleMgrImpl implements QueryScheduleMgr{
	TbFaxQueryScheduleDAO tbFaxQueryScheduleDAO;
	
	public List findListByCondition(String name,ListSearchBean searchBean) {
		String hql="";
		if(name.equals("all")){
			hql = "select t.file_name,t.sender,t.senddeptid,d.name,t.senddate,t.recman,t.fax,t.content,t.id from tb_fax_schedule t join tb_dept d on(t.senddeptid=d.id)" ;
			if(null!=searchBean){
				System.out.println("searchBean.getState()**********"+searchBean.getState());
				hql+="where state='"+searchBean.getState()+"' ";
				
				if(searchBean.getStartTime()!=null && !"".equals(searchBean.getStartTime().trim())){
					hql+="and senddate >= to_date('"+searchBean.getStartTime()+"','yyyy-mm-dd') ";
				}
				if(searchBean.getEndTime()!=null && !"".equals(searchBean.getEndTime().trim())){
					hql+="and senddate <= to_date('"+searchBean.getEndTime()+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
				}
				if(searchBean.getFaxNum()!=null && !"".equals(searchBean.getFaxNum().trim())){
					hql+="and fax='"+searchBean.getFaxNum()+"' ";
				}
				if(searchBean.getSendDeptId()!=null && !"".equals(searchBean.getSendDeptId().trim())){
					hql+="and senddeptid='"+searchBean.getSendDeptId()+"' ";
				}
				if(searchBean.getSender()!=null && !"".equals(searchBean.getSender().trim())){
					hql+="and sender='"+searchBean.getSender()+"' ";
				}
			}
		}else if(name.equals("deptNamelist")){
			hql = "select distinct t.senddeptid,d.name from tb_fax_schedule t join tb_dept d on(t.senddeptid=d.id)" ;
			
		}else if(name.equals("senderlist")){
			hql = "select distinct t.sender from tb_fax_schedule t " ;
			
		}
		/*StringBuffer hql = new StringBuffer(); 
		hql.append("select file_name ");
		hql.append(" from tb_fax_schedule ");*/
		//hql.append(" join tb_dept as d on(t.senddeptid=d.id)");
		
		/*"where state='"+searchBean.getState()+"' ";
		if(searchBean.getStartTime()!=null && !"".equals(searchBean.getStartTime().trim())){
			hql+="and senddate >= to_date('"+searchBean.getStartTime()+"','yyyy-mm-dd') ";
		}
		if(searchBean.getEndTime()!=null && !"".equals(searchBean.getEndTime().trim())){
			hql+="and senddate <= to_date('"+searchBean.getEndTime()+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
		if(searchBean.getFaxNum()!=null && !"".equals(searchBean.getFaxNum().trim())){
			hql+="and fax='"+searchBean.getFaxNum()+"' ";
		}*/
		
		return tbFaxQueryScheduleDAO.findBySql(hql);
	}

	public TbFaxSchedule findById(String id) {
		return tbFaxQueryScheduleDAO.findById(id);
	}
	
	public void setTbFaxQueryScheduleDAO(TbFaxQueryScheduleDAO tbFaxQueryScheduleDAO) {
		this.tbFaxQueryScheduleDAO = tbFaxQueryScheduleDAO;
	}	
}
