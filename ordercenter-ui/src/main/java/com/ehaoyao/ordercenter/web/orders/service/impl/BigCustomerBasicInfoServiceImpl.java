/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.web.orders.service.impl;

import com.ehaoyao.ordercenter.common.response.PageResponse;
import com.ehaoyao.ordercenter.web.orders.feigns.BigCustomerBasicInfoFeignClient;
import com.ehaoyao.ordercenter.web.orders.feigns.dto.BigCustomerBasicInfoDTO;
import com.ehaoyao.ordercenter.web.orders.service.BigCustomerBasicInfoService;
import com.ehaoyao.ordercenter.web.orders.vo.BigCustomerBasicInfoQueryRequest;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.ParameterMapUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @author
 * @Date 2017-12-25 15:45
 * @Modified by:
 **/
@Service
public class BigCustomerBasicInfoServiceImpl implements BigCustomerBasicInfoService {
    @Autowired
    private BigCustomerBasicInfoFeignClient bigCustomerBasicInfoFeignClient;


    @Override
    public ResponseEntity <PageResponse <BigCustomerBasicInfoDTO>> findPageList(Page <BigCustomerBasicInfoDTO> page, BigCustomerBasicInfoQueryRequest queryRequest) throws RuntimeException {

        Map <String, Object> params = ParameterMapUtil.transBean2Map ( queryRequest );
        params.putAll ( ParameterMapUtil.transBean2Map ( page ) );
        return bigCustomerBasicInfoFeignClient.pageList ( params );
    }

    @Override
    public BigCustomerBasicInfoDTO getById(Integer id) throws RuntimeException {
        ResponseEntity <BigCustomerBasicInfoDTO> responseEntity = bigCustomerBasicInfoFeignClient.getById ( id );
        if (null != responseEntity) {
            HttpStatus httpStatus = responseEntity.getStatusCode ( );
            if (HttpStatus.OK.compareTo ( httpStatus ) == 0) {
                return responseEntity.getBody ( );
            }
        }
        return null;
    }

    @Override
    public BigCustomerBasicInfoDTO saveOrUpdate(BigCustomerBasicInfoDTO request) throws RuntimeException {
        Integer id = request.getId ( );
        if (null != id) {// 更新操作
            ResponseEntity <BigCustomerBasicInfoDTO> responseEntity = bigCustomerBasicInfoFeignClient.getById ( id );
            if (null != responseEntity) {
                HttpStatus httpStatus = responseEntity.getStatusCode ( );
                if (HttpStatus.OK.compareTo ( httpStatus ) == 0) {
                    BigCustomerBasicInfoDTO bigCustomerBasicInfoDTO = responseEntity.getBody ( );
                    try {
//                        BeanUtils.copyProperties ( bigCustomerBasicInfoDTO, request );
                        PropertyUtils.copyProperties ( bigCustomerBasicInfoDTO, request );
                    } catch (Exception e) {
                        e.printStackTrace ( );
                    }
                    bigCustomerBasicInfoFeignClient.update ( id, bigCustomerBasicInfoDTO );
                }
                // 错误处理
            }

        } else {
            ResponseEntity <BigCustomerBasicInfoDTO> responseEntity = bigCustomerBasicInfoFeignClient.save ( request );
            if (null != responseEntity) {
                HttpStatus httpStatus = responseEntity.getStatusCode ( );
                if (HttpStatus.CREATED.compareTo ( httpStatus ) == 0) {
                    return responseEntity.getBody ( );
                }
                // 错误处理
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) throws RuntimeException {
        ResponseEntity <BigCustomerBasicInfoDTO> responseEntity = bigCustomerBasicInfoFeignClient.deleteById ( id );
        if (null != responseEntity) {
            HttpStatus httpStatus = responseEntity.getStatusCode ( );
            if (HttpStatus.NO_CONTENT.compareTo ( httpStatus ) == 0) {
                return true;
            }
        }
        return false;
    }
}
