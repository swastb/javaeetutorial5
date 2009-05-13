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
 * Creation date: 07-30-2008
 * 
 * XDoclet definition:
 * @struts.action input="/WEB-INF/web/jsp/docrec/book.jsp" scope="request" validate="true"
 */
public class DocRecBookAction extends DocActionHelper {

	/**
	 * <p>Decription:验证用户是否有权限操作收文登记</p>
	 * @param userId 操作用户Id
	 * @return 有权限返回true，没有返回false
	 * <p>Create Time:2008-7-31</p>
	 */
	public boolean validateUser(String userId){
		return docServiceMgr.isDisposerOrBooker(userId);
	}

	/**
	 * <p>Decription:检查文件编号是否已存在</p>
	 * @param docCode 文件编号
	 * @return 存在，返回false，否则，返回true
	 * @author heaton.cai
	 * <p>Create Time:2008-10-10</p>
	 */
	public boolean checkDocCode(String docCode){
		List list = tbDocRecMgr.findByProperty("docCode", docCode);
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * <p>Decription:保存登记人填写的数据</p>
	 * @param form
	 * @throws ParseException
	 * @author heaton.cai
	 * @throws IOException 
	 * <p>Create Time:2008-7-31</p>
	 */
	private TbDocRec saveBookData(DynaActionForm form,String state) throws ParseException, IOException{
		String id = (String) form.get("docId");
//		System.out.println("--heaton.cai--"+id);
		TbDocRec item = null;
		if(id!=null && id.length()>0){
			item = tbDocRecMgr.findById(id);
		}
		if(item == null){
			item = new TbDocRec();
		}
//		System.out.println("--heaton.cai--"+item.getId());
		item.setDocType((String)form.get("docType"));
		if(item.getInfoLevel()==null || item.getInfoLevel().length()<5){
			item.setInfoLevel((String)form.get("infoLevel"));
			item.setInfoLevel(tbDocRecMgr.getCurInfoLevel(item.getInfoLevel()));
		}
		item.setDocName((String)form.get("docName"));
		item.setBookUser((String)form.get("bookUser"));
		item.setDocNum((Long)form.get("docNum"));
		item.setDocPage((Long)form.get("docPage"));
		item.setDocDept((String)form.get("docDept"));
		//来文编号不可重复
		item.setDocCode((String)form.get("docCode"));
		item.setAuditUser((String)form.get("auditUser"));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		item.setWriteTime(format.parse((String)form.get("writeTime")));
		item.setDocState(state);
		tbDocRecMgr.save(item);
		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOC, item.getId(), IDocServiceMgr.UPLOAD_PATH_DOC);
		return item;
	}

