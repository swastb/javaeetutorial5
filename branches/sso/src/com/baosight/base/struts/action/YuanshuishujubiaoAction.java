package com.baosight.base.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IYuanshuishujubiaoMgr;
import com.baosight.struts.action.BaseDispatchAction;

public class YuanshuishujubiaoAction extends BaseDispatchAction {

	protected IYuanshuishujubiaoMgr YuanshuishujubiaoMgr;

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String action = request.getParameter("action");
		String[] stationId = null;
		if ("list1".equals(action))
		{
			stationId = new String[13];
			stationId[0]="G000113";
			stationId[1]="G000114";
			stationId[2]="G000109";
			stationId[3]="G000205";
			stationId[4]="G000209";
			stationId[5]="G000210";
			stationId[6]="G000104";
			stationId[7]="G000111";
			stationId[8]="G000112";
			stationId[9]="G000208";
			stationId[10]="G000206";
			stationId[11]="G000207";
			stationId[12]="G000110";
		}
		else if ("list2".equals(action))
		{
			stationId = new String[4];
			stationId[0]="G000118";
			stationId[1]="G000119";
			stationId[2]="G000120";
			stationId[3]="G000117";
		}
		List<Object> yuanshuishujubiao = new ArrayList<Object>();
		for(int i=0;i<stationId.length;i++)
		{
			//²éÑ¯½á¹û
			yuanshuishujubiao.addAll(this.YuanshuishujubiaoMgr.findByStationId(stationId[i]));
		}
		request.setAttribute("yuanshuishujubiao", yuanshuishujubiao);
		return mapping.findForward("list");
	}

	public void setYuanshuishujubiaoMgr(IYuanshuishujubiaoMgr YuanshuishujubiaoMgr) {
		this.YuanshuishujubiaoMgr = YuanshuishujubiaoMgr;
	}

}
