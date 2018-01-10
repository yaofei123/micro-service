package com.ehaoyao.ordercenter.web.orders.vo;

import java.io.Serializable;

public class OrderVo implements Serializable{
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
