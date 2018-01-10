/*
 * Copyright (C) 2017 北京好药师大药房连锁有限公司(www.ehaoyao.com) , All Rights Reserved.
 */
package com.ehaoyao.ordercenter.common.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @Description RESTful - API 响应定义
 * @Author cuiyaosheng
 * @Date 2017-12-23 10:32
 * @Modified by:
 **/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RestResponse<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public RestResponse() {
    }

    public RestResponse(String status) {
        this.status = status;
    }

    public RestResponse(Integer code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public RestResponse(Integer code, String message, String status, String _key) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
		this._key = _key;
	}

	/**
     *
     */
    private Integer code;
    /**
     *
     */
    private String message;
    /**
     *
     */
    private String status;
    /**
     * 批量新增 必须返回的属性（其他情况可以忽略）
     */
    private String _key;

    /**
     * 数据体
     */
    private T body;

    public Integer getCode() {
        return code;
    }

    public String get_key() {
		return _key;
	}

	public void set_key(String _key) {
		this._key = _key;
	}

	public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
