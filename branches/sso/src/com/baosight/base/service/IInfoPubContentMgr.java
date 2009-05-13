package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbGovInfoPubContent;
import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbInfoPubContent;
import com.baosight.mode.TbUser;

public interface IInfoPubContentMgr {
	public List findAll();

	public  TbInfoPubContent findById(String id);

	public void updte(TbInfoPubContent model);

	public void delete(String id);

	public void save(TbInfoPubContent model);
	
	public void saveGovInfoPub(TbGovInfoPubContent model);
	
	public  TbGovInfoPubContent findGovInfoPubById(String id);
	
	public void deleteGovInfoPub(String id);
	
	public void updteGovInfoPub(TbGovInfoPubContent model);

	public List findByTitle(String title); 
	
	public abstract List findByInfoId(Object infoId);
	
	public abstract List findByInfoSubject(Object infoSubject,String code);
	
	public abstract long findCountByInfoSubject(Object infoSubject);

	public abstract List findByInfoSubjectList(Object infoSubject);
	/*按信息名模糊查询*/
	public abstract List findByPIdInfoName(TbUser user,String parentid,String claname,String type);
	/*按信息名模糊查询*/
	public abstract List findByPIdInfoNameGov(TbUser user,String parentid,String claname,String type);
	/**
	 * same name checked
	 * @param id
	 * @param value
	 * @param flag
	 * @return
	 */
	public String checkInfoCommName(String parentid,String id, String value,  String flag);
	/**
	 * same name checked
	 * @param id
	 * @param value
	 * @param flag
	 * @return
	 */
	public String checkInfoClaCommName(String parentid,String id, String value,  String flag);
	/**
	 * 有lsh_type根据流水号类型找最大的流水号
	 * @param lsh_type
	 * @return
	 */
	public String findMaxLiuShHByPId(String lsh_type);
	/**
	 * 首页综合信息查询
	 * @param infoSubject
	 * @return
	 */
	public abstract List findByInfoSubjectlist(Object infoSubject);
	/**
	 * 判断用户是否为某个角色下的人员
	 */
	public boolean isForRoleUser(TbUser user,String roleId);
	/**
	 * 受理中心信息查看列表
	 * @param parentid
	 * @param infoname
	 * @return
	 */
	public List findSlzxInfoList(String parentid, String infoname);
	/**
	 * 查找出所有政府信息
	 * @return
	 */
	public List findAllGovInfo();
}
