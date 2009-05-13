package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.dao.ITbAppsysDAO;
import com.baosight.base.dao.ITbAuthInfoDAO;
import com.baosight.base.dao.ITbFunctionDAO;
import com.baosight.base.dao.ITbRighttypeDAO;
import com.baosight.base.dao.ITbRoleAuthDAO;
import com.baosight.base.dao.ITbRoleDAO;
import com.baosight.base.dao.ITbUserDAO;
import com.baosight.base.dao.ITbUserRoleDAO;
import com.baosight.base.service.IFunctionMgr;
import com.baosight.mode.DBSY;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbAuthInfo;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbRighttype;
import com.baosight.mode.TbRole;
import com.baosight.mode.TbRoleAuth;
import com.baosight.mode.TbUser;

public class FunctionMgrImpl implements IFunctionMgr {
	private ITbFunctionDAO tbFunctionDAO;

	private ITbRighttypeDAO tbRighttypeDAO;

	private ITbRoleDAO tbRoleDAO;

	private ITbRoleAuthDAO tbRoleAuthDAO;

	private ITbAuthInfoDAO tbAuthInfoDAO;

	private ITbAppsysDAO tbAppsysDAO;

	private ITbUserDAO tbUserDAO;

	private ITbUserRoleDAO tbUserRoleDAO;

	public ITbUserDAO getTbUserDAO() {
		return tbUserDAO;
	}

	public void setTbUserDAO(ITbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}

	public ITbUserRoleDAO getTbUserRoleDAO() {
		return tbUserRoleDAO;
	}

	public void setTbUserRoleDAO(ITbUserRoleDAO tbUserRoleDAO) {
		this.tbUserRoleDAO = tbUserRoleDAO;
	}

	public ITbAppsysDAO getTbAppsysDAO() {
		return tbAppsysDAO;
	}

	public void setTbAppsysDAO(ITbAppsysDAO tbAppsysDAO) {
		this.tbAppsysDAO = tbAppsysDAO;
	}

	public ITbFunctionDAO getTbFunctionDAO() {
		return tbFunctionDAO;
	}

	public void setTbFunctionDAO(ITbFunctionDAO tbFunctionDAO) {
		this.tbFunctionDAO = tbFunctionDAO;
	}

	public ITbRighttypeDAO getTbRighttypeDAO() {
		return tbRighttypeDAO;
	}

	public void setTbRighttypeDAO(ITbRighttypeDAO tbRighttypeDAO) {
		this.tbRighttypeDAO = tbRighttypeDAO;
	}

	public ITbRoleDAO getTbRoleDAO() {
		return tbRoleDAO;
	}

	public void setTbRoleDAO(ITbRoleDAO tbRoleDAO) {
		this.tbRoleDAO = tbRoleDAO;
	}

	public ITbRoleAuthDAO getTbRoleAuthDAO() {
		return tbRoleAuthDAO;
	}

	public void setTbRoleAuthDAO(ITbRoleAuthDAO tbRoleAuthDAO) {
		this.tbRoleAuthDAO = tbRoleAuthDAO;
	}

	public ITbAuthInfoDAO getTbAuthInfoDAO() {
		return tbAuthInfoDAO;
	}

	public void setTbAuthInfoDAO(ITbAuthInfoDAO tbAuthInfoDAO) {
		this.tbAuthInfoDAO = tbAuthInfoDAO;
	}

	public void delete(TbFunction tbfunction) {
		// TODO Auto-generated method stub
		tbFunctionDAO.delete(tbfunction);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return tbFunctionDAO.findAll();
	}

	public TbFunction findById(String id) {
		// TODO Auto-generated method stub
		return tbFunctionDAO.findById(id);
	}

	public void save(TbFunction tbfunction) {
		// TODO Auto-generated method stub
		tbFunctionDAO.save(tbfunction);
	}

	public void update(TbFunction tbfunction) {
		// TODO Auto-generated method stub
		tbFunctionDAO.attachClean(tbfunction);
	}

