/*
 * Copyright (C) 2017  , All Rights Reserved.
 */

package com.ehaoyao.ucenter.framework.base.entity;

import java.io.Serializable;

/**
 * @Description
 * @author
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
