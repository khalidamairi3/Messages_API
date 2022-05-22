package com.example.chat.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Class to represent the form of the request body
 */
public class MessageRequest {

    private  String phoneNumber; // destination


    private String message;

    public MessageRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber=" +  phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
