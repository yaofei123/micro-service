package com.ehaoyao.ordercenter.web.orders.feigns;

import com.ehaoyao.ordercenter.web.orders.feigns.dto.OrderDTO;
import com.ehaoyao.ordercenter.web.orders.feigns.fallback.OrderFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order-api",fallback = OrderFallback.class)
public interface OrderFeign {

    @RequestMapping("/v1/orders")
    public OrderDTO getOrder() throws RuntimeException;
}
