package com.nhnent.edu.springboot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "dooray")
public class DoorayProperties {
    private String hookUrl;

    public String getHookUrl() {
        return hookUrl;
    }

    public void setHookUrl(String hookUrl) {
        this.hookUrl = hookUrl;
    }
}
