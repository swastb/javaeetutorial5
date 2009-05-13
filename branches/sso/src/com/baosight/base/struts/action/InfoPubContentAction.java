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

import org.apache.commons.lang.StringUtils;
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

public class InfoPubContentAction extends InfoPubHelperAction {
	/* 文本编辑测试 */
	public ActionForward test(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		return mapping.findForward("test");
	}

	/* 取信息列表 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String id = request.getParameter("id");
		String act = request.getParameter("act");
		String name = request.getParameter("name");
		String infoname = request.getParameter("infoname");
		String type = request.getParameter("type");
		/*//2008-10-30 start
		String deptId = "";
		//判断是否为管理员
		if (this.infoPubContentMgr.isAdministrator(user))
			deptId = "all";
		else
			deptId = user.getDeptCode();
		//2008-10-30 end
*/		List infoConList = this.infoPubContentMgr.findByPIdInfoName(user,parentid,
				infoname == null ? "" : infoname, type);

		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("act", act);
		request.setAttribute("p_name", p_name);
		long count = infoConList.size();
		
		startPaging(infoConList, null, request);
		startPagingCount(null, request,count);
		if ("bs".equals(type) || "dsh".equals(type) || "spxx".equals(type))
			return mapping.findForward("bsdshlist");
		else
			return mapping.findForward("infolist");

	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws java.text.ParseException, SQLException, IOException {
		String action = request.getParameter("action");
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String pubcominfo = request.getParameter("pubcominfo");
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				long iscopyright = 0;
				((DynaValidatorForm) form).set("iscopyright", iscopyright);
				((DynaValidatorForm) form).set("infoSource", this.deptMgr.find(
						user.getDeptCode()).getName());
				((DynaValidatorForm) form).set("infocla", p_name);

				request.setAttribute("sendTo", new Long(0));
				request.setAttribute("parentid", parentid);
				saveToken(request);
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				if (isTokenValid(request, true)) {
					String claSelId = request.getParameter("claId");
					if (!"".equals(claSelId) && claSelId!=null)
						parentid = claSelId;
					DynaValidatorForm formt = (DynaValidatorForm) form;
					String infoclas = (String) formt.get("infoclas");//duo lan mu ming
					String summaryTitle = (String) formt.get("summaryTitle");
					String infoSource = (String) formt.get("infoSource");
					String title = (String) formt.get("title");
					String authorName = (String) formt.get("authorName");
					String keyword1 = (String) formt.get("keyword1");
					String keyword2 = (String) formt.get("keyword2");
					String keyword3 = (String) formt.get("keyword3");
					String keyword4 = (String) formt.get("keyword4");
					String content = (String) formt.get("content");
					String createTimeTmp = (String) formt.get("createTime");
					String topTimeTmp = (String) formt.get("topTime");
					String summary = (String) formt.get("summary");
					String titleColor = (String) formt.get("titleColor");
					Long iscopyright = (Long) formt.get("iscopyright");
					String infoType = (String) formt.get("infoType");
					String clasel = (String) formt.get("clasel");//duo lan mu ids
					String infocla = (String) formt.get("infocla");
					Long sendTo = (Long) formt.get("sendTo");// 不用审核,待审核,报送
					
					String addType = request.getParameter("addType");
					String col0V = (String) formt.get("col0V");
					String col1V = (String) formt.get("col1V");
					String col2V = (String) formt.get("col2V");
					String col3V = (String) formt.get("col3V");
					String col4V = (String) formt.get("col4V");
					String col5V = (String) formt.get("col5V");
					String col6V = (String) formt.get("col6V");
					String col7V = (String) formt.get("col7V");
					String col8V = (String) formt.get("col8V");
					
					Date recordTime = new Date();
					DateFormat dateFormat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm");
					Date createTime = null, topTime = null;
					createTime = dateFormat.parse(createTimeTmp);
					if (!"".equals(StringUtils.trimToEmpty(topTimeTmp)))
						topTime = dateFormat.parse(topTimeTmp);
					//2008-12-22
					String keyword = keyword1+","+keyword2+","+keyword3+","+keyword4;
					//publishFlag 表示是哪个栏目数下的消息
					String publishFlag = request.getParameter("publishFlag");
					TbInfoPubContent item = new TbInfoPubContent(user.getDeptCode(),
							infoSource, title, authorName, keyword.toString(), createTime,
							createTime, publishFlag, sendTo, parentid, clasel, infocla,
							infoclas, recordTime, Hibernate.createClob(content),
							summaryTitle, summary, titleColor, iscopyright,
							topTime, infoType,addType,col0V,col1V,col2V,col3V,col4V,col5V,col6V,col7V,col8V);
					this.infoPubContentMgr.save(item);
					String forword = "/infopubContentaction.do?method=list&p_name="
						+ p_name
						+ "&parentid="
						+ parentid
						+ "&type=infopub";
					if (pubcominfo != null && !"".equals(pubcominfo))
						this.addGovInfoCon(item,content,pubcominfo);
					return new ActionForward(forword);
				} else {
					saveToken(request);
					String forword = "/infopubContentaction.do?method=list&p_name="
								+ p_name
								+ "&parentid="
								+ parentid
								+ "&type=infopub";
					return new ActionForward(forword);
				}
			}

		}
		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws java.text.ParseException, SQLException, IOException {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String p_name = request.getParameter("p_name");
		String pubcominfo = request.getParameter("pubcominfo");
		DynaValidatorForm formt = (DynaValidatorForm) form;
		if (action != null && action.equals("submit")) {
			String parentid = request.getParameter("parentid");
			if (isTokenValid(request, true)) {
			String infoSource = (String) formt
					.get("infoSource");
			String title = (String) formt.get("title");
			String authorName = (String) formt
					.get("authorName");
			String keyword1 = (String) formt.get("keyword1");
			String keyword2 = (String) formt.get("keyword2");
			String keyword3 = (String) formt.get("keyword3");
			String keyword4 = (String) formt.get("keyword4");
			String content = (String) formt.get("content");
			String createTimeTmp = (String) formt
					.get("createTime");
			String summary = (String) formt.get("summary");
			String titleColor = (String) formt
					.get("titleColor");
			Long iscopyright = (Long) formt
					.get("iscopyright");
			String infoType = (String) formt
					.get("infoType");
			String summaryTitle = (String) formt
					.get("summaryTitle");
			String topTimeTmp = (String) formt
					.get("topTime");
			String clasel = (String) formt.get("clasel");
			String infocla = (String) formt.get("infocla");
			Long status = (Long) formt.get("sendTo");
			String infoclas = (String) formt.get("infoclas");//duo lan mu ming
			String keyword = keyword1+","+keyword2+","+keyword3+","+keyword4;
			// long sendTo = 0;
			String addType = request.getParameter("addType");
			String col0V = (String) formt.get("col0V");
			String col1V = (String) formt.get("col1V");
			String col2V = (String) formt.get("col2V");
			String col3V = (String) formt.get("col3V");
			String col4V = (String) formt.get("col4V");
			String col5V = (String) formt.get("col5V");
			String col6V = (String) formt.get("col6V");
			String col7V = (String) formt.get("col7V");
			String col8V = (String) formt.get("col8V");
			// Date recordTime = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date createTime = null, topTime = null;
			createTime = dateFormat.parse(createTimeTmp);
			if (!"".equals(StringUtils.trimToEmpty(topTimeTmp))
					&& StringUtils.trimToEmpty(topTimeTmp) != null)
				topTime = dateFormat.parse(topTimeTmp);
			TbInfoPubContent item = this.infoPubContentMgr.findById(id);
			item.setAuthorName(authorName);
			item.setContent(Hibernate.createClob(content));
			item.setCreateTime(createTime);
			item.setInfoSource(infoSource);
			item.setKeyword(keyword);
			item.setSendTo(status);// 不用审核,待审核,报送
			item.setTitle(title);
			item.setSummary(summary);
			item.setSummaryTitle(summaryTitle);
			item.setTitleColor(titleColor);
			item.setInfoType(infoType);
			item.setIscopyright(iscopyright);
			item.setTopTime(topTime);
			item.setAttr1(clasel);
			item.setAttr2(infocla);
			item.setAttr3(infoclas);
			item.setAddType(addType);
			item.setCol0V(col0V);
			item.setCol1V(col1V);
			item.setCol2V(col2V);
			item.setCol3V(col3V);
			item.setCol4V(col4V);
			item.setCol5V(col5V);
			item.setCol6V(col6V);
			item.setCol7V(col7V);
			item.setCol8V(col8V);
			
			this.infoPubContentMgr.updte(item);
			if (pubcominfo != null && !"".equals(pubcominfo)) {
				this.addGovInfoCon(item,content,pubcominfo);
			}
			ActionForward fwd = new ActionForward("/infopubContentaction.do?method=list&p_name=" + p_name
					+ "&parentid=" + parentid + "&type=infopub");		
			return fwd;
			}
			else {
				saveToken(request);
				return new ActionForward("/infopubContentaction.do?method=list&p_name=" + p_name
						+ "&parentid=" + parentid + "&type=infopub");
			}
		} else {
			if (id != null && !id.equals("")) {
				String parentid = request.getParameter("parentid");
				TbInfoPubContent item = this.infoPubContentMgr.findById(id);
				formSet(form, item);
				request.setAttribute("parentid", parentid);
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}
	public String clobToString(Clob contentClob) throws SQLException, IOException {
		if(contentClob!=null){
		String content = "";
		SerializableClob sc = (SerializableClob)contentClob;
		Clob wrapclob = sc.getWrappedClob();
		CLOB clob = (CLOB) wrapclob;

		Reader is = clob.getCharacterStream();
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		
		while (s != null) {
			content += s;
			s = br.readLine();
		}
		br.close();
		is.close();
		return content;
		}
		else return null;
	}
	public void addGovInfoCon(TbInfoPubContent item,String content,String pubcominfo) throws SQLException, IOException{
		String applyId="";
		applyId = this.infoPubContentMgr.findMaxLiuShHByPId(pubcominfo);//根据栏目找该栏目下流水号最大的的索取号
		if ("".equals(applyId)) {
			String clacode = this.infoPubClaMgr.findById(pubcominfo).getCode();
			applyId = clacode+"-"+(1900+Calendar.getInstance().getTime().getYear())+"-"+"1";
		}
		else
			applyId = applyId.substring(0,applyId.lastIndexOf('-')+1)+(Long.parseLong(applyId.substring(applyId.lastIndexOf('-')+1))+1);
		TbInfoPubCla claItem = this.infoPubClaMgr.findById(pubcominfo);
		TbGovInfoPubContent govitem = new TbGovInfoPubContent(item.getInfoSource(),item.getTitle(), item.getAuthorName(), item.getKeyword(), item.getSummary(), 
				 Hibernate.createClob(content), item.getCreateTime(), "10", "", pubcominfo, "4", applyId, 
				new Long(2), "", claItem.getName(), "",new Long(0),claItem.getAttr2());
		this.infoPubContentMgr.saveGovInfoPub(govitem);
	}
	public void formSet(ActionForm form,TbInfoPubContent item) throws SQLException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String content = clobToString(item.getContent());
		String keyword = item.getKeyword();
		DynaValidatorForm formt = (DynaValidatorForm) form;
		formt.set("authorName", item.getAuthorName());
		formt.set("content", content);
		formt.set("createTime", sdf.format(item.getCreateTime())+ "");
		formt.set("infoType", item.getInfoType());
		formt.set("infoSource", item.getInfoSource());
		formt.set("keyword1", keyword.split(",")[0]);
		formt.set("keyword2", keyword.split(",")[1]);
		formt.set("keyword3", keyword.split(",")[2]);
		formt.set("keyword4", keyword.split(",")[3]);
		formt.set("sendTo", item.getSendTo());
		formt.set("title", item.getTitle());
		formt.set("summaryTitle", item.getSummaryTitle());
		formt.set("titleColor", item.getTitleColor());
		formt.set("summary", item.getSummary());
		formt.set("topTime", item.getTopTime()==null?"":sdf.format(item.getTopTime())
				+ "");
		formt.set("clasel", item.getAttr1());
		formt.set("infoclas", item.getAttr3()!=null?item.getAttr3():item.getAttr2());
		formt.set("iscopyright", item.getIscopyright());
		formt.set("infocla", item.getAttr2());
		//formt.set("infoclas", item.getAttr3());
		formt.set("col0V", item.getCol0V());
		formt.set("col1V", item.getCol1V());
		formt.set("col2V", item.getCol2V());
		formt.set("col3V", item.getCol3V());
		formt.set("col4V", item.getCol4V());
		formt.set("col5V", item.getCol5V());
		formt.set("col6V", item.getCol6V());
		formt.set("col7V", item.getCol7V());
		formt.set("col8V", item.getCol8V());
	}
	public ActionForward bsdshview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String parentid = request.getParameter("parentid");
		String type = request.getParameter("type");
		TbInfoPubContent item = this.infoPubContentMgr.findById(id);
		formSet(form, item);
		request.setAttribute("parentid", parentid);
		request.setAttribute("p_name", item.getAttr2());
		request.setAttribute("id", item.getId());
		request.setAttribute("type", type);
		return mapping.findForward("bsdshview");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String id = request.getParameter("id");
		if (!"".equals(id)) {
			this.infoPubContentMgr.delete(id);
		}

		return new ActionForward("/infopubContentaction.do?method=list&p_name="
				+ p_name + "&parentid=" + parentid + "&type=infopub");
	}

	public ActionForward shehedo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//String apparise = request.getParameter("apparise");
		String p_name = request.getParameter("p_name");
		String parentid = request.getParameter("parentid");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		
		String clasel = (String) ((DynaValidatorForm) form).get("clasel");
		String infoclas = (String) ((DynaValidatorForm) form).get("infoclas");//duo lan mu ming
		
		TbInfoPubContent item = this.infoPubContentMgr.findById(id);
		item.setSendTo(new Long(4));
		item.setAttr1(clasel);
		item.setAttr3(infoclas);
		this.infoPubContentMgr.updte(item);

		return new ActionForward("/infopubContentaction.do?method=list&p_name="
				+ p_name + "&parentid=" + parentid + "&type=" + type);
	}

	public ActionForward rollbackdo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String p_name = request.getParameter("p_name");
		String parentid = request.getParameter("parentid");
		String type = request.getParameter("type");
		String id = request.getParameter("id");

		// TbInfoPubContent item = this.infoPubContentMgr.findById(id);
		// item.setSendTo(new Long(4));
		// this.infoPubContentMgr.updte(item);

		return new ActionForward("/infopubContentaction.do?method=list&p_name="
				+ p_name + "&parentid=" + parentid + "&type=" + type);
	}

	// 详细信息显示
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String id = request.getParameter("id");
		String title = request.getParameter("title");
		if (title != null && !title.equals("")) {
			List viewResult = this.infoPubContentMgr.findByTitle(title);
			TbInfoPubContent item = (TbInfoPubContent) viewResult.get(0);
			String content = clobToString(item.getContent());

			request.setAttribute("content", content);
			request.setAttribute("item", item);
			return mapping.findForward("view");
		}
		if (id != null && !id.equals("")) {
			TbInfoPubContent item = this.infoPubContentMgr.findById(id);

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
	/*受理中心信息查看*/
	public ActionForward slzxInfoList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String parentid = request.getParameter("parentid");
		String p_name = request.getParameter("p_name");
		String infoname = request.getParameter("infoname");
		
		List infoConList = this.infoPubContentMgr.findSlzxInfoList(parentid,
				infoname == null ? "" : infoname);
		
		request.setAttribute("p_name", p_name);
		long count = infoConList.size();
		
		startPaging(infoConList, null, request);
		startPagingCount(null, request,count);
		
		return mapping.findForward("slzxInfoList");
	}
	/* 首页显示的新闻中心,通知通告,水务动态 */
	public ActionForward news(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String xwzx = request.getParameter("xwzx");
		String tongzhitonggao = request.getParameter("tongzhitonggao");
		String swdt = request.getParameter("swdt");

		List resultList1 = null;
		List resultList2 = null;
		List resultList3 = null;
		List claId1 = this.infoPubClaMgr.getId(xwzx);
		if(!claId1.isEmpty()) {
			resultList1 = this.infoPubContentMgr.findByInfoSubjectlist(claId1.get(0));
		}
		List claId2 = this.infoPubClaMgr.getId(tongzhitonggao);
		if(!claId2.isEmpty()) {
			resultList2 = this.infoPubContentMgr.findByInfoSubjectlist(claId2.get(0));
		}
		List claId3 = this.infoPubClaMgr.getId(swdt);
		if(!claId3.isEmpty()) {
			resultList3 = this.infoPubContentMgr.findByInfoSubjectlist(claId3.get(0));
		}

		request.setAttribute("resultList1", resultList1);
		request.setAttribute("resultList2", resultList2);
		request.setAttribute("resultList3", resultList3);
		return mapping.findForward("news");

	}

