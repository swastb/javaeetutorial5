package com.baosight.base.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
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

import com.baosight.base.dao.impl.TbTopicDAOImpl;
import com.baosight.base.dao.impl.TbUploadFileDAOImpl;
import com.baosight.base.service.IDeptMgr;
import com.baosight.base.service.ITbArchivesMgr;
import com.baosight.base.service.ITbFormatMgr;
import com.baosight.base.service.ITbNopubdescMgr;
import com.baosight.base.service.ITbOffDocCateMgr;
import com.baosight.base.service.ITbPubclassMgr;
import com.baosight.base.service.ITbTypeMgr;
import com.baosight.mode.Stufflisting;
import com.baosight.mode.TbArchives;
import com.baosight.mode.TbUploadFile;
import com.baosight.tools.ChangeUtil;
public class TbArchivesEditAction extends Action {

	private ITbArchivesMgr tbArchivesMgr;
	private ITbFormatMgr tbFormatMgr;
	private ITbNopubdescMgr tbNopubdescMgr;
	private ITbOffDocCateMgr tbOffDocCateMgr;
	private ITbPubclassMgr tbPubclassMgr;
	private TbTopicDAOImpl	tbTopicDAO;
	private TbUploadFileDAOImpl tbUploadFileDAO;
	private ITbTypeMgr tbTypeMgr;
	private IDeptMgr deptMgr;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Boolean maxLengthExceeded = (Boolean) request.getAttribute(MultipartRequestHandler.ATTRIBUTE_MAX_LENGTH_EXCEEDED);
		String method = request.getParameter("method");
		if ((maxLengthExceeded != null) && (maxLengthExceeded.booleanValue())){
			System.out.print(form);
			return mapping.findForward("error");
		}
		if(method.equals("add"))
			return this.add(mapping, form, request, response);

		if(method.equals("modify"))
			return this.modify(mapping, form, request, response);

		if(method.equals("archivesStatus"))
			return this.archivesStatus(mapping, form, request, response);

		if(method.equals("download"))
			return this.download(mapping, form, request, response);
		
