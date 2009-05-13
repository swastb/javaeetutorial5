package com.baosight.infocenter.docsend.action;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.service.IDocServiceMgr;
import com.baosight.base.struts.action.DocActionHelper;
import com.baosight.base.struts.action.DocAttachAction;
import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;
import com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx;
import com.baosight.infocenter.docsend.service.IDocSendDealMgr;
import com.baosight.infocenter.docsend.service.IDocSendMgr;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

/**
 * <p>Decription:DocSendHelperAction</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-13</p>
 */
public class DocSendHelper extends BaseDispatchAction{

	protected IDocSendMgr docSendMgr;
	protected IDocSendDealMgr docSendDealXxzxMgr;
	protected DocAttachAction attachAction;

	public void setDocSendMgr(IDocSendMgr docSendMgr) {
		this.docSendMgr = docSendMgr;
	}

	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String controlId = request.getParameter("controlId");
		TbDocsendControlXxzx control = docSendMgr.findControlById(controlId);
		doInput(control);
		TbDocSendXxzx item = docSendMgr.findById(control.getTbDocSendXxzx().getId());
		setBaseInfo((DynaActionForm) form,control,item);
		putCommonInfo(request,item);
		return mapping.findForward("goInput");
	}

	protected void doInput(TbDocsendControlXxzx control){
		if(IDocSendMgr.STATE_NEW.equals(control.getState())){
			control.setState(IDocSendMgr.STATE_DISPOSE);
			control.setInputTime(new Date(System.currentTimeMillis()));
			docSendMgr.saveControl(control);
			tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","add");
			tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"302","minus");
		}
	}

	protected void setBaseInfo(DynaActionForm form,TbDocsendControlXxzx control,TbDocSendXxzx item){
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
		form.set("sign", item.getSign());
		form.set("fileNum", item.getFileNum());
		form.set("collateUser", item.getCollateUser());
		form.set("fileDept", item.getFileDept());
		form.set("secret1", item.getSecret1());
		form.set("secret2", item.getSecret2());
		form.set("filePages", item.getFilePages());
		form.set("sendFileType", item.getSendFileType());
		form.set("fileCategory", item.getFileCategory());
		form.set("draftUser", item.getDraftUser());
		form.set("chargeUser", item.getChargeUser());
		form.set("fileType", item.getFileType());
		form.set("sendFileTypeX", item.getSendFileTypeX());
	}

	protected void putCommonInfo(HttpServletRequest request,TbDocSendXxzx item){
		request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCSEND));
		request.setAttribute("sclzdList", docSendMgr.findClosedControl(item.getId()));//查询审查流转单
		request.setAttribute("docfileList",docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOCCONTEXT));
		request.setAttribute("archiveTypeList", docServiceMgr.findAllArchiveType());
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
		if(attachAction==null){
			attachAction = new DocAttachAction();
			attachAction.setDocAttachMgr(docAttachMgr);
			attachAction.setServlet(this.getServlet());
		}
		return attachAction;		
	}

	public IDocSendDealMgr getDocSendDealXxzxMgr() {
		return docSendDealXxzxMgr;
	}

	public void setDocSendDealXxzxMgr(IDocSendDealMgr docSendDealXxzxMgr) {
		this.docSendDealXxzxMgr = docSendDealXxzxMgr;
	}
}
