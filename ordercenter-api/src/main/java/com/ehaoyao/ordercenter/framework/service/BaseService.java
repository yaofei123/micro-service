/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.framework.service;


import com.ehaoyao.ordercenter.framework.dao.BaseDao;
import com.ehaoyao.ordercenter.framework.exception.ExceptionConstants;
import com.ehaoyao.ordercenter.framework.response.PageResponse;
import com.ehaoyao.ordercenter.framework.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description 抽象Base服务
 * @author
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
public abstract class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    /**
     * 分页查询资源
     *
     * @return
     */
    public PageResponse<T> pageList(T params, Pagination pagination) {
        if (null == pagination || null == params) {
            PageResponse<T> response = new PageResponse<>();
            response.setPageSize(pagination.getTotalPage());
            response.setPageNo(pagination.getPage());
            response.setCode(ExceptionConstants.STATUS_CODE_PAGE_EXCEPTION);
            response.setStatus(ExceptionConstants.FAILURE);
            response.setMessage(ExceptionConstants.STATUS_CODE_PAGE_EXCEPTION_MESSAGE);
            return response;
        }

        List<T> result = baseDao.selectPage(params, pagination);
        PageResponse<T> response = new PageResponse<>();
        response.setPageSize(pagination.getRows());
        response.setPageNo(pagination.getPage());
        response.setTotalCount(pagination.getTotal());
        response.setData(result);
        return response;
    }

    /**
     * 获取单个资源
     *
     * @param id
     * @return
     */
    public T getById(Integer id) {
        return baseDao.selectById(id);
    }

    /**
     * 添加资源
     *
     * @param params
     * @return
     */
    public T save(T params) {
        baseDao.save(params);
        return params;
    }

    /**
     * 更新资源
     *
     * @param params 资源对象
     * @return
     */
    public T update(Integer id, T params) {
        baseDao.update(params);
        return baseDao.selectById(id);
    }

    /**
     * 删除资源
     *
     * @param id
     */
    public void deleteById(Integer id) {
        baseDao.delById(id);
    }

}
