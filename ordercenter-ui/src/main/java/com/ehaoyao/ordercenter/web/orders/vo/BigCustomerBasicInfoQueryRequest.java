/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.web.orders.vo;

import com.ehaoyao.ordercenter.common.request.PageRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author cuiyaosheng
 * @Date 2017-12-25 15:53
 * @Modified by:
 **/
public class BigCustomerBasicInfoQueryRequest extends PageRequest implements Serializable {
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 操作人
     */
    private String updateBy;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
