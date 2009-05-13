package com.baosight.base.struts.action;


import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IGovInfoPubMgr;
import com.baosight.base.service.IWrit4Mgr;
import com.baosight.mode.TbWrit4;
import com.baosight.struts.action.BaseDispatchAction;

public class Writ4Action extends BaseDispatchAction {
	
	private IWrit4Mgr writ4Mgr;
	private IGovInfoPubMgr govInfoPubMgr;
	private Date defaultDate = new Date(System.currentTimeMillis());

	public IWrit4Mgr getWrit4Mgr() {
		return writ4Mgr;
	}

	public void setWrit4Mgr(IWrit4Mgr writ4Mgr) {
		this.writ4Mgr = writ4Mgr;
	}

	public ActionForward getWrit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
        
		String writId = request.getParameter("writId");
		String busId = request.getParameter("busId");
		TbWrit4 tbWrit4 = writ4Mgr.findById(writId);
		request.setAttribute("tbWrit4", tbWrit4);
		request.setAttribute("govInfoPub", govInfoPubMgr.findById(busId));
		return mapping.findForward("showdetail");
	}
	
	public ActionForward  CreateWrit4(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		TbWrit4 tbWrit4 =  new TbWrit4();
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit4.setApplydate(applydate);
		tbWrit4.setBusId(request.getParameter("busId"));
		tbWrit4.setSjzm(request.getParameter("sjzm"));
		tbWrit4.setSqnc(request.getParameter("sqnc"));
		tbWrit4.setWsh(request.getParameter("wsh"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit4.setCreatedate(createdate);
		
		
		writ4Mgr.save(tbWrit4);
		return mapping.findForward("success");
	}
	
	public ActionForward  UpdateWrit4(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String writId = request.getParameter("id");
		TbWrit4 tbWrit4 = writ4Mgr.findById(writId);
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit4.setApplydate(applydate);
		tbWrit4.setBusId(request.getParameter("busId"));
		tbWrit4.setSjzm(request.getParameter("sjzm"));
		tbWrit4.setSqnc(request.getParameter("sqnc"));
		tbWrit4.setWsh(request.getParameter("wsh"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit4.setCreatedate(createdate);
		
		writ4Mgr.update(tbWrit4);
		
		return mapping.findForward("success");
	}
	public IGovInfoPubMgr getGovInfoPubMgr() {
		return govInfoPubMgr;
	}

	public void setGovInfoPubMgr(IGovInfoPubMgr govInfoPubMgr) {
		this.govInfoPubMgr = govInfoPubMgr;
	}
}
