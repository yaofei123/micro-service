/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.framework.request;

import java.io.Serializable;

/**
 * @Description RESTful - 请求值对象
 * @author
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
public class PageRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 每页的记录数
	 */
	private int pageSize = 10;
	
	/**
	 * 当前的页码数
	 */
	private int pageNo = 1;
	
	/**
	 * 排序字段名称,多个以","分割
	 */
	private String sortField;
	
	/**
	 * 排序
	 */
	private String sort = "ASC";
	
	/**
	 * 每页的记录数
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 当前页码
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	/**
	 * @return
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 获取当前页的开始索引数(后台)
	 * @return
	 */
	public int getStartRecord(){
		int startRecord = (getPageNo()-1) * getPageSize();
		if (startRecord < 0) {
			startRecord = 0;
		}
		return startRecord;
	}
	
}
