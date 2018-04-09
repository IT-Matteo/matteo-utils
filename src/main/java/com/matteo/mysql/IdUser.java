package com.matteo.mysql;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
 * 2018/4/8      matteo                 Created
 */
@Getter
public enum IdUser {
    USER(1L, 1L),
    VIDEO(2L, 2L),
    ADMIN(3L, 3L);
    private long workerId;
    private long datacenterId;

    IdUser(long workerId, long datacenterId) {
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

}
