package com.baosight.mode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.baosight.base.dao.ITbAppsysDAO;
import com.baosight.base.dao.ITbAuthInfoDAO;
import com.baosight.base.dao.ITbDeptDAO;
import com.baosight.base.dao.ITbFunctionDAO;
import com.baosight.base.dao.ITbGroupAuthDAO;
import com.baosight.base.dao.ITbGroupDAO;
import com.baosight.base.dao.ITbGroupRoleDAO;
import com.baosight.base.dao.ITbLicencepolicyDAO;
import com.baosight.base.dao.ITbPstDAO;
import com.baosight.base.dao.ITbPstlvlDAO;
import com.baosight.base.dao.ITbRighttypeDAO;
import com.baosight.base.dao.ITbRoleAuthDAO;
import com.baosight.base.dao.ITbRoleDAO;
import com.baosight.base.dao.ITbUserAuthDAO;
import com.baosight.base.dao.ITbUserDAO;
import com.baosight.base.dao.ITbUserGroupDAO;
import com.baosight.base.dao.ITbUserRoleDAO;
import com.baosight.base.dao.ITbUserinfoDAO;
import com.baosight.base.dao.ITbUserlvlDAO;

public class SsoWebServiceImpl implements ISsoWebService {

	private ITbRoleAuthDAO tbRoleAuthDAO;

	private ITbGroupDAO tbGroupDAO;

	private ITbRighttypeDAO tbRighttypeDAO;

	private ITbUserAuthDAO tbUserAuthDAO;

	private ITbLicencepolicyDAO tbLicencepolicyDAO;

	private ITbUserGroupDAO tbUserGroupDAO;

	private ITbGroupRoleDAO tbGroupRoleDAO;

	private ITbAuthInfoDAO tbAuthInfoDAO;

	private ITbUserDAO tbUserDAO;

	private ITbUserRoleDAO tbUserRoleDAO;

	private ITbUserinfoDAO tbUserinfoDAO;

	private ITbFunctionDAO tbFunctionDAO;

	private ITbGroupAuthDAO tbGroupAuthDAO;

	private ITbDeptDAO tbDeptDAO;

	private ITbRoleDAO tbRoleDAO;

	private ITbPstlvlDAO tbPstlvlDAO;

	private ITbPstDAO tbPstDAO;

	private ITbUserlvlDAO tbUserlvlDAO;

	private ITbAppsysDAO tbAppsysDAO;
	
	public ITbAppsysDAO getTbAppsysDAO() {
		return tbAppsysDAO;
	}

	public void setTbAppsysDAO(ITbAppsysDAO tbAppsysDAO) {
		this.tbAppsysDAO = tbAppsysDAO;
	}

	public ITbAuthInfoDAO getTbAuthInfoDAO() {
		return tbAuthInfoDAO;
	}

	public void setTbAuthInfoDAO(ITbAuthInfoDAO tbAuthInfoDAO) {
		this.tbAuthInfoDAO = tbAuthInfoDAO;
	}

	public ITbDeptDAO getTbDeptDAO() {
		return tbDeptDAO;
	}

	public void setTbDeptDAO(ITbDeptDAO tbDeptDAO) {
		this.tbDeptDAO = tbDeptDAO;
	}

	public ITbFunctionDAO getTbFunctionDAO() {
		return tbFunctionDAO;
	}

	public void setTbFunctionDAO(ITbFunctionDAO tbFunctionDAO) {
		this.tbFunctionDAO = tbFunctionDAO;
	}

	public ITbGroupAuthDAO getTbGroupAuthDAO() {
		return tbGroupAuthDAO;
	}

	public void setTbGroupAuthDAO(ITbGroupAuthDAO tbGroupAuthDAO) {
		this.tbGroupAuthDAO = tbGroupAuthDAO;
	}

	public ITbGroupDAO getTbGroupDAO() {
		return tbGroupDAO;
	}

	public void setTbGroupDAO(ITbGroupDAO tbGroupDAO) {
		this.tbGroupDAO = tbGroupDAO;
	}

	public ITbGroupRoleDAO getTbGroupRoleDAO() {
		return tbGroupRoleDAO;
	}

	public void setTbGroupRoleDAO(ITbGroupRoleDAO tbGroupRoleDAO) {
		this.tbGroupRoleDAO = tbGroupRoleDAO;
	}

	public ITbLicencepolicyDAO getTbLicencepolicyDAO() {
		return tbLicencepolicyDAO;
	}

