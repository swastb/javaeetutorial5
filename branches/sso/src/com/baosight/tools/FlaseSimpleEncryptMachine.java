package com.baosight.tools;

/**
 * 假加密器 实现EncryptMachine接口，空实现，用于支持在属性文件中配置加密器
 */

public class FlaseSimpleEncryptMachine implements EncryptMachine {
	/*
	 * 获得加密后的数据
	 */
	public String getEncryptData(String data, String item) {
		return data;
	}

	/*
	 * 获得解密后的数据
	 */
	public String getDncodeData(String data) {
		return data;
	}

	/*
	 * 加密算法
	 */
	public byte[] encode(byte[] input, byte[] key) throws Exception {
		return input;
	}

	/*
	 * 解密算法
	 */
	public byte[] decode(byte[] input, byte[] key) throws Exception {
		return input;
	}

}