	public void save(DynaValidatorForm form) {
		// TODO Auto-generated method stub
		TbFunction tbFunction = new TbFunction();
		String name = form.getString("name");
		String fun_key = form.getString("fun_key");
		String sys_key = form.getString("sys_key");
		String fid = form.getString("fid");
		String insure = form.getString("insure");

		TbFunction baseFun = tbFunctionDAO.findById(fid);
		tbFunction.setName(name.trim());
		tbFunction.setFunKey(fun_key.trim());
		tbFunction.setSysId(sys_key.trim());
		if (baseFun != null) {
			tbFunction.setParId(baseFun.getId());
		}
		tbFunction.setInuse(Long.valueOf(insure));
		tbFunctionDAO.save(tbFunction);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		TbFunction tbFunction = tbFunctionDAO.findById(id);
		if (tbFunction != null) {
			tbFunctionDAO.delete(tbFunction);
			this.tbFunctionDAO.setOthersDefordByNewdeford(tbFunction,tbFunction.getDefor(),tbFunction.getParId(),"delete");
		}
	}

	public void update(DynaValidatorForm form, String insure) {
		// TODO Auto-generated method stub
		String id = form.getString("id");
		String name = form.getString("name");
		String fun_key = form.getString("fun_key");
		String sys_key = form.getString("sys_key");
		String par_id = form.getString("par_id");
		String[] right_type = form.getStrings("right_type");
		String url = form.getString("url");
		String newDeforder=form.getString("newDeforder");
		//2008-10-13 添加图标名　程俊峰
		String imageName = form.getString("imageName");
		String righttypeid = new String();

		TbFunction tbFunction = tbFunctionDAO.findById(id);
		String deforder="";
		if (tbFunction != null) {
			deforder=tbFunction.getDefor();
			tbFunction.setName(name.trim());
			tbFunction.setFunKey(fun_key.trim());
			tbFunction.setSysId(sys_key.trim());
			tbFunction.setParId(par_id);
			tbFunction.setInuse(Long.valueOf(insure));
			tbFunction.setUrl(url);
			tbFunction.setImageName(imageName);
			//tbFunction.setDefor(newDeforder);

			int rTypeLen = right_type.length;
			for (int i = 0; i < rTypeLen; i++) {
				righttypeid = righttypeid + right_type[i] + ",";
			}
			if (righttypeid.length() != 0) {
				righttypeid = righttypeid
						.substring(0, righttypeid.length() - 1);
				tbFunction.setRighttypeid(righttypeid);
				List ruleTypeList = tbRighttypeDAO.findByProperty("code", 0);
				if (ruleTypeList.size() == 1) {
					TbRighttype tbRighttype = (TbRighttype) ruleTypeList.get(0);
					tbFunction.setRighttypeid(tbFunction.getRighttypeid() + ","
							+ tbRighttype.getId());
				}
			} else {
				List ruleTypeList = tbRighttypeDAO.findByProperty("code", 0);
				if (ruleTypeList.size() == 1) {
					TbRighttype tbRighttype = (TbRighttype) ruleTypeList.get(0);
					tbFunction.setRighttypeid(tbRighttype.getId());
				}
			}
			this.tbFunctionDAO.setOthersDefordByNewdeford(tbFunction,newDeforder+","+deforder,form.getString("par_id"),"update");
			//tbFunctionDAO.attachDirty(tbFunction);
		}
	}

	public List findAllForTree(String fid) {
		// TODO Auto-generated method stub
		List funList = new ArrayList();
		String hql = "";
		if (fid != null) {
			if (fid.equals("0")) {
				hql = "from TbFunction model where model.parId is null";
				funList = tbFunctionDAO.findByHQL(hql, true, -1, -1);
			} else {
				TbFunction tbFunction = tbFunctionDAO.findById(fid);
				if (tbFunction != null) {
					hql = "from TbFunction model where model.parId='"
							+ tbFunction.getId() + "' order by model.name";
					funList = tbFunctionDAO.findByHQL(hql, true, -1, -1);
				}
			}
		}
		return funList;
	}

