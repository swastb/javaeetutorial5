package com.baosight.common.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbIndividual;
import com.baosight.mode.TbIndividualComm;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

/**
 * <p>Decription:个人通讯录</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-20</p>
 */
public class IndividualTreeAction extends BaseDispatchAction{

	public ActionForward input(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return mapping.findForward("input");
	}

	public ActionForward showTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TbUser user = getCurrentUser(request);
		String parentId = request.getParameter("parentId");
		String type = request.getParameter("type");
		StringBuffer xml = new StringBuffer();
		Iterator iterator = null;
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		xml.append("<individual>\r\n");
//		xml.append("<isFirst>");
//		xml.append("<first>" + "false" + "</first>");
//		xml.append("</isFirst>");
		if(parentId==null || "".equals(parentId) || "0".equals(parentId)){
			parentId="0";
			List groupList = individualCommMgr.findForTree(user.getId());
			iterator = groupList.iterator();
			while (iterator.hasNext()) {
				xml.append("<item>\r\n");
				TbIndividualComm comm = (TbIndividualComm) iterator.next();
				xml.append("<id>" + comm.getId() + "</id>\r\n");
				xml.append("<name>" + comm.getName() + "</name>\r\n");
				xml.append("<parId>"+parentId+"</parId>\r\n");
				xml.append("<isnode>true</isnode>\r\n");
				xml.append("<isCheck>false</isCheck>\r\n");
				xml.append("</item>\r\n");
			}
		}else{
			List personList = individualMgr.findByGroupId(parentId);
			iterator = personList.iterator();
			while (iterator.hasNext()) {
				xml.append("<item>\r\n");
				TbIndividual comm = (TbIndividual) iterator.next();
				xml.append("<id>" + comm.getId() + "</id>\r\n");
				xml.append("<name>" + comm.getName() + "</name>\r\n");
				if("fax".equals(type)){
					xml.append("<mobile>" + comm.getFax() + "</mobile>\r\n");
				}else{
					xml.append("<mobile>" + comm.getMovePhone() + "</mobile>\r\n");
				}
				xml.append("<parId>"+parentId+"</parId>\r\n");
				xml.append("<isnode>false</isnode>\r\n");
				xml.append("<isCheck>false</isCheck>\r\n");
				xml.append("</item>\r\n");
			}
		}
		xml.append("</individual>");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/xml;charset=GBK");
		try {
			response.getWriter().print(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
