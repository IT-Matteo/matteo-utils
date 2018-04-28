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
        String HAVA_MARK_MSG = "你已经已经评分过了哦!";

        String USER_HAVA_EXIST = "1000003";
        String USER_HAVA_EXIST_MSG = "用户名已存在!";

        String MAIL_HAVA_EXIST = "1000004";
        String MAIL_HAVA_EXIST_MSG = "该邮箱已被注册!";


        String USER_OR_PASSWORD_ERROR = "1000005";
        String USER_OR_PASSWORD_ERROR_MSG = "用户名或者密码错误!";

        String USER_OLD_PASSWORD_EQUAL_NEW_ERROR = "1000006";
        String USER_OLD_PASSWORD_EQUAL_NEW_ERROR_MSG = "新密码不能与原来的相同!";

        String HAVA_FOLLOW = "1000007";
        String HAVA_FOLLOW_MSG = "你已经关注了该博主了!";

        String SCORE_ADD_ERROR = "1000007";
        String SCORE_ADD_ERROR_MSG = "用户积分更新失败~";

        String SCORE_NOT_ENOUGH = "1000009";
        String SCORE_NOT_ENOUGH_MSG = "你的积分不够咯,快去评论赚取积分吧!";

        String ES_SEARCH_VIDEO_ERROR = "1000010";
        String ES_SEARCH_VIDEO_ERROR_MSG = "ES搜索视频失败";

        String ES_ADD_VIDEO_ERROR = "1000011";
        String ES_ADD_VIDEO_ERROR_MSG = "ES添加视频失败";

        String VALUE_NOT_FIND = "1000012";
        String VALUE_NOT_FIND_MSG = "没有找到需要的资源!";

        String USER_STATUS_WARN = "1000013";
        String USER_STATUS_WARN_MSG = "用户状态异常";


        String MAIL_HAVA_NOT_EXIST = "1000014";
        String MAIL_HAVA_EXIST_NOT_MSG = "该邮箱未注册!";

        String VALIDATE_CODE_ERROR = "1000015";
        String VALIDATE_CODE_ERROR_MSG = "验证码验证失败!";

        String VALIDATE_CODE_SEND_MORE_ERROR = "1000016";
        String VALIDATE_CODE_SEND_MORE_ERROR_MSG = "当日验证码发送已达上限!";
    }
}
