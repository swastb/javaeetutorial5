package com.baosight.base.struts.action;


import java.util.Map;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IGovInfoPubMgr;
import com.baosight.base.service.IWrit7Mgr;
import com.baosight.mode.TbWrit7;
import com.baosight.struts.action.BaseDispatchAction;

public class Writ7Action extends BaseDispatchAction {
	private Date defaultDate = new Date(System.currentTimeMillis());
	private IWrit7Mgr writ7Mgr;
	private IGovInfoPubMgr govInfoPubMgr;
	public IWrit7Mgr getWrit7Mgr() {
		return writ7Mgr;
	}

	public void setWrit7Mgr(IWrit7Mgr writ7Mgr) {
		this.writ7Mgr = writ7Mgr;
	}

	public ActionForward getWrit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
        
		String writId = request.getParameter("writId");
		String busId = request.getParameter("busId");
		TbWrit7 tbWrit7 = writ7Mgr.findById(writId);
		request.setAttribute("tbWrit7", tbWrit7);
		request.setAttribute("govInfoPub", govInfoPubMgr.findById(busId));
		return mapping.findForward("showdetail");
	}
	
	public ActionForward  CreateWrit7(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		TbWrit7 tbWrit7 =  new TbWrit7();
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit7.setApplydate(applydate);
		tbWrit7.setBusId(request.getParameter("busId"));
		tbWrit7.setCheckbox(request.getParameter("checkbox"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit7.setCreatedate(createdate);
		tbWrit7.setText1(request.getParameter("text1"));
		tbWrit7.setText2(request.getParameter("text2"));
		
		writ7Mgr.save(tbWrit7);
		return mapping.findForward("success");
	}
	
	public ActionForward  UpdateWrit7(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String writId = request.getParameter("id");
		TbWrit7 tbWrit7 = writ7Mgr.findById(writId);
		String strapplydate = request.getParameter("applydate");
		Date applydate = strapplydate.equals("")?defaultDate:Date.valueOf(strapplydate);
		tbWrit7.setApplydate(applydate);
		tbWrit7.setBusId(request.getParameter("busId"));
		tbWrit7.setCheckbox(request.getParameter("checkbox"));
		String createdateStr = request.getParameter("createdate");
		Date createdate = createdateStr.equals("")?defaultDate:Date.valueOf(createdateStr);
		tbWrit7.setCreatedate(createdate);
		tbWrit7.setText1(request.getParameter("text1"));
		tbWrit7.setText2(request.getParameter("text2"));
		
		writ7Mgr.update(tbWrit7);
		
		return mapping.findForward("success");
	}
	public IGovInfoPubMgr getGovInfoPubMgr() {
		return govInfoPubMgr;
	}

	public void setGovInfoPubMgr(IGovInfoPubMgr govInfoPubMgr) {
		this.govInfoPubMgr = govInfoPubMgr;
	}
}
