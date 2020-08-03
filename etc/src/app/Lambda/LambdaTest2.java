package app.lambda;

// 두개의 숫자 더하기
public class LambdaTest2 {
    // 람다식 문법 (매개변수 목록)->{실행문}
    public static void exec(Compare com) {
        int k = 10;
        int m = 20;
        int value = com.add(k, m);
        System.out.println(value);
    }

    public static void main(String[] args) {
        exec((i, j) -> {
            return i + j;
        });
    }
}

interface Compare {
    public int add(int a, int b);
}