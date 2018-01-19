<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%--
  ~ Copyright (C) 2017  , All Rights Reserved.
  --%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>大客户资料管理</title>

    <script type="text/javascript"
            src="${ctxStatic}/ordercenter-js/order/common/address.js"
    ></script>
    <script type="text/javascript" src="${ctxStatic}/ordercenter-js/ruleDeploy/customerBasicInfo.js"></script>


</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/orders/customerbasicinfo/">大客户资料</a>
    </li>
    <shiro:hasPermission name="orders:customerbasicinfo:edit">
        <li><a href="${ctx}/orders/customerbasicinfo/form">大客户添加</a>
        </li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm"
           modelAttribute="bigCustomerBasicInfoDTO"
           action="${ctx}/orders/customerbasicinfo/"
           method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden"
           value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden"
           value="${page.pageSize}"/>
    <label>客户名称：</label><form:input path="customerName"
                                    htmlEscape="false"
                                    maxlength="50"
                                    class="input-medium"/>
    &nbsp;&nbsp;
    <label>操作人 ：</label>
    <form:input path="updateBy" htmlEscape="false" maxlength="50" class="input-medium"/>
    &nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable"
       class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>客户ID</th>
        <th>客户名称</th>
        <th>联系方式</th>
        <th>省</th>
        <th>市</th>
        <th>区</th>
        <th>收货地址</th>
        <th>操作人</th>
        <th>操作时间</th>
        <shiro:hasPermission name="orders:customerbasicinfo:edit">
        <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="bigCustomer">
        <tr>
            <td>${bigCustomer.customerNo}</td>
            <td>${bigCustomer.customerName}</td>
            <td>${bigCustomer.customerContact}</td>
            <td>${bigCustomer.province}</td>
            <td>${bigCustomer.city}</td>
            <td>${bigCustomer.county}</td>
            <td>${bigCustomer.shippingAddress}</td>
            <td>${bigCustomer.updateBy}</td>
            <td>${bigCustomer.updateDate}</td>
                <shiro:hasPermission name="orders:customerbasicinfo:edit">
            <td>
                <a href="${ctx}/orders/customerbasicinfo/form?id=${bigCustomer.id}">修改</a>
                <a href="${ctx}/orders/customerbasicinfo/delete?id=${bigCustomer.id}"
                   onclick="return confirmx('确认要删除该客户吗？', this.href)">删除</a>
            </td>
                </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
