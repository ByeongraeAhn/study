package app.Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Sample {

    public static void main(String[] args) {

        // 더하기
        System.out.println(sum((i, j) -> {return i + j;}, 3, 2));

        // 빼기
        System.out.println(sum((i, j) -> {return i - j;}, 3, 2));

        // 곱하기
        MyFunction myFunction = (i, j) -> {return i * j;};
        int result1 = myFunction.operate(3, 2);
        System.out.println(result1);

        //java.util.function 패키지
        //BiFunction
        //인자2개, 리턴 있음
        BiFunction<Integer, Integer, Integer> biFunction = (i, j) -> {return i * j;};
        Integer result2 = biFunction.apply(3, 2);
        System.out.println(result2);

        //Function
        //인자1개, 리턴 있음
        Function<String, Integer> function = str -> Integer.parseInt(str);
        Integer result3 = function.apply("10");
        System.out.println(result3);

        //Consumer
        //인자있음, 리턴 없음
        //Stream 인터페이스의 forEach 메서드는 void forEach(Consumer<? super T> action) 로 정의되어 있음
        String[] strArr = {"aaa", "ccc", "bbb"};
        Arrays.stream(strArr).sorted().forEach(str -> System.out.print(str));

        //Supplier
        //때문에 랜덤함수것을 쓰지 않는 이상 통상적으로 같은 결과를 리턴함
        Supplier<String> supplier = () -> "msg from supplier";
        String result4 = supplier.get();
        System.out.println(result4);

        //Operator
        //Function과 동일한 형태지만 타입변환 보다는 연산을 수행
        //인자와 리턴의 타입이 동일
        UnaryOperator<String> unaryOperator = str -> str + " add ++++++++++++";
        String result5 = unaryOperator.apply("-----------");
        System.out.println(result5);

        //Predicate
        //인자1개, boolean 타입의 리턴
        Predicate<String> predicate = str -> str.contains("aaa");
        boolean result6 = predicate.test("bbb"); // false 
        System.out.println(result6);

        //Comparator
        Comparator<String> c = (str1, str2) -> str1.compareTo(str2);
        int resul7 = c.compare("xxx", "yyy");  //-1
        System.out.println(resul7);


    }

    public static int sum(MyFunction myFunction, int a, int b) {
        return myFunction.operate(a, b);
    }

}

@FunctionalInterface
interface MyFunction {

    int operate(int a, int b);
}
