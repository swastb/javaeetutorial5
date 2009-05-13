package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.baosight.base.dao.ITbGovInfoPubContentDAO;
import com.baosight.base.dao.ITbInfoPubClaDAO;
import com.baosight.base.dao.ITbInfoPubContentDAO;
import com.baosight.base.service.IInfoPubContentMgr;
import com.baosight.mode.TbGovInfoPubContent;
import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbInfoPubContent;
import com.baosight.mode.TbRoleCla;
import com.baosight.mode.TbUser;

public class InfoPubContentMgrImpl implements IInfoPubContentMgr {

	private ITbInfoPubContentDAO tbInfoPubContentDAO;
	private ITbInfoPubClaDAO tbInfoPubClaDAO;
	private ITbGovInfoPubContentDAO tbGovInfoPubContentDAO;
	private static final String XXZHXFBSHH_ROLE = "8a99810f1b5948c3011b595249270008";//信息中心
	private static final String ZHFXXSHH_ROLE = "9f90831b1d989f38011d98a4fb740003";//政府信息发布
	private static final String TYMHSHH_ROLE = "9f90831b1d989f38011d98a639240004";//统一门户
	private static final String JXXFBSHH_ROLE = "9f90831b1d989f38011d98a7687d0005";//局信息发布
	private static final String WWXXFBSHH_ROLE = "9f90831b1d989f38011d98a966fc0006";//外网信息发布
	private static final String SHLZHXSHH_ROLE = "9f90831b1d989f38011d98aa1c620008";//受理中心发布

	public void delete(String id) {
		TbInfoPubContent item = this.tbInfoPubContentDAO.findById(id);
		this.tbInfoPubContentDAO.delete(item);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbInfoPubContentDAO.findAll();
	}

	public List findByInfoId(Object parentid) {
		// TODO Auto-generated method stub
		return this.tbInfoPubContentDAO.findByInfoId(parentid);
	}

	public TbInfoPubContent findById(String id) {
		// TODO Auto-generated method stub
		return this.tbInfoPubContentDAO.findById(id);
	}

	public void save(TbInfoPubContent model) {
		// TODO Auto-generated method stub
		this.tbInfoPubContentDAO.save(model);
	}

	public void saveGovInfoPub(TbGovInfoPubContent model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubContentDAO.save(model);
	}

	public TbGovInfoPubContent findGovInfoPubById(String id) {
		// TODO Auto-generated method stub
		return this.tbGovInfoPubContentDAO.findById(id);
	}

	public void deleteGovInfoPub(String id) {
		TbGovInfoPubContent item = this.tbGovInfoPubContentDAO.findById(id);
		this.tbGovInfoPubContentDAO.delete(item);
	}

	public void updteGovInfoPub(TbGovInfoPubContent model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubContentDAO.update(model);
	}

	public void updte(TbInfoPubContent model) {
		// TODO Auto-generated method stub
		this.tbInfoPubContentDAO.update(model);
	}

	public ITbInfoPubContentDAO getTbInfoPubContentDAO() {
		return tbInfoPubContentDAO;
	}

	public void setTbInfoPubContentDAO(ITbInfoPubContentDAO tbInfoPubContentDAO) {
		this.tbInfoPubContentDAO = tbInfoPubContentDAO;
	}

	public ITbInfoPubClaDAO getTbInfoPubClaDAO() {
		return tbInfoPubClaDAO;
	}

	public void setTbInfoPubClaDAO(ITbInfoPubClaDAO tbInfoPubClaDAO) {
		this.tbInfoPubClaDAO = tbInfoPubClaDAO;
	}

