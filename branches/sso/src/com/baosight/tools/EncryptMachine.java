package com.baosight.tools;

/**
 * 类说明 加密器接口
 */
public interface EncryptMachine {
	/*
	 * 获得加密后的数据
	 */
	public String getEncryptData(String data, String item);

	/*
	 * 获得解密后的数据
	 */
	public String getDncodeData(String data);

	/*
	 * 加密算法
	 */
	public byte[] encode(byte[] input, byte[] key) throws Exception;

	/*
	 * 解密算法
	 */
	public byte[] decode(byte[] input, byte[] key) throws Exception;
}