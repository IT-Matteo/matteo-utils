package com.matteo.mysql;

import java.util.UUID;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.mysql
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/8/15      matteo                 Created
 */
public class IdUtils {

    public static String Id() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
