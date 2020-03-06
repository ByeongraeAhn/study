package com.example.demo.event02;

public class CustomSpringEvent02 {

    private int data;

    private Object source;

    public CustomSpringEvent02(Object source, int data){
       this.source = source;
       this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}