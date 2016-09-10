package com.tohours.hbj.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.naming.ConfigurationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springside.modules.orm.Page;

import com.opensymphony.xwork2.ActionSupport;
import com.tohours.hbj.constants.Constants;
import com.tohours.hbj.constants.TohoursUtils;
import com.tohours.hbj.entity.Pager;
import com.tohours.hbj.entity.User;
import com.tohours.hbj.exception.BusinessException;
import com.tohours.hbj.service.AdminService;
import com.tohours.hbj.service.NewsService;

@EqualsAndHashCode(callSuper = false)
public @Data class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Logger log = Logger.getLogger(BaseAction.class);
	
	@SuppressWarnings("rawtypes")
	protected Pager pager = new Pager(15);
	@SuppressWarnings("rawtypes")
	protected Page page;
	@Autowired
	private AdminService adminService;
	@Autowired 
	private NewsService newsService;
	
	private String pages;
	
	protected String alert;
	protected Map<String, Object> key = new HashMap<String, Object>();
	

	/**
	 * 得到request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 得到response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 得到session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	
	public String getUserNameFromSession(){
		return (String)this.getSession().getAttribute(Constants.SESSION_USER_NAME);
	}
	
	public User getUserFromSession(){
		String id = (String)this.getSession().getAttribute(Constants.SESSION_USER_ID);
		return this.getAdminService().getUserById(id);
	}


	/**
	 * 返回json给页面
	 * 
	 * @param jsonStr
	 */
	public void printToJson(String jsonStr) {
		printContent(jsonStr, "text/json");
	}
	/**
	 * 返回html
	 * @param html
	 */
	public void printToHtml(String html){
		printContent(html, "text/html");
		
	}
	
	/**
	 * 返回数据给页面
	 * 
	 * @param jsonStr
	 * @param contentType
	 */
	public void printContent(String jsonStr, String contentType) {
		try {
			getResponse().setCharacterEncoding("UTF-8");
			getResponse().setContentType(contentType);
			getResponse().setDateHeader("Expires", 0);
			PrintWriter out = getResponse().getWriter();
			out.println(jsonStr);
			out.flush();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到某个URL
	 * @param url
	 */
	public void jump(String url){
		this.printToHtml("<script>location.href='"+url+"';</script>");
	}
	
	/**
	 * 返回某个列表
	 * @param listName
	 */
	public void backToList(String listName){
		Assert.notNull(listName);
		StringBuffer sb = new StringBuffer();
		String contextPath = this.getRequest().getContextPath();
		if("/".equals(contextPath)){
			contextPath = "";
		}
		sb.append(String.format("<script type='text/javascript' src='%s/static/js/tohours.min.js'></script>", contextPath));
		sb.append(String.format("<script type='text/javascript'>location.href = tohours.storage.get('%s');</script>", listName));
		this.printToHtml(sb.toString());
	}


	/**
	 * 上传附件
	 * @param file
	 * @param fileName
	 * @return
	 * @throws ConfigurationException
	 * @throws IOException
	 */
	public String uploadFile(File file, String fileName) {

		log.debug(fileName);
		Calendar calendar = Calendar.getInstance();
		String datePath = calendar.get(Calendar.YEAR) + "/";
		datePath += this.formatNum(calendar.get(Calendar.MONTH) + 1) + this.formatNum(calendar.get(Calendar.DATE));
		String newFileName = TohoursUtils.randomKey(10) + TohoursUtils.getFileExt(fileName);
		String separator = "/";
		String realPath = ServletActionContext.getServletContext().getRealPath(separator + "uploads");
		File newFile = new File(realPath + separator + datePath + separator + newFileName);
		File dirFile = new File(realPath + separator + datePath + separator);
		if(dirFile.exists() == false){
			dirFile.mkdirs();
		}
		log.debug(realPath);
		if(!validateFileSize(file, Constants.getFileUploadSize())) {
			throw new BusinessException("超过附件上传限制大小");
		}
		if(!validateFileExt(fileName, Constants.getFileUploadType())) {
			throw new BusinessException("只能上传 " + Constants.getFileUploadType() + "格式的文件");
		}
		copy(file, newFile);
		return "uploads" + separator + datePath + separator + newFileName;
	}
	

	/**
	 * 验证文件大小
	 * @param upload
	 */
	private boolean validateFileSize(File upload, Long maxSize) {
		long fileSize = upload.length();
		return fileSize <= maxSize;
	}
	
	/**
	 * 验证文件扩展名
	 * @param upload
	 * @param exts
	 * @return
	 */
	private boolean validateFileExt(String uploadFileName, String exts) {
		boolean rv = false;
		String ext = TohoursUtils.getFileExt(uploadFileName);
		ext = ext.replaceAll("^\\.", "");
		if(StringUtils.isNotEmpty(ext)){
			rv = exts.indexOf(ext) >= 0;
		}
		return rv;
	}
	

	/**
	 * 将10以下的数字补0
	 * @return
	 */
	private String formatNum(int n){
		
		return n < 10 ? "0" + n : n + "";
	}
	
	
	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				// 输入到缓冲流
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void setAlertMessage(String msg){
		this.alert = String.format("<script type='text/javascript'>window.onload=function(){alert('%s');}</script>", msg);
	}
	
	

	private static final int BUFFER_SIZE = 16 * 1024 ;
}
