package com.cy.pro.utils;


import org.omg.CORBA.SystemException;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    /**
     * "596282182@qq.com"
     * "新员工入职通知"
     *
     * @param toAddress
     * @throws Exception
     */
    public static void senEmail(String toAddress, String subject, String content) throws Exception {
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.163.com");//发送邮件的smtp服务器类型
        pro.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(pro);
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("13242429815@163.com"));
        message.setRecipients(Message.RecipientType.TO, toAddress);
        message.setSubject(subject);
        message.setText(content);

        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.163.com", "13242429815@163.com", "cs0719");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
