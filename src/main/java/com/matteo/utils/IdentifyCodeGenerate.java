package com.matteo.utils;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.utils
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/10/18      matteo                 Created
 */
public class IdentifyCodeGenerate {

    private static final char[] digit = new char[]{'2', '3', '4', '5', '6', '7', '8', '9'};


    private static final char[] alpha = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * 生成邀请码（邀请码规则：4位数字+2位字母随机排列，不区分大小写，为避免误看，排除：1、l、0、o、i 例如：21x56w）
     *
     * @return
     */
    public static String getCode() {
        Integer digitNum = 0; //数字计数器
        Integer alphNum = 0; // 字母计数器

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            Integer type = getRandom(0, 1); //0  数字;    1 字母：

            if (digitNum == 2) {
                type = 1;
            }

            if (alphNum == 2) {
                type = 0;
            }

            if (type == 0) {
                digitNum++;
                builder.append(digit[getRandom(0, 7)]);
            } else {
                alphNum++;
                builder.append(alpha[getRandom(0, 22)]);
            }
        }

        return builder.toString();
    }

    /**
     * 在min和max的区间取得随机数(包括min和max)
     *
     * @param min
     * @param max
     * @return
     */
    public static Integer getRandom(Integer min, Integer max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }


}
