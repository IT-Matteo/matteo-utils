package com.matteo.dubbo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
@Data
public class PaginationSupport<T> implements Serializable {
    private List<T> list;
    private Integer totalCount;
    private Integer pageSize;
    private Integer pageCount;

    public PaginationSupport(List<T> list, Integer totalCount, Integer pageSize) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
    }

}
