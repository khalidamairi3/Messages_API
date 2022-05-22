package com.example.chat.controllers;


import com.example.chat.dto.MessageRequest;
import com.example.chat.services.CallService;
import com.example.chat.services.SMSService;
import com.example.chat.services.TwilioSmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class MessagingController {
    private final SMSService service;
    @Autowired
    private CallService callService;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingController.class);
    @Autowired
    public MessagingController(SMSService service) {
        this.service = service;
    }

    /***
     * Send message function to receive and handle message requests
     * @param messageRequest
     * @return
     */
    @PostMapping
    public ResponseEntity sendMessage(@RequestBody MessageRequest messageRequest){
        try {
            service.sendSms(messageRequest);
            LOGGER.info("sms sent successfully");
            return ResponseEntity.accepted().build();
        }catch (Exception ex){
            ex.printStackTrace();
            LOGGER.error("sms failed");
            return ResponseEntity.badRequest().build();
        }

    }

}
