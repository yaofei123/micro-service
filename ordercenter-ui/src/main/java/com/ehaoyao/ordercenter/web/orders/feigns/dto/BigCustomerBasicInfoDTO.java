/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.web.orders.feigns.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 大客户基本资料管理
 * @author
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
public class BigCustomerBasicInfoDTO implements Serializable {
    private Integer id;
    //客户编码
    private String customerNo;

    //客户名称
    private String customerName;

    //联系方式
    private String customerContact;

    //省份
    private String province;

    //市
    private String city;

    //区县
    private String county;

    //收货详细地址
    private String shippingAddress;

    //创建人
    private String createBy;

    //创建时间
    private Date createDate;

    //更新时间
    private Date updateDate;

    //更新人
    private String updateBy;

    //备注
    private String remarks;

    //删除标记
    private String delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取客户编码
     *
     * @return customer_no - 客户编码
     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     * 设置客户编码
     *
     * @param customerNo 客户编码
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim ( );
    }

    /**
     * 获取客户名称
     *
     * @return customer_name - 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置客户名称
     *
     * @param customerName 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim ( );
    }

    /**
     * 获取联系方式
     *
     * @return customer_contact - 联系方式
     */
    public String getCustomerContact() {
        return customerContact;
    }

    /**
     * 设置联系方式
     *
     * @param customerContact 联系方式
     */
    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact == null ? null : customerContact.trim ( );
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim ( );
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim ( );
    }

    /**
     * 获取区县
     *
     * @return county - 区县
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置区县
     *
     * @param county 区县
     */
    public void setCounty(String county) {
        this.county = county == null ? null : county.trim ( );
    }

    /**
     * 获取收货详细地址
     *
     * @return shipping_address - 收货详细地址
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * 设置收货详细地址
     *
     * @param shippingAddress 收货详细地址
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim ( );
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim ( );
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取更新人
     *
     * @return update_by - 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim ( );
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim ( );
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim ( );
    }

}
