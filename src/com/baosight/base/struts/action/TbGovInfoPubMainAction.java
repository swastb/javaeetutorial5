package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbGovInfoPub;
import com.baosight.struts.action.BaseDispatchAction;

/*
 * 待审核信息列表和申请详细信息ACTION
 */
public class TbGovInfoPubMainAction extends BaseDispatchAction {
	
	/*显示待审核的申请信息列表*/
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List RecordList=null;
		
		String action = request.getParameter("action");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		
		if (StringUtils.isNotBlank(action)&&action.equals("all")) 
			RecordList=this.tbGovInfoPubAuditMgr.findByProperty("status",1);
		long count=RecordList.size();
		startPagingCount(null, request,count);
		startPaging(RecordList, null, request);
		
		return mapping.findForward("list");
	}
	
	/*显示待审核的申请信息详细信息*/
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, SQLException, IOException {
		
		String id = request.getParameter("id");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		
		TbGovInfoPub  record = tbGovInfoPubMgr.findById(id);
		request.setAttribute("afterDate", record.getAttr2());
		request.setAttribute("record", record);
		
		if(null != isOrNotPrint && isOrNotPrint.equals("print")){
			return mapping.findForward("print");
		}else{
			return mapping.findForward("view");
		}
	}
	public ActionForward lookupGovInfoPub(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//String govInfoPubId = request.getParameter("bid");
		String govInfoPubId = request.getParameter("id");
		TbGovInfoPub  govInfoPub = tbGovInfoPubMgr.findById(govInfoPubId);
		request.setAttribute("govInfoPub", govInfoPub);
		return mapping.findForward("lookdeclare");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)){
			TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(id);
			tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(524288));
			this.infoAuditMgr.modifyStatus(tbGovInfoPub);
			//tbGovInfoPubMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	
	public ActionForward doc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		return mapping.findForward("doc");
	}
	
}
