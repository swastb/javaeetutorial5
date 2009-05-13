package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbCommonality;;

public interface ICommonalityMgr {
	
	public List findAll();

	public TbCommonality findById(String id);

	public void updte(TbCommonality model);

	public void delete(String id);

	public void save(TbCommonality model);
	
	public List findByName(String parentid,String name,String phone,String duty,String remark);
	
	public String checkMphone(String name,String fax);
//	查询二级组下的所有通讯录
	public List findByNameAndPhone(String comParentId);
	
	/**
	 * 根据公共通讯录id查询
	 * @param id
	 * @return
	 */
	public List findByCommId(String id);

	/**
	 * <p>Decription:根据组Id查找组内的人</p>
	 * @param id
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-10-17</p>
	 */
	public List findByCommonalityId(String id);
	/**
	 * 保存对象并返回id
	 * @param model
	 */
	public String saveObjRetrunId(TbCommonality model);
	/**
	 * 根据一个组成员id删除所有组中的该成员
	 * @param userIdForZu
	 */
	public void deleteFromAllZu(String userIdForZu);
	/**
	 * 根据一个组成员id找该成员所在的所有组
	 * @param userIdForZu
	 * @return
	 */
	public List findSelectedZuList(String userIdForZu);
	
	/**
	 * 查询统计模块所用 通过Id获取名称
	 */
	public List findByIdReturnName(String id);
}