/*防汛动态*/
public ActionForward fxdt(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response){
	String code=request.getParameter("code");
	List resultList = null;
	List claId = this.infoPubClaMgr.getId(code);
	if(!claId.isEmpty()) {
		resultList = this.infoPubContentMgr
				.findByInfoSubject(claId.get(0),"fxdt");
	}
	request.setAttribute("resultList", resultList);
	return mapping.findForward("fxdt");
}
/*水资源动态*/
public ActionForward szydt(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response){
	String code=request.getParameter("code");
	List resultList = null;
	List claId = this.infoPubClaMgr.getId(code);
	if(!claId.isEmpty()) {
		resultList = this.infoPubContentMgr
				.findByInfoSubject(claId.get(0),"fxdt");
	}
	request.setAttribute("resultList", resultList);
	return mapping.findForward("szydt");
}
/*防汛动态 显示更多信息*/
public ActionForward fxdt_more(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {

	String code = request.getParameter("code");
	String name = request.getParameter("name");

	List resultListMore = null;
	long count=0;
	List claId = this.infoPubClaMgr.getId(code);
	if(!claId.isEmpty()) {
		resultListMore = this.infoPubContentMgr
				.findByInfoSubjectList(claId.get(0));
		count=this.infoPubContentMgr.findCountByInfoSubject(claId.get(0));
	}
	request.setAttribute("name", name);
	
	request.setAttribute("resultList", resultListMore);
	startPagingCount(null, request,count);
	startPaging(resultListMore, null, request);
	return mapping.findForward("fxdt_more");

}
/*水资源动态 显示更多信息*/
public ActionForward szydt_more(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {

	String code = request.getParameter("code");
	String name = request.getParameter("name");

	List resultList = null;
	long count=0;
	List claId = this.infoPubClaMgr.getId(code);
	if(!claId.isEmpty()) {
		resultList = this.infoPubContentMgr
				.findByInfoSubjectList(claId.get(0));
		count=this.infoPubContentMgr.findCountByInfoSubject(claId.get(0));
	}
	request.setAttribute("name", name);
	request.setAttribute("resultList", resultList);
	startPagingCount(null, request,count);
	startPaging(resultList, null, request);
	return mapping.findForward("szydt_more");

}

	/* 首页显示的网站动态 */
	public ActionForward wzdt(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("wzdt");

	}

	/* 政务专栏显示的通知通告 */
	public ActionForward tztg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("tztg");

	}

	/* 政务专栏显示的水务动态 */
	public ActionForward swdt(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList2", resultList);
		return mapping.findForward("swdt");

	}

	/* 政务专栏显示的最新播报 */
	public ActionForward zxbb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("zxbb");

	}

	/* 政务专栏显示的公示 */
	public ActionForward gongshi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("gongshi");

	}

	/* 政务专栏显示的常用信息 */
	public ActionForward information(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("information");

	}

	/* 登陆后页面显示的通知通告 */
	public ActionForward tztg_login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("tztg_login");

	}

	/* 登陆后页面显示的常用信息 */
	public ActionForward information_login(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("information_login");

	}

	/* 登陆后页面显示的公示 */
	public ActionForward gongshi_login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("gongshi_login");

	}

	/* 首页显示的网站动态更多信息 */
	public ActionForward wzdt_more(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");
		String name = request.getParameter("name");

		List resultList = null;
		long count=0;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
			count=this.infoPubContentMgr.findCountByInfoSubject(claId.get(0));
		}
		request.setAttribute("name", name);
		request.setAttribute("resultList", resultList);
		startPagingCount(null, request,count);
		startPaging(resultList, null, request);
		return mapping.findForward("wzdt_more");

	}

/* 首页显示的公开年报 */
	public ActionForward gknb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");

		List resultList = null;
		List claId = this.infoPubClaMgr.getId(code);
		if(!claId.isEmpty()) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId.get(0),"");
		}
		request.setAttribute("resultList", resultList);
		return mapping.findForward("gknb");

	}
}
