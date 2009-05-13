package com.baosight.base.struts.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.service.ITbShareFileMgr;
import com.baosight.mode.TbShareFile;
import com.baosight.mode.TbUser;

public class SharefileEditAction extends Action {
	
	
	private ITbShareFileMgr tbShareFileMgr;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Boolean maxLengthExceeded = (Boolean) request.getAttribute(MultipartRequestHandler.ATTRIBUTE_MAX_LENGTH_EXCEEDED);
		String method = request.getParameter("method");
		if ((maxLengthExceeded != null) && (maxLengthExceeded.booleanValue()))
			return mapping.findForward("error");
	
		if(method.equals("add"))
			return this.add(mapping, form, request, response);
		
		if(method.equals("modify"))
			return this.modify(mapping, form, request, response);
		return null;
	}
	
	private ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String action = request.getParameter("action");
		
		if (StringUtils.isBlank(action))
			return mapping.findForward("add");
		if (action.equals("submit")){
			//做新增操作
			String uploadPath= this.getServlet().getServletContext().getRealPath("/")+"UploadFile/Resources Sharing";
			TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
			String userId = user.getId();
			String explanation = (String) ((DynaValidatorForm) form).get("explanation");
			String type = (String) ((DynaValidatorForm) form).get("type");
			String isShare = (String) ((DynaValidatorForm) form).get("isShare");
			FormFile file = (FormFile) ((DynaValidatorForm) form).get("file");
			//上传附件
			String serverName=this.fileUpload(file, uploadPath);
			
			TbShareFile saveObject = new TbShareFile();
			saveObject.setUserid(userId);
			saveObject.setExplanation(explanation);
			saveObject.setIsShare(isShare);
			saveObject.setType(type);
			saveObject.setOriginallyName(file.getFileName());
			saveObject.setServerName(serverName);
          
			this.tbShareFileMgr.save(saveObject);
		}
		return mapping.findForward("success");
	}
	
	private ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, SQLException, IOException {
		
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (StringUtils.isNotBlank(action)&&action.equals("submit")) {
			//做修改操作
			String type = (String) ((DynaValidatorForm) form).get("type");
			String isShare = (String) ((DynaValidatorForm) form).get("isShare");
			String explanation = (String) ((DynaValidatorForm) form).get("explanation");
			
			TbShareFile updateObject = this.tbShareFileMgr.findById(id);
			updateObject.setExplanation(explanation);
			updateObject.setIsShare(isShare);
			updateObject.setType(type);

			tbShareFileMgr.update(updateObject);
		} 
		else if(StringUtils.isNotBlank(id)){
			//跳转编辑页面设置好将要修改的字段
			
			TbShareFile updateObject = tbShareFileMgr.findById(id);
			request.setAttribute("fileName", updateObject.getOriginallyName());
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("explanation",updateObject.getExplanation());
			((DynaValidatorForm) form).set("isShare",updateObject.getIsShare());
			((DynaValidatorForm) form).set("type",updateObject.getType());
			
			return mapping.findForward("add");
		}
		return mapping.findForward("success");
	}
	
	/**
	 * 通过IO Stream上传到服务器中
	 * @param file 
	 * @param uploadPath 上传的目录
	 * @return  返回一个UUID做为存储的文件名保存到服务器
	 * @throws IOException
	 */
	private String fileUpload( FormFile file, String uploadPath) throws IOException{
		String filename=UUID.randomUUID().toString();
		java.io.InputStream stream = file.getInputStream();//把文件读入 
        OutputStream bos = new FileOutputStream(uploadPath + "/"+ filename); 
        //建立一个上传文件的输出流，将上传文件存入web应用的根目录。 
        int bytesRead = 0; 
        byte[] buffer = new byte[8192]; 
        while ( (bytesRead = stream.read(buffer, 0, 8192)) != -1) { 
        	bos.write(buffer, 0, bytesRead);//将文件写入服务器 
         }
         bos.close(); 
         stream.close(); 
         //返回一个UUID做为文件名保存到WEB容器下
         return filename;
	}

	public void setTbShareFileMgr(ITbShareFileMgr tbShareFileMgr) {
		this.tbShareFileMgr = tbShareFileMgr;
	}
	

	
}
