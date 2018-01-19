<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>大客户资料管理</title>

    <script type="text/javascript" src="${ctxStatic}/ordercenter-js/ruleDeploy/customerBasicInfo.js"></script>
    <script type="text/javascript" src="${ctxStatic}/ordercenter-js/order/common/address.js"></script>

</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/orders/customerbasicinfo/">大客戶列表</a></li>
    <li class="active">
        <a href="${ctx}/orders/customerbasicinfo/form?id=${bigCustomerBasicInfoDTO.id}">
            大客戶
            <shiro:hasPermission name="orders:customerbasicinfo:edit">
                ${not empty bigCustomerBasicInfoDTO.id?'修改':'添加'}
                </shiro:hasPermission>
            <shiro:lacksPermission name="orders:customerbasicinfo:view">
                查看
            </shiro:lacksPermission>
        </a>
    </li>
</ul><br/>
<form:form id="form:inputForm" modelAttribute="bigCustomerBasicInfoDTO" action="${ctx}/orders/customerbasicinfo/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">客户编号：</label>
        <div class="controls">
            <form:input  type="text" path="customerNo"   htmlEscape="false" maxlength="100"
                    class="form:input-medium"  />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">客户名称：</label>
        <div class="controls">
            <form:input  type="text" path="customerName"    htmlEscape="false" maxlength="100"
                    class="form:input-medium"  />
            <span class="help-inline" id="errorBigCustomerName"><font color="red">*</font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">联系方式：</label>
        <div class="controls">
            <form:input  type="text" path="customerContact"    htmlEscape="false" maxlength="100"
                    class="form:input-medium"  />
            <span class="help-inline" id="errorMobile"><font color="red"></font> </span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">省：</label>
        <div class="controls">
            <label>
                <form:select path="province" id="provinceId" itemValue="province" itemLabel="province"  style="width:100px"  class="form:input selectTd" onchange="setCity()" data-bvalidator="required,required"></form:select>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">市：</label>
        <div class="controls">
            <label>
                <form:select path="city" itemValue="city" itemLabel="city"  id="cityId"  style="width:100px"  class="form:input selectTd" onchange="setDistrict()" data-bvalidator="required,required"></form:select>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">区/县：</label>
        <div class="controls">
            <label>
                <form:select path="county" itemValue="county" itemLabel="county" id="districtId" style="width:100px"  class="form:input selectTd"  data-bvalidator="required,required"></form:select>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">详细地址：</label>
        <div class="controls">
            <form:textarea path="shippingAddress" style="width:200px;height:80px;" ></form:textarea>
            <!-- <span class="help-inline"><font color="red">*</font> </span> -->
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:input  type="text" path="remarks"    htmlEscape="false" maxlength="100"
                    class="form:input-medium"  />
        </div>
    </div>
    <div class="form-actions">
        <shiro:hasPermission name="orders:customerbasicinfo:edit">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
        </shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>