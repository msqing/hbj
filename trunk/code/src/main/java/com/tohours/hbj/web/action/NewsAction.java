package com.tohours.hbj.web.action;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@EqualsAndHashCode(callSuper=false)
@Namespace("/")
public @Data class NewsAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Action("effectInfoList")
	public String effectInfoList(){
		page = super.getNewsService().searchEffectInfo(key,super.pager);
		return "notice_effect_info_list";
	}
	
	@SuppressWarnings("unchecked")
	@Action("effectPreExamineList")
	public String effectPreExamineList(){
		page = super.getNewsService().searchEffectPreExamine(key,super.pager);
		return "notice_effect_pre_examine_list";
	}
	
	@SuppressWarnings("unchecked")
	@Action("effectExamineList")
	public String effectExamineList(){
		page = super.getNewsService().searchEffectExamine(key,super.pager);
		return "notice_effect_examine_list";
	}
	
	@SuppressWarnings("unchecked")
	@Action("saveInfoList")
	public String saveInfoList(){
		page = super.getNewsService().searchSaveInfo(key,super.pager);
		return "notice_save_info_list";
	}
	
	@SuppressWarnings("unchecked")
	@Action("savePreExamineList")
	public String savePreExamineList(){
		page = super.getNewsService().searchSavePreExamine(key,super.pager);
		return "notice_save_pre_examine_list";
	}
	
	@SuppressWarnings("unchecked")
	@Action("saveExamineList")
	public String saveExamineList(){
		page = super.getNewsService().searchSaveExamine(key,super.pager);
		return "notice_save_examine_list";
	}
	
	@SuppressWarnings("unchecked")
	@Action("swageTable")
	public String swageTable(){
		page = super.getNewsService().searchSwage(key,super.pager);
		return "notice_swage";
	}
	
	@Action("effectInfo")
	public String effectInfo(){
		return "notice_effect_info";
	}
	@Action("effectPreExamine")
	public String effectPreExamine(){
		return "notice_effect_pre_examine";
	}
	@Action("effectExamine")
	public String effectExamine(){
		return "notice_effect_examine";
	}
	
	@Action("saveInfo")
	public String saveInfo(){
		return "notice_save_info";
	}
	@Action("savePreExamine")
	public String savePreExamine(){
		return "notice_save_pre_examine";
	}
	@Action("saveExamine")
	public String saveExamine(){
		return "notice_save_examine";
	}
	
	@Action("noticeIndex")
	public String noticeIndex(){
		return "notice_index";
	}
	
}
