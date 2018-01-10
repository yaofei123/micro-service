package com.ehaoyao.ordercenter.web.orders.controller;

import com.ehaoyao.ordercenter.web.orders.feigns.OrderFeign;
import com.ehaoyao.ordercenter.web.orders.feigns.dto.OrderDTO;
import com.ehaoyao.ordercenter.web.orders.vo.OrderVo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    @Autowired
    OrderFeign orderFeign;

    /**
     * 测试
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
    public String thymeleaf(Model model) throws Exception {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo("gtest");
        orderVo.setUserName("test");
        model.addAttribute("orderVo", orderVo);
        return "modules/orders/thymeleaf";
    }

    @RequestMapping(value = "/jsp", method = RequestMethod.GET)
    public String jsp(Model model) throws Exception {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo("gtest");
        orderVo.setUserName("test");
        model.addAttribute("orderVo", orderVo);
        return "modules/test/order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(Model model) throws Exception {
        OrderDTO orderDTO = orderFeign.getOrder();
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(orderVo,orderDTO);
        model.addAttribute("orderVo", orderVo);
        return "modules/orders/order";
    }
}
