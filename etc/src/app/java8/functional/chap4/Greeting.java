package app.java8.functional.chap4;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String helloMethod(String name) {
        return "hello " + name;
    }

    public static String hiMethod(String name) {
        return "hi " + name;
    }

}