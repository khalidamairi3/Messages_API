package com.example.chat.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageRequestTest {
    MessageRequest messageRequest =  new MessageRequest("1234","message");

    @Test
    void getPhoneNumber() {
        assertEquals("1234",messageRequest.getPhoneNumber());
    }

    @Test
    void getMessage() {
        assertEquals("message",messageRequest.getMessage());
    }

    @Test
    void testToString() {
        assertEquals("SmsRequest{phoneNumber=1234', message='message'}", messageRequest.toString());
    }
}