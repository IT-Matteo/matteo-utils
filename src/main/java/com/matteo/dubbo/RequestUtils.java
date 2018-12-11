package com.matteo.dubbo;

import java.io.Serializable;
import java.util.UUID;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.so.skill.utils
 * 系统名           ：追踪错误的id
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/4/1      matteo                 Created
 */
public class RequestUtils implements Serializable {
    public static String SoSkillId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
