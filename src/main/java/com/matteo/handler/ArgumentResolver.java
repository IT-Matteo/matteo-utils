package com.matteo.handler;

import com.matteo.api.ErrorCode;
import com.matteo.api.ErrorException;
import com.matteo.api.FinalUserInfo;
import com.matteo.handler.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.mac.box.macbox.handler
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/10/17      matteo                 Created
 */
@Component
public class ArgumentResolver implements HandlerMethodArgumentResolver {

    private static Logger log = LoggerFactory.getLogger(ArgumentResolver.class);

    /**
     * 用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument。
     *
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(FinalUserInfo.class);
    }

    /**
     * 真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象。
     *
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Nullable
    @Override
    public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
        log.info("begin HandlerMethodArgumentResolver");
        String token = nativeWebRequest.getHeader("Authorization");
        if (null == token) {
            throw new ErrorException(ErrorCode.ApiError.TOKEN_NOT_FILL);
        }
        Claims claims = TokenUtils.getClaimsFromToken(token.replace("Bearer ", ""));
        String userId = claims.get("userId").toString();
        return new FinalUserInfo(Long.valueOf(userId));
    }
}
