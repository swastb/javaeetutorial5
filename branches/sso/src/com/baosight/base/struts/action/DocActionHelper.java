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

import com.baosight.base.service.IDocServiceMgr;
import com.baosight.base.service.ITbDocRecMgr;
import com.baosight.mode.TbDocControl;
import com.baosight.mode.TbDocRec;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class DocActionHelper extends BaseDispatchAction{

	public void doInput(TbDocControl control){
		if(ITbDocRecMgr.STATE_NEW.equals(control.getState())){
			control.setInputTime(new Date(System.currentTimeMillis()));
			control.setState(ITbDocRecMgr.STATE_DISPOSING);
			tbDocRecMgr.saveControl(control);
			tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"300","minus");
			tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"301","add");
		}
	}

	public void setBaseInfo(DynaActionForm form,TbDocRec item,String controlId){
		form.set("docId", item.getId());
		form.set("docType", item.getDocType());
		form.set("infoLevel", item.getInfoLevel());
		form.set("docName", item.getDocName());
		form.set("bookUser", item.getBookUser());
		form.set("docNum", item.getDocNum());
		form.set("docPage", item.getDocPage());
		form.set("docDept", item.getDocDept());
		form.set("docCode", item.getDocCode());
		if(item.getWriteTime()!=null){
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			form.set("writeTime", format.format(item.getWriteTime()));
		}
		form.set("controlId", controlId);
		form.set("auditUser", item.getAuditUser());
		form.set("draftOpinion", item.getDraftOpinion());
		form.set("leaderAudit", item.getLeaderAudit());
		form.set("assUserRemark", item.getAssUserRemark());
		form.set("mainDeptOpinion", item.getMainDeptOpinion());
		form.set("dealState",item.getDealState());
		if(item.getOverDate()!=null){
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			form.set("overDate", format.format(item.getOverDate()));
		}
	}

	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("newAndDisposingList");
	}

	/**
	 * <p>Decription:页面上需要的非form信息</p>
	 * @param request
	 * @author heaton.cai
	 * <p>Create Time:2008-8-5</p>
	 */
	protected void putCommonInfo(HttpServletRequest request,TbDocRec item){
		request.setAttribute("archiveTypeList", docServiceMgr.findAllArchiveType());
		request.setAttribute("infoLevelList", tbDocRecMgr.findAllInfoLevel());
		request.setAttribute("files", docAttachMgr.findByIdAndType(item.getId(), IDocServiceMgr.UPLOAD_TYPE_DOC));
		request.setAttribute("isUrgent", String.valueOf(item.getUrgentFlag()));
		request.setAttribute("sclzdList", docRecListMgr.findSCLZDById(item.getId()));
		putTreeRootId(request);
	}

	protected void putTreeRootId(HttpServletRequest request){
		TbUser user = getCurrentUser(request);
		if(IDocServiceMgr.DEPT_TYPE_INFO.equals(user.getUserdept())){
			request.setAttribute("treeRootId", DEPT_ID_INFO);
		}else if(IDocServiceMgr.DEPT_TYPE_SLZX.equals(user.getUserdept())){
			request.setAttribute("treeRootId", DEPT_ID_SLZX);
		}else{
			request.setAttribute("treeRootId", DEPT_ID_JUOA);
		}
	}

	protected DocAttachAction getAttachAction(){
		DocAttachAction docAttachAction = new DocAttachAction();
		docAttachAction.setDocAttachMgr(docAttachMgr);
		docAttachAction.setServlet(this.getServlet());
		return docAttachAction;
	}

	public static final String DEPT_ID_JUOA="e584b88cc02f49c0b0da6db657f8fd83";//局OA
	public static final String DEPT_ID_INFO="9f9083fd19310922011931fc1da5018d";//信息中心
	public static final String DEPT_ID_SLZX="A1155544505531079843E571333742CC06625D51837831";//受理中心
}
