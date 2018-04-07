package com.matteo.api;

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
 * 2018/1/29      matteo                 Created
 */
public class ErrorCode {

    private String code;
    private String message;

    public ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public interface ApiError {
        ErrorCode SYSTEM_ERROR = new ErrorCode("600000", "系统错误~请联系管理员");
        ErrorCode PARAMETER_VALIDATION_ERROR = new ErrorCode("600001", "参数验证失败");
        ErrorCode NO_RESPONSE_STATUS_ERROR = new ErrorCode("600002", "调用RPC接口无响应状态码");
    }
}
