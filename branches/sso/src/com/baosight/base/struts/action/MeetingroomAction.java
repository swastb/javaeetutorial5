package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;


import com.baosight.mode.TbMeetingroom;

import com.baosight.struts.action.BaseDispatchAction;

public class MeetingroomAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List allmeetingroom = this.meetingRoomMgr.findAll();
		request.setAttribute("allmeetingroom", allmeetingroom);
		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String roomName = (String) ((DynaValidatorForm) form).get("roomName");
			String location = (String) ((DynaValidatorForm) form).get("location");
			Long capability =  (Long)((DynaValidatorForm) form).get("capability");
			Long status = (Long) ((DynaValidatorForm) form).get("status");
			String rem = (String) ((DynaValidatorForm) form).get("rem");
			TbMeetingroom item = this.meetingRoomMgr.findById(id);
			item.setRoomName(roomName);
			item.setLocation(location);
			item.setCapability(capability);
			item.setStatus(status);
			item.setRem(rem);
			this.meetingRoomMgr.updte(item);
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbMeetingroom item = this.meetingRoomMgr.findById(id);
				((DynaValidatorForm) form).set("roomName", item.getRoomName());
				((DynaValidatorForm) form).set("location", item.getLocation());
				((DynaValidatorForm) form).set("capability", item.getCapability());
				((DynaValidatorForm) form).set("status", item.getStatus());
				((DynaValidatorForm) form).set("rem", item.getRem());
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		if (id != null && !id.equals("")) {
			meetingRoomMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				long status = 0;
				((DynaValidatorForm) form).set("status",status);
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String roomName = (String) ((DynaValidatorForm) form).get("roomName");
				String location = (String) ((DynaValidatorForm) form).get("location");
				Long capability =  (Long)((DynaValidatorForm) form).get("capability");
				Long status = (Long) ((DynaValidatorForm) form).get("status");
				String rem = (String) ((DynaValidatorForm) form).get("rem");
				//long capabilityS = Long.parseLong(capability);
				//long statusS = Long.parseLong(status);
				TbMeetingroom item = new TbMeetingroom(roomName,location,capability,status,rem);
				this.meetingRoomMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("list");
	}
}
