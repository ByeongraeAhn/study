package com.example.demo.event01;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent01 extends ApplicationEvent {
    private String message;
 
    public CustomSpringEvent01(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