	public List findAllForTreeInsure(String fid) {
		// TODO Auto-generated method stub
		List funList = new ArrayList();
		String hql = "";
		if (fid != null) {
			if (fid.equals("0")) {
				// hql="select {tbFunction.*} from tb_function tbFunction start
				// with tbFunction.id in ( select t.id from tb_function t where
				// t.par_id is null) connect by prior
				// {tbFunction}.id={tbFunction}.par_id";
				// funList=tbFunctionDAO.findByNativeSql(hql);
				hql = "from TbFunction model where model.parId is null";
				funList = tbFunctionDAO.findByHQL(hql, true, -1, -1);
			} else {

				// hql="select {tbFunction.*} from tb_function tbFunction start
				// with tbFunction.id in ('"+ fid +"') connect by prior
				// tbFunction.id=tbFunction.par_id";
				// funList=tbFunctionDAO.findByNativeSql(hql);
				TbFunction tbFunction = tbFunctionDAO.findById(fid);
				if (tbFunction != null) {
					hql = "from TbFunction model where model.parId='"
							+ tbFunction.getId()
							+ "' and model.inuse=1 order by model.name";
					funList = tbFunctionDAO.findByHQL(hql, true, -1, -1);
				}
			}
		}
		System.out
				.println(funList.size()
						+ "???????????????????????????????????????????????????????????????????");
		return funList;
	}

	public void save(DynaValidatorForm form, String root) {
		// TODO Auto-generated method stub
		String name = form.getString("name");
		String fun_key = form.getString("fun_key");
		String sys_key = form.getString("sys_key");
		String insure = form.getString("insure");
		String[] right_type = form.getStrings("right_type");
		String url = form.getString("url");
		String newDeforder=form.getString("newDeforder");
		//2008-10-13 添加图标名　程俊峰
		String imageName = form.getString("imageName");
		String righttypeid = new String();

		TbFunction tbFunction = new TbFunction();
		tbFunction.setName(name.trim());
		tbFunction.setFunKey(fun_key.trim());
		tbFunction.setSysId(sys_key.trim());
		tbFunction.setInuse(Long.valueOf(insure));
		tbFunction.setUrl(url);
		tbFunction.setDefor(newDeforder);
		tbFunction.setImageName(imageName);

		int rTypeLen = right_type.length;
		for (int i = 0; i < rTypeLen; i++) {
			righttypeid = righttypeid + right_type[i] + ",";
		}
		if (righttypeid.length() != 0) {
			righttypeid = righttypeid.substring(0, righttypeid.length() - 1);
			tbFunction.setRighttypeid(righttypeid);

			List ruleTypeList = tbRighttypeDAO.findByProperty("code", 0);
			if (ruleTypeList.size() == 1) {
				TbRighttype tbRighttype = (TbRighttype) ruleTypeList.get(0);
				tbFunction.setRighttypeid(tbFunction.getRighttypeid() + ","
						+ tbRighttype.getId());
			}
		} else {
			List ruleTypeList = tbRighttypeDAO.findByProperty("code", 0);
			if (ruleTypeList.size() == 1) {
				TbRighttype tbRighttype = (TbRighttype) ruleTypeList.get(0);
				tbFunction.setRighttypeid(tbRighttype.getId());
			}
		}

		if (root != null && root != "") {
			// 添加除根结点以外的其它结点
			if (root.equals("false")) {
				String fid = form.getString("fid");
				TbFunction baseFun = tbFunctionDAO.findById(fid);
				if (baseFun != null) {
					tbFunction.setParId(baseFun.getId());
				}
			}
		}
		this.tbFunctionDAO.setOthersDefordByNewdeford(tbFunction,newDeforder,form.getString("fid"),"save");
		//tbFunctionDAO.save(tbFunction);
	}

	public List findAllRightType() {
		// TODO Auto-generated method stub
		List list = tbRighttypeDAO.findByHQL("from TbRighttype model order",
				true, -1, -1);
		List result = new ArrayList();
		TbRighttype tbRighttype;
		for (Iterator it = list.iterator(); it.hasNext();) {
			tbRighttype = (TbRighttype) it.next();
			if (tbRighttype != null) {
				if (tbRighttype.getCode() != 0) {
					result.add(tbRighttype);
				}
			}
		}
		return result;
	}

