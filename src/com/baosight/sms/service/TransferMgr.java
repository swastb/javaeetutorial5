package com.baosight.sms.service;

import java.util.List;

import com.baosight.sms.mode.SmsTransferInfo;
import com.baosight.sms.mode.SmsTransferList;

/**
 * <p>Decription:短信转发</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-8</p>
 */
public interface TransferMgr {

	public abstract void saveInfo(SmsTransferInfo instance);

	public abstract void deleteInfo(SmsTransferInfo persistentInstance);

	public abstract SmsTransferInfo findInfoById(String id);

	public abstract List findByExample(SmsTransferInfo instance);

	public abstract List findInfoAll();

	public abstract void saveList(SmsTransferList instance);

	public abstract void deleteList(SmsTransferList persistentInstance);

	public abstract SmsTransferList findListById(String id);

	public abstract List findListByExample(SmsTransferList instance);

	public abstract void deleteListByInfo(String infoId);

	/**
	 * <p>Decription:公共通讯录所有组</p>
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-10-13</p>
	 */
	public abstract List findAddBookList();

	/**
	 * <p>Decription:公共通讯录中所有人</p>
	 * @param type 取的不同的值，move_phone:手机，fax:传真
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-10-13</p>
	 */
	public abstract List findBookPersonList(String type);

	/**
	 * <p>Decription:查询转发列表</p>
	 * @param instance
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-10-10</p>
	 */
	public abstract List findListByQuery(SmsTransferList instance);

}