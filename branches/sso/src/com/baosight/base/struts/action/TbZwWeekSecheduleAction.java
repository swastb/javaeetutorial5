package com.baosight.base.struts.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbAuthlvl;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbZwWeekSechedule;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tools.WeekManager;

public class TbZwWeekSecheduleAction extends BaseDispatchAction {

	public ActionForward resultlist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TbUser user = (TbUser) request.getSession().getAttribute(
				"SYSTEM_USER_SESSION");

		Date date = null;

		// 得到为x年x周
		String weekofyear = request.getParameter("weekofyear");

		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");

		if (starttime == null || "".equals(starttime)) {
			date = new Date();
			starttime = WeekManager.getSunday(date);
			weekofyear = WeekManager.getSeqWeek();
		} else {
			date = WeekManager.strToDate(starttime);
		}
		if (endtime == null || "".equals(endtime)) {
			date = new Date();
			endtime = WeekManager.getSaturday(date);
			weekofyear = WeekManager.getSeqWeek();
		} else {
			date = WeekManager.strToDate(endtime);
		}

		List allweekSechedule = new ArrayList();

		List weekdayList = new ArrayList();

		List sundayList = null;
		List mondayList = null;
		List tuesdayList = null;
		List wednesdayList = null;
		List thursdayList = null;
		List fridayList = null;
		List saturdayList = null;

		weekdayList.add(WeekManager.getSunday(date) + "(星期日)");
		weekdayList.add(WeekManager.getMonday(date) + "(星期一)");
		weekdayList.add(WeekManager.getTuesday(date) + "(星期二)");
		weekdayList.add(WeekManager.getWednesday(date) + "(星期三)");
		weekdayList.add(WeekManager.getThursday(date) + "(星期四)");
		weekdayList.add(WeekManager.getFriday(date) + "(星期五)");
		weekdayList.add(WeekManager.getSaturday(date) + "(星期六)");

		TbZwWeekSechedule zw = null;

		zw = new TbZwWeekSechedule();
		zw.setWeekofyear(weekofyear);
		zw.setAttr2("星期日");
		// 当前用户只能看到本部门的部门日程和本人日程
		zw.setDept(user.getUserdept());
		zw.setPrivateUserId(user.getId());
		sundayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

		zw = new TbZwWeekSechedule();
		zw.setWeekofyear(weekofyear);
		zw.setAttr2("星期一");
		// 当前用户只能看到本部门的部门日程和本人日程
		zw.setDept(user.getUserdept());
		zw.setPrivateUserId(user.getId());
		mondayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

		zw = new TbZwWeekSechedule();
		zw.setWeekofyear(weekofyear);
		zw.setAttr2("星期二");
		// 当前用户只能看到本部门的部门日程和本人日程
		zw.setDept(user.getUserdept());
		zw.setPrivateUserId(user.getId());
		tuesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

		zw = new TbZwWeekSechedule();
		zw.setWeekofyear(weekofyear);
		zw.setAttr2("星期三");
		// 当前用户只能看到本部门的部门日程和本人日程
		zw.setDept(user.getUserdept());
		zw.setPrivateUserId(user.getId());
		wednesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

		zw = new TbZwWeekSechedule();
		zw.setWeekofyear(weekofyear);
		zw.setAttr2("星期四");
		// 当前用户只能看到本部门的部门日程和本人日程
		zw.setDept(user.getUserdept());
		zw.setPrivateUserId(user.getId());
		thursdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

		zw = new TbZwWeekSechedule();
		zw.setWeekofyear(weekofyear);
		zw.setAttr2("星期五");
		// 当前用户只能看到本部门的部门日程和本人日程
		zw.setDept(user.getUserdept());
		zw.setPrivateUserId(user.getId());
		fridayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

		zw = new TbZwWeekSechedule();
		zw.setWeekofyear(weekofyear);
		zw.setAttr2("星期六");
		// 当前用户只能看到本部门的部门日程和本人日程
		zw.setDept(user.getUserdept());
		zw.setPrivateUserId(user.getId());
		saturdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

		// request.setAttribute("alllist", alllist);

		request.setAttribute("allweekSechedule", allweekSechedule);
		//
		request.setAttribute("weekdayList", weekdayList);

		request.setAttribute("sundayList", sundayList);
		request.setAttribute("mondayList", mondayList);
		request.setAttribute("tuesdayList", tuesdayList);
		request.setAttribute("wednesdayList", wednesdayList);
		request.setAttribute("thursdayList", thursdayList);
		request.setAttribute("fridayList", fridayList);
		request.setAttribute("saturdayList", saturdayList);

		request.setAttribute("weekofyear", weekofyear);
		request.setAttribute("starttime", starttime);
		request.setAttribute("endtime", endtime);

		System.out.println("获得一周日程安排" + endtime);

