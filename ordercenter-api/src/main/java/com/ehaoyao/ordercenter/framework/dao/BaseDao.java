/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.framework.dao;

import com.ehaoyao.ordercenter.framework.util.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 抽象BaseMapper
 * @Author cuiyaosheng
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
@Mapper
public interface BaseDao<T> {

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    T selectById(Serializable id);

    /**
     * 查询单条记录
     *
     * @param entity
     * @return
     */
    T selectOne(@Param("item") T entity);

    /**
     * 查询记录集合
     *
     * @param entity
     * @return
     */
    List<?> selectList(@Param("item") T entity);

    /**
     * 分页查询
     *
     * @param obj
     * @param pagination
     * @return
     */
    List<T> selectPage(@Param("item") T obj, @Param("pagination") Pagination pagination);

    /**
     * 通用的保存方法
     *
     * @param entity
     */
    void save(@Param("item") T entity);

    /**
     * 批量保存
     *
     * @param list
     */
    int batchSave(List<?> list);

    /**
     * 通用的修改方法
     *
     * @param entity
     */
    int update(@Param("item") T entity);

    /**
     * 批量更新
     *
     * @param list
     * @return
     */
    int batchUpdate(List<?> list);

    /**
     * 删除方法
     *
     * @param id
     */
    int delById(Serializable id);

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    int delList(List<?> list);

    /**
     * 批量删除方法
     *
     * @param ids
     */
    int delArray(int[] ids);

    /**
     * 统计查询
     *
     * @param params 查询参数
     * @return 总记录条数
     */
    int count(@Param("item") T params);
}
