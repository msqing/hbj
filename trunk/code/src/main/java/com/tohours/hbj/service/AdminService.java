package com.tohours.hbj.service;

import java.util.Map;

import org.springside.modules.orm.Page;

import com.tohours.hbj.entity.Article;
import com.tohours.hbj.entity.User;

public interface AdminService {
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 */
	User login(String userName, String password);
	
	/**
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 */
	void editPassword(String userName, String oldPassword, String newPassword);
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(String id);
	
	/**
	 * 查找内容
	 * @param key
	 * @param page
	 */
	Page<Article> searchArticle(Map<String, Object> key, Page<Article> page);
	
	
	/**
	 *  新增内容
	 * @param article
	 * @return
	 */
	Article addArticle(Article article);
	
	/**
	 * 删除党员信息
	 * @param ids
	 */
	void deletePartyMember(String ids);
	/**
	 * 删除人员信息
	 * @param ids
	 */
	void deleteMember(String ids);
	/**
	 * 删除内容信息
	 * @param ids
	 */
	void deleteArticle(String ids);
	/**
	 * 删除滚屏图片
	 * @param ids
	 */
	void deletePicture(String ids);
	/**
	 * 删除诗歌
	 * @param ids
	 */
	void deleteCulturePoem(String ids);
	/**
	 * 删除图片
	 * @param ids
	 */
	void deleteCultureImg(String ids);
	/**
	 * 删除视频
	 * @param ids
	 */
	void deleteCultureVideo(String ids);
	
	/**
	 * 根据ID找内容
	 * @param id
	 * @return
	 */
	Article getArticleById(String id);
	
	/**
	 * 编辑内容信息
	 * @param Article
	 * @return
	 */
	Article editArticle(Article article);
}
