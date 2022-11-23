package com.prprv.shop.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 未確認の庭師
 */
@Service
public class MailService {
    @Resource
    private JavaMailSender sender;
    public void sendSimpleMail(String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发送者
        message.setFrom(from);
        // 接收者
        message.setTo(to);
        // 邮件主题
        message.setSubject(subject);
        // 邮件内容
        message.setText(text);
        sender.send(message);
    }

}