	public List findRightTypeByFunction(TbFunction tbfunction) {
		// TODO Auto-generated method stub
		List rightTypeList = new ArrayList();
		String righttypeid = tbfunction.getRighttypeid();
		if (righttypeid != null && !righttypeid.equals("")) {
			String[] rTypeId = righttypeid.split(",");
			int chkLen = rTypeId.length;
			for (int i = 0; i < chkLen; i++) {
				TbRighttype tbRighttype = tbRighttypeDAO.findById(rTypeId[i]);
				if (tbRighttype != null && tbRighttype.getCode() != 0) {
					rightTypeList.add(tbRighttype);
				}
			}
		}
		return rightTypeList;
	}

	public List findAllRole() {
		// TODO Auto-generated method stub
		return tbRoleDAO.findByHQL("from TbRole model order by model.name",
				true, -1, -1);
	}

	public Map findFunByRid(String rid) {
		// TODO Auto-generated method stub
		Map result = new HashMap();
		List roleAuthList = tbRoleAuthDAO.findByHQL(
				"from TbRoleAuth model where model.roleid='" + rid + "'", true,
				-1, -1);
		List authInfoList = new ArrayList();
		Iterator itR = roleAuthList.iterator();
		Iterator itA = null;
		TbRoleAuth tbRoleAuth;
		TbFunction tbFunction;
		TbAuthInfo tbAuthInfo;
		while (itR.hasNext()) {
			tbRoleAuth = (TbRoleAuth) itR.next();
			if (tbRoleAuth != null) {
				authInfoList = tbAuthInfoDAO.findByHQL(
						"from TbAuthInfo model where model.id='"
								+ tbRoleAuth.getAuthid() + "'", true, -1, -1);
				itA = authInfoList.iterator();
				while (itA.hasNext()) {
					tbAuthInfo = (TbAuthInfo) itA.next();
					if (tbAuthInfo != null) {
						tbFunction = tbFunctionDAO.findById(tbAuthInfo
								.getFunid());
						if (tbFunction != null) {
							result.put(tbFunction.getId(), tbFunction);
						}
					}
				}
			}
		}
		return result;
	}

	public List findFunForRole() {
		// TODO Auto-generated method stub
		return tbFunctionDAO
				.findByHQL("from TbFunction model where model.parId is null",
						true, -1, -1);
	}

