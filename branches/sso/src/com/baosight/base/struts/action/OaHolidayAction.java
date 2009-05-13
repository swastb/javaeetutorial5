package com.baosight.base.struts.action;

import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbOaHoliday;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tools.YearList;

public class OaHolidayAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Calendar calendar = Calendar.getInstance();
		String i = String.valueOf(calendar.get(Calendar.YEAR));   
		String b = String.valueOf(calendar.get(Calendar.MONTH)+1);   

		List allOaHoliday = this.oaholidayMgr.findSysDate();
		request.setAttribute("allOaHoliday", allOaHoliday);
		List yearList = YearList.getYearList(-2, 5);
		List monthList = YearList.getMonthList(12);
	
		request.setAttribute("year", i);
		request.setAttribute("yearE", i);
		request.setAttribute("month", b);
		request.setAttribute("yearList", yearList);
		request.setAttribute("yearListE", yearList);
		request.setAttribute("monthList", monthList);

		return mapping.findForward("list");
	}

	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		if (id != null && !id.equals("")) {
			oaholidayMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	
	public ActionForward selectDate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		List year_month = this.oaholidayMgr.listDate(year, month);
		request.setAttribute("allOaHoliday", year_month);
		List yearList = YearList.getYearList(-2, 5);
		List monthList = YearList.getMonthList(12);
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("yearE", year);
		request.setAttribute("yearList", yearList);
		request.setAttribute("yearListE", yearList);
		request.setAttribute("monthList", monthList);


		return mapping.findForward("list");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				((DynaValidatorForm) form).set("amPm","am_pm");
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String tempHoliday = (String) ((DynaValidatorForm) form).get("holiday");
				DateFormat format= new SimpleDateFormat("yyyy-MM-dd");         
				Date holiday=null;
				try {
					holiday = format.parse(tempHoliday);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String amPm = (String) ((DynaValidatorForm) form).get("amPm");
				Float day=null;
				if(amPm.equals("am_pm"))
				{
					day=1.0F;
				}
				else
				{
					day=0.5F;
				}
				String description = (String) ((DynaValidatorForm) form).get("description");
				TbOaHoliday item = new TbOaHoliday(holiday,amPm,day,description);
				this.oaholidayMgr.save(item);
				return mapping.findForward("ok");
			}
		}
		return mapping.findForward("list");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String tempHoliday = (String) ((DynaValidatorForm) form).get("holiday");
			DateFormat format= new SimpleDateFormat("yyyy-MM-dd");         
			Date holiday=null;
			try {
				holiday = format.parse(tempHoliday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String amPm = (String) ((DynaValidatorForm) form).get("amPm");
			
			Float day=null;
			if(amPm.equals("am_pm"))
			{
				day=1.0F;
			}
			else
			{
				day=0.5F;
			}
			
			String description = (String) ((DynaValidatorForm) form).get("description");
			TbOaHoliday item = this.oaholidayMgr.findById(id);
			item.setHoliday(holiday);
			item.setAmPm(amPm);
			item.setDay(day);
			item.setDescription(description);
			this.oaholidayMgr.updte(item);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbOaHoliday item = this.oaholidayMgr.findById(id);
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				((DynaValidatorForm) form).set("holiday", sf.format(item.getHoliday()));
				((DynaValidatorForm) form).set("amPm", item.getAmPm());
				((DynaValidatorForm) form).set("id", item.getId());
				((DynaValidatorForm) form).set("description", item.getDescription());
				request.setAttribute("year", year);
				request.setAttribute("month", month);
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}
	
	
	public ActionForward selectsunsat(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String yearE = request.getParameter("yearE");
		
		List listYearArb = this.oaholidayMgr.findYearArb(yearE, "1");
		for (int i = 0; i < listYearArb.size(); i++) {
			String id = listYearArb.get(i).toString();
			oaholidayMgr.delete(id);
		}
		
		List listsunsat = this.oaholidayMgr.findSunSat(yearE);
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		for (int j = 0; j < listsunsat.size(); j++) {

			String date = listsunsat.get(j).toString();
			Date dates = format1.parse(date);
			TbOaHoliday item = new TbOaHoliday(dates,"am_pm",1.0F,"","ÖÜÄ©","1");
			this.oaholidayMgr.save(item);
		}
		return mapping.findForward("ok");
	}
}
