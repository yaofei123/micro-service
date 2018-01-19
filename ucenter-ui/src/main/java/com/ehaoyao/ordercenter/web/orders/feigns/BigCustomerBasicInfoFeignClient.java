/*
 * Copyright (C) 2017  , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.web.orders.feigns;

import com.ehaoyao.ordercenter.common.response.PageResponse;
import com.ehaoyao.ordercenter.web.orders.feigns.dto.BigCustomerBasicInfoDTO;
import com.ehaoyao.ordercenter.web.orders.feigns.fallback.BigCustomerBasicInfoFallback;
import com.ehaoyao.ordercenter.web.orders.vo.BigCustomerBasicInfoQueryRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description
 * @author
 * @Date 2017-12-25 14:26
 * @Modified by:
 **/
@FeignClient( url = "http://localhost:8083" ,name = "order-api",fallback = BigCustomerBasicInfoFallback.class)
public interface BigCustomerBasicInfoFeignClient {
    /**
     * 分页响应
     * @return
     */
    @RequestMapping(value = "/v1/bigcustomerbasicinfo/list", method = RequestMethod.GET)
    public ResponseEntity<PageResponse<BigCustomerBasicInfoDTO>> pageList(BigCustomerBasicInfoQueryRequest queryRequest ) throws RuntimeException;

    /**
     * 分页响应
     * @return
     */
    @RequestMapping(value = "/v1/bigcustomerbasicinfo/list", method = RequestMethod.GET)
    public ResponseEntity<PageResponse<BigCustomerBasicInfoDTO>> pageList(@RequestParam Map<String,Object> params) throws RuntimeException;

    /**
     * 添加资源
     * @param obj
     * @return
     */
    @RequestMapping(value = "/v1/bigcustomerbasicinfo",method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BigCustomerBasicInfoDTO> save(@RequestBody BigCustomerBasicInfoDTO obj) throws RuntimeException;

    /**
     * 更新资源
     * @param params 资源对象
     * @return
     */
    @RequestMapping(value = "/v1/bigcustomerbasicinfo/{id}" , method = RequestMethod.PUT ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BigCustomerBasicInfoDTO> update(@PathVariable("id") Integer id , @RequestBody BigCustomerBasicInfoDTO params) throws RuntimeException;

    /**
     *  删除资源
     * @param id 资源对象ID
     * @return
     */
    @RequestMapping(value = "/v1/bigcustomerbasicinfo/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<BigCustomerBasicInfoDTO> deleteById(@PathVariable("id") Integer id ) throws RuntimeException;

    /**
     *  获取单个资源
     * @param id 资源对象主键标识
     * @return
     */
    @RequestMapping(value = "/v1/bigcustomerbasicinfo/{id}" , method = RequestMethod.GET)
    public ResponseEntity<BigCustomerBasicInfoDTO> getById(@PathVariable("id") Integer id ) throws RuntimeException;
}
