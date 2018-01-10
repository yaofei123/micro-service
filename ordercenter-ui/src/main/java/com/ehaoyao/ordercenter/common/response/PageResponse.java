/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.common.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 分页响应值对象
 * @Author cuiyaosheng
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
public class PageResponse<T>  extends RestResponse implements Serializable{

	/**
	 * 
	 */
	private int totalCount = 0;
	/**
	 * 
	 */
	private int pageNo = 1;
	/**
	 * 
	 */
	private int pageSize = 20;
	
	/**
	 * 
	 */
	private List<T> data = new ArrayList<T>();
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * 设置总记录数
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获取分页页码
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * 设置分页页码
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * 设置每页多少记录
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 设置每页多少记录
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
