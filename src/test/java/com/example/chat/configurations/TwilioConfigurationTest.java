package com.example.chat.configurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwilioConfigurationTest {
    TwilioConfiguration twilioConfiguration = new TwilioConfiguration();

    @Test
    void getAccountSid() {
        twilioConfiguration.setAccountSid("id");
        assertEquals("id",twilioConfiguration.getAccountSid());
    }

    @Test
    void getAuthToken() {
        twilioConfiguration.setAuthToken("token");
        assertEquals("token",twilioConfiguration.getAuthToken());
    }

    @Test
    void getTrialNumber() {
        twilioConfiguration.setTrialNumber("1234");
        assertEquals("1234",twilioConfiguration.getTrialNumber());
    }

}