	/**
	 * <p>Decription:进入收文登记页面</p>
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
		if(validateUser(user.getId())){
			String controlId = request.getParameter("controlId");
			String docId = request.getParameter("docId");
			TbDocRec item = null;
			TbDocControl control = null;
			if(controlId!=null && !"".equals(controlId)){
				control = tbDocRecMgr.findControlById(controlId);
				doInput(control);
				item = tbDocRecMgr.findById(control.getTbDocRec().getId());
			}else{
				if(docId != null && docId.length()>0){
					item = tbDocRecMgr.findById(docId);
					control = tbDocRecMgr.findCuruserControl(user.getId(), docId);
				}
				if(item==null){
					item = new TbDocRec();
					item.setBookUser(user.getName());
				}
			}
			DynaActionForm dform = (DynaActionForm) form;
			dform.set("docType", item.getDocType());
			dform.set("infoLevel", item.getInfoLevel());
			dform.set("docName", item.getDocName());
			dform.set("bookUser", item.getBookUser());
			dform.set("docNum", item.getDocNum());
			dform.set("docDept", item.getDocDept());
			dform.set("docCode", item.getDocCode());
			dform.set("docPage", item.getDocPage());
			if(item.getWriteTime()!=null){
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				dform.set("writeTime", format.format(item.getWriteTime()));
			}
			if(control!=null){
				dform.set("controlId", control.getId());
			}
			List disposerList = docServiceMgr.getDisposerList();
			TbUser disposer = null;
			if(disposerList==null || disposerList.size()<1){
				request.setAttribute("errorString", "没有配置拟办人！");
				return mapping.findForward("goInput");
			}else{
				if(user.getUserdept()==null){
					request.setAttribute("errorString", "用户没有配置所属部门，请配置！");
					return mapping.findForward("goInput");
				}
				for(Object o:disposerList){
					disposer = (TbUser) o;
					if(user.getUserdept().equals(disposer.getUserdept())){
						break;
					}
				}
			}
			item.setAuditUser(disposer.getName());
			dform.set("auditUserId", disposer.getId());
			dform.set("auditUser", item.getAuditUser());
			putCommonInfo(request, docId);
//			System.out.println("--heaton.cai--input over--");
			return mapping.findForward("goInput");
		}else{
//			用户没有登陆或者没有权限
			return mapping.findForward("newAndDisposingList");
		}
	}

	/**
	 * <p>Decription:收文等级完成</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		TbUser user = getCurrentUser(request);
		if(user!=null && validateUser(user.getId())){
//			System.out.println("--heaton.cai--add start--");
			String controlId = (String) ((DynaActionForm) form).get("controlId");
			if(controlId==null || "".equals(controlId)){
				if(!checkDocCode((String)((DynaActionForm)form).get("docCode"))){
					request.setAttribute("errorString", "文件编号已存在！");
					putCommonInfo(request, (String) ((DynaActionForm)form).get("docId"));
					return mapping.findForward("goInput");
				}
			}
			TbDocRec item = saveBookData((DynaActionForm) form,ITbDocRecMgr.STATE_NAME_BOOKED);
			Date nowTime = new Date(System.currentTimeMillis());
			TbDocControl control = null;
			if(controlId!=null && controlId.length()>0){
				control = tbDocRecMgr.findControlById(controlId);
			}
			if(control==null){
				control = new TbDocControl();
				control.setTbDocRec(item);
				control.setCreateTime(nowTime);
				control.setInputTime(nowTime);
				control.setStateName(ITbDocRecMgr.STATE_NAME_NEWBOOK);
				control.setUserId(user.getId());
				control.setUserName(user.getName());
			}else{
				tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"301","minus");
			}
			control.setState(ITbDocRecMgr.STATE_CLOSED);
			control.setCloseTime(nowTime);
			tbDocRecMgr.saveControl(control);
			
			control = new TbDocControl();
			control.setTbDocRec(item);
			control.setCreateTime(nowTime);
			control.setState(ITbDocRecMgr.STATE_NEW);
			control.setStateName(ITbDocRecMgr.STATE_NAME_BOOKED);
			control.setUserId((String) ((DynaActionForm) form).get("auditUserId"));
			control.setUserName(item.getAuditUser());
			tbDocRecMgr.saveControl(control);
			tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"300","add");
//			System.out.println("--heaton.cai--add start--");
			return mapping.findForward("disposedList");
		}else{
			//用户没有登陆或者没有权限
			return mapping.findForward("newAndDisposingList");
		}
	}

	public ActionForward addTemp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		TbUser user = getCurrentUser(request);
		if(user!=null && validateUser(user.getId())){
//			System.out.println("--heaton.cai--addTemp start--");
			String controlId = (String) ((DynaActionForm) form).get("controlId");
			if(controlId==null || "".equals(controlId)){
				if(!checkDocCode((String)((DynaActionForm)form).get("docCode"))){
					request.setAttribute("errorString", "文件编号已存在！");
					putCommonInfo(request, (String) ((DynaActionForm)form).get("docId"));
					return mapping.findForward("goInput");
				}
			}
			TbDocRec item = saveBookData((DynaActionForm) form,ITbDocRecMgr.STATE_NAME_NEWBOOK);
			TbDocControl control = null;
			if(controlId!=null && controlId.length()>0){
				control = tbDocRecMgr.findControlById(controlId);
			}
			if(control==null){
				control = new TbDocControl();
				Date nowTime = new Date(System.currentTimeMillis());
				control.setTbDocRec(item);
				control.setCreateTime(nowTime);
				control.setInputTime(nowTime);
				control.setState(ITbDocRecMgr.STATE_NEWBOOK);
				control.setStateName(ITbDocRecMgr.STATE_NAME_NEWBOOK);
				control.setUserId(user.getId());
				control.setUserName(user.getName());
				tbDocRecMgr.saveControl(control);
				tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"301","add");
			}
//			System.out.println("--heaton.cai--addTemp start--");
			return mapping.findForward("bookingList");
		}else{
			//用户没有登陆或者没有权限
			return mapping.findForward("newAndDisposingList");
		}
	}

	private void putCommonInfo(HttpServletRequest request, String docId) {
		request.setAttribute("archiveTypeList", docServiceMgr.findAllArchiveType());
		request.setAttribute("infoLevelList", tbDocRecMgr.findAllInfoLevel());
		request.setAttribute("files", docAttachMgr.findByIdAndType(docId, IDocServiceMgr.UPLOAD_TYPE_DOC));
	}

}