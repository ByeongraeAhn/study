package com.example.apiserver2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);


    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
    }
}
