package com.example.chat.services;

import com.example.chat.configurations.TwilioConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwilioSmsSenderTest {

    private TwilioSmsSender twilioSmsSender;
    private TwilioConfiguration twilioConfiguration;

    @BeforeEach
    public void initBeforeTest(){
        twilioSmsSender = new TwilioSmsSender(twilioConfiguration);
    }

    @Test
    public void isPhoneNumberValid(){
        assertTrue(twilioSmsSender.isPhoneNumberValid("5875684533"));
        assertFalse(twilioSmsSender.isPhoneNumberValid("123456"));
    }

}