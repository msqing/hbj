package com.tohours.hbj.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.tohours.hbj.dao.ArticleDao;
import com.tohours.hbj.entity.Article;
@Repository
public class ArticleDaoImpl extends AbstractDaoImpl<Article, String> implements ArticleDao {

}