	public void toAuth(String rid, String[] funList, String[] isDefList) {
		// TODO Auto-generated method stub
		/**
		 * 1
		 */
		TbRole tbRole = tbRoleDAO.findById(rid);
		List ruleTypeList = new ArrayList();
		TbRighttype tbRighttype = new TbRighttype();
		if (tbRole != null) {
			if (funList != null) {
				int funLen = funList.length;
				Map fidOrgList = new HashMap();
				Map fidNewList = new HashMap();
				List authInfoList = new ArrayList();
				TbRoleAuth tbRoleAuth;
				TbAuthInfo tbAuthInfo;

				for (int i = 0; i < funLen; i++) {
					String f[] = funList[i].split(":");
					List roleAuthList = tbRoleAuthDAO.findByHQL(
							"select model.id from TbRoleAuth model ,TbAuthInfo au where model.roleid='"
									+ rid
									+ "' and model.authid=au.id and au.funid='"
									+ f[0] + "'", true, -1, -1);
					if (roleAuthList.size() == 0) {
						fidNewList.put(f[0], isDefList[i]);
					} else if (roleAuthList.size() != 0) {
						String pair = (String) roleAuthList.get(0);
						String raId = pair;
						tbRoleAuth = (TbRoleAuth) tbRoleAuthDAO.findById(raId);
						if (f[1] != null && !f[1].equals("")
								&& f[1].equals("true")) {
							if (tbRoleAuth != null) {
								tbAuthInfo = tbAuthInfoDAO.findById(tbRoleAuth
										.getAuthid());
								String type = isDefList[i];
								if (type.equals("2")) {
									// 除去所有权限
									if (tbAuthInfo != null) {
										tbAuthInfo.setRighttypeid(null);
										authInfoList.add(tbAuthInfo);
									}
								} else if (type.equals("1")) {
									// 默认情况下
								} else {
									// 选择权限
									if (tbAuthInfo != null) {
										tbAuthInfo.setRighttypeid(type);
										authInfoList.add(tbAuthInfo);
									}
								}
							}
						}
						if (f[1] != null && !f[1].equals("")
								&& f[1].equals("false")) {
							fidOrgList.put(tbRoleAuth.getId(), tbRoleAuth);
						}
					}
				}
				// 更新
				for (Iterator it = authInfoList.iterator(); it.hasNext();) {
					tbAuthInfo = (TbAuthInfo) it.next();
					if (tbAuthInfo != null) {
						tbAuthInfoDAO.attachDirty(tbAuthInfo);
					}
				}
				List newAuth = new ArrayList();
				for (Iterator it = fidNewList.keySet().iterator(); it.hasNext();) {
					String key = (String) it.next();
					String type = (String) fidNewList.get(key);
					if (type != null && !type.equals("") && !type.equals("1")) {
						TbAuthInfo au = new TbAuthInfo();
						TbFunction fun = (TbFunction) tbFunctionDAO
								.findById(key);
						if (fun != null) {
							au.setFunid(key);
							au.setName(fun.getName());
							au.setRighttypeid(type);
							newAuth.add(au);
						}
					}
				}
				System.out.println("aaaaaaaa");
				List list = new ArrayList();
				// 分别保存
				for (Iterator it = newAuth.iterator(); it.hasNext();) {
					tbAuthInfo = (TbAuthInfo) it.next();
					if (tbAuthInfo != null) {
						tbAuthInfoDAO.save(tbAuthInfo);
						list.add(tbAuthInfo);
					}
				}
				TbRoleAuth ra;
				TbAuthInfo au;
				for (Iterator it = list.iterator(); it.hasNext();) {
					au = (TbAuthInfo) it.next();
					if (au != null) {
						ra = new TbRoleAuth();
						ra.setRoleid(tbRole.getId());
						ra.setAuthid(au.getId());
						tbRoleAuthDAO.save(ra);
					}
				}
				// 删除
				for (Iterator it = fidOrgList.keySet().iterator(); it.hasNext();) {
					String key = (String) it.next();
					TbRoleAuth value = (TbRoleAuth) fidOrgList.get(key);
					if (value != null && value.getAuthid() != null) {
						List infoList = tbAuthInfoDAO.findByProperty("id",
								value.getAuthid());
						for (Iterator i = infoList.iterator(); i.hasNext();) {
							TbAuthInfo info = (TbAuthInfo) i.next();
							tbRoleAuthDAO.delete(value);
							tbAuthInfoDAO.delete(info);
						}
					}
				}
			}
		}
	}

	public boolean isChecked(TbFunction tbFunction, String rid) {
		// TODO Auto-generated method stub
		boolean result = false;
		TbFunction t;

		String funid = tbFunction.getId();
		String parid = tbFunction.getParId();

		String hql = "";
		// System.out.println(funid+"?????????????????????????"+rid);

		if (parid == null || parid.equals("")) {
			hql = "select fun.id from tb_role_auth t ,tb_auth_info info ,tb_function fun where t.roleid='"
					+ rid
					+ "' and t.authid=info.id and info.funid =  fun.id and fun.id in (select tbFunction.id from tb_function tbFunction start with tbFunction.id in ( select tf.id from tb_function tf where tf.id='"+funid+"') connect by prior tbFunction.id=tbFunction.par_id)";
		} else {
			hql = "select fun.id from tb_role_auth t ,tb_auth_info info ,tb_function fun where t.roleid='"
					+ rid
					+ "' and t.authid=info.id and info.funid =  fun.id and fun.id in (select tbFunction.id from tb_function tbFunction start with tbFunction.id ='"
					+ funid
					+ "' connect by prior tbFunction.id=tbFunction.par_id)";
		}

		List objList = tbFunctionDAO.findByNativeSql(hql);

		if (objList.size() > 0) {
			result = true;
		} else {
			result = false;
		}

		// Iterator it = objList.iterator();

		// // 此处tbFunction 为受理中心OA
		// // String hql="select {tbFunction.*} from tb_function tbFunction
		// start with tbFunction.id in ('"+ tbFunction.getId() +"') connect by
		// prior tbFunction.id=tbFunction.par_id";
		// // List list=tbFunctionDAO.findByNativeSql(hql);
		// List list = tbFunctionDAO.findByHQL(
		// "from TbFunction model where model.parId='"
		// + tbFunction.getId() + "'", true, -1, -1);
		// // list 为菜单\普通资源\信息发布栏目
		// result = toAuth(rid, tbFunction.getId());
		// if (result) {
		// return result;
		// }
		// if (list.size() == 0) {
		// result = toAuth(rid, tbFunction.getId());
		// if (result) {
		// return result;
		// }
		// } else {
		// if (result) {
		// return result;
		// }
		// Iterator it = list.iterator();
		// while (it.hasNext()) {
		// t = (TbFunction) it.next();
		// result = toAuth(rid, t.getId());
		// if (result) {
		// return result;
		// }
		// result = isChecked(t, rid);
		// }
		// }
		return result;
	}

