package com.clt.email;

import com.clt.pojo.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

    @Value("${spring.mail.username}")
    private String MAIL_SENDER; //邮件发送者



    private Logger logger = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 发送文本邮件
     *
     * @param Email
     */
    public  void sendSimpleMail(Email Email) {
        try {
            JavaMailSender javaMailSender = new JavaMailSenderImpl();
            SimpleMailMessage mailMessage= new SimpleMailMessage();
            mailMessage.setFrom(MAIL_SENDER);
            mailMessage.setTo(Email.getRecipient());
            mailMessage.setSubject(Email.getSubject());
            mailMessage.setText(Email.getContent());
            //mailMessage.copyTo(copyTo);
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            logger.error("邮件发送失败", e.getMessage());
        }
    }
}
