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
 * 2018/5/20      matteo                 Created
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HideLog {
    /**
     * 作用
     *
     * @return
     */
    String value() default "隐藏日志";
}
