package com.data.load.webapp.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.baosight.base.service.*;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;

/**
 * <p>
 * StartupListener class used to initialize and database settings and populate
 * any application-wide drop-downs.
 * 
 * <p>
 * Keep in mind that this listener is executed outside of
 * OpenSessionInViewFilter, so if you're using Hibernate you'll have to
 * explicitly initialize all loaded data at the Dao or service level to avoid
 * LazyInitializationException. Hibernate.initialize() works well for doing
 * this.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class StartupListener extends ContextLoaderListener implements
		ServletContextListener {

	private static final Log log = LogFactory.getLog(StartupListener.class);

	public void contextInitialized(ServletContextEvent event) {
		List result = new LinkedList();
		if (log.isDebugEnabled()) {
			log.debug("initializing context...");
		}

		// call Spring's context ContextLoaderListener to initialize
		// all the context files specified in web.xml
		super.contextInitialized(event);

		ServletContext context = event.getServletContext();

		// Orion starts Servlets before Listeners, so check if the config
		// object already exists
		Map config = (HashMap) context.getAttribute(Constants.CONFIG);

		if (config == null) {
			config = new HashMap();
		}

		if (log.isDebugEnabled()) {
			log.debug("[StartupListener.contextInitialized]:config = " + config);
		}

		/*
		 * if (context.getInitParameter(Constants.CSS_THEME) != null) {
		 * config.put(Constants.CSS_THEME,
		 * context.getInitParameter(Constants.CSS_THEME)); }
		 * 
		 * if(log.isDebugEnabled()) { log.debug("第二个config包含的内容是：" + config); }
		 */
		
		//在系统启动时把Resouce和Dictionary中的数据都load出来存到Constants.resourceMap和Constants.dictionaryMap中
		try
		{
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		ITbUserMgr userMgr=(ITbUserMgr)ctx.getBean("userMgr");
		IDeptMgr deptMgr=(IDeptMgr)ctx.getBean("deptMgr");
		IPstMgr pstMgr=(IPstMgr)ctx.getBean("pstMgr");

		//TbDept system = deptMgr.getSystemRoot();
		
		
/*		System.out.println("length---------------"+result.size());
		System.out.println("length-------sersutl--------"+result);*/
		//getChild(userMgr,deptMgr,pstMgr,result,system.getId());
		}
		catch(Exception e)
		{
		log.info("Resource and Dictionary init error......");
		e.printStackTrace();
		}

		if (log.isDebugEnabled()) {
			log.debug("[StartupListener.contextInitialized]:ApplicationContext = " + config);
		}

		/*
		 * boolean encryptPassword = false; try { ProviderManager provider =
		 * (ProviderManager) ctx.getBean("authenticationManager"); for (Iterator
		 * it = provider.getProviders().iterator(); it.hasNext();) {
		 * AuthenticationProvider p = (AuthenticationProvider) it.next(); if (p
		 * instanceof RememberMeAuthenticationProvider) {
		 * config.put("rememberMeEnabled", Boolean.TRUE); } }
		 * 
		 * if (ctx.containsBean("passwordEncoder")) { encryptPassword = true;
		 * config.put(Constants.ENCRYPT_PASSWORD, Boolean.TRUE); String
		 * algorithm = "SHA"; if (ctx.getBean("passwordEncoder") instanceof
		 * Md5PasswordEncoder) { algorithm = "MD5"; }
		 * config.put(Constants.ENC_ALGORITHM, algorithm); } } catch
		 * (NoSuchBeanDefinitionException n) { // ignore, should only happen
		 * when testing }
		 */

		context.setAttribute(Constants.CONFIG, config);

		// output the retrieved values for the Init and Context Parameters
		/*
		 * if (log.isDebugEnabled()) { log.debug("Remember Me Enabled? " +
		 * config.get("rememberMeEnabled")); log.debug("Encrypt Passwords? " +
		 * encryptPassword); if (encryptPassword) { log.debug("Encryption
		 * Algorithm: " + config.get(Constants.ENC_ALGORITHM)); }
		 * log.debug("Populating drop-downs..."); }
		 */

		// setupContext(context);
		Constants.orgList=result;
	}
	private void getChild(ITbUserMgr userMgr,IDeptMgr deptMgr,IPstMgr pstMgr,List result, String parentId) {
		List children = getChildren(userMgr,deptMgr,pstMgr,parentId);
		if (children.size() > 0) {
			result.addAll(children);
			Iterator iter = children.iterator();
			while (iter.hasNext()) {
				Object item = iter.next();
				if (item instanceof TbDept) {
					getChild(userMgr,deptMgr,pstMgr,result, ((TbDept) item).getId());
				}
				if (item instanceof TbPst) {
					getChild(userMgr,deptMgr,pstMgr,result, ((TbPst) item).getId());
				}
				if (item instanceof TbUser) {
					getChild(userMgr,deptMgr,pstMgr,result, ((TbUser) item).getId());
				}
			}
		}
	}

	/**
	 * 得到给定节点的所有直接子节点
	 * 
	 * @param parentId
	 *            给定节点的id
	 * @return 该节点的所有子节点
	 */
	private List getChildren(ITbUserMgr userMgr,IDeptMgr deptMgr,IPstMgr pstMgr,String parentId) {
		List result = new LinkedList();
		// 从deptMgr中找
		result.addAll(deptMgr.getChildren(parentId));
		// 从pstMgr中找
		result.addAll(pstMgr.getByDeptId(parentId));
		// 从userMgr中找
		result.addAll(userMgr.getChildren(parentId));
		return result;
	}
}
