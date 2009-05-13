package com.baosight.layout.portlet;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import com.baosight.layout.table.*;

public class DJYD extends BasePortletClass {
	/**
	 * 信息中心(3)下的党建园地(87)
	 */
	public String render(UserEO user, PortletEO portlet) {
		StringBuffer buf = new StringBuffer();
		buf.append("<a href=\"#1\"></a><iframe src=\"layoutContent.do?method=djyd&flag=true\" frameborder=\"0\" width=\"100%\"  height=\"163\"  scrolling=\"no\"></iframe>");
		return addBorder(user, portlet, buf.toString(), false);
	}
}
