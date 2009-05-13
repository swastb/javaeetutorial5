package com.baosight.base.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import oracle.sql.CLOB;

import org.apache.struts.validator.DynaValidatorForm;
import org.hibernate.lob.SerializableClob;

import com.baosight.base.dao.ITbZfxxgkdfOneDAO;
import com.baosight.base.dao.ITbZfxxgkdfTwoDAO;
import com.baosight.base.dao.ITbZfxxgksqSjhcDAO;
import com.baosight.base.service.IInfoPubClaMgr;
import com.baosight.base.service.IZfxxgkdfMgr;
import com.baosight.mode.TbGovInfoPubContent;
import com.baosight.mode.TbZfxxgkdfOne;
import com.baosight.mode.TbZfxxgkdfTwo;
import com.baosight.mode.TbZfxxgksqSjhc;

/**
 * Data access object (DAO) for domain model class TbZfxxgkdfOne.
 * 
 * @see com.baosight.mode.TbZfxxgkdfOne
 * @author MyEclipse Persistence Tools
 */

public class ZfxxgkdfMgrImpl implements IZfxxgkdfMgr {
	

	private ITbZfxxgkdfOneDAO tbZfxxgkdfOneDAO;
	private ITbZfxxgkdfTwoDAO tbZfxxgkdfTwoDAO;
	private ITbZfxxgksqSjhcDAO tbZfxxgksqSjhcDAO;
	/*zfxxgkdf one begin*/
	public void saveOne(TbZfxxgkdfOne model) {
		//TODO Auto-generated method stub
		this.tbZfxxgkdfOneDAO.save(model);
	}
	
	/*public void deleteOne(String id) {
		TbZfxxgkdfOne item = this.tbZfxxgkdfOneDAO.findById(id);
		this.tbZfxxgkdfOneDAO.delete(item);
	}*/

	public List findAllOne() {
		// TODO Auto-generated method stub
		return this.tbZfxxgkdfOneDAO.findAll();
	}
	public List findOneByAttr1(String attr1) {
		// TODO Auto-generated method stub
		return this.tbZfxxgkdfOneDAO.findByAttr1(attr1);
	}
	public TbZfxxgkdfOne findByIdOne(String id) {
		// TODO Auto-generated method stub
		return this.tbZfxxgkdfOneDAO.findById(id);
	}
	/*zfxxgkdf one end*/
	
	/*zfxxgkdf two begin*/
	public void saveTwo(TbZfxxgkdfTwo model) {
		//TODO Auto-generated method stub
		this.tbZfxxgkdfTwoDAO.save(model);
	}
	
	/*public void deleteTwo(String id) {
		TbZfxxgkdfTwo item = this.tbZfxxgkdfTwoDAO.findById(id);
		this.tbZfxxgkdfTwoDAO.delete(item);
	}
*/
	public List findAllTwo() {
		// TODO Auto-generated method stub
		return this.tbZfxxgkdfTwoDAO.findAll();
	}

	public List findByAttr1Two(String attr1) {
		// TODO Auto-generated method stub
		return this.tbZfxxgkdfTwoDAO.findByAttr1(attr1);
	}
	
	public TbZfxxgkdfTwo findByIdTwo(String id) {
		// TODO Auto-generated method stub
		return this.tbZfxxgkdfTwoDAO.findById(id);
	}
	/*zfxxgkdf two end*/
	
	/*zfxxgkdf sjhc begin*/
	public void saveSjhc(TbZfxxgksqSjhc model) {
		//TODO Auto-generated method stub
		this.tbZfxxgksqSjhcDAO.save(model);
	}
	
	/*public void deleteSjhc(String id) {
		TbZfxxgksqSjhc item = this.tbZfxxgkdfSjhcDAO.findById(id);
		this.tbZfxxgkdfSjhcDAO.delete(item);
	}*/

	public List findAllSjhc() {
		// TODO Auto-generated method stub
		return this.tbZfxxgksqSjhcDAO.findAll();
	}

	public TbZfxxgksqSjhc findByIdSjhc(String id) {
		// TODO Auto-generated method stub
		return this.tbZfxxgksqSjhcDAO.findById(id);
	}
	public List findByAttr1Sjhc(String attr1) {
		// TODO Auto-generated method stub
		return this.tbZfxxgksqSjhcDAO.findByAttr1(attr1);
	}
	public String queryContent(String docNum) throws SQLException, IOException{
		List list=this.tbZfxxgksqSjhcDAO.queryContent(docNum);
		String content = "";
		if(list.size()!=0 && null != ((TbGovInfoPubContent)list.get(0)).getContent()){
			SerializableClob  sc= (SerializableClob)((TbGovInfoPubContent)list.get(0)).getContent();
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB)wrapclob;
			
			Reader is;
			is = clob.getCharacterStream ();

		    BufferedReader br = new BufferedReader ( is );
		    String s = br.readLine ();
		    
		    while ( s != null )
		       {
		         content += s ;
		         s = br.readLine ();
		       }
		       br.close();
		       is.close();		       
		}   
		return content;
	}
	/*zfxxgkdf sjhc end*/

	public ITbZfxxgkdfOneDAO getTbZfxxgkdfOneDAO() {
		return tbZfxxgkdfOneDAO;
	}

	public void setTbZfxxgkdfOneDAO(ITbZfxxgkdfOneDAO tbZfxxgkdfOneDAO) {
		this.tbZfxxgkdfOneDAO = tbZfxxgkdfOneDAO;
	}

	public ITbZfxxgkdfTwoDAO getTbZfxxgkdfTwoDAO() {
		return tbZfxxgkdfTwoDAO;
	}

	public void setTbZfxxgkdfTwoDAO(ITbZfxxgkdfTwoDAO tbZfxxgkdfTwoDAO) {
		this.tbZfxxgkdfTwoDAO = tbZfxxgkdfTwoDAO;
	}

	public ITbZfxxgksqSjhcDAO getTbZfxxgksqSjhcDAO() {
		return tbZfxxgksqSjhcDAO;
	}

	public void setTbZfxxgksqSjhcDAO(ITbZfxxgksqSjhcDAO tbZfxxgksqSjhcDAO) {
		this.tbZfxxgksqSjhcDAO = tbZfxxgksqSjhcDAO;
	}
}