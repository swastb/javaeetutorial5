package com.baosight.sms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.sms.mode.SmsTransferInfo;
import com.baosight.sms.service.TransferMgr;
import com.baosight.struts.action.BaseDispatchAction;

/**
 * <p>Decription:短信转发人员管理</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-8</p>
 */
public class TransferInfoAction extends BaseDispatchAction{
	private TransferMgr transferMgr;

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = request.getParameter("id");
		if(infoId!=null && !"".equals(infoId)){
			SmsTransferInfo info = transferMgr.findInfoById(infoId);
			setBaseInfo((DynaActionForm) form,info);
		}
		putCommonInfo(request);
		return mapping.findForward("goInput");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = (String) ((DynaActionForm) form).get("id");
		SmsTransferInfo info = null;
		if(infoId!=null && !"".equals(infoId)){
			info = transferMgr.findInfoById(infoId);
		}else{
			info = new SmsTransferInfo();
		}
		info.setBz((String)((DynaActionForm) form).get("fee"));
		info.setReceiveMobile((String)((DynaActionForm) form).get("receiveMobile"));
		info.setReceiveDept((String)((DynaActionForm) form).get("receiveDept"));
		info.setReceiveName((String)((DynaActionForm) form).get("receiveName"));
		info.setReceiveType((String)((DynaActionForm) form).get("receiveType"));
		transferMgr.saveInfo(info);
		setBaseInfo((DynaActionForm) form,new SmsTransferInfo());
		putCommonInfo(request);
		return mapping.findForward("goInput");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = (String) ((DynaActionForm) form).get("id");
		if(infoId!=null && !"".equals(infoId)){
			SmsTransferInfo info = transferMgr.findInfoById(infoId);
			if(info!=null && info.getId().length()>0){
				transferMgr.deleteListByInfo(info.getId());
				transferMgr.deleteInfo(info);
			}
		}
		setBaseInfo((DynaActionForm) form,new SmsTransferInfo());
		putCommonInfo(request);
		return mapping.findForward("goInput");
	}

	private void setBaseInfo(DynaActionForm form,SmsTransferInfo info){
		form.set("id", info.getId());
		form.set("fee", info.getBz());
		form.set("receiveMobile", info.getReceiveMobile());
		form.set("receiveDept", info.getReceiveDept());
		form.set("receiveName", info.getReceiveName());
		form.set("receiveType", info.getReceiveType());
	}

	private void putCommonInfo(HttpServletRequest request) {
		SmsTransferInfo exa = new SmsTransferInfo();
		String temp = request.getParameter("queryName");
		temp="".equals(temp)?null:temp;
		exa.setReceiveName(temp);
		temp = request.getParameter("queryMobile");
		temp="".equals(temp)?null:temp;
		exa.setReceiveMobile(temp);
		request.setAttribute("list", transferMgr.findByExample(exa));
	}

	public void setTransferMgr(TransferMgr transferMgr) {
		this.transferMgr = transferMgr;
	}

}
