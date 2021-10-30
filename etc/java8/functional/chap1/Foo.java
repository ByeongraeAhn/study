package java8.functional.chap1;

public class Foo {

    public static void main(String[] args) {

        int baseNumber = 1;

        // 익명 내부 클래스
        // 인터페이스의 추상메서드를 익명 내부 클래스로 구현한다.
        // RunSomthing runSomthing = new RunSomthing() {
        //     @Override
        //     public int doIt(int num) {
        //         return num + 10;

        //     }
        // };


        // 람다 표현
        RunSomthing runSomthing = (number) -> {
            //자바를 1급 객체로 사용 가능(함수를 변수에 할당할 수 있고, 인자로 넘길 수 있으며, 리턴할 수 있다.)
            //함수형 프로그래밍 : 입력값이 동일한 경우 결과가 같아야 한다.(외부에 종속 X)
            //함수 밖에 있는 값을 참조하거나 변경하려고 하면 함수형 프로그래밍 의도와 맞지 않다.
            //baseNumber++; //퓨어한 함수라고 볼수 없다.
            //return number + baseNumber; //퓨어한 함수라고 볼수 없다.
            return number + 10;
        };
        

        // 출력(함수형은 같은 input이면 같은 결과를 보장한다.)
        System.out.println(runSomthing.doIt(1));

    }

}