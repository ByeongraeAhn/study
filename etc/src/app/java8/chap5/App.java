package app.java8.chap5;

public class App {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("anbr");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
    
}