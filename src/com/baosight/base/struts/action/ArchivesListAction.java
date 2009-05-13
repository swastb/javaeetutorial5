package com.baosight.base.struts.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbArchives;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class ArchivesListAction extends BaseDispatchAction {
	
	public ActionForward noPigeonholeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {	
		List noPigeonholeArchivesList=null;		
		noPigeonholeArchivesList=super.tbArchivesMgr.findOrderByCreateTime();		
//		for (Iterator it = noPigeonholeArchivesList.iterator(); it.hasNext();) {
//			TbArchives item = (TbArchives) it.next();
//			if ("1".equals(item.getStatus())) {
//				it.remove();
//			}
//		}
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();
		List shenHeRole = super.tbArchivesMgr.findShenHeRole(userId);
		if(shenHeRole.size()==1)
			request.setAttribute("shenHeRole", "1");
		else
			request.setAttribute("shenHeRole", "0");
		long count=0;
		count=noPigeonholeArchivesList.size();
		startPagingCount(null, request,count);
		startPaging(noPigeonholeArchivesList, null, request);
		return mapping.findForward("noPigeonholeList");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		TbArchives tbArchives = super.tbArchivesMgr.findById(id);
		super.tbArchivesMgr.delete(tbArchives);
		return mapping.findForward("success");
	}	
}
