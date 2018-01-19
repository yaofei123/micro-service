/*
 * Copyright (C) 2017  , All Rights Reserved.
 */
package com.ehaoyao.ucenter.api.order.dao;

import com.ehaoyao.ucenter.api.order.dto.request.BigCustomerBasicInfoQueryRequest;
import com.ehaoyao.ucenter.framework.base.dao.BaseDao;
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
