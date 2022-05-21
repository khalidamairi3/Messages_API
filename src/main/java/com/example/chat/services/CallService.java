package com.example.chat.services;

import com.example.chat.configurations.TwilioConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;

@Service
public class CallService {
    private final TwilioConfiguration twilioConfiguration;
    @Autowired
    public CallService(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    /**
     * function that takes phoneNum and make a call to it using twilio
     * @param phoneNum
     */
    public void makeCall(String phoneNum){
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
        Call call = Call.creator(
                        new com.twilio.type.PhoneNumber(phoneNum),
                        new com.twilio.type.PhoneNumber(twilioConfiguration.getTrialNumber()),
                        new com.twilio.type.Twiml("<Response><Say voice='alice'>Thanks for using telemedicine app. you are receiving this call because you have an appointment with one of our specialists. please wait until we connect you to the specialist</Say>" +
                                "<Play>http://com.twilio.music.classical.s3.amazonaws.com/oldDog_-_endless_goodbye_%28instr.%29.mp3</Play> </Response>"))
                .create();

        System.out.println(call.getAccountSid());

    }
}
