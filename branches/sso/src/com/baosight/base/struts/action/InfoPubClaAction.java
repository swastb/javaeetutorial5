package com.baosight.base.struts.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbRole;
import com.baosight.mode.TbUser;


public class InfoPubClaAction extends InfoPubHelperAction {
	
	/* 取拦目列表 */
	public ActionForward clalist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String id = request.getParameter("id");
		String act = request.getParameter("act");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String claname = request.getParameter("claname");
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		List infoClaList = this.infoPubClaMgr.findByPIdClaName(parentid,claname==null?"":claname,user);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("act", act);
		request.setAttribute("p_name", p_name);
		long count =  infoClaList.size();
		startPagingCount(null, request,count);
		startPaging(infoClaList, null, request);
		return mapping.findForward("clalist");
	}
	/*排序*/
	public ActionForward upAndDownCla(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String nodeId = request.getParameter("nodeId");
		String id = request.getParameter("id");
		String type = request.getParameter("move");
		String name = request.getParameter("name");

		this.infoPubClaMgr.upAndDownCla(parentid,nodeId,type);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("p_name", p_name);

		return new ActionForward(
				"/infopubclaaction.do?method=clalist&p_name=" + p_name
						+ "&parentid=" + parentid);
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		String parentid = request.getParameter("parentid");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				long onlyTree = 1;
				long enable = 1;
				((DynaValidatorForm) form).set("onlyTree",onlyTree);
				((DynaValidatorForm) form).set("enable",enable);
				
				List roleList = this.infoPubClaMgr.getRolesForClaList();
				
				request.setAttribute("parentid", parentid);
				request.setAttribute("roleList", roleList);
			
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String code = (String) ((DynaValidatorForm) form).get("code");
				String name = (String) ((DynaValidatorForm) form).get("name");
				String remark = (String) ((DynaValidatorForm) form).get("rem");
				Long onlyTree = (Long) ((DynaValidatorForm) form).get("onlyTree");
				String[] roles = (String[])request.getParameterValues("roleId");
				long enable = 1;
				String type = request.getParameter("type");
				Date creattime = new Date();
				
				long deforder = this.infoPubClaMgr.getMaxDefOrder(parentid);

				TbInfoPubCla item = new TbInfoPubCla(name, code, parentid,
						creattime, deforder+1,onlyTree, enable,
						remark);
				if ("root".equals(type))
					 item.setAttr1(code);
				else item.setAttr1(type);
				
				Serializable id=this.infoPubClaMgr.save(item);
				
				this.infoPubClaMgr.disRolesForCla(id.toString(),roles);
					//id=this.infoPubClaMgr.save(item);

				String act = "add";
				
				return new ActionForward(
						"/infopubclaaction.do?method=clalist&parentid=" + parentid + "&id=" + id + "&name=" + name + "&act=" + act );
			}
		}
		return mapping.findForward("list");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String parentid = request.getParameter("parentid");
		if (action != null && action.equals("submit")) {
			String code = (String) ((DynaValidatorForm) form).get("code");
			String name = (String) ((DynaValidatorForm) form).get("name");
			String remark = (String) ((DynaValidatorForm) form).get("rem");
			Long onlyTree = (Long) ((DynaValidatorForm) form).get("onlyTree");
			String[] roles = (String[])request.getParameterValues("roleId");
			
			TbInfoPubCla item = this.infoPubClaMgr.findById(id);
			item.setName(name);
			item.setCode(code);
			item.setRem(remark);
			item.setOnlyTree(onlyTree);
			
			if (this.infoPubClaMgr.disRolesForCla(id,roles))
				this.infoPubClaMgr.updte(item);

			
			return new ActionForward(
					"/infopubclaaction.do?method=clalist&parentid=" + parentid + "&id=" + id + "&name=" + name );
		} else {
			if (id != null && !id.equals("")) {
				List seledRolesList = this.infoPubClaMgr.findRolesSeled(id);
				List unseledRolesList = this.infoPubClaMgr.findRolesUnSeled(id);
				TbInfoPubCla item = this.infoPubClaMgr.findById(id);
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("code", item.getCode());
				((DynaValidatorForm) form).set("rem", item.getRem());
				((DynaValidatorForm) form).set("onlyTree", item.getOnlyTree());
				((DynaValidatorForm) form).set("enable", item.getEnable());
				request.setAttribute("seledRolesList", seledRolesList);
				request.setAttribute("unseledRolesList", unseledRolesList);
				request.setAttribute("parentid", parentid);
				request.setAttribute("haveChildNum", item.getNode()+"");
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}
	
	
	public ActionForward modifyS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String parentid = request.getParameter("parentid");
		
			TbInfoPubCla item = this.infoPubClaMgr.findById(id);
			long enable = 1;
			item.setEnable(enable);
			String name = item.getName();
			
			this.infoPubClaMgr.updte(item);
			String act = "add";
			
			return new ActionForward(
					"/infopubclaaction.do?method=clalist&parentid=" + parentid + "&id=" + id + "&name=" + name + "&act=" + act  );

	}
	
	public ActionForward modifyC(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String parentid = request.getParameter("parentid");
		List item1 = this.infoPubClaMgr.findParentID_EnableIsTure(id);
		
		TbInfoPubCla item = this.infoPubClaMgr.findById(id);
		long enable = 0;
		item.setEnable(enable);
		String name = item.getName();
		
		if(item1.size()>0){
			
		}
		else{
			this.infoPubClaMgr.updte(item);
		}
		return new ActionForward(
				"/infopubclaaction.do?method=clalist&parentid=" + parentid + "&id=" + id + "&name=" + name  );

			
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String source = request.getParameter("source");
		String type = request.getParameter("type");//infopub or govinfopub
		//String oneormore = request.getParameter("oneormore");//public to one or more
		HttpSession session = request.getSession();
		List inforolesUserList = (List)session.getAttribute("inforolesUserList");
		String[] roleForCla = new String[inforolesUserList.size()];
		for (int i=0;!inforolesUserList.isEmpty()&&i<inforolesUserList.size();i++) {
			roleForCla[i] = ((TbRole)inforolesUserList.get(i)).getId();
		}
		if (!"govinfopub".equals(type))
			type = "root";
		TbInfoPubCla system = this.infoPubClaMgr.getRoot(type);
		///List claList = getClaList(system,roleForCla);
		List claList = this.infoPubClaMgr.getClaListTest(roleForCla,system.getId());

		//request.setAttribute("system", system);
		request.setAttribute("claList", claList);
		String roleId = request.getParameter("roleid");
		if (roleId != null && !roleId.equals("")) {
			request.setAttribute("roleid", roleId);
		}
		if (!"".equals(source)&&"doubleClaPub".equals(source)){
			String flag = request.getParameter("flag");
			if (flag != null && "modify".equals(flag)) {
				request.setAttribute("action", "modify");
			}
			return mapping.findForward("doubleClaSeclist");
		}
			
		else
			return mapping.findForward("treelist");
	}
	
	private List getClaList(TbInfoPubCla root,String[] roleForCla) {
		List result = new LinkedList();
		String rootId = root.getId();
		getChild(result, rootId,roleForCla);
		return result;
	}
	
	private void getChild(List result, String parentId,String[] roleForCla) {
		List children = getChildren(parentId,roleForCla);
		if (children.size() > 0) {
			result.addAll(children);
			Iterator iter = children.iterator();
			while (iter.hasNext()) {
				Object item = iter.next();
				if (item instanceof TbInfoPubCla) {
					getChild(result, ((TbInfoPubCla) item).getId(),roleForCla);
				}

			}
		}
	}
	
	private List getChildren(String parentId,String[] roleForCla) {
		List result = new LinkedList();
		result.addAll(infoPubClaMgr.getChildren(parentId,roleForCla));

		//result = this.sortList(result);
		return result;
	}
	
	public ActionForward maininfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("type", request.getParameter("type"));
		return mapping.findForward("maininfo");
	}

	public List sortList(List temp) {
		Object[] obj = temp.toArray();
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j < obj.length - i - 1; j++) { // 对邻接的元素进行比较，如果后面的小，就交换
				
					if (((TbInfoPubCla) obj[j]).getDefOrder().compareTo(
							((TbInfoPubCla) obj[j + 1]).getDefOrder()) > 0) {
						TbInfoPubCla tmp = new TbInfoPubCla();
						tmp = (TbInfoPubCla) obj[j];
						obj[j] = (TbInfoPubCla) obj[j + 1];
						obj[j + 1] = tmp;
					}
			}
		}
		return Arrays.asList(obj);
	}
	public ActionForward isCanNotDo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String claId = request.getParameter("claId");
		String rightcode = request.getParameter("rightcode");
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		boolean result = infoPubClaMgr.isCanNotdo(claId, rightcode, user.getId());
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=GBK");
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ActionForward temp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	/*信息简报*/
	public ActionForward xxjb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		return mapping.findForward("infopubframeset");
	}
	public ActionForward childclas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String parentid = request.getParameter("parentid");
		List childclas = this.infoPubClaMgr.findByParentIdOrder(parentid);
		request.setAttribute("childclas", childclas);
		return mapping.findForward("leftchildclas");
	}
}
