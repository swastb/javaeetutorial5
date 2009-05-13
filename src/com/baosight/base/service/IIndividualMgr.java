package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbIndividual;
import com.baosight.mode.TbUser;


public interface IIndividualMgr {
	public List findAll();

	public TbIndividual findById(String id);

	public void updte(TbIndividual model);

	public void delete(String id);

	public void save(TbIndividual model);
	
	public List findSelect(String name,String movephone,TbUser user);
	
    public List findindividualid(String individualid);
    public List findByNameAndPhone(String individualId);

    /**
     * <p>Decription:找到组下讯息录</p>
     * @param groupId
     * @return
     * @author heaton.cai
     * <p>Create Time:2008-10-20</p>
     */
    public List findByGroupId(String groupId);
}
