package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
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

/** 
 * MyEclipse Struts
 * Creation date: 2008-08-04
 * 
 * XDoclet definition:
 * @struts.action path="/docRecDispose" name="docRecBookForm" scope="request"
 */
public class DocRecDisposeAction extends DocActionHelper {
	/**
	 * <p>Decription:保存拟办人填写的数据</p>
	 * @param form
	 * @throws ParseException
	 * @author heaton.cai
	 * @throws IOException 
	 * <p>Create Time:2008-7-31</p>
	 */
	private TbDocRec saveBookData(DynaActionForm form,String state,boolean isUrgent,String draftRadio) throws IOException{
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
		item.setAuditUser((String)form.get("auditUser"));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		item.setWriteTime(format.parse((String)form.get("writeTime")));
		try{
			item.setOverDate(format.parse((String)form.get("overDate")));
		}catch(ParseException e){
		}
		item.setDraftOpinion((String)form.get("draftOpinion"));
		item.setDraftRadio(draftRadio);
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
	 * <p>Decription:进入拟办页面</p>
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
			System.out.println("--heaton.cai--input start--");
			String controlId = request.getParameter("controlId");
			TbDocRec item = null;
			TbDocControl control = null;
			control = tbDocRecMgr.findControlById(controlId);
			doInput(control);
			item = tbDocRecMgr.findById(control.getTbDocRec().getId());
			DynaActionForm dform = (DynaActionForm) form;
			setBaseInfo(dform,item,controlId);
			dform.set("auditUserId", user.getId());
			putCommonInfo(request, item);
			return mapping.findForward("goInput");
	}

