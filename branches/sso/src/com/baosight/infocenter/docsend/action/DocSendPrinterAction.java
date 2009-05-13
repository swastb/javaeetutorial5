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

public class DocSendPrinterAction extends DocSendHelper {
	//文号、打印人、校对人、附件
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		Date nowTime = new Date(System.currentTimeMillis());
		TbDocsendControlXxzx control = docSendMgr.findControlById(controlId);
		TbDocSendXxzx item = docSendMgr.findById(control.getTbDocSendXxzx().getId());
		
		control.setState(IDocSendMgr.STATE_END);
		control.setCloseTime(nowTime);
		item.setFileNo((String) ((DynaActionForm) form).get("fileNo"));
		item.setPrintUser((String) ((DynaActionForm) form).get("printUser"));
		item.setCollateUser((String) ((DynaActionForm) form).get("collateUser"));
		item.setFileCategory((String) ((DynaActionForm) form).get("fileCategory"));
		item.setDocState(IDocSendMgr.STATE_NAME_END);
		
		docSendMgr.saveControl(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","minus");
		docSendMgr.save(item);
		
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOCSEND, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOCSEND);
		return mapping.findForward("disposedList");
	}
	
}
