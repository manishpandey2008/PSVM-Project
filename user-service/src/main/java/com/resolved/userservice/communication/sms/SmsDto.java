package com.resolved.userservice.communication.sms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsDto {
    private String sendTo;
    private String message;
}
