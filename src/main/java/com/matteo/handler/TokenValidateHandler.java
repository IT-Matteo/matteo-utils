package com.matteo.handler;

import com.matteo.api.Authorization;
import com.matteo.api.ErrorCode;
import com.matteo.api.ErrorException;
import com.matteo.handler.utils.RedisUtil;
import com.matteo.handler.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

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
public class TokenValidateHandler extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(TokenValidateHandler.class);

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            log.info("token begin validate!");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(Authorization.class)) {
                String token = request.getHeader("Authorization");
                log.info("login token:{}", token);

                if (null == token) {
                    throw new ErrorException(ErrorCode.ApiError.TOKEN_NOT_FILL);
                }

                if (!token.startsWith("Bearer ")) {
                    throw new ErrorException(ErrorCode.ApiError.TOKEN_HAVE_EXPIRE);
                }

                try {
                    Claims claims = TokenUtils.getClaimsFromToken(token.replace("Bearer ", ""));
                    String userId = claims.get("userId").toString();

                    String redisToken = (String) redisUtil.get("token_" + userId);
                    if (null == redisToken) {
                        throw new ErrorException(ErrorCode.ApiError.TOKEN_HAVE_EXPIRE);
                    }

                    return true;
                } catch (SignatureException e) {
                    throw new ErrorException(ErrorCode.ApiError.TOKEN_HAVE_EXPIRE);
                }

            }
        }
        return true;
    }
}
