package com.matteo.handler.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Map;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.mac.box.macbox.util
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/10/17      matteo                 Created
 */
public class TokenUtils {

    public static String generateToken(Map<String, Object> claims) {
        byte[] secret = new byte[]{'m', 'a', 'c'};
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(DateUtils.addDays(new Date(), 1))
                .signWith(SignatureAlgorithm.HS512, secret) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
    }

    public static Claims getClaimsFromToken(String token) throws SignatureException {
        byte[] secret = new byte[]{'m', 'a', 'c'};
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
