package com.example.chat.services;

import com.example.chat.dto.MessageRequest;

/**
 * Sms Sender interface to define actions
 */
public interface SmsSender {
    void sendSms(MessageRequest messageRequest);
}
