/*
 * Copyright (C) 2017  , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.web.orders.feigns.dto;

public class OrderDTO {
    String orderNo;
    String userName;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
