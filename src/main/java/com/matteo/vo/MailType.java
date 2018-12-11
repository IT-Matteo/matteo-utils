package com.matteo.vo;

import java.util.Objects;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.Snow.vo
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/9/13      matteo                 Created
 */
public enum MailType {

    MAIL_163(0, "163邮箱"),
    QQ(1, "QQ邮箱");

    private Integer type;
    private String desc;

    MailType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static MailType getMailType(Integer type) {
        for (MailType mailType : MailType.values()) {
            if (Objects.equals(mailType.getType(), type)) {
                return mailType;
            }
        }
        return null;
    }
}
