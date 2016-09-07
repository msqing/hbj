package com.tohours.hbj.entity;


public class Pager<T> extends org.springside.modules.orm.Page<T> {
	
	// 起始记录数
	protected int offset = 0;
	
	//-- 构造函数 --//
	public Pager() {
	}

	public Pager(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getOffset() {
		return this.offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
		this.pageNo = this.offset/this.pageSize + 1;
	}
	
	/**
	 * 重写设置每页的记录数量.
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;
		this.pageNo = this.offset/this.pageSize + 1;
	}
}
