package com.example.chat.services;

import com.example.chat.dto.MessageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/***
 * SMS service class to perform sms messaging functionality
 */
@Service
public class SMSService {

    private SmsSender smsSender;

    @Autowired
    public  SMSService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(MessageRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
