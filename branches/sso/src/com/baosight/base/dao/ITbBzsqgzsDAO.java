package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbBzsqgzs;
import com.baosight.mode.TbZfxxbfgkgzs;

public interface ITbBzsqgzsDAO {
	// property constants
	public static final String INFO_ID = "infoId";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	public static final String ATTR4 = "attr4";

	public static final String ATTR5 = "attr5";

	public static final String ATTR6 = "attr6";

	public static final String ATTR7 = "attr7";

	public static final String ATTR8 = "attr8";

	public static final String ATTR9 = "attr9";

	public static final String ATTR10 = "attr10";

	public static final String ATTR11 = "attr11";

	public static final String ATTR12 = "attr12";

	public static final String ATTR13 = "attr13";

	public static final String ATTR14 = "attr14";

	public static final String ATTR15 = "attr15";

	public static final String ATTR16 = "attr16";

	public static final String ATTR17 = "attr17";

	public static final String ATTR18 = "attr18";

	public static final String ATTR19 = "attr19";

	public static final String ATTR20 = "attr20";

	public static final String ATTR21 = "attr21";

	public static final String ATTR22 = "attr22";

	public static final String ATTR23 = "attr23";

	public static final String ATTR24 = "attr24";

	public static final String ATTR25 = "attr25";
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#save(com.baosight.mode.TbBzsqgzs)
	 */
	public abstract void save(TbBzsqgzs transientInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#delete(com.baosight.mode.TbBzsqgzs)
	 */
	public abstract void delete(TbBzsqgzs persistentInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findById(java.lang.String)
	 */
	public abstract TbBzsqgzs findById(java.lang.String id);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByExample(com.baosight.mode.TbBzsqgzs)
	 */
	public abstract List findByExample(TbBzsqgzs instance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public abstract List findByProperty(String propertyName, Object value);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByInfoId(java.lang.Object)
	 */
	public abstract List findByInfoId(Object infoId);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr1(java.lang.Object)
	 */
	public abstract List findByAttr1(Object attr1);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr2(java.lang.Object)
	 */
	public abstract List findByAttr2(Object attr2);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr3(java.lang.Object)
	 */
	public abstract List findByAttr3(Object attr3);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr4(java.lang.Object)
	 */
	public abstract List findByAttr4(Object attr4);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr5(java.lang.Object)
	 */
	public abstract List findByAttr5(Object attr5);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr6(java.lang.Object)
	 */
	public abstract List findByAttr6(Object attr6);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr7(java.lang.Object)
	 */
	public abstract List findByAttr7(Object attr7);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr8(java.lang.Object)
	 */
	public abstract List findByAttr8(Object attr8);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr9(java.lang.Object)
	 */
	public abstract List findByAttr9(Object attr9);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr10(java.lang.Object)
	 */
	public abstract List findByAttr10(Object attr10);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr11(java.lang.Object)
	 */
	public abstract List findByAttr11(Object attr11);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr12(java.lang.Object)
	 */
	public abstract List findByAttr12(Object attr12);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr13(java.lang.Object)
	 */
	public abstract List findByAttr13(Object attr13);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr14(java.lang.Object)
	 */
	public abstract List findByAttr14(Object attr14);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr15(java.lang.Object)
	 */
	public abstract List findByAttr15(Object attr15);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr16(java.lang.Object)
	 */
	public abstract List findByAttr16(Object attr16);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr17(java.lang.Object)
	 */
	public abstract List findByAttr17(Object attr17);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr18(java.lang.Object)
	 */
	public abstract List findByAttr18(Object attr18);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr19(java.lang.Object)
	 */
	public abstract List findByAttr19(Object attr19);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr20(java.lang.Object)
	 */
	public abstract List findByAttr20(Object attr20);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr21(java.lang.Object)
	 */
	public abstract List findByAttr21(Object attr21);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr22(java.lang.Object)
	 */
	public abstract List findByAttr22(Object attr22);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr23(java.lang.Object)
	 */
	public abstract List findByAttr23(Object attr23);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr24(java.lang.Object)
	 */
	public abstract List findByAttr24(Object attr24);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr25(java.lang.Object)
	 */
	public abstract List findByAttr25(Object attr25);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findAll()
	 */
	public abstract List findAll();

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#merge(com.baosight.mode.TbBzsqgzs)
	 */
	public abstract TbBzsqgzs merge(TbBzsqgzs detachedInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#attachDirty(com.baosight.mode.TbBzsqgzs)
	 */
	public abstract void attachDirty(TbBzsqgzs instance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#attachClean(com.baosight.mode.TbBzsqgzs)
	 */
	public abstract void attachClean(TbBzsqgzs instance);
	public abstract void update(TbBzsqgzs item);
}