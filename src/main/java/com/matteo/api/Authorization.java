package com.matteo.api;

import java.lang.annotation.*;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.api
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/10/17      matteo                 Created
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorization {
    /**
     * 作用
     *
     * @return
     */
    String value() default "token 验证";
}
