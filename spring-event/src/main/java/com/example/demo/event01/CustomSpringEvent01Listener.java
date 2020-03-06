package com.example.demo.event01;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//ApplicationListener 인터페이스를 구현하는 방식. 
@Component
public class CustomSpringEvent01Listener implements ApplicationListener<CustomSpringEvent01> {
    @Override
    public void onApplicationEvent(CustomSpringEvent01 event) {
        System.out.println("Received spring custom event - " + event.getMessage());
    }
}