package com.tohours.hbj.dao.hibernate;

import java.io.Serializable;

import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * @author 叶荣杰
 */
public abstract class AbstractDaoImpl<T, PK extends Serializable> extends HibernateDao<T, PK>{
	
}
