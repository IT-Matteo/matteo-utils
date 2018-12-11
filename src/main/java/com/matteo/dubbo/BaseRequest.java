package com.matteo.dubbo;

import lombok.Data;

import javax.validation.constraints.NotNull;
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
public class BaseRequest implements Serializable {
    @NotNull(message = "requestId不能为空")
    private String requestId;
}
