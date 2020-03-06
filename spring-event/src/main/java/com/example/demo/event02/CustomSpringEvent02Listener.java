package com.example.demo.event02;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//Spring 4.2부터는 이벤트 리스너가 ApplicationListener 인터페이스를 구현하는 Bean 일 필요는 없다. 
//@EventListener 주석을 통해 관리되는 Bean의 모든 공개 메소드에 등록 할 수 있다.
@Component
public class CustomSpringEvent02Listener {
    @EventListener
    public void handle(CustomSpringEvent02 event) {
        System.out.println("Received spring custom event - " + event.getData());
    }
}