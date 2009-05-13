package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbOaHolidayDAO;
import com.baosight.base.service.IOaHolidayMgr;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbOaHoliday;

public class OaHolidayMgrImpl implements IOaHolidayMgr {
	
	private ITbOaHolidayDAO oaHolidayDAO;

	public void delete(String id) {
		// TODO Auto-generated method stub
		TbOaHoliday item = this.oaHolidayDAO.findById(id);
		this.oaHolidayDAO.delete(item);

	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.oaHolidayDAO.findAll();
	}

	public TbOaHoliday findById(String id) {
		// TODO Auto-generated method stub
		return this.oaHolidayDAO.findById(id);
	}

	public void save(TbOaHoliday model) {
		// TODO Auto-generated method stub
		this.oaHolidayDAO.save(model);

	}

	public void updte(TbOaHoliday model) {
		// TODO Auto-generated method stub
		this.oaHolidayDAO.update(model);

	}

	public ITbOaHolidayDAO getOaHolidayDAO() {
		return oaHolidayDAO;
	}

	public void setOaHolidayDAO(ITbOaHolidayDAO oaHolidayDAO) {
		this.oaHolidayDAO = oaHolidayDAO;
	}

	public List listDate(String year, String month) {
		// TODO Auto-generated method stub
		return this.oaHolidayDAO.listDate(year, month);
	}
	
	public List findSysDate() {
		// TODO Auto-generated method stub
		return this.oaHolidayDAO.findSysDate();
	}
	
	public List findSunSat(String year) {
		 String	hql = "select t.d from (" + 
				 "select trunc(to_date('" + 
				 year + 
				 "-1-1','yyyy-MM-DD'), 'yyyy')+rownum-1 as d " +
				 "from dba_objects " + 
				 "where rownum < 367) t " +
				 "where to_char(t.d, 'yyyy') = to_char(to_date('" +
				 year + 
				 "-1-1','yyyy-MM-DD'), 'yyyy') " +
				 "and (trim(to_char(t.d, 'Day')) = 'ÐÇÆÚÈÕ' or trim(to_char(t.d, 'Day')) = 'ÐÇÆÚÁù')";

		List objList = oaHolidayDAO.findByNativeSql(hql);

		return objList;
	}

	public List findYearArb(String year,String arb) {
		 String	hql = "select t.id from tb_oa_holiday t " + 
		              "where to_char(t.holiday,'yyyy-MM-DD') like '%" + 
		              year + 
		              "%' and t.arb='" + 
		              arb + 
		              "'";

		 List objList = oaHolidayDAO.findByNativeSql(hql);

			return objList;

	}



}
