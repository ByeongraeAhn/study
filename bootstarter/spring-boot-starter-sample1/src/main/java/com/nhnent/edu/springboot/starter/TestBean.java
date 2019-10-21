package com.nhnent.edu.springboot.starter;



public class TestBean {

    private String hockUrl;

    public TestBean(String hockUrl) {
        this.hockUrl = hockUrl;
    }
    
    public void logApi() {
        System.out.println("★★★★★★★★★★★★★★★★★★★★ " + hockUrl);
    }
}
