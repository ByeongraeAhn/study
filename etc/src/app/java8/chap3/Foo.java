package app.java8.chap3;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {

    public static void main(String[] args) {

        Foo foo = new Foo();
        foo.run();
        
    }

    //변수 캡처 정리
    private void run() {

        //로컬 변수
        int baseNumber = 10;
        

        //1. 로컬 클래스
        //섀도잉 된다
        class LocalClass {
            void printBaseNubmer() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        //2. 익명 클래스
        //섀도잉 된다
        Consumer<Integer> integerConsumer = new Consumer<Integer>(){
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        //3. 람다
        //섀도잉 되지 않는다.
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);
        printInt.accept(10);

        //baseNumber++;
    } 
}