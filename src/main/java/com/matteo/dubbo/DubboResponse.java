package com.matteo.dubbo;

import lombok.Data;

import java.io.Serializable;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.so.skill.utils
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/3/31      matteo                 Created
 */
@Data
public class DubboResponse<T> implements Serializable {
    private String status;
    private String error;
    private String msg;
    private T data;
}
