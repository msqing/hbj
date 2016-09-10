package com.tohours.hbj.service;

import java.util.Map;

import org.springside.modules.orm.Page;

import com.tohours.hbj.entity.EffectExamine;
import com.tohours.hbj.entity.EffectInfo;
import com.tohours.hbj.entity.EffectPreExamine;
import com.tohours.hbj.entity.SaveExamine;
import com.tohours.hbj.entity.SaveInfo;
import com.tohours.hbj.entity.SavePreExamine;
import com.tohours.hbj.entity.SewageInfo;


public interface NewsService {
	
	/**
	 * 查找建设项目环境影响评价受理信息公示的告知事项
	 * @param key
	 * @param page
	 * @return
	 */
	Page<EffectInfo> searchEffectInfo(Map<String, Object> key,Page<EffectInfo> page);
	
	/**
	 * 查找建设项目环境影响评价拟审批公示的告知事项
	 * @param key
	 * @param page
	 * @return
	 */
	Page<EffectPreExamine> searchEffectPreExamine(Map<String, Object> key,Page<EffectPreExamine> page);
	/**
	 * 查找建设项目环境影响评价审批决定公告的告知事项
	 * @param key
	 * @param page
	 * @return
	 */
	Page<EffectExamine> searchEffectExamine(Map<String, Object> key,Page<EffectExamine> page);
	
	/**
	 * 查找建设项目环境影响评价受理信息公示的告知事项
	 * @param key
	 * @param page
	 * @return
	 */
	Page<SaveInfo> searchSaveInfo(Map<String, Object> key,Page<SaveInfo> page);
	
	/**
	 * 查找建设项目环境影响评价拟审批公示的告知事项
	 * @param key
	 * @param page
	 * @return
	 */
	Page<SavePreExamine> searchSavePreExamine(Map<String, Object> key,Page<SavePreExamine> page);
	/**
	 * 查找建设项目环境影响评价审批决定公告的告知事项
	 * @param key
	 * @param page
	 * @return
	 */
	Page<SaveExamine> searchSaveExamine(Map<String, Object> key,Page<SaveExamine> page);
	
	/**
	 * 查找最新的污水处理数据
	 * @param key
	 * @param page
	 * @return
	 */
	Page<SewageInfo> searchSwage(Map<String, Object> key,Page<SewageInfo> page);
}
