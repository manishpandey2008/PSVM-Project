package com.resolved.userservice.communication.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMailToUser(MailDto mailDto){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(mailDto.getSendFrom());
        message.setTo(mailDto.getSendTo());
        message.setSubject(mailDto.getMailSubject());
        message.setText(mailDto.getMailBody());
//        message.setCc("balmukundpandey20oct1997@gmail.com");
        try{
            javaMailSender.send(message);
            log.info("Mail sent from "+mailDto.getSendFrom()+" to"+mailDto.getSendTo()+"........................");
        }catch(Exception ex){
            log.info("Error : Mail not sent due to : {}",ex.getMessage());
        }
    }
}
