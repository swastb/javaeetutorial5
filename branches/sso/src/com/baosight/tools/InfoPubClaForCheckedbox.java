package com.baosight.tools;

import com.baosight.mode.TbInfoPubCla;

public class InfoPubClaForCheckedbox {
	private boolean checked;

	public TbInfoPubCla infoPubCla;

	public InfoPubClaForCheckedbox(TbInfoPubCla infoPubCla, boolean checked) {
		this.infoPubCla = infoPubCla;
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public TbInfoPubCla getTbInfoPubCla() {
		return infoPubCla;
	}

	public void setTbInfoPubCla(TbInfoPubCla infoPubCla) {
		this.infoPubCla = infoPubCla;
	}

}
