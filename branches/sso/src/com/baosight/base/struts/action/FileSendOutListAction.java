package com.baosight.base.struts.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.CLOB;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.lob.SerializableClob;

import com.baosight.base.dao.impl.TbUserDAOImpl;
import com.baosight.base.service.ITbFilesendMgr;
import com.baosight.base.service.impl.TbFilesendMgrImpl;
import com.baosight.mode.TbFilesend;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class FileSendOutListAction extends BaseDispatchAction {
	public ITbFilesendMgr tbFilesendMgr;
	public TbUserDAOImpl tbUserDAO;

	public void setTbFilesendMgr(ITbFilesendMgr tbFilesendMgr) {
		this.tbFilesendMgr = tbFilesendMgr;
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)  throws java.text.ParseException, SQLException, IOException{	
		List fileSendOutList=null;	
		TbUser user = (TbUser) request.getSession().getAttribute(
				"SYSTEM_USER_SESSION");
		String userId = user.getId();
		fileSendOutList=this.tbFilesendMgr.findByProperty("senderId",userId);
		List newfileSendOutList=new ArrayList();
		if(fileSendOutList!=null)
		{
			for(int i=0;i<fileSendOutList.size();i++)
			{				
				TbFilesend item = (TbFilesend)fileSendOutList.get(i);
				String receiverName = getUserNamebyId(getStringFromClob(item.getReceiverId()));
				item.setContent(receiverName);
			}
			TbFilesend fileSendOutArray[] = new TbFilesend[fileSendOutList.size()];
			for(int i=0;i<fileSendOutList.size();i++){
				fileSendOutArray[i] = (TbFilesend)fileSendOutList.get(i);
			}
			for(int i=0;i<fileSendOutArray.length;i++){
				for(int j=0;j<fileSendOutArray.length-i-1;j++){
					if(((TbFilesend)fileSendOutArray[j]).getSendDt().before(((TbFilesend)fileSendOutArray[j+1]).getSendDt())){
						TbFilesend t = fileSendOutArray[j];
						fileSendOutArray[j] = fileSendOutArray[j+1];
						fileSendOutArray[j+1] = t;
					}
				}
			}
				
			for(int i=0;i<fileSendOutArray.length;i++){
				newfileSendOutList.add(fileSendOutArray[i]);
			}
		}
		long count=0;
		count=newfileSendOutList.size();
		startPagingCount(null, request,count);
		startPaging(newfileSendOutList, null, request);
		return mapping.findForward("fileSendOutList");
	}	
	private String getUserNamebyId(String userId){
		String result="";
		if(userId!=null||!"".equals(userId)){
		String[] ids=StringUtils.split(userId,',');
		for(int i=0;i<ids.length;i++){
			TbUser user = this.tbUserDAO.findById(ids[i]);
			result+=(user==null?"":user.getName())+",";
		}
		}
		if(!"".equals(result))
		result = result.substring(0, result.length()-1);
		return result;
	}

	public String getStringFromClob(Clob receiver) throws java.text.ParseException, SQLException, IOException{
			SerializableClob  sc= (SerializableClob)receiver;
	    	String content = "";
			if(sc!=null){
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB)wrapclob;		
			Reader is = clob.getCharacterStream ();
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
	public void setTbUserDAO(TbUserDAOImpl tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}
}
