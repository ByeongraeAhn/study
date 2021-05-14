package app.java8.functional.chap2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {

    public static void main(String[] args) {

        // Plus10 plus10 = new Plus10();
        // System.out.println(plus10.apply(1));

        //위처럼 클래스를 안쓰고 직접 구현 가능
        //Function<Integer, Integer> plus10 = (num) -> {return num + 10;};
        Function<Integer, Integer> plus10 = (num) -> num + 10; //return 안쓸수 있음
        System.out.println(plus10.apply(1));

        //조합도 가능하다.
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        
        // 해당 값을 곱하기2를 먼저하고 10을 더한다.
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(1)); //12

        // 해당 값을 10을 더하고 곱하기2를 한다.
        Function<Integer, Integer> Plus10Andmultiply2 = plus10.andThen(multiply2);
        System.out.println(Plus10Andmultiply2.apply(1)); //22

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 15;
        get10.get();

        Predicate<String> startsWithAnbr = (s) -> s.startsWith("Anbr");
        startsWithAnbr.test("AnbrTEST");

        UnaryOperator<Integer> plus10Operator = (num) -> num + 10; //return 안쓸수 있음
        System.out.println(plus10.apply(1));

    }

}