package com.baosight.tech.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.struts.action.DocAttachAction;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tech.mode.TbTechDiscoure;
import com.baosight.tech.service.ITechDiscoureMgr;

/**
 * <p>Decription:TechDiscoureAction</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechDiscoureAction extends BaseDispatchAction {
	private ITechDiscoureMgr techDiscoureMgr;
	protected DocAttachAction attachAction;

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		if(infoId!=null && !"".equals(infoId)){
			TbTechDiscoure item = techDiscoureMgr.findById(infoId);
			setBaseInfo((DynaActionForm) form,item);
			request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_TECH_DISCOURE));
		}
		return mapping.findForward("info");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		TbTechDiscoure item = getBaseInfo((DynaActionForm)form);
		item.setFabiaoshijian(new Date(System.currentTimeMillis()));
		techDiscoureMgr.save(item);
		getAttachAction().saveAttachFile(form, DocAttachAction.TYPE_TECH_DISCOURE, item.getId(),DocAttachAction.PATH_TECH);
		ActionForward actionForward = new ActionForward("/techDiscoure.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		techDiscoureMgr.delete(techDiscoureMgr.findById(infoId));
		ActionForward actionForward = new ActionForward("/techDiscoure.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		TbTechDiscoure item = new TbTechDiscoure();
		item.setA1(request.getParameter("sdate"));
		item.setPianming(request.getParameter("title"));
		item.setZuozhe1(request.getParameter("author"));
		item.setKanming(request.getParameter("kname"));
		List list = techDiscoureMgr.findForQuery(item);
		startPaging(list, null, request);
		return mapping.findForward("list");
	}

	protected void setBaseInfo(DynaActionForm form, TbTechDiscoure item){
		form.set("pianming", item.getPianming());
		form.set("danwei", item.getDanwei());
		form.set("guanjianci", item.getGuanjianci());
		form.set("a1", item.getA1());
		form.set("zhaiyao", item.getZhaiyao());
		form.set("qihao", item.getQihao());
		form.set("zuozhe1", item.getZuozhe1());
		form.set("id", item.getId());
		form.set("kanming", item.getKanming());
	}

	protected TbTechDiscoure getBaseInfo(DynaActionForm form){
		TbTechDiscoure item = null;
		String id = form.getString("id");
		if(id!=null && !"".equals(id)){
			item = techDiscoureMgr.findById(id);
		}
		if(item == null){
			item = new TbTechDiscoure();
		}
		item.setPianming(form.getString("pianming"));
		item.setDanwei(form.getString("danwei"));
		item.setGuanjianci(form.getString("guanjianci"));
		item.setA1(form.getString("a1"));
		item.setZhaiyao(form.getString("zhaiyao"));
		item.setQihao(form.getString("qihao"));
		item.setZuozhe1(form.getString("zuozhe1"));
		item.setKanming(form.getString("kanming"));
		return item;
	}
	public void setTechDiscoureMgr(ITechDiscoureMgr techDiscoureMgr) {
		this.techDiscoureMgr = techDiscoureMgr;
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
