package com.baosight.tech.dao;

import java.util.List;

import com.baosight.base.dao.DAOHelper;
import com.baosight.tech.mode.TbTechDiscoure;

public interface ITbTechDiscoureDAO extends DAOHelper {

	public abstract void save(TbTechDiscoure transientInstance);

	public abstract void delete(TbTechDiscoure persistentInstance);

	public abstract TbTechDiscoure findById(java.lang.String id);

	public abstract List findByExample(TbTechDiscoure instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPianming(Object pianming);

	public abstract List findByZuozhe1(Object zuozhe1);

	public abstract List findByZuozhe2(Object zuozhe2);

	public abstract List findByZuozhe3(Object zuozhe3);

	public abstract List findByDanwei(Object danwei);

	public abstract List findByKanming(Object kanming);

	public abstract List findByQihao(Object qihao);

	public abstract List findByGuanjianci(Object guanjianci);

	public abstract List findByZhaiyao(Object zhaiyao);

	public abstract List findByZhengwen(Object zhengwen);

	public abstract List findByA1(Object a1);

	public abstract List findByA2(Object a2);

	public abstract List findByA3(Object a3);

	public abstract List findByA4(Object a4);

	public abstract List findByA5(Object a5);

	public abstract List findAll();

	public abstract TbTechDiscoure merge(TbTechDiscoure detachedInstance);

	public abstract void attachDirty(TbTechDiscoure instance);

	public abstract void attachClean(TbTechDiscoure instance);

}