	public void setTbLicencepolicyDAO(ITbLicencepolicyDAO tbLicencepolicyDAO) {
		this.tbLicencepolicyDAO = tbLicencepolicyDAO;
	}

	public ITbPstDAO getTbPstDAO() {
		return tbPstDAO;
	}

	public void setTbPstDAO(ITbPstDAO tbPstDAO) {
		this.tbPstDAO = tbPstDAO;
	}

	public ITbPstlvlDAO getTbPstlvlDAO() {
		return tbPstlvlDAO;
	}

	public void setTbPstlvlDAO(ITbPstlvlDAO tbPstlvlDAO) {
		this.tbPstlvlDAO = tbPstlvlDAO;
	}

	public ITbRighttypeDAO getTbRighttypeDAO() {
		return tbRighttypeDAO;
	}

	public void setTbRighttypeDAO(ITbRighttypeDAO tbRighttypeDAO) {
		this.tbRighttypeDAO = tbRighttypeDAO;
	}

	public ITbRoleAuthDAO getTbRoleAuthDAO() {
		return tbRoleAuthDAO;
	}

	public void setTbRoleAuthDAO(ITbRoleAuthDAO tbRoleAuthDAO) {
		this.tbRoleAuthDAO = tbRoleAuthDAO;
	}

	public ITbRoleDAO getTbRoleDAO() {
		return tbRoleDAO;
	}

	public void setTbRoleDAO(ITbRoleDAO tbRoleDAO) {
		this.tbRoleDAO = tbRoleDAO;
	}

	public ITbUserAuthDAO getTbUserAuthDAO() {
		return tbUserAuthDAO;
	}

	public void setTbUserAuthDAO(ITbUserAuthDAO tbUserAuthDAO) {
		this.tbUserAuthDAO = tbUserAuthDAO;
	}

	public ITbUserDAO getTbUserDAO() {
		return tbUserDAO;
	}

	public void setTbUserDAO(ITbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}

	public ITbUserGroupDAO getTbUserGroupDAO() {
		return tbUserGroupDAO;
	}

	public void setTbUserGroupDAO(ITbUserGroupDAO tbUserGroupDAO) {
		this.tbUserGroupDAO = tbUserGroupDAO;
	}

	public ITbUserinfoDAO getTbUserinfoDAO() {
		return tbUserinfoDAO;
	}

	public void setTbUserinfoDAO(ITbUserinfoDAO tbUserinfoDAO) {
		this.tbUserinfoDAO = tbUserinfoDAO;
	}

	public ITbUserlvlDAO getTbUserlvlDAO() {
		return tbUserlvlDAO;
	}

	public void setTbUserlvlDAO(ITbUserlvlDAO tbUserlvlDAO) {
		this.tbUserlvlDAO = tbUserlvlDAO;
	}

	public ITbUserRoleDAO getTbUserRoleDAO() {
		return tbUserRoleDAO;
	}

	public void setTbUserRoleDAO(ITbUserRoleDAO tbUserRoleDAO) {
		this.tbUserRoleDAO = tbUserRoleDAO;
	}
	
