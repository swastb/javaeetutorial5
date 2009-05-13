<HTML>
	<HEAD>
		<%@ page contentType="text/html;charset=gb2312"%>
		<%@ page import="com.baosight.layout.*"%>
		<%@ page import="com.baosight.layout.table.*"%>
		<%@ page import="com.baosight.layout.portlet.*"%>
		<%@ page import="java.sql.*"%>
		<%@ page import="java.util.*,com.baosight.mode.TbUser"%>
		<%
					TbUser tbUser = (TbUser) request.getSession().getAttribute(
					"SYSTEM_USER_SESSION");
			String loginType = (String) request.getAttribute("loginType");
			boolean bSuccess = true;//定义一个布尔型变量
			BasePortletClass baseClass = null;
			Vector portlets = new Vector();//用于存储列中要显示的小窗口(ID)
			String userId = tbUser.getId();//获得Session的值
			UserEO user = new UserEO();
			LayoutEO layout = null;//声明LayoutEO对象
			if (userId == null || userId.equals("")) {//如果sesiion的值为null或为空
				bSuccess = false;
				if (loginType != null && loginType.equals("1")) {
					response.sendRedirect("index_ju.jsp");
				} else if (loginType != null && loginType.equals("2")) {
					response.sendRedirect("index_xxzx.jsp");
				} else if (loginType != null && loginType.equals("3")) {
					response.sendRedirect("index_slzx.jsp");
				} else {
					response.sendRedirect("index.jsp");//转向index.jsp
				}
			}
			if (userId != null) {
				System.out.println("-------" + userId);
				user.setId(userId);
				user.setName(tbUser.getName());
				user.setPassword(tbUser.getPwd());
				user.setUserAcc(tbUser.getUserAcc());
			}
			if (bSuccess)
				layout = LayoutEO.getInstance(user);//获得该用户所设置的布局
		%>
		<TITLE>个性化主页</TITLE>
		<link rel="stylesheet" href="css/main.css">
		<link rel="stylesheet" href="css/calendar.css">
		<script type="text/javascript" src="js/prototype-1.4.0.js"></script>
	</HEAD>
	<link href="css/index-css.css" rel="stylesheet" type="text/css">
	<body style='overflow:scroll;overflow-x:hidden' leftmargin="0"
		topmargin="0">
		<input type="button" value="添加新窗口" onclick="openpan()"/>
		<table width="885" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FFFFFF" id="parentTable">
			<TR>
				<TD width="310" id="left">
					<!-- 以下是显示左侧的小窗口开始-->
					<%
						portlets = layout.getNarrowLeft();//获得左侧所有的小窗口
						for (int i = 0; i < portlets.size(); i++) {//循环小窗口
							String portID = (String) portlets.get(i);
							PortletEO portlet = new PortletEO(Integer.parseInt(portID));
							if (portlet != null && portlet.getId() > 0) {
								String className = portlet.getJavaClassName();//获得该小窗口对应的Java类
								try {//使用类反射机制装载该类
							baseClass = (BasePortletClass) Class.forName(className)
									.newInstance();
							out.println(baseClass.render(user, portlet));//显示小窗口
								} catch (ClassNotFoundException cnfe) {
							continue;
								}
							}
						}
					%>
					<!-- 显示左侧的小窗口结束-->
				</TD>
				<TD width="310" id=wide>
					<!-- 以下是显示中间的小窗口开始-->
					<%
						portlets = layout.getWide();//获得中间所有的小窗口
						for (int i = 0; i < portlets.size(); i++) {//循环小窗口
							String portID = (String) portlets.get(i);
							PortletEO portlet = new PortletEO(Integer.parseInt(portID));
							if (portlet != null && portlet.getId() > 0) {
								String className = portlet.getJavaClassName();
								try {//使用类反射机制装载该类
							baseClass = (BasePortletClass) Class.forName(className)
									.newInstance();
							baseClass.setSide("wide");//设置为中间
							out.println(baseClass.render(user, portlet));//显示小窗口
								} catch (ClassNotFoundException cnfe) {
							continue;
								}
							}
						}
					%>
					<!-- 显示中间的小窗口结束-->
				</TD>
				<TD width="310" id=right>
					<!-- 以下是显示右侧的小窗口开始-->
					<%
						portlets = layout.getNarrowRight();//获得右侧所有的小窗口
						for (int i = 0; i < portlets.size(); i++) {//循环小窗口
							String portID = (String) portlets.get(i);
							PortletEO portlet = new PortletEO(Integer.parseInt(portID));
							if (portlet != null && portlet.getId() > 0) {
								String className = portlet.getJavaClassName();
								try {//使用类反射机制装载该类
							baseClass = (BasePortletClass) Class.forName(className)
									.newInstance();
							baseClass.setSide("right");//设置为右侧
							out.println(baseClass.render(user, portlet));//显示小窗口
								} catch (ClassNotFoundException cnfe) {
							continue;
								}
							}
						}
					%>
					<!-- 显示右侧的小窗口结束-->
				</TD>
			</TR>
		</TABLE>
		<table width="885" border="0" cellpadding="0" cellspacing="0"
			align="center" bgcolor="#FFFFFF">
			<tr>
				<td align="center" valign="top">
					<table width="885" align="center" bgcolor="#FFFFFF" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>
								<select
									onchange="javascript:window.open(this.options[this.selectedIndex].value)"
									name="select2">
									<option selected="selected">
										国内省级水利厅局
									</option>
									<option value="http://www.bjwater.gov.cn" />
										北京市
									<option value="http://www.shanghaiwater.gov.cn" />
										上海市
									<option value="http://www.tjwcb.gov.cn" />
										天津市
									<option value="http://www.cqwater.gov.cn" />
										重庆市
									<option value="http://www.water.hebnet.gov.cn" />
										河北省
									<option value="http://www.sxwater.gov.cn" />

										山西省
									<option value="http://www.dwr.ln.gov.cn" />





										辽宁省
									<option value="http://slt.jl.gov.cn" />





										吉林省
									<option value="http://www.e-gov.hl.cn/agriculture/shuili">
										黑龙江省
									</option>
									<option value="http://www.jswater.gov.cn" />





										江苏省
									<option value="http://www.zjwater.com" />





										浙江省
									<option value=" http://www.ahsl.gov.cn/   ">
										安徽省
									</option>
									<option value="http://www.fjwater.gov.cn" />





										福建省
									<option value="http://www.jxfx.gov.cn/  ">
										江西省
									</option>
									<option value="http://www.hnsl.gov.cn/  ">
										河南省
									</option>
									<option value="http://www.hubeiwater.gov.cn" />





										湖北省
									<option value="http://www.hnwr.gov.cn" />





										湖南省
									<option value="http://www.slt.gd.gov.cn" />





										广东省
									<option value="http://202.100.218.58/gov/jshuili/sljzy.htm">
										海南省
									</option>
									<option value="http://www.scwater.net/  ">
										四川省
									</option>
									<option value="http://www.gzmwr.gov.cn/ ">
										贵州省
									</option>
									<option value="http://www.wcb.yn.gov.cn/ ">
										云南省
									</option>
									<option value="http://www.xzwater.gov.cn/  ">
										西藏自治区
									</option>
									<option value="http://210.83.3.18/  ">
										陕西省
									</option>
									<option value="http://www.gssl.gov.cn/  ">
										甘肃省
									</option>
									<option value="http://www.nxsl.gov.cn/default.asp">
										宁夏
									</option>
									<option value="http://www.qhsl.gov.cn/  ">
										青海省
									</option>
									<option value="http://www.info.gov.hk/wsd/index.htm  ">
										香港
									</option>
								</select>
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								<select style="WIDTH: 135px;
                              id="
									menu4" 
                              onchange="javascript:window.open(this.options[this.selectedIndex].value)"
									name="select3">
									<option selected="selected">
										国内市级水利机构
									</option>
									<option value="http://www.shanghaiwater.gov.cn" />
										上海
									<option value="http://www.gzwater.gov.cn" />





										广州
									<option value="http://www.szwrb.gov.cn" />





										深圳
									<option value="http://www.swj.dl.gov.cn" />





										大连
									<option value="http://www.jnwater.gov.cn" />





										济南
									<option value="http://slsd.wztelecom.zj.cn" />





										温州
									<option value="http://www.sysl.gov.cn" />





										沈阳
									<option value="http://sanfang.nanhai.gov.cn" />




										南海
									<option value="http://www.zhanjiang.gov.cn/zjsl" />





										湛江
									<option value="http://www.huainan.gov.cn/shuili/index.htm">
										淮南
									</option>
									<option value="http://www.gygov.gov.cn/shuidianjv/shuilijv.htm">
										贵阳
									</option>
									<option value="http://www.jqwater.net" />





										酒泉
									<option value="http://202.98.242.42" />





										昌都
									<option value="http://www.yqs-slj.zj001.net" />





										乐清
									<option value="http://www.gm.fswater.gov.cn" />





										高明
									<option value="http://www.dh.jl.gov.cn/shuiliju/jzzc.htm">
										敦化
									</option>
									<option value="http://www.shuili.cangzhou.gov.cn" />





										沧州
									<option value="http://www.ycsl.gov.cn" />





										宜昌
									<option value="http://www.xfwater.com" />





										襄樊
									<option value="http://www.qzwater.com" />





										衢州
									<option value="http://jjsl.nease.net/2001zjh/2001zjh.htm">
										椒江
									</option>
									<option value="http://szszys.sosoo.net" />





										宁波
									<option value="http://www.cndx.net/cnslj/index.htm">
										苍南
									</option>
									<option value="http://www.yzsl.gov.cn" />





										扬州
									<option value="http://www.jszjsl.gov.cn" />





										镇江
									<option value="http://www.tzwater.com" />





										泰州
									<option value="http://www.wxwater.gov.cn" />





										无锡
									<option value="http://xntf.wx-e.com" />




										咸宁
									<option value="http://www.zqwater.gov.cn" />





										肇庆
									<option value="http://hsslj.heshan.net" />





										鹤山
									<option value="http://www.njslw.com" />





										宁江
									<option value="http://www.shlj.sjz.net.cn" />





										石家庄
									<option value="http://www.hsswj.gov.cn/hsswj/index.jsp">
										衡水
									</option>
									<option value="http://bzwater.533.net" />





										滨州
									<option value="http://www.lzsl.gov.cn" />





										临淄
									<option value="http://www.cqrcsl.com" />





										荣昌
									<option value="http://www.cqlpsl.com" />





										梁平
									<option value="http://www.cqtnsl.com" />





										潼南
									<option value="http://www.cqtlsl.com" />





										铜梁
									<option value="http://www.cqbssl.com" />





										壁山
									<option value="http://www.cqkxsl.com" />





										开县
									<option value="http://www.cqddksl.com" />





										大渡口
									<option value="http://www.cqwssl.com" />




										万盛
									<option value="http://www.cqwzsl.com" />




										万州
									<option value="http://www.cqpssl.com" />





										彭水
									<option value="http://www.cqxssl.com" />





										秀山
									<option value="http://www.yywr.gov.cn" />





										益阳
									<option value="http://www.hhsl.gov.cn" />




										红河
									<option value="http://slj.liuzhou.gov.cn" />





										柳州
									<option value="http://www.lljj.com" />




										岳阳
									<option value="http://www.fswater.gov.cn" />





										佛山
									<option value="http://slj.lyg.gov.cn" />





										连云港
									<option value="http://www.qzsdj.gov.cn" />





										泉州
								</select>
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								<select style="WIDTH: 140px; HEIGHT: 20px"
									onchange="javascript:window.open(this.options[this.selectedIndex].value)"
									name="select">
									<option selected="selected">
										业内网站
									</option>
									<option value="http://www.shhes.org.cn" />





										上海市水利学会
									<option value="http://www.cjw.com.cn" />





										水利部长江水利委员会
									<option value="http://www.yellowriver.gov.cn" />





										水利部黄河水利委员会
									<option value="http://www.hu.mwr.gov.cn/ ">
										水利部淮河水利委员会
									</option>
									<option value="http://www.hwcc.gov.cn" />





										水利部海河水利委员会
									<option value="http://www.pearlwater.gov.cn/ ">
										水利部珠江水利委员会
									</option>
									<option value=" http://www.slwr.gov.cn/">
										水利部松辽水利委员会
									</option>
									<option value=" http://www.tba.gov.cn/  ">
										水利部太湖流域管理局
									</option>
									<option value="http://rencai.chinawater.net.cn" />





										水利部人才资源开发中心
									<option value=" http://www.waterinfo.com.cn/  ">
										水利部发展研究中心
									</option>
									<option value="http://www.ccwm.com.cn" />





										中国水利市场网
									<option value="http://www.water-sh.com" />





										上海市自来水市南有限公司
									<option value="http://www.shanghaiwater.com" />




										上海市自来水市北有限公司
									<option value="http://www.minhangwater.com/index.asp">
										上海市自来水闵行有限公司
									</option>
									<option value=" http://www.pudongwater.com/index.asp">
										上海浦东威立雅自来水有限公司
									</option>
									<option value="http://www.swec.net" />





										上海水环境建设有限公司
									<option value="http://www.ssrcc.com/" />




										上海市苏州河综合整治建设有限公司
									<option value="http://www.swcc.org.cn" />




										水土保持生态环境建设网
									<option value="http://www.giwp.org.cn" />





										水电水利规划设计总院
									<option value=" http://www.hydroinfo.gov.cn/">
										中国水文信息网
									</option>
									<option value=" http://www.irrigate.com.cn/    ">
										中国排灌信息网
									</option>
									<option value="http://www.chinawater.net.cn" />





										中国水利科技信息网
									<option value="http://www.shuiwang.com/   ">
										水网
									</option>
									<option value="http://www.h2o-china.com" />




										中国水网
									<option value="http://www.e-water.com.cn/  ">
										华夏水网
									</option>
									<option value="http://www.waterwaswater.com" />





										给水排水
									<option value="http://www.gpszx.com" />





										给排水在线
									<option value="http://www.chinawater.net/  ">
										中国给水排水
									</option>
									<option value="http://www.h2o-china.com/general/index-g.asp">
										给水技术博物馆
									</option>
									<option value="http://www.cnwaternews.com" />




										中国水务网
									<option value="http://www.c-water.com.cn/  ">
										中国水工业网
									</option>
									<option value="http://www.chinasewage.com" />





										中国污水网
									<option value="http://www.chinawater.com.cn/ ">
										中国水利报社
									</option>
									<option value=" http://jhe.ches.org.cn/  ">
										水利学报
									</option>
									<option value="http://www.waterpub.com.cn" />





										中国水利水电出版社
									<option value=" http://www.nceib.iwhr.com/">
										国家节水灌溉北京工程技术研究中心
									</option>
									<option value="http://www.bjwatergroup.com" />





										北京市自来水集团有限责任公司
									<option value="http://www.pdswater.com" />





										平顶山市自来水公司
									<option value=" http://www.ytkfqwater.com.cn/">
										烟台经济技术开发区自来水公司
									</option>
									<option value="http://www.zibowater.com" />





										淄博市自来水公司
									<option value="http://www.whwater.com" />





										武汉市自来水公司
									<option value="http://www.xfgs.com.cn" />





										襄樊供水总公司
									<option value="http://www.tianjinwater.com.cn" />





										天津自来水集团有限公司
									<option value="http://www.supplywater.com" />





										长沙市自来水公司
									<option
										value="http://www.chinacity.net/zgcs/liaoning/shenyang/shen35/shen58.htm">
										沈阳市自来水总公司
									</option>
									<option value="http://www.waterchina.com" />





										深圳市水务（集团）有限公司
									<option value="http://www.ddzwater.com.cn" />





										大连经济技术开发区自来水公司
									<option value="http://www.fswater.com" />




										佛山水司
									<option value="http://www.qqhrwater.com" />





										齐齐哈尔市自来水公司
									<option value="http://www.chwater.com" />





										澄海市自来水公司
									<option value="http://www.ntws.com.cn" />





										南通市自来水公司
									<option value="http://www.wuwater.com" />





										梧州市自来水公司
									<option value="http://jingtai.363.net/index.htm">
										宁波市自来水公司
									</option>
									<option value="http://www.tysy.com.cn" />





										海南天涯水业（集团）公司
									<option value="http://www.xiamenwater.com" />





										厦门市自来水集团有限公司
									<option value="http://www.viewchina.org/qzss" />




										泉州市自来水公司
									<option value="http://www.jnwater.com.cn" />





										济南市自来水公司
								</select>
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								<select style="WIDTH: 105px; HEIGHT: 20px"
									onchange="javascript:window.open(this.options[this.selectedIndex].value)"
									name="select">
									<option selected="selected">
										国外水务机构
									</option>
									<option value="http://www.wef.org" />




										Water Environment Federation
									<option value="http://www.awt.org" />





										Association of water Technologies
									<option value="http://www.awwa.org" />





										Americian Water Works Association
									<option value="http://www.water4people.org" />





										Water for People
									<option value="http://www.givewater.org" />





										Give Water
									<option value="http://www.worldwater.org" />





										The World`s Water
									<option value="http://www.waterwiser.org" />




										Water Wiser
									<option value="http://www.iwahq.org.uk" />




										International Water Association
									<option value="http://www.cleanwateraction.org" />




										Clean Water Action
									<option value="http://www.water.org.uk" />





										Water UK
									<option value="http://www.w-ww.com" />





										Water-Wastewater Web
									<option
										value=" http://www.wateronline.com/content/homepage/default.asp">
										Water online
									</option>
									<option value="http://water.usgs.gov" />





										Water Resources of the United States
									<option value="http://ga.water.usgs.gov/edu" />





										Water Science for Schools
									<option value="http://www.thames-water.com" />





										Thames Water
									<option value="http://www.uswaternews.com/homepage.htm">
										U.S. Water News
									</option>
									<option value="http://wow.nrri.umn.edu/wow" />





										Water on the Web
									<option value="http://www.thewaterpage.com" />





										The Water Page
									<option
										value="http://www.state.nv.us/cnr/ndwp/dict-1/waterwds.htm">
										Water Words Dictionary
									</option>
									<option value="http://www.nal.usda.gov/wqic">
										Water Quality Information Center
									</option>
									<option value="http://www.bottledwaterweb.com" />




										Bottled Water Web
									<option value="http://www.wcc.nrcs.usda.gov" />





										National Water and Climate Center
									<option value="http://www.water-technology.net" />





										Water Technology
									<option value="http://www.cleanwater.gov" />




										Cleanwater.gov
									<option value="http://www.southernwater.co.uk" />




										Southern Water
									<option value="http://www.fi.edu/city/water">
										Water in The City
									</option>
									<option value="http://www.anglianwater.co.uk" />





										Anglian Water
									<option value="http://www.sydneywater.com.au" />





										Sydney Water
									<option value="http://www.unesco.org/water" />





										United Nations Educational Scientific and Cultural
										Organization Water
									<option value="http://www.wcp.net" />




										Water Conditioning and Pur?9ification Magazine
									<option value="http://www.epa.gov/water">
										U.S. Environmental Protection Agency &gt; water
									</option>
									<option value="http://www.wsscc.org" />




										Water Supply &amp; Sanitation Collaborative Council
								</select>
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								<select class="tx1" style="WIDTH: 120px"
									onchange="javascript:window.open(this.options[this.selectedIndex].value) "
									name="select">
									<option selected="selected">
										局属部门、单位
									</option>
									<option value="http://61.151.248.163">
										上海市防汛信息服务网
									</option>
									<option value="http://www.shswyouth.com">
										上海市水务青年网
									</option>
									<option value="http://www.shsl.org.cn" />




										上海市水利管理处
									<option value="http://www.wsa.gov.cn" />




										上海市供水管理处





										<!--option 
                                value="http://paishui.shanghaiwater.gov.cn"/>
          
          
      
        
              上海市排水管理处-->
									<option value="http://www.hydrology.sh.cn" />




										上海市水文总站
									<option value="http://www.shanghaiwater.org" />




										上海市防汛信息中心（上海市水务信息中心）
									<option value="http://www.shwaterplan.com" />




										上海市水务规划设计院
									<option value="http://www.swedri.com" />




										上海市水务工程设计研究院有限公司
									<option value="http://www.shhb.com.cn" />



										上海宏波工程咨询管理有限公司
									<option value="http://www.sscrpho.org" />



										上海苏州河环境综合整治领导小组办公室
								</select>
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								<select class="tx1" style="WIDTH: 120px"
									onchange="javascript:window.open(this.options[this.selectedIndex].value) "
									name="select">
									<option selected="selected">
										郊区（县）防汛办
									</option>
									<option value="http://211.144.95.130:9080/website/index.jsp">
										浦东新区防汛办
									</option>
									<option value="http://31.16.1.9/shfx/jiuzai/xuhui.htm" />
										徐汇区防汛办
									</option>
									<option value="http://31.16.1.9/shfx/jiuzai/changnin.htm" />
										长宁区防汛办
									</option>
									<option value="http://172.1.5.1/" />
										普陀区防汛办
									</option>
									<option value="http://172.12.1.100/" />
										闸北区防汛办
									</option>
									<option value="http://31.16.1.9/shfx/jiuzai/hongke.htm" />
										虹口区防汛办
									</option>
									<option value="http://192.168.2.98/ypfx" />
										杨浦区防汛办
									</option>
									<option value="http://31.16.1.9/shfx/jiuzai/huangpu.htm" />
										黄浦区防汛办
									</option>
									<option value="http://31.16.1.9/shfx/jiuzai/luwan.htm" />
										卢湾区防汛办
									</option>
									<option value="http://172.9.1.100/" />
										静安区防汛办
									</option>
									<option value="http://172.13.1.1/" />
										宝山区防汛办
									</option>
									<option value="http://172.7.1.100/" />
										闵行区防汛办
									</option>
									<option value="http://www.jdwater.gov.cn/">
										嘉定区防汛办
									</option>
									<option value="http://172.8.1.1/" />
										松江区防汛办
									</option>
									<option value="http://192.69.1.1/" />
										金山区防汛办
									</option>
									<option value="http://www.nanhui.gov.cn/nhsw/default.jsp">
										南汇区防汛办
									</option>
									<option value="http://222.72.135.140/fxsw_new/index.asp">
										奉贤区防汛办
									</option>
									<option value="http://192.1.8.100/" />
										青浦区防汛办
									</option>
									<option value="http://www.cmwater.gov.cn">
										崇明县防汛办
									</option>
								</select>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="15" bgcolor="#E1EAF1">
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#E1EAF1" class="zw">
					2007-2010&nbsp;&nbsp;上海市水务局 &nbsp;&nbsp;版权所有
				</td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
	</body>
	<script type="text/javascript">
//关闭小窗口
function closePortlet(portlet_id,side)
{
   var url="layout.do?action=close&id="+portlet_id+"&side="+side;
   //alert(url);
   var myAjax = new Ajax.Request(
				url,
				{
					//请求方式：POST
					method:'post',
					//指定回调函数
					onComplete: closePortCalback(portlet_id,side),
					//是否异步发送请求
					asynchronous:true
				});
}
function closePortCalback(portlet_id,side)
{
   var elem = document.getElementById("portlet_all_"+portlet_id+"_"+side);
   if (elem!=null)
     elem.parentNode.removeChild(elem);
}

//改变窗口位置
function change(){
	//取得各列小窗口ID
	var p_left = getPortlets(left);
	var p_right = getPortlets(right);
	var p_wide = getPortlets(wide);		
	//使用Ajax动态提交到数据库
	var url = "layout.do?action=change&left="+p_left+"&right="+p_right+"&wide="+p_wide;
	var myAjax = new Ajax.Request(
		url,
		{
			method:'post',
			asynchronous:true
		});
}

//最大最小化小窗口
function Toggle(item) {
   var max=item+"_max";
   var min=item+"_min";
   objMax=document.getElementById(max);
   objMin=document.getElementById(min);
   obj=document.getElementById(item);

   visible=(obj.style.display!="none")  
   if (visible) {
     obj.style.display="none";
     if ( objMax != null ) objMax.style.display="block";
     if ( objMin != null ) objMin.style.display="none";
   } else {
     obj.style.display="block";
     if ( objMax != null ) objMax.style.display="none";
     if ( objMin != null ) objMin.style.display="block";
   }
}
//获取指定列内的小窗口ID
function getPortlets(item){
	var rs = "";
	var arr = new Array();
	var tabs = item.getElementsByTagName("table");
	for(var i=0; i<tabs.length; i++){
		var t = tabs[i].id.match(/\d\d/g);
		if(t==null){
			t = tabs[i].id.match(/\d/g);
		}
		arr[i] = t;
	}
	rs = arr.toString();
	return rs;
}

//添加小窗口页面
function openpan(){
	var params = getPortlets(left);
	if(params!=""){
		params +=",";
	}	
	params += getPortlets(right);
	if(params!=""){
		params +=",";
	}
	var p_wide = getPortlets(wide);	
	params += p_wide;
	var url="pan.jsp?params="+params.toString();
    var win=showModalDialog(url,window,"dialogWidth:500px;dialogHeight:300px;center:yes;help:No;status:no;resizable:No;edge:no");
	if (win=='success'){
		alert("操作成功!");
		window.location.reload();
	}    
}
function loginCheck()
{
	//请求的地址

	//创建Ajax.Request对象，对应于发送请求
	var myAjax = new Ajax.Request(
	url,
	{
		//请求方式：POST
		method:'post',
		//请求参数
		//parameters:params,
		//是否异步发送请求
		asynchronous:true
	});
}
function pagego1(go)
{
   var link= document.getElementById("syhref1");
   if(go==1)
   {
     link.src="zwzl/wsbs.htm"; 
	 document.getElementById("deimage").background="imagine/l-4-2.gif";  
	}

	if(go==2)
   {
     link.src="zwzl/wsbs1.htm"; 
	 document.getElementById("deimage").background="imagine/2l-1.gif";  
	}
}	
function pagego2(go)
{
   var link= document.getElementById("syhref2");
   if(go==1)
   {
     link.src="zwzl/zfxxgk.htm"; 
     document.getElementById("deimage1").background="imagine/l-6-2.gif";
	}

	if(go==2)
   {
     link.src="zwzl/zfxxgk.htm"; 
     document.getElementById("deimage1").background="imagine/2l-2.gif";
	}
 
}		
</script>
	<script src="Scripts/scripts.js" language="javascript"></script>
	<script defer src="Scripts/init.js" language="javascript"></script>
	<!--自动调用init()方法-->
</html>
