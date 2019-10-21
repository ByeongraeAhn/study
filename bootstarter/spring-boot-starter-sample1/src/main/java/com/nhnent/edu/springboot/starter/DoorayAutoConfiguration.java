package com.nhnent.edu.springboot.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * TODO (1)
 * 1) DoorayHookSender.class 가 Classpath 에 존재할때,
 * 2) dooray.hook-url 속성이 정의되어 있을때,
 * 동작하도록 설정 하세요.
 */
@Configuration
//@ConditionalOnClass(DoorayHookSender.class) //클래스패스에 잡혀있으면...
@ConditionalOnProperty("dooray.hook-url")
@EnableConfigurationProperties(DoorayProperties.class)
public class DoorayAutoConfiguration {

    @Autowired
    private DoorayProperties doorayProperties;

    /**
     * TODO (2)
     * RestTemplate type의 빈이 선언되어 있지 않으면 RestTemplate Bean을 생성하도록
     * @ConditionalOnMissingBean 을 이용해서 코드를 작성하세요.
     */
    @ConditionalOnMissingBean(RestTemplate.class)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    /**
     * TODO (3)
     * DoorayHookSender Bean 이 생성되도록 코드를 작성해 주세요.
     */
    @Bean
    public TestBean doorayHookSender(RestTemplate restTemplate) {
        return new TestBean(doorayProperties.getHookUrl());
    }


}
