package app.java8.interface_method.chap1;

public class DefaultFoo implements Foo {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    //default메서드에 대한 재정의도 가능하다
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }

    

    @Override
    public void printName() {

        System.out.println(this.name);
    }


    @Override
    public String getName() {
        return this.name;
    }
    
}