	/**
	 * <p>Decription:拟办完成</p>
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
			System.out.println("--heaton.cai--DocRecDispose--add start--");
			String draftRadio = (String) ((DynaActionForm) form).get("draftRadio");
			String controlId = (String) ((DynaActionForm) form).get("controlId");
			TbDocControl curControl = tbDocRecMgr.findControlById(controlId);
			curControl.setCloseTime(nowTime);
			curControl.setState(ITbDocRecMgr.STATE_CLOSED);
			TbDocControl nextControl = null;
			String state = null;
			if("1".equals(draftRadio)){
				String leader = request.getParameter("leader1");
				String leaderName = request.getParameter("leaderName1");
				String[] leaderIds = leader.split(",");
				String[] leaderNames = leaderName.split(",");
				String person = request.getParameter("person1");
				String personName = request.getParameter("personName1");
				String[] personIds = person.split(",");
				String[] personNames = personName.split(",");
				//转到领导处理
				for(int i=0;i<leaderIds.length;i++){
					if(leaderIds[i]==null || leaderIds[i].length()<1){
						continue;
					}
					nextControl = new TbDocControl();
					nextControl.setCreateTime(nowTime);
					nextControl.setState(ITbDocRecMgr.STATE_NEW);
					nextControl.setStateName(ITbDocRecMgr.STATE_NAME_LEADER);
					nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_LEADER);
					nextControl.setTbDocRec(curControl.getTbDocRec());
					nextControl.setUserId(leaderIds[i]);
					nextControl.setUserName(leaderNames[i]);
					tbDocRecMgr.saveControl(nextControl);
					tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
				}
				//建立接下来的相关人员
				for(int i=0;i<personIds.length;i++){
					if(personIds[i]==null || personIds[i].length()<1){
						continue;
					}
					nextControl = new TbDocControl();
					nextControl.setCreateTime(nowTime);
					nextControl.setState(ITbDocRecMgr.STATE_WAIT_DISPOSE);
					nextControl.setStateName(ITbDocRecMgr.STATE_NAME_PERSON);
					nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_PERSON);
					nextControl.setTbDocRec(curControl.getTbDocRec());
					nextControl.setUserId(personIds[i]);
					nextControl.setUserName(personNames[i]);
					tbDocRecMgr.saveControl(nextControl);
				}
				tbDocRecMgr.saveControl(curControl);
				tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
				state = ITbDocRecMgr.STATE_NAME_LEADER;
			}else if("2".equals(draftRadio)){
				String leader = request.getParameter("leader2");
				String leaderName = request.getParameter("leaderName2");
				String mainDept = request.getParameter("mainDept2");
				String secendDept = request.getParameter("secendDept2");
				String[] secendDeptIds = secendDept.split(",");
				//转到领导处理
				nextControl = new TbDocControl();
				nextControl.setCreateTime(nowTime);
				nextControl.setState(ITbDocRecMgr.STATE_NEW);
				nextControl.setStateName(ITbDocRecMgr.STATE_NAME_LEADER);
				nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_LEADER);
				nextControl.setTbDocRec(curControl.getTbDocRec());
				nextControl.setUserId(leader);
				nextControl.setUserName(leaderName);
				tbDocRecMgr.saveControl(nextControl);
				tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
				//建立接下来的主办部门
				nextControl = new TbDocControl();
				nextControl.setCreateTime(nowTime);
				nextControl.setState(ITbDocRecMgr.STATE_WAIT_DISPOSE);
				nextControl.setStateName(ITbDocRecMgr.STATE_NAME_MAIN_DEPT);
				nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_MAIN_DEPT);
				nextControl.setTbDocRec(curControl.getTbDocRec());
				TbUser deptDisposer = docServiceMgr.getDeptDisposer(mainDept);
				nextControl.setUserId(deptDisposer.getId());
				nextControl.setUserName(deptDisposer.getName());
				tbDocRecMgr.saveControl(nextControl);
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
				state = ITbDocRecMgr.STATE_NAME_LEADER;
			}else if("3".equals(draftRadio)){
				String leader = request.getParameter("leader3");
				String leaderName = request.getParameter("leaderName3");
				String mainDept = request.getParameter("mainDept3");
				String secendDept = request.getParameter("secendDept3");
				String[] secendDeptIds = secendDept.split(",");
				//转到主办部门处理
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
				//建立领导监控
				nextControl = new TbDocControl();
				nextControl.setCreateTime(nowTime);
				nextControl.setState(ITbDocRecMgr.STATE_CAN_MONITOR);
				nextControl.setStateName(ITbDocRecMgr.STATE_NAME_LEADER);
				nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_LEADER);
				nextControl.setTbDocRec(curControl.getTbDocRec());
				nextControl.setUserId(leader);
				nextControl.setUserName(leaderName);
				tbDocRecMgr.saveControl(nextControl);
				tbDocRecMgr.saveControl(curControl);
				tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
				state = ITbDocRecMgr.STATE_NAME_MAIN_DEPT;
			}else if("4".equals(draftRadio)){
				String person = request.getParameter("person4");
				String personName = request.getParameter("personName4");
				String[] personIds = person.split(",");
				String[] personNames = personName.split(",");
				//建立传阅人员
				for(int i=0;i<personIds.length;i++){
					if(personIds[i]==null || personIds[i].length()<1){
						continue;
					}
					nextControl = new TbDocControl();
					nextControl.setCreateTime(nowTime);
					nextControl.setState(ITbDocRecMgr.STATE_NEW);
					nextControl.setStateName(ITbDocRecMgr.STATE_NAME_READ);
					nextControl.setStateType(ITbDocRecMgr.STATE_TYPE_READ);
					nextControl.setTbDocRec(curControl.getTbDocRec());
					nextControl.setUserId(personIds[i]);
					nextControl.setUserName(personNames[i]);
					tbDocRecMgr.saveControl(nextControl);
					tbUserOpeationMgr.SaveOrUpdate(nextControl.getUserId(),"300","add");
				}
				tbDocRecMgr.saveControl(curControl);
				tbUserOpeationMgr.SaveOrUpdate(curControl.getUserId(),"301","minus");
				state = ITbDocRecMgr.STATE_NAME_READ;
			}else{
				System.out.println("拟办人没有选择处理类型！");
				throw new Exception("拟办人没有选择处理类型！");
			}
			saveBookData((DynaActionForm) form,state,false,draftRadio);

//			System.out.println("--heaton.cai--add start--");
			return mapping.findForward("disposedList");
	}

	/**
	 * <p>Decription:拟办加急</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward urgent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		TbDocRec item = saveBookData((DynaActionForm) form,null,true,null);
		putCommonInfo(request, item);
		return mapping.findForward("goInput");
	}

}