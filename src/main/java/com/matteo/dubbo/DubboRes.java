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
public class DubboRes {

    public static <T> DubboResponse<T> ok(T data) {
        DubboResponse<T> res = new DubboResponse<>();
        res.setStatus(Constants.System.OK);
        res.setError(Constants.System.SERVER_SUCCESS);
        res.setMsg(Constants.System.SERVER_SUCCESS_MSG);
        res.setData(data);
        return res;
    }

    public static <T> DubboResponse<T> fail(String code, String msg) {
        DubboResponse<T> res = new DubboResponse<>();
        res.setStatus(Constants.System.OK);
        res.setError(code);
        res.setMsg(msg);
        return res;
    }

    public static boolean isOk(DubboResponse response) {
        return response != null &&
                Constants.System.OK.equals(response.getStatus()) &&
                Constants.System.SERVER_SUCCESS.equals(response.getError());
    }

}