		return null;
	}
	
	private ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equals("add")){
			this.addSelectData(request);
			return mapping.findForward("add");
		}
		if (action.equals("submit")){
			//做新增操作
			String applyId = (String) ((DynaValidatorForm) form).get("applyId");
			String title = (String) ((DynaValidatorForm) form).get("title");
			String fileId = (String) ((DynaValidatorForm) form).get("fileId");
			String createTime = (String) ((DynaValidatorForm) form).get("createTime");
			String createDept = (String) ((DynaValidatorForm) form).get("presideDept");
			String topicId = (String) ((DynaValidatorForm) form).get("topicId");
			String pubId = (String) ((DynaValidatorForm) form).get("pubId");
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
            
			TbArchives Archives = new TbArchives();
			Archives.setApplyId(applyId);
			Archives.setTitle(title);
			Archives.setFileId(fileId);
			Archives.setPubId(pubId);
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
			Archives.setStatus("0");
            //上传附件
			MultipartRequestHandler multipartRequestHandler=form.getMultipartRequestHandler();
			Hashtable files =multipartRequestHandler.getFileElements();
			Set<TbUploadFile> tbUploadFiles=this.uploadFile(files, Archives);
			Archives.setTbUploadFiles(tbUploadFiles);
			tbArchivesMgr.save(Archives);
				 
		}
		return mapping.findForward("success");
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
			String createDept = (String) ((DynaValidatorForm) form).get("presideDept");
			String topicId = (String) ((DynaValidatorForm) form).get("topicId");
			String cateId = (String) ((DynaValidatorForm) form).get("cateId");
			String pubId = (String) ((DynaValidatorForm) form).get("pubId");
			String nopubdescId = (String) ((DynaValidatorForm) form).get("nopubdescId");
			String keywords = (String) ((DynaValidatorForm) form).get("keywords");
			String formatId = (String) ((DynaValidatorForm) form).get("formatId");
			String typeId = (String) ((DynaValidatorForm) form).get("typeId");
			String normalsign = (String) ((DynaValidatorForm) form).get("normalsign");
			String draftsign = (String) ((DynaValidatorForm) form).get("draftsign");
			String Abstract = (String) ((DynaValidatorForm) form).get("abstract");
			DateFormat   format   =   new   SimpleDateFormat("yyyy-MM-dd");   
            Date   createTimeDate   =   format.parse(createTime); 
			
			TbArchives Archives = this.tbArchivesMgr.findById(id);
			Archives.setApplyId(applyId);
			Archives.setTitle(title);
			Archives.setFileId(fileId);
			Archives.setCreateTime(createTimeDate);
			Archives.setCreateDept(createDept);
			Archives.setTopicId(topicId);
			Archives.setPubId(pubId);
			Archives.setCateId(cateId);
			Archives.setNopubdescId(nopubdescId);
			Archives.setKeywords(keywords);
			Archives.setFormatId(formatId);
			Archives.setTypeId(typeId);
			Archives.setNormalsign(normalsign);
			Archives.setDraftsign(draftsign);
			Archives.setAbstract_(Abstract);

		 	String UploadFilePath = this.getServlet().getServletContext().getRealPath("/")+"UploadFile\\Document Management";
		 	for(int i=0;i<FileIds.length;i++){
		 		TbUploadFile  uploadFile=tbUploadFileDAO.findById(FileIds[i]);
		 		File f=new File(UploadFilePath+uploadFile.getServerName());
		 		if(f.delete());
		 			tbUploadFileDAO.delete(uploadFile);
		 	}
		 	MultipartRequestHandler multipartRequestHandler=form.getMultipartRequestHandler();
			Hashtable files =multipartRequestHandler.getFileElements();
			Set<TbUploadFile> TbUploadFiles=this.uploadFile(files, Archives);
			Iterator<TbUploadFile> iterator = TbUploadFiles.iterator();
			while(iterator.hasNext()){
				Archives.addTbUploadFile(iterator.next());
			}
			tbArchivesMgr.update(Archives);
		} 
		else if(StringUtils.isNotBlank(id)){
			//跳转编辑页面设置好将要修改的字段
			this.addSelectData(request);
			TbArchives Archives = tbArchivesMgr.findById(id);

			request.setAttribute("files", Archives.getTbUploadFiles());
			
			String applyid="";
			String type="";
			String applyno="";
			String f_linkman="";
			if(Archives.getAttr2()!=null && !Archives.getAttr2().equals(""))
			{
				applyid=Archives.getAttr2();
			}else
			{
				applyid=Archives.getAttr1();
			}
			
			List stuffList=new ArrayList();
			if(applyid!=null)
			{
				Stufflisting stufflisting=new Stufflisting();
				stufflisting.setApplyid(applyid);
				stuffList=tbArchivesMgr.findByObjects(stufflisting);
			}
			
			type=Archives.getAttr3();
			applyno=Archives.getAttr4();
			f_linkman=Archives.getAttr5();
			
			request.setAttribute("stuffList", stuffList);
			request.setAttribute("applyid", Archives.getAttr1());
			request.setAttribute("type", type);
			request.setAttribute("applyno", applyno);
			request.setAttribute("f_linkman", f_linkman);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("applyId",Archives.getApplyId());
			((DynaValidatorForm) form).set("title",Archives.getTitle());
			((DynaValidatorForm) form).set("fileId",Archives.getFileId());
			((DynaValidatorForm) form).set("pubId",Archives.getPubId());
			String createTime =DateFormatUtils.ISO_DATE_FORMAT.format(Archives.getCreateTime());
			((DynaValidatorForm) form).set("createTime",createTime);
			((DynaValidatorForm) form).set("presideDept",Archives.getCreateDept());
			String dept=deptMgr.find(Archives.getCreateDept()).getName();
			((DynaValidatorForm) form).set("presidername",dept);
			((DynaValidatorForm) form).set("topicId",Archives.getTopicId());
			((DynaValidatorForm) form).set("cateId",Archives.getCateId());
			((DynaValidatorForm) form).set("pubId",Archives.getPubId());
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
	
	public ActionForward archivesStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		TbArchives Archives = this.tbArchivesMgr.findById(id);
		Archives.setStatus("1");
		this.tbArchivesMgr.update(Archives);
		return mapping.findForward("success");
		
	}

	
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
			String id=(String)request.getParameter("id");
			String state=(String)request.getParameter("state");
			
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";	
	
			if("xzxk".equals(state))
			{
				
				TbUploadFile fileReocrd  = this.tbUploadFileDAO.findById(id);	   
				
				Stufflisting stufflisting=(Stufflisting)tbArchivesMgr.findById(Stufflisting.class, id);
				if(stufflisting!=null)
				{
					String fullPath = stufflisting.getStandby4();
					FileInputStream file = new FileInputStream(fullPath);   
				    //解决中文文件名下载问题
					response.setCharacterEncoding("GBk"); 
					String filename = stufflisting.getUpload();
					response.setContentType("application/x-download");
					response.addHeader("Content-Disposition","attachment;filename=" + filename);
					String url=ChangeUtil.xzxkurl+"/upload/"+filename;
					response.sendRedirect(url);
					return null;
				}
			}else
			{

				TbUploadFile fileReocrd  = this.tbUploadFileDAO.findById(id);	   
				response.setCharacterEncoding("GBk"); 
				String filename = fileReocrd.getOriginallyName();
				response.setContentType("application/x-download");
				response.addHeader("Content-Disposition","attachment;filename=" + filename);
				response.sendRedirect(basePath+"UploadFile/Document Management/"+java.net.URLDecoder.decode(filename,"GBK"));	
				return null;
			    			    
				/*TbUploadFile fileReocrd  = this.tbUploadFileDAO.findById(id);	   
				String fullPath = this.getServlet().getServletContext().getRealPath("/")+"UploadFile\\Document Management\\"+fileReocrd.getServerName();
				FileInputStream file = new FileInputStream(fullPath);   
			    //解决中文文件名下载问题
			    String filename = new String(fileReocrd.getOriginallyName().getBytes("GBK"),"ISO_8859_1");
			    response.setContentType("application/octet-stream;charset=GBK");      
			    response.setHeader("Content-Disposition", "attachment;filename="+ filename);   
			    ServletOutputStream out = response.getOutputStream();   
			    out.flush();   
			    byte buffer[] = new byte[1024];   
			    int size;   
			    while ((size = file.read(buffer)) != -1) {   
			        out.write(buffer, 0, size);   
			        out.flush();   
			    }   
			       
			    file.close();   
			    out.close();*/			    
			}

		return null;
		
	}
	/**
	 * 加载页面下拉框数据
	 * @param request
	 */
	private void addSelectData(HttpServletRequest request){
	
		List topicList=tbTopicDAO.findAll();
		List pubList=tbPubclassMgr.findAll();
		List typeList=tbTypeMgr.findAll();
		List formatList=tbFormatMgr.findAll();
		List nopubdescList=tbNopubdescMgr.findAll();
		List offDocCateList=tbOffDocCateMgr.findAll();
	
		request.setAttribute("topicList",topicList);
		request.setAttribute("pubList",pubList);
		request.setAttribute("nopubdescList",nopubdescList);
		request.setAttribute("typeList",typeList);
		request.setAttribute("formatList",formatList);
		request.setAttribute("offDocCateList",offDocCateList);
	}
	
	/**
	 * 上传附件文件并返回文件记录集
	 * @param files     文件集
	 * @param Archives  附件文件所属的档案记录
	 * @return 附件文件记录集
	 * @throws IOException
	 */
	private Set<TbUploadFile> uploadFile(Hashtable files,TbArchives Archives) throws IOException{
	
		String filePath = this.getServlet().getServletContext().getRealPath("/")+"UploadFile/Document Management";
		Set<TbUploadFile> tbUploadFiles=new HashSet<TbUploadFile>();
        String serverfileName="";
        TbUploadFile tbUploadFile=null;
		for (Enumeration e = files.keys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			FormFile formfile = (FormFile) files.get(key);
			String filename = formfile.getFileName().trim(); //文件名 
			serverfileName=this.fileUpload(formfile, filePath,filename);//得到上传文件后的文件名
			tbUploadFile =new TbUploadFile(Archives,filename,serverfileName);
			tbUploadFiles.add(tbUploadFile);
		}
		return tbUploadFiles;
		
	}
	
	/**
	 * 通过IO Stream上传到服务器中
	 * @param file 
	 * @param uploadPath 上传的目录
	 * @return  返回一个UUID做为存储的文件名保存到服务器
	 * @throws IOException
	 */
	private String fileUpload( FormFile file, String uploadPath,String filename) throws IOException{
		//String filename=UUID.randomUUID().toString();
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

	public void setTbArchivesMgr(ITbArchivesMgr tbArchivesMgr) {
		this.tbArchivesMgr = tbArchivesMgr;
	}

	public void setTbFormatMgr(ITbFormatMgr tbFormatMgr) {
		this.tbFormatMgr = tbFormatMgr;
	}

	public void setTbNopubdescMgr(ITbNopubdescMgr tbNopubdescMgr) {
		this.tbNopubdescMgr = tbNopubdescMgr;
	}

	public void setTbOffDocCateMgr(ITbOffDocCateMgr tbOffDocCateMgr) {
		this.tbOffDocCateMgr = tbOffDocCateMgr;
	}

	public void setTbPubclassMgr(ITbPubclassMgr tbPubclassMgr) {
		this.tbPubclassMgr = tbPubclassMgr;
	}

	public void setTbTypeMgr(ITbTypeMgr tbTypeMgr) {
		this.tbTypeMgr = tbTypeMgr;
	}

	public void setDeptMgr(IDeptMgr deptMgr) {
		this.deptMgr = deptMgr;
	}

	public void setTbTopicDAO(TbTopicDAOImpl tbTopicDAO) {
		this.tbTopicDAO = tbTopicDAO;
	}

	public void setTbUploadFileDAO(TbUploadFileDAOImpl tbUploadFileDAO) {
		this.tbUploadFileDAO = tbUploadFileDAO;
	}
	
}
