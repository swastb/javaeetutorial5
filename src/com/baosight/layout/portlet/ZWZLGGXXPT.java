package com.baosight.layout.portlet;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import com.baosight.layout.table.*;

public class ZWZLGGXXPT extends BasePortletClass {
	/**
	 * 政务专栏里的公共信息平台
	 */
	public String render(UserEO user, PortletEO portlet) {
		StringBuffer buf = new StringBuffer();
		buf.append("<a href=\"http://31.16.1.75/website/shsw_webgis/viewer.htm\"  onClick=\"\" target=\"_blank\"><img src=\"imagine/pic.gif\" width=285 height=160 border=\"0\"></img></a>");
		return addBorderForLongTitle(user, portlet, buf.toString(), false);
	}
}
