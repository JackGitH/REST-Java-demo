package com.huobi.response;

import com.huobi.api.ApiException;

public class ApiResponse<T> {

    public String code;
    public String msg;
    public T data;

    public T checkAndReturn() {
        if ("0".equals(code)) {
            return data;
        }
        throw new ApiException(code, msg);
    }
}