	public UserInfo getUserInfo(String loginName,String uuid) {
		// TODO Auto-generated method stub
		if(loginName==null || loginName.equals("") ||uuid==null || uuid.equals("")){
			return null;
		}
		List usList = tbUserDAO.findByHQL("from TbUser model where model.userAcc='"+loginName+"'", true, -1, -1);
		UserInfo user = new UserInfo();
		if(usList.size()==0){
			return null;
		}else{
			List<TbRole> roleList = new ArrayList<TbRole>();
			List<TbFunction> funList = new ArrayList<TbFunction>();
			List<TbAuthInfo> authInfoList = new ArrayList<TbAuthInfo>();
			List<TbRighttype> rightTypeList = new ArrayList<TbRighttype>();
			List<TbRoleAuth> roleAuthList = new ArrayList<TbRoleAuth>();
			List<TbAppsys> appSysList = new ArrayList<TbAppsys>();
			List ruauList = new ArrayList();
			TbUser tbUser = (TbUser)usList.iterator().next();
			user.setUserName(tbUser.getName());
			user.setLoginName(loginName);
			/*
			 * 部门
			 */
			if(tbUser.getDeptCode()!=null){
				TbDept tbDept = tbDeptDAO.findById(tbUser.getDeptCode());
				if(tbDept!=null){
					TbDept parDept = tbDeptDAO.findById(tbDept.getParCode());
					//受理中心
					if(tbDept.getCode().equals("202")){
						user.setDeptName(tbDept.getName());	
						user.setDeptId(tbDept.getId());
					}else if(parDept.getCode().equals("202")){
						user.setDeptName(parDept.getName());	
						user.setDeptId(parDept.getId());
					}else{
						user.setDeptName(tbDept.getName());
						user.setDeptId(tbDept.getId());
					}			
				}	
			}
			/*
			 * 岗位
			 */
			if(tbUser.getPst()!=null){
				TbPst tbPst = tbPstDAO.findById(tbUser.getPst());
				if(tbPst!=null){
					user.setPostName(tbPst.getName());
					user.setPostId(tbPst.getId());
				}	
			}
			/*
			 * 用户角色列表
			 */
			List usroList = tbUserRoleDAO.findByProperty("userid", tbUser.getId());
			for(Iterator it = usroList.iterator();it.hasNext();){
				TbUserRole tbUserRole = (TbUserRole)it.next();
				TbRole tbRole = tbRoleDAO.findById(tbUserRole.getRoleid());
				if(tbRole!=null){
					roleList.add(tbRole);
				}
			}
			user.setRoleList(roleList);
			/*
			 * 用户所能访问资源列表
			 */
			for(Iterator it = roleList.iterator();it.hasNext();){
				TbRole tbRole = (TbRole)it.next();
				ruauList = tbRoleAuthDAO.findByProperty("roleid", tbRole.getId());
				for(Iterator itR = ruauList.iterator();itR.hasNext();){
					TbRoleAuth tbRoleAuth = (TbRoleAuth)itR.next();
					TbAuthInfo tbAuthInfo = tbAuthInfoDAO.findById(tbRoleAuth.getAuthid());
					roleAuthList.add(tbRoleAuth);
					if(tbAuthInfo!=null){
						String rightTypeid = tbAuthInfo.getRighttypeid();
						if(rightTypeid!=null && !rightTypeid.equals("")){
							String[] rightTypeidList = rightTypeid.split(",");
							int len = rightTypeidList.length;
							for(int i=0;i<len;i++){
								TbRighttype tbRighttype = tbRighttypeDAO.findById(rightTypeidList[i]);
								if(tbRighttype!=null){
									/*
									 * 操作权限类型
									 */
									boolean isExistForRT = false;
									for(Iterator itrt = rightTypeList.iterator();itrt.hasNext();){
										TbRighttype rtighttype = (TbRighttype)itrt.next();
										if(rtighttype.getId().equals(tbRighttype.getId())){
											isExistForRT = true;
											break;
										}
									}
									if(!isExistForRT){
										rightTypeList.add(tbRighttype);
										boolean isExistApp = false;
										Iterator ita = appSysList.iterator();
										while(ita.hasNext()){
											TbAppsys tbAppsys = (TbAppsys)ita.next();
											if(tbAppsys.getId().equals(tbAppsysDAO.findById(tbRighttype.getAppsysid()).getId())){
												isExistApp = true;
												break;
											}
										}
										if(isExistApp==false){
											appSysList.add(tbAppsysDAO.findById(tbRighttype.getAppsysid()));
										}
										
									}
									//finalRightTypeCode = finalRightTypeCode + tbRighttype.getCode().toString() + ",";
								}
							}
							/*if(finalRightTypeCode.length()!=0){
								finalRightTypeCode = finalRightTypeCode.substring(0, finalRightTypeCode.length()-1);
								
								 * 将权限代码存入tbAuthInfo对象的rightTypeid字段中
								 
								tbAuthInfo.setRighttypeid(finalRightTypeCode);
							}*/	
						}
						authInfoList.add(tbAuthInfo);
						TbFunction tbFunction = tbFunctionDAO.findById(tbAuthInfo.getFunid());
						/*
						 * 用户资源列表
						 */
						if(tbFunction!=null){
							boolean isExistForFun = false;
							for(Iterator itA = funList.iterator();itA.hasNext();){
								TbFunction fun = (TbFunction)itA.next();
								if(fun.getId().equals(tbFunction.getId())){
									isExistForFun = true;
									break;
								}
							}	
							if(!isExistForFun){
								funList.add(tbFunction);
							}
						}
					}
				}
			}
			user.setAppSysList(appSysList);
			user.setRoleAuthList(roleAuthList);
			user.setRightTypeList(rightTypeList);
			user.setFunList(funList);
			user.setAuthInfoList(authInfoList);
		}
		return user;
	}
	public User getUser(String UserId, String UserName, String UserLevel,
			String Department) {
		// TODO Auto-generated method stub
		String hql = "";
		if(UserId!=null && !UserId.equals("")){
			hql = "from TbUser model where model.id='"+UserId+"'";
		}
		List list = tbUserDAO.findByHQL(hql, true, -1, -1);
		if(list.size()==0){
			return null;
		}else{
			TbUser tbUser = (TbUser)list.get(0);
			User user = new User();
			user.setUserid(tbUser.getId());
			user.setName(tbUser.getName());
			user.setUseracc(tbUser.getUserAcc());
			user.setPwd(tbUser.getPwd());
			user.setLvl(tbUser.getLvl());
			user.setDept(tbUser.getDeptCode());
			user.setTel(tbUser.getTel());
			user.setPst(tbUser.getPst());
			return user;
		}
	}