	public boolean toAuth(String rid, String fid) {
		boolean result = false;
		List roleAuthList = tbRoleAuthDAO.findByHQL(
				"from TbRoleAuth model where model.roleid='" + rid + "'", true,
				-1, -1);
		TbRoleAuth tbRoleAuth;
		TbAuthInfo tbAuthInfo;
		List authList = new ArrayList();
		Iterator it = roleAuthList.iterator();
		while (it.hasNext()) {
			tbRoleAuth = (TbRoleAuth) it.next();
			// tbRoleAuth.getAuthid() 对应于tb_auth_info中的Id
			// fid 对应于 tb_auth_info 中的funid
			// tb_auth_info能查询到id 为 tbRoleAuth.getAuthid() ,funid 为 fid
			// 的纪录则选定该name
			authList = tbAuthInfoDAO.findByHQL(
					"from TbAuthInfo model where model.id='"
							+ tbRoleAuth.getAuthid() + "' and model.funid='"
							+ fid + "'", true, -1, -1);

			if (authList.size() > 0) {
				result = true;
				return result;
			}

			// authList = tbAuthInfoDAO.findByHQL(
			// "from TbAuthInfo model where model.id='"
			// + tbRoleAuth.getAuthid() + "'", true, -1, -1);
			// Iterator itA = authList.iterator();
			// while (itA.hasNext()) {
			// tbAuthInfo = (TbAuthInfo) itA.next();
			// if (tbAuthInfo.getFunid().equals(fid)) {
			// result = true;
			// return result;
			// }
			// }
		}
		return result;
	}

	public List findAllAppSys() {
		// TODO Auto-generated method stub
		return tbAppsysDAO.findByHQL(
				"from TbAppsys model where model.ischild=1 and model.insure=1",
				true, -1, -1);
	}

	public List findFunBySysId(String sysId) {
		return tbFunctionDAO.findByHQL(
				"from TbFunction model where model.sysId='" + sysId
						+ "' and model.inuse=1", true, -1, -1);
	}

	public List findRightTypeByRidAndFid(String fid, String rid) {
		// TODO Auto-generated method stub
		List roAuList = tbRoleAuthDAO.findByProperty("roleid", rid);
		List result = new ArrayList();
		for (Iterator it = roAuList.iterator(); it.hasNext();) {
			TbRoleAuth tbRoleAuth = (TbRoleAuth) it.next();
			TbAuthInfo tbAuthInfo = tbAuthInfoDAO.findById(tbRoleAuth
					.getAuthid());
			if (tbAuthInfo != null) {
				if (tbAuthInfo.getFunid().equals(fid)) {
					if (tbAuthInfo.getRighttypeid() != null) {
						String[] rt = tbAuthInfo.getRighttypeid().split(",");
						for (int i = 0; i < rt.length; i++) {
							TbRighttype tbRighttype = tbRighttypeDAO
									.findById(rt[i]);
							if (tbRighttype != null) {
								result.add(tbRighttype);
							}
						}
					}
					break;
				}
			}
		}
		return result;
	}

