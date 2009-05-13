package com.baosight.tech.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.struts.action.DocAttachAction;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tech.mode.TbTechMapShare;
import com.baosight.tech.service.ITechMapShareMgr;

/**
 * <p>Decription:TechMapShareAction</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechMapShareAction extends BaseDispatchAction {

	private ITechMapShareMgr techMapShareMgr;
	protected DocAttachAction attachAction;

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		if(infoId!=null && !"".equals(infoId)){
			TbTechMapShare item = techMapShareMgr.findById(infoId);
			setBaseInfo((DynaActionForm) form,item);
			request.setAttribute("files1", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_TECH_MAP_APPROVE));
			request.setAttribute("files2", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_TECH_MAP_AGBOOK));
		}
		return mapping.findForward("info");
	}
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		TbTechMapShare item = getBaseInfo((DynaActionForm)form);
		techMapShareMgr.save(item);
		getAttachAction().saveAttachFile(form, DocAttachAction.TYPE_TECH_MAP_APPROVE, item.getId(),DocAttachAction.PATH_TECH);
		ActionForward actionForward = new ActionForward("/techMapShare.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		techMapShareMgr.delete(techMapShareMgr.findById(infoId));
		ActionForward actionForward = new ActionForward("/techMapShare.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		TbTechMapShare item = new TbTechMapShare();
		item.setGetTime(request.getParameter("getTime"));
		item.setUnitName(request.getParameter("unitName"));
		List list = techMapShareMgr.findForQuery(item);
		startPaging(list, null, request);
		return mapping.findForward("list");
	}
	
	public void setTechMapShareMgr(ITechMapShareMgr techMapShareMgr) {
		this.techMapShareMgr = techMapShareMgr;
	}
	
	protected void setBaseInfo(DynaActionForm form, TbTechMapShare item){
		form.set("unitName", item.getUnitName());
		form.set("getTime", item.getGetTime());
		form.set("applyReason", item.getApplyReason());
		form.set("mapScope", item.getMapScope());
		form.set("mapContent", item.getMapContent());
		form.set("attachment1", item.getAttachment1());
		form.set("attachment2", item.getAttachment2());
		form.set("id", item.getId());
		
	}
	protected TbTechMapShare getBaseInfo(DynaActionForm form){
		TbTechMapShare item = null;
		String id = form.getString("id");
		if(id!=null && !"".equals(id)){
			item = techMapShareMgr.findById(id);
		}
		if(item == null){
			item = new TbTechMapShare();
		}
		item.setUnitName(form.getString("unitName"));
		item.setGetTime(form.getString("getTime"));
		item.setApplyReason(form.getString("applyReason"));
		item.setMapScope(form.getString("mapScope"));
		item.setMapContent(form.getString("mapContent"));
		item.setAttachment1(form.getString("attachment1"));
		item.setAttachment2(form.getString("attachment2"));
		return item;
	}

	protected DocAttachAction getAttachAction(){
		if(attachAction==null){
			attachAction = new DocAttachAction();
			attachAction.setDocAttachMgr(docAttachMgr);
			attachAction.setServlet(this.getServlet());
			attachAction.setNameFileMap(getAttachTypeMap());
		}
		return attachAction;		
	}

	private Map<String,String> getAttachTypeMap(){
		Map<String,String> attachTypeMap = new HashMap<String,String>();
		attachTypeMap.put("approve", DocAttachAction.TYPE_TECH_MAP_APPROVE);
		attachTypeMap.put("agbook", DocAttachAction.TYPE_TECH_MAP_AGBOOK);
		return attachTypeMap;
	}
}
