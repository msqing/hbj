package com.tohours.hbj.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import com.tohours.hbj.dao.EffectExamineDao;
import com.tohours.hbj.dao.EffectInfoDao;
import com.tohours.hbj.dao.EffectPreExamineDao;
import com.tohours.hbj.dao.SaveExamineDao;
import com.tohours.hbj.dao.SaveInfoDao;
import com.tohours.hbj.dao.SavePreExamineDao;
import com.tohours.hbj.dao.SewageInfoDao;
import com.tohours.hbj.entity.EffectExamine;
import com.tohours.hbj.entity.EffectInfo;
import com.tohours.hbj.entity.EffectPreExamine;
import com.tohours.hbj.entity.SaveExamine;
import com.tohours.hbj.entity.SaveInfo;
import com.tohours.hbj.entity.SavePreExamine;
import com.tohours.hbj.entity.SewageInfo;
import com.tohours.hbj.service.NewsService;

@Service
@Transactional
public @Data class NewsServiceImpl implements NewsService{
	
	@Autowired
	private EffectInfoDao effectInfoDao;
	@Autowired
	private EffectPreExamineDao effectPreExamineDao;
	@Autowired
	private EffectExamineDao effectExamineDao;
	@Autowired
	private SaveInfoDao saveInfoDao;
	@Autowired
	private SavePreExamineDao savePreExamineDao;
	@Autowired
	private SaveExamineDao saveExamineDao;
	@Autowired
	private SewageInfoDao sewageInfoDao;

	@Override
	public Page<EffectInfo> searchEffectInfo(Map<String, Object> key,Page<EffectInfo> page) {
		StringBuffer hql = new StringBuffer(" from EffectInfo where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append(" order by endTime desc ");
		return this.effectInfoDao.findPage(page, hql.toString(), values);
	}

	@Override
	public Page<EffectPreExamine> searchEffectPreExamine(Map<String, Object> key, Page<EffectPreExamine> page) {
		StringBuffer hql = new StringBuffer(" from EffectPreExamine where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append(" order by endTime desc ");
		return this.effectPreExamineDao.findPage(page, hql.toString(), values);
	}
	
	@Override
	public Page<EffectExamine> searchEffectExamine(Map<String, Object> key, Page<EffectExamine> page) {
		StringBuffer hql = new StringBuffer(" from EffectExamine where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append(" order by endTime desc ");
		return this.effectExamineDao.findPage(page, hql.toString(), values);
	}

	@Override
	public Page<SaveInfo> searchSaveInfo(Map<String, Object> key,Page<SaveInfo> page) {
		StringBuffer hql = new StringBuffer(" from SaveInfo where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append(" order by endTime desc ");
		return this.saveInfoDao.findPage(page, hql.toString(), values);
	}

	@Override
	public Page<SavePreExamine> searchSavePreExamine(Map<String, Object> key,Page<SavePreExamine> page) {
		StringBuffer hql = new StringBuffer(" from SavePreExamine where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append(" order by endTime desc ");
		return this.savePreExamineDao.findPage(page, hql.toString(), values);
	}

	@Override
	public Page<SaveExamine> searchSaveExamine(Map<String, Object> key,Page<SaveExamine> page) {
		StringBuffer hql = new StringBuffer(" from SaveExamine where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append(" order by endTime desc ");
		return this.saveExamineDao.findPage(page, hql.toString(), values);
	}

	@Override
	public Page<SewageInfo> searchSwage(Map<String, Object> key,Page<SewageInfo> page) {
		StringBuffer hql = new StringBuffer(" from SewageInfo where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append(" and time=(select max(time) from SewageInfo)");
		return this.sewageInfoDao.findPage(page, hql.toString(), values);
	}

}
