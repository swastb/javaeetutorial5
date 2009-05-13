package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbCommonalityComm;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class CommonalityCommAction extends BaseDispatchAction {

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		
		String action = request.getParameter("action");
		String parentId = request.getParameter("parentid");
		String name = request.getParameter("name");
		//String p_name = request.getParameter("p_name");
		
		List commonalityCommList=null;
		long count=0;
		//查询同一系统下的所有一级组名，显示到列表框
		//List commList=this.commonalityCommMgr.findByCommType(parentId,user.getUserdept(),"comm");
		//
		if(action!=null&&action.equals("comm"))
		{
			//在页面查询时显示的列表
			commonalityCommList=this.commonalityCommMgr.findByComm(parentId, name);
			request.setAttribute("name", name);
			count=commonalityCommList.size();
		}
		else
		{
			//第一次进入列表页面查询的列表
			commonalityCommList = this.commonalityCommMgr.findByCommType(parentId,user.getUserdept(),"comm");
			count=commonalityCommList.size();
		}
		
		request.setAttribute("parentId", parentId);
		//request.setAttribute("commList", commList);
		//request.setAttribute("p_name", p_name);	
		startPagingCount(null, request,count);
		startPaging(commonalityCommList, null, request);
		return mapping.findForward("list");
	}
	public ActionForward movePage2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		String parentId = request.getParameter("parentid");
		//查询某组及其子组名，显示到列表框
		List commList=this.commonalityCommMgr.findByCommType(parentId,user.getUserdept(),"comm");
		request.setAttribute("commList", commList);
		request.setAttribute("parentId", parentId);
		return super.movePage(mapping, form, request, response);
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String parentId = request.getParameter("parentId");
		String type = request.getParameter("type");
		if (!"".equals(id)) {
			this.commonalityCommMgr.delete(id);
			return new ActionForward("/commonalityCommAction.do?method=list&parentid="+parentId+"&type="+type);
		}
		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		
		String action = request.getParameter("action");
		String parentId = request.getParameter("parentid");
		String type = request.getParameter("type");
		if (!"".equals(action)) {
			if (action.equals("add")) {
				// 默认为启用
				((DynaValidatorForm) form).set("inuse", "1");
				TbCommonalityComm parentObj = this.commonalityCommMgr.findById(parentId);
				request.setAttribute("parentObj", parentObj);
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String typeT = request.getParameter("typeT");
				String parentIdt = (String) ((DynaValidatorForm) form)
						.get("parentId");
				String name = (String) ((DynaValidatorForm) form).get("name");

				Long inuse = Long.parseLong(((DynaValidatorForm) form).get(
						"inuse").toString());
				String remark = (String) ((DynaValidatorForm) form)
						.get("remark");

				TbCommonalityComm model = new TbCommonalityComm(parentIdt, name,
						inuse,user.getUserdept(), remark,typeT);
				this.commonalityCommMgr.save(model);
				return new ActionForward("/commonalityCommAction.do?method=list&parentid="+parentIdt+"&type="+typeT);
			}
		}
		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String parentId = (String) ((DynaValidatorForm) form)
					.get("parentId");
			String name = (String) ((DynaValidatorForm) form).get("name");
			Long inuse = Long.parseLong(((DynaValidatorForm) form).get("inuse")
					.toString());
			
			String remark = (String) ((DynaValidatorForm) form).get("remark");

			TbCommonalityComm item = this.commonalityCommMgr.findById(id);

			item.setParentId(parentId);
			item.setName(name);
			item.setInuse(inuse);
			item.setRemark(remark);

			this.commonalityCommMgr.updte(item);
			return new ActionForward("/commonalityCommAction.do?method=list&parentid="+parentId+"&type="+item.getAttr1());
		} else {
			if (id != null && !id.equals("")) {
				TbCommonalityComm item = this.commonalityCommMgr.findById(id);

				((DynaValidatorForm) form).set("parentId", item.getParentId());
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("inuse", item.getInuse()
						.toString());
				((DynaValidatorForm) form).set("remark", item.getRemark());

				if (item.getInuse().toString().equals("1")) {
					request.setAttribute("flag", "isInuse");
				}
				String parId = item.getParentId();
				TbCommonalityComm parentObj = this.commonalityCommMgr.findById(parId);
				request.setAttribute("parentObj", parentObj);
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}
	//组结构树 cjf 2008-10-23
	public ActionForward maininfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("type", request.getParameter("type"));
		return mapping.findForward("maininfo");
	}
	
	public ActionForward treeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String type = request.getParameter("type");
			String towhich = request.getParameter("towhich");
			
			List treeList = this.commonalityCommMgr.findCommTreeList(type);
			request.setAttribute("treeList", treeList);
			if (towhich!=null && !"".equals(towhich))
				return mapping.findForward("selectZu");
			else
				return mapping.findForward("treeList");
	}
	public ActionForward subscribeTreeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String type = request.getParameter("type");
			String towhich = request.getParameter("towhich");
			List treeList = this.commonalityCommMgr.findCommTreeList(type);
			request.setAttribute("treeList", treeList);
			if (towhich!=null && !"".equals(towhich))
				return mapping.findForward("subscribeTree");
			else
				return mapping.findForward("subscribeTree");
	}
}
