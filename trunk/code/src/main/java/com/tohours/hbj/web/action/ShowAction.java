package com.tohours.hbj.web.action;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.util.Assert;

import com.tohours.hbj.entity.Article;

@EqualsAndHashCode(callSuper=false)
@Namespace("/")
public @Data class ShowAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ids;
	private String id;
	private String type;
	
	private String nameSearch;
	private Article article;
	
	private List<Article> noticeList;
	private List<Article> qwList;
	private List<Article> dwList;
	private List<Article> djList;
	private List<Article> jwList;
	
	private String title;
	
	
	@SuppressWarnings({ "unchecked" })
	@Action("contentList")
	public String contentList(){
		key.put("type", type);
		page=super.getAdminService().searchArticle(key,super.pager);
		return "content_list";
	}
	
	@Action("content")
	public String content(){
		Assert.notNull(id);
		article = super.getAdminService().getArticleById(id);
		return "content";
	}
	
	@Action("cultureType")
	public String cultureType(){
		return "culture_type";
	}
}
