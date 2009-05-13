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

import com.baosight.base.service.ITbDocRecMgr;
import com.baosight.mode.TbDocControl;
import com.baosight.mode.TbDocRec;
/** 
 * MyEclipse Struts
 * Creation date: 08-06-2008
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class DocRecWriteDealAction extends DocActionHelper {

	/**
	 * <p>Decription:保存办理情况数据</p>
	 * @param form
	 * @throws ParseException
	 * @author heaton.cai
	 * @throws IOException 
	 * <p>Create Time:2008-7-31</p>
	 */
	private TbDocRec saveBookData(DynaActionForm form,String state) throws ParseException, IOException{
		String id = (String) form.get("docId");
		//System.out.println("--heaton.cai--"+id);
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
		item.setDealState((String) form.get("dealState"));
		if(state!=null){
			item.setDocState(state);
		}
		tbDocRecMgr.save(item);
//		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOC, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOC);
		return item;
	}

	/**
	 * <p>Decription:进入办理情况填写页面</p>
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
			//System.out.println("--heaton.cai--input start--");
			String controlId = request.getParameter("controlId");
			TbDocRec item = null;
			TbDocControl control = null;
			control = tbDocRecMgr.findControlById(controlId);
			doInput(control);
			item = tbDocRecMgr.findById(control.getTbDocRec().getId());
			setBaseInfo((DynaActionForm) form,item,controlId);
			putCommonInfo(request, item);
			//System.out.println("--heaton.cai--input over--");
			return mapping.findForward("goInput");
	}

	/**
	 * <p>Decription:办理情况填写完成</p>
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
			//System.out.println("--heaton.cai--DocRecWriteDealAction--add start--");
			String controlId = (String) ((DynaActionForm) form).get("controlId");
			TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
			curControl.setCloseTime(nowTime);
			curControl.setState(ITbDocRecMgr.STATE_CLOSED);
			String state = null;
			boolean needArchive = false;
			List nextControls = tbDocRecMgr.findNextControl(curControl.getTbDocRec().getId());
			//有主办部门给主办部门
			for(Object control : nextControls){
				TbDocControl nextControl = (TbDocControl) control;
				if(ITbDocRecMgr.STATE_WAIT_DISPOSE.equals(nextControl.getState())
						&& ITbDocRecMgr.STATE_TYPE_MAIN_DEPT.equals(nextControl.getStateType())){
					nextControl.setState(ITbDocRecMgr.STATE_NEW);
					nextControl.setCreateTime(nowTime);
					tbDocRecMgr.saveControl(nextControl);
					tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
					state = nextControl.getStateName();
				}
			}
			if(state==null){
				//没有主办部门，给领导
				for(Object control : nextControls){
					TbDocControl nextControl = (TbDocControl) control;
					if((ITbDocRecMgr.STATE_WAIT_DISPOSE.equals(nextControl.getState())
							|| ITbDocRecMgr.STATE_CAN_MONITOR.equals(nextControl.getState()))
							&& ITbDocRecMgr.STATE_TYPE_LEADER.equals(nextControl.getStateType())){
						nextControl.setState(ITbDocRecMgr.STATE_NEW);
						tbDocRecMgr.saveControl(nextControl);
						tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
						state = nextControl.getStateName();
					}
				}
			}
			if(state==null){
				state = ITbDocRecMgr.STATE_NAME_END;
				needArchive = true;
			}
			tbDocRecMgr.saveControl(curControl);
			tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
			TbDocRec item = saveBookData((DynaActionForm) form,state);
			if(needArchive){
				docServiceMgr.save2Archives(item,getCurrentUser(request));
			}
			//System.out.println("--heaton.cai--add end--");

			return mapping.findForward("disposedList");
	}

}