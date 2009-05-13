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
import com.baosight.mode.TbUser;

public class DocSendLeaderAction extends DocSendHelper {
	//签发、办公室核稿人、办公室负责人、附件等
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		Date nowTime = new Date(System.currentTimeMillis());
		TbDocsendControlXxzx control = docSendMgr.findControlById(controlId);
		TbDocSendXxzx item = docSendMgr.findById(control.getTbDocSendXxzx().getId());
		control.setState(IDocSendMgr.STATE_END);
		control.setCloseTime(nowTime);
		docSendMgr.saveControl(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","minus");
		TbUser officer = docSendMgr.getPrinter();
		if(officer==null){
			request.setAttribute("errorString", "未找到文印室负责人！");
			request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCSEND));
			return mapping.getInputForward();
		}
		TbDocsendControlXxzx nextControl = new TbDocsendControlXxzx();
		nextControl.setTbDocSendXxzx(item);
		nextControl.setCreateTime(nowTime);
		nextControl.setState(IDocSendMgr.STATE_NEW);
		nextControl.setStateName(IDocSendMgr.STATE_NAME_PRINTER);
		nextControl.setStateType(IDocSendMgr.STATE_TYPE_PRINTER);
		nextControl.setUserId(officer.getId());
		nextControl.setUserName(officer.getName());
		docSendMgr.saveControl(nextControl);
		tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"302","add");
		item.setDocState(nextControl.getStateName());
		item.setSign((String) ((DynaActionForm) form).get("sign"));
		docSendMgr.save(item);
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOCSEND, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOCSEND);
		return mapping.findForward("disposedList");
	}

	public ActionForward rollBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Date nowTime = new Date(System.currentTimeMillis());
		String backControlId = request.getParameter("backControl");
		TbDocsendControlXxzx backControl = docSendMgr.findControlById(backControlId);
		if(backControl==null){
			request.setAttribute("errorString", "没有找到您选择的驳回接点");
			return mapping.getInputForward();
		}
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		TbDocsendControlXxzx control = docSendMgr.findControlById(controlId);
		if(control==null){
			request.setAttribute("errorString", "为找到当前接点！您不能再进行操作！");
			return mapping.getInputForward();
		}
		TbDocSendXxzx item = docSendMgr.findById(control.getTbDocSendXxzx().getId());
//		control.setState(IDocSendMgr.STATE_END);
//		control.setCloseTime(nowTime);
//		docSendMgr.saveControl(control);
		docSendMgr.deleteControl(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","minus");
		TbDocsendControlXxzx nextControl = new TbDocsendControlXxzx();
		nextControl.setTbDocSendXxzx(item);
		nextControl.setCreateTime(nowTime);
		nextControl.setState(IDocSendMgr.STATE_NEW);
		nextControl.setStateName(backControl.getStateName());
		nextControl.setStateType(backControl.getStateType());
		nextControl.setUserId(backControl.getUserId());
		nextControl.setUserName(backControl.getUserName());
		docSendMgr.saveControl(nextControl);
		tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"302","add");
		item.setDocState(nextControl.getStateName());
		docSendMgr.save(item);
		return mapping.findForward("newAndDoing");
	}

}
