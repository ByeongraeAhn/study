package com.example.apiserver1.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    StringRedisTemplate template;


    @RequestMapping("/")
    public String index() throws Exception {


        System.out.println("메세지 보냄");
        try {
            template.convertAndSend("chat", "Hello from Redis!");
        } catch (Exception e) {
            System.out.println("서버 오프");
        }

        return "Greetings from Spring Boot!";
    }

}