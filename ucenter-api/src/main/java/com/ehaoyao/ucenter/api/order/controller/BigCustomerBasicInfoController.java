/*
 * Copyright (C) 2017  , All Rights Reserved.
 */
package com.ehaoyao.ucenter.api.order.controller;

import com.ehaoyao.ucenter.api.order.dto.request.BigCustomerBasicInfoQueryRequest;
import com.ehaoyao.ucenter.api.order.service.IBigCustomerBasicInfoService;
import com.ehaoyao.ucenter.framework.base.controller.BaseController;
import com.ehaoyao.ucenter.framework.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Description 大客户基本资料管理
 * @author
 * @Modifier wls
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
@RestController
@RequestMapping(ConstantUtils.V1 + "/bigcustomerbasicinfo")
public class BigCustomerBasicInfoController extends BaseController<BigCustomerBasicInfoQueryRequest> {

    @Autowired
    private IBigCustomerBasicInfoService bigCustomerBasicInfoService;

    //TODO:具体业务可复写方法....
}
