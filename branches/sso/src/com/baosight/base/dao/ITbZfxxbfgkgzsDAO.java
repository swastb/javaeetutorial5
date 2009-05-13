package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxbfgkgzs;

public interface ITbZfxxbfgkgzsDAO {

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

	public abstract void save(TbZfxxbfgkgzs transientInstance);

	public abstract void delete(TbZfxxbfgkgzs persistentInstance);

	public abstract TbZfxxbfgkgzs findById(java.lang.String id);

	public abstract List findByExample(TbZfxxbfgkgzs instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByInfoId(Object infoId);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findByAttr4(Object attr4);

	public abstract List findByAttr5(Object attr5);

	public abstract List findByAttr6(Object attr6);

	public abstract List findByAttr7(Object attr7);

	public abstract List findByAttr8(Object attr8);

	public abstract List findByAttr9(Object attr9);

	public abstract List findByAttr10(Object attr10);

	public abstract List findByAttr11(Object attr11);

	public abstract List findByAttr12(Object attr12);

	public abstract List findByAttr13(Object attr13);

	public abstract List findByAttr14(Object attr14);

	public abstract List findByAttr15(Object attr15);

	public abstract List findByAttr16(Object attr16);

	public abstract List findByAttr17(Object attr17);

	public abstract List findByAttr18(Object attr18);

	public abstract List findByAttr19(Object attr19);

	public abstract List findByAttr20(Object attr20);

	public abstract List findByAttr21(Object attr21);

	public abstract List findByAttr22(Object attr22);

	public abstract List findByAttr23(Object attr23);

	public abstract List findByAttr24(Object attr24);

	public abstract List findByAttr25(Object attr25);

	public abstract List findAll();

	public abstract TbZfxxbfgkgzs merge(TbZfxxbfgkgzs detachedInstance);

	public abstract void attachDirty(TbZfxxbfgkgzs instance);

	public abstract void attachClean(TbZfxxbfgkgzs instance);

	public abstract void update(TbZfxxbfgkgzs item);

}