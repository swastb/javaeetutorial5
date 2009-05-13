package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbYuanshuishujubiaoDAO;
import com.baosight.base.service.IYuanshuishujubiaoMgr;

public class YuanshuishujubiaoMgrImpl implements IYuanshuishujubiaoMgr {

	private ITbYuanshuishujubiaoDAO tbYuanshuishujubiaoDAO;

	public List<Object> findByStationId(String stationId) {

		//sql×÷³É
		String sql=""
			+"	select y.stationid, g.name, to_char(y.datatime,' hh24:mi'), y.datavalue "
			+"	from gongshuiinfrastructure g, yuanshuishujubiao y "
			+"	where y.stationid='"+stationId
			+"'	and y.datatime=(select max(datatime) from yuanshuishujubiao where stationid='"+stationId+"')"
			+"	and y.stationid=g.station_id(+)";
		return tbYuanshuishujubiaoDAO.findBySql(sql);
	}

	public ITbYuanshuishujubiaoDAO getTbYuanshuishujubiaoDAO() {
		return tbYuanshuishujubiaoDAO;
	}

	public void setTbYuanshuishujubiaoDAO(ITbYuanshuishujubiaoDAO tbYuanshuishujubiaoDAO) {
		this.tbYuanshuishujubiaoDAO = tbYuanshuishujubiaoDAO;
	}

}
