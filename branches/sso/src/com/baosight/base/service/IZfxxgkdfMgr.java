package com.baosight.base.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.baosight.mode.TbZfxxgkdfOne;
import com.baosight.mode.TbZfxxgkdfTwo;
import com.baosight.mode.TbZfxxgksqSjhc;

/**
 * Data access object (DAO) for domain model class TbZfxxgkdfOne.
 * 
 * @see com.baosight.mode.TbZfxxgkdfOne
 * @author MyEclipse Persistence Tools
 */

public interface IZfxxgkdfMgr {
	/*zfxxgkdf one begin*/
	public void saveOne(TbZfxxgkdfOne transientInstance);

	//public void deleteOne(TbZfxxgkdfOne persistentInstance) ;

	public TbZfxxgkdfOne findByIdOne(java.lang.String id) ;
	
	public List findAllOne() ;
	
	public List findOneByAttr1(java.lang.String attr1);
	/*zfxxgkdf one end*/
	
	/*zfxxgkdf two begin*/
	public void saveTwo(TbZfxxgkdfTwo transientInstance);

	//public void deleteTwo(TbZfxxgkdfTwo persistentInstance) ;

	public TbZfxxgkdfTwo findByIdTwo(java.lang.String id) ;
	
	public List findAllTwo() ;
	
	public List findByAttr1Two(java.lang.String attr1) ;
	/*zfxxgkdf two end*/
	
	/*zfxxgkdf sjhc begin*/
	public void saveSjhc(TbZfxxgksqSjhc transientInstance);

	//public void deleteSjhc(TbZfxxgksqSjhc persistentInstance) ;

	public TbZfxxgksqSjhc findByIdSjhc(java.lang.String id) ;
	
	public List findAllSjhc() ;
	
	public List findByAttr1Sjhc(java.lang.String attr1);
	
	public String queryContent(String docNum) throws SQLException, IOException;
	/*zfxxgkdf sjhc end*/
	
}