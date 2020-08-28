package app.java8.chap5;

/**
 * Foo
 */
public interface Foo {

    void printName();


    //뒤에 추가된 메서드
    //default메서드를 통해 기존의 구현체에 컴파일 에러를 발생시키지 않는다.
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    //Object가 제공하는 기능(equals, hashCode)는 기본 메소드를 제공할 수 없다. 구현체가 재정의 해야한다.
    // default boolean equals() {
    // }

    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();
}