package app.Rambda;

import java.util.Arrays;
import java.util.List;

public class Sample {

    public static void main(String[] args) {

        // 더하기
        System.out.println(sum((i, j) -> {return i + j;}, 3, 2));

        // 빼기
        System.out.println(sum((i, j) -> {return i - j;}, 3, 2));

        // 곱하기
        Functional functional = (i, j) -> {return i * j;};
        System.out.println(functional.operate(3, 2));
    }

    public static int sum(Functional functional, int a, int b) {
        return functional.operate(a, b);
    }

}

@FunctionalInterface
interface Functional {

    int operate(int a, int b);
}
