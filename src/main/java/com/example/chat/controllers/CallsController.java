package com.example.chat.controllers;

import com.example.chat.services.CallService;
import com.example.chat.services.TwilioSmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calls")
public class CallsController {
    @Autowired
    private CallService callService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CallsController.class);
    /**
     *
     * @param phoneNum
     * @return A method to receive a call request and execute the call function
     */
    @PostMapping
    public ResponseEntity call(@RequestBody String phoneNum){
        try {
            callService.makeCall(phoneNum);
            LOGGER.info("call success :" + phoneNum);
            return ResponseEntity.accepted().build();
        }catch (Exception ex){
            ex.printStackTrace();
            LOGGER.error("call failed : " + phoneNum);
            return ResponseEntity.badRequest().build();
        }

    }
}
