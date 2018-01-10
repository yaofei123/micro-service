/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.framework.response;

import com.ehaoyao.ordercenter.framework.util.LoggerUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 响应构建器
 * @author fei.yao
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
public class RestBuilder<T>{

  public ResponseEntity restBuilder(HttpServletRequest request, PageResponse<T> body, HttpStatus status) {
    request.setAttribute(LoggerUtils.LOGGER_RETURN,body);
    return new ResponseEntity<>(body, status);
  }
}
