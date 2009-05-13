package com.baosight.tools;

import com.baosight.mode.TbPst;

public class PstNodeForCheckedbox {
	private boolean checked;

	public TbPst pst;

	public PstNodeForCheckedbox(TbPst pst, boolean checked) {
		this.pst = pst;
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public TbPst getPst() {
		return pst;
	}

	public void setPst(TbPst pst) {
		this.pst = pst;
	}

}
