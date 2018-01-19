/*
 * Copyright (C) 2017  , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.web.orders.service;

import com.ehaoyao.ordercenter.common.response.PageResponse;
import com.ehaoyao.ordercenter.web.orders.feigns.dto.BigCustomerBasicInfoDTO;
import com.ehaoyao.ordercenter.web.orders.vo.BigCustomerBasicInfoQueryRequest;
import com.thinkgem.jeesite.common.persistence.Page;
import org.springframework.http.ResponseEntity;

/**
 * @Description
 * @author
 * @Date 2017-12-25 15:45
 * @Modified by:
 **/
public interface BigCustomerBasicInfoService {
    ResponseEntity <PageResponse <BigCustomerBasicInfoDTO>> findPageList(Page <BigCustomerBasicInfoDTO> page, BigCustomerBasicInfoQueryRequest queryRequest) throws RuntimeException;

    BigCustomerBasicInfoDTO getById(Integer id) throws RuntimeException;

    BigCustomerBasicInfoDTO saveOrUpdate(BigCustomerBasicInfoDTO request) throws RuntimeException;

    boolean deleteById(Integer id) throws RuntimeException;
}
