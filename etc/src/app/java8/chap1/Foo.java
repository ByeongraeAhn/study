package app.java8.chap1;

public class Foo {

    public static void main(String[] args) {

        int baseNumber = 10;

        // 익명 내부 클래스
        // RunSomthing runSomthing = new RunSomthing() {
        //     @Override
        //     public int doIt(int num) {
        //         return num + 10;

        //     }
        // };

        // 람다 표현
        RunSomthing runSomthing = (number) -> {
            //함수 밖에 있는 값을 참조하거나 변경하려고 하면 함수형 프로그래밍 의도와 맞지 않다.
            //return number + baseNumber; //퓨어한 함수라고 볼수 없다.
            //baseNumber++; //퓨어한 함수라고 볼수 없다.
            return number + 10;
        };

        // 출력(함수형은 같은 input이면 같은 결과를 보장한다.)
        System.out.println(runSomthing.doIt(1));

    }

}