	public List findByInfoSubject(Object infoSubject, String code) {
		String hql = "from TbInfoPubContent as model where model.infoSubject= '"
				+ infoSubject
				+ "' or model.attr1 like '%"
				+ infoSubject
				+ "%' order by model.publishTime desc";
		if (code.equals("gs")) {
			return this.tbInfoPubContentDAO.findByHQL(hql, true, 0, 3);
		} else if (code.equals("fxdt")) {
			return this.tbInfoPubContentDAO.findByHQL(hql, true, 0, 12);
		} else if (code.equals("DynamicSections")) {//科室动态(下边所有栏目)
			return getContentForLayout(code,"true");
		} else if (code.equals("nianduzongjie")) {//职工考核(年度总结(下边所有栏目))
			return getContentForLayout(code,"true");
		} else if (code.equals("moreOther")) {
			TbInfoPubCla cla = this.tbInfoPubClaDAO.findById((String) infoSubject);
			if (cla != null && cla.getCode() != null && cla.getCode().equals("DynamicSections")) {//科室动态(下边所有栏目)
				return getContentForLayout(cla.getCode(),"false");
			} else if (cla != null && cla.getCode() != null && cla.getCode().equals("nianduzongjie")){//职工考核(年度总结(下边所有栏目))
				return getContentForLayout(cla.getCode(),"false");
			}else if (cla != null && cla.getCode() != null && cla.getCode().equals("zhibujianshe")){//支部建设(下边所有栏目)
				return getContentForLayout(cla.getCode(),"false");
			}else if (cla != null && cla.getCode() != null && cla.getCode().equals("xuexizhuanlan")){//学习专栏(下边所有栏目)
				return getContentForLayout(cla.getCode(),"false");
			}else {
				return this.tbInfoPubContentDAO.findByHQL(hql, true, -1, -1);
			}
		}else if (code.equals("forDQGZ")) {//党群工作
			return getContentForDQGZLayout();
		}else if(code.equals("zfxxgk")){
			hql = "from TbGovInfoPubContent model where model.status=1  order by model.createTime desc";
			return this.tbInfoPubContentDAO.findByHQL(hql, true, 0, 6);
		}else{
			return this.tbInfoPubContentDAO.findByHQL(hql, true, 0, 6);
		}
	}

	public List findByInfoSubjectList(Object infoSubject) {

		String hql = "from TbInfoPubContent as model where model.infoSubject= '"
				+ infoSubject
				+ "' or model.attr1 like '%"
				+ infoSubject
				+ "%' order by model.publishTime desc";
		return this.tbInfoPubContentDAO.findByHQL(hql, true, 0, 30);
	}

	public long findCountByInfoSubject(Object infoSubject) {
		String hql = "from TbInfoPubContent as model where model.infoSubject= '"
				+ infoSubject
				+ "' or model.attr1 like '%"
				+ infoSubject
				+ "%' ";
		long count = this.tbInfoPubContentDAO.findByHQL(hql).size();
		System.out.println("count====0000====" + count);
		return count;
	}

	/**
	 * same name checked
	 * 
	 * @param id
	 * @param value
	 * @param flag
	 * @return
	 */
	public String checkInfoCommName(String parentid, String id, String value,
			String flag) {
		// TODO Auto-generated method stub
		List list = tbInfoPubContentDAO.checkInfoCommName(parentid, id, value,
				flag);
		String checkMessage = "true";
		if (list.size() > 0) {
			checkMessage = "false";
		}
		return checkMessage;
	}

	/**
	 * same name checked
	 * 
	 * @param id
	 * @param value
	 * @param flag
	 * @return
	 */
	public String checkInfoClaCommName(String parentid, String id,
			String value, String flag) {
		// TODO Auto-generated method stub
		List list = tbInfoPubContentDAO.checkInfoClaCommName(parentid, id,
				value, flag);
		String checkMessage = "true";
		if (list.size() > 0) {
			checkMessage = "false";
		}
		return checkMessage;
	}

