package com.resolved.userservice.communication.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Data
public class TwilioConfiguration {
    private String accountSid;
    private String authToken;
    private String trailNumber;
}
