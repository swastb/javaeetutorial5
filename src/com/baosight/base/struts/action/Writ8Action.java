package com.baosight.base.struts.action;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IGovInfoPubMgr;
import com.baosight.base.service.IWrit8Mgr;
import com.baosight.mode.TbWrit8;
import com.baosight.struts.action.BaseDispatchAction;

public class Writ8Action extends BaseDispatchAction {
	
	private IWrit8Mgr writ8Mgr;
	private Date defaultDate = new Date(System.currentTimeMillis());
	private IGovInfoPubMgr govInfoPubMgr;
	public IWrit8Mgr getWrit8Mgr() {
		return writ8Mgr;
	}

	public void setWrit8Mgr(IWrit8Mgr writ8Mgr) {
		this.writ8Mgr = writ8Mgr;
	}

	public ActionForward getWrit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
        
		String writId = request.getParameter("writId");
		TbWrit8 tbWrit8 = writ8Mgr.findById(writId);
		String busId = request.getParameter("busId");
		request.setAttribute("tbWrit8", tbWrit8);
		request.setAttribute("govInfoPub", govInfoPubMgr.findById(busId));
		return mapping.findForward("showdetail");
	}
	
	public ActionForward  CreateWrit8(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		TbWrit8 tbWrit8 =  new TbWrit8();
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit8.setApplydate(applydate);
		tbWrit8.setBusId(request.getParameter("busId"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit8.setCreatedate(createdate);
		tbWrit8.setLxfs(request.getParameter("lxfs"));
		tbWrit8.setSjzm(request.getParameter("sjzm"));
		tbWrit8.setSqmc(request.getParameter("sqmc"));
		tbWrit8.setWsh(request.getParameter("wsh"));
		tbWrit8.setZx(request.getParameter("zx"));
		writ8Mgr.save(tbWrit8);
		return mapping.findForward("success");
	}
	
	public ActionForward  UpdateWrit8(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String writId = request.getParameter("id");
		TbWrit8 tbWrit8 = writ8Mgr.findById(writId);
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit8.setApplydate(applydate);
		tbWrit8.setBusId(request.getParameter("busId"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit8.setCreatedate(createdate);
		tbWrit8.setLxfs(request.getParameter("lxfs"));
		tbWrit8.setSjzm(request.getParameter("sjzm"));
		tbWrit8.setSqmc(request.getParameter("sqmc"));
		tbWrit8.setWsh(request.getParameter("wsh"));
		tbWrit8.setZx(request.getParameter("zx"));
		
		writ8Mgr.update(tbWrit8);
		
		return mapping.findForward("success");
	}
	public IGovInfoPubMgr getGovInfoPubMgr() {
		return govInfoPubMgr;
	}

	public void setGovInfoPubMgr(IGovInfoPubMgr govInfoPubMgr) {
		this.govInfoPubMgr = govInfoPubMgr;
	}
}
