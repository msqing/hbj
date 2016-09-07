package com.tohours.hbj.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import com.tohours.hbj.dao.HealthInfoDao;
import com.tohours.hbj.entity.HealthInfo;
import com.tohours.hbj.service.SearchService;

@Service
@Transactional
public @Data class SearchServiceImpl implements SearchService{
	
	@Autowired
	private HealthInfoDao healthInfoDao;

	@Override
	public Page<HealthInfo> searchHealthInfo(Map<String, Object> key,Page<HealthInfo> page) {
		StringBuffer hql = new StringBuffer(" from HealthInfo where 1=1");
		Map<String, Object> values = new HashMap<String, Object>();
		if (key != null) {
			String cardId = (String) key.get("cardId");
			if (StringUtils.isNotEmpty(cardId)) {
				hql.append(" and cardId like :cardId");
				values.put("cardId", cardId);
			}
		}
		hql.append(" order by cssj desc ");
		return this.healthInfoDao.findPage(page, hql.toString(), values);
	}

	@Override
	public HealthInfo findHealthInfoById(Long id) {
		return this.healthInfoDao.get(id);
	}

}