	/*按信息名模糊查询*/
	public List findByPIdInfoName(TbUser user,String parentid,String claname,String type){
		String subHql = "";
		String flagPubStr = this.publicFlagStr(user);
		if (!"".equals(flagPubStr) && flagPubStr != null)
			subHql = "instr('"+flagPubStr+"',model.publishFlag,1)>0 and model.sendTo=decode('"+type+"','dsh','2','bs','3','spxx','4') and ";
		String hql="from TbInfoPubContent model where (model.sendTo!='2' and model.sendTo!='3') and model.title like '%"+claname+"%' and " +
				"(model.infoSubject = '"+parentid+"' or model.attr1 like '%"+parentid+"%') order by model.recordTime desc";
		String dshorbshql="from TbInfoPubContent model where "+subHql+" model.title like '%"+claname+"%'" +
				"order by model.recordTime desc";
		if (!"dsh".equals(type) && !"bs".equals(type) && !"spxx".equals(type))
			return this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		else
			return ("".equals(subHql))?null:this.tbInfoPubClaDAO.findByHQL(dshorbshql, true, -1, -1);
	}


	/*按信息名模糊查询*/
	public List findByPIdInfoNameGov(TbUser user,String parentid,String claname,String type) {
		String subHql = "";
		if (isCanShenHe(user, ZHFXXSHH_ROLE))
			subHql = "model.status=decode('"+type+"','dsh','2','spxx','0') and ";
		String hql="from TbGovInfoPubContent model where (model.status!='2') and model.title like '%"+claname+"%' and " +
			"(model.infoSubject = '"+parentid+"' or model.attr1 like '%"+parentid+"%') order by model.createTime desc";
		String dshhql="from TbGovInfoPubContent model where "+subHql+" model.title like '%"+claname+"%'" +
			"order by model.createTime desc";
		if (!"dsh".equals(type) && !"spxx".equals(type))
			return this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		else
			return ("".equals(subHql))?null:this.tbInfoPubClaDAO.findByHQL(dshhql, true, -1, -1);
	}
	private String publicFlagStr (TbUser user) {
		StringBuffer flagStr = new StringBuffer("");
		if (isCanShenHe(user, XXZHXFBSHH_ROLE))
			flagStr.append("infopub");
		if (isCanShenHe(user, ZHFXXSHH_ROLE))
			flagStr.append("govinfopub");
		if (isCanShenHe(user, TYMHSHH_ROLE))
			flagStr.append("unifieddoor");
		if (isCanShenHe(user, JXXFBSHH_ROLE))
			flagStr.append("bureauinfopub");
		if (isCanShenHe(user, WWXXFBSHH_ROLE))
			flagStr.append("outsidenetinfopub");
		if (isCanShenHe(user, SHLZHXSHH_ROLE))
			flagStr.append("shliinfopub");
		return flagStr.toString();
	}
	public boolean isCanShenHe(TbUser user, String role) {
		String hql = "from TbUserRole ur where ur.userid='"+user.getId()+"' and ur.roleid='"+role+"'";
		List list = this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		if (list!=null&&!list.isEmpty()&&list.size()>0)
			return true;
		else
			return false;
		
	}
	public ITbGovInfoPubContentDAO getTbGovInfoPubContentDAO() {
		return tbGovInfoPubContentDAO;
	}

	public void setTbGovInfoPubContentDAO(
			ITbGovInfoPubContentDAO tbGovInfoPubContentDAO) {
		this.tbGovInfoPubContentDAO = tbGovInfoPubContentDAO;
	}

	/**
	 * 根据流水号类型找最大的流水号
	 * 
	 * @param lsh_type
	 * @return
	 */
	public String findMaxLiuShHByPId(String lsh_type) {
		/*
		 * String hql="from TbGovInfoPubContent model where
		 * substr(model.applyId,instr(model.applyId,'-',-1,1)+1)=" + "(select
		 * max(substr(t.applyId,instr(t.applyId,'-',-1,1)+1)) from
		 * TbGovInfoPubContent t where t.infoSubject='"+parentid+"')";
		 */
		// List list = this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		String sql = "select max(substr(t.apply_Id,instr(t.apply_Id,'-',-1,1)+1))+1 from Tb_Gov_Info_Pub_Content t where t.lsh_type='"+lsh_type+"'";
		List list = this.tbInfoPubClaDAO.findBySql(sql);
		if (list.size()>0 && !list.isEmpty() && list != null) {
			// return ((TbGovInfoPubContent)list.get(0)).getApplyId();
			String applyId = list.get(0)!=null?list.get(0).toString():"1";
			int len = applyId.length();
			if (len == 1)
				return "00" + applyId;
			else if (len == 2)
				return "0" + applyId;
			else
				return applyId;
		} else {
			return "";
		}
	}

