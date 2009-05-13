package com.baosight.base.struts.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.service.IWarningPubMgr;
import com.baosight.mode.TbWarningPub;
import com.baosight.struts.action.BaseDispatchAction;


public class WarningPubAction extends BaseDispatchAction {

	protected IWarningPubMgr warningPubMgr;
	protected DocAttachAction attachAction;

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		if(infoId!=null && !"".equals(infoId)){
			TbWarningPub item = warningPubMgr.findById(infoId);
			setBaseInfo((DynaActionForm) form,item);
			request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_WARNING_PUB));
		}
		return mapping.findForward("info");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		TbWarningPub item = getBaseInfo((DynaActionForm)form);
		warningPubMgr.save(item);
		getAttachAction().saveAttachFile(form, DocAttachAction.TYPE_WARNING_PUB, item.getId(),DocAttachAction.PATH_WARING_PUB);
		ActionForward actionForward = new ActionForward("/warningPub.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		warningPubMgr.delete(infoId);
		ActionForward actionForward = new ActionForward("/warningPub.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		TbWarningPub item = new TbWarningPub();
		item.setSignal(request.getParameter("signal"));
		item.setResp(request.getParameter("resp"));
		try {
			String pubstart = request.getParameter("pubstart");
			String pubend = request.getParameter("pubend");
			if(pubstart!=null && !"".equals(pubstart) && pubend!=null && !"".equals(pubend)){
				item.setPubstart(dateFormat.parse(pubstart));
				item.setPubend(dateFormat.parse(pubend));
			}		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List list = warningPubMgr.findForQuery(item);
		long count =  list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);		
		return mapping.findForward("list");
	}

	protected void setBaseInfo(DynaActionForm form, TbWarningPub item){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		form.set("id", item.getId());
		form.set("signal", item.getSignal());
		form.set("resp", item.getResp());
		form.set("pubstart", dateFormat.format(item.getPubstart()));
		form.set("pubend", dateFormat.format(item.getPubend()));		
	}

	protected TbWarningPub getBaseInfo(DynaActionForm form){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		TbWarningPub item = null;
		String id = form.getString("id");
		if(id!=null && !"".equals(id)){
			item = warningPubMgr.findById(id);
		}
		if(item == null){
			item = new TbWarningPub();
		}
		item.setSignal(form.getString("signal"));
		item.setResp(form.getString("resp"));
		try {
			item.setPubstart(dateFormat.parse(form.getString("pubstart")));
			item.setPubend(dateFormat.parse(form.getString("pubend")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	protected DocAttachAction getAttachAction(){
		if(attachAction==null){
			attachAction = new DocAttachAction();
			attachAction.setDocAttachMgr(docAttachMgr);
			attachAction.setServlet(this.getServlet());
		}
		return attachAction;		
	}
	public void setWarningPubMgr(IWarningPubMgr warningPubMgr) {
		this.warningPubMgr = warningPubMgr;
	}
		
}
