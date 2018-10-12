package com.matteo.dubbo;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.dubbo
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/10/12      matteo                 Created
 */
public class BizException extends RuntimeException {

    /**
     * UID
     */
    private static final long serialVersionUID = 7341934955068468957L;

    public BizException(String message)  {
        super(message);
    }

    public BizException(Throwable e) {
        super(e);
    }

    public BizException(String message, Throwable e) {
        super(message, e);
    }

}
