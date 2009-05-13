package com.baosight.base.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbArchives;
import com.baosight.mode.TbUploadFile;

public class CopyOfTbArchivesEditAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Boolean maxLengthExceeded = (Boolean) request.getAttribute(MultipartRequestHandler.ATTRIBUTE_MAX_LENGTH_EXCEEDED);
		String method = request.getParameter("method");
		if ((maxLengthExceeded != null) && (maxLengthExceeded.booleanValue())){
			return mapping.findForward("error");
		}
		
		
		if(method.equals("add")){
			String fileId = request.getParameter("");
			return mapping.findForward("add");
		}
		
		if(method.equals("upload"))
			return this.upload(mapping, form, request, response);	
		
		if(method.equals("modify"))
			return this.modify(mapping, form, request, response);

		if(method.equals("archivesStatus"))
			//return this.archivesStatus(mapping, form, request, response);

		if(method.equals("download"))
			return this.download(mapping, form, request, response);
		
		return null;
	}
	
	private ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, IOException {
		
			MultipartRequestHandler multipartRequestHandler=form.getMultipartRequestHandler();
			Hashtable files =multipartRequestHandler.getFileElements();
			this.uploadFile(files,request);
		return mapping.findForward("success");
	}
	//上传附件
	private Set<TbUploadFile> uploadFile(Hashtable files,HttpServletRequest request) throws IOException{
	
		String filePath = this.getServlet().getServletContext().getRealPath("/")+"UploadFile";
		File a = new File(filePath);
		String existFileName [] = a.list();
		Set<TbUploadFile> tbUploadFiles=new HashSet<TbUploadFile>();
        String serverfileName="";
        TbUploadFile tbUploadFile=null;
        boolean isExist = false;
		for (Enumeration e = files.keys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			FormFile formfile = (FormFile) files.get(key);
			for(int i=0;i<existFileName.length;i++){
				if(existFileName[i].equals(formfile.getFileName())){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				System.out.println(formfile.getFileName());
				this.fileUpload(formfile, filePath,false,request);
			}else{
				System.out.println(formfile.getFileName());
				this.fileUpload(formfile, filePath,true,request);
			}    
		}
		return tbUploadFiles;
		
	}
	
	private String fileUpload( FormFile file, String uploadPath,boolean isExist,HttpServletRequest request) throws IOException{
		
		String fileRealName = request.getParameter("DocTitle");
		System.out.println(fileRealName);
		fileRealName = fileRealName.substring(fileRealName.lastIndexOf("\\")+1,fileRealName.length());
		System.out.println(uploadPath + "/"+ fileRealName);		
		String filename=UUID.randomUUID().toString().replaceAll("-", "");
		java.io.InputStream stream = file.getInputStream();//把文件读入 
		if(!isExist){
	        OutputStream bos = new FileOutputStream(uploadPath + "/"+ fileRealName); 
	        //建立一个上传文件的输出流，将上传文件存入web应用的根目录。 
	        int bytesRead = 0; 
	        byte[] buffer = new byte[8192]; 
	        while ( (bytesRead = stream.read(buffer, 0, 8192)) != -1) { 
	        	bos.write(buffer, 0, bytesRead);//将文件写入服务器 
	         }
	         bos.close(); 
	         stream.close(); 
		}else{
          
		}
         //返回一个UUID做为文件名保存到WEB容器下
         return fileRealName;
	}	


	
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id=(String)request.getParameter("id");
		TbUploadFile fileReocrd  = null;//this.tbUploadFileDAO.findById(id);
	    String fullPath = this.getServlet().getServletContext().getRealPath("/")+"UploadFile\\"+fileReocrd.getServerName();    
	    FileInputStream file = new FileInputStream(fullPath);   
	    //解决中文文件名下载问题
	    String filename = new String(fileReocrd.getOriginallyName().getBytes("GBK"),"ISO_8859_1");
	    response.setContentType("application/octet-stream;charset=GBK");      
	    response.setHeader("Content-Disposition", "attachment;filename="+ filename);   
	    //print   
	    ServletOutputStream out = response.getOutputStream();   
	    out.flush();   
	    byte buffer[] = new byte[1024];   
	    int size;   
	    while ((size = file.read(buffer)) != -1) {   
	        out.write(buffer, 0, size);   
	        out.flush();   
	    }   
	       
	    file.close();   
	    out.close();
		return null;
		
	}

	
	private String checkFileSize(Hashtable files){
		String str="";
		for (Enumeration e = files.keys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			FormFile formfile = (FormFile) files.get(key);
			int fileSize=formfile.getFileSize();
			if(fileSize>=(10*1024*1024)){
				str+=formfile.getFileName()+" ";
				System.out.println(formfile.getFileName());
			}
		}
		if(str.equals(""))
			return "";
		else
			str+="不能大于10M!";
		return str;
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, SQLException, IOException {
		
		String id = request.getParameter("id");
		String delIds = request.getParameter("delId");
		String[] FileIds=StringUtils.split(delIds,'-');
		String action = request.getParameter("action");
		if (StringUtils.isNotBlank(action)&&action.equals("submit")) {
			
			//做修改操作
			String applyId = (String) ((DynaValidatorForm) form).get("applyId");
			String title = (String) ((DynaValidatorForm) form).get("title");
			String fileId = (String) ((DynaValidatorForm) form).get("fileId");
			String createTime = (String) ((DynaValidatorForm) form).get("createTime");
			String createDept = (String) ((DynaValidatorForm) form).get("createDept");
			String topicId = (String) ((DynaValidatorForm) form).get("topicId");
			String cateId = (String) ((DynaValidatorForm) form).get("cateId");
			String nopubdescId = (String) ((DynaValidatorForm) form).get("nopubdescId");
			String keywords = (String) ((DynaValidatorForm) form).get("keywords");
			String formatId = (String) ((DynaValidatorForm) form).get("formatId");
			String typeId = (String) ((DynaValidatorForm) form).get("typeId");
			String normalsign = (String) ((DynaValidatorForm) form).get("normalsign");
			String draftsign = (String) ((DynaValidatorForm) form).get("draftsign");
			String Abstract = (String) ((DynaValidatorForm) form).get("abstract");
			DateFormat   format   =   new   SimpleDateFormat("yyyy-MM-dd");   
            Date   createTimeDate   =   format.parse(createTime); 
			
			TbArchives Archives = null;//this.tbArchivesMgr.findById(id);
			Archives.setApplyId(applyId);
			Archives.setTitle(title);
			Archives.setFileId(fileId);
			Archives.setCreateTime(createTimeDate);
			Archives.setCreateDept(createDept);
			Archives.setTopicId(topicId);
			Archives.setCateId(cateId);
			Archives.setNopubdescId(nopubdescId);
			Archives.setKeywords(keywords);
			Archives.setFormatId(formatId);
			Archives.setTypeId(typeId);
			Archives.setNormalsign(normalsign);
			Archives.setDraftsign(draftsign);
			Archives.setAbstract_(Abstract);

		 	String filePath = this.getServlet().getServletContext().getRealPath("/")+"UploadFile\\";
		 	for(int i=0;i<FileIds.length;i++){
		 		TbUploadFile  uploadFile=null;//tbUploadFileDAO.findById(FileIds[i]);
		 		File f=new File(filePath+uploadFile.getServerName());
		 		if(f.delete());
		 			//tbUploadFileDAO.delete(uploadFile);
		 	}
		 	MultipartRequestHandler multipartRequestHandler=form.getMultipartRequestHandler();
			Hashtable files =multipartRequestHandler.getFileElements();
			Set<TbUploadFile> TbUploadFiles=this.uploadFile(files,request);
			Iterator<TbUploadFile> iterator = TbUploadFiles.iterator();
			while(iterator.hasNext()){
				Archives.addTbUploadFile(iterator.next());
			}
			//tbArchivesMgr.update(Archives);
		} 
		else if(StringUtils.isNotBlank(id)){
			//跳转编辑页面设置好将要修改的字段
			//this.addSelectData(request);
			TbArchives Archives = null;//tbArchivesMgr.findById(id);
			request.setAttribute("files", Archives.getTbUploadFiles());
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("applyId",Archives.getApplyId());
			((DynaValidatorForm) form).set("title",Archives.getTitle());
			((DynaValidatorForm) form).set("fileId",Archives.getFileId());
			String createTime =DateFormatUtils.ISO_DATE_FORMAT.format(Archives.getCreateTime());
			((DynaValidatorForm) form).set("createTime",createTime);
			((DynaValidatorForm) form).set("createDept",Archives.getCreateDept());
			((DynaValidatorForm) form).set("topicId",Archives.getTopicId());
			((DynaValidatorForm) form).set("cateId",Archives.getCateId());
			((DynaValidatorForm) form).set("nopubdescId",Archives.getNopubdescId());
			((DynaValidatorForm) form).set("keywords",Archives.getKeywords());
			((DynaValidatorForm) form).set("formatId",Archives.getFormatId());
			((DynaValidatorForm) form).set("typeId",Archives.getTypeId());
			((DynaValidatorForm) form).set("normalsign",Archives.getNormalsign());
			((DynaValidatorForm) form).set("draftsign",Archives.getDraftsign());
			((DynaValidatorForm) form).set("abstract",Archives.getAbstract_());
			
			return mapping.findForward("add");
		}
		return mapping.findForward("success");
	}	
}
