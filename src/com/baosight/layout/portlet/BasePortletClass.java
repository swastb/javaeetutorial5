package com.baosight.layout.portlet;

import com.baosight.layout.table.*;

public abstract class BasePortletClass {
	abstract public String render(UserEO user ,PortletEO portlet);
	/**
	 * 用户首次登录,添加第一个小窗口时调用
	 * @param user			指定用户
	 * @param portlet		指定小窗口
	 * @param insidecontent 小窗口要显示的内容
	 * @param center		小窗口内容是否居中显示
	 * @return
	 */
	public String addBorder(UserEO user ,PortletEO portlet, String insidecontent,boolean center) {
		String portletDispName = portlet.getDisplayName();
		StringBuffer content = new StringBuffer();
		/*content.append("<table  class=dragTable id=portlet_all_"+portlet.getId()+"_"+side+"><tr><td>11111");
		content.append("</td></tr></table>");*/
		content.append("<table background=\"imagine/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id="+portlet.getId()+"_"+side+">");
		//content.append("<table background=\"images/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id=portlet_all_"+portlet.getId()+"_"+side+">");		
		/******************** 以下模拟标题栏*********************/
		content.append("<tr class=\"dragTR\">");
		//4(待办事宜)2(公示)1(通知通告)
		if(portlet.getId()==4 || portlet.getId()==2 || portlet.getId()==1){
			//显示小窗口名称
			content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
							+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:Toggle('portlet_"
								+ portlet.getId()
								+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		}else{
			//显示小窗口名称
			content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
							+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:Toggle('portlet_"
								+ portlet.getId()
								+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;<a href=# onClick=\"javascript:closePortlet('"+ portlet.getId()+ "','"+side+"')\"><img src=\"images/icon2.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		}

/*		//最小化小窗口
		content.append("<td   align=right valign=buttom  class=ahsPortletTitle ><span id=\"portlet_"+ portlet.getId()
							+ "_"+side+"_min\" style=\"display:block;\"><a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()
							+ "_"+side+"')\"><img  src=\"images/icon1.gif\" border=0></a>");
		content.append("&nbsp;&nbsp;<a href=# onClick=\"javascript:");
		content.append("closePortlet('"+ portlet.getId()+ "','"+side+"')");
		content.append("\"><img src=\"images/icon2.gif\" border=0></a></span>");
		//最大化小窗口
		content.append("<span id=\"portlet_"+ portlet.getId()
							+ "_"+side+"_max\" style=\"display:none;\"><a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>");
		//关闭小窗口
		content.append("<a href=# onClick=\"javascript:");
		content.append("closePortlet('"+ portlet.getId()+ "','"+side+"')");
		content.append("\"><img src=\"images/icon2.gif\" border=0></a></span></td>");*/	
		content.append("</tr>");
		/*********************显示小窗口内容*************************/
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=left bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		//content.append("<td width=5 rowspan=3></td>");
		content.append("</table>");
		return content.toString();
	}
	public String addBorderForLongTitle(UserEO user ,PortletEO portlet, String insidecontent,boolean center) {
		String portletDispName = portlet.getDisplayName();
		StringBuffer content = new StringBuffer();
		content.append("<table background=\"imagine/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id="+portlet.getId()+"_"+side+">");
		/******************** 以下模拟标题栏*********************/
		content.append("<tr class=\"dragTR\">");
		if(portletDispName!=null && !portletDispName.equals("")){
			if(portletDispName.length()>6){
				portletDispName = portletDispName.substring(0, 6);
			}
		}	
		//显示小窗口名称
		content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
						+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\"><a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()
							+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;<a href=# onClick=\"javascript:closePortlet('"+ portlet.getId()+ "','"+side+"')\"><img src=\"images/icon2.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		content.append("</tr>");
		/*********************显示小窗口内容*************************/
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		content.append("</table>");
		return content.toString();
	}
	
	public String addBorderForShortTitle(UserEO user ,PortletEO portlet, String insidecontent,boolean center) {
		String portletDispName = portlet.getDisplayName();
		StringBuffer content = new StringBuffer();
		content.append("<table background=\"imagine/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id="+portlet.getId()+"_"+side+">");
		/******************** 以下模拟标题栏*********************/
		content.append("<tr class=\"dragTR\">");
		//显示小窗口名称
		content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>&nbsp;&nbsp;"
						+ portletDispName + "&nbsp;&nbsp;&nbsp;</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()
							+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;<a href=# onClick=\"javascript:closePortlet('"+ portlet.getId()+ "','"+side+"')\"><img src=\"images/icon2.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		content.append("</tr>");
		/*********************显示小窗口内容*************************/
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=left bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		content.append("</table>");
		return content.toString();
	}
	
	public String addBorderForGS(UserEO user ,PortletEO portlet, String insidecontent,boolean center) {
		String portletDispName = portlet.getDisplayName();
		StringBuffer content = new StringBuffer();
		content.append("<table background=\"imagine/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id="+portlet.getId()+"_"+side+">");
		/******************** 以下模拟标题栏*********************/
		content.append("<tr class=\"dragTR\">");
		//显示小窗口名称
		if(portlet.getId()==4 || portlet.getId()==2 || portlet.getId()==1){
			//显示小窗口名称
			content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
							+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\"><a href=\"javascript:Toggle('portlet_"
								+ portlet.getId()
								+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		}else{
			//显示小窗口名称
			content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
							+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:Toggle('portlet_"
								+ portlet.getId()
								+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;<a href=# onClick=\"javascript:closePortlet('"+ portlet.getId()+ "','"+side+"')\"><img src=\"images/icon2.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		}
		content.append("</tr>");
		/*********************显示小窗口内容*************************/
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=left bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		content.append("</table>");
		return content.toString();
	}
	public String addBorderForGGXXPT(UserEO user ,PortletEO portlet, String insidecontent,boolean center) {
		String portletDispName = portlet.getDisplayName();
		StringBuffer content = new StringBuffer();
		content.append("<table background=\"imagine/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id="+portlet.getId()+"_"+side+">");
		/******************** 以下模拟标题栏*********************/
		content.append("<tr class=\"dragTR\">");
		//显示小窗口名称
		content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
						+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()
							+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;<a href=# onClick=\"javascript:closePortlet('"+ portlet.getId()+ "','"+side+"')\"><img src=\"images/icon2.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		content.append("</tr>");
		
		/*********************显示小窗口内容*************************/
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=left bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		content.append("</table>");
		return content.toString();	
		
/*		content.append("<table width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id=portlet_all_"+portlet.getId()+"_"+side+">");
		*//******************** 以下模拟标题栏*********************//*
		content.append("<tr class=\"dragTR\">");
		//显示小窗口名称
		content.append("<td width=\"331\" height=\"27\" align=\"left\" valign=\"bottom\" bgcolor=\"#C7C0EB\" background=\"imagine/fx1.gif\" style=\"cursor:hand\"><br/><B>&nbsp;&nbsp;&nbsp;"
						+ portletDispName + "</B></td>");
		//最小化小窗口
		content.append("<td  align=right class=ahsPortletTitle background=\"imagine/bglayout.gif\"><span id=\"portlet_"+ portlet.getId()
							+ "_"+side+"_min\" style=\"display:block;\"><a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()
							+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>");
		content.append("<a href=# onClick=\"javascript:");
		content.append("closePortlet('"+ portlet.getId()+ "','"+side+"')");
		content.append("\"><img src=\"images/icon2.gif\" border=0></a></span>");
		//最大化小窗口
		content.append("<span id=\"portlet_"+ portlet.getId()
							+ "_"+side+"_max\" style=\"display:none;\"><a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>");
		//关闭小窗口
		content.append("<a href=# onClick=\"javascript:");
		content.append("closePortlet('"+ portlet.getId()+ "','"+side+"')");
		content.append("\"><img src=\"images/icon2.gif\" border=0></a></span></td>");	
		content.append("</tr>");
		
		*//*********************显示小窗口内容*************************//*
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=left bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		content.append("</table>");
		return content.toString();*/
	}	
	public String addBorderForWSBS(UserEO user ,PortletEO portlet, String insidecontent,boolean center) {
		String portletDispName = portlet.getDisplayName();
		StringBuffer content = new StringBuffer();
		content.append("<table background=\"imagine/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id="+portlet.getId()+"_"+side+">");
		/******************** 以下模拟标题栏*********************/
		content.append("<tr class=\"dragTR\">");
		//显示小窗口名称
		content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
						+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()
							+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;<a href=# onClick=\"javascript:closePortlet('"+ portlet.getId()+ "','"+side+"')\"><img src=\"images/icon2.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		content.append("</tr>");
		
		/*********************显示小窗口内容*************************/
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=left bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		content.append("</table>");
		return content.toString();
	}	
	public String addBorderForWSDC(UserEO user ,PortletEO portlet, String insidecontent,boolean center) {
		String portletDispName = portlet.getDisplayName();
		StringBuffer content = new StringBuffer();
		content.append("<table background=\"imagine/xx_bg1.gif\" width=100% border=0 cellspacing=0 cellpadding=0  class=dragTable id="+portlet.getId()+"_"+side+">");
		/******************** 以下模拟标题栏*********************/
		content.append("<tr class=\"dragTR\">");
		//显示小窗口名称
		content.append("<td    class=\"tabl_atab\" height=\"24\"  align=left 	 style=\"cursor:hand\"><B>"
						+ portletDispName + "</B></td><td align=right class=ahsPortletTitle background=\"imagine/xx_bg1.gif\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:Toggle('portlet_"
							+ portlet.getId()
							+ "_"+side+"')\"><img src=\"images/icon1.gif\" border=0></a>&nbsp;&nbsp;<a href=# onClick=\"javascript:closePortlet('"+ portlet.getId()+ "','"+side+"')\"><img src=\"images/icon2.gif\" border=0></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		content.append("</tr>");
		
		/*********************显示小窗口内容*************************/
		if (center)
			content.append("<tr><td align=center bgcolor=\"#FFFFFF\" colspan=2>");
		else
			content.append("<tr><td align=left bgcolor=\"#FFFFFF\" colspan=2>");
		//核心部分
		content.append("<div id=\"portlet_" + portlet.getId()+ "_"+side+"\">");
		content.append(insidecontent);
		content.append("</div>");
		content.append("</td></tr>");
		content.append("</table>");
		return content.toString();
	}	
	
//	public String addBorder(String insidecontent ,PortletEO portlet) {
//		StringBuffer content = new StringBuffer();
//		content.append("<table width=100% border=0 cellspacing=0 cellpadding=1 bgcolor=CCCCCC><tr><td>");
//		content.append("<table width=100% border=0 cellspacing=0 cellpadding=2 bgcolor=FFFFFF align=center valign=top>");
//		content.append("<tr><td align=center class=\"normalSmall\" colspan=2>");
//		content.append(insidecontent);
//		content.append("</td></tr>");
//		content.append("</table>");
//		content.append("</td></tr></table>");
//		return content.toString();
//	}

	protected String side = "left";

	public void setSide( String s) {
		side = s;
	}
}