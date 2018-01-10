/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.web.orders.feigns.fallback;

import com.ehaoyao.ordercenter.common.response.PageResponse;
import com.ehaoyao.ordercenter.web.orders.feigns.BigCustomerBasicInfoFeignClient;
import com.ehaoyao.ordercenter.web.orders.feigns.dto.BigCustomerBasicInfoDTO;
import com.ehaoyao.ordercenter.web.orders.vo.BigCustomerBasicInfoQueryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description 单个函数进行熔断
 * @author
 * @Date 2017-12-25 14:27
 * @Modified by:
 **/
@Service
public class BigCustomerBasicInfoFallback implements BigCustomerBasicInfoFeignClient {

    @Override
    public ResponseEntity<PageResponse<BigCustomerBasicInfoDTO>> pageList(BigCustomerBasicInfoQueryRequest queryRequest) throws RuntimeException {
        return null;
    }

    @Override
    public ResponseEntity<PageResponse<BigCustomerBasicInfoDTO>> pageList(Map<String, Object> params) throws RuntimeException {
        return new ResponseEntity<PageResponse<BigCustomerBasicInfoDTO>>(new PageResponse<BigCustomerBasicInfoDTO>(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BigCustomerBasicInfoDTO> save(BigCustomerBasicInfoDTO obj) throws RuntimeException {
        return null;
    }

    @Override
    public ResponseEntity<BigCustomerBasicInfoDTO> update(Integer id, BigCustomerBasicInfoDTO params) throws RuntimeException {
        return null;
    }

    @Override
    public ResponseEntity<BigCustomerBasicInfoDTO> deleteById(Integer id) throws RuntimeException {
        return null;
    }

    @Override
    public ResponseEntity<BigCustomerBasicInfoDTO> getById(Integer id) throws RuntimeException {
        return null;
    }
}
