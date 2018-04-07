package com.matteo.dubbo;

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
public class Constants {
    public interface System {
        String OK = "1";
        String FAIL = "0";

        String SERVER_SUCCESS = "000000";
        String SERVER_SUCCESS_MSG = "服务正常!";

        String PARAMS_INVALID = "1000001";
        String PARAMS_INVALID_MSG = "参数无效!";

        String HAVA_MARK = "1000002";
        String HAVA_MARK_MSG = "你已经已经评分过了哦~~~~";

        String USER_HAVA_EXIST = "1000003";
        String USER_HAVA_EXIST_MSG = "用户名已存在";

        String USER_OR_PASSWORD_ERROR = "1000004";
        String USER_OR_PASSWORD_ERROR_MSG = "用户名或者密码错误";

        String USER_OLD_PASSWORD_EQUAL_NEW_ERROR = "1000005";
        String USER_OLD_PASSWORD_EQUAL_NEW_ERROR_MSG = "新密码不能与原来的相同";

        String HAVA_FOLLOW = "1000006";
        String HAVA_FOLLOW_MSG = "你已经关注了该博主了";
    }
}
