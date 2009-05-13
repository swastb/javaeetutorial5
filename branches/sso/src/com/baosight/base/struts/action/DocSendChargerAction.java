package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.Date;

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

public class DocSendChargerAction extends DocSendHelper {

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		Date nowTime = new Date(System.currentTimeMillis());
		TbDocsendControl control = docSendMgr.findControlById(controlId);
		TbDocSend item = docSendMgr.findById(control.getTbDocSend().getId());
		control.setState(IDocSendMgr.STATE_END);
		control.setCloseTime(nowTime);
		String chargerRadio = request.getParameter("chargerRidio");
		if("1".equals(chargerRadio)){
			String signUserId = request.getParameter("signUserId");
			String signUserName = request.getParameter("signUserName");
			String[] userIds = signUserId.split(",");
			String[] userNames = signUserName.split(",");
			for(int i=0;i<userIds.length;i++){
				TbDocsendControl nextControl = new TbDocsendControl();
				nextControl.setTbDocSend(item);
				nextControl.setCreateTime(nowTime);
				nextControl.setState(IDocSendMgr.STATE_NEW);
				nextControl.setStateName(IDocSendMgr.STATE_NAME_SIGN);
				nextControl.setStateType(IDocSendMgr.STATE_TYPE_SIGN);
				nextControl.setUserId(userIds[i]);
				nextControl.setUserName(userNames[i]);
				docSendMgr.saveControl(nextControl);
				tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"302","add");
			}
			item.setDocState(IDocSendMgr.STATE_NAME_SIGN);
		}else if("2".equals(chargerRadio)){
			TbUser officer = docSendMgr.getOfficeCharger();
			if(officer==null){
				request.setAttribute("errorString", "未找到局办公室负责人！");
				request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCSEND));
				return mapping.getInputForward();
			}
			TbDocsendControl nextControl = new TbDocsendControl();
			nextControl.setTbDocSend(item);
			nextControl.setCreateTime(nowTime);
			nextControl.setState(IDocSendMgr.STATE_NEW);
			nextControl.setStateName(IDocSendMgr.STATE_NAME_OFFICER);
			nextControl.setStateType(IDocSendMgr.STATE_TYPE_OFFICER);
			nextControl.setUserId(officer.getId());
			nextControl.setUserName(officer.getName());
			docSendMgr.saveControl(nextControl);
			tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"302","add");
			item.setDocState(nextControl.getStateName());
		}
		docSendMgr.saveControl(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","minus");
		item.setMainChargeUser((String) ((DynaActionForm)form).get("mainChargeUser"));
		item.setMainSignDept((String) ((DynaActionForm)form).get("mainSignDept"));
		docSendMgr.save(item);
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOCSEND, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOCSEND);
		return mapping.findForward("disposedList");
	}

}
