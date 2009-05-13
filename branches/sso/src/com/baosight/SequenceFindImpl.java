package com.baosight;

import java.util.UUID;


/**
 * 得到系统所需要的序号，可以预装载一定量的序号
 */
public class SequenceFindImpl implements SequenceFind {
	/**
	 * 本次缓存的最大序号
	 */
	private static int maxID = 0;

	/**
	 * 当前取得的序号
	 */
	private static int id = 0;

	/**
	 * 得到当前序号
	 * 
	 * @return 当前序号
	 * @throws java.sql.SQLException
	 */
	public synchronized String getId() {
//		// 保存要返回的id号
//		int cur = id;
//		// id号后移
//		id++;
//		// 如果超出缓存
//		if (id >= maxID) {
//			// 装载缓存
//			loadID();
//		}
//		return cur;
		UUID uuid = UUID.randomUUID();
		String result = uuid.toString();
		result = result.replaceAll("-", "");
		return result;
	}


	/**
	 * 得到当前序号
	 * 
	 * @return 当前序号
	 * @throws java.sql.SQLException
	 */
//	public static void loadID() throws Exception {
//		// 从序号表中得到当前序号
//		String sql = "select bssequence from bsdual";
//		String result[][] = DBTools.executeQueryWithTableHead(sql);
//		int cur = Integer.parseInt(result[1][0]);
//		// 得到缓存的个数
//		int count = 1;
//		try {
//			count = Integer.parseInt(PropertiesService.getProperty("sequence",
//					"count"));
//		} catch (Exception e) {
//		}
//		// 最大序号为当前序号+缓存个数
//		maxID = cur + count;
//		id = cur;
//		// 更新序号表
//		DBTools.excuteUpdate("update bsdual set bssequence = "
//				+ Integer.toString(maxID));
//	}
}