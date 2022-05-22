package com.example.chat.services;

import com.example.chat.configurations.TwilioConfiguration;
import com.example.chat.dto.MessageRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.*;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    /***
     * sendSms method that takes message request as an argument and use its information to send the message to the recipient number
     * @param smsRequest
     */
    @Override
    public void sendSms(MessageRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            LOGGER.error("Invalid phone number: " + smsRequest.getPhoneNumber() );
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
            );
        }

    }

    /***
     * function to validate that the recipient phone number is valid and has 10 digits
     * @param phoneNumber
     * @return
     */
    public boolean isPhoneNumberValid(String phoneNumber) {
        Pattern ptrn = Pattern.compile("^\\d{10}$");
        Matcher match = ptrn.matcher(phoneNumber);
        return (match.find() && match.group().equals(phoneNumber));
    }
}