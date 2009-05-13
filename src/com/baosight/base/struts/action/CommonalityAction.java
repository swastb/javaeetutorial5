package com.baosight.base.struts.action;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbCommonality;
import com.baosight.mode.TbCommonalityComm;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class CommonalityAction extends BaseDispatchAction {

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		long count=0;
		List commonalityList=null;
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String action = request.getParameter("action");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String duty=request.getParameter("duty");
		String remark=request.getParameter("remark");
		if(action!=null&&action.equals("selectByName"))
		{
			commonalityList=this.commonalityMgr.findByName(parentid,name, phone,duty,remark);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			request.setAttribute("duty", duty);
			request.setAttribute("remark", remark);
			count=commonalityList.size();
		}
		else
		{
			commonalityList=this.commonalityMgr.findByCommId(parentid);
			count=commonalityList.size();
		}
		request.setAttribute("p_name", p_name);	
		request.setAttribute("parentid", parentid);
		startPagingCount(null, request,count);
		startPaging(commonalityList, null, request);
		return mapping.findForward("list");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String parentid = request.getParameter("parentid");
		if (!"".equals(id)) {
			this.commonalityMgr.delete(id);
		}
		return new ActionForward("/commonalityaction.do?method=list&parentid="+parentid);
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		
		String action = request.getParameter("action");
		String parentid = request.getParameter("parentid");
		if (!"".equals(action)) {
			if (action.equals("add")) {
				
				request.setAttribute("parentid", parentid);
				return mapping.findForward("add");
				
			}
			if (action.equals("submit")) {
				
				String zuIdStr = request.getParameter("zuIds");
				String name = (String) ((DynaValidatorForm) form).get("name");
				String duty = (String) ((DynaValidatorForm) form).get("duty");
				String fax = (String) ((DynaValidatorForm) form).get("fax");
				String movePhone = (String) ((DynaValidatorForm) form).get("movePhone");	
				String remark = (String) ((DynaValidatorForm) form).get("remark");
				
				TbCommonalityComm item = this.commonalityCommMgr.findById(parentid);
				TbCommonality model = new TbCommonality();
				model = new TbCommonality(parentid,"",name,duty,fax,movePhone,remark,item.getName(),"");
				
				String userId = this.commonalityMgr.saveObjRetrunId(model);
				TbCommonality obj = this.commonalityMgr.findById(userId);
				obj.setComParentId(userId);
				this.commonalityMgr.updte(obj);
				zuIdStr = this.deleteParentId(zuIdStr,parentid);
				//多组添加start
				addUserForOtherZu(zuIdStr,null,obj);
				//多组添加end
				
				return new ActionForward("/commonalityaction.do?method=list&parentid="+parentid);
			}
		}
		return mapping.findForward("list");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		//TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		String parentid = request.getParameter("parentid");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String flag = request.getParameter("flag");
		if (action != null && action.equals("submit")) {
			String zuIdStr = request.getParameter("zuIds");
			String[] selectZuIdStr = request.getParameterValues("selectZuIdStr");
			
			String name = (String) ((DynaValidatorForm) form).get("name");
			String duty = (String) ((DynaValidatorForm) form).get("duty");
			String fax = (String) ((DynaValidatorForm) form).get("fax");
			String movePhone = (String) ((DynaValidatorForm) form).get("movePhone");
			String remark = (String) ((DynaValidatorForm) form).get("remark");
			
			TbCommonality item = new TbCommonality();//this.commonalityMgr.findById(id);
			
			item.setComParentId(id);
			item.setName(name);
			item.setDuty(duty);
			item.setFax(fax);
			item.setMovePhone(movePhone);
			item.setRemark(remark);	
			
			//this.commonalityMgr.delete(id);
			this.commonalityMgr.deleteFromAllZu(id);
			//多组添加start
			addUserForOtherZu(zuIdStr,selectZuIdStr,item);
			//多组添加end
			
			return new ActionForward("/commonalityaction.do?method=list&parentid="+parentid);
		} else {
			TbCommonality item = this.commonalityMgr.findById(id);
			if (id != null && !id.equals("")) {	
				
				((DynaValidatorForm) form).set("commonalityId", item.getCommonalityId());
				((DynaValidatorForm) form).set("comParentId", item.getComParentId());
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("duty", item.getDuty());
				((DynaValidatorForm) form).set("fax", item.getFax());
				((DynaValidatorForm) form).set("movePhone", item.getMovePhone());
				((DynaValidatorForm) form).set("remark", item.getRemark());
				((DynaValidatorForm) form).set("attr1", item.getAttr1() );
				((DynaValidatorForm) form).set("attr2", item.getAttr2());
				
			}
			if(flag.equals("modify"))
			{
				/*用户所分配的所有组*/
				List selectedZu = this.commonalityMgr.findSelectedZuList(item.getComParentId());
				
				request.setAttribute("selectedZu", selectedZu);
				request.setAttribute("parentid", parentid);
				return mapping.findForward("add");
			}
			else
			{
				return mapping.findForward("info");
			}
		}

	}
	public void addUserForOtherZu(String zuIdStr,String[] selectZuIdStr,TbCommonality item) {
		String[] zuIds = null;
		if (zuIdStr!=null&&!"".equals(zuIdStr))
			zuIds = zuIdStr.split(",");
		Set setIds = new HashSet();
		for (int i=0;selectZuIdStr!=null&&selectZuIdStr.length>0&&i<selectZuIdStr.length;i++)
			setIds.add(selectZuIdStr[i]);
		for (int j=0;zuIds!=null&&zuIds.length>0&&j<zuIds.length;j++) {
			setIds.add(zuIds[j]);
		}
		Object[] selectedIdS = setIds.toArray();
	
		for (int i=0;i<selectedIdS.length;i++) {
			TbCommonality obj = new TbCommonality();
			TbCommonalityComm itemComm = this.commonalityCommMgr.findById(selectedIdS[i].toString());
			obj =new TbCommonality(selectedIdS[i].toString(),item.getComParentId(),item.getName(),item.getDuty(),item.getFax(),item.getMovePhone(),item.getRemark(),itemComm.getName(),"");
			this.commonalityMgr.save(obj);
		}
	}
	public String deleteParentId(String zuIdStr,String parentid) {
		String[] zuIds = null;
		StringBuffer zuIdString = new StringBuffer("");
		if (zuIdStr!=null&&!"".equals(zuIdStr)) {
			zuIds = zuIdStr.split(",");
			for (int i=0;i<zuIds.length;i++) {
				if (!zuIds[i].equals(parentid))
					zuIdString.append(zuIds[i]).append(",");
			}
			String temp = zuIdString.toString();
			if ("".equals(temp))
				return null;
			return temp.substring(0,temp.lastIndexOf(","));
		}
		else return null;
	}
	/*public static void main (String[] args){
		Date d=new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("------"+df.format(d));
	}*/
}
