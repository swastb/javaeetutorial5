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
 * @struts.action path="/docRecMainDept" name="docRecBookForm" scope="request"
 */
public class DocRecMainDeptAction extends DocActionHelper {

	/**
	 * <p>Decription:保存主办部门数据</p>
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
//		item.setAssUserRemark((String) form.get("assUserRemark"));
		item.setMainDeptOpinion((String) form.get("mainDeptOpinion"));
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
	 * <p>Decription:进入主办部门处理页面</p>
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
			String controlId = request.getParameter("controlId");
			TbDocRec item = null;
			TbDocControl control = null;
			control = tbDocRecMgr.findControlById(controlId);
			doInput(control);
			item = tbDocRecMgr.findById(control.getTbDocRec().getId());
			setBaseInfo((DynaActionForm) form, item, controlId);
			putCommonInfo(request, item);
//			System.out.println("--heaton.cai--input over--");
			return mapping.findForward("goInput");
	}

	/**
	 * <p>Decription:主办部门完成</p>
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
			//System.out.println("--heaton.cai--DocRecMainDeptAction--add start--");
			String controlId = (String) ((DynaActionForm) form).get("controlId");
			TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
			curControl.setCloseTime(nowTime);
			curControl.setState(ITbDocRecMgr.STATE_CLOSED);
			String state = null;
			boolean needArchive = false;
			List nextControls = tbDocRecMgr.findNextControl(curControl.getTbDocRec().getId());
			//自动给协办部门
			for(Object control : nextControls){
				TbDocControl nextControl = (TbDocControl) control;
				if(ITbDocRecMgr.STATE_WAIT_DISPOSE.equals(nextControl.getState())
						&& ITbDocRecMgr.STATE_TYPE_SECEND_DEPT.equals(nextControl.getStateType())){
					nextControl.setState(ITbDocRecMgr.STATE_NEW);
					nextControl.setCreateTime(nowTime);
					tbDocRecMgr.saveControl(nextControl);
					tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
					state = nextControl.getStateName();
				}
			}
			if(state==null){
				//没有协办部门，查找是否有监控的领导
				request.setAttribute("hasSecendDept", "false");
				for(Object control : nextControls){
					TbDocControl nextControl = (TbDocControl) control;
					if(ITbDocRecMgr.STATE_CAN_MONITOR.equals(nextControl.getState())
							&& ITbDocRecMgr.STATE_TYPE_LEADER.equals(nextControl.getStateType())){
						nextControl.setState(ITbDocRecMgr.STATE_NEW);
						tbDocRecMgr.saveControl(nextControl);
						tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
						state = nextControl.getStateName();
					}
				}
				if(state==null){
					request.setAttribute("hasLeader", "false");
					state = ITbDocRecMgr.STATE_NAME_END;
					needArchive = true;
				}else{
					request.setAttribute("hasLeader", "true");
				}
			}else{
				request.setAttribute("hasSecendDept", "true");
			}
			tbDocRecMgr.saveControl(curControl);
			tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
			TbDocRec item = saveBookData((DynaActionForm) form,state,false,false);
			if(needArchive){
				docServiceMgr.save2Archives(item,getCurrentUser(request));
			}
			request.setAttribute("controlId", curControl.getId());
			putTreeRootId(request);
			//System.out.println("--heaton.cai--add end--");

			return mapping.findForward("success");
	}

	/**
	 * <p>Decription:主办部门完成后扭转页面完成</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward addControl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			Date nowTime = new Date(System.currentTimeMillis());
			//System.out.println("--heaton.cai--DocRecDispose--add start--");
			String deptRadio = request.getParameter("deptRadio");
			String controlId = request.getParameter("controlId");
			TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
			if("1".equals(deptRadio)){
				//协办，这段逻辑已处理
			}else if("2".equals(deptRadio)){
				//报领导
				List nextControls = tbDocRecMgr.findControl(curControl.getTbDocRec().getId(), ITbDocRecMgr.STATE_TYPE_LEADER);
				if(nextControls!=null && !nextControls.isEmpty()){
					boolean hasLeaderDoing = false;
					for(Object control : nextControls){
						TbDocControl con = (TbDocControl) control;
						if(!ITbDocRecMgr.STATE_CLOSED.equals(con.getState())){
							hasLeaderDoing = true;
						}
					}
					if(!hasLeaderDoing){
						TbDocControl control = (TbDocControl)nextControls.get(0);
						TbDocControl nextControl = new TbDocControl();
						nextControl.setCreateTime(nowTime);
						nextControl.setState(ITbDocRecMgr.STATE_NEW);
						nextControl.setStateName(control.getStateName());
						nextControl.setStateType(control.getStateType());
						nextControl.setTbDocRec(control.getTbDocRec());
						nextControl.setUserId(control.getUserId());
						nextControl.setUserName(control.getUserName());
						tbDocRecMgr.saveControl(nextControl);
						tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
					}
				}
				TbDocRec item = tbDocRecMgr.findById(curControl.getTbDocRec().getId());
				item.setDocState(ITbDocRecMgr.STATE_NAME_LEADER);
				tbDocRecMgr.save(item);
			}else if("3".equals(deptRadio)){
				TbUser user = getCurrentUser(request);
				String sendControlId = docServiceMgr.copyRec2Send(curControl.getTbDocRec().getId(), user);
				if(IDocServiceMgr.DEPT_TYPE_JUOA.equals(user.getUserdept())){
					return new ActionForward("/docSendBook.do?method=input&controlId="+sendControlId);
				}else{
					return new ActionForward("/xdocSendBook.do?method=input&controlId="+sendControlId);
				}
			}else if("4".equals(deptRadio)){
				//主办人员办理
				String userId = request.getParameter("userId4");
				String userName = request.getParameter("userName4");
				curControl.setState(ITbDocRecMgr.STATE_WAIT_DISPOSE);
				tbDocRecMgr.saveControl(curControl);
				List nextControls = tbDocRecMgr.findNextControl(curControl.getTbDocRec().getId());
				//自动给协办部门
				for(Object control : nextControls){
					TbDocControl nextControl = (TbDocControl) control;
					if(ITbDocRecMgr.STATE_NEW.equals(nextControl.getState())
							|| ITbDocRecMgr.STATE_DISPOSING.equals(nextControl.getState())){
						if(ITbDocRecMgr.STATE_TYPE_SECEND_DEPT.equals(nextControl.getStateType())){
							nextControl.setState(ITbDocRecMgr.STATE_WAIT_DISPOSE);
							tbDocRecMgr.saveControl(nextControl);
							tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","minus");
						}else if(ITbDocRecMgr.STATE_TYPE_LEADER.equals(nextControl.getStateType())){
							nextControl.setState(ITbDocRecMgr.STATE_CAN_MONITOR);
							tbDocRecMgr.saveControl(nextControl);
							tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","minus");
						}
					}
				}
				TbDocControl nextControl = new TbDocControl();
				nextControl.setCreateTime(nowTime);
				nextControl.setState(ITbDocRecMgr.STATE_NEW);
				nextControl.setStateName(ITbDocRecMgr.STATE_NAME_MAIN_PERSON);
				nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_SECEND_DEPT);
				nextControl.setTbDocRec(curControl.getTbDocRec());
				nextControl.setUserId(userId);
				nextControl.setUserName(userName);
				tbDocRecMgr.saveControl(nextControl);
				tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
				TbDocRec item = tbDocRecMgr.findById(curControl.getTbDocRec().getId());
				item.setDocState(ITbDocRecMgr.STATE_NAME_MAIN_PERSON);
				tbDocRecMgr.save(item);
			}else{
				System.out.println("没有选择扭转！");
				throw new Exception("没有选择扭转！");
			}
			String state = null;
			List controls = tbDocRecMgr.findNotClosedControl(curControl.getTbDocRec().getId());
			if(controls==null || controls.size()==0){
				state = ITbDocRecMgr.STATE_NAME_END;
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
		saveBookData((DynaActionForm)form, state, false,false);
		return mapping.findForward("newAndDisposingList");
	}

}