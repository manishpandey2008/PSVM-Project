package com.resolved.userservice.communication.sms;

import com.resolved.userservice.communication.sms.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SmsService {
    private final TwilioConfiguration twilioConfiguration;

    public void send(SmsDto sms) {
       try{
           Message message = Message.creator(
                           new PhoneNumber(sms.getSendTo()),
                           new PhoneNumber(twilioConfiguration.getTrailNumber()),
                           sms.getMessage())
                   .create();
           log.info("Sms sent successfully to {}",sms.getSendTo());
       }catch(Exception ex){
           log.info("Error: Sms not sent due to : {}",ex.getMessage());
       }
    }
}
