package com.tohours.hbj.constants;

import java.util.HashMap;
import java.util.Map;


public class Constants {

	//附件相关
	private static final Long FILE_UPLOAD_SIZE = 200 * 1024 * 1024L;
	private static final Long FILE_UPLOAD_IMAGE_SIZE = 2 * 1024 * 1024L;
	private static final String FILE_UPLOAD_IMAGE_TYPE = "jpg,jpeg,gif,png";
	private static final String FILE_UPLOAD_TYPE = "jpg,jpeg,gif,png,doc,rar,xls,docs,xlsx,mp4,avi,flv,mpeg,wmv";
	public static Long getFileUploadSize(){
		return FILE_UPLOAD_SIZE;
	}
	public static Long getFileUploadImageSize(){
		return FILE_UPLOAD_IMAGE_SIZE;
	}
	public static String getFileUploadImageType(){
		return FILE_UPLOAD_IMAGE_TYPE;
	}
	public static String getFileUploadType(){
		return FILE_UPLOAD_TYPE;
	}
	
	private static final String[] PARENT_CATALOG = { "政府机构", "餐饮美食", "健康医疗",
			"公共服务", "教育机构", "文化娱乐", "体育健身", "出行游玩"};

	public static boolean isParentCatalog(String catalog){
		for(String cata : PARENT_CATALOG){
			if(cata.equals(catalog)){
				return true;
			}
		}
		return false;
	}
	
	private static final Map<String, String> SUB_TYPE_MAP = new HashMap<String, String>();
	static{
		SUB_TYPE_MAP.put("奉贤特色餐饮", "奉贤特色餐饮");
		SUB_TYPE_MAP.put("长途汽车站", "长途汽车站");
		SUB_TYPE_MAP.put("旅行社", "旅行社");
		SUB_TYPE_MAP.put("特色景点", "特色景点");
		SUB_TYPE_MAP.put("菜场、农贸市场", "菜场、农贸市场");
		SUB_TYPE_MAP.put("敬老院", "敬老院");
		SUB_TYPE_MAP.put("邮政", "邮政");
		SUB_TYPE_MAP.put("中国石化加油站", "中国石化加油站");
		SUB_TYPE_MAP.put("中国石油加油站", "中国石油加油站");
		SUB_TYPE_MAP.put("公立医院", "公立医院");
		SUB_TYPE_MAP.put("社区卫生服务中心", "社区卫生服务中心");
		SUB_TYPE_MAP.put("药房", "药房");
		SUB_TYPE_MAP.put("初中", "初中");
		SUB_TYPE_MAP.put("大学", "大学");
		SUB_TYPE_MAP.put("高中/中专", "中专");
		SUB_TYPE_MAP.put("其他教育", "其他教育");
		SUB_TYPE_MAP.put("小学", "小学");
		SUB_TYPE_MAP.put("幼儿园", "幼儿园");
		SUB_TYPE_MAP.put("保险", "保险");
		SUB_TYPE_MAP.put("银行", "银行");
		SUB_TYPE_MAP.put("证券", "证券");
		SUB_TYPE_MAP.put("体育馆", "体育馆");
		SUB_TYPE_MAP.put("电信营业厅", "电信营业厅");
		SUB_TYPE_MAP.put("东方有线", "东方有线");
		SUB_TYPE_MAP.put("联通营业厅", "联通营业厅");
		SUB_TYPE_MAP.put("移动营业厅", "移动营业厅");
		SUB_TYPE_MAP.put("博物馆", "博物馆");
		SUB_TYPE_MAP.put("档案馆", "档案馆");
		SUB_TYPE_MAP.put("电影院", "电影院");
		SUB_TYPE_MAP.put("社区文化中心", "社区文化中心");
		SUB_TYPE_MAP.put("图书馆", "图书馆");
		SUB_TYPE_MAP.put("文化馆", "文化馆");
		SUB_TYPE_MAP.put("派出所", "派出所");
		SUB_TYPE_MAP.put("社区事务受理中心", "社区事务受理中心");
		SUB_TYPE_MAP.put("镇、社区办事处", "镇、社区办事处");
		SUB_TYPE_MAP.put("政府职能部门", "政府职能部门");
	}
	public static boolean isSubType(String term){
		return SUB_TYPE_MAP.get(term) != null;
	}
	
	public static boolean isAdmin(String userId){
		return "0".equals(userId);
	}
	
	public static final String SESSION_USER_NAME = "userName";
	public static final String SESSION_USER_ID = "userId";
	public static final String SESSION_USER = "user";
	
}
