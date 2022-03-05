package com.resolved.userservice.communication.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MailDto {
    private String sendFrom;
    private String sendTo;
    private String mailSubject;
    private String mailBody;
}
