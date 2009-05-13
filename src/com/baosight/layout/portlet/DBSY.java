package com.baosight.layout.portlet;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import com.baosight.layout.table.*;

public class DBSY extends BasePortletClass {
	public String render(UserEO user, PortletEO portlet) {
		StringBuffer buf = new StringBuffer();
		buf.append("<a href=\"#1\"></a><iframe height=163 src=\"zwzl/zxbb1.jsp\" frameborder=\"0\" width=\"99%\"  scrolling=\"yes\"></iframe>");
		return addBorder(user, portlet, buf.toString(), false);
	}
}
