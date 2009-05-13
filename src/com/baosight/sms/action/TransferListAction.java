package com.baosight.sms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.sms.mode.SmsTransferInfo;
import com.baosight.sms.mode.SmsTransferList;
import com.baosight.sms.service.TransferMgr;
import com.baosight.struts.action.BaseDispatchAction;

/**
 * <p>Decription:½ÓÊÕºÅÂëÄ£¿é</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-9</p>
 */
public class TransferListAction extends BaseDispatchAction {

	private TransferMgr transferMgr;

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String listId = request.getParameter("id");
		if(listId!=null && !"".equals(listId)){
			SmsTransferList item = transferMgr.findListById(listId);
			setBaseInfo((DynaActionForm) form,item);
		}
		putCommonInfo(request);
		return mapping.findForward("goInput");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String infoId = (String) ((DynaActionForm) form).get("receiveId");
		SmsTransferInfo info = transferMgr.findInfoById(infoId);
		String senderIds = request.getParameter("senderIds");
		if(senderIds!=null && !"".equals(senderIds)){
			String senderNames = request.getParameter("senderNames");
			String senderMobiles = request.getParameter("senderMobiles");
			String[] senderId = senderIds.split(",");
			String[] senderName = senderNames.split(",");
			String[] senderMobile = senderMobiles.split(",");
			for(int i=0;i<senderId.length;i++){
				if(senderId[i]!=null && !"".equals(senderId[i])){
					SmsTransferList item = new SmsTransferList();
					item.setSenderName(senderName[i]);
					item.setSenderMobile(senderMobile[i]);
					item.setSmsTransferInfo(info);
					transferMgr.saveList(item);
				}
			}
		}else{
			String listId = (String) ((DynaActionForm) form).get("id");
			SmsTransferList item = null;
			if(listId!=null && !"".equals(listId)){
				item = transferMgr.findListById(listId);
			}else{
				item = new SmsTransferList();
			}
			item.setSenderName((String)((DynaActionForm) form).get("senderName"));
			item.setSenderDept((String)((DynaActionForm) form).get("senderDept"));
			item.setSenderMobile((String)((DynaActionForm) form).get("senderMobile"));
			item.setSmsTransferInfo(info);
			transferMgr.saveList(item);
		}
		setBaseInfo((DynaActionForm) form,new SmsTransferList());
		putCommonInfo(request);
		return mapping.findForward("goInput");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String listId = (String) ((DynaActionForm) form).get("id");
		if(listId!=null && !"".equals(listId)){
			SmsTransferList item = transferMgr.findListById(listId);
			transferMgr.deleteList(item);
		}
		setBaseInfo((DynaActionForm) form,new SmsTransferList());
		putCommonInfo(request);
		return mapping.findForward("goInput");
	}

	private void setBaseInfo(DynaActionForm form,SmsTransferList item){
		form.set("id", item.getId());
		form.set("senderName", item.getSenderName());
		form.set("senderDept", item.getSenderDept());
		form.set("senderMobile", item.getSenderMobile());
		if(item.getSmsTransferInfo()!=null){
			form.set("receiveId", item.getSmsTransferInfo().getId());
		}else{
			form.set("receiveId", null);
		}
	}

	private void putCommonInfo(HttpServletRequest request) {
		SmsTransferList exa = new SmsTransferList();
		String temp = request.getParameter("queryName");
		temp="".equals(temp)?null:temp;
		exa.setSenderName(temp);
		temp = request.getParameter("queryMobile");
		temp="".equals(temp)?null:temp;
		exa.setSenderMobile(temp);
		temp = request.getParameter("queryReceivers");
		if(!"".equals(temp)){
			SmsTransferInfo info = new SmsTransferInfo();
			info.setId(temp);
			exa.setSmsTransferInfo(info);
		}
		request.setAttribute("list", transferMgr.findListByQuery(exa));
		request.setAttribute("receiveList", transferMgr.findInfoAll());
	}

	public ActionForward addressBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String type=request.getParameter("type");
		if(type==null || "".equals(type)){
			type="move_phone";
		}
		request.setAttribute("bookList", transferMgr.findAddBookList());
		request.setAttribute("personList", transferMgr.findBookPersonList(type));
		return mapping.findForward("addbook");
	}

	public void setTransferMgr(TransferMgr transferMgr) {
		this.transferMgr = transferMgr;
	}

}
