package com.baosight.tech.action;

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

import com.baosight.base.struts.action.DocAttachAction;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tech.mode.TbTechStandard;
import com.baosight.tech.service.ITechStandardMgr;

/**
 * <p>Decription:TechStandardAction</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechStandardAction extends BaseDispatchAction {

	private ITechStandardMgr techStandardMgr;
	protected DocAttachAction attachAction;

	public void setTechStandardMgr(ITechStandardMgr techStandardMgr) {
		this.techStandardMgr = techStandardMgr;
	}

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		if(infoId!=null && !"".equals(infoId)){
			TbTechStandard item = techStandardMgr.findById(infoId);
			setBaseInfo((DynaActionForm) form,item);
			request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_TECH_STANDARD));
		}
		return mapping.findForward("info");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		TbTechStandard item = getBaseInfo((DynaActionForm)form);
		techStandardMgr.save(item);
		getAttachAction().saveAttachFile(form, DocAttachAction.TYPE_TECH_STANDARD, item.getId(),DocAttachAction.PATH_TECH);
		ActionForward actionForward = new ActionForward("/techStandard.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		techStandardMgr.delete(techStandardMgr.findById(infoId));
		ActionForward actionForward = new ActionForward("/techStandard.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException{
		TbTechStandard item = new TbTechStandard();
		item.setName(request.getParameter("name"));
		item.setPubDepartment(request.getParameter("pubDepartment"));
		String pubTime = request.getParameter("pubTime");
		if(pubTime!=null && !"".equals(pubTime)){
			DateFormat df = new SimpleDateFormat("yyyy-MM");
			item.setPubTime(df.parse(pubTime));
		}
		List list = techStandardMgr.findForQuery(item);
		startPaging(list, null, request);
		return mapping.findForward("list");
	}

	protected void setBaseInfo(DynaActionForm form, TbTechStandard item){
		form.set("id", item.getId());
		form.set("pubDepartment", item.getPubDepartment());
		form.set("content", item.getContent());
		form.set("levels", item.getLevels());
		if(item.getPubTime()!=null){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			form.set("pubTime", df.format(item.getPubTime()));
		}
		form.set("name", item.getName());
	}

	protected TbTechStandard getBaseInfo(DynaActionForm form) throws ParseException{
		TbTechStandard item = null;
		String id = form.getString("id");
		if(id!=null && !"".equals(id)){
			item = techStandardMgr.findById(id);
		}
		if(item == null){
			item = new TbTechStandard();
		}
		item.setPubDepartment(form.getString("pubDepartment"));
		item.setContent(form.getString("content"));
		item.setLevels(form.getString("levels"));
		item.setName(form.getString("name"));
		String pubTime = form.getString("pubTime");
		if(pubTime!=null && !"".equals(pubTime)){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			item.setPubTime(df.parse(pubTime));
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

}
