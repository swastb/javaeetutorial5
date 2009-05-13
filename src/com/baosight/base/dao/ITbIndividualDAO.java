package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbIndividual;

public interface ITbIndividualDAO extends DAOHelper{

	// property constants
	public static final String INDIVIDUAL_ID = "individualId";

	public static final String NAME = "name";

	public static final String DUTY = "duty";

	public static final String DEPARTMENT = "department";

	public static final String FAX = "fax";

	public static final String POST = "post";

	public static final String ADDRESS = "address";

	public static final String PARTMENT_PHONE = "partmentPhone";

	public static final String MOVE_PHONE = "movePhone";

	public static final String HOME_PHONE = "homePhone";

	public static final String EMAIL = "email";

	public static final String QQ = "qq";

	public static final String MSN = "msn";

	public static final String REMARK = "remark";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public abstract void save(TbIndividual transientInstance);

	public abstract void delete(TbIndividual persistentInstance);

	public abstract TbIndividual findById(java.lang.String id);

	public abstract List findByExample(TbIndividual instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByIndividualId(Object individualId);

	public abstract List findByName(Object name);

	public abstract List findByDuty(Object duty);

	public abstract List findByDepartment(Object department);

	public abstract List findByFax(Object fax);

	public abstract List findByPost(Object post);

	public abstract List findByAddress(Object address);

	public abstract List findByPartmentPhone(Object partmentPhone);

	public abstract List findByMovePhone(Object movePhone);

	public abstract List findByHomePhone(Object homePhone);

	public abstract List findByEmail(Object email);

	public abstract List findByQq(Object qq);

	public abstract List findByMsn(Object msn);

	public abstract List findByRemark(Object remark);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findAll();

	public abstract TbIndividual merge(TbIndividual detachedInstance);

	public abstract void update(TbIndividual transientInstance);

	public abstract void attachDirty(TbIndividual instance);

	public abstract void attachClean(TbIndividual instance);
	
	public abstract List findByNativeSql(String sql);
	
	public abstract List findindividualid(String individualid);
	
	public List findByNameAndPhone(String individualId);

}