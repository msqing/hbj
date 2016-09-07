package com.tohours.hbj.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.orm.PropertyFilter.MatchType;


public abstract interface AbstractDao<T, PK extends Serializable> {
	/**
	 * 根据ID得到对象
	 * @param id
	 * @return
	 */
	T get(PK id);
	
	/**
	 * 保存对象
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 根据Id删除对象
	 * @param Id
	 */
	void delete(PK Id);
	
	/**
	 * 获得page页面
	 * @param page
	 * @param hql
	 * @param values
	 * @return Page
	 */
	Page<T> findPage(Page<T> page, String hql, Map<String, ?> values);
	
	/**
	 * 获得Page页面
	 * @param page
	 * @param hql
	 * @param values
	 * @return Page
	 */
	Page<T> findPage(final Page<T> page, final String hql, final Object... values);
	
	/**
	 * 获得全部
	 * @param page
	 * @return Page
	 */
	Page<T> getAll(final Page<T> page);
	
	/**
	 * 按属性查找对象列表,支持多种匹配方式.
	 * @param propertyName 属性名
	 * @param value  值
	 * @param matchType  匹配类型
	 * @return  List
	 */
	List<T> findBy(final String propertyName, final Object value, final MatchType matchType);
	
	/**
	 * 按属性过滤条件列表查找对象列表.
	 * @param filters
	 * @return list
	 */
	List<T> find(List<PropertyFilter> filters);
	
	/**
	 * 批量执行
	 * @param hql
	 * @param values
	 * @return
	 */
	int batchExecute(final String hql, final Object... values);
	
	/**
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	<X> X findUnique(final String hql, final Object... values);
	
	/**
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	<X> List<X> find(final String hql, final Object... values);
}
