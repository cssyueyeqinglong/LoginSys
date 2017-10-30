package com.cy.pro;

import com.cy.pro.utils.MailUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class JDBCTest {

    @Test
    public void jdbcTest(){
        try {
//            MailUtils.senEmail("596282182@qq.com","欢迎您","欢迎您");

            ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");

            SimpleMailMessage message = (SimpleMailMessage) ac.getBean("mailMessage");//加载简单邮件对象
            JavaMailSender sender = (JavaMailSender) ac.getBean("mailSender");       //得到邮件的发送对象，专门用于邮件发送

            //设置简单邮件对象的属性
            message.setSubject("spring与javamail的测试");//主题
            message.setText("hello,spring and javamail ");//内容
            message.setTo("596282182@qq.com");//收件箱


            //发送邮件
            sender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