	public String checkName(String id, String name, String fid, String field) {
		List list = tbFunctionDAO.checkName(id, name, fid, field);
		String checkMessage = "true";
		if (list.size() > 0) {
			checkMessage = "false";
		}
		return checkMessage;
	}
	/*cheng begin*/
	/*根据父ID取新加资源顺位的默认值*/
	public int getDeforderByParId(String parid){
		return tbFunctionDAO.findByParId(parid).size();
	}
	/*找统一门户第一层资源*/
	public List findFirstLevelRes(TbUser user){
		return this.tbFunctionDAO.findFirstLevelRes(user);
	}
	/*找统一门户第二层资源*/
	public List findSecondLevelRes(TbUser user,TbFunction tbFunction){
		return this.tbFunctionDAO.findSecondLevelRes(user,tbFunction);
	}
	/*个性化设置－取已经设置的资源*/
	public List findAllSetByUser(TbUser user){
		return this.tbFunctionDAO.findAllSetByUser(user);
	}
	/*个性化设置－取所有的资源*/
	public List findAllRes(TbUser user){
		return this.tbFunctionDAO.findAllRes(user);
	}
	/*保存资源设置*/
	public List saveResSet(TbUser user,String[] resIds,String sysId){
		return this.tbFunctionDAO.saveResSet(user,resIds,sysId);
	}
	/*取当前登陆用户所拥有的对信息栏目操作的角色*/
	public List findInfoRolesUserList(TbUser user) {
		String hql = "from TbRole role where exists " +
				"(select roleauth.id from TbRoleAuth roleauth,TbAuthInfo authinfo,TbFunction function " +
				"where role.id= roleauth.roleid and roleauth.authid=authinfo.id " +
				"and authinfo.funid=function.id and function.funKey like '%Information Publishing%') and role.id in " +
				"(select userrole.roleid from TbUserRole userrole where userrole.userid='"+user.getId()+"')";
		return this.tbFunctionDAO.findByHQL(hql, true, -1, -1);
	}
	/*cheng end*/
	/**
	 * 获取待办事宜权限
	 * @param userId
	 * @param funKey
	 * @return DBSY
	 * @author lqs 2008-09-26
	 */
	public DBSY getDBSYAuthInfo(String userId, String funKey) {
		String selectFiled = "select new com.baosight.mode.DBSY(t1.id,t1.name,t1.userAcc,t2.id,t2.name,t2.code,t2.insure,t6.id,t6.funKey,t6.name,t6.url,t6.sysId,t6.parId,t6.inuse,t6.righttypeid)";
		String hql = selectFiled
				+ "from TbUser t1, TbRole t2,TbUserRole t3,TbRoleAuth t4,TbAuthInfo t5,TbFunction t6 "
				+ "where t1.id='"
				+ userId
				+ "' and t6.funKey='"
				+ funKey
				+ "' and t1.id=t3.userid and t3.roleid=t2.id and t2.insure='1' and t2.id=t4.roleid and t4.authid=t5.id and t5.funid=t6.id and t6.inuse='1'";
		//System.out.println(hql);
		List list = this.tbFunctionDAO.findByHQL(hql, true, -1, -1);
		if(list.size()>0){
			return (DBSY)list.get(0);
		}else{
			return null;
		}
	}
	public String getPersonalInfo(TbUser user){
		String sql = "";
		String attr = "";
		String flag = "";
		List list;
		sql = "select t2.attr1 from tb_user t1,tb_userdept t2 where t1.id='"+user.getId()+"' and t1.userdept=t2.id";
		list = this.tbFunctionDAO.findByNativeSql(sql);
		if(list!=null && list.size()!=0){
			attr = (String)list.get(0);
			/**
			 * 100:信息中心OA，局OA
			 * 200:受理中心OA，局OA
			 * 400:信息中心OA，受理中心OA，局OA(不显示)待办事宜，公示，通知通告
			 * 500:防汛专栏
			 * 600:水资源专栏
			 * 700:水资源专栏
			 * 000:信息中心OA，受理中心OA，局OA(显示)
			 */
			if(attr!=null && attr.equals("1")){
				//局OA
				flag = "'100','200','500','600','700'";
			}
			if(attr!=null && attr.equals("2")){
				//受理中心OA
				flag = "'200','300','500','600','700'";
			}
			if(attr!=null && attr.equals("3")){
				//信息中心OA
				flag = "'100','500','600','700'";
			}			
		}
		sql = "select t3.* from tb_user t1,tb_userdept t2,tb_ajax_portlet t3 where t1.id='"+user.getId()+"' and t1.userdept=t2.id and (t2.attr1 = t3.belong or t3.belong='000' or t3.belong in("+flag+"))";
		return sql;
	}	
}
