package com.matteo.api;

import lombok.Data;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.so.skill.vo
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/4/1      matteo                 Created
 */
@Data
public class PageQuery {
    private Integer currentPage;
    private Integer pageSize;
}
