package app.java8.functional.chap4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//메서드 레퍼런스
public class Foo {

    public static void main(String[] args) {

        UnaryOperator<String> hi = Greeting::hi; //스테틱 메서드 사용시
        System.out.println(hi.apply("anbr"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello; //인스턴스 메서드 사용시
        System.out.println(hello.apply("anbr"));

        Supplier<Greeting> newGreeting = Greeting::new; //생성자 사용시(아규먼트 없음)
        Greeting greeting1 = newGreeting.get(); //get을 해야 만들어진다

        Function<String, Greeting> newGreeting2 = Greeting::new;  //생성자 사용시(아규먼트 있음)
        Greeting greeting2 = newGreeting2.apply("anbr"); //apply를 해야 만들어진다.

        String[] names = {"a", "b", "C"};
        // Arrays.sort(names, new Comparator<String>(){
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return 0;
        //     }
        // });

        //Arrays.sort(names, (o1, o2) -> 0); //람다로 바꾸면 이와 같다.

        Arrays.sort(names, String::compareToIgnoreCase); //임의의 객체의 인스턴스 메서드를 참조

        
    }
    
}