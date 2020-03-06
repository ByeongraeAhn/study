package com.example.demo;

import com.example.demo.event01.CustomSpringEvent01;
import com.example.demo.event02.CustomSpringEvent02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;

// 참고
// https://engkimbs.tistory.com/718
// https://www.baeldung.com/spring-events
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//event01 publish
		CustomSpringEvent01 customSpringEvent = new CustomSpringEvent01(this, "event01");
		applicationEventPublisher.publishEvent(customSpringEvent);
		
		//event02 publish
		applicationEventPublisher.publishEvent(new CustomSpringEvent02(this, 100));

		//event03 publish(ContextStartedEvent)
		((ConfigurableApplicationContext)applicationEventPublisher).start();



	}

}
