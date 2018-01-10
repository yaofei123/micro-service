/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */

package com.ehaoyao.ordercenter.web.orders.controller;

import com.alibaba.fastjson.JSONObject;
import com.ehaoyao.ordercenter.common.response.PageResponse;
import com.ehaoyao.ordercenter.web.orders.feigns.dto.BigCustomerBasicInfoDTO;
import com.ehaoyao.ordercenter.web.orders.service.BigCustomerBasicInfoService;
import com.ehaoyao.ordercenter.web.orders.vo.BigCustomerBasicInfoQueryRequest;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author cuiyaosheng
 * @Date 2017-12-25 15:11
 * @Modified by:
 **/
@Controller
@RequestMapping(value = "${jeesite.adminPath}/orders/customerbasicinfo")
public class BigCustomerBasicInfoController extends BaseController {
    @Autowired
    BigCustomerBasicInfoService bigCustomerBasicInfoService;

    /**
     * 单个资源模型
     *
     * @param id
     * @return
     */
    @ModelAttribute
    public BigCustomerBasicInfoDTO get(@RequestParam(required=false) Integer id) {
        if (null != id) {
            return bigCustomerBasicInfoService.getById ( id );
        } else {
            return new BigCustomerBasicInfoDTO ( );
        }
    }

    @RequiresPermissions("orders:customerbasicinfo:view")
    @RequestMapping(value = {"list", ""})
    public String list(BigCustomerBasicInfoQueryRequest queryRequest,
                       HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            logger.info ( "【分页查询大客户资料】，请求信息：{}", JSONObject.toJSONString ( queryRequest ) );
            ResponseEntity <PageResponse <BigCustomerBasicInfoDTO>> page = bigCustomerBasicInfoService.findPageList ( new Page <BigCustomerBasicInfoDTO> ( request, response ), queryRequest );
            logger.info ( "【分页查询大客户资料】，返回信息：{}", JSONObject.toJSONString ( page.getBody ( ) ) );

            Page <BigCustomerBasicInfoDTO> bigCustomerBasicInfoDTOPage = new Page <BigCustomerBasicInfoDTO> ( );
            bigCustomerBasicInfoDTOPage.setCount ( page.getBody ( ).getTotalCount ( ) );
            bigCustomerBasicInfoDTOPage.setPageNo ( page.getBody ( ).getPageNo ( ) );
            bigCustomerBasicInfoDTOPage.setPageSize ( page.getBody ( ).getPageSize ( ) );
            bigCustomerBasicInfoDTOPage.setList ( page.getBody ( ).getData ( ) );

            model.addAttribute ( "bigCustomerBasicInfoDTO", queryRequest );
            model.addAttribute ( "page", bigCustomerBasicInfoDTOPage );

        } catch (Exception e) {
            e.printStackTrace ( );
            logger.error ( "初始化大客户资料页面出现异常：", e );
            addMessage ( model, "系统内部错误！" );
        }
        return "modules/rules/customerBasicInfoList";
    }

    /**
     * 保存单个资源
     *
     * @param bigCustomerBasicInfoDTO
     * @param request
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("orders:customerbasicinfo:edit")
    @RequestMapping(value = "save")
    public String saveOrUpdate(BigCustomerBasicInfoDTO bigCustomerBasicInfoDTO, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        logger.info ( "【新增大客戶資料】，請求信息：{}", JSONObject.toJSONString ( bigCustomerBasicInfoDTO ) );
        // 验证资源信息
        if (!beanValidator ( model, bigCustomerBasicInfoDTO )) {
            return form ( bigCustomerBasicInfoDTO, model );
        }

        User user = UserUtils.getUser ( );
        String userName = user.getName ( );
        if (null == bigCustomerBasicInfoDTO.getId ( )) {
            bigCustomerBasicInfoDTO.setCreateBy ( userName );
            bigCustomerBasicInfoDTO.setUpdateBy ( userName );
        } else {
            bigCustomerBasicInfoDTO.setUpdateBy ( userName );
        }

        try {

            bigCustomerBasicInfoService.saveOrUpdate ( bigCustomerBasicInfoDTO );
            addMessage ( redirectAttributes, "保存成功" );
            return "redirect:" + adminPath + "/orders/customerbasicinfo/";
        } catch (Exception e) {
            e.printStackTrace ();
            logger.error ( "保存或更新大客户资料,出现异常：", e );
            addMessage ( redirectAttributes, "保存失败," );
            return form ( bigCustomerBasicInfoDTO, model );
        }
    }


    /**
     * 删除资源
     *
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("orders:customerbasicinfo:edit")
    @RequestMapping(value = "delete")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        try {
            boolean isSuccess = bigCustomerBasicInfoService.deleteById ( id );
            String tipMsg = null;
            if (isSuccess) {
                tipMsg = "删除成功";
            } else {
                tipMsg = "删除失败";
            }
            addMessage ( redirectAttributes, tipMsg );
        } catch (Exception e) {
            logger.error ( "删除大客户资料,出现异常：", e );
            addMessage ( redirectAttributes, "系统内部异常." );
        }
        return "redirect:" + adminPath + "/orders/customerbasicinfo/";
    }


    /**
     * 表单自动填充
     *
     * @param bigCustomerBasicInfoDTO
     * @param model
     * @return
     */
    @RequiresPermissions("orders:customerbasicinfo:view")
    @RequestMapping(value = "form")
    public String form(BigCustomerBasicInfoDTO bigCustomerBasicInfoDTO, Model model) {
        model.addAttribute ( "bigCustomerBasicInfoDTO", bigCustomerBasicInfoDTO );
        return "modules/rules/customerBasicInfoForm";
    }
}
