package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

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

/** 
 * MyEclipse Struts
 * Creation date: 08-04-2008
 * 
 * XDoclet definition:
 * @struts.action path="/docRecLeader" name="docRecBookForm" scope="request"
 */
public class DocRecLeaderAction extends DocActionHelper {
	/**
	 * <p>Decription:保存拟办人填写的数据</p>
	 * @param form
	 * @throws ParseException
	 * @author heaton.cai
	 * @throws IOException 
	 * <p>Create Time:2008-7-31</p>
	 */
	private TbDocRec saveBookData(DynaActionForm form,String state,boolean isUrgent) throws ParseException, IOException{
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
		if(item.getLeaderAudit()!=null && !"".equals(item.getLeaderAudit())){
			item.setLeaderAudit(item.getLeaderAudit()+"\r\n"+(String) form.get("leaderAudit"));
		}else{
			item.setLeaderAudit((String) form.get("leaderAudit"));
		}
		if(state!=null){
			item.setDocState(state);
		}
		if(isUrgent){
			item.setUrgentFlag(1l);
		}
		tbDocRecMgr.save(item);
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOC, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOC);
		return item;
	}

	/**
	 * <p>Decription:进入领导处理页面</p>
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
		TbUser user = getCurrentUser(request);
//			System.out.println("--heaton.cai--input start--");
//			String docId = request.getParameter("docId");
			String controlId = request.getParameter("controlId");
			TbDocRec item = null;
			TbDocControl control = null;
			control = tbDocRecMgr.findControlById(controlId);
			doInput(control);
//			item = tbDocRecMgr.findById(docId);
			item = tbDocRecMgr.findById(control.getTbDocRec().getId());
			DynaActionForm dform = (DynaActionForm) form;
			setBaseInfo(dform, item, controlId);
			dform.set("auditUserId", user.getId());
			putCommonInfo(request, item);
			request.setAttribute("draftRadio", item.getDraftRadio());
//			System.out.println("--heaton.cai--input over--");
			return mapping.findForward("goInput");
	}

	/**
	 * <p>Decription:领导处理完成</p>
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
			String leaderRadio = (String) ((DynaActionForm) form).get("leaderRadio");
			String controlId = (String) ((DynaActionForm) form).get("controlId");
			TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
			curControl.setCloseTime(nowTime);
			curControl.setState(ITbDocRecMgr.STATE_CLOSED);
			TbDocControl nextControl = null;
			String state = null;
			boolean needArchive = false;
			if("1".equals(leaderRadio)){
				List cons = tbDocRecMgr.findNotClosedControl(curControl.getTbDocRec().getId(), ITbDocRecMgr.STATE_TYPE_LEADER);
				if(cons.size()==1){
					List nextControls = tbDocRecMgr.findNextControl(curControl.getTbDocRec().getId());
					for(Object control : nextControls){
						nextControl = (TbDocControl) control;
						if(ITbDocRecMgr.STATE_WAIT_DISPOSE.equals(nextControl.getState())
								&& (ITbDocRecMgr.STATE_TYPE_MAIN_DEPT.equals(nextControl.getStateType())
								|| ITbDocRecMgr.STATE_TYPE_PERSON.equals(nextControl.getStateType()))){
							nextControl.setState(ITbDocRecMgr.STATE_NEW);
							tbDocRecMgr.saveControl(nextControl);
							tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
							state = nextControl.getStateName();
						}
					}
					if(state==null){
						state = ITbDocRecMgr.STATE_NAME_END;
						needArchive = true;
					}
				}
				tbDocRecMgr.saveControl(curControl);
			}else if("2".equals(leaderRadio)){
				String mainDept = request.getParameter("mainDept4");
				String secendDept = request.getParameter("secendDept4");
				String[] secendDeptIds = secendDept.split(",");
				List nextControls = tbDocRecMgr.findNextControl(curControl.getTbDocRec().getId());
				for(Object control : nextControls){
					nextControl = (TbDocControl) control;
					if(ITbDocRecMgr.STATE_WAIT_DISPOSE.equals(nextControl.getState())
							&& (ITbDocRecMgr.STATE_TYPE_MAIN_DEPT.equals(nextControl.getStateType())
							|| ITbDocRecMgr.STATE_TYPE_PERSON.equals(nextControl.getStateType()))){
						tbDocRecMgr.deleteControl(nextControl);
					}
				}
				//主办部门
				nextControl = new TbDocControl();
				nextControl.setCreateTime(nowTime);
				nextControl.setState(ITbDocRecMgr.STATE_NEW);
				nextControl.setStateName(ITbDocRecMgr.STATE_NAME_MAIN_DEPT);
				nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_MAIN_DEPT);
				nextControl.setTbDocRec(curControl.getTbDocRec());
				TbUser deptDisposer = docServiceMgr.getDeptDisposer(mainDept);
				nextControl.setUserId(deptDisposer.getId());
				nextControl.setUserName(deptDisposer.getName());
				tbDocRecMgr.saveControl(nextControl);
				tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
				//协办部门
				for(int i=0;i<secendDeptIds.length;i++){
					if(secendDeptIds[i]==null || secendDeptIds[i].length()<1){
						continue;
					}
					nextControl = new TbDocControl();
					nextControl.setCreateTime(nowTime);
					nextControl.setState(ITbDocRecMgr.STATE_WAIT_DISPOSE);
					nextControl.setStateName(ITbDocRecMgr.STATE_NAME_SECEND_DEPT);
					nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_SECEND_DEPT);
					nextControl.setTbDocRec(curControl.getTbDocRec());
					deptDisposer = docServiceMgr.getDeptDisposer(secendDeptIds[i]);
					nextControl.setUserId(deptDisposer.getId());
					nextControl.setUserName(deptDisposer.getName());
					tbDocRecMgr.saveControl(nextControl);
				}
				tbDocRecMgr.saveControl(curControl);
				tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
				state = ITbDocRecMgr.STATE_NAME_MAIN_DEPT;
			}else{
				System.out.println("领导没有选择处理类型！");
				request.setAttribute("errorString", "领导没有选择处理类型！");
				return mapping.findForward("goInput");
			}
			TbDocRec item = saveBookData((DynaActionForm) form,state,false);
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
		TbDocRec item = saveBookData((DynaActionForm) form,null,true);
		putCommonInfo(request, item);
		return mapping.findForward("goInput");
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
		if(tbDocRecMgr.findCuruserControl(backControl.getUserId(), backControl.getTbDocRec().getId())==null){
			//被驳回的用户没有正在处理当前收文
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
		saveBookData((DynaActionForm)form, state, false);
		return mapping.findForward("newAndDisposingList");
	}

}