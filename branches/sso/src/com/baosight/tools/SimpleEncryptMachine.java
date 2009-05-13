package com.baosight.tools;

import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/**
 * 简单数据加密器类，实现加密器接口
 */
public class SimpleEncryptMachine implements EncryptMachine {
	/**
	 * 定义 加密算法,可用 DES,DESede,Blowfish
	 */
	private static String Algorithm = "DES";

	/**
	 * 需要加密的项
	 */
	private static String encryptItem = null;

	/**
	 * 密钥
	 */
	private byte[] key = "博视软件".getBytes();

	/**
	 * 根据服务的要求 得到加密后的数据
	 */
	public String getEncryptData(String info, String item) {
		// 允许加密，返回加密后的数据
		if (isEncrypt(item)) {
			try {
				return byte2hex(encode(info.getBytes(), key));
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		// 不允许加密，返回原数据
		else {
			return info;
		}
	}

	/*
	 * 根据服务的要求 得到解密密后的数据 @param info 需要解密的数据 @return String 解密后的数据
	 */
	public String getDncodeData(String info) {
		try {
			// 去掉 ":"
			StringTokenizer st = new StringTokenizer(info, ":");
			byte[] bytes = new byte[st.countTokens()];
			int i = 0;
			while (st.hasMoreElements()) {
				String sValue = st.nextToken();
				byte ch = Integer.decode("0x" + sValue).byteValue();
				bytes[i++] = ch;
			}
			// 返回解密后的数据
			return new String(decode(bytes, key));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 本应用是否需要
	 */
	private static boolean isEncrypt(String item) {
		// 如果加密项为空
		if (encryptItem == null) {
			try {
				// 从属性文件中读取加密项
				encryptItem = "userpassword";//PropertiesService.getProperty("Encrypt", "item");
			} catch (Exception e) {
				return false;
			}
		}
		// 如果属性文件的加密项中包含指定项
		if (encryptItem.indexOf(item) != -1) {
			// 指定项的数据允许加密
			return true;
		} else {
			// 指定项的数据允许加密
			return false;
		}
	}

	/**
	 * 二行制转字符串
	 */
	private String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
			if (n < b.length - 1) {
				hs = hs + ":";
			}
		}
		return hs.toUpperCase();
	}

	/**
	 * 生成密钥, 注意此步骤时间比较长
	 */
	public static byte[] getKey() throws Exception {
		/**
		 * 密钥工厂
		 */
		KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);
		// 密钥
		SecretKey deskey = keygen.generateKey();
		// 密钥的密文
		return deskey.getEncoded();
	}

	/**
	 * 加密
	 */
	public byte[] encode(byte[] input, byte[] key) throws Exception {
		// 密钥
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		// 算法器
		Cipher c1 = Cipher.getInstance(Algorithm);
		// 算法器初始化
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		// 加密
		byte[] cipherByte = c1.doFinal(input);
		return cipherByte;
	}

	/**
	 * 解密
	 */
	public byte[] decode(byte[] input, byte[] key) throws Exception {
		// 密钥
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		// 算法器
		Cipher c1 = Cipher.getInstance(Algorithm);
		// 算法器初始化
		c1.init(Cipher.DECRYPT_MODE, deskey);
		// 解密
		byte[] clearByte = c1.doFinal(input);
		return clearByte;
	}

	// // 将字符串转为二进制数
	// private byte[] toBytes(String content) {
	// byte[] bytes = new byte[content.length() / 2];
	// for (int i = 0; i < bytes.length; i++) {
	// int high = toByte(content.charAt(2 * i));
	// int low = toByte(content.charAt(2 * i + 1));
	// bytes[i] = (byte) (high * 16 + low);
	// }
	// return bytes;
	// }

	/**
	 * 把单个字符转换成二进制
	 */
	// private byte toByte(char ch) {
	// if (ch >= '0' && ch <= '9') {
	// return (byte) (ch - '0');
	// } else if (ch >= 'a' && ch <= 'f') {
	// return (byte) (ch - 'a' + 10);
	// } else if (ch >= 'A' && ch <= 'F') {
	// return (byte) (ch - 'A' + 10);
	// } else {
	// throw new IllegalArgumentException("字符必须是0-9或者a-f");
	// }
	// }
}
