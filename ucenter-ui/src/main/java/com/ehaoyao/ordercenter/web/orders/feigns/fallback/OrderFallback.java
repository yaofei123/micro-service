package com.ehaoyao.ordercenter.web.orders.feigns.fallback;

import com.ehaoyao.ordercenter.web.orders.feigns.OrderFeign;
import com.ehaoyao.ordercenter.web.orders.feigns.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderFallback implements OrderFeign {
    @Override
    public OrderDTO getOrder() throws RuntimeException{
        OrderDTO orderInfo = new OrderDTO();
        orderInfo.setOrderNo("无");
        orderInfo.setUserName("无");
        return orderInfo;
    }
}
