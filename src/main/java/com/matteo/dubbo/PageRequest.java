package com.matteo.dubbo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
 * 2018/4/1      matteo                 Created
 */
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class PageRequest extends BaseRequest {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
}
