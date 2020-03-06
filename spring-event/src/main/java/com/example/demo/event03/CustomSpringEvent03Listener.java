package com.example.demo.event03;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 스프링 기본이벤트
// ContextRefreshedEvent : ApplicationContext를 초기화 했거나 리프래시 했을 때 발생.
// ContextStartedEvent : ApplicationContext를 start()하여 라이프사이클 빈들이 시작 신호를 받은 시점에 발생
// ContextStoppedEvent : ApplicationContext를 stop()하여 라이프사이클 빈들이 정지 신호를 받은 시점에 발생
// ContextClosedEvent : ApplicationContext를 close() 하여 싱글턴 빈들이 소멸되는 시점에 발생.
// RequestHandledEvent : HTTP 요청을 처리했을 때 발생.

@Component
public class CustomSpringEvent03Listener {
    @EventListener
    public void handle(ContextStartedEvent event) {
        System.out.println("Received spring context started event");
    }
}