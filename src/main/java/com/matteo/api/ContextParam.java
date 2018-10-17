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
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ContextParam {

    String value();

    boolean required() default true;

}
