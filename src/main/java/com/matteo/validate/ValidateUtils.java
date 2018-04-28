package com.matteo.validate;

import java.util.Random;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.validate
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/4/25      matteo                 Created
 */
public class ValidateUtils {
    /**
     * 随机生成四位的验证码
     *
     * @return
     */
    public static String getValidateCode() {
        Random d = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String num = String.valueOf(d.nextInt(10));
            str.append(num);
        }
        return str.toString();
    }
}
