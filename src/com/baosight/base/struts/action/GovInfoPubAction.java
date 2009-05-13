package com.baosight.base.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IGovInfoPubMgr;
import com.baosight.base.service.ITbGovInfoPubAuditMgr;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbGovInfoPubAudit;
import com.baosight.struts.action.BaseDispatchAction;

public class GovInfoPubAction extends BaseDispatchAction {
	
	private IGovInfoPubMgr govInfoPubMgr;
	private ITbGovInfoPubAuditMgr govInfoPubAuditMgr;

	public ActionForward getGovInfoPub(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
        String govInfoPubId = request.getParameter("id");

       TbGovInfoPub govInfoPub=getGovInfoPubMgr().findById(govInfoPubId);
		request.setAttribute("govInfoPub", govInfoPub);

		return mapping.findForward("showdetail");
	}

	public IGovInfoPubMgr getGovInfoPubMgr() {
		return govInfoPubMgr;
	}

	public void setGovInfoPubMgr(IGovInfoPubMgr govInfoPubMgr) {
		this.govInfoPubMgr = govInfoPubMgr;
	}
	
	public ActionForward createTbGovInfoPubAudit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
        String govInfoPubId = request.getParameter("bus_id");
        String status = request.getParameter("status");
        String remark = request.getParameter("remark");

       TbGovInfoPub govInfoPub=getGovInfoPubMgr().findById(govInfoPubId);
       TbGovInfoPubAudit tbGovInfoPubAudit = govInfoPub.getTbGovInfoPubAudit();
     
       if(tbGovInfoPubAudit!=null){
    	   //不同意的状态
    	   tbGovInfoPubAudit.setStatus(new Long(status));
           tbGovInfoPubAudit.setRem(remark);
           govInfoPubAuditMgr.update(tbGovInfoPubAudit);   
       }
       
		return mapping.findForward("success");
	}

	public ITbGovInfoPubAuditMgr getGovInfoPubAuditMgr() {
		return govInfoPubAuditMgr;
	}

	public void setGovInfoPubAuditMgr(ITbGovInfoPubAuditMgr govInfoPubAuditMgr) {
		this.govInfoPubAuditMgr = govInfoPubAuditMgr;
	}
}
