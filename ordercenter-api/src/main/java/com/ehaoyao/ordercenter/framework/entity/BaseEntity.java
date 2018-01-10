/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.framework.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author cuiyaosheng
 * @Date 2017-12-25 14:20
 * @Modified by:
 **/
public class BaseEntity implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
