package com.tohours.hbj.web.action;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.util.Assert;

import com.tohours.hbj.entity.HealthInfo;

@EqualsAndHashCode(callSuper=false)
@Namespace("/")
public @Data class UserSearchAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sear;
	private Long id;
	private HealthInfo info;
	
	@Action("search")
	public String searchIndex(){
		return "search_index";
	}
	
	@SuppressWarnings("unchecked")
	@Action("searchResultList")
	public String searchResultList(){
		Assert.notNull(sear);
		key.put("cardId", sear);
		page = super.getSearchService().searchHealthInfo(key, super.pager);
		return "search_result_list";
	}
	
	@Action("healthInfoDetail")
	public String healthInfoDetail(){
		Assert.notNull(id);
		info = super.getSearchService().findHealthInfoById(id);
		return "search_detail_info";
	}
	
}
