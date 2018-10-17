package com.matteo.handler;

import com.matteo.api.ErrorException;
import com.matteo.api.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

import static com.matteo.api.ErrorCode.ApiError.SYSTEM_ERROR;
import static com.matteo.api.RestResponse.fail;

/**
 * *****************************************************************************
 * <p>
 * 系统名           ：全局异常处理器
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/4/30      matteo                 Created
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(value = {ErrorException.class})
    public RestResponse unknownException(Exception ex) {
        log.info("自定义异常:{}", ex);
        ErrorException e = (ErrorException) ex;
        return fail(e.getErrorCode().getMessage());
    }

    @ExceptionHandler(value = {BindException.class})
    public RestResponse bindException(BindException e) {
        log.info("参数验证失败异常:{}", e);
        return fail(e.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()).toString()
        );
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public RestResponse methodArgumentException(MethodArgumentNotValidException e) {
        log.info("参数验证失败异常:{}", e);
        return fail(
                e.getBindingResult().getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()).toString()
        );
    }


    @ExceptionHandler(value = {Exception.class})
    public RestResponse exception(Exception e) {
        log.info("全局异常:{}", e);
        return fail(SYSTEM_ERROR.getMessage());
    }
}
