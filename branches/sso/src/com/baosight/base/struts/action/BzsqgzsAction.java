package com.baosight.base.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbBzsqgzs;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbGovInfoPubAudit;
import com.baosight.struts.action.BaseDispatchAction;

public class BzsqgzsAction extends BaseDispatchAction {
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("edit");
	}

	public ActionForward addOrEditSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String infoId = (String) ((DynaValidatorForm) form).get("infoId");
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		String attr2 = (String) ((DynaValidatorForm) form).get("attr2");
		String attr3 = (String) ((DynaValidatorForm) form).get("attr3");
		String attr4 = (String) ((DynaValidatorForm) form).get("attr4");
		String attr5 = (String) ((DynaValidatorForm) form).get("attr5");
		String attr6 = (String) ((DynaValidatorForm) form).get("attr6");
		String attr7 = (String) ((DynaValidatorForm) form).get("attr7");
		String attr8 = (String) ((DynaValidatorForm) form).get("attr8");
		String attr9 = (String) ((DynaValidatorForm) form).get("attr9");
		String attr10 = (String) ((DynaValidatorForm) form).get("attr10");
		String attr11 = (String) ((DynaValidatorForm) form).get("attr11");
		String attr12 = (String) ((DynaValidatorForm) form).get("attr12");
		String attr13 = (String) ((DynaValidatorForm) form).get("attr13");
		String attr14 = (String) ((DynaValidatorForm) form).get("attr14");
		String attr15 = (String) ((DynaValidatorForm) form).get("attr15");
		String attr16 = (String) ((DynaValidatorForm) form).get("attr16");
		String attr17 = (String) ((DynaValidatorForm) form).get("attr17");
		String attr18 = (String) ((DynaValidatorForm) form).get("attr18");
		String attr19 = (String) ((DynaValidatorForm) form).get("attr19");
		String attr20 = (String) ((DynaValidatorForm) form).get("attr20");
		String attr21 = (String) ((DynaValidatorForm) form).get("attr21");
		String attr22 = (String) ((DynaValidatorForm) form).get("attr22");
		TbBzsqgzs item = new TbBzsqgzs(infoId,attr1,attr2,attr3,attr4,attr5,attr6,
				attr7,attr8,attr9,attr10,attr11,attr12,attr13,attr14,attr15,attr16,attr17,attr18,attr19,attr20,attr21,attr22,"","","");
		super.bzsqgzsMgr.save(item);
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub)(super.tbGovInfoPubMgr.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit=tbGovInfoPub.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(32));
		super.tbGovInfoPubMgr.update(tbGovInfoPub);
		return mapping.findForward("success");		
	}
}
