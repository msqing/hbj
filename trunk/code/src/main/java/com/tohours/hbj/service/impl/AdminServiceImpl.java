package com.tohours.hbj.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springside.modules.orm.Page;

import com.tohours.hbj.constants.TohoursUtils;
import com.tohours.hbj.dao.ArticleDao;
import com.tohours.hbj.dao.UserDao;
import com.tohours.hbj.entity.Article;
import com.tohours.hbj.entity.User;
import com.tohours.hbj.exception.BusinessException;
import com.tohours.hbj.service.AdminService;

@Service
@Transactional
public @Data class AdminServiceImpl implements AdminService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public User login(String userName, String password) {
		String hql = " from User where userName = ? and password = ?";
		Page<User> page = new Page<User>(1);
		page = this.userDao.findPage(page, hql, userName, password);
		List<User> result = page.getResult();
		if(result.size() <= 0){
			throw new BusinessException("用户名或密码错误！");
		} else {
			return result.get(0);
		}
	}

	@Override
	public void editPassword(String userName, String oldPassword, String newPassword) {
		Assert.notNull(userName);
		Assert.notNull(oldPassword);
		Assert.notNull(newPassword);
		User user = this.findByUserName(userName);
		if(user != null){
			if(oldPassword.equals(user.getPassword())){
				user.setPassword(newPassword);
				this.userDao.save(user);
			} else {
				throw new BusinessException("原密码不正确！");
			}
		} else {
			throw new BusinessException("用户不存在");
		}
	}
	
	private User findByUserName(String userName){
		String hql = " from User where userName = ?";
		Page<User> page = new Page<User>(1);
		page = this.userDao.findPage(page, hql, userName);
		List<User> result = page.getResult();
		if(result.size() > 0){
			return result.get(0);
		}
		return null;
	}
	@Override
	public User getUserById(String id) {
		Assert.notNull(id);
		return this.userDao.get(id);
	}

	
	@Override
	public Page<Article> searchArticle(Map<String, Object> key, Page<Article> page){
		StringBuffer hql = new StringBuffer(" from Article where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		if (key != null) {
			String name = (String) key.get("tittle");
			if (StringUtils.isNotEmpty(name)) {
				hql.append(" and tittle like :tittle");
				values.put("tittle", TohoursUtils.addPercent(name));
			}
			String type = (String) key.get("type");
			if (StringUtils.isNotEmpty(type)) {
				hql.append(" and type = :type");
				values.put("type", new Long(type));
			}
		}
		hql.append(" order by insertTime desc");
		return this.articleDao.findPage(page, hql.toString(), values);
	}
	
	
	@Override
	public Article addArticle(Article article){
		Assert.notNull(article);
		Assert.notNull(article.getTittle());
		Assert.isNull(article.getId());
		Date now = new Date();
		article.setInsertTime(now);
		article.setUpdateTime(now);
		article.setSeq(0L);
		this.articleDao.save(article);
		return article;
	}
	
	
	@Override
	public Article getArticleById(String id) {
		Assert.notNull(id);
		return this.articleDao.get(id);
	}
	
	@Override
	public Article editArticle(Article article) {
		Assert.notNull(article);
		Assert.notNull(article.getId());
		Article dbpm = this.articleDao.get(article.getId());
		dbpm.setUpdateTime(new Date());
		String[] names = { "tittle", "author", "content","type" };
		
		try {
			TohoursUtils.copyProperties(dbpm, names, article);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("拷贝出现错误");
		}
		articleDao.save(dbpm);
		return dbpm;
	}

	@Override
	public void deletePartyMember(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePicture(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCulturePoem(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCultureImg(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCultureVideo(String ids) {
		// TODO Auto-generated method stub
		
	}

}
