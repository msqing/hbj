package com.tohours.hbj.service;

import java.util.Map;

import org.springside.modules.orm.Page;

import com.tohours.hbj.entity.HealthInfo;

public interface SearchService {
	
	/**
	 * 查找体质监测数据
	 * @param key
	 * @param page
	 * @return
	 */
	Page<HealthInfo> searchHealthInfo(Map<String, Object> key, Page<HealthInfo> page);

	/**
	 * 通过id查询体质监测数据
	 * @param id
	 * @return
	 */
	HealthInfo findHealthInfoById(Long id);
}
