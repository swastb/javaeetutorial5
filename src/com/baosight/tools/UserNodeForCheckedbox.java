package com.baosight.tools;

import com.baosight.mode.TbUser;

public class UserNodeForCheckedbox {
	
	private boolean checked;
	
	public TbUser user;
	
	public UserNodeForCheckedbox(TbUser user, boolean checked) {
		this.user = user;
		this.checked = checked;
	}

	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
