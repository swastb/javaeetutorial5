package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbPstlvl;
import com.baosight.struts.action.BaseDispatchAction;

/**
 * 职务等级管理Action 提供对职务等级实体的增删改查
 * 
 * @author ytr
 * 
 */
public class PstlvlAction extends BaseDispatchAction {

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List allPstlvl = this.pstlvlMgr.findAll();
		request.setAttribute("allpstlvl", allPstlvl);
		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {

			// 该职务修改后的名称
			String name = (String) ((DynaValidatorForm) form).get("name");
			String code = (String) ((DynaValidatorForm) form).get("code");

			TbPstlvl item = this.pstlvlMgr.find(id);
			// 该职务原来的职务名称
			String oldname = item.getName();

			item.setCode(code);
			// 该职务修改后的名称
			item.setName(name);

			// this.pstlvlMgr.update(item);

			// 职务(tb_pstlvl)等级修改时，根据其原name,在tb_pst表中查询所有lvl字段为原name的记录,并将这些记录的lvl字段值更新为新name
			this.pstlvlMgr.updateMore(item, oldname);

			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbPstlvl item = this.pstlvlMgr.find(id);
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("code", item.getCode());
				((DynaValidatorForm) form).set("id", item.getId());
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			TbPstlvl item = this.pstlvlMgr.find(id);
			// 该职务原来的职务名称
			String oldname = item.getName();

			// pstlvlMgr.delete(id);
			// 职务(tb_pstlvl)等级删除时，根据其原name,在tb_pst表中查询所有lvl字段为原name的记录,并将这些记录的lvl字段值清空
			pstlvlMgr.deleteMore(id,oldname);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String name = (String) ((DynaValidatorForm) form).get("name");
				String code = (String) ((DynaValidatorForm) form).get("code");
				TbPstlvl item = new TbPstlvl(name, code);
				this.pstlvlMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("list");
	}
}
