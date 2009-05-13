package com.baosight.base.struts.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.CLOB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.lob.SerializableClob;

import com.baosight.base.service.IGovInfoPubContentMgr;
import com.baosight.base.service.TFileAllZfMgr;
import com.baosight.mode.AbstractTFileAllZf;
import com.baosight.mode.TFileAllZf;
import com.baosight.mode.TbGovInfoPubContent;
import com.baosight.struts.action.BaseDispatchAction;



public class GovAction extends BaseDispatchAction{

	private TFileAllZfMgr tfileMgr;

	public TFileAllZfMgr getTfileMgr() {
		return tfileMgr;
	}
	private IGovInfoPubContentMgr govMgr;
	
	public IGovInfoPubContentMgr getGovMgr() {
		return govMgr;
	}
	public void setGovMgr(IGovInfoPubContentMgr govMgr) {
		this.govMgr = govMgr;
	}
	public void setTfileMgr(TFileAllZfMgr tfileMgr) {
		this.tfileMgr = tfileMgr;
	}
	public ActionForward zfxxgk(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
	Long id=null; 
    List list = govMgr.findById(id);
		
		request.setAttribute("list", list);
		return mapping.findForward("zfxxgk");
	}
	
	public ActionForward zfxxgk_login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
	Long id=null; 
		List list = tfileMgr.findById(id);
		
		request.setAttribute("list", list);
		return mapping.findForward("zfxxgk_login");
	}
	
	public ActionForward zfxxgk_more(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
	Long id=null; 
		List list = govMgr.findAllInfo();
		String name = request.getParameter("name");
		request.setAttribute("name", name);
//		request.setAttribute("list", list);
		long count=list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);
		return mapping.findForward("zfxxgk_more");
	}
	
//	 œÍœ∏–≈œ¢œ‘ æ
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String id = request.getParameter("id");
		String title = request.getParameter("title");
		if (title != null && !title.equals("")) {
			List viewResult = this.govMgr.findByTitle(title);
			TbGovInfoPubContent item = (TbGovInfoPubContent) viewResult.get(0);
			SerializableClob sc = (SerializableClob) item.getContent();
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB) wrapclob;
			Reader is = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			String content = "";
			while (s != null) {
				content += s;
				s = br.readLine();
			}
			br.close();
			is.close();

			request.setAttribute("content", content);
			request.setAttribute("item", item);
			return mapping.findForward("view");
		}
		if (id != null && !id.equals("")) {
			TbGovInfoPubContent item = this.govMgr.findById(id);

			SerializableClob sc = (SerializableClob) item.getContent();
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB) wrapclob;
			Reader is = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			String content = "";
			while (s != null) {
				content += s;
				s = br.readLine();
			}
			br.close();
			is.close();

			request.setAttribute("content", content);
			request.setAttribute("item", item);
			return mapping.findForward("view");
		}

		return mapping.findForward("success");
	}
}