	public Dept getDept(String DeptCode, String DeptName, String Superior, String DeptLevel) {
		// TODO Auto-generated method stub
		String hql = "";
		if(DeptCode!=null && !DeptCode.equals("")){
			hql = "from TbDept model where model.id='"+DeptCode+"'";
		}
		List list = tbDeptDAO.findByHQL(hql, true, -1, -1);
		if(list.size()==0){
			return null;
		}else{
			TbDept tbDept = (TbDept)list.get(0);
			Dept dept = new Dept();
			dept.setCode(dept.getCode());
			dept.setName(tbDept.getName());
			dept.setLvl(tbDept.getLvl());
			dept.setSuperior(tbDept.getParCode());
			dept.setTel(tbDept.getTel());
			dept.setCtc(tbDept.getCtc());
			dept.setRmk(tbDept.getRem());
			return dept;
		}
	}

	public List <User> getUserInfoByDept(String DeptCode, String DeptName) {
		// TODO Auto-generated method stub
		List <User>userInfoList = new ArrayList<User>();
		List list = new ArrayList();
		if(DeptCode!=null && !DeptCode.equals("")){
			list = tbUserDAO.findByDeptCode(DeptCode);
		}
		TbUser tbUser;
		User user;
		for(Iterator it = list.iterator();it.hasNext();){
			tbUser = (TbUser)it.next();
			user = new User();
			user.setUserid(tbUser.getId());
			user.setName(tbUser.getName());
			user.setUseracc(tbUser.getUserAcc());
			user.setPwd(tbUser.getPwd());
			user.setLvl(tbUser.getLvl());
			user.setDept(tbUser.getDeptCode());
			user.setTel(tbUser.getTel());
			user.setPst(tbUser.getPst());	
			userInfoList.add(user);
		}
		return userInfoList;
	}

	public List<UserGroup> getUserGroupByDept(String DeptCode, String DeptName) {
		//TODO Auto-generated method stub
		List <UserGroup> userGruopList = new ArrayList<UserGroup>();
		List list = new ArrayList();
		if(DeptCode!=null && !DeptCode.equals("")){
			list = tbPstDAO.findByDeptId(DeptCode);
		}
		TbPst tbPst;
		UserGroup userGruop;
		for(Iterator it = list.iterator();it.hasNext();){
			tbPst = (TbPst)it.next();
			userGruop = new UserGroup();
			userGruop.setCode(tbPst.getCode());
			userGruop.setName(tbPst.getName());
			userGruop.setLvl(tbPst.getLvl());
			userGruopList.add(userGruop);
		}
		return userGruopList;
	}

	public List<User> getUserInfoByGroup(String GroupCode) {
		// TODO Auto-generated method stub
		List <User>userInfoList = new ArrayList<User>();
		List list = new ArrayList();
		if(GroupCode!=null && !GroupCode.equals("")){
			list = tbUserDAO.findByPst(GroupCode);
		}
		TbUser tbUser;
		User user;
		for(Iterator it = list.iterator();it.hasNext();){
			tbUser = (TbUser)it.next();
			user = new User();
			user.setUserid(tbUser.getId());
			user.setName(tbUser.getName());
			user.setUseracc(tbUser.getUserAcc());
			user.setPwd(tbUser.getPwd());
			user.setLvl(tbUser.getLvl());
			user.setDept(tbUser.getDeptCode());
			user.setTel(tbUser.getTel());
			user.setPst(tbUser.getPst());	
			userInfoList.add(user);
		}
		return userInfoList;
	}
	
}