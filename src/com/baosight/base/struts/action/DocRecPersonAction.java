package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.baosight.base.service.IDocServiceMgr;
import com.baosight.base.service.ITbDocRecMgr;
import com.baosight.mode.TbDocControl;
import com.baosight.mode.TbDocRec;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

/** 
 * MyEclipse Struts
 * Creation date: 08-04-2008
 * 
 * XDoclet definition:
 * @struts.action path="/docRecPerson" name="docRecBookForm" scope="request"
 */
public class DocRecPersonAction extends DocActionHelper {

	/**
	 * <p>Decription:保存相关人员数据</p>
	 * @param form
	 * @throws ParseException
	 * @author heaton.cai
	 * @throws IOException 
	 * <p>Create Time:2008-7-31</p>
	 */
	private TbDocRec saveBookData(DynaActionForm form,String state,boolean isUrgent,boolean isAchive) throws ParseException, IOException{
		String id = (String) form.get("docId");
//		System.out.println("--heaton.cai--"+id);
		TbDocRec item = tbDocRecMgr.findById(id);
//		item.setDocType((String)form.get("docType"));
//		item.setInfoLevel((String)form.get("infoLevel"));
//		if(item.getInfoLevel().length()<5){
//			item.setInfoLevel(tbDocRecMgr.getCurInfoLevel(item.getInfoLevel()));
//		}
//		item.setDocName((String)form.get("docName"));
//		item.setBookUser((String)form.get("bookUser"));
//		item.setDocNum((Long)form.get("docNum"));
//		item.setDocDept((String)form.get("docDept"));
//		item.setDocCode((String)form.get("docCode"));
//		item.setAuditUser((String)form.get("auditUser"));
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		item.setWriteTime(format.parse((String)form.get("writeTime")));
//		item.setOverDate(format.parse((String)form.get("overDate")));
//		item.setDraftOpinion((String)form.get("draftOpinion"));
//		item.setLeaderAudit((String) form.get("leaderAudit"));
//		if(item.getAssUserRemark()!=null && !"".equals(item.getAssUserRemark())){
//			item.setAssUserRemark(item.getAssUserRemark()+"\r\n"+(String) form.get("assUserRemark"));
//		}else{
			item.setAssUserRemark((String) form.get("assUserRemark"));
//		}
		if(state!=null){
			item.setDocState(state);
		}
		if(isAchive){
			item.setArchiveFlag(1l);
		}
		if(isUrgent){
			item.setUrgentFlag(1l);
		}
		tbDocRecMgr.save(item);
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOC, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOC);
		return item;
	}

	/**
	 * <p>Decription:进入相关人员处理页面</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * <p>Create Time:2008-7-31</p>
	 * @throws Exception 
	 */
	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("--heaton.cai--input start--");
			String controlId = request.getParameter("controlId");
			TbDocRec item = null;
			TbDocControl control = null;
			control = tbDocRecMgr.findControlById(controlId);
			doInput(control);
			item = tbDocRecMgr.findById(control.getTbDocRec().getId());
			setBaseInfo((DynaActionForm) form,item,controlId);
			putCommonInfo(request, item);
			System.out.println("--heaton.cai--input over--");
			return mapping.findForward("goInput");
	}

	/**
	 * <p>Decription:相关人员完成</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			Date nowTime = new Date(System.currentTimeMillis());
			//System.out.println("--heaton.cai--DocRecDispose--add start--");
			String controlId = (String) ((DynaActionForm) form).get("controlId");
			TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
			curControl.setCloseTime(nowTime);
			curControl.setState(ITbDocRecMgr.STATE_CLOSED);
			tbDocRecMgr.saveControl(curControl);
			tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
			String state = null;
			boolean needArchive = false;
			List controls = tbDocRecMgr.findNotClosedControl(curControl.getTbDocRec().getId());
			if(controls==null || controls.isEmpty()){
				state = ITbDocRecMgr.STATE_NAME_END;
				needArchive = true;
			}
			TbDocRec item = saveBookData((DynaActionForm) form,state,false,false);
			if(needArchive){
				docServiceMgr.save2Archives(item,getCurrentUser(request));
			}
			//System.out.println("--heaton.cai--add start--");
			return mapping.findForward("disposedList");
	}

	/**
	 * <p>Decription:加急</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward urgent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		TbDocRec item = saveBookData((DynaActionForm) form,null,true,false);
		putCommonInfo(request, item);
		return mapping.findForward("goInput");
	}

	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("newAndDisposingList");
	}

	/**
	 * <p>Decription:驳回</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-8-5</p>
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public ActionForward rollback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		Date nowTime = new Date(System.currentTimeMillis());
		String backControlId = request.getParameter("backControl");
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
		curControl.setCloseTime(nowTime);
		curControl.setState(ITbDocRecMgr.STATE_CLOSED);
		TbDocControl backControl = tbDocRecMgr.findControlById(backControlId);
		String state = null;
		if(tbDocRecMgr.findCuruserControl(backControl.getUserId(), backControl.getTbDocRec().getId())!=null){
			//被驳回的用户已不处理该收文
			TbDocControl nextControl = new TbDocControl();
			nextControl.setCreateTime(nowTime);
			nextControl.setState(ITbDocRecMgr.STATE_NEW);
			nextControl.setStateName(backControl.getStateName());
			nextControl.setStateType(backControl.getStateType());
			nextControl.setTbDocRec(backControl.getTbDocRec());
			nextControl.setUserId(backControl.getUserId());
			nextControl.setUserName(backControl.getUserName());
			tbDocRecMgr.saveControl(nextControl);
			tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
			state = nextControl.getStateName();
		}
		tbDocRecMgr.saveControl(curControl);
		tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
		saveBookData((DynaActionForm)form, state, false,false);
		return mapping.findForward("newAndDisposingList");
	}

	/**
	 * <p>Decription:归档</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 * @author heaton.cai
	 * <p>Create Time:2008-8-5</p>
	 */
	public ActionForward archive(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		saveBookData((DynaActionForm)form, ITbDocRecMgr.STATE_NAME_ARCHIVE, false,true);
		String controlId = (String) ((DynaActionForm) form).get("controlId");
		TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
		tbDocRecMgr.deleteControl(curControl);
		//TODO 跳转到归档页面
		return mapping.findForward("newAndDisposingList");
	}

}