package com.baosight.base.struts.action;


import java.util.Map;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IGovInfoPubMgr;
import com.baosight.base.service.IWrit9Mgr;
import com.baosight.mode.TbWrit9;
import com.baosight.struts.action.BaseDispatchAction;

public class Writ9Action extends BaseDispatchAction {
	
	private IWrit9Mgr writ9Mgr;
	private IGovInfoPubMgr govInfoPubMgr;
	private Date defaultDate = new Date(System.currentTimeMillis());
	public IWrit9Mgr getWrit9Mgr() {
		return writ9Mgr;
	}

	public void setWrit9Mgr(IWrit9Mgr writ9Mgr) {
		this.writ9Mgr = writ9Mgr;
	}

	public ActionForward getWrit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
        
		String writId = request.getParameter("writId");
		String busId = request.getParameter("busId");
		TbWrit9 tbWrit9 = writ9Mgr.findById(writId);
		request.setAttribute("tbWrit9", tbWrit9);
		request.setAttribute("govInfoPub", govInfoPubMgr.findById(busId));
		return mapping.findForward("showdetail");
	}
	
	public ActionForward  CreateWrit9(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		TbWrit9 tbWrit9 =  new TbWrit9();
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit9.setApplydate(applydate);
		tbWrit9.setBusId(request.getParameter("busId"));
		tbWrit9.setSqmc(request.getParameter("sqmc"));
		tbWrit9.setSjzm(request.getParameter("sjzm"));
		tbWrit9.setWsh(request.getParameter("wsh"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit9.setCreatedate(createdate);
		
		
		writ9Mgr.save(tbWrit9);
		return mapping.findForward("success");
	}
	
	public ActionForward  UpdateWrit9(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String writId = request.getParameter("id");
		TbWrit9 tbWrit9 = writ9Mgr.findById(writId);
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit9.setApplydate(applydate);
		tbWrit9.setBusId(request.getParameter("busId"));
		tbWrit9.setSqmc(request.getParameter("sqmc"));
		tbWrit9.setSjzm(request.getParameter("sjzm"));
		tbWrit9.setWsh(request.getParameter("wsh"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit9.setCreatedate(createdate);
		
		writ9Mgr.update(tbWrit9);
		
		return mapping.findForward("success");
	}
	public IGovInfoPubMgr getGovInfoPubMgr() {
		return govInfoPubMgr;
	}

	public void setGovInfoPubMgr(IGovInfoPubMgr govInfoPubMgr) {
		this.govInfoPubMgr = govInfoPubMgr;
	}
}
