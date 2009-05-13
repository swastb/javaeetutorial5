package com.baosight.tools;

import com.baosight.mode.TbDept;

public class DeptNodeForCheckedbox {
	private boolean checked;

	public TbDept dept;

	public DeptNodeForCheckedbox(TbDept dept, boolean checked) {
		this.dept = dept;
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public TbDept getDept() {
		return dept;
	}

	public void setDept(TbDept dept) {
		this.dept = dept;
	}

}
