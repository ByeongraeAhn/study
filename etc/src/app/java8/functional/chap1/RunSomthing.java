package app.java8.functional.chap1;

@FunctionalInterface
public interface RunSomthing {

    int doIt(int number);

    //void doAgain(); // @FunctionalInterface에 의해 에러


    //interface의 static 메소드 
    //interface에서 메소드 구현이 가능하다.
    //반드시 클래스 명으로 메소드를 호출해야 한다.
    //재정의 불가능!
    static void printName() {
        System.out.println("안"); 
    }


    //interface의 default 메소드
    //interface에서도 메소드 구현이 가능하다.
    //참조 변수로 함수를 호출할 수 있다.
    //implements한 클래스에서 재정의가 가능하다.
    default void printAge() {
        System.out.println("10");
    }
    
}