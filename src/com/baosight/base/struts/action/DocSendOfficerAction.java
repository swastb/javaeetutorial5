package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.service.IDocSendMgr;
import com.baosight.base.service.IDocServiceMgr;
import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;
import com.baosight.mode.TbUser;

public class DocSendOfficerAction extends DocSendHelper {
	//签发、办公室核稿人、办公室负责人、附件等
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		Date nowTime = new Date(System.currentTimeMillis());
		TbDocsendControl control = docSendMgr.findControlById(controlId);
		TbDocSend item = docSendMgr.findById(control.getTbDocSend().getId());
		control.setState(IDocSendMgr.STATE_END);
		control.setCloseTime(nowTime);
		List controlList = docSendMgr.findActiveControl(item.getId(), IDocSendMgr.STATE_TYPE_SIGN);
		if(controlList==null || controlList.isEmpty()){
			TbUser officer = docSendMgr.getDrafter();
			if(officer==null){
				request.setAttribute("errorString", "未找到办公室拟办人！");
				request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCSEND));
				return mapping.getInputForward();
			}
			TbDocsendControl nextControl = new TbDocsendControl();
			nextControl.setTbDocSend(item);
			nextControl.setCreateTime(nowTime);
			nextControl.setState(IDocSendMgr.STATE_NEW);
			nextControl.setStateName(IDocSendMgr.STATE_NAME_DRAFT);
			nextControl.setStateType(IDocSendMgr.STATE_TYPE_DRAFT);
			nextControl.setUserId(officer.getId());
			nextControl.setUserName(officer.getName());
			docSendMgr.saveControl(nextControl);
			tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"302","add");
			item.setDocState(nextControl.getStateName());
		}
		item.setOfficeDraftUser((String) ((DynaActionForm) form).get("officeDraftUser"));
		item.setOfficeChargeUser((String) ((DynaActionForm) form).get("officeChargeUser"));
		docSendMgr.saveControl(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","minus");
		docSendMgr.save(item);
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOCSEND, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOCSEND);
		return mapping.findForward("disposedList");
	}
}
