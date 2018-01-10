/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.api.order.dao;

import com.ehaoyao.ordercenter.api.order.dto.request.BigCustomerBasicInfoQueryRequest;
import com.ehaoyao.ordercenter.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 大客户基本资料管理
 * @author
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
@Mapper
public interface BigCustomerBasicInfoEntityDao extends BaseDao<BigCustomerBasicInfoQueryRequest> {
}
