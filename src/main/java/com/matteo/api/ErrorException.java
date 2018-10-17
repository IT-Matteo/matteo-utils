package com.matteo.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.matteo.api.RestResponse.fail;


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
 * 2018/1/30      matteo                 Created
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ErrorException extends Exception {

    private String code;
    private ErrorCode errorCode;

    public ErrorException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.errorCode = errorCode;
    }

    public ErrorException(String code, ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.errorCode = errorCode;
    }

    public <T> RestResponse toResult() {
        return fail(this.code, this.errorCode);
    }

}
