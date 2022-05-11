package com.example.chat.controllers;


import com.example.chat.dto.MessageRequest;
import com.example.chat.services.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessagingController {
    private final SMSService service;

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
            return ResponseEntity.accepted().build();
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
}
