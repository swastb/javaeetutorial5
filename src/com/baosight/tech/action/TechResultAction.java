package com.baosight.tech.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.baosight.tech.mode.TbTechResult;
import com.baosight.tech.service.ITechResultMgr;

/**
 * <p>Decription:TechResultAction</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechResultAction extends BaseDispatchAction {

	private ITechResultMgr techResultMgr;
	protected DocAttachAction attachAction;

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		if(infoId!=null && !"".equals(infoId)){
			TbTechResult item = techResultMgr.findById(infoId);
			setBaseInfo((DynaActionForm) form,item);
			request.setAttribute("files1", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_TECH_RESULT));
			request.setAttribute("files2", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_TECH_RESULT_TECH));
			request.setAttribute("files3", docAttachMgr.findByIdAndType(item.getId(), DocAttachAction.TYPE_TECH_RESULT_MANG));
		}
		return mapping.findForward("info");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		TbTechResult item = getBaseInfo((DynaActionForm)form);
		techResultMgr.save(item);
		getAttachAction().saveAttachFile(form, DocAttachAction.TYPE_TECH_RESULT, item.getId(),DocAttachAction.PATH_TECH);
		ActionForward actionForward = new ActionForward("/techResult.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		techResultMgr.delete(techResultMgr.findById(infoId));
		ActionForward actionForward = new ActionForward("/techResult.do?method=list");
		actionForward.setRedirect(true);
		return actionForward;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException{
		TbTechResult item = new TbTechResult();
		item.setItemName(request.getParameter("itemName"));
		item.setBearUnit(request.getParameter("bearUnit"));
		item.setItemPrincipal(request.getParameter("itemPrincipal"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = request.getParameter("startTime");
		if(time!=null && !"".equals(time)){
			item.setStartTime(df.parse(time));
		}
		time = request.getParameter("endTime");
		if(time!=null && !"".equals(time)){
			item.setEndTime(df.parse(time));
		}
		List list = techResultMgr.findForQuery(item);
		startPaging(list, null, request);
		return mapping.findForward("list");
	}

	protected void setBaseInfo(DynaActionForm form, TbTechResult item){
		form.set("plan", item.getPlan());
		form.set("id", item.getId());
		form.set("together", item.getTogether());
		form.set("itemBudget", item.getItemBudget());
		form.set("itemName", item.getItemName());
		form.set("itemInvest", item.getItemInvest());
		form.set("contentKey", item.getContentKey());
		form.set("issuePaper", item.getIssuePaper());
		form.set("itemPrincipal", item.getItemPrincipal());
		form.set("needSense", item.getNeedSense());
		form.set("workHeadway", item.getWorkHeadway());
		form.set("expectEffect", item.getExpectEffect());
		form.set("bearUnit", item.getBearUnit());
		form.set("itemFrom", item.getItemFrom());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(item.getStartTime()!=null){
			form.set("startTime", df.format(item.getStartTime()));
		}
		if(item.getEndTime()!=null){
			form.set("endTime", df.format(item.getEndTime()));
		}
	}

	protected TbTechResult getBaseInfo(DynaActionForm form) throws ParseException{
		TbTechResult item = null;
		String id = form.getString("id");
		if(id!=null && !"".equals(id)){
			item = techResultMgr.findById(id);
		}
		if(item == null){
			item = new TbTechResult();
		}
		item.setPlan(form.getString("plan"));
		item.setTogether(form.getString("together"));
		item.setItemBudget(form.getString("itemBudget"));
		item.setItemName(form.getString("itemName"));
		item.setItemInvest(form.getString("itemInvest"));
		item.setContentKey(form.getString("contentKey"));
		item.setIssuePaper(form.getString("issuePaper"));
		item.setItemPrincipal(form.getString("itemPrincipal"));
		item.setNeedSense(form.getString("needSense"));
		item.setWorkHeadway(form.getString("workHeadway"));
		item.setExpectEffect(form.getString("expectEffect"));
		item.setBearUnit(form.getString("bearUnit"));
		item.setItemFrom(form.getString("itemFrom"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = form.getString("startTime");
		if(time!=null && !"".equals(time)){
			item.setStartTime(df.parse(time));
		}
		time = form.getString("endTime");
		if(time!=null && !"".equals(time)){
			item.setEndTime(df.parse(time));
		}
		return item;
	}

	public void setTechResultMgr(ITechResultMgr techResultMgr) {
		this.techResultMgr = techResultMgr;
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
		attachTypeMap.put("discoure", DocAttachAction.TYPE_TECH_RESULT);
		attachTypeMap.put("tech", DocAttachAction.TYPE_TECH_RESULT_TECH);
		attachTypeMap.put("manage", DocAttachAction.TYPE_TECH_RESULT_MANG);
		return attachTypeMap;
	}
}
