package com.data.load.webapp.listener;

import java.util.List;
import java.util.Map;

/**
 * Constant values used throughout the application.
 * 
 * <p>
 * <a href="Constants.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class Constants {

	public static Map resourceMap;
	public static Map dictionaryMap;
	public static List orgList;
	public static boolean isBuyerSystem = false;
	// ~ Static fields/initializers
	// =============================================

	/** The name of the ResourceBundle used in this application */
	public static final String BUNDLE_KEY = "ApplicationResources";

	/** The encryption algorithm key to be used for passwords */
	public static final String ENC_ALGORITHM = "algorithm";

	/** A flag to indicate if passwords should be encrypted */
	public static final String ENCRYPT_PASSWORD = "encryptPassword";

	/** File separator from System properties */
	public static final String FILE_SEP = System.getProperty("file.separator");

	/** User home from System properties */
	public static final String USER_HOME = System.getProperty("user.home")
			+ FILE_SEP;

	/** The name of the configuration hashmap stored in application scope. */
	public static final String CONFIG = "appConfig";

	/**
	 * Session scope attribute that holds the locale set by the user. By setting
	 * this key to the same one that Struts uses, we get synchronization in
	 * Struts w/o having to do extra work or have two session-level variables.
	 */
	public static final String PREFERRED_LOCALE_KEY = "org.apache.struts.action.LOCALE";

	/**
	 * The request scope attribute under which an editable user form is stored
	 */
	public static final String USER_KEY = "userForm";

	/**
	 * The request scope attribute that holds the user list
	 */
	public static final String USER_LIST = "userList";

	/**
	 * The request scope attribute for indicating a newly-registered user
	 */
	public static final String REGISTERED = "registered";

	/**
	 * The name of the Administrator role, as specified in web.xml
	 */
	public static final String ADMIN_ROLE = "admin";

	/**
	 * The name of the User role, as specified in web.xml
	 */
	public static final String USER_ROLE = "user";

	/**
	 * The name of the user's role list, a request-scoped attribute when
	 * adding/editing a user.
	 */
	public static final String USER_ROLES = "userRoles";

	/**
	 * The name of the available roles list, a request-scoped attribute when
	 * adding/editing a user.
	 */
	public static final String AVAILABLE_ROLES = "availableRoles";

	/**
	 * The name of the CSS Theme setting.
	 */
	public static final String CSS_THEME = "csstheme";

	public static final String ATTRIBUTE_SEPARATOR = "_";

	public static final String CLASS_SEPARATOR = ".";

	public static final String STRUTS_SUFFIX = "html";

	// session
	public static final String SYSTEM_USER_SESSION = "SYSTEM_USER_SESSION";

	// system parameter
	public static final String SYSTEM_PARAMETER_MESSAGE = "SYSTEM_PARAMETER_MESSAGE";

	public static final String SYSTEM_PARAMETER_ERROR = "SYSTEM_PARAMETER_ERROR";

	public static final String SYSTEM_PARAMETER_BUTTON = "SYSTEM_PARAMETER_BUTTON";

	public static final String SYSTEM_PARAMETER_BUTTON_TEXT = "BUTTON_TEXT";

	public static final String SYSTEM_PARAMETER_BUTTON_URL = "BUTTON_URL";

	public static final String SYSTEM_PARAMETER_BUTTON_CLICK = "BUTTON_CLICK";

	public static final String SYSTEM_PARAMETER_JS_CODE = "SYSTEM_PARAMETER_JS_CODE";

	public static final String SYSTEM_PARAMETER_MENU = "SYSTEM_PARAMETER_MENU";

	// tree

	public static final String TREE_ID = "TREE_ID";

	public static final String TREE_LFT = "TREE_LFT";

	public static final String TREE_RGT = "TREE_RGT";

	public static final String TREE_TITLE = "TREE_TITLE";

	public static final String TREE_STATUS = "TREE_STATUS";

	public static final String TREE_PARENT = "TREE_PARENT";

	public static final String TREE_CHILDREN_NUMBER = "TREE_CHILDREN_NUMBER";

	public static final String TREE_CHILDREN_LIST = "TREE_CHILDREN_LIST";

	public static final String TREE_ENABLE = "TREE_ENABLE";

	public static final String TREE_LINKAGE = "TREE_LINKAGE";

	// linkage
	public static final String OPTION_TEXT = "OPTION_TEXT";

	public static final String OPTION_VALUE = "OPTION_VALUE";

	// 可能是编码引起的中文问题，所以重新提交

	public static final int GT_BUSINESS_LOG_LOGIN = 1;

	public static final int GT_BUSINESS_LOG_LOGOUT = 2;

	public static final int GT_BUSINESS_LOG_ADD = 3;

	public static final int GT_BUSINESS_LOG_UPDATE = 4;

	public static final int GT_BUSINESS_LOG_DELETE = 5;
}
