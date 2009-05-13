package com.baosight.base.struts.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbArchivesApply;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class PigeonholedArchivesListAction extends BaseDispatchAction {
	public ActionForward pigeonholedArchivesList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List pigeonholedArchivesList = null;
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();
		pigeonholedArchivesList = super.tbArchivesMgr.findPigeonholedArchives(userId);
		
/*		TbUser user = (TbUser) request.getSession().getAttribute(
				"SYSTEM_USER_SESSION");
		String userId = user.getId();
		for (Iterator it = pigeonholedArchivesList.iterator(); it.hasNext();) {
			Object[] item = (Object[]) it.next();
			String applyor = (String) item[4];
			if (applyor != null && !applyor.equals(userId)) {
				it.remove();
			}
		}	*/
		List shenHeRole = super.tbArchivesMgr.findShenHeRole(userId);
		if(shenHeRole.size()==1)
			request.setAttribute("shenHeRole", "1");
		else
			request.setAttribute("shenHeRole", "0");	
		long count=pigeonholedArchivesList.size();
		startPagingCount(null, request,count);
		startPaging(pigeonholedArchivesList, null, request);
		return mapping.findForward("pigeonholedArchivesList");
	}
	//ÉêÇë²Ù×÷
	public ActionForward apply(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String archiveId = request.getParameter("archiveId");
		String applyor = request.getParameter("applyor");
		String applyId = request.getParameter("applyId");
		if(applyor==null||applyor.equals("null")){
			TbUser user = (TbUser) request.getSession().getAttribute(
			"SYSTEM_USER_SESSION");
			String userId = user.getId();		
			TbArchivesApply tbArchivesApply = new TbArchivesApply(userId,archiveId,new Date(),null,null,null,null);
			super.tbArchivesApplyMgr.save(tbArchivesApply);
		}else{
			TbArchivesApply tbArchivesApply = super.tbArchivesApplyMgr.findById(applyId);
			tbArchivesApply.setApplyTiem(new Date());
			tbArchivesApply.setAuditor(null);
			tbArchivesApply.setAuditTime(null);
			tbArchivesApply.setResult(null);
			super.tbArchivesApplyMgr.update(tbArchivesApply);
		}
		super.tbUserOpeationMgr.archiveApplySaveOrUpdate("add");
		return mapping.findForward("success");
	}
}
