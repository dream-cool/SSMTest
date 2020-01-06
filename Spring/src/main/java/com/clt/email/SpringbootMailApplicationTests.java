package com.clt.email;

import com.clt.pojo.Email;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import java.sql.Date;



public class SpringbootMailApplicationTests {



    @Autowired
    private TemplateEngine templateEngine;

    //
    /**
     *接收人
     */
    private static final String RECIPINET = "1769693979@qq.com";

    /**
     * 发送文本邮件
     */
    @Test
    public void sendSimpleMail() {
        MailUtil mailUtil = new MailUtil();
        Email email = new Email();
        email.setRecipient(RECIPINET);
        email.setSubject("SpringBootMail之这是一封文本的邮件");
        email.setContent("SpringBootMail发送一个简单格式的邮件，时间为："+ new Date(System.currentTimeMillis()));
//        + DateUtils.format(new Date())
        mailUtil.sendSimpleMail(email);
        System.out.println("发送成功");
    }



}