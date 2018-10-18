package com.matteo.utils;

import com.matteo.vo.MailType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.Snow.mail
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/9/13      matteo                 Created
 */
public class MailSender {

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    /**
     * @param type           发送邮件邮箱类型
     * @param senderAccount  发送方
     * @param senderPassword 密码
     * @param receiveAccount 接受方
     * @param subject        主题
     * @param content        内容
     * @throws Exception
     * @Param nick 自定义昵称
     */
    public static void sendMail(MailType type, String senderAccount, String senderPassword, String receiveAccount, String nick, String subject, String content) throws Exception {
        // 1.获取session
        Session session = getSession(type);
        //2、创建邮件的实例对象
        Message msg = getMimeMessage(session, senderAccount, receiveAccount, nick, subject, content);
        //4、根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();
        //设置发件人的账户名和密码
        transport.connect(senderAccount, senderPassword);
        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(msg, msg.getAllRecipients());
        //5、关闭邮件连接
        transport.close();
    }

    private static Session getSession(MailType type) throws GeneralSecurityException {
        //1、连接邮件服务器的参数配置
        Properties props = new Properties();
        if (type.equals(MailType.MAIL_163)) {
            //设置用户的认证方式
            props.setProperty("mail.smtp.auth", "true");
            //设置传输协议
            props.setProperty("mail.transport.protocol", "smtp");
            //设置发件人的SMTP服务器地址
            props.setProperty("mail.smtp.host", "smtp.163.com");
        }

        if (type.equals(MailType.QQ)) {
            // 设置邮件服务器
            props.setProperty("mail.host", "smtp.qq.com");
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
        }

        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);
        //设置调试信息在控制台打印出来
        session.setDebug(true);
        return session;
    }

    /**
     * 获得创建一封邮件的实例对象
     *
     * @param session
     * @return
     */
    private static MimeMessage getMimeMessage(Session session, String senderAddress, String recipientAddress, String nick, String subject, String content) throws Exception {
        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        try {
            nick = javax.mail.internet.MimeUtility.encodeText(nick);
        } catch (UnsupportedEncodingException e) {
            logger.info("设置自定义发件人昵称出错!");
        }
        msg.setFrom(new InternetAddress(nick + " <" + senderAddress + ">"));

        msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientAddress));
        //设置邮件主题
        msg.setSubject(subject, "UTF-8");
        //设置邮件正文
        msg.setText(content);
        return msg;
    }

}
