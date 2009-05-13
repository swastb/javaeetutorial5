package com.baosight.infocenter.docsend.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.service.IDocServiceMgr;
import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;
import com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx;
import com.baosight.infocenter.docsend.service.IDocSendMgr;

public class DocSendChargerAction extends DocSendHelper {

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		Date nowTime = new Date(System.currentTimeMillis());
		TbDocsendControlXxzx control = docSendMgr.findControlById(controlId);
		TbDocSendXxzx item = docSendMgr.findById(control.getTbDocSendXxzx().getId());
		String leaderId = request.getParameter("leaderId");
		String leaderName = request.getParameter("leaderName");
		if(leaderId==null || "".equals(leaderId)){
			request.setAttribute("errorString", "没有选择领导！");
			request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCSEND));
			return mapping.getInputForward();
		}
		control.setState(IDocSendMgr.STATE_END);
		control.setCloseTime(nowTime);
		docSendMgr.saveControl(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","minus");
		TbDocsendControlXxzx nextControl = new TbDocsendControlXxzx();
		nextControl.setTbDocSendXxzx(item);
		nextControl.setCreateTime(nowTime);
		nextControl.setState(IDocSendMgr.STATE_NEW);
		nextControl.setStateName(IDocSendMgr.STATE_NAME_LEADER);
		nextControl.setStateType(IDocSendMgr.STATE_TYPE_LEADER);
		nextControl.setUserId(leaderId);
		nextControl.setUserName(leaderName);
		docSendMgr.saveControl(nextControl);
		tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"302","add");
		item.setDocState(nextControl.getStateName());
		item.setChargeUser((String) ((DynaActionForm)form).get("chargeUser"));
		docSendMgr.save(item);
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOCSEND, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOCSEND);
		return mapping.findForward("disposedList");
	}

}
