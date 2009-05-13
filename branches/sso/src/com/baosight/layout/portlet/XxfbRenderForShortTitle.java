package com.baosight.layout.portlet;

import com.baosight.layout.table.PortletEO;
import com.baosight.layout.table.UserEO;

/**
 * <p>Decription:与信息发布有关的选项卡</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-30</p>
 */
public abstract class XxfbRenderForShortTitle extends BasePortletClass{

	public String render(UserEO user, PortletEO portlet) {
		StringBuffer buf = new StringBuffer();
		buf.append("<a href=\"#1\"></a><iframe src=\"layoutContent.do?method=content&code="+getCode()+"\" frameborder=\"0\" width=\"100%\"  height=\"163\"  scrolling=\"no\"></iframe>");
		return addBorderForShortTitle(user, portlet, buf.toString(), false);
	}

	protected abstract String getCode();

}

