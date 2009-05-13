package com.baosight.base.struts.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import oracle.sql.CLOB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.hibernate.Hibernate;
import org.hibernate.lob.SerializableClob;

import com.baosight.mode.TbGovInfoPubContent;
import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbInfoPubContent;
import com.baosight.mode.TbUser;

public class GovInfoPubContentAction extends InfoPubHelperAction {
	private final static String PUBLIC_DEPAERTMENT="上海市水务局";
	/* 取政府信息公开信息列表 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String infoname = request.getParameter("infoname");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		/*//2008-10-30 start
		String deptId = "";
		if (this.infoPubContentMgr.isAdministrator(user))
			deptId = "all";
		else
			deptId = user.getDeptCode();
		//2008-10-30 end
*/		List infoConList = this.infoPubContentMgr.findByPIdInfoNameGov(user,parentid,infoname==null?"":infoname,type);
				
		request.setAttribute("p_name", p_name);
		long count=infoConList.size();
		startPagingCount(null, request,count);
		startPaging(infoConList, null, request);
		if ("dsh".equals(type) || "spxx".equals(type))
			return mapping.findForward("govdshlist");
		else
			return mapping.findForward("list");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException {
		String action = request.getParameter("action");
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				String applyId="";
				TbInfoPubCla obj = this.infoPubClaMgr.findById(parentid);
				applyId = this.infoPubContentMgr.findMaxLiuShHByPId(obj.getAttr2());//根据流水号类型找最大的流水号
				if ("".equals(applyId)) {
					applyId = obj.getCode()+"-"+(1900+Calendar.getInstance().getTime().getYear())+"-"+"001";
				}
				else
					applyId = obj.getCode()+"-"+(1900+Calendar.getInstance().getTime().getYear())+"-"+applyId;
				//applyId.substring(0,applyId.lastIndexOf('-')+1)+(Long.parseLong(applyId.substring(applyId.lastIndexOf('-')+1))+1);
				((DynaValidatorForm) form).set("applyId",applyId);
				//((DynaValidatorForm) form).set("infoSource",this.deptMgr.find(user.getDeptCode()).getName());
				((DynaValidatorForm) form).set("infoSource",PUBLIC_DEPAERTMENT);//默认发布机构
				request.setAttribute("parentid", parentid);
				request.setAttribute("fromOther", "self");
				request.setAttribute("lsh_type", obj.getAttr2());
				saveToken(request);
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				if (isTokenValid(request, true)) {
				DynaValidatorForm formt=(DynaValidatorForm)form;
				String lsh_type = (String)request.getParameter("lsh_type");
				String infoSource = (String) formt.get("infoSource");
				String title = (String) formt.get("title");
				String authorName = (String) formt.get("authorName");
				String keyword = (String) formt.get("keyword");
				String content = (String)formt.get("content");
				String createTimeTmp = (String) formt.get("createTime");
				String fileCode = (String) formt.get("fileCode");
				String summary = (String) formt.get("summary");
				String publishType = (String) formt.get("publishType");
				String offerWay = (String) formt.get("offerWay");
				String applyId = (String) formt.get("applyId");
				Long status = (Long) formt.get("status");
				String clasel = (String) formt.get("clasel");
				long sendTo = 0;
				
				if (lsh_type==null || "null".equals(lsh_type))
					lsh_type = "";
				
				DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date createTime = null;
				createTime = dateFormat.parse (createTimeTmp);
				
				TbGovInfoPubContent item = new TbGovInfoPubContent(infoSource, title, authorName, keyword, summary, 
						Hibernate.createClob(content), createTime, publishType, fileCode, parentid, offerWay, applyId, 
						status, clasel, p_name, user.getDeptCode(),sendTo,lsh_type);
				this.infoPubContentMgr.saveGovInfoPub(item);
				//发布为其他信息
				if (clasel!=null&&!"".equals(clasel)) {
					TbInfoPubContent item2 = new TbInfoPubContent("", infoSource, title,authorName, keyword, createTime, createTime, "", sendTo,
							parentid, clasel, "", "",new Date(), Hibernate.createClob(content), "",
							summary, "000000", new Long(0), new Date(),"","xw","","","","","","","","","");
					this.infoPubContentMgr.save(item2);
				}
				
				return new ActionForward(
						"/govinfopubContentaction.do?method=list&p_name="+p_name+"&parentid=" + parentid);
			}
				else{
					saveToken(request);
					return new ActionForward(
							"/govinfopubContentaction.do?method=list&p_name="+p_name+"&parentid=" + parentid);
				}
			}
			
		}
		return mapping.findForward("list");
	}
	public ActionForward addFromInfoPub(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String parentid = request.getParameter("parentid");
		TbInfoPubContent obj = (TbInfoPubContent)request.getAttribute("item");
		
		if(parentid.indexOf(',')!=-1)
			parentid = parentid.substring(parentid.indexOf(',')+1);
		
		((DynaValidatorForm) form).set("infoSource",user.getName());
		//request.setAttribute("sendTo", new Long(0));
		request.setAttribute("parentid", parentid);
		
		return mapping.findForward("add");
	}
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, SQLException, IOException {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String p_name = request.getParameter("p_name");
		if (action != null && action.equals("submit")) {
			DynaValidatorForm formt=(DynaValidatorForm)form;
			
			String infoSource = (String) formt.get("infoSource");
			String title = (String) formt.get("title");
			String authorName = (String) formt.get("authorName");
			String keyword = (String) formt.get("keyword");
			String content = (String)formt.get("content");
			String createTimeTmp = (String) formt.get("createTime");
			String fileCode = (String) formt.get("fileCode");
			String summary = (String) formt.get("summary");
			String publishType = (String) formt.get("publishType");
			String offerWay = (String) formt.get("offerWay");
			String applyId = (String) formt.get("applyId");
			Long status = (Long) formt.get("status");
			String clasel = (String) formt.get("clasel");
			
			long sendTo = 0;
			String parentid = request.getParameter("parentid");
			DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date createTime = null;
			createTime = dateFormat.parse (createTimeTmp);
			
			TbGovInfoPubContent item = this.infoPubContentMgr.findGovInfoPubById(id);
			item.setAuthorName(authorName);
			item.setContent(Hibernate.createClob(content));
			item.setCreateTime(createTime);
			item.setInfoSource(infoSource);
			item.setKeyword(keyword);
			item.setSendTo(sendTo);
			item.setTitle(title);
			item.setSummary(summary);
			item.setFileCode(fileCode);
			item.setPublishType(publishType);
			item.setOfferWay(offerWay);
			item.setApplyId(applyId);
			item.setStatus(status);
			item.setAttr1(clasel);
			
			this.infoPubContentMgr.updteGovInfoPub(item);
			if (clasel!=null&&!"".equals(clasel)) {
				TbInfoPubContent item2 = new TbInfoPubContent("", infoSource, title,authorName, keyword, createTime, createTime, "", sendTo,
						parentid, clasel, "", "",new Date(), Hibernate.createClob(content), "",
						summary, "000000", new Long(0), new Date(),"","xw","","","","","","","","","");
				this.infoPubContentMgr.save(item2);
			}
			
			return new ActionForward(
					"/govinfopubContentaction.do?method=list&type=all&p_name="+p_name+"&parentid=" + parentid);
		} else {
			if (id != null && !id.equals("")) {
				String parentid = request.getParameter("parentid");
				
				TbGovInfoPubContent item = this.infoPubContentMgr.findGovInfoPubById(id);
				this.formValueSet(form,item);
				request.setAttribute("parentid", parentid);
				request.setAttribute("fromOther", "self");
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String id = request.getParameter("id");
		if (!"".equals(id)) {
			this.infoPubContentMgr.deleteGovInfoPub(id);
		}
		
		return new ActionForward(
				"/govinfopubContentaction.do?method=list&p_name="+p_name+"&parentid=" + parentid);
	}
	
	public ActionForward bsdshview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String type = request.getParameter("type");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		TbGovInfoPubContent item = this.infoPubContentMgr.findGovInfoPubById(id);
		this.formValueSet(form,item);
		request.setAttribute("parentid", parentid);
		request.setAttribute("p_name", item.getAttr2());
		request.setAttribute("id", item.getFileId());
		request.setAttribute("type", type);
		return mapping.findForward("govbsdshview");
	}
	public ActionForward shehedo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaValidatorForm formt=(DynaValidatorForm)form;
		String p_name = request.getParameter("p_name");
		String parentid = request.getParameter("parentid");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String pubcominfo = request.getParameter("pubcominfo");
		String attr2 = (String)formt.get("attr2");

		TbGovInfoPubContent item = this.infoPubContentMgr.findGovInfoPubById(id);
		item.setStatus(new Long(0));//审核通过
		if (pubcominfo!=null && !"".equals(pubcominfo))
			item.setInfoSubject(pubcominfo);
		item.setAttr2(attr2);
		this.infoPubContentMgr.updteGovInfoPub(item);
		return new ActionForward("/govinfopubContentaction.do?method=list&p_name="
				+ p_name + "&parentid=" + parentid + "&type=" + type);
	}
	private void formValueSet(ActionForm form,TbGovInfoPubContent item) throws SQLException, IOException {
		SerializableClob  sc= (SerializableClob)item.getContent();
		String content = "";
		if (sc!=null) {
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB)wrapclob;
			
			Reader is = clob.getCharacterStream ();
		    BufferedReader br = new BufferedReader ( is );
		    String s = br.readLine ();
		    while ( s != null )
		       {
		         content += s ;
		         s = br.readLine ();
		       }
		       br.close();
		       is.close();
		}   
	    ((DynaValidatorForm) form).set("authorName", item.getAuthorName());
		((DynaValidatorForm) form).set("content", content);
		((DynaValidatorForm) form).set("createTime", item.getCreateTime()+"");
		((DynaValidatorForm) form).set("infoSource", item.getInfoSource());
		((DynaValidatorForm) form).set("keyword", item.getKeyword());
		((DynaValidatorForm) form).set("attr2", item.getAttr2());//栏目名
		((DynaValidatorForm) form).set("title", item.getTitle());
		((DynaValidatorForm) form).set("publishType", item.getPublishType());
		((DynaValidatorForm) form).set("fileCode", item.getFileCode());
		((DynaValidatorForm) form).set("summary", item.getSummary());
		((DynaValidatorForm) form).set("offerWay", item.getOfferWay());
		((DynaValidatorForm) form).set("applyId", item.getApplyId());
		((DynaValidatorForm) form).set("status", item.getStatus());
		((DynaValidatorForm) form).set("clasel", item.getAttr1());
	}

}