		return mapping.findForward("list");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {

			Date date = null;
			// 得到个人最近两天的日程
			if ("personNow".equals(action)) {
				// 当前用户
				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");
				// 得到为x年x周
				String weekofyear = request.getParameter("weekofyear");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 当天日期
				Date nowDate = new Date();
				// 明天日期
				Date nextDate = WeekManager.getNextDate(new Date(), "2");

				Hashtable htable = new Hashtable<String, String>();
				htable.put("nowDate", sdf.format(nowDate));
				htable.put("nextDate", sdf.format(nextDate));

				// 用户今明两天日程
				List personLastList = this.tbZwWeekSecheduleMgr.findPersonLast(
						user, htable);

				request.setAttribute("personLastList", personLastList);

				return new ActionForward(
						"/WEB-INF/web/jsp/weeksechedule/personLastlist.jsp");

			}

			// 得到个人当天、当周、当月日程
			if ("personAll".equals(action)) {
				// 当前用户
				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");
				// 得到为x年x周
				String weekofyear = request.getParameter("weekofyear");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 当天日期
				Date nowDate = new Date();
				// 明天日期
				Date nextDate = WeekManager.getNextDate(new Date(), "1");

				Hashtable htable = new Hashtable<String, String>();
				htable.put("nowDate", sdf.format(nowDate));
				htable.put("nextDate", sdf.format(nextDate));

				// 用户当天日程
				List personLastList = this.tbZwWeekSecheduleMgr.findPersonLast(
						user, htable);

				request.setAttribute("personLastList", personLastList);

				// 用户当周日程
				String queryTime = request.getParameter("queryTime");
				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");

				if (queryTime == null || "".equals(queryTime)) {
					date = new Date();
					starttime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek();
					endtime = WeekManager.getSaturday(date);
				} else {
					date = WeekManager.strToDate(queryTime);
					starttime = WeekManager.getSunday(date);
					endtime = WeekManager.getSaturday(date);
					weekofyear = WeekManager.getSeqWeek(queryTime);

				}

				List allweekSechedule = new ArrayList();

				List weekdayList = new ArrayList();

				List sundayList = null;
				List mondayList = null;
				List tuesdayList = null;
				List wednesdayList = null;
				List thursdayList = null;
				List fridayList = null;
				List saturdayList = null;

				weekdayList.add(WeekManager.getSunday(date) + "(星期日)");
				weekdayList.add(WeekManager.getMonday(date) + "(星期一)");
				weekdayList.add(WeekManager.getTuesday(date) + "(星期二)");
				weekdayList.add(WeekManager.getWednesday(date) + "(星期三)");
				weekdayList.add(WeekManager.getThursday(date) + "(星期四)");
				weekdayList.add(WeekManager.getFriday(date) + "(星期五)");
				weekdayList.add(WeekManager.getSaturday(date) + "(星期六)");

				TbZwWeekSechedule zw = null;

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期日");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				sundayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期一");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				mondayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期二");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				tuesdayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期三");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				wednesdayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期四");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				thursdayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期五");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				fridayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期六");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				saturdayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				System.out.println(allweekSechedule.size());

				// request.setAttribute("alllist", alllist);

				request.setAttribute("allweekSechedule", allweekSechedule);
				//
				request.setAttribute("weekdayList", weekdayList);

				request.setAttribute("sundayList", sundayList);
				request.setAttribute("mondayList", mondayList);
				request.setAttribute("tuesdayList", tuesdayList);
				request.setAttribute("wednesdayList", wednesdayList);
				request.setAttribute("thursdayList", thursdayList);
				request.setAttribute("fridayList", fridayList);
				request.setAttribute("saturdayList", saturdayList);

				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("starttime", starttime);
				request.setAttribute("endtime", endtime);

				return new ActionForward(
						"/WEB-INF/web/jsp/weeksechedule/personLastAlllist.jsp");

			}

			if ("selectuser".equals(action)) {
				List userlist = this.userMgr.findAll();

				request.setAttribute("userlist", userlist);

				return mapping.findForward("selectuser");
			}

			if (action.equals("listofweek")) {

				String weekofyear = request.getParameter("weekofyear");

				List allweekSechedule = this.tbZwWeekSecheduleMgr
						.findByWeekOfYear(weekofyear);

				request.setAttribute("allweekSechedule", allweekSechedule);

				System.out.println("获得一周日程安排");

				return mapping.findForward("daylist");
			}

			if (action.equals("querylist")) {

				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");

				// 得到为x年x周
				String weekofyear = request.getParameter("weekofyear");

				String queryTime = request.getParameter("queryTime");
				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");

				if (queryTime == null || "".equals(queryTime)) {
					date = new Date();
					starttime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek();
					endtime = WeekManager.getSaturday(date);
				} else {
					date = WeekManager.strToDate(queryTime);
					starttime = WeekManager.getSunday(date);
					endtime = WeekManager.getSaturday(date);
					weekofyear = WeekManager.getSeqWeek(queryTime);

				}

				List allweekSechedule = new ArrayList();

				List weekdayList = new ArrayList();

				List sundayList = null;
				List mondayList = null;
				List tuesdayList = null;
				List wednesdayList = null;
				List thursdayList = null;
				List fridayList = null;
				List saturdayList = null;

				weekdayList.add(WeekManager.getSunday(date) + "(星期日)");
				weekdayList.add(WeekManager.getMonday(date) + "(星期一)");
				weekdayList.add(WeekManager.getTuesday(date) + "(星期二)");
				weekdayList.add(WeekManager.getWednesday(date) + "(星期三)");
				weekdayList.add(WeekManager.getThursday(date) + "(星期四)");
				weekdayList.add(WeekManager.getFriday(date) + "(星期五)");
				weekdayList.add(WeekManager.getSaturday(date) + "(星期六)");

				TbZwWeekSechedule zw = null;

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期日");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				sundayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期一");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				mondayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期二");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				tuesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期三");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				wednesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期四");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				thursdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期五");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				fridayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期六");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				saturdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				System.out.println(allweekSechedule.size());

				// request.setAttribute("alllist", alllist);

				request.setAttribute("allweekSechedule", allweekSechedule);
				//
				request.setAttribute("weekdayList", weekdayList);

				request.setAttribute("sundayList", sundayList);
				request.setAttribute("mondayList", mondayList);
				request.setAttribute("tuesdayList", tuesdayList);
				request.setAttribute("wednesdayList", wednesdayList);
				request.setAttribute("thursdayList", thursdayList);
				request.setAttribute("fridayList", fridayList);
				request.setAttribute("saturdayList", saturdayList);

				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("starttime", starttime);
				request.setAttribute("endtime", endtime);

				System.out.println("获得一周日程安排" + endtime);

				return mapping.findForward("list");

			}

			if (action.equals("Bossquerylist")) {

				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");

				// 得到为x年x周
				String weekofyear = request.getParameter("weekofyear");

				String queryTime = request.getParameter("queryTime");
				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");

				if (queryTime == null || "".equals(queryTime)) {
					date = new Date();
					starttime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek();
					endtime = WeekManager.getSaturday(date);
				} else {
					date = WeekManager.strToDate(queryTime);
					starttime = WeekManager.getSunday(date);
					endtime = WeekManager.getSaturday(date);
					weekofyear = WeekManager.getSeqWeek(queryTime);

				}

				List allweekSechedule = new ArrayList();

				List weekdayList = new ArrayList();

				List sundayList = null;
				List mondayList = null;
				List tuesdayList = null;
				List wednesdayList = null;
				List thursdayList = null;
				List fridayList = null;
				List saturdayList = null;

				weekdayList.add(WeekManager.getSunday(date) + "(星期日)");
				weekdayList.add(WeekManager.getMonday(date) + "(星期一)");
				weekdayList.add(WeekManager.getTuesday(date) + "(星期二)");
				weekdayList.add(WeekManager.getWednesday(date) + "(星期三)");
				weekdayList.add(WeekManager.getThursday(date) + "(星期四)");
				weekdayList.add(WeekManager.getFriday(date) + "(星期五)");
				weekdayList.add(WeekManager.getSaturday(date) + "(星期六)");

				TbZwWeekSechedule zw = null;

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				sundayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期一");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				mondayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期二");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				tuesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期三");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				wednesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期四");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				thursdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期五");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				fridayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期六");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				saturdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				System.out.println(allweekSechedule.size());

				// request.setAttribute("alllist", alllist);

				request.setAttribute("allweekSechedule", allweekSechedule);
				//
				request.setAttribute("weekdayList", weekdayList);

				request.setAttribute("sundayList", sundayList);
				request.setAttribute("mondayList", mondayList);
				request.setAttribute("tuesdayList", tuesdayList);
				request.setAttribute("wednesdayList", wednesdayList);
				request.setAttribute("thursdayList", thursdayList);
				request.setAttribute("fridayList", fridayList);
				request.setAttribute("saturdayList", saturdayList);

				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("starttime", starttime);
				request.setAttribute("endtime", endtime);

				System.out.println("获得一周日程安排" + endtime);

				return mapping.findForward("bosslist");

			}

			// 查看局领导日程安排
			if (action.equals("Bosslist")) {
				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");

				// 得到为x年x周
				String weekofyear = request.getParameter("weekofyear");

				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");

				if (starttime == null || "".equals(starttime)) {
					date = new Date();
					starttime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek();
				} else {
					date = WeekManager.strToDate(starttime);
					starttime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek(starttime);
				}
				if (endtime == null || "".equals(endtime)) {
					date = new Date();
					endtime = WeekManager.getSaturday(date);
					weekofyear = WeekManager.getSeqWeek();
				} else {
					date = WeekManager.strToDate(endtime);
					endtime = WeekManager.getSaturday(date);
					weekofyear = WeekManager.getSeqWeek(endtime);
				}

				String skip = request.getParameter("skip");
				if (skip != null && !"".equals(skip)) {
					if ("last".equals(skip)) {
						starttime = WeekManager.getNextDay(starttime, "-7");
						endtime = WeekManager.getNextDay(endtime, "-7");
						date = WeekManager.getNextDate(date, "-7");
						weekofyear = WeekManager.getSeqWeek(starttime);
					}
					if ("now".equals(skip)) {
						weekofyear = WeekManager.getSeqWeek();
						date = new Date();
						starttime = WeekManager.getSunday(new Date());
						endtime = WeekManager.getSaturday(new Date());
					}
					if ("next".equals(skip)) {
						starttime = WeekManager.getNextDay(starttime, "7");
						endtime = WeekManager.getNextDay(endtime, "7");
						date = WeekManager.getNextDate(date, "7");
						weekofyear = WeekManager.getSeqWeek(starttime);
					}
				}

				List allweekSechedule = new ArrayList();

				List weekdayList = new ArrayList();

				List sundayList = null;
				List mondayList = null;
				List tuesdayList = null;
				List wednesdayList = null;
				List thursdayList = null;
				List fridayList = null;
				List saturdayList = null;

				weekdayList.add(WeekManager.getSunday(date) + "(星期日)");
				weekdayList.add(WeekManager.getMonday(date) + "(星期一)");
				weekdayList.add(WeekManager.getTuesday(date) + "(星期二)");
				weekdayList.add(WeekManager.getWednesday(date) + "(星期三)");
				weekdayList.add(WeekManager.getThursday(date) + "(星期四)");
				weekdayList.add(WeekManager.getFriday(date) + "(星期五)");
				weekdayList.add(WeekManager.getSaturday(date) + "(星期六)");

				TbZwWeekSechedule zw = null;

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期日");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				sundayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期一");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				mondayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期二");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				tuesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期三");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				wednesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期四");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				thursdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期五");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				fridayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期六");
				// 查看局机关部门日程
				zw.setDept("b205f4e34f4f4d2da5bd89e2e10af37a");
				// zw.setPrivateUserId(user.getId());
				saturdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				System.out.println(allweekSechedule.size());

				// request.setAttribute("alllist", alllist);

				request.setAttribute("allweekSechedule", allweekSechedule);
				//
				request.setAttribute("weekdayList", weekdayList);

				request.setAttribute("sundayList", sundayList);
				request.setAttribute("mondayList", mondayList);
				request.setAttribute("tuesdayList", tuesdayList);
				request.setAttribute("wednesdayList", wednesdayList);
				request.setAttribute("thursdayList", thursdayList);
				request.setAttribute("fridayList", fridayList);
				request.setAttribute("saturdayList", saturdayList);

				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("starttime", starttime);
				request.setAttribute("endtime", endtime);

				System.out.println("获得一周日程安排" + endtime);

				return mapping.findForward("bosslist");
			}
			// personalllist
			if (action.equals("personalllist")) {
				// 当前用户
				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");
				// 得到为x年x周
				String weekofyear = request.getParameter("weekofyear");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 当天日期
				Date nowDate = new Date();
				// 明天日期
				Date nextDate = WeekManager.getNextDate(new Date(), "1");

				Hashtable htable = new Hashtable<String, String>();
				htable.put("nowDate", sdf.format(nowDate));
				htable.put("nextDate", sdf.format(nextDate));

				// 用户当天日程
				List personLastList = this.tbZwWeekSecheduleMgr.findPersonLast(
						user, htable);

				request.setAttribute("personLastList", personLastList);

				// 用户的周日程

				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");

				if (starttime == null || "".equals(starttime)) {
					date = new Date();
					starttime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek();
				} else {
					date = WeekManager.strToDate(starttime);
					starttime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek(starttime);
				}
				if (endtime == null || "".equals(endtime)) {
					date = new Date();
					endtime = WeekManager.getSaturday(date);
					weekofyear = WeekManager.getSeqWeek();
				} else {
					date = WeekManager.strToDate(endtime);
					endtime = WeekManager.getSaturday(date);
					weekofyear = WeekManager.getSeqWeek(endtime);
				}

				String skip = request.getParameter("skip");
				if (skip != null && !"".equals(skip)) {
					if ("last".equals(skip)) {
						starttime = WeekManager.getNextDay(starttime, "-7");
						endtime = WeekManager.getNextDay(endtime, "-7");
						date = WeekManager.getNextDate(date, "-7");
						weekofyear = WeekManager.getSeqWeek(starttime);
					}
					if ("now".equals(skip)) {
						weekofyear = WeekManager.getSeqWeek();
						date = new Date();
						starttime = WeekManager.getSunday(new Date());
						endtime = WeekManager.getSaturday(new Date());
					}
					if ("next".equals(skip)) {
						starttime = WeekManager.getNextDay(starttime, "7");
						endtime = WeekManager.getNextDay(endtime, "7");
						date = WeekManager.getNextDate(date, "7");
						weekofyear = WeekManager.getSeqWeek(starttime);
					}
				}

				List allweekSechedule = new ArrayList();

				List weekdayList = new ArrayList();

				List sundayList = null;
				List mondayList = null;
				List tuesdayList = null;
				List wednesdayList = null;
				List thursdayList = null;
				List fridayList = null;
				List saturdayList = null;

				weekdayList.add(WeekManager.getSunday(date) + "(星期日)");
				weekdayList.add(WeekManager.getMonday(date) + "(星期一)");
				weekdayList.add(WeekManager.getTuesday(date) + "(星期二)");
				weekdayList.add(WeekManager.getWednesday(date) + "(星期三)");
				weekdayList.add(WeekManager.getThursday(date) + "(星期四)");
				weekdayList.add(WeekManager.getFriday(date) + "(星期五)");
				weekdayList.add(WeekManager.getSaturday(date) + "(星期六)");

				TbZwWeekSechedule zw = null;

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期日");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				sundayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);
				this.tbZwWeekSecheduleMgr.findPersonLast(user, htable);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期一");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				mondayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期二");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				tuesdayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期三");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				wednesdayList = this.tbZwWeekSecheduleMgr
						.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期四");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				thursdayList = this.tbZwWeekSecheduleMgr
						.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期五");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				fridayList = this.tbZwWeekSecheduleMgr.findPersonByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期六");
				// 当前用户本人日程
				zw.setPrivateUserId(user.getId());
				saturdayList = this.tbZwWeekSecheduleMgr
						.findPersonByExample(zw);

				System.out.println(allweekSechedule.size());

				// request.setAttribute("alllist", alllist);

				request.setAttribute("allweekSechedule", allweekSechedule);
				//
				request.setAttribute("weekdayList", weekdayList);

				request.setAttribute("sundayList", sundayList);
				request.setAttribute("mondayList", mondayList);
				request.setAttribute("tuesdayList", tuesdayList);
				request.setAttribute("wednesdayList", wednesdayList);
				request.setAttribute("thursdayList", thursdayList);
				request.setAttribute("fridayList", fridayList);
				request.setAttribute("saturdayList", saturdayList);

				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("starttime", starttime);
				request.setAttribute("endtime", endtime);

				System.out.println("获得一周日程安排" + endtime);

				return new ActionForward(
						"/WEB-INF/web/jsp/weeksechedule/personLastAlllist.jsp");

			}
			if (action.equals("alllist")) {

				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");

				// 非局机关用户显示查看局机关日程安排链接
				if (user.getUserdept().equals(
						"b205f4e34f4f4d2da5bd89e2e10af37a")) {
					request.setAttribute("showBossLink", "no");
				} else {
					request.setAttribute("showBossLink", "yes");
				}

				// 得到为x年x周
				String weekofyear = request.getParameter("weekofyear");

				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");

				if (starttime == null || "".equals(starttime)) {
					date = new Date();
					starttime = WeekManager.getMonday(date);
					weekofyear = WeekManager.getSeqWeek();
				} else {
					date = WeekManager.strToDate(starttime);
					starttime = WeekManager.getMonday(date);
					weekofyear = WeekManager.getSeqWeek(starttime);
				}
				if (endtime == null || "".equals(endtime)) {
					date = new Date();
					endtime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek();
				} else {
					date = WeekManager.strToDate(endtime);
					endtime = WeekManager.getSunday(date);
					weekofyear = WeekManager.getSeqWeek(endtime);
				}

				String skip = request.getParameter("skip");
				if (skip != null && !"".equals(skip)) {
					if ("last".equals(skip)) {
						starttime = WeekManager.getNextDay(starttime, "-7");
						endtime = WeekManager.getNextDay(endtime, "-7");
						date = WeekManager.getNextDate(date, "-7");
						weekofyear = WeekManager.getSeqWeek(starttime);
					}
					if ("now".equals(skip)) {
						weekofyear = WeekManager.getSeqWeek();
						date = new Date();
						starttime = WeekManager.getMonday(new Date());
						endtime = WeekManager.getSunday(new Date());
					}
					if ("next".equals(skip)) {
						starttime = WeekManager.getNextDay(starttime, "7");
						endtime = WeekManager.getNextDay(endtime, "7");
						date = WeekManager.getNextDate(date, "7");
						weekofyear = WeekManager.getSeqWeek(starttime);
					}
				}

				List allweekSechedule = new ArrayList();

				List weekdayList = new ArrayList();

				List sundayList = null;
				List mondayList = null;
				List tuesdayList = null;
				List wednesdayList = null;
				List thursdayList = null;
				List fridayList = null;
				List saturdayList = null;

				weekdayList.add(WeekManager.getSunday(date) + "(星期日)");
				weekdayList.add(WeekManager.getMonday(date) + "(星期一)");
				weekdayList.add(WeekManager.getTuesday(date) + "(星期二)");
				weekdayList.add(WeekManager.getWednesday(date) + "(星期三)");
				weekdayList.add(WeekManager.getThursday(date) + "(星期四)");
				weekdayList.add(WeekManager.getFriday(date) + "(星期五)");
				weekdayList.add(WeekManager.getSaturday(date) + "(星期六)");

				TbZwWeekSechedule zw = null;

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期日");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				sundayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期一");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				mondayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期二");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				tuesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期三");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				wednesdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期四");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				thursdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期五");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				fridayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				zw = new TbZwWeekSechedule();
				zw.setWeekofyear(weekofyear);
				zw.setAttr2("星期六");
				// 当前用户只能看到本部门的部门日程和本人日程
				zw.setDept(user.getUserdept());
				zw.setPrivateUserId(user.getId());
				saturdayList = this.tbZwWeekSecheduleMgr.findByExample(zw);

				System.out.println(allweekSechedule.size());

				// request.setAttribute("alllist", alllist);

				request.setAttribute("allweekSechedule", allweekSechedule);
				//
				request.setAttribute("weekdayList", weekdayList);

				request.setAttribute("sundayList", sundayList);
				request.setAttribute("mondayList", mondayList);
				request.setAttribute("tuesdayList", tuesdayList);
				request.setAttribute("wednesdayList", wednesdayList);
				request.setAttribute("thursdayList", thursdayList);
				request.setAttribute("fridayList", fridayList);
				request.setAttribute("saturdayList", saturdayList);

				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("starttime", starttime);
				request.setAttribute("endtime", endtime);

				System.out.println("获得一周日程安排" + endtime);

				return mapping.findForward("list");

			}
		} else {
			Date date = new Date();
			// 得到当前为x年x周
			String weekofyear = WeekManager.getSeqWeek();

			List allweekSechedule = this.tbZwWeekSecheduleMgr
					.findByWeekOfYear(weekofyear);

			String starttime = WeekManager.getSunday(date);
			// String end=WeekManager.getFriday(date);
			String endtime = WeekManager.getSaturday(date);

			request.setAttribute("allweekSechedule", allweekSechedule);
			request.setAttribute("starttime", starttime);
			request.setAttribute("endtime", endtime);

			System.out.println("获得一周日程安排" + endtime);

			return mapping.findForward("list");
		}

		return null;
	}

	private TbZwWeekSechedule initTbZwWeekSechedule() {
		TbZwWeekSechedule obj = new TbZwWeekSechedule();

		obj.setAttendance("");
		obj.setAttr2("");
		obj.setCreateTime("");
		obj.setDept("");
		obj.setEndTime(new Date());
		obj.setId("");
		obj.setItemTitle("");
		obj.setItemType("");
		obj.setOrigin("");
		obj.setPromulgator("");
		obj.setRem("");
		obj.setStartTime(new Date());
		obj.setUserId("");
		obj.setWeekofyear("");

		return obj;
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");

		if (action != null && !action.equals("")) {
			if (action.equals("modify")) {
				String id = request.getParameter("id");

				TbZwWeekSechedule zw = this.tbZwWeekSecheduleMgr.find(id);
				// 2008-11-14修改 召集人。
				 request.setAttribute("promulgator", zw.getPromulgator());
				((DynaValidatorForm) form).set("id", zw.getId());
				((DynaValidatorForm) form).set("itemTitle", zw.getItemTitle());
				((DynaValidatorForm) form).set("itemType", zw.getItemType());
				((DynaValidatorForm) form).set("dept", zw.getDept());
				((DynaValidatorForm) form).set("startTime",
						new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")
								.format(zw.getStartTime()));
				((DynaValidatorForm) form).set("endTime",
						new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")
								.format(zw.getEndTime()));
				((DynaValidatorForm) form)
						.set("attendance", zw.getAttendance());
				((DynaValidatorForm) form).set("userId", zw.getUserId());
				((DynaValidatorForm) form).set("promulgator", zw
						.getPromulgator());
				((DynaValidatorForm) form).set("origin", zw.getOrigin());
				((DynaValidatorForm) form)
						.set("createTime", zw.getCreateTime());
				((DynaValidatorForm) form).set("rem", zw.getRem());
				((DynaValidatorForm) form)
						.set("weekofyear", zw.getWeekofyear());
				((DynaValidatorForm) form).set("attr2", zw.getAttr2());
				((DynaValidatorForm) form).set("attr3", zw.getAttr3());
				((DynaValidatorForm) form).set("content", zw.getContent());
				((DynaValidatorForm) form).set("deptId", zw.getDeptId());
				((DynaValidatorForm) form).set("privateUserId", zw
						.getPrivateUserId());
				((DynaValidatorForm) form).set("ischild", zw.getIschild());
				((DynaValidatorForm) form).set("pid", zw.getPid());

				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");
				// 当前用户的用户名
				String username = user.getName();
				String userid = user.getId();

				String addtype = "";
				if (zw.getItemType().equals("person")) {
					addtype = "person";
				} else {
					addtype = "dept";
				}
				// String date = request.getParameter("date");
				String weekofyear = zw.getWeekofyear();

				request.setAttribute("addtype", addtype);
				// ischild 是否为其他日程级联添加的日程，是则不能修改
				String ischild = zw.getIschild();

				String nowweekofyear = WeekManager.getSeqWeek(WeekManager
						.dateToStr(new Date()));
				// 比较时间，是否已过期，过期则不能修改
				String timeoutflag = "0";
				if (Integer.parseInt(weekofyear) < Integer
						.parseInt(nowweekofyear)) {
					timeoutflag = "1";
				}
				// 是否为子日程，1 为是，0为否
				request.setAttribute("ischild", ischild);
				// 是否已过期, 1 为过期，0为未过期
				request.setAttribute("timeoutflag", timeoutflag);

				// request.setAttribute("date", date);
				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("username", username);
				request.setAttribute("userid", userid);
				request.setAttribute("action", "modify");

				request.setAttribute("userids", zw.getUserId());
				request.setAttribute("deptids", zw.getDeptId());
				
				//2008-12-25 cjf添加管理功能-即追加人员或部门
				String xgorgl = (String)request.getParameter("xgorgl");
				if ("gl".equals(xgorgl))
					return mapping.findForward("addSecheduleTwo");
				else
				//2008-12-25 end
				return mapping.findForward("addSechedule");

			}
			if (action.equals("addSechedule")) {
				String date = request.getParameter("date");
				String weekofyear = request.getParameter("weekofyear");
				String id = request.getParameter("id");

				TbZwWeekSechedule zw = new TbZwWeekSechedule();
				zw = this.tbZwWeekSecheduleMgr.find(id);
				((DynaValidatorForm) form).set("id", zw.getId());
				((DynaValidatorForm) form).set("itemTitle", zw.getItemTitle());
				((DynaValidatorForm) form).set("itemType", zw.getItemType());
				((DynaValidatorForm) form).set("promulgator", zw
						.getPromulgator());
				((DynaValidatorForm) form).set("userId", zw.getUserId());
				((DynaValidatorForm) form).set("rem", zw.getRem());
				((DynaValidatorForm) form).set("content", zw.getContent());

				String stratTime = new java.text.SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss").format(zw.getStartTime());
				String stratTimeDate = stratTime.substring(0, 10);
				String stratTimeTime = stratTime.substring(11, stratTime
						.length());

				String flag = request.getParameter("flag");
				if (flag != null && !"".equals(flag)) {
					if (flag.equals("look")) {
						request.setAttribute("look", "look");
					}
				}
				request.setAttribute("stratTimeDate", stratTimeDate);
				request.setAttribute("stratTimeTime", stratTimeTime);
				request.setAttribute("date", date);
				request.setAttribute("weekofyear", weekofyear);

				return mapping.findForward("addSechedule");
			}
			if (action.equals("submit")) {
				try {
					System.out.println("modify");
					String addtype = request.getParameter("addtype");
					System.out.println("modify  " + addtype + "  "
							+ request.getParameter("userids") + "  "
							+ request.getParameter("deptids"));

					TbUser user = (TbUser) request.getSession().getAttribute(
							"SYSTEM_USER_SESSION");
					// System.out.println(user.getUserdept()+"??????????????????????????");
					// System.out.println(user.getName()+"??????????????????????????"+user.getId());
					String id = (String) ((DynaValidatorForm) form).get("id");
					System.out.println("??????????????????????????" + id);
					String dept = user.getUserdept();
					String itemTitle = (String) ((DynaValidatorForm) form)
							.get("itemTitle");
					String itemType = (String) ((DynaValidatorForm) form)
							.get("itemType");
					String content = (String) ((DynaValidatorForm) form)
							.get("content");
					String startTime = (String) ((DynaValidatorForm) form)
							.get("startTime");

					// 发布人id 即为当前登录用户
					// String promulgator = (String)
					// request.getParameter("loginuserid");
					String promulgator = (String) request
							.getParameter("promulgator");
					// String userId = (String) ((DynaValidatorForm) form)
					// .get("userId");
					// 出席人员id
					String userId = (String) request.getParameter("userids");
					String deptId = (String) request.getParameter("deptids");
					String rem = (String) ((DynaValidatorForm) form).get("rem");
					// 参加人员、单位
					String attendance = (String) ((DynaValidatorForm) form)
							.get("attendance");
					// String weekofyear = (String) ((DynaValidatorForm) form)
					// .get("weekofyear");

					String startTimeDate = startTime.substring(0, 10);
					String weekofyear = WeekManager.getSeqWeek(startTimeDate);

					SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
					// String date = (String) request.getParameter("date");
					String day = WeekManager.getDayOfWeek(spf
							.parse(startTimeDate));
					String start = WeekManager.getSunday(spf
							.parse(startTimeDate));
					String end = WeekManager.getSaturday(spf
							.parse(startTimeDate));

					TbZwWeekSechedule zw = new TbZwWeekSechedule();
					zw.setId(id);
					zw.setItemTitle(itemTitle);

					Date time = new java.text.SimpleDateFormat(
							"yyyy-MM-dd HH:mm").parse(startTime);

					zw.setStartTime(time);

					zw.setPromulgator(promulgator);

					zw.setCreateTime(new java.text.SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date()));
					zw.setRem(rem);
					zw.setAttr2(day);
					zw.setAttr3(start + "," + end);
					zw.setWeekofyear(weekofyear);
					zw.setContent(content);
					zw.setDept("");
					zw.setEndTime(time);
					zw.setOrigin("");
					zw.setDept(dept);
					/*
					 * 添加的为部门时 发布来源为当前用户的userdept
					 * 
					 * 添加的为个人时 发布来源为当前用户的id
					 */
					if (addtype != null && !addtype.equals("")) {
						if (addtype.equals("dept")) {
							zw.setAttendance(attendance);
							zw.setItemType("dept");
							zw.setOrigin(dept);
							zw.setColorflag("1");
							// 选择的人员ids
							zw.setUserId(userId);
							// 选择的部门ids
							zw.setDeptId(deptId);
							// 添加的为部门日程，个人userid为空，所有本部门用户均可见
							zw.setPrivateUserId("");

							// ischild 为0表示为父日程
							zw.setIschild("0");
							// pid 为空表示为父日程
							zw.setPid("");

							// this.tbZwWeekSecheduleMgr.save(zw);
							this.tbZwWeekSecheduleMgr.updateDept(zw, user);
						}
						if (addtype.equals("person")) {
							zw.setAttendance(user.getName());
							zw.setItemType("peson");
							zw.setOrigin(user.getId());
							zw.setColorflag("0");
							// 当前用户id
							zw.setUserId(user.getId());
							// 当前用户所述部门
							zw.setDeptId(user.getUserdept());
							// 添加的为个人日程，个人userid为当前用户的userid，本部门其它用户不可见
							zw.setPrivateUserId(user.getId());

							// ischild 为0
							zw.setIschild("0");
							// pid 为空
							zw.setPid("");

							this.tbZwWeekSecheduleMgr.updatePerson(zw, user);
						}
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return mapping.findForward("success");
			}
		}
		return null;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");

		this.tbZwWeekSecheduleMgr.delete(id);

		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("query")) {
				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");
				String publicflag = request.getParameter("publicflag");

				Hashtable hashtable = new Hashtable();

				hashtable.put("starttime", (starttime != null) ? (starttime)
						: (""));
				hashtable.put("endtime", (endtime != null) ? (endtime) : (""));
				hashtable.put("publicflag", (publicflag != null) ? (publicflag)
						: (""));

				request.setAttribute("starttime", starttime);
				request.setAttribute("endtime", endtime);
				request.setAttribute("publicflag", publicflag);

				List list = this.tbZwWeekSecheduleMgr.findByQuerySQL(hashtable);
				request.setAttribute("list", list);
				return mapping.findForward("add");

			}
			if (action.equals("add")) {

				List list = this.tbZwWeekSecheduleMgr.findByGroupByWeekOfYear();
				request.setAttribute("list", list);
				return mapping.findForward("add");
			}
			if (action.equals("addSechedule")) {

				TbUser user = (TbUser) request.getSession().getAttribute(
						"SYSTEM_USER_SESSION");
				// 当前用户的用户名
				String username = user.getName();
				String userid = user.getId();

				String addtype = request.getParameter("addtype");
				String date = request.getParameter("date");
				String weekofyear = request.getParameter("weekofyear");

				request.setAttribute("addtype", addtype);
				request.setAttribute("date", date);
				request.setAttribute("weekofyear", weekofyear);
				request.setAttribute("username", username);
				request.setAttribute("userid", userid);
				//添加用户
				request.setAttribute("promulgator", username);
				return mapping.findForward("addSechedule");
			}
			if (action.equals("submit")) {
				try {
					String addtype = request.getParameter("addtype");
					TbUser user = (TbUser) request.getSession().getAttribute(
							"SYSTEM_USER_SESSION");
					// System.out.println(user.getUserdept()+"??????????????????????????");
					// System.out.println(user.getName()+"??????????????????????????"+user.getId());
					String id = UUID.randomUUID().toString()
							.replaceAll("-", "");
					String dept = user.getUserdept();
					String itemTitle = (String) ((DynaValidatorForm) form)
							.get("itemTitle");
					String itemType = (String) ((DynaValidatorForm) form)
							.get("itemType");
					String content = (String) ((DynaValidatorForm) form)
							.get("content");
					String startTime = (String) ((DynaValidatorForm) form)
							.get("startTime");

					// 发布人id 即为当前登录用户
					// String promulgator = (String)
					// request.getParameter("loginuserid");
					String promulgator = (String) request
							.getParameter("promulgator");
					// String userId = (String) ((DynaValidatorForm) form)
					// .get("userId");
					// 出席人员id
					String userId = (String) request.getParameter("userids");
					String deptId = (String) request.getParameter("deptids");
					String rem = (String) ((DynaValidatorForm) form).get("rem");
					// 参加人员、单位
					String attendance = (String) ((DynaValidatorForm) form)
							.get("attendance");
					// String weekofyear = (String) ((DynaValidatorForm) form)
					// .get("weekofyear");

					String startTimeDate = startTime.substring(0, 10);
					String weekofyear = WeekManager.getSeqWeek(startTimeDate);

					SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
					// String date = (String) request.getParameter("date");
					String day = WeekManager.getDayOfWeek(spf
							.parse(startTimeDate));
					String start = WeekManager.getSunday(spf
							.parse(startTimeDate));
					String end = WeekManager.getSaturday(spf
							.parse(startTimeDate));

					TbZwWeekSechedule zw = new TbZwWeekSechedule();
					// zw.setId(id);
					zw.setItemTitle(itemTitle);

					Date time = new java.text.SimpleDateFormat(
							"yyyy-MM-dd HH:mm").parse(startTime);

					zw.setStartTime(time);

					zw.setPromulgator(promulgator);

					zw.setCreateTime(new java.text.SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date()));
					zw.setRem(rem);
					zw.setAttr2(day);
					zw.setAttr3(start + "," + end);
					zw.setWeekofyear(weekofyear);
					zw.setContent(content);
					zw.setDept("");
					zw.setEndTime(time);
					zw.setOrigin("");
					zw.setDept(dept);
					/*
					 * 添加的为部门时 发布来源为当前用户的userdept
					 * 
					 * 添加的为个人时 发布来源为当前用户的id
					 */
					if (addtype != null && !addtype.equals("")) {
						if (addtype.equals("dept")) {
							zw.setAttendance(attendance);
							zw.setItemType("dept");
							zw.setOrigin(dept);
							// 1为本部门日程
							zw.setColorflag("1");
							// 选择的人员ids
							zw.setUserId(userId);
							// 选择的部门ids
							zw.setDeptId(deptId);
							// 添加的为部门日程，个人userid为空，所有本部门用户均可见
							zw.setPrivateUserId("");

							// ischild 为0表示为父日程
							zw.setIschild("0");
							// pid 为空表示为父日程
							zw.setPid("");

							// this.tbZwWeekSecheduleMgr.save(zw);
							this.tbZwWeekSecheduleMgr.savaDept(zw, user);
						}
						if (addtype.equals("person")) {
							zw.setAttendance(user.getName());
							zw.setItemType("peson");
							zw.setOrigin(user.getId());
							// 0为个人日程
							zw.setColorflag("0");
							// 当前用户id
							zw.setUserId(user.getId());
							// 当前用户所述部门
							zw.setDeptId(user.getUserdept());
							// 添加的为个人日程，个人userid为当前用户的userid，本部门其它用户不可见
							zw.setPrivateUserId(user.getId());

							// ischild 为0
							zw.setIschild("0");
							// pid 为空
							zw.setPid("");

							this.tbZwWeekSecheduleMgr.savePerson(zw, user);
						}
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return mapping.findForward("success");
			}
		}
		return null;
	}

}
