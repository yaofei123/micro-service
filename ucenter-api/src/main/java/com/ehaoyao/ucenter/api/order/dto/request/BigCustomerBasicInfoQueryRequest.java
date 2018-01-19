package com.ehaoyao.ucenter.api.order.dto.request;

import com.ehaoyao.ucenter.api.order.entity.BigCustomerBasicInfoEntity;

import java.util.Date;

public class BigCustomerBasicInfoQueryRequest extends BigCustomerBasicInfoEntity {

    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;

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
