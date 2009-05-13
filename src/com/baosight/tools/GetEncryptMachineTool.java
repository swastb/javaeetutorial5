package com.baosight.tools;


//import com.browsesoft.PropertiesService;

/**
 * 获得加密器的工具类
 */
public class GetEncryptMachineTool {
	/**
	 * 取得属性文件中配置的加密器
	 * 
	 * @return EncryptMachine
	 */
	public static EncryptMachine getEncryptMachine() {
		String userPassEncrypt = null;
		EncryptMachine em = null;
		String falseEncryptMachine = "com.baosight.tools.FlaseSimpleEncryptMachine";//"com.browsesoft.oa.FlaseSimpleEncryptMachine";
		try {
			// 取得用户加密器
			// 取得加密器类名， 来源:属性文件
			userPassEncrypt = "com.baosight.tools.SimpleEncryptMachine";//PropertiesService.getProperty("Encrypt","encryptmachine");
			em = (EncryptMachine) Class.forName(userPassEncrypt).newInstance();
		} catch (Exception ex) {
			// 创建假加密器对象，FlaseEncryptMachine空实现了EncryptMachine接口
			try {
				em = (EncryptMachine) Class.forName(falseEncryptMachine)
						.newInstance();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}
		return em;
	}
}
