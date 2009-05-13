package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.service.IDocSendMgr;
import com.baosight.base.service.IDocServiceMgr;
import com.baosight.mode.TbDocAttach;
import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;
import com.baosight.mode.TbUser;

public class DocSendBookAction extends DocSendHelper {
	
	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String controlId = request.getParameter("controlId");
		if(controlId!=null && controlId.length()>0){
			TbDocsendControl control = docSendMgr.findControlById(controlId);
			TbDocSend item = docSendMgr.findById(control.getTbDocSend().getId());
			setBaseInfo((DynaActionForm) form,control,item);
			putCommonInfo(request,item);
		}
		return mapping.findForward("goInput");
	}
	/**
	 * 发文稿纸（拟稿人填写）完成
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String docId = (String)((DynaActionForm)form).get("docId");
		
		TbUser user = getCurrentUser(request);
		if(docId!=null && !docId.equals("")){
			TbDocSend instance =saveBookData((DynaActionForm) form,IDocSendMgr.STATE_NAME_NEWBOOK,docId);
			if(instance!=null){
				Date nowTime = new Date(System.currentTimeMillis());
				String controlId = (String)((DynaActionForm)form).get("controlId");
				//己完成
				TbDocsendControl conAchieve = null;
				if(controlId!=null && !"".equals(controlId)){
					conAchieve = docSendMgr.findControlById(controlId);
				}
				if(conAchieve==null){
					conAchieve = new TbDocsendControl();
					conAchieve.setTbDocSend(instance);
					conAchieve.setStateName(IDocSendMgr.STATE_NAME_NEWBOOK);
					conAchieve.setCreateTime(nowTime);
					conAchieve.setUserId(user.getId());
					conAchieve.setUserName(user.getName());
					conAchieve.setStateType(IDocSendMgr.STATE_TYPE_DRAFTER);
				}else{
					tbUserOpeationMgr.SaveOrUpdate(conAchieve.getUserId(),"303","minus");
				}
				conAchieve.setInputTime(nowTime);
				conAchieve.setState(IDocSendMgr.STATE_END);
				conAchieve.setCloseTime(nowTime);
				docSendMgr.saveControl(conAchieve);
				//未处理
				String leaderId = request.getParameter("leaderId");
				String leaderName = request.getParameter("leaderName");
				TbDocsendControl conUntreated = new TbDocsendControl();
				conUntreated.setTbDocSend(instance);
				conUntreated.setStateName(IDocSendMgr.STATE_NAME_DEPT_LEADERORRESPONSER);
				conUntreated.setCreateTime(nowTime);		
				conUntreated.setInputTime(nowTime);
				conUntreated.setUserId(leaderId);
				conUntreated.setUserName(leaderName);
				conUntreated.setState(IDocSendMgr.STATE_NEW);
				conUntreated.setStateType(IDocSendMgr.STATE_TYPE_DEPT_LEADERORRESPONSER);
				conUntreated.setCloseTime(nowTime);
				docSendMgr.saveControl(conUntreated);
				tbUserOpeationMgr.SaveOrUpdate(conUntreated.getUserId(),"302","add");
				//更新发文当前步骤
				instance.setDocState(IDocSendMgr.STATE_NAME_DEPT_LEADERORRESPONSER);
				docSendMgr.save(instance);
				if(IDocServiceMgr.DEPT_TYPE_JUOA.equals(user.getUserdept())){
					String[] sends = (instance.getSendMain()+","+instance.getSendSecond()).split(",");
					for(int i=0;i<sends.length;i++){
						if("上海市防汛信息中心".equals(sends[i])){
							docServiceMgr.sendToInfoRec(instance);
							break;
						}
					}
				}
			}
		}
		return mapping.findForward("add");
	}	
	/**
	 * 发文稿纸（拟稿人填写）暂存
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addTemp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String docId = (String)((DynaActionForm)form).get("docId");	
		saveBookData((DynaActionForm) form,IDocSendMgr.STATE_NAME_NEWBOOK,docId);
		return mapping.findForward("addTemp");
	}	
	/**
	 * 保存拟稿人填写的数据
	 * @param form
	 * @param docState 发文当前步骤
	 * @return
	 * @throws IOException
	 * @throws ParseException 
	 */
	private TbDocSend saveBookData(DynaActionForm form,String docState,String docId) throws IOException, ParseException{
		TbDocSend item = this.docSendMgr.findById(docId);
		if(item==null){
			item = new TbDocSend();	
		}
		item.setSecret1((String)form.get("secret1"));
		item.setSecret2((String)form.get("secret2"));
		item.setFileSecret((String)form.get("fileSecret"));
		item.setSendFileType((String)form.get("sendFileType"));
		item.setFileTitle((String)form.get("fileTitle"));
		item.setFileDept((String)form.get("fileDept"));
		item.setSendMain((String)form.get("sendMain"));
		item.setSendSecond((String)form.get("sendSecond"));
		item.setTopicWord((String)form.get("topicWord"));
		item.setMainDraftUser((String)form.get("mainDraftUser"));
		item.setMainChargeUser((String)form.get("mainChargeUser"));
		item.setFileNo((String)form.get("fileNo"));
		item.setPrintUser((String)form.get("printUser"));
		item.setCollateUser((String)form.get("collateUser"));
		item.setFileNum((Long)form.get("fileNum"));
		item.setFilePages((Long)form.get("filePages"));
		item.setFileType((String)form.get("fileType"));
		String fileDate = (String)form.get("fileDate");
		if(fileDate!=null && !"".equals(fileDate)){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			item.setFileDate(dateFormat.parse(fileDate));
		}
		item.setDocState(docState);
		docSendMgr.save(item);

		getAttachAction().saveAttachFile(form, IDocServiceMgr.UPLOAD_TYPE_DOCSEND, docId, IDocServiceMgr.UPLOAD_PATH_DOCSEND);
		return item;
	}
	/**
	 * 上传WEBOFFICE
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward uploadWebOfficeFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		String webOfficeTitle = request.getParameter("DocTitle");
		String docId = request.getParameter("DocSendId");
		String docAttId = request.getParameter("DocAttId");
		TbDocAttach att = null;
		if(docAttId!=null && !"".equals(docAttId)){
			att = docAttachMgr.findById(docAttId);
		}
		att = getAttachAction().saveAttachFileForWebOff(form, IDocServiceMgr.UPLOAD_TYPE_DOCCONTEXT, docId, IDocServiceMgr.UPLOAD_PATH_DOCSEND,webOfficeTitle,att);
		if(att==null){
			response.getOutputStream().println("failed");
		}else{
			response.getOutputStream().println(att.getId());
		}
		return null;
	}	
	/**
	 * 新建TbDocSend对象
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward uploadWebOffice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		TbDocSend item = new TbDocSend();
		item.setDocState(IDocSendMgr.STATE_NAME_NEWBOOK);
		String fileTitle = request.getParameter("fileTitle");
		if(fileTitle!=null && !"".equals(fileTitle)){
			item.setFileTitle(fileTitle);
		}else{
			item.setFileTitle("临时记录");
		}
		docSendMgr.save(item);
		TbUser user = getCurrentUser(request);	
		Date nowTime = new Date(System.currentTimeMillis());
		TbDocsendControl control = new TbDocsendControl();
		control.setTbDocSend(item);
		control.setStateName(IDocSendMgr.STATE_NAME_NEWBOOK);
		control.setCreateTime(nowTime);		
		control.setInputTime(nowTime);
		control.setUserId(user.getId());
		control.setUserName(user.getName());
		control.setState(IDocSendMgr.STATE_BOOKING);
		control.setStateType(IDocSendMgr.STATE_TYPE_DRAFTER);
		docSendMgr.saveControl(control);
		tbUserOpeationMgr.SaveOrUpdate(control.getUserId(),"303","add");
		String result = item.getId()+","+control.getId();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=GBK");
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}		
}
