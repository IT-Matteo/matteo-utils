package com.matteo.api;

import com.matteo.dubbo.Constants;
import com.matteo.dubbo.DubboResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;
import static com.matteo.api.ErrorCode.ApiError.NO_RESPONSE_STATUS_ERROR;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.so.skill.utils
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/4/1      matteo                 Created
 */
public class DubboDataUtils<T> {

    public static boolean isSuccessfulResponse(DubboResponse response) {
        return response != null &&
                Constants.System.OK.equals(response.getStatus()) &&
                Constants.System.SERVER_SUCCESS.equals(response.getError());
    }

    public static <T> T data(DubboResponse<T> response) throws ErrorException {
        return data(response, t -> t);
    }

    public static <T, R> R data(DubboResponse<T> response, Function<T, R> function) throws ErrorException {
        if (response == null) {
            throw new ErrorException(NO_RESPONSE_STATUS_ERROR);
        }
        if (StringUtils.isBlank(response.getStatus())) {
            throw new ErrorException(NO_RESPONSE_STATUS_ERROR);
        }
        if (StringUtils.isBlank(response.getError())) {
            throw new ErrorException(NO_RESPONSE_STATUS_ERROR);
        }
        if (isSuccessfulResponse(response)) {
            return function == null ? null : function.apply(response.getData());
        }
        throw new ErrorException(new ErrorCode(response.getError(), response.getMsg()));
    }
}

