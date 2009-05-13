package com.baosight.base.struts.action;


import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IGovInfoPubMgr;
import com.baosight.base.service.IWrit2Mgr;
import com.baosight.mode.TbWrit2;
import com.baosight.struts.action.BaseDispatchAction;

public class Writ2Action extends BaseDispatchAction {
	
	private IWrit2Mgr writ2Mgr;
	private IGovInfoPubMgr govInfoPubMgr;
	private Date defaultDate = new Date(System.currentTimeMillis());
	public IWrit2Mgr getWrit2Mgr() {
		return writ2Mgr;
	}

	public void setWrit2Mgr(IWrit2Mgr writ2Mgr) {
		this.writ2Mgr = writ2Mgr;
	}

	public ActionForward getWrit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
        
		String writId = request.getParameter("writId");
		String busId = request.getParameter("busId");
		TbWrit2 tbWrit2 = writ2Mgr.findById(writId);
		request.setAttribute("tbWrit2", tbWrit2);
		request.setAttribute("govInfoPub", govInfoPubMgr.findById(busId));

		return mapping.findForward("showdetail");
	}
	
	public ActionForward  CreateWrit2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		TbWrit2 tbWrit2 =  new TbWrit2();
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit2.setApplydate(applydate);
		tbWrit2.setBusId(request.getParameter("busId"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit2.setCreatedate(createdate);
		tbWrit2.setQtxs(request.getParameter("qtxs"));
		tbWrit2.setSjzm(request.getParameter("sjzm"));
		tbWrit2.setTjxs(request.getParameter("tjxs"));
		tbWrit2.setWsh(request.getParameter("wsh"));
		writ2Mgr.save(tbWrit2);
		return mapping.findForward("success");
	}
	
	public ActionForward  UpdateWrit2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String writId = request.getParameter("id");
		TbWrit2 tbWrit2 = writ2Mgr.findById(writId);
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit2.setApplydate(applydate);
		tbWrit2.setBusId(request.getParameter("busId"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit2.setCreatedate(createdate);
		tbWrit2.setQtxs(request.getParameter("qtxs"));
		tbWrit2.setSjzm(request.getParameter("sjzm"));
		tbWrit2.setTjxs(request.getParameter("tjxs"));
		tbWrit2.setWsh(request.getParameter("wsh"));
		
		writ2Mgr.update(tbWrit2);
		
		return mapping.findForward("success");
	}

	public IGovInfoPubMgr getGovInfoPubMgr() {
		return govInfoPubMgr;
	}

	public void setGovInfoPubMgr(IGovInfoPubMgr govInfoPubMgr) {
		this.govInfoPubMgr = govInfoPubMgr;
	}
	
	
}
