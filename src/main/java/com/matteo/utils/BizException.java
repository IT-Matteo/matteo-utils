package com.matteo.utils;


/**
 * 业务错误处理类
 */
public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

}

