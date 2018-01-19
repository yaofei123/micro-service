/*
 * Copyright (C) 2017  , All Rights Reserved.
 */
package com.ehaoyao.ucenter.framework.base.controller;

import com.ehaoyao.ucenter.framework.base.entity.BaseEntity;
import com.ehaoyao.ucenter.framework.response.PageResponse;
import com.ehaoyao.ucenter.framework.response.RestBuilder;
import com.ehaoyao.ucenter.framework.base.service.BaseService;
import com.ehaoyao.ucenter.framework.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 抽象Controller
 * @author
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
public abstract class BaseController<T extends BaseEntity> {
    /**
     * 日志
     */
    Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    BaseService<T> baseService;

    /**
     * 分页响应
     *
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public ResponseEntity pageList(HttpServletRequest request, T params, Pagination pagination) {
        PageResponse<T> pageResponse = baseService.pageList(params, pagination);
        return new RestBuilder<T>().restBuilder(request,pageResponse, HttpStatus.OK);
    }

    /**
     * 添加资源
     *
     * @param obj
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> save(@RequestBody T obj) {
        T t = baseService.save(obj);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    /**
     * 更新资源
     *
     * @param params 资源对象
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> update(@PathVariable("id") Integer id, @RequestBody T params) {
        T t = baseService.getById(id);
        if (null == t) {
            return new ResponseEntity<>(t, HttpStatus.NOT_FOUND);
        }
        BaseEntity baseEntity = (BaseEntity) params;
        baseEntity.setId(id);
        t = baseService.update(id, params);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    /**
     * 删除资源
     *
     * @param id 资源对象标识
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<T> deleteById(@PathVariable("id") Integer id) {
        T t = baseService.getById(id);
        if (null == t) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        baseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 获取单个资源
     *
     * @param id 资源对象主键标识
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<T> getById(@PathVariable("id") Integer id) {
        T t = baseService.getById(id);
        if (null == t) {
            return new ResponseEntity<>(t, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