	public List findByTitle(String title) {
		String hql = "from TbInfoPubContent model where model.title='" + title
				+ "'";
		return this.tbInfoPubContentDAO.findByHQL(hql, true, -1, -1);
	}

	public List findByInfoSubjectlist(Object infoSubject) {

		String hql = "from TbInfoPubContent as model where model.infoSubject= '"
				+ infoSubject
				+ "' or model.attr1 like '%"
				+ infoSubject
				+ "%' order by model.publishTime desc";
		return this.tbInfoPubContentDAO.findByHQL(hql, true, 0, 6);
	}

	/**
	 * 判断用户是否为某个角色下的人员 2008-10-30
	 */
	public boolean isForRoleUser(TbUser user,String roleId) {
		//roleid='9f90838e18f45e8c0118f45f6f8e0001' --管理员
		String hql = "from TbUserRole ur where ur.userid='" + user.getId()
				+ "' and ur.roleid='"+roleId+"'";
		List list = this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		if (list != null && !list.isEmpty() && list.size() > 0)
			return true;
		else
			return false;
	}
	/**
	 * 科室动态(下边所有栏目)
	 * 职工考核(年度总结(下边所有栏目))
	 * 支部建设(下边所有栏目)
	 * 学习专栏(下边所有栏目)
	 * @param code
	 * @return
	 */
	public List getContentForLayout(String code,String flag){
		List result = new ArrayList();
		String hql = "";
		hql = "from TbInfoPubContent as model where model.infoSubject in (select t3.id from TbInfoPubCla as t1,TbInfoPubCla as t2,TbInfoPubCla as t3 where t1.code='infopub' and t2.parentid=t1.id and t2.code='"
				+ code + "' and t3.parentid=t2.id)";
		List list1 = this.tbInfoPubContentDAO.findByHQL(hql, true, -1, -1);
		Map map = new HashMap();
		if (list1 != null && list1.size() != 0) {
			for (Iterator it = list1.iterator(); it.hasNext();) {
				TbInfoPubContent mode = (TbInfoPubContent) it.next();
				map.put(mode.getId(), mode);
			}
		}
		// 取多栏目发布
		hql = "select t3 from TbInfoPubCla as t1,TbInfoPubCla as t2,TbInfoPubCla as t3 where t1.code='infopub' and t2.parentid=t1.id and t2.code='"
				+ code + "' and t3.parentid=t2.id";
		List list2 = this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		if (list2 != null && list2.size() != 0) {
			for (Iterator it = list2.iterator(); it.hasNext();) {
				TbInfoPubCla mode = (TbInfoPubCla) it.next();
				hql = "from TbInfoPubContent as model where model.attr1 like '%"
						+ mode.getId()
						+ "%' order by model.publishTime desc";
				List inner = this.tbInfoPubContentDAO.findByHQL(hql, true,
						-1, -1);
				for (Iterator itN = inner.iterator(); itN.hasNext();) {
					TbInfoPubContent instance = (TbInfoPubContent) itN
							.next();
					if (!map.containsKey(instance.getId())) {
						map.put(instance.getId(), instance);
					}
				}
			}
		}
		if (map != null) {
			if(flag.equals("true")){
				for (Iterator itMap = map.keySet().iterator(); itMap.hasNext();) {
					String key = (String) itMap.next();
					if (map.containsKey(key) && result.size() < 6) {
						result.add(map.get(key));
					}
				}
			}else{
				for (Iterator itMap = map.keySet().iterator(); itMap.hasNext();) {
					String key = (String) itMap.next();
					result.add(map.get(key));
				}
			}

		}	
		return result;
	}
	/**
	 * 党群工作(科室动态下的工会和团支部)
	 * @return
	 */
	public List getContentForDQGZLayout(){
		List result = new ArrayList();
		String hql = "";
		hql = "from TbInfoPubContent as model where model.infoSubject in (select t3.id from TbInfoPubCla as t1,TbInfoPubCla as t2,TbInfoPubCla as t3 where t1.code='govinfopub' and t2.parentid=t1.id and t2.code='DynamicSections' and t3.parentid=t2.id and (t3.code='Union' or t3.code='MissionBranch'))";
		List list1 = this.tbInfoPubContentDAO.findByHQL(hql, true, -1, -1);
		Map map = new HashMap();
		if (list1 != null && list1.size() != 0) {
			for (Iterator it = list1.iterator(); it.hasNext();) {
				TbInfoPubContent mode = (TbInfoPubContent) it.next();
				map.put(mode.getId(), mode);
			}
		}
		// 取多栏目发布
		hql = "select t3 from TbInfoPubCla as t1,TbInfoPubCla as t2,TbInfoPubCla as t3 where t1.code='govinfopub' and t2.parentid=t1.id and t2.code='DynamicSections' and t3.parentid=t2.id and (t3.code='Union' or t3.code='MissionBranch')";
		List list2 = this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		if (list2 != null && list2.size() != 0) {
			for (Iterator it = list2.iterator(); it.hasNext();) {
				TbInfoPubCla mode = (TbInfoPubCla) it.next();
				hql = "from TbInfoPubContent as model where model.attr1 like '%"
						+ mode.getId()
						+ "%' order by model.publishTime desc";
				List inner = this.tbInfoPubContentDAO.findByHQL(hql, true,
						-1, -1);
				for (Iterator itN = inner.iterator(); itN.hasNext();) {
					TbInfoPubContent instance = (TbInfoPubContent) itN
							.next();
					if (!map.containsKey(instance.getId())) {
						map.put(instance.getId(), instance);
					}
				}
			}
		}
		if (map != null) {
			for (Iterator itMap = map.keySet().iterator(); itMap.hasNext();) {
				String key = (String) itMap.next();
				if (map.containsKey(key) && result.size() < 6) {
					result.add(map.get(key));
				}
			}
		}	
		return result;
	}	
	/**
	 * 受理中心信息查看列表
	 * @param parentid
	 * @param infoname
	 * @return
	 */
	public List findSlzxInfoList(String parentid, String infoname) {
		List claIdList = this.getClaIdListByParentId(parentid);
		int size = claIdList.size();
		String hql = "";
		List slzxInfoList = new ArrayList();
		for (int i=0;i<size;i++) {
			parentid = claIdList.get(i).toString();
		    hql = "from TbInfoPubContent model where (model.sendTo!='2' and model.sendTo!='3') and model.title like '%"+infoname+"%' and " +
				"(model.infoSubject = '"+parentid+"' or model.attr1 like '%"+parentid+"%') order by model.recordTime desc";
		    List list = this.tbInfoPubClaDAO.findByHQL(hql, true, -1, -1);
		    if (list!=null && list.size()>0)
		    slzxInfoList.addAll(list);
		}
		return slzxInfoList;
		
	}
	public List getClaIdListByParentId(String parentid) {
		String sql = "select ipc.id from Tb_Info_Pub_Cla ipc start with id='"+parentid+"' connect by prior ipc.id=ipc.parentid";
		List claIdList = this.tbInfoPubClaDAO.findBySql(sql);
		return claIdList;
	}
	public List findAllGovInfo(){
		List list = tbGovInfoPubContentDAO.fingByHql("from TbGovInfoPubContent model where model.status=1  order by model.createTime desc");
		return list;
	}
}
