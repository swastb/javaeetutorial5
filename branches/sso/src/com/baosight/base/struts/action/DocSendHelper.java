package com.baosight.base.struts.action;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import com.baosight.struts.action.BaseDispatchAction;

/**
 * <p>Decription:DocSendHelperAction</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-13</p>
 */
public class DocSendHelper extends BaseDispatchAction{

	protected IDocSendMgr docSendMgr;

	public void setDocSendMgr(IDocSendMgr docSendMgr) {
		this.docSendMgr = docSendMgr;
	}

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String controlId = request.getParameter("controlId");
		TbDocsendControl control = docSendMgr.findControlById(controlId);
		doInput(control);
		TbDocSend item = docSendMgr.findById(control.getTbDocSend().getId());
		setBaseInfo((DynaActionForm) form,control,item);
		putCommonInfo(request,item);
		return mapping.findForward("goInput");
	}

	protected void doInput(TbDocsendControl control){
		if(IDocSendMgr.STATE_NEW.equals(control.getState())){
			control.setState(IDocSendMgr.STATE_DISPOSE);
			control.setInputTime(new Date(System.currentTimeMillis()));
			docSendMgr.saveControl(control);
			tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"302","minus");
			tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","add");
		}
	}

	protected void setBaseInfo(DynaActionForm form,TbDocsendControl control,TbDocSend item){
		if(control!=null){
			form.set("controlId", control.getId());
		}
		form.set("docId", item.getId());
		form.set("printUser", item.getPrintUser());
		form.set("sendMain", item.getSendMain());
		form.set("fileNo", item.getFileNo());
		form.set("fileTitle", item.getFileTitle());
		form.set("topicWord", item.getTopicWord());
		if(item.getFileDate()!=null){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			form.set("fileDate", df.format(item.getFileDate()));
		}
		form.set("sendSecond", item.getSendSecond());
		form.set("fileSecret", item.getFileSecret());
		form.set("draftOpinion", item.getDraftOpinion());
		form.set("sign", item.getSign());
		form.set("mainDraftUser", item.getMainDraftUser());
		form.set("signOpinion", item.getSignOpinion());
		form.set("fileNum", item.getFileNum());
		form.set("collateUser", item.getCollateUser());
		form.set("fileDept", item.getFileDept());
		form.set("mainChargeUser", item.getMainChargeUser());
		form.set("secret1", item.getSecret1());
		form.set("secret2", item.getSecret2());
		form.set("filePages", item.getFilePages());
		form.set("sendFileType", item.getSendFileType());
		form.set("officeDraftUser", item.getOfficeDraftUser());
		form.set("officeChargeUser", item.getOfficeChargeUser());
		form.set("mainSignDept", item.getMainSignDept());
		form.set("fileType", item.getFileType());
	}

	protected void putCommonInfo(HttpServletRequest request,TbDocSend item){
		request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCSEND));
		request.setAttribute("sclzdList", docSendMgr.findClosedControl(item.getId()));//查询审查流转单
		request.setAttribute("docfileList",docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCCONTEXT));
		putTreeRootId(request);
	}

	protected void putTreeRootId(HttpServletRequest request){
		TbUser user = getCurrentUser(request);
		if(IDocServiceMgr.DEPT_TYPE_INFO.equals(user.getUserdept())){
			request.setAttribute("treeRootId", DocActionHelper.DEPT_ID_INFO);
		}else if(IDocServiceMgr.DEPT_TYPE_SLZX.equals(user.getUserdept())){
			request.setAttribute("treeRootId", DocActionHelper.DEPT_ID_SLZX);
		}else{
			request.setAttribute("treeRootId", DocActionHelper.DEPT_ID_JUOA);
		}
	}

	protected DocAttachAction getAttachAction(){
		DocAttachAction docAttachAction = new DocAttachAction();
		docAttachAction.setDocAttachMgr(docAttachMgr);
		docAttachAction.setServlet(this.getServlet());
		return docAttachAction;		
	}
}
