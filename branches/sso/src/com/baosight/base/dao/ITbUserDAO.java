package com.baosight.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Projection;

import com.baosight.mode.TbDept;
import com.baosight.mode.TbUser;

public interface ITbUserDAO {

	public abstract void save(TbUser transientInstance);

	public abstract void delete(TbUser persistentInstance);

	public abstract TbUser findById(java.lang.String id);

	public abstract List findByExample(TbUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findBySex(Object sex);

	public abstract List findByUserAcc(Object userAcc);

	public abstract List findByPwd(Object pwd);

	public abstract List findByDeptCode(Object deptCode);

	public abstract List findByLvl(Object lvl);

	public abstract List findByTel(Object tel);

	public abstract List findByPst(Object pst);

	public abstract List findByDefOrder(Object defOrder);
	
	public abstract List findByInsure(Object insure);
	
	public abstract List findByCA(Object ca);
	
	public abstract List findByCAPass(Object caPass);
	
	public abstract List findByUserDept(Object userDept);

	public abstract List findAll();

	public abstract TbUser merge(TbUser detachedInstance);

	public abstract void attachDirty(TbUser instance);

	public abstract void attachClean(TbUser instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
	
	public List find(HashMap hmcriteria, List condition, Projection[] projection, String order,
			String ranking, int start, int maxRs, boolean isShowAll,Class object);	

	public List findByNativeSql(String sql);

	public abstract void update(TbUser item);
	
	public List checkName(Object id,Object value,String field);
	/**
	 * 
	 * @param parentId
	 * @param defOrder
	 * @return
	 */
	public TbUser findByPDefOrder(String parentId,long defOrder,String type);
	/**
	 * 取deforder的最大值
	 * @param parentId
	 * @return
	 */
	public long findMaxDefOrder(String parentId);
	/**
	 * 找用户所在职位的部门ID
	 * @param parentId
	 * @return
	 */
	public String findDeptIdForUser(String parentId);
	/**
	 * 取部门或职务下的人员
	 * @param parentId
	 * @param type
	 * @return
	 */
	public abstract List findAllUser(String parentId,String type);
	/**
	 * 根据用户名查询用户
	 */
	public TbUser findUserByName(String name);
	
	public int insertSql(String Insert_SQL);
	
	public List getUserNameAndId(String deptCode);

	public abstract List findBySql(String sql,String id,Class entity);
}