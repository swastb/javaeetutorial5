package com.baosight.base.struts.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.service.ICommissionMgr;
import com.baosight.mode.TbCommission;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class CommissionAction extends InfoPubHelperAction {

	protected ICommissionMgr commissionMgr;
	private static final String COMMISSION = "commlist";
	private static final String BE_COMMISSIONED = "becommedlist";
	private static final String FORWORD_TO = "/commission.do?method=commissionList&type=1";
	private static final String FORWORD_TOED = "/commission.do?method=commissionList&type=2";

	//委托列表
	public ActionForward commissionList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = this.getCurrentUser(request);
		String type = request.getParameter("type");//1 委托列表 2 被委托列表
		String comm_name = request.getParameter("comm_name");
		String beginTime = request.getParameter("biginTime");
		String endTime = request.getParameter("endTime");
		Date now = new Date();
		
		List commissionlist = this.commissionMgr.findCommissionListByType(user,comm_name,beginTime,endTime,now,type);
		
		//List beCommissionedlist = this.commissionMgr.findCommissionListByType(user,type);
		
		//request.setAttribute("commissionlist", commissionlist);
		//request.setAttribute("commissionlist", beCommissionedlist);
		long count =  commissionlist.size();
		startPagingCount(null, request,count);
		startPaging(commissionlist, null, request);
		String forword = "1".equals(type)?COMMISSION:BE_COMMISSIONED;
		return mapping.findForward(forword);
	}
	//新增加委托
	public ActionForward addCommission(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String action = request.getParameter("action");
		TbUser user = this.getCurrentUser(request);
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				
				((DynaValidatorForm) form).set("commName",user.getName());
				
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String commTitle = (String) ((DynaValidatorForm) form).get("commTitle");
				String becommedId = (String) ((DynaValidatorForm) form).get("becommedId");
				String becommedName = (String) ((DynaValidatorForm) form).get("becommedName");
				String begintimeT = (String) ((DynaValidatorForm) form).get("begintime");
				String endtimeT = (String) ((DynaValidatorForm) form).get("endtime");
				String commMatters = (String)((DynaValidatorForm) form).get("commMatters");
				String saveType = request.getParameter("saveType");//tongyi zancun
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date begintime = dateFormat.parse(begintimeT);
				Date endtime = dateFormat.parse(endtimeT);
				
				TbCommission item = new TbCommission(commTitle, user.getId(), user.getName(), becommedId,
						becommedName, begintime,endtime, commMatters,Long.parseLong(saveType),
						"","","");
				
				this.commissionMgr.save(item);
				if(saveType!=null && saveType.equals("1")){
					//待办事宜委托增加
					//委托人增加
					super.tbUserOpeationMgr.SaveOrUpdate(user.getId(),"70","add");
					//被委托人增加
					super.tbUserOpeationMgr.SaveOrUpdate(becommedId,"710","add");
				}

				
				return new ActionForward(FORWORD_TO);
			}
		}
		return new ActionForward(FORWORD_TO);
	}
	//委托修改
	public ActionForward modCommission(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		TbCommission item = this.commissionMgr.findById(id);
		if (action != null && action.equals("submit")) {
			String commTitle = (String) ((DynaValidatorForm) form).get("commTitle");
			String becommedId = (String) ((DynaValidatorForm) form).get("becommedId");
			String becommedName = (String) ((DynaValidatorForm) form).get("becommedName");
			String begintimeT = (String) ((DynaValidatorForm) form).get("begintime");
			String endtimeT = (String) ((DynaValidatorForm) form).get("endtime");
			String commMatters = (String)((DynaValidatorForm) form).get("commMatters");
			String saveType = request.getParameter("saveType");//tongyi zancun
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date begintime = dateFormat.parse(begintimeT);
			Date endtime = dateFormat.parse(endtimeT);
			item.setCommTitle(commTitle);
			item.setBecommedId(becommedId);
			item.setBecommedName(becommedName);
			item.setBegintime(begintime);
			item.setEndtime(endtime);
			item.setCommMatters(commMatters);
			item.setCommFlag(Long.parseLong(saveType));
		
			this.commissionMgr.update(item);
			
			//待办事宜委托增加
			//委托人增加
			super.tbUserOpeationMgr.SaveOrUpdate(item.getCommId(),"70","add");
			//被委托人增加
			super.tbUserOpeationMgr.SaveOrUpdate(becommedId,"710","add");		
			
			return new ActionForward(FORWORD_TO);
		} else {
			if (id != null && !id.equals("")) {
				
				setFormValue(form,item);
				
				return mapping.findForward("add");
			}
		}
		return new ActionForward(FORWORD_TO);
	}

	//删除委托
	public ActionForward delCommission(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		//待办事宜委托减少
		TbCommission item = this.commissionMgr.findById(id);
		if(item!=null){
			Long commFlag = item.getCommFlag();
			if(commFlag!=null && commFlag==1){
				//委托人减少
				super.tbUserOpeationMgr.SaveOrUpdate(item.getCommId(),"70","minus");
				//被委托人减少
				super.tbUserOpeationMgr.SaveOrUpdate(item.getBecommedId(),"710","minus");
			}			
		}
		
		this.commissionMgr.delete(id);				
		return new ActionForward(FORWORD_TO);
	}
	//查看委托
	public ActionForward viewCommission(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		TbCommission item = this.commissionMgr.findById(id);
		setFormValue(form,item);
		return mapping.findForward("view");
	}
	public void setFormValue(ActionForm form, TbCommission item) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		((DynaValidatorForm) form).set("id", item.getId());
		((DynaValidatorForm) form).set("commTitle", item.getCommTitle());
		((DynaValidatorForm) form).set("commName", item.getCommName());
		((DynaValidatorForm) form).set("becommedId", item.getBecommedId());
		((DynaValidatorForm) form).set("becommedName", item.getBecommedName());
		((DynaValidatorForm) form).set("begintime", dateFormat.format(item.getBegintime()));
		((DynaValidatorForm) form).set("endtime", dateFormat.format(item.getEndtime()));
		((DynaValidatorForm) form).set("commMatters", item.getCommMatters());
	}
	//被委托人处理委托－同意或不同意
	public ActionForward dealCommission(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String yesorno = request.getParameter("yesorno");
		TbCommission item = this.commissionMgr.findById(id);
		item.setCommFlag(Long.parseLong(yesorno));
		this.commissionMgr.update(item);
		
		//待办事宜委托减少
		//委托人减少
		super.tbUserOpeationMgr.SaveOrUpdate(item.getCommId(),"70","minus");
		//被委托人减少
		super.tbUserOpeationMgr.SaveOrUpdate(item.getBecommedId(),"710","minus");	
		
		return new ActionForward(FORWORD_TO);
	}
	//自动登陆到委托人系统
	public ActionForward autoLoginTo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String commId = request.getParameter("userId");
		TbUser userN = this.getCurrentUser(request);
		TbUser user = this.userMgr.find(commId);
		HttpSession session = request.getSession();
		session.invalidate();
		String url="/login.do?loginUser="+user.getUserAcc()+"&password="+user.getPwd()+"&auto=true&commedName="+userN.getName();
		return new ActionForward(url);
	}
	public void setcommissionMgr(ICommissionMgr commissionMgr) {
		this.commissionMgr = commissionMgr;
	}

	public ActionForward isSameDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String becommedId = request.getParameter("becommedId");
		TbUser user = this.getCurrentUser(request);
		TbUser userCommed = this.userMgr.find(becommedId);
		
		boolean result = user.getDeptCode().equals(userCommed.getDeptCode());
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
	
	public ActionForward userTreeForSameDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = this.getCurrentUser(request);
		Map map = this.commissionMgr.findUserTree(user);
		request.setAttribute("root", map.get("root"));
		request.setAttribute("userTree", map.get("userList"));
		return mapping.findForward("userTree");
	}
}
