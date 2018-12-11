package com.matteo.api;

import lombok.Data;

import java.io.Serializable;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：it.search.controller.response
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/1/27      matteo                 Created
 */
@Data
public class RestResponse<T> implements Serializable {

    private static final String SUCCESS_CODE = "0";
    private static final String ERROR_CODE = "1";

    private String code;
    private T content;

    public static <T> RestResponse<T> ok() {
        return ok(null);
    }

    public static <T> RestResponse<T> ok(T result) {
        return new RestResponse<>(SUCCESS_CODE, result);
    }


    public static <T> RestResponse fail(ErrorCode errorCode) {
        return new RestResponse<>(ERROR_CODE, new ErrorMsg(errorCode.getCode(), errorCode.getMessage()));
    }

    public static <T> RestResponse fail(String msg) {
        return new RestResponse<>(ERROR_CODE,msg);
    }

    public static <T> RestResponse fail(String code, ErrorCode errorCode) {
        return new RestResponse<>(code, new ErrorMsg(errorCode.getCode(), errorCode.getMessage()));
    }

    public static <T> RestResponse fail(String code, String msg) {
        return new RestResponse<>(ERROR_CODE, new ErrorMsg(code, msg));
    }

    public RestResponse(String code, T content) {
        this.code = code;
        this.content = content;
    }

    public RestResponse() {
    }

    @Data
    public static class ErrorMsg {
        private String code;
        private String msg;

        public ErrorMsg(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}
