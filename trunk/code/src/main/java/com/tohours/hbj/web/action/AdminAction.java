package com.tohours.hbj.web.action;

import java.io.File;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.util.Assert;

import com.opensymphony.xwork2.ActionContext;
import com.tohours.hbj.constants.Constants;
import com.tohours.hbj.entity.Article;
import com.tohours.hbj.entity.User;
import com.tohours.hbj.exception.BusinessException;

@EqualsAndHashCode(callSuper = false)
@InterceptorRefs(@InterceptorRef("adminDefaultStack"))
@Namespace("/admin")
public @Data class AdminAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	private User user;
	
	private String type;
	private String name;
	private String address;
	private String phone;
	private String post;
	private String term;
	private String ids;
	private String id;
	private String words;
	
	private String ageMin;
	private String ageMax;
	private String partyAgeMin;
	private String partyAgeMax;
	private String nameSearch;
	private String branch;
	private String kaptcha;
	private String results;
	private Article article;
	
	private File jpg;
	private String jpgFileName;
	
	@Action("loginPre")
	public String loginPre(){
		return "login_pre";
	}
	
	@Action("loginTest")
	public void LoginTest(){
		String c = (String)ActionContext.getContext().getSession().get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
		if(StringUtils.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(c)){
			results = "1";
			ActionContext.getContext().getSession().remove(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		}else{
			results = "2";
		}
		
		JSONObject json=new JSONObject();
		json.put("success", true);
		json.put("msg", results);
		
		super.printToJson(json.toString());
	}
	
	@Action("login")
	public void login(){
		Assert.notNull(userName);
		Assert.notNull(password);
		String c = (String)ActionContext.getContext().getSession().get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(StringUtils.isEmpty(c)||!c.equals(kaptcha)){
			ActionContext.getContext().getSession().remove(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			throw new BusinessException("请通过合法渠道登录！");
		}
		ActionContext.getContext().getSession().remove(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		user = super.getAdminService().login(userName, password);
		super.getSession().setAttribute(Constants.SESSION_USER_NAME, userName);
		super.getSession().setAttribute(Constants.SESSION_USER_ID, user.getId());
		super.getSession().setAttribute(Constants.SESSION_USER, user);
		super.jump("main.do");
	}
	
	@Action("logout")
	public void logout(){
		super.getSession().removeAttribute(Constants.SESSION_USER_NAME);
		super.getSession().removeAttribute(Constants.SESSION_USER_ID);
		super.getSession().removeAttribute(Constants.SESSION_USER);
		super.jump("loginPre.do");
	}
	@Action("main")
	public String main(){
		return "main_page";
	}
	
	@Action("passwordEditPre")
	public String passwordEditPre(){
		
		return "password_edit_pre";
	}
	
	@Action("passwordEdit")
	public String passwordEdit(){
		if(StringUtils.isEmpty(oldPassword)){
			super.setAlertMessage("原密码不能为空");
		} else if(StringUtils.isEmpty(newPassword)){
			super.setAlertMessage("新密码不能为空");
		} else if(StringUtils.isEmpty(repeatPassword)){
			super.setAlertMessage("重复密码不能为空");
		} else if(!newPassword.equals(repeatPassword)){
			super.setAlertMessage("两次密码不一致");
		} else {
			try{
				super.getAdminService().editPassword(super.getUserNameFromSession(), oldPassword, newPassword);
				super.setAlertMessage("修改成功");
			} catch (BusinessException e){
				super.setAlertMessage(e.getMessage());
			}
		}
		return "password_edit_pre";
	}
	
	
	@Action("defaultPage")
	public String defaultPage(){
		return "default_page";
	}
	
	@Action("partyMemberAddPre")
	public String partyMemberAddPre(){
		return "party_member_add_pre";
	}
	
	@Action("partyMemberDelete")
	public void partyMemberDelete() {
		Assert.notNull(ids);
		super.getAdminService().deletePartyMember(ids);
		super.backToList("party_member_list");
	}
	
	@Action("memberAddPre")
	public String memberAddPre(){
		return "member_add_pre";
	}
	
	@Action("memberDelete")
	public void memberDelete() {
		Assert.notNull(ids);
		super.getAdminService().deleteMember(ids);
		super.backToList("member_list");
	}
	
	@SuppressWarnings({ "unchecked" })
	@Action("articleList")
	public String articleList(){
		key.put("tittle", nameSearch);
		page=super.getAdminService().searchArticle(key,super.pager);
		return "article_list";
	}
	
	@Action("articleAddPre")
	public String articleAddPre(){
		return "article_add_pre";
	}
	
	@Action("articleAdd")
	public void articleAdd(){
		super.getAdminService().addArticle(article);
		super.backToList("article_list");
	}
	
	@Action("articleDelete")
	public void articleDelete() {
		Assert.notNull(ids);
		super.getAdminService().deleteArticle(ids);
		super.backToList("article_list");
	}
	
	@Action("articleEditPre")
	public String articleEditPre(){
		Assert.notNull(article);
		Assert.notNull(article.getId());
		article = super.getAdminService().getArticleById(article.getId());
		return "article_edit_pre";
	}
	
	@Action("articleEdit")
	public void articleEdit() {
		Assert.notNull(article);
		Assert.notNull(article.getId());
		Assert.notNull(article.getTittle());
		super.getAdminService().editArticle(article);
		super.backToList("article_list");
	}
	
	@Action("pictureAddPre")
	public String pictureAddPre(){
		return "picture_add_pre";
	}
	
	
	@Action("pictureUpload")
	public void pictureUpload() {
		Assert.notNull(jpg);
		Assert.notNull(jpgFileName);
		JSONObject json = new JSONObject();
		try {
			String path = super.uploadFile(jpg, jpgFileName);
			json.put("success", true);
			json.put("msg", "上传图片成功！");
			json.put("path", path);
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", e.getMessage());
		}
		super.printToHtml(json.toString());
	}
	
	@Action("pictureDelete")
	public void pictureDelete() {
		Assert.notNull(ids);
		super.getAdminService().deletePicture(ids);
		super.backToList("picture_list");
	}
	
	
	@Action("cultureImgAddPre")
	public String cultureImgAddPre(){
		return "culture_img_add_pre";
	}
	
	@Action("cultureImgDelete")
	public void cultureImgDelete() {
		Assert.notNull(ids);
		super.getAdminService().deleteCultureImg(ids);
		super.backToList("culture_img_list");
	}
	
	@Action("cultureVideoAddPre")
	public String cultureVideoAddPre(){
		return "culture_video_add_pre";
	}
	
	
	@Action("cultureVideoDelete")
	public void cultureVideoDelete() {
		Assert.notNull(ids);
		super.getAdminService().deleteCultureVideo(ids);
		super.backToList("culture_video_list");
	}
	
	
	@Action("culturePoemAddPre")
	public String culturePoemAddPre(){
		return "culture_poem_add_pre";
	}
	
	
	@Action("culturePoemDelete")
	public void culturePoemDelete() {
		Assert.notNull(ids);
		super.getAdminService().deleteCulturePoem(ids);
		super.backToList("culture_poem_list");
	}
	
}
