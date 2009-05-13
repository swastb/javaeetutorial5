package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbUser;
import com.baosight.mode.TbVehiclesApply;
import com.baosight.struts.action.BaseDispatchAction;


public class TbVehiclesApplyAction extends BaseDispatchAction {
	
	/*取信息列表*/
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List tbVehiclesApplyList=null;
		
		String action = request.getParameter("action");
		String license=request.getParameter("license");
		
		//条件查询
		if(action.equals("conditionSelect")&&StringUtils.isNotBlank(license))
			tbVehiclesApplyList=this.tbVehiclesApplyMgr.findByLicense('%'+license+'%');
		else
			tbVehiclesApplyList=this.tbVehiclesApplyMgr.findAll();
		request.setAttribute("license", license);

		String userName;
		for (Object object : tbVehiclesApplyList) {
			TbVehiclesApply record=(TbVehiclesApply)object;
			userName=userMgr.find(record.getApplyer()).getName();
			record.setApplyer(userName);
		}
		long count=tbVehiclesApplyList.size();
		startPagingCount(null, request,count);
		startPaging(tbVehiclesApplyList, null, request);
		
		return mapping.findForward("list");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException {
		
		String action = request.getParameter("action");
		
		if (action.equals("add")){
			return mapping.findForward("add");
		}
		if (action.equals("submit")){
			//做新增操作
			HttpSession session = request.getSession();
			TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
			String applyer = user.getId();
			String applyDept = (String) ((DynaValidatorForm) form).get("applyDept");
			String model = (String) ((DynaValidatorForm) form).get("model");
			Long capacity = (Long) ((DynaValidatorForm) form).get("capacity");
			String phone = (String) ((DynaValidatorForm) form).get("phone");
			String dest = (String) ((DynaValidatorForm) form).get("dest");
			String startLoc = (String) ((DynaValidatorForm) form).get("startLoc");
			String startTime = (String) ((DynaValidatorForm) form).get("startTime");
			String reason = (String) ((DynaValidatorForm) form).get("reason");
			String dispatcher = (String) ((DynaValidatorForm) form).get("dispatcher");
			String driver = (String) ((DynaValidatorForm) form).get("driver");
			String license = (String) ((DynaValidatorForm) form).get("license");
			String rem = (String) ((DynaValidatorForm) form).get("rem"); 
            Date startTimeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime+":00"); 
            
			TbVehiclesApply tbVehiclesApply = new TbVehiclesApply();
			tbVehiclesApply.setApplyTime(new Date());
			tbVehiclesApply.setApplyDept(applyDept);
			tbVehiclesApply.setModel(model);
			tbVehiclesApply.setStartTime(startTimeDate);
			tbVehiclesApply.setStartLoc(startLoc);
			tbVehiclesApply.setCapacity(capacity);
			tbVehiclesApply.setApplyer(applyer);
			tbVehiclesApply.setPhone(phone);
			tbVehiclesApply.setDest(dest);
			tbVehiclesApply.setReason(reason);
			tbVehiclesApply.setDispatcher(dispatcher);
			tbVehiclesApply.setDriver(driver);
			tbVehiclesApply.setLicense(license);
			tbVehiclesApply.setRem(rem);
			//审核状态 2：已提交未审核
			tbVehiclesApply.setStatus(new Long(2));
			tbVehiclesApplyMgr.save(tbVehiclesApply);
		}
		return mapping.findForward("success");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, SQLException, IOException {
		
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (StringUtils.isNotBlank(action)&&action.equals("submit")) {
			//做修改操作
			String applyDept = (String) ((DynaValidatorForm) form).get("applyDept");
			String model = (String) ((DynaValidatorForm) form).get("model");
			Long capacity = (Long) ((DynaValidatorForm) form).get("capacity");
			String applyer = (String) ((DynaValidatorForm) form).get("applyer");
			String phone = (String) ((DynaValidatorForm) form).get("phone");
			String dest = (String) ((DynaValidatorForm) form).get("dest");
			String reason = (String) ((DynaValidatorForm) form).get("reason");
			String dispatcher = (String) ((DynaValidatorForm) form).get("dispatcher");
			String driver = (String) ((DynaValidatorForm) form).get("driver");
			String license = (String) ((DynaValidatorForm) form).get("license");
			String rem = (String) ((DynaValidatorForm) form).get("rem");
			
			TbVehiclesApply tbVehiclesApply = tbVehiclesApplyMgr.findById(id);
			tbVehiclesApply.setApplyDept(applyDept);
			tbVehiclesApply.setModel(model);
			tbVehiclesApply.setCapacity(capacity);
			tbVehiclesApply.setApplyer(applyer);
			tbVehiclesApply.setPhone(phone);
			tbVehiclesApply.setDest(dest);
			tbVehiclesApply.setReason(reason);
			tbVehiclesApply.setDispatcher(dispatcher);
			tbVehiclesApply.setDriver(driver);
			tbVehiclesApply.setLicense(license);
			tbVehiclesApply.setRem(rem);
			
			this.tbVehiclesApplyMgr.update(tbVehiclesApply);
		} 
		else if(StringUtils.isNotBlank(id)){
			//跳转编辑页面设置好将要修改的字段
			TbVehiclesApply tbVehiclesApply = tbVehiclesApplyMgr.findById(id);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("applyDept",tbVehiclesApply.getApplyDept());
			if(StringUtils.isNotBlank(tbVehiclesApply.getAuditor()))
				((DynaValidatorForm) form).set("auditor",userMgr.find(tbVehiclesApply.getAuditor()).getName());
			((DynaValidatorForm) form).set("model",tbVehiclesApply.getModel());
			((DynaValidatorForm) form).set("capacity",tbVehiclesApply.getCapacity());
			((DynaValidatorForm) form).set("applyer",tbVehiclesApply.getApplyer());
			((DynaValidatorForm) form).set("phone",tbVehiclesApply.getPhone());
			((DynaValidatorForm) form).set("dest",tbVehiclesApply.getDest());
			((DynaValidatorForm) form).set("reason",tbVehiclesApply.getReason());
			((DynaValidatorForm) form).set("dispatcher",tbVehiclesApply.getDispatcher());
			((DynaValidatorForm) form).set("driver",tbVehiclesApply.getDriver());
			((DynaValidatorForm) form).set("license",tbVehiclesApply.getLicense());
			((DynaValidatorForm) form).set("rem",tbVehiclesApply.getRem());
			String startTimeString = DateFormatUtils.format(tbVehiclesApply.getStartTime(),"yyyy-MM-dd hh:mm");
			((DynaValidatorForm) form).set("startTime",startTimeString);
			return mapping.findForward("add");
		}
		
		return mapping.findForward("success");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)){
			tbVehiclesApplyMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	
}
