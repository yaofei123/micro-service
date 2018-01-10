/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.framework.response;

import java.util.List;

/**
 * @Description RESTful - API 批量处理响应
 * @author
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
public class RestBatchResponse<T> extends RestResponse {
    private String _key;

    /**
     * @param code
     * @param status
     * @param message
     * @param messages
     */
    public RestBatchResponse(Integer code, String status, String message, List<T> messages) {
        super(code, status, message);
        this.messages = messages;
    }

    private List<T> messages;

    public List<T> getMessages() {
        return messages;
    }

    public void setMessages(List<T> messages) {
        this.messages = messages;
